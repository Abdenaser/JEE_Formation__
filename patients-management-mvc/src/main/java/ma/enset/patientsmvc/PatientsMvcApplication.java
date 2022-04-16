package ma.enset.patientsmvc;

import ma.enset.patientsmvc.Entities.Patient;
import ma.enset.patientsmvc.Repositories.PatientRepositorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }
    //@bean : pour que cette methode ne s'exécute pas au démarage.
    //@Bean
    CommandLineRunner commandLineRunner(PatientRepositorie patientRepositorie){
        return args->{
            patientRepositorie.save(new Patient(null,"Abdenasser",new Date(),false,151));
            patientRepositorie.save(new Patient(null,"Ahmed",new Date(),true,225));
            patientRepositorie.save(new Patient(null,"ikram",new Date(),false,733));
            patientRepositorie.save(new Patient(null,"Said",new Date(),true,101));

            //returner la listes des patient aux demarage de l'appliocation
            patientRepositorie.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }
}
