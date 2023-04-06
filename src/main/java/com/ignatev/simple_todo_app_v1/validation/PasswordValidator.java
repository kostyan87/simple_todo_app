package com.ignatev.simple_todo_app_v1.validation;

import com.ignatev.simple_todo_app_v1.annotation.PasswordMatches;
import com.ignatev.simple_todo_app_v1.payload.SignUpRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        SignUpRequest userSignupRequest = (SignUpRequest) o;
//        System.out.println("password validator");
        return userSignupRequest
                .getPassword()
                .equals(userSignupRequest.getConfirmPassword());
    }
}
