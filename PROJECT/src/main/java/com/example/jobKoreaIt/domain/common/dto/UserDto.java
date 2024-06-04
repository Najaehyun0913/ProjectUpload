package com.example.jobKoreaIt.domain.common.dto;


import com.example.jobKoreaIt.domain.offer.entity.JobOffer;
import com.example.jobKoreaIt.domain.seeker.entity.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	private String username;
	private String password;
	private String repassword;
	private String role;
	private String type; // "seeker" 와 "offer" 회원가입시 기준을 나누기 위한
	private String email;



	//OAUTH2
	private String provider;
	private String providerId;

	public UserDto(JobOffer offer) {
		this.username = offer.getOfferName();
		this.password = (String) offer.getPassword();
		this.type = "offer";
	}

	public UserDto(JobSeeker seeker) {
		this.username = seeker.getUsername();
		this.password = (String) seeker.getPassword();

		this.type = "seeker";
	}


//    //날짜
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private LocalDateTime rdate;
}