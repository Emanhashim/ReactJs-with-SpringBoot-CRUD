package com.example.backend.services;


import com.example.backend.entities.GymRecord;
import com.example.backend.exceptions.AppException;
import com.example.backend.mapppers.GymRecordMappers;
import com.example.backend.repositories.GymRecordsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.backend.dtos.GymRecordDto;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Recordservices {


    private final GymRecordsRepository gymRecordsRepository;
    private final GymRecordMappers gymRecordMappers;


    public List<GymRecordDto> allRecords(){

    return gymRecordMappers.toGymRecordDtos(gymRecordsRepository.findAll());
    }

    public GymRecordDto createGymRecord(GymRecordDto gymRecordDto){
        GymRecord  gymRecord = gymRecordMappers.toGymRecord(gymRecordDto);

        GymRecord createdGymRecord = gymRecordsRepository.save(gymRecord);
        return gymRecordMappers.toGymRecordDto(createdGymRecord);
    }

    public GymRecordDto deleteRecord(Long id){
        GymRecord gymRecord = gymRecordsRepository.findById(id)
        .orElseThrow(() -> new AppException("Gym Record Not Found", HttpStatus.NOT_FOUND));

        GymRecordDto gymRecordDto = gymRecordMappers.toGymRecordDto(gymRecord);
        gymRecordsRepository.deleteById(id);

        return gymRecordDto;
    }







}
