package fr.eni.Spring05TPCRUDvote.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.Spring05TPCRUDvote.bo.Passion;

public interface PassionDao extends CrudRepository<Passion, Integer>{

}
