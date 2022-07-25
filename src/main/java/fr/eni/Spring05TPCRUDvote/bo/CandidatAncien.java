package fr.eni.Spring05TPCRUDvote.bo;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CandidatAncien extends Candidat{
	private Double popularite;

	public CandidatAncien(String prenom, String nom, Parti parti, Double popularite) {
		super(prenom, nom, parti);
		this.popularite = popularite;
	}
	
	
}
