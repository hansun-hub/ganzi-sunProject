package com.example.ganzisunProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class DetailedResponse {
    private Boolean success;
    private Integer reservationId;
    private String breadType;
    private Integer quantity;
    private Date pickUpDate;
    private String pickUpTime;
    private String message;
}
