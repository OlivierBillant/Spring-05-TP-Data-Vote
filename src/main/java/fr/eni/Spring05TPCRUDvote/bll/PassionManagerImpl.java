package fr.eni.Spring05TPCRUDvote.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.eni.Spring05TPCRUDvote.bo.Passion;
import fr.eni.Spring05TPCRUDvote.dal.PassionDao;


@Service
public class PassionManagerImpl implements PassionManager{
	@Autowired
	private PassionDao dao;
	
	@Override
	@Transactional
	public void addPassion(Passion... listePassion) throws PassionException {
		for (Passion passion : listePassion) {
			addOrModPassion(passion);
		}
	}

	@Override
	public List<Passion> getAllPassion() {
		return (List<Passion>) dao.findAll();
	}

	@Override
	public void delPassionById(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public Passion getPassionById(Integer id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public void modPassion(Passion passion) throws PassionException {
		this.addOrModPassion(passion);
	}

	private void addOrModPassion(Passion passion) throws PassionException {
		if("Chasse".equals(passion.getNom())){
			throw new PassionException("Tire toi dessus");
		}
		dao.save(passion);
	}

}
