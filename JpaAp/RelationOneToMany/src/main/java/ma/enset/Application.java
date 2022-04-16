package ma.enset.demo;

import ma.enset.demo.entities.*;
import ma.enset.demo.repositories.ConsultationRepo;
import ma.enset.demo.repositories.MedecinRepo;
import ma.enset.demo.repositories.PatientRepo;
import ma.enset.demo.repositories.RendezVousRepo;
import ma.enset.demo.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner start(IHospitalService hospitalService,
                            PatientRepo patientRepo,
                            MedecinRepo medecinRepo,
                            RendezVousRepo rendezVousRepo,
                            ConsultationRepo consultationRepo){
        return args -> {
            hospitalService.savePatient(new Patient(null,"abdenasser", new Date(),false,null));
            Stream.of("Aziz", "ikram", "said").forEach(name -> {
                Patient p = new Patient();
                p.setNom(name);
                p.setDateNaissance(new Date());
                p.setMalade(false);
                hospitalService.savePatient(p);
            });

            Stream.of("Akram", "med", "yasser").forEach(name -> {
                Medecin medecin = new Medecin();
                medecin.setName(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "Psycho");
                hospitalService.saveMedecin(medecin);
            });

            Patient patient = patientRepo.findByNom("abdenasser");
            Medecin medecin = medecinRepo.findById(2L).orElse(null);

            RendezVous rdv = new RendezVous();
            rdv.setDate(new Date());
            rdv.setStatus(StatusRDV.DONE);
            rdv.setPatient(patient);
            rdv.setMedecin(medecin);
            hospitalService.saveRDV(rdv);

            RendezVous rendezVous = rendezVousRepo.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsult(rendezVous.getDate());
            consultation.setRendezVous(rendezVous);
            consultation.setRapportConsult("Rapport de la consultation N° :");
            hospitalService.saveConsultation(consultation);


        };
    }

}
