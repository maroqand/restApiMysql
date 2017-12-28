package me.nsarvar.vo;

import me.nsarvar.util.UsernameConstraint;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by nsarvar on 12/27/17.
 */
public class CreateUserVO {


    @NotEmpty(message = "First name cannot be empty.")
    private String firstName;

    @NotEmpty(message = "Last name cannot be null.")
    private String lastName;

    @NotEmpty(message = "Username cannot be null.")
    @UsernameConstraint
    @Size(min = 4, max = 11)
    private String username;
    //getters and setters


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
