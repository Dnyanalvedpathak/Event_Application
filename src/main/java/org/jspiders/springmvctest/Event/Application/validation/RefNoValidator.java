package org.jspiders.springmvctest.Event.Application.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RefNoValidator implements ConstraintValidator<RefNo,String> {

    private String prefix;

    @Override
    public void initialize(RefNo constraintAnnotation) {
        this.prefix=constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value==null) {
            return false;
        }
        return value.startsWith(prefix);
    }
}
