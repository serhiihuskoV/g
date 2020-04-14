package com.graduatework.conference.search.service;

import com.graduatework.conference.conference.model.Conference;
import com.graduatework.conference.conference.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private final ConferenceService conferenceService;

    @Autowired
    public SearchService(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    public List<Conference> searchByAnyCriteria(String word) {
        word = word.toLowerCase();

        List<Conference> foundedConferences = new ArrayList<>();
        for (Conference element : conferenceService.getAllConferences()) {
            if (element.getTitle().toLowerCase().contains(word)) {
                foundedConferences.add(element);
            } else if (element.getDescription().toLowerCase().contains(word)) {
                foundedConferences.add(element);
            } else if (element.getStartDate().contains(word)) {
                foundedConferences.add(element);
            } else if (element.getType().getTitle().toLowerCase().contains(word)) {
                foundedConferences.add(element);
            } else if (element.getOrganizationTitle().toLowerCase().contains(word)) {
                foundedConferences.add(element);
            } else if (element.getLocation().getCity().toLowerCase().contains(word)) {
                foundedConferences.add(element);
            } else if (element.getLocation().getCountry().toLowerCase().contains(word)) {
                foundedConferences.add(element);
            }
        }
        return foundedConferences;
    }
}