package com.graduatework.conference.type.service;

import com.graduatework.conference.type.model.Type;
import com.graduatework.conference.type.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {
    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Type getTypeById(int typeId) {
        return typeRepository.getTypeById(typeId);
    }
}