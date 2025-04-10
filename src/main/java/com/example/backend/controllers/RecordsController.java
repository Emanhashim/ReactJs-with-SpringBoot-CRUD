package com.example.backend.controllers;


import com.example.backend.dtos.GymRecordDto;
import com.example.backend.entities.GymRecord;
import com.example.backend.services.Recordservices;
import lombok.RequiredArgsConstructor;
import org.mapstruct.ap.internal.util.Services;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class RecordsController {

    private final Recordservices recordservices;
    @GetMapping("/gym/records")
    public ResponseEntity<List<GymRecordDto>> allRecords(){
        return ResponseEntity.ok(recordservices.allRecords());

    }

    @PostMapping("/gym/records")

    public ResponseEntity<GymRecordDto> createGymRecord(@RequestBody GymRecordDto gymRecordDto){
        GymRecordDto createdGymRecord = recordservices.createGymRecord(gymRecordDto);
        return ResponseEntity.created(URI.create("/gym/records/" + createdGymRecord.getId()))
                .body(createdGymRecord);

    }


    @DeleteMapping("/gym/records/{id}")
    public ResponseEntity<GymRecordDto> deleteGymRecord(@PathVariable Long id){
        return ResponseEntity.ok(recordservices.deleteRecord(id));
    }

}
