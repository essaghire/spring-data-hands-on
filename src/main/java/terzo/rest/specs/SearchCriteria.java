package terzo.rest.specs;

import terzo.rest.specs.EmployeeSpecification;

public class SearchCriteria {

    private String key;
    private EmployeeSpecification.SearchOperation operation;
    private Object value;

    public SearchCriteria(String key, EmployeeSpecification.SearchOperation operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }


    public Object getValue() {
        return value;
    }

    public EmployeeSpecification.SearchOperation getOperation() {
        return operation;
    }

    public String getKey() {
        return key;
    }
}
