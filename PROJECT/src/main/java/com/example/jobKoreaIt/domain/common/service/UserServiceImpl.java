package com.example.jobKoreaIt.domain.common.service;


import com.example.jobKoreaIt.domain.common.dto.UserDto;
import com.example.jobKoreaIt.domain.common.repository.UserRepository;
import com.example.jobKoreaIt.domain.offer.entity.JobOffer;
import com.example.jobKoreaIt.domain.offer.repository.JobOfferRepository;
import com.example.jobKoreaIt.domain.seeker.entity.JobSeeker;
import com.example.jobKoreaIt.domain.seeker.repository.JobSeekerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JobSeekerRepository jobSeekerRepository;
    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Override
    public UserDto loginSeeker(String username, String password) {
        JobSeeker seeker = jobSeekerRepository.findByUsername(username);
        if (seeker != null && seeker.getPassword().equals(password)) {
            return new UserDto(seeker);
        }
        return null;
    }

    @Override
    public UserDto loginOffer(String username, String password) {
        JobOffer offer = jobOfferRepository.findByUsername(username);
        if (offer != null && offer.getPassword().equals(password)) {
            return new UserDto(offer);
        }
        return null;
    }

    @Override
    public boolean JoinUser(UserDto userDto) {
        return false;
    }


    //어떻게 나눠야하는가 개인회원 , 기업회원 ....을
    @Override
    public boolean UserJoin(UserDto userDto) {
        try {
            if ("seeker".equalsIgnoreCase(userDto.getType())) {
                JobSeeker seeker = new JobSeeker();
                seeker.setUsername(userDto.getUsername());
                seeker.setPassword(userDto.getPassword());
                seeker.setEmail(userDto.getEmail());
                jobSeekerRepository.save(seeker);
            } else if ("offer".equalsIgnoreCase(userDto.getType())) {
                JobOffer offer = new JobOffer();
                offer.setUserName(userDto.getUsername());
                offer.setPassword(userDto.getPassword());
                offer.setEmail(userDto.getEmail());
                jobOfferRepository.save(offer);
            } else {
                throw new IllegalArgumentException("Invalid user type");
            }
            return true;
        } catch (Exception e) {
            log.error("Failed to create user", e);
            return false;
        }
    }
}