package pe.edu.i202030258.cl2_backoffice_mvc_medina_diana.dto;

import java.time.LocalDateTime;
import java.util.Date;

public record FilmDetailDto(Integer filmId,
                            String title,
                            String description,
                            Integer releaseYear,
                            Integer languageId,
                            String languageName,
                            Integer rentalDuration,
                            Double rentalRate,
                            Integer length,
                            Double replacementCost,
                            String rating,
                            String specialFeatures,
                            LocalDateTime lastUpdate) {


}
