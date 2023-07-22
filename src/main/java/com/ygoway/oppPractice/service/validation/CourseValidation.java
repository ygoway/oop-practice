package com.ygoway.oppPractice.service.validation;

import com.ygoway.oppPractice.service.exception.IncorrectNameException;

import static com.ygoway.oppPractice.service.Impl.StudentServiceImpl.STUDENT_NAME_REGEX;

public interface CourseValidation extends Validatable {

    default boolean courseTitleValidation(String title) throws IncorrectNameException {
        try {
            courseTitleValidate(title);
            return true;
        } catch (IncorrectNameException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void courseTitleValidate(String title) throws IncorrectNameException {
        if(!title.matches(STUDENT_NAME_REGEX))
            throw new IncorrectNameException(String.format("Invalid title : %s", title + "\n" +
                    "Title must started from capital letter, include only latin letters, consist of minimum 2 letters" +
                    "\nand supports spaces between a words"));
    }
}
