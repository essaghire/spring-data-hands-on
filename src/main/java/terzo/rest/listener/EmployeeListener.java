package terzo.rest.listener;


import org.springframework.data.domain.Auditable;
import terzo.rest.model.Employee;

import javax.persistence.*;

public class EmployeeListener {
    @PrePersist
    public void EmployeePrePersist(Employee ob) {
        System.out.println("Listening Employee Pre Persist : " + ob.getName());
    }
    @PostPersist
    public void EmployeePostPersist(Employee ob) {
        System.out.println("Listening Employee Post Persist : " + ob.getName());
    }
    @PostLoad
    public void EmployeePostLoad(Employee ob) {
        System.out.println("Listening Employee Post Load : " + ob.getName());
    }
    @PreUpdate
    public void EmployeePreUpdate(Employee ob) {
        System.out.println("Listening Employee Pre Update : " + ob.getName());
    }
    @PostUpdate
    public void EmployeePostUpdate(Employee ob) {
        System.out.println("Listening Employee Post Update : " + ob.getName());
    }
    @PreRemove
    public void EmployeePreRemove(Employee ob) {
        System.out.println("Listening Employee Pre Remove : " + ob.getName());
    }
    @PostRemove
    public void EmployeePostRemove(Employee ob) {
        System.out.println("Listening Employee Post Remove : " + ob.getName());
    }
}
