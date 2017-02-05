package com.reseau;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReseauSocialApplication implements CommandLineRunner {

	/*@Autowired
	private IUtilisateurRepository utilisateurRepository;*/
	
	public static void main(String[] args) {
		SpringApplication.run(ReseauSocialApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		/*SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Utilisateur utilisateur = new Professeur("belahmar", "habib", "habib", MD5.getMD5("habib"), formatter.parse("02-04-1975"), "0655889933", "agdal", "/dist/img/avatar6.png", "Maroc", "Rabat", "branche", true, "Professeur", new Date(System.currentTimeMillis()), "ISGA, EMSI, Unicérsite Mohamed 5");
		utilisateurRepository.save(utilisateur);*/
	}
}
