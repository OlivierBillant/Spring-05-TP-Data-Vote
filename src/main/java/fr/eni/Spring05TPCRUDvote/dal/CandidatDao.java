package fr.eni.Spring05TPCRUDvote.dal;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.eni.Spring05TPCRUDvote.bo.Candidat;
import fr.eni.Spring05TPCRUDvote.bo.Passion;
import fr.eni.Spring05TPCRUDvote.bo.Votant;

public interface CandidatDao extends CrudRepository<Candidat, Integer> {

	@Query("SELECT p.nom FROM Votant v JOIN v.candidat c JOIN c.listePassion p WHERE v= :votant")
	ArrayList<String> getPassionCandidatOfVotant(@Param("votant") Votant votant);
	
}
