package com.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode
{
    String value() default "Spring";
    String message() default "must start with Spring";

    //default groups
    Class<?>[] groups() default {};

    //default payload
    Class<? extends Payload>[] payload() default {};
}
