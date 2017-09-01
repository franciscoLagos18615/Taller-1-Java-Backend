package cl.citiaps.spring.backend.rest;

import cl.citiaps.spring.backend.entities.Actor;
import cl.citiaps.spring.backend.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.citiaps.spring.backend.entities.Film;
import cl.citiaps.spring.backend.repository.FilmRepository;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ActorRepository actorRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Film> getAllUsers() {
        return filmRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  Film findOne(@PathVariable("id") Integer id) {
        return filmRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Film create(@RequestBody Film resource) {
        return filmRepository.save(resource);
    }

    //Método GET que retorna todos los actores de una película en específico
    @RequestMapping(value = "/{id}/actors", method = RequestMethod.GET)
    @ResponseBody
    public List<Actor> actorsOfFilm(@PathVariable("id") Integer id){
        Film film = filmRepository.findOne(id);
        List<Actor> filmsResultantes = film.getActores();
        return filmsResultantes;
    }

    //films/1/actors/2 --> vincula el actor 2 a la película 1.
    @RequestMapping(value = "/{idFilm}/actors/{idActor}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Film vincula(@PathVariable("idFilm") Integer idFilm, @PathVariable("idActor") Integer idActor) {
        Actor actor = actorRepository.findOne(idActor);
        Film film = filmRepository.findOne(idFilm);
        film.addActor(actor);
        return filmRepository.save(film);
    }

}