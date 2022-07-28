package fr.eni.Spring05TPCRUDvote.bll;

import java.util.List;
import fr.eni.Spring05TPCRUDvote.bo.Passion;


public interface PassionManager {
	public void addPassion(Passion... listePassion) throws PassionException;
	public List<Passion> getAllPassion();
	public void delPassionById(Integer id);
	public Passion getPassionById(Integer id);
	public void modPassion(Passion passion) throws PassionException;
}
