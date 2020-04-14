package com.graduatework.conference.location.service;

import com.graduatework.conference.location.model.Location;
import com.graduatework.conference.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location getLocationById(int locationId) {
        return locationRepository.getLocationById(locationId);
    }
}