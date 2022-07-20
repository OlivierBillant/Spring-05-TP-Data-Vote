package fr.eni.Spring05TPCRUDvote.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Candidat {
	@Id
	@GeneratedValue
	private Integer idCandidat;
	private String nom;
	private String prenom;
	private String parti;

	public Candidat(String prenom, String nom, String parti) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.parti = parti;
	}
}
