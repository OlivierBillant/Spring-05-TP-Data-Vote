package fr.eni.Spring05TPCRUDvote.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.Spring05TPCRUDvote.bo.Votant;

public interface VotantDao extends CrudRepository<Votant, Integer>{

}
