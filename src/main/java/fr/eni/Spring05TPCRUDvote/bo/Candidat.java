package fr.eni.Spring05TPCRUDvote.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//import lombok.ToString;

//@Data
@Getter
@Setter
//@ToString
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "candidate")
public class Candidat {
	@Id
	@GeneratedValue
	private Integer idCandidat;
	@Column(length = 25)
	private String nom;
	private String prenom;
	@ManyToOne
	private Parti parti;
	
	@OneToMany(mappedBy = "candidat", fetch = FetchType.LAZY)
	@ToString.Exclude
	private Set<Votant> listeVotants = new HashSet<>();

	@ManyToMany(cascade = CascadeType.PERSIST)
	private Set<Passion> listePassion = new HashSet<Passion>();
	
	public Candidat(String prenom, String nom, Parti parti) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.parti = parti;
	}
	
	public void addVotant(Votant votant) {
		listeVotants.add(votant);
	}

//	@Override
//	public String toString() {
//		return "Candidat [nom=" + nom + ", prenom=" + prenom + ", parti=" + parti.getNom() + "]";
//	}

	
	
	
}
