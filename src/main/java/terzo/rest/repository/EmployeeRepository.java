package terzo.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import terzo.rest.model.Department;
import terzo.rest.model.Employee;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.NamedQuery;

@RepositoryRestResource(collectionResourceRel = "employee", path = "employees")
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

    List<Employee> findByName(@Param("name") String name);

    List<Employee> findByDepartment(@Param("department") Department department);

    List<Employee> findBySalary(@Param("salary") long salary);

    List<Employee> findByManagerId(@Param("manager") Employee manger);

}
