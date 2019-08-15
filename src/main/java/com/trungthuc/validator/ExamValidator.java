package com.trungthuc.validator;

import com.trungthuc.domains.Exam;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class ExamValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Exam.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Exam exam =(Exam)  o;


    }
}
