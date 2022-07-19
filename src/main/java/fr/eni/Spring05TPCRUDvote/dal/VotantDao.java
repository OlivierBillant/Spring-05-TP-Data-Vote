package fr.eni.Spring05TPCRUDvote.dal;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.eni.Spring05TPCRUDvote.bo.Votant;

public interface VotantDao extends CrudRepository<Votant, Integer>{

//	Votant findByCandidat(String Candidat);
	@Query("SELECT v.prenom FROM Votant v WHERE v.candidat= :candidat")
	ArrayList<String> getByCandidat(@Param("candidat") String prenom);
}
