package Developia.spring.web.MVC.student;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DevelopiaLangValidator

		implements ConstraintValidator<DevelopiaLang, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	
		return value.contains("Developia"); // bu kod ilə yazsaq HƏR HANSI BİR YERİNDƏ Developia sözü yazsa qəbul edəcək
		
		//return value.startsWith("Developia"); // annotasiya hara qoyulubsa məlumatı yazarkən dırnaq arasında və ya
												// mötərizə içində olan simvolla BAŞLAMALIDIR!
	}

}
