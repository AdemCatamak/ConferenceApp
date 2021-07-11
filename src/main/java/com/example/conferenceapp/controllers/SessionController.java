package com.example.conferenceapp.controllers;


import com.example.conferenceapp.models.Session;
import com.example.conferenceapp.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController
{
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id)
    {
        return sessionRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody final Session session)
    {
        return sessionRepository.saveAndFlush(session);
    }
}
