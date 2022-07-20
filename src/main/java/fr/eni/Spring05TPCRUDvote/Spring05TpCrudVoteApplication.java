package fr.eni.Spring05TPCRUDvote;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import fr.eni.Spring05TPCRUDvote.bll.VoteManager;
import fr.eni.Spring05TPCRUDvote.bo.Candidat;
import fr.eni.Spring05TPCRUDvote.bo.Parti;
import fr.eni.Spring05TPCRUDvote.bo.Votant;


@SpringBootApplication
public class Spring05TpCrudVoteApplication implements CommandLineRunner {
	@Autowired
	@Qualifier("VoteManager")
	private VoteManager voteManager;

	public static void main(String[] args) {
		SpringApplication.run(Spring05TpCrudVoteApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Parti lesSoumises = new Parti("lesSoumises", "Goche");
		Parti laMatraque = new Parti("laMatraque", "Droate");
//		Création des candidats
		Candidat jean = new Candidat("Jean", "Delagauche", lesSoumises);
		Candidat jeanne = new Candidat("Jeanne", "Dissidente", lesSoumises);
		Candidat michel = new Candidat("Michel", "Plusadroite", laMatraque);
//		Création des votants
		Votant pierre = new Votant("Pierre", "Avote", 18, "Francais", michel);
		Votant paul = new Votant("Paul", "Avote", 18, "Francais", jean);
		Votant jacques = new Votant("Jacques", "Avote", 16, "Francais", michel);
		Votant andre = new Votant("André", "Bourrelesurnes", 19, "Francais", jean);
		Votant antoine = new Votant("Antoine", "Avote", 18, "Francais", jean);
		Votant hans = new Votant("Hans", "Gruber", 18, "Allemand", michel);

//		Enreistrement des partis en db
		voteManager.creationParti(lesSoumises);
		voteManager.creationParti(laMatraque);

//		Enreistrement des candidatures en db
		voteManager.candidature(jean);
		voteManager.candidature(jeanne);
		voteManager.candidature(michel);
		
//		Enreistrement des votes en db
		voteManager.vote(pierre);
		voteManager.vote(paul);
		voteManager.vote(jacques);
		voteManager.vote(andre);
		voteManager.vote(antoine);
		voteManager.vote(hans);
		
//		Essai de vote en doublon
		voteManager.vote(pierre);

//		Affichage de tous les partis
		System.out.println("Test affichage partis");
		voteManager.afficherLesPartis();
		System.out.println("");
		
//		Affichage de toutes les candidatures
		System.out.println("Test affichage candidats");
		voteManager.afficherLesCandidatures();
		System.out.println("");

//		Affichage de touts les votants
		System.out.println("Impression de la liste des votants");
		voteManager.afficherLesVotants();
		System.out.println("");
		
//		Affichage des votants par candidat
		voteManager.afficherListesVotants();

//		Affichage des résultats
		System.out.println("Proclamation des résultats");
		voteManager.proclamationResultatsMultiple();
	}
}
