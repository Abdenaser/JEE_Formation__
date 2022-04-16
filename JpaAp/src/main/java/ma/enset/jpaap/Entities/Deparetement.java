package ma.enset.jpaap.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor

public class Deparetement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "deparetement",fetch = FetchType.LAZY)
    public Collection<Professeur> professeurs;
    }
