package az.developia.springrestayaan.exception;

import org.springframework.validation.BindingResult;

public class MyValidationException extends RuntimeException {

	BindingResult br;

	public MyValidationException(BindingResult br) {
		this.br = br;
	}

	public BindingResult getBr() {
		return br;
	}

	public void setBr(BindingResult br) {
		this.br = br;
	}

}
