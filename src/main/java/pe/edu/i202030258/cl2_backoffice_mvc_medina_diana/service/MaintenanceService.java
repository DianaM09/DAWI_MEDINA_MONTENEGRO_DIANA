package pe.edu.i202030258.cl2_backoffice_mvc_medina_diana.service;


import pe.edu.i202030258.cl2_backoffice_mvc_medina_diana.dto.FilmDetailDto;
import pe.edu.i202030258.cl2_backoffice_mvc_medina_diana.dto.FilmDto;

import java.util.List;

public interface MaintenanceService {

    List<FilmDto> getAllFilms();

    FilmDetailDto getFilmById(int id);

    Boolean updateFilm(FilmDetailDto filmDetailDto);

    Boolean deleteFilm(int id);

    FilmDetailDto createFilm(FilmDetailDto filmDetailDto);

    // Método para buscar películas por título
    List<FilmDto> searchFilmsByTitle(String title);



}