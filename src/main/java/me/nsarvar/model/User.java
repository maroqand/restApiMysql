package me.nsarvar.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by nsarvar on 12/27/17.
 *
 * @Id - Annotate the id column using @Id
 * @GeneratedValue -Let database generate (auto-increment) the id column.
 * GenerationType - Defines the types of primary key generation strategies.
 * GenerationType.AUTO - persistence provider should pick an appropriate strategy for db
 * @CreationTimestamp - Hibernate gets the current timestamp from the VM and sets it as the value of the attribute
 * @UpdateTimestamp -gets the current timestamp from the VM and sets it as the update timestamp
 * on the SQL Update statement
 *
 */
@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "created")
    @CreationTimestamp
    private Date crated;

    @Column(name = "updated")
    @UpdateTimestamp
    private Date updated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Date getCrated() {
        return crated;
    }

    public void setCrated(Date crated) {
        this.crated = crated;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}