package com.example.backend.mapppers;


import com.example.backend.dtos.GymRecordDto;
import com.example.backend.entities.GymRecord;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GymRecordMappers {


// this method used to hide some data from user like i didnt want to show all db dtata so i wanted mapper to only show what i needed
//this mapper maps the dto and db


    //map entitiy to dto
GymRecord toGymRecord(GymRecordDto dto);

//dto to entity
GymRecordDto toGymRecordDto(GymRecord gymRecord);

List<GymRecordDto> toGymRecordDtos(List<GymRecord> gymRecords);


}
