package com.borrowing.entity;

import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

public class customer extends BaseEntity {
    @Id
    private String cif;
    private String firstName;
    private String lastName;
    private Date birthDate;

    public customer(Integer id, java.sql.Date createdAt, java.sql.Date updatedAt, String cif, String firstName, String lastName, Date birthDate) {
        super(id, createdAt, updatedAt);
        this.cif = cif;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        customer customer = (customer) o;
        return Objects.equals(cif, customer.cif) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(birthDate, customer.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cif, firstName, lastName, birthDate);
    }
}
