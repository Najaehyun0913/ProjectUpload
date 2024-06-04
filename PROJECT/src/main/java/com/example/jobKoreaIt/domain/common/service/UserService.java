package com.example.jobKoreaIt.domain.common.service;


import com.example.jobKoreaIt.domain.common.dto.UserDto;

public interface UserService {

    UserDto loginSeeker(String username,String password);
    UserDto loginOffer(String username,String password);
    boolean JoinUser(UserDto userDto);

    //어떻게 나눠야하는가 개인회원 , 기업회원 ....을
    boolean UserJoin(UserDto userDto);
}
