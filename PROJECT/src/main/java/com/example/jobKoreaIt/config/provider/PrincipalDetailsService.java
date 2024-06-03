package com.example.jobKoreaIt.config.provider;

import com.example.jobKoreaIt.domain.offer.dto.OfferDto;
import com.example.jobKoreaIt.domain.seeker.dto.SeekerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrincipalDetailsService implements UserDetails, OAuth2User {

    private OfferDto offerDto;
    private SeekerDto seekerDto;

    public void PrincipalDetails(OfferDto offerDto) {this.offerDto = offerDto}
    //-----------------------------------
    //OAUTH2
    //-----------------------------------
    private String accessToken;
    private Map<String,Object> attributes;
    @Override
    public Map<String,Object> getAttributes()


    @Override
    public String getName() {
        return "";
    }

    @Override
    public Map<String, Object> getAttributes() {
        return Map.of();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
