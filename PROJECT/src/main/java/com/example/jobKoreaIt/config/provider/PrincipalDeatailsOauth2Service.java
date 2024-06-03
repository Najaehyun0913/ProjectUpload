package com.example.jobKoreaIt.config.provider;

import com.example.jobKoreaIt.config.auth.provider.OAuth2UserInfo;
import com.example.jobKoreaIt.domain.common.entity.User;
import com.example.jobKoreaIt.domain.common.repository.UserRepository;
import com.example.jobKoreaIt.domain.seeker.dto.SeekerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Optional;

public class PrincipalDeatailsOauth2Service extends DefaultOAuth2UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{

        //OAuth2User INFO
        OAuth2User oAuth2User = super.loadUser(userRequest);

        //provider 선별
        String provider = userRequest.getClientRegistration().getRegistrationId();

        OAuth2UserInfo oAuth2UserInfo=null;


        //DB 조회
        String username=oAuth2UserInfo.getProvider()+"_"+oAuth2UserInfo.getProviderId();
        String password=passwordEncoder.encode("1234");

        Optional<User> userOptional = userRepository.findById(username);


        //최초 로그인시 (개인회원)
        SeekerDto seekerDto=null;

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole("ROLE_Seeker");
        user.setProvider(oAuth2UserInfo.getProvider());
        user.setProviderId(oAuth2UserInfo.getProviderId());
        userRepository.save(user);



    }
}
