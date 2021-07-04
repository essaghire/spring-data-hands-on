package terzo.rest.model;

import lombok.Getter;
import lombok.Setter;
import terzo.rest.listener.EmployeeListener;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EntityListeners(EmployeeListener.class)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="salary")
    private long salary;

    @JoinColumn(name = "department_id", referencedColumnName = "id")
    @ManyToOne(optional=true)
    private Department department;

    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    @ManyToOne(optional=true)
    private Employee manager;

    @Column(name="designation")
    private Designation designation;

    @Embedded
    private Contact contact;
}
