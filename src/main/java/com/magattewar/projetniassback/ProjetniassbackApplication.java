package com.magattewar.projetniassback;

import com.magattewar.projetniassback.model.EtatCommande;
import com.magattewar.projetniassback.model.InitEtatCommande;
import com.magattewar.projetniassback.repository.EtatCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ProjetniassbackApplication {


	public static void main(String[] args) {
		SpringApplication.run(ProjetniassbackApplication.class, args);
	}


}
