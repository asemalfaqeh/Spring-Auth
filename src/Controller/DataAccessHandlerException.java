package Controller;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DataAccessHandlerException {

	@ExceptionHandler
	public String DataAccessExceptionHandle(DataAccessException dx) {
		dx.printStackTrace();
		return "error";
	}
	
}
