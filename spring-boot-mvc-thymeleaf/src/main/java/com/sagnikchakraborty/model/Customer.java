package com.sagnikchakraborty.model;

import com.sagnikchakraborty.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;

    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 5, message = "must be less than or equal to 5")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 characters/digits allowed")
    private String postalCode;

//    @CourseCode(value = "ARC", message = "Must start with ARC")
    @CourseCode
    private String courseCode;

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

    public Integer getFreePasses() {
        return freePasses;
    }
    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", freePasses=" + freePasses +
                ", postalCode='" + postalCode + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}
