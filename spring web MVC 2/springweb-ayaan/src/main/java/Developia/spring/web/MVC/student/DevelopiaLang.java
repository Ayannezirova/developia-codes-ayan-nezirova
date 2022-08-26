package Developia.spring.web.MVC.student;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = DevelopiaLangValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface DevelopiaLang {

	String message() default "Düzgün yaz!";

	Class<? extends Payload>[] payload() default {};

	Class<?>[] groups() default {};

	// əgər şifrə DevelopiaLangValidator sinifində verilən "Developia" ilə başlamasa
	// bu sinifin içindəki error baş verəcək
}
