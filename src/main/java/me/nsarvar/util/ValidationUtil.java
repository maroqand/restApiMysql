package me.nsarvar.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nsarvar on 12/28/17.
 */
public class ValidationUtil {
    public static List<String> fromBindingErrors(Errors errors) {
        List<String> validErrors = new ArrayList<String>();

        errors.getAllErrors().forEach(
                objectError -> validErrors.add(objectError.getDefaultMessage()));

        return validErrors;
    }
}
