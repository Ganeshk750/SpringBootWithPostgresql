package com.ganesh.controller;

import com.ganesh.model.Speaker;
import com.ganesh.repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepo;

    @GetMapping
    public List<Speaker> list(){
        return speakerRepo.findAll();
    }
    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return  speakerRepo.getOne(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker){
        return speakerRepo.saveAndFlush(speaker);
    }

    @RequestMapping(value="{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        speakerRepo.deleteById(id);
    }

    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){
        Speaker existingSpeaker = speakerRepo.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepo.saveAndFlush(existingSpeaker);
    }
}
