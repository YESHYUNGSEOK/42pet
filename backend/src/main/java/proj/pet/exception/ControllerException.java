package proj.pet.exception;

import lombok.Getter;
import proj.pet.dto.ExceptionStatusDto;

@Getter
public class ControllerException extends RuntimeException{

	private final ExceptionStatusDto status;


	public ControllerException(ExceptionStatus status) {
		this.status = new ExceptionStatusDto(status.getStatusCode(), status.getMessage(), status.getError());
	}

	public ControllerException(ExceptionStatus status, String message) {
		this.status = new ExceptionStatusDto(status.getStatusCode(), message, status.getError());
	}
}
