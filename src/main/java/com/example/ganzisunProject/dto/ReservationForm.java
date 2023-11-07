package com.example.ganzisunProject.dto;

import com.example.ganzisunProject.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReservationForm {

    private Long id;
    private String breadType; //빵종류
    private Integer quantity; //빵 수량
    private Date pickUpDate; // 수령 날짜
    private String pickUpTime; // 수령 시간

    public Reservation toEntity() {
        return new Reservation(id, breadType, quantity, pickUpDate, pickUpTime);
    }
}
