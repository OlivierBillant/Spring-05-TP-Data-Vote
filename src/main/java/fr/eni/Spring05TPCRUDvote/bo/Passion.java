package fr.eni.Spring05TPCRUDvote.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Passion {
	@Id
	@GeneratedValue
	private Integer idPassion;
	private String nom;
	private String description;
	
	@ManyToMany(mappedBy = "listePassion")
	private Set<Candidat> listeCandidat = new HashSet<Candidat>();

	public Passion(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Passion [nom=" + nom + ", description=" + description + "]";
	}
	
	
	
}
