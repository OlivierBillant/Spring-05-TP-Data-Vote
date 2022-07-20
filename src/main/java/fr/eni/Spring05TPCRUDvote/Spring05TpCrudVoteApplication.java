package fr.eni.Spring05TPCRUDvote;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.Spring05TPCRUDvote.bll.VoteManager;
import fr.eni.Spring05TPCRUDvote.bo.Candidat;
import fr.eni.Spring05TPCRUDvote.bo.Votant;
import fr.eni.Spring05TPCRUDvote.dal.CandidatDao;
import fr.eni.Spring05TPCRUDvote.dal.VotantDao;

@SpringBootApplication
public class Spring05TpCrudVoteApplication implements CommandLineRunner {
	@Autowired
	private VotantDao votantDao;
	@Autowired
	private CandidatDao candidatDao;
	@Autowired
	@Qualifier("VoteManager")
	private VoteManager voteManager;

	public static void main(String[] args) {
		SpringApplication.run(Spring05TpCrudVoteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Candidat jean = new Candidat("Jean", "Delagauche", "Gauche");
		Candidat michel = new Candidat("Michel", "Plusadroite", "Droite");
		Votant pierre = new Votant("Pierre", "Avote", 18, "Francais", michel);
		Votant paul = new Votant("Paul", "Avote", 18, "Francais", jean);
		Votant jacques = new Votant("Jacques", "Avote", 16, "Francais", michel);
		Votant andre = new Votant("André", "Bourrelesurnes", 19, "Francais", jean);
		Votant antoine = new Votant("Antoine", "Avote", 18, "Francais", jean);
		Votant hans = new Votant("Hans", "Gruber", 18, "Allemand", michel);

		candidatDao.save(jean);
		candidatDao.save(michel);
		voteManager.vote(pierre);
		voteManager.vote(paul);
		voteManager.vote(jacques);
		voteManager.vote(andre);
		voteManager.vote(antoine);
		voteManager.vote(hans);

		voteManager.vote(pierre);
		
		System.out.println("Test affichage candidats");
		candidatDao.findAll().forEach(System.out::println);
		System.out.println("");
		
		System.out.println("Impression de la liste des votants");
		voteManager.afficherLesVotants();
		System.out.println("");
		
//		votantDao.getByCandidat("michel").forEach(System.out::println);
//		votantDao.getByCandidat("jean").forEach(System.out::println);

		System.out.println("Proclamation des résultats");
//		System.out.println(voteManager.proclamationResultats());
//		System.out.println("Tableau des résultats");
//		System.out.println(votantDao.getCount());
//		System.out.println(votantDao.getTotalVote());
		voteManager.proclamationResultatsMultiple();
	}
}
