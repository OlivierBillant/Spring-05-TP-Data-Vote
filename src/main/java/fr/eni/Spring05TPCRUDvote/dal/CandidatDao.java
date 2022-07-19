package fr.eni.Spring05TPCRUDvote.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.Spring05TPCRUDvote.bo.Candidat;

public interface CandidatDao extends CrudRepository<Candidat, Integer>{

}
