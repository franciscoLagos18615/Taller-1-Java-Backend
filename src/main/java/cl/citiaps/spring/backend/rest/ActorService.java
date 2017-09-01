package cl.citiaps.spring.backend.rest;

import cl.citiaps.spring.backend.entities.Film;
import cl.citiaps.spring.backend.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.citiaps.spring.backend.entities.Actor;
import cl.citiaps.spring.backend.repository.ActorRepository;

import java.util.*;

@RestController  
@RequestMapping("/actors")
public class ActorService {
	
	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private FilmRepository filmRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Actor> getAllUsers() {
		return actorRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public  Actor findOne(@PathVariable("id") Integer id) {
		return actorRepository.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Actor create(@RequestBody Actor resource) {
	     return actorRepository.save(resource);
	}

	//Método GET que retorna todas las películas en las que participa un Actor en específico
	@RequestMapping(value = "/{id}/films", method = RequestMethod.GET)
	@ResponseBody
	public List<Film> filmsOfActor(@PathVariable("id") Integer id){
		Actor actor = actorRepository.findOne(id);
		List<Film> filmsResultantes = actor.getFilms();
		return filmsResultantes;
	}

}