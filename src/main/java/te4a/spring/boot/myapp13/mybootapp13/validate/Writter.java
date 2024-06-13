package te4a.spring.boot.myapp13.mybootapp13.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = WritterValidator.class)
public @interface Writter {
    String ok();
    String message() default "Input {0}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}