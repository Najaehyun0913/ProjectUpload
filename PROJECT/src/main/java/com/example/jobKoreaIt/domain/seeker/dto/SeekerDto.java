package com.example.jobKoreaIt.domain.seeker.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Builder
@Table(name="seeker")
public class SeekerDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tel;
    private String zipcode;
    private String addr1;
    private String addr2;
}
