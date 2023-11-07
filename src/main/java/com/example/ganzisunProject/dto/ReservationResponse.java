package com.example.ganzisunProject.dto;
//get 예약 목록 조회 response


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReservationResponse {
    private Boolean success;
    private Integer reservationId;
    private String message;

    // 성공한 응답을 위한 편의 생성자
    public ReservationResponse(Integer reservationId) {
        this.success = true;
        this.reservationId = reservationId;
        this.message = "조회 성공";
    }

    // 실패한 응답을 위한 편의 생성자
    public ReservationResponse(String message) {
        this.success = false;
        this.reservationId = null;
        this.message = message;
    }
}
