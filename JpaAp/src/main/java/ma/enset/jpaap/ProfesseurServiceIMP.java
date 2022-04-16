package ma.enset.jpaap;

import ma.enset.jpaap.Entities.Professeur;
import ma.enset.jpaap.Repositories.DeparetementRepository;
import ma.enset.jpaap.Repositories.ProfesseurRepository;
import ma.enset.jpaap.Services.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Repository
@Transactional
public class ProfesseurServiceIMP implements ProfesseurService {

    //@Autowired
    ProfesseurRepository professeurRepository;
    //@Autowired
    DeparetementRepository deparetementRepository;

    public ProfesseurServiceIMP(ProfesseurRepository professeurRepository, DeparetementRepository deparetementRepository) {
        this.professeurRepository = professeurRepository;
        this.deparetementRepository = deparetementRepository;
    }

    @Override
    public Professeur save(Professeur p) {
        return professeurRepository.save(p);
    }

    @Override
    public List<Professeur> findAll() {
        return professeurRepository.findAll();
    }

    @Override
    public Professeur findOne(Long id) {
        return null;
    }
}

