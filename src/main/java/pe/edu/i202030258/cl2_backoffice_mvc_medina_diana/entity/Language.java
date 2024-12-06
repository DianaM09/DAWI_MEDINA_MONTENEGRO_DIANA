package pe.edu.i202030258.cl2_backoffice_mvc_medina_diana.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer languageId;

    private String name;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @OneToMany(mappedBy = "language")
    private List<Film> films;

    @OneToMany(mappedBy = "originalLanguage")
    private List<Film> originalLanguageFilms;
}
