package fr.eni.Spring05TPCRUDvote.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Votant {
		@Id
		@GeneratedValue
		private Integer idVotant;
		private String nom;
		private String prenom;
		private Integer age;
		private String nationalite;
//		private Candidat candidat;
		private String candidat;
		private Boolean aVote = false;
		
		public Votant(String prenom, String nom, Integer age, String nationalite, String candidat) {
			super();
			this.prenom = prenom;
			this.nom = nom;
			this.age = age;
			this.nationalite = nationalite;
			this.candidat = candidat;
		}	
	}


	

