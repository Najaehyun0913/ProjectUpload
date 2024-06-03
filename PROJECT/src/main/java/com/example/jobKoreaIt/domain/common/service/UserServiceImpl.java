package com.example.jobKoreaIt.domain.common.service;


import com.example.jobKoreaIt.domain.common.dto.UserDto;
import com.example.jobKoreaIt.domain.common.entity.User;
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

    public UserDto loginSeeker(String username, String password) {
        JobSeeker seeker = jobSeekerRepository.findByUsername(username);
        if (seeker != null && seeker.getPassword().equals(password)) {
            return new UserDto(seeker);
        }
        return null;
    }

    public UserDto loginOffer(String username, String password) {
        JobOffer offer = jobOfferRepository.findByUsername(username);
        if (offer != null && offer.getPassword().equals(password)) {
            return new UserDto(offer);
        }
        return null;
    }
}
