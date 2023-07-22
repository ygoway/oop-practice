package com.ygoway.oppPractice.service.validation;

import com.ygoway.oppPractice.service.exception.IncorrectIdException;
import com.ygoway.oppPractice.service.exception.IncorrectNameException;
import com.ygoway.oppPractice.service.exception.NotFoundException;

import java.util.InputMismatchException;

import static com.ygoway.oppPractice.service.Impl.StudentServiceImpl.STUDENT_NAME_REGEX;

public interface StudentValidation extends Validatable {

    default boolean newStudentValidation(String fName, String lName) throws IncorrectNameException{
        try {
            newStudentValidate(fName, lName);
            return true;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IncorrectNameException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    default boolean idValidation(String stringId) throws IncorrectIdException, NotFoundException {
        try {
            idValidate(stringId);
            return true;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IncorrectIdException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void newStudentValidate(String firstName, String lastName) throws NullPointerException, IncorrectNameException {
        if(firstName == null || lastName == null) throw new NullPointerException("Name cannot be a null");
        if (!firstName.matches(STUDENT_NAME_REGEX))
            throw new IncorrectNameException(String.format("Invalid firstname : %s", firstName + "\n" +
                    "Firstname must started from capital letter, include only latin letters and consist of minimum 2 letters"));
        else if (!lastName.matches(STUDENT_NAME_REGEX))
            throw new IncorrectNameException(String.format("Invalid lastname : %s.", lastName + "\n" +
                    "Lastname must started from capital letter, include only latin letters and consist of minimum 2 letters"));
    }

    private void idValidate(String stringId) throws NullPointerException, InputMismatchException, IncorrectIdException {
        if (stringId == null) throw new NullPointerException("Id cannot be a null");
        if(!stringId.matches("\\d+")) throw new InputMismatchException("Id must be numeric only");
        var id = Integer.parseInt(stringId);
        if (id <= 0) throw new IncorrectIdException(String.format("Invalid id : %s", id +
                "\nId cannot be less than 1"));
    }
}
