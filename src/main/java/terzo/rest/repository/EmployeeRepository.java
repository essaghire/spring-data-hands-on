package terzo.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import terzo.rest.model.Employee;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(@Param("name") String name);

    @Override
    Optional<Employee> findById(Long aLong);


}
