package me.nsarvar.util;

import me.nsarvar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by nsarvar on 12/28/17.
 */
public class UsernameValidator implements ConstraintValidator<UsernameConstraint, String> {

    @Autowired
    UserService userService;

    @Override
    public void initialize(UsernameConstraint usernameConstraint) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if(userService.findOneByUsername(s).size() == 0)
            return true;

        return false;
    }
}
