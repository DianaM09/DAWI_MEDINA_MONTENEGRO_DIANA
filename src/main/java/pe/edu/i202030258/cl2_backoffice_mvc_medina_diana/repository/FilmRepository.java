package pe.edu.i202030258.cl2_backoffice_mvc_medina_diana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pe.edu.i202030258.cl2_backoffice_mvc_medina_diana.entity.Film;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {

    // Método para buscar películas por título, ignorando mayúsculas y minúsculas
    List<Film> findByTitleContainingIgnoreCase(String title);
}