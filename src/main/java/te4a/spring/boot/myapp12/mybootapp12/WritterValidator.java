package te4a.spring.boot.myapp12.mybootapp12;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class WritterValidator implements ConstraintValidator<Writter, String> {

    private String ok;

    @Override
    public void initialize(Writter constraintAnnotation) {
        ok = constraintAnnotation.ok();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals(ok);
    }
}