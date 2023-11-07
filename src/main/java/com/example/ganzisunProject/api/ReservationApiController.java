package com.example.ganzisunProject.api;

import com.example.ganzisunProject.dto.ReservationForm;
import com.example.ganzisunProject.entity.Article;
import com.example.ganzisunProject.entity.Reservation;
import com.example.ganzisunProject.repository.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ReservationApiController {
    @Autowired
    private ReservationRepository reservationRepository;

    //GET
    @GetMapping("/api/reservations")
    public List<Reservation> index(){
        return reservationRepository.findAll();
    }

    //상세 GET
    @GetMapping("/api/reservations/{id}")
    public Reservation show(@PathVariable Long id){
        return reservationRepository.findById(id).orElse(null);
    }

    //POST
    @PostMapping("/api/reservations")
    public Reservation create(@RequestBody ReservationForm dto){
        //1. DTO를 엔티티로 변환
        Reservation reservation= dto.toEntity();
        //2. 리파지터리로 엔티티를 DB에 저장
        //Reservation saved = reservationRepository.save(reservation);
        return reservationRepository.save(reservation);
    }
}
