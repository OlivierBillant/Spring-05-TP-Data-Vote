package fr.eni.Spring05TPCRUDvote.bll;

import fr.eni.Spring05TPCRUDvote.bo.Votant;

public interface VoteManager {
	public void vote(Votant votant);
	public void afficherLesVotants();
	public void afficherVotantsaGauche();
	public void afficherVotantsaDroite();
	public Boolean listeElectorale(Votant votant) throws VoteException;
	public String proclamationResultats();
	public void proclamationResultatsMultiple();
}
