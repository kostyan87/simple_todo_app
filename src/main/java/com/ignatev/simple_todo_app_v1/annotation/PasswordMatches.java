package com.ignatev.simple_todo_app_v1.annotation;

import com.ignatev.simple_todo_app_v1.validation.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordMatches {
    String message() default "password do not match";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default {};
}
