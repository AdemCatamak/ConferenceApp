package com.example.conferenceapp.controllers;

import com.example.conferenceapp.models.Speaker;
import com.example.conferenceapp.repositories.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakerController
{
    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> get()
    {
        List<Speaker> speakers = speakerRepository.findAll();
        return speakers;
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id)
    {
        Speaker speaker = speakerRepository.getById(id);
        return speaker;
    }
}
