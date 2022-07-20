package fr.eni.Spring05TPCRUDvote.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.eni.Spring05TPCRUDvote.bo.Candidat;
import fr.eni.Spring05TPCRUDvote.bo.Votant;
import fr.eni.Spring05TPCRUDvote.dal.CandidatDao;
import fr.eni.Spring05TPCRUDvote.dal.VotantDao;

@Component("VoteManager")
public class VoteManagerImpl implements VoteManager {
	@Autowired
	private VotantDao votantDao;
	@Autowired
	private CandidatDao candidatDao;
	@Override
	public void vote(Votant votant) {
//		votantDao.save(votant);
		try {
			if (listeElectorale(votant)) {
				System.out.println(votant.getPrenom()+" "+votant.getNom()+" est inscrit sur la liste électorale");
				votant.setAVote(true);
				votantDao.save(votant);
				votant.getCandidat().addVotant(votant);
				
			}
		} catch (VoteException ve) {
			System.out.println("Erreur : "+ve.getMessage());
		}
	}
	
	@Override
	public void candidature(Candidat candidat) {
		candidatDao.save(candidat);
	}

	@Override
	public void afficherLesVotants() {
		votantDao.findAll().forEach(System.out::println);
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
	public void afficherLesCandidatures() {
		candidatDao.findAll().forEach(System.out::println);
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
		System.out.println("Le vainqueur est "
				+votantDao.getCount().get(0).getPrenom()
				+" "+ votantDao.getCount().get(0).getNom()
				+" avec "+ votantDao.getTotalVote().get(0)+" voix !"
				+" Vive la "+votantDao.getCount().get(0).getParti());
	}

}
