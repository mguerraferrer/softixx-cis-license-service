package mx.softixx.cis.cloud.license.exception.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.val;
import mx.softixx.cis.common.license.exception.LicenseTypeNotFoundException;
import mx.softixx.cis.common.license.exception.UserLicenseAlreadyExistsException;
import mx.softixx.cis.common.license.exception.UserLicenseNotFoundException;
import mx.softixx.cis.common.validation.exception.CustomException;
import mx.softixx.cis.common.validation.util.ProblemDetailUtils;

@Order(Ordered.LOWEST_PRECEDENCE)
@RestControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(UserLicenseNotFoundException.class)
	public ProblemDetail handlerUserLicenseNotFoundException(UserLicenseNotFoundException e) {
		val properties = CustomException.populateProperties(e);
		properties.put("id", e.getId());
		properties.put("userId", e.getUserId());
		properties.put("licenseId", e.getLicenseId());
		properties.put("serie", e.getSerie());
		
		return ProblemDetailUtils.notFound(e.getMessage(), properties);
	}

	@ExceptionHandler(LicenseTypeNotFoundException.class)
	public ProblemDetail handlerLicenseTypeNotFoundException(LicenseTypeNotFoundException e) {
		val properties = CustomException.populateProperties(e);
		properties.put("id", e.getId());
		properties.put("code", e.getCode());
		
		return ProblemDetailUtils.notFound(e.getMessage(), properties);
	}

	@ExceptionHandler(UserLicenseAlreadyExistsException.class)
	public ProblemDetail handlerUserLicenseAlreadyExistsException(UserLicenseAlreadyExistsException e) {
		val properties = CustomException.populateProperties(e);
		return ProblemDetailUtils.preconditionFailed(e.getMessage(), properties);
	}

}