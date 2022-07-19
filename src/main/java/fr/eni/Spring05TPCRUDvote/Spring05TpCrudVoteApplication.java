package fr.eni.Spring05TPCRUDvote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.Spring05TPCRUDvote.bo.Candidat;
import fr.eni.Spring05TPCRUDvote.bo.Votant;
import fr.eni.Spring05TPCRUDvote.dal.CandidatDao;
import fr.eni.Spring05TPCRUDvote.dal.VotantDao;

@SpringBootApplication
public class Spring05TpCrudVoteApplication implements CommandLineRunner {
	@Autowired
	private VotantDao votantDao;
	private CandidatDao candidatDao;

	public static void main(String[] args) {
		SpringApplication.run(Spring05TpCrudVoteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Candidat jean = new Candidat("Jean", "Delagauche", "Gauche");
		Candidat michel = new Candidat("Michel", "Plusadroite", "Droite");
		Votant pierre = new Votant("Pierre", "Avote", 18, "Francais", "michel");

//		candidatDao.save(jean);
//		candidatDao.save(michel);
		votantDao.save(pierre);

//		System.out.println("Test affichage candidats");
//		candidatDao.findAll().forEach(System.out::println);

		System.out.println("Test affichage votant");
		votantDao.findAll().forEach(System.out::println);
	}
}
