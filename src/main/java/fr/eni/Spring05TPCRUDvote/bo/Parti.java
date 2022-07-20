package fr.eni.Spring05TPCRUDvote.bo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class Parti {
	@Id
	@GeneratedValue
	private Integer idParti;
	private String nom;
	private String affiliation;
	
	public Parti(String nom, String affiliation) {
		super();
		this.nom = nom;
		this.affiliation = affiliation;
	}
	
	
}
