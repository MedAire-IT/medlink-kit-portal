//package com.medlink.portal.service;
//
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class CustomUserDetailsService implements UserDetailsService {
//
//    //make use of constructor injection
//    private final UsersRepository usersRepository;
//
//    /**
//     * Tell Spring Security how to retrieve the users from the database
//     * @param username
//     * @return
//     * @throws UsernameNotFoundException
//     */
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = usersRepository.findbyEmail(username).orElseThrow(()-> new UsernameNotFoundException("Could not found user"))
//        return new CustomUserDetails(user);
//    }
//}
