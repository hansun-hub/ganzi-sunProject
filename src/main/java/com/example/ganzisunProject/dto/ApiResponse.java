package com.example.ganzisunProject.dto;
//post의 response
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ApiResponse {
    private Boolean success;
    private Integer reservationId;
    private String message;

}
