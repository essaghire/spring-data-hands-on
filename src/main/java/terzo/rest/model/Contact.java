package terzo.rest.model;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {

    private String firstName;
    private String lastName;
    private String phone;
}
