package com.example.conferenceapp.controllers;


import com.example.conferenceapp.models.Session;
import com.example.conferenceapp.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController
{
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list()
    {
        List<Session> sessions = sessionRepository.findAll();
        return sessions;
    }

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

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id)
    {
        // Also need to check for children records before deleting
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session)
    {
        // TODO: Add validation that all attributes are passed in, otherwise return 400
        Session existingSession = sessionRepository.getById(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }


}
