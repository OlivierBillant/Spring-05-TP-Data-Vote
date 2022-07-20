package fr.eni.Spring05TPCRUDvote.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.Spring05TPCRUDvote.bo.Parti;

public interface PartiDao extends CrudRepository<Parti, Integer>{

}
