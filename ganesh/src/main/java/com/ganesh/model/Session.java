package com.ganesh.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name="sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long session_id;
    private String session_name;
    private String session_description;
    private Integer session_length;
    @ManyToMany
    @JoinTable(name="session_speakers", joinColumns = @JoinColumn(name="session_id"),
    inverseJoinColumns = @JoinColumn(name="speaker_id"))
    private List<Speaker> speakers;


    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public Session() {
    }


}
