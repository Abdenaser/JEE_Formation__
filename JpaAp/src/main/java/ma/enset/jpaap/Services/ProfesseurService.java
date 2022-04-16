package ma.enset.jpaap.Services;

import ma.enset.jpaap.Entities.Professeur;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProfesseurService {
    public Professeur save(Professeur p);
    public List<Professeur> findAll();
    public Professeur findOne(Long id);
}
