package com.orxanibrahim.resume_portal.service;

import com.orxanibrahim.resume_portal.model.MyUserDetails;
import com.orxanibrahim.resume_portal.model.User;
import com.orxanibrahim.resume_portal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        user.orElseThrow(()-> new UsernameNotFoundException("User not found : "+ username));
        /*
         * calling user details constructor and gets user which is mapped from UserRepository
         * */
        return user.map(MyUserDetails::new).get();

    }
}