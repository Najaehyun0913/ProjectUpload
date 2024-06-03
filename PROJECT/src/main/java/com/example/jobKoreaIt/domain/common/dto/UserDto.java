package com.example.jobKoreaIt.domain.common.dto;


import com.example.jobKoreaIt.domain.offer.entity.JobOffer;
import com.example.jobKoreaIt.domain.seeker.entity.JobSeeker;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

	//OAUTH2
	private String provider;
	private String providerId;

	public UserDto(JobOffer offer) {
	}

	public UserDto(JobSeeker seeker) {
	}


//    //날짜
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private LocalDateTime rdate;
}