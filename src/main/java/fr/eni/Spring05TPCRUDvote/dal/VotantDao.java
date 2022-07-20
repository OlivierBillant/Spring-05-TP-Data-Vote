package fr.eni.Spring05TPCRUDvote.dal;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.eni.Spring05TPCRUDvote.bo.Candidat;
import fr.eni.Spring05TPCRUDvote.bo.Votant;

public interface VotantDao extends CrudRepository<Votant, Integer>{

//	Votant findByCandidat(String Candidat);
	@Query("SELECT v.prenom FROM Votant v WHERE v.candidat= :candidat")
	ArrayList<String> getByCandidat(@Param("candidat") String prenom);
	
//	Ici la requete récupère count les occurence du prenom, les groupe par prénom et les classe par ordre descendant.
	@Query("SELECT v.candidat FROM Votant v GROUP BY v.candidat ORDER BY count(v.candidat) DESC")
	ArrayList<Candidat> getCount();


}
