package fr.eni.Spring05TPCRUDvote.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter
@Setter
@ToString
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
	
	@OneToMany(mappedBy = "candidat")
	private Set<Votant> listeVotants = new HashSet<Votant>();

	public Candidat(String prenom, String nom, String parti) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.parti = parti;
	}
	
	public void addVotant(Votant votant) {
		listeVotants.add(votant);
	}
}
