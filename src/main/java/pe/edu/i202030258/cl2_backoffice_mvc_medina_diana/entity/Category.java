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
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String name;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @OneToMany(mappedBy = "category")
    private List<FilmCategory> filmCategories;
}
