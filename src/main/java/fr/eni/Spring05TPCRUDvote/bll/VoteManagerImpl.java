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
				votant.setAVote(true);
				votantDao.save(votant);
			}
		} catch (VoteException ve) {
			System.out.println("Erreur : "+ve.getMessage());
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
	public Boolean listeElectorale(Votant votant) throws VoteException {
		if (votant.getAge() >= 18 && "Francais".equals(votant.getNationalite()) && !votant.getAVote()) {
			return true;
		} else {
			throw new VoteException("Ne peut pas voter");
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
		String results [] = votantDao.getCount().get(0).trim().split(",");
		String vainqueur = results[0];
		Integer nrbVotes = Integer.parseInt(results[1]);
//		System.out.println("Le vainqueur est "+votantDao.getCount().get(0));
		System.out.println("Le vainqueur est "+vainqueur+" avec "+nrbVotes.toString()+" voix");
	}

}
