package com.example.ganzisunProject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Controller;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String breadType;
    @Column
    private Integer quantity;

    @Temporal(TemporalType.DATE) // Assuming you want just the date part
    private Date pickUpDate;

    @Column// pickUpTime is required
    private String pickUpTime;

}
