package br.gov.pa.prodepa.nucleopa.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.stereotype.Component;

import br.gov.pa.prodepa.nucleopa.domain.port.ValidationUtils;
import lombok.Getter;
import lombok.Setter;

@Component
public class ValidationUtilsImpl implements ValidationUtils {

	@Override
	public Boolean ehCpfValido(String cpf) {
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		CpfWrapper wrapper = new CpfWrapper(cpf);
		
		Set<ConstraintViolation<CpfWrapper>> validate = validator.validate(wrapper);
		
		return validate.size() > 0;
	}

	@Getter
	@Setter
	class CpfWrapper {

		@CPF
		private String cpf;
		
		public CpfWrapper(String cpf) {
			this.cpf = cpf;
		}
		
	}
}
