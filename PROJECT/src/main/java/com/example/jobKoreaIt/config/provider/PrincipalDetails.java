package com.example.jobKoreaIt.config.provider;

import com.example.jobKoreaIt.domain.common.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrincipalDetails implements UserDetails {

    private UserDto userDto;

    public  PrincipalDetails(UserDto userDto){
        this.userDto = userDto;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(userDto.getRole()));
    }

    @Override
    public String getPassword() {
        return "getPassword";
    }

    @Override
    public String getUsername() {
        return "getUsername";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
