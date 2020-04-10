package com.ganesh.controller;

import com.ganesh.model.Session;
import com.ganesh.repository.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepo;

    @GetMapping
    public List<Session> list(){
        return sessionRepo.findAll();
    }
    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return  sessionRepo.getOne(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session){
        return sessionRepo.saveAndFlush(session);
    }

    @RequestMapping(value="{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        sessionRepo.deleteById(id);
    }

    public Session update(@PathVariable Long id, @RequestBody Session session){
        Session existingSession = sessionRepo.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepo.saveAndFlush(existingSession);
    }
}
