package fr.eni.Spring05TPCRUDvote.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.Spring05TPCRUDvote.bo.BureauDeVote;

public interface BureauDeVoteDao extends CrudRepository<BureauDeVote, Integer>{

}
