package fr.eni.Spring05TPCRUDvote.bll;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PassionException extends Exception {
	private String message;

	public PassionException(String message) {
		super();
		this.message = message;
	}

	
}
