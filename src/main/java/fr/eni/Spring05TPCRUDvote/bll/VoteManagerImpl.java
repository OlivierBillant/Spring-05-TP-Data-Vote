package fr.eni.Spring05TPCRUDvote.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.eni.Spring05TPCRUDvote.bo.Votant;
import fr.eni.Spring05TPCRUDvote.dal.VotantDao;

@Component("VoteManager")
public class VoteManagerImpl implements VoteManager {
	@Autowired
	private VotantDao votantDao;

	@Override
	public void vote(Votant votant) {
//		votantDao.save(votant);
		try {
			if (listeElectorale(votant)) {
				System.out.println(votant.getPrenom()+" "+votant.getNom()+" est inscrit sur la liste électorale");
				votantDao.save(votant);
			}
		} catch (Exception e) {
			System.out.println("Pas inscrit sur la liste électorale.");
		}
	}

	@Override
	public void afficherLesVotants() {
		votantDao.findAll().forEach(System.out::println);;
	}

	@Override
	public void afficherVotantsaGauche() {
		votantDao.getByCandidat("jean");
	}

	@Override
	public void afficherVotantsaDroite() {
		votantDao.getByCandidat("michel");

	}

	@Override
	public Boolean listeElectorale(Votant votant) {
		if (votant.getAge() >= 18 && "Francais".equals(votant.getNationalite())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String proclamationResultats() {
		if (votantDao.getByCandidat("michel").size() > votantDao.getByCandidat("jean").size()) {
			return "Le vainqueur est Michel de Droite";
		} else
			return "Le vainqueur est Jean de Gauche";
	}
	
	@Override
	public void proclamationResultatsMultiple() {
		System.out.println("Le vainqueur est "+votantDao.getCount().get(0));
	}

}
