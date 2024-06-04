package com.example.jobKoreaIt.domain.offer.entity;


import com.example.jobKoreaIt.domain.common.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
@Table(name="offer")
public class JobOffer{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String offerName;
    private String offerAddress;
    private String email;

    private String username;
    private String password;

    public void setUserName(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}