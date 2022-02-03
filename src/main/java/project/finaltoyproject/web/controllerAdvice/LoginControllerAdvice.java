package project.finaltoyproject.web.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import project.finaltoyproject.util.ErrorField;
import project.finaltoyproject.util.exeption.DuplicatedEmailException;
import project.finaltoyproject.util.exeption.SessionRemoveException;
import project.finaltoyproject.util.exeption.UserNotExistException;

@ControllerAdvice
public class LoginControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ErrorField> duplicatedException(DuplicatedEmailException ex)
    {
        ErrorField errorField = new ErrorField();
        errorField.setCode("BAD");
        errorField.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorField>(errorField,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorField> userExistException(UserNotExistException ex)
    {
        ErrorField errorField = new ErrorField();
        errorField.setCode("BAD");
        errorField.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorField>(errorField,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorField> userExistException(SessionRemoveException ex)
    {
        ErrorField errorField = new ErrorField();
        errorField.setCode("UNAUTHORIZED");
        errorField.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorField>(errorField,HttpStatus.UNAUTHORIZED);
    }
}
