package com.example.ganzisunProject.api;

import com.example.ganzisunProject.dto.ApiResponse;
import com.example.ganzisunProject.dto.DetailedResponse;
import com.example.ganzisunProject.dto.ReservationForm;
import com.example.ganzisunProject.dto.ReservationResponse;
import com.example.ganzisunProject.entity.Article;
import com.example.ganzisunProject.entity.Reservation;
import com.example.ganzisunProject.repository.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class ReservationApiController {
    @Autowired
    private ReservationRepository reservationRepository;

    //GET
//    @GetMapping("/api/reservations")
//    public List<Reservation> index(){
//        return reservationRepository.findAll();
//    }
    @GetMapping("/api/reservations")
    public ResponseEntity<List<ReservationResponse>> getReservations() {
        try {
            List<Reservation> reservations = reservationRepository.findAll();

            List<ReservationResponse> responseList = reservations.stream()
                    .map(reservation -> new ReservationResponse(reservation.getId().intValue()))
                    .collect(Collectors.toList());

            return ResponseEntity.ok(responseList);
        } catch (Exception e) {
            // 예외가 발생했을 때의 응답 처리
            ReservationResponse errorResponse = new ReservationResponse("조회 중 오류가 발생했습니다: " + e.getMessage());
            return ResponseEntity.badRequest().body(List.of(errorResponse));
        }
    }

    //상세 GET
//    @GetMapping("/api/reservations/{id}")
//    public Reservation show(@PathVariable Long id){
//        return reservationRepository.findById(id).orElse(null);
//    }
    @GetMapping("/api/reservations/{id}")
    public ResponseEntity<DetailedResponse> show(@PathVariable Long id) {
        return reservationRepository.findById(id)
                .map(reservation -> new DetailedResponse(
                        true,
                        reservation.getId().intValue(),
                        reservation.getBreadType(),
                        reservation.getQuantity(),
                        reservation.getPickUpDate(),
                        reservation.getPickUpTime(),
                        "예약 조회 성공"
                ))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ok(new DetailedResponse(
                        false,
                        null,
                        null,
                        null,
                        null,
                        null,
                        "해당 ID로 예약을 찾을 수 없습니다."
                )));
    }



    //POST
//    @PostMapping("/api/reservations")
//    public Reservation create(@RequestBody ReservationForm dto){
//        //1. DTO를 엔티티로 변환
//        Reservation reservation= dto.toEntity();
//        //2. 리파지터리로 엔티티를 DB에 저장
//        //Reservation saved = reservationRepository.save(reservation);
//        return reservationRepository.save(reservation);
//    }

    @PostMapping("/api/reservations")
    public ResponseEntity<ApiResponse> create(@RequestBody ReservationForm dto) {
        try {
            // DTO를 엔티티로 변환
            Reservation reservation = dto.toEntity();
            // 리파지터리로 엔티티를 DB에 저장
            Reservation saved = reservationRepository.save(reservation);
            // 성공 응답 반환
            ApiResponse apiResponse = new ApiResponse(true, saved.getId().intValue(), "예약이 성공적으로 생성되었습니다.");
            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            // 실패 응답 반환
            ApiResponse apiResponse = new ApiResponse(false, null, "예약 생성에 실패했습니다: " + e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
        }
    }
}
