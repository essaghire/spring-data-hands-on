package specs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import terzo.rest.AppConfig;
import terzo.rest.model.Department;
import terzo.rest.model.Designation;
import terzo.rest.model.Employee;
import terzo.rest.repository.DepartmentRepository;
import terzo.rest.repository.EmployeeRepository;
import terzo.rest.specs.EmployeeSpecification;
import terzo.rest.specs.SearchCriteria;

import java.util.List;
import java.util.Optional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
public class JPASpecificationsTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    private Employee employee;
    private Employee manager;
    Department finance;
    Department research;


    @Before
    public void init() {
        finance = new Department();
        finance.setName("finance");
        departmentRepository.save(finance);

        research = new Department();
        research.setName("Research");
        departmentRepository.save(research);

        manager = new Employee();
        manager.setName("Essaid");
        manager.setSalary(100000);
        manager.setDepartment(finance);
        manager.setDesignation(Designation.MANAGER);
        employeeRepository.save(manager);

        employee = new Employee();
        employee.setName("Jones");
        employee.setSalary(200000);
        employee.setManager(manager);
        employee.setDepartment(research);
        employee.setDesignation(Designation.ARCHITECT);
        employeeRepository.save(employee);

        employee = new Employee();
        employee.setName("Tom");
        employee.setSalary(9000);
        employee.setManager(manager);
        employee.setDepartment(finance);
        employee.setDesignation(Designation.ARCHITECT);
        employeeRepository.save(employee);

        employee = new Employee();
        employee.setName("Rebeca");
        employee.setSalary(9999);
        employee.setManager(manager);
        employee.setDepartment(finance);
        employee.setDesignation(Designation.ASSOCIATE);
        employeeRepository.save(employee);
    }

    @Test
    public void Problem1_byId_thenEssaid() {
        SearchCriteria criteria = new SearchCriteria("id",
                EmployeeSpecification.SearchOperation.EQUALITY, manager.getId());
        EmployeeSpecification spec =
                new EmployeeSpecification(criteria);

        Optional<Employee> results = employeeRepository.findOne(spec);

        Assert.assertEquals(results.get(), manager);
    }

    @Test
    public void Problem1_bySalaryGT10k_then2() {
        SearchCriteria criteria = new SearchCriteria("salary",
                EmployeeSpecification.SearchOperation.GREATER_THAN, 10_000);
        EmployeeSpecification spec = new EmployeeSpecification(criteria);

        List<Employee> results = employeeRepository.findAll(spec, Sort.by("name").ascending());

        Assert.assertEquals(2, results.size());
        Assert.assertEquals(manager, results.get(0));
    }

    @Test
    public void Problem1_bySalaryGT10k_finance_then2() {
        SearchCriteria salaryGt10K = new SearchCriteria("salary",
                EmployeeSpecification.SearchOperation.GREATER_THAN, 10_000);
        SearchCriteria inFinance = new SearchCriteria("department",
                EmployeeSpecification.SearchOperation.EQUALITY, finance);

        EmployeeSpecification spec = new EmployeeSpecification(salaryGt10K);
        EmployeeSpecification finance = new EmployeeSpecification(inFinance);

        List<Employee> results = employeeRepository.findAll(spec.and(finance), Sort.by("salary").descending());

        Assert.assertEquals(1, results.size());
        Assert.assertEquals(manager, results.get(0));
    }

    @Test
    public void Problem2_byDesignation_then2() {
        SearchCriteria designation = new SearchCriteria("designation",
                EmployeeSpecification.SearchOperation.EQUALITY, Designation.ARCHITECT);

        EmployeeSpecification spec = new EmployeeSpecification(designation);

        List<Employee> results = employeeRepository.findAll(spec);

        Assert.assertEquals(2, results.size());
    }
}