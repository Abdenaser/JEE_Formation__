package ma.enset.jpaap;


import ma.enset.jpaap.Entities.Professeur;
import ma.enset.jpaap.Repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.List;

@SpringBootApplication
public class JpaApApplication{


    @Autowired
    private ProfesseurRepository professeurRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaApApplication.class, args);

    }
    public void run(String... args)throws Exception{
        professeurRepository.save(new Professeur(
                null,
                "Abdenasser",
                "Aroukhsiss",
                new Date(Date.valueOf("2000-02-26").getTime()),
                "Math-Info"
        ));
        professeurRepository.save(new Professeur(
                null,
                "Said",
                "Ahmed",
                new Date(Date.valueOf("1999-02-02").getTime()),
                "Mecanique"
        ));
        professeurRepository.save(new Professeur(
                null,
                "Yassine",
                "benani",
                new Date(Date.valueOf("1980-02-26").getTime()),
                "Math-Info"
        ));
        professeurRepository.save(new Professeur(
                null,
                "mohammed",
                "Sifeddine",
                new Date(Date.valueOf("1980-02-26").getTime()),
                "Electrique"
        ));professeurRepository.save(new Professeur(
                null,
                "ikram",
                "boujdik",
                new Date(Date.valueOf("1980-02-26").getTime()),
                "Electrique"
        ));professeurRepository.save(new Professeur(
                null,
                "fatim-ezzahra",
                "allaoui",
                new Date(Date.valueOf("1980-02-26").getTime()),
                "Math-Info"
        ));
    }




}
