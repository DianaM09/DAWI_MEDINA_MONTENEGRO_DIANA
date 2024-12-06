package pe.edu.i202030258.cl2_backoffice_mvc_medina_diana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.i202030258.cl2_backoffice_mvc_medina_diana.dto.FilmDetailDto;
import pe.edu.i202030258.cl2_backoffice_mvc_medina_diana.dto.FilmDto;
import pe.edu.i202030258.cl2_backoffice_mvc_medina_diana.service.MaintenanceService;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    // Ruta para mostrar todas las películas
    @GetMapping("/start")
    public String start(Model model) {
        List<FilmDto> films = maintenanceService.getAllFilms();
        model.addAttribute("films", films);
        return "maintenance";
    }

    // Ruta para ver detalles de una película
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.getFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance-detail";
    }

    // Ruta para editar una película
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.getFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance-edit";
    }

    // Ruta para confirmar la edición de una película
    @PostMapping("/edit-confirm")
    public String edit(@ModelAttribute FilmDetailDto filmDetailDto) {
        maintenanceService.updateFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }

    // Ruta para mostrar la vista de confirmación de eliminación
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.getFilmById(id);
        if (filmDetailDto == null) {
            return "redirect:/maintenance/start";
        }
        model.addAttribute("film", filmDetailDto);
        return "maintenance-delete-confirm";
    }

    // Ruta para confirmar la eliminación de una película
    @PostMapping("/delete-confirm/{id}")
    public String deleteConfirm(@PathVariable Integer id) {
        maintenanceService.deleteFilm(id);
        return "redirect:/maintenance/start";
    }

    // Ruta para crear una nueva película (muestra el formulario)
    @GetMapping("/create")
    public String create(Model model) {
        return "maintenance-create";  // Retorna la vista del formulario de creación
    }

    // Ruta para confirmar la creación de una película
    @PostMapping("/create-confirm")
    public String createConfirm(@ModelAttribute FilmDetailDto filmDetailDto) {
        maintenanceService.createFilm(filmDetailDto);
        return "redirect:/maintenance/start";  // Redirige al listado de películas
    }

    // Ruta para crear una nueva película vía API (si es necesario)
    @PostMapping("/create")
    public ResponseEntity<FilmDetailDto> createFilm(@RequestBody FilmDetailDto filmDetailDto) {
        FilmDetailDto createdFilm = maintenanceService.createFilm(filmDetailDto);
        return ResponseEntity.ok(createdFilm);
    }

    @GetMapping("/search")
    public String search(@RequestParam String title, Model model) {
        // Llama al servicio para buscar las películas por título
        List<FilmDto> films = maintenanceService.searchFilmsByTitle(title);

        // Agrega las películas encontradas al modelo
        model.addAttribute("films", films);
        return "maintenance";  // La misma vista que muestra todas las películas
    }

}
