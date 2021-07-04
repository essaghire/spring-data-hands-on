package terzo.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import terzo.rest.model.Department;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "department", path = "departments")
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByName(@Param("name") String name);
}
