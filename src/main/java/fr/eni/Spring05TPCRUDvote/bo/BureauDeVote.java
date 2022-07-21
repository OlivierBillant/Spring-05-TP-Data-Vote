package fr.eni.Spring05TPCRUDvote.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class BureauDeVote {
	@Id
	@GeneratedValue
	private Integer idBureau;
	private String numero;
	private String adresse;

	public BureauDeVote(String numero, String adresse) {
		super();
		this.numero = numero;
		this.adresse = adresse;
	}
}
