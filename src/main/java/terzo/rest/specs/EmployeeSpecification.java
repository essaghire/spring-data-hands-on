package terzo.rest.specs;

import org.springframework.data.jpa.domain.Specification;
import terzo.rest.model.Employee;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EmployeeSpecification implements Specification<Employee> {


    private SearchCriteria criteria;

    public EmployeeSpecification(SearchCriteria searchCriteria) {
        this.criteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(
            Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        switch (criteria.getOperation()) {
            case EQUALITY:
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            case NEGATION:
                return builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
            case GREATER_THAN:
                return builder.greaterThan(root.<String> get(
                        criteria.getKey()), criteria.getValue().toString());
            case LESS_THAN:
                return builder.lessThan(root.<String> get(
                        criteria.getKey()), criteria.getValue().toString());
            case LIKE:
                return builder.like(root.<String> get(
                        criteria.getKey()), criteria.getValue().toString());
            case STARTS_WITH:
                return builder.like(root.<String> get(criteria.getKey()), criteria.getValue() + "%");
            case ENDS_WITH:
                return builder.like(root.<String> get(criteria.getKey()), "%" + criteria.getValue());
            case CONTAINS:
                return builder.like(root.<String> get(
                        criteria.getKey()), "%" + criteria.getValue() + "%");
            default:
                return null;
        }
    }
    public enum SearchOperation {
        EQUALITY, NEGATION, GREATER_THAN, LESS_THAN, LIKE, STARTS_WITH, ENDS_WITH, CONTAINS;

        public static final String[] SIMPLE_OPERATION_SET = { ":", "!", ">", "<", "~" };

        public static SearchOperation getSimpleOperation(char input) {
            switch (input) {
                case ':':
                    return EQUALITY;
                case '!':
                    return NEGATION;
                case '>':
                    return GREATER_THAN;
                case '<':
                    return LESS_THAN;
                case '~':
                    return LIKE;
                default:
                    return null;
            }
        }
    }
}
