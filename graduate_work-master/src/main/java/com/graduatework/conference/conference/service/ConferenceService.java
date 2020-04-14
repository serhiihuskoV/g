package com.graduatework.conference.conference.service;

import com.graduatework.conference.conference.model.Conference;
import com.graduatework.conference.conference.model.ConferenceDto;
import com.graduatework.conference.conference.repository.ConferenceRepository;
import com.graduatework.conference.location.service.LocationService;
import com.graduatework.conference.type.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConferenceService {
    private final ConferenceRepository conferenceRepository;
    private final TypeService typeService;
    private final LocationService locationService;

    @Autowired
    public ConferenceService(ConferenceRepository conferenceRepository,
                             TypeService typeService,
                             LocationService locationService) {
        this.conferenceRepository = conferenceRepository;
        this.typeService = typeService;
        this.locationService = locationService;
    }

    private Conference converter(ConferenceDto dto) {
        Conference conference = new Conference();
        if (dto.getId() != null) {
            conference.setId(dto.getId());
        }
        conference.setTitle(dto.getTitle());
        conference.setDescription(dto.getDescription());
        conference.setType(typeService.getTypeById(dto.getTypeId()));
        conference.setOrganizationTitle(dto.getOrganizationTitle());
        conference.setLocation(locationService.getLocationById(dto.getLocationId()));
        conference.setStartDate(dto.getStartDatetime());
        conference.setEndDate(dto.getEndDatetime());
        return conference;
    }

    public void addConference(ConferenceDto dto) {
        conferenceRepository.addConference(converter(dto));
    }

    public void updateConference(ConferenceDto dto) {
        conferenceRepository.updateConference(converter(dto));
    }

    public List<Conference> getAllConferences() {
        List<ConferenceDto> allConferences = conferenceRepository.getAllConferences();

        List<Conference> list = new ArrayList<>();
        for (ConferenceDto element : allConferences) {
            list.add(converter(element));
        }
        return list;
    }

    public void deleteConference(int conferenceId) {
        conferenceRepository.deleteConference(conferenceId);
    }
}