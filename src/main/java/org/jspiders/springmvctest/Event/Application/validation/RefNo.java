package org.jspiders.springmvctest.Event.Application.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.stereotype.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RefNoValidator.class)
public @interface RefNo {
    String value();
    String message() default "REF NO MUST START WITH {value}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
