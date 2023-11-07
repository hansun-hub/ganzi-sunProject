package com.example.ganzisunProject.dto;

import com.example.ganzisunProject.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ReservationForm {

    private Long id;
    private String breadType; //빵종류
    private Integer quantity; //빵 갯수

    public Reservation toEntity() {
        return new Reservation(id, breadType, quantity);
    }
}
