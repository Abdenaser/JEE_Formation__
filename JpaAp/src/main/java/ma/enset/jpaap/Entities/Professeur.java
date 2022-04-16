package ma.enset.jpaap.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor

public class Professeur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prenom;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date date_de_naissance;
    @ManyToOne(fetch = FetchType.EAGER)
    private Deparetement deparetement;


    public Professeur(Long id, String said, String ahmed, java.sql.Date date_de_naissance, String mecanique) {
    }
}
