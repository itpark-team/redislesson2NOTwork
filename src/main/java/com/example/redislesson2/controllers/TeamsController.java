package com.example.redislesson2.controllers;

import com.example.redislesson2.models.Team;
import com.example.redislesson2.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/teams")
public class TeamsController {

    private TeamsRepository teamsRepository;

    public TeamsController(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }

    @PostMapping(value = "/add")
    public void add(Team team) {
        teamsRepository.add(team);
    }

    @GetMapping(value = "/get-all")
    public List<Team> getAll() {
        return teamsRepository.getAll();
    }

    @GetMapping(value = "/get-by-id/{id}")
    public Team getById(@PathVariable int id) {
        return teamsRepository.getById(id);
    }

}
