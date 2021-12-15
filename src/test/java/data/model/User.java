package data.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class User {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String fullName;
    private String phoneNumber;
    private String role;
}
