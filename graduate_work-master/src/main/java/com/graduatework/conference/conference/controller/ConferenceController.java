package com.graduatework.conference.conference.controller;

import com.graduatework.conference.conference.model.Conference;
import com.graduatework.conference.conference.model.ConferenceDto;
import com.graduatework.conference.conference.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/conference")
public class ConferenceController {
    private final ConferenceService conferenceService;

    @Autowired
    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping
    public List<Conference> getAllConferences() {
        return conferenceService.getAllConferences();
    }

    @PostMapping
    public void addConference(@RequestBody ConferenceDto dto) {
        conferenceService.addConference(dto);
    }

    @PutMapping
    public void updateConference(@RequestBody ConferenceDto dto) {
        conferenceService.updateConference(dto);
    }

    @DeleteMapping
    public void deleteConference(@RequestParam int conferenceId) {
        conferenceService.deleteConference(conferenceId);
    }
}