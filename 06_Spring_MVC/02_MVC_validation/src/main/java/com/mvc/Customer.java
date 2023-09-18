package com.mvc;

import com.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;

@Component
public class Customer
{
    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String lastName;
    @NotNull(message = "is required")
    @Min(value = 0, message = "Value must be greater than or equal to 0")
    @Max(value = 10, message = "Value must be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{6}", message = "Only 6 chars/digits")
    private String postalCode;

    @CourseCode(value = "H", message = "must start with H")
    private String courseCode;
    public Customer() {}
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}
