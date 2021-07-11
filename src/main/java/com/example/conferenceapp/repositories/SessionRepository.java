package com.example.conferenceapp.repositories;

import com.example.conferenceapp.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long>
{
}
