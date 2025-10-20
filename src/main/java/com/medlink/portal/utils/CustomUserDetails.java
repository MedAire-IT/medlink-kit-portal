//package com.medlink.portal.utils;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
///**
// * TODO: Create Database Entities
// * Users: basic information about a user (id, email, isActive, password, registrationDate, userTypeId)
// * @ManyToOne(Casecade = CasecadeType.ALL)
// * @JoinColumn(name = "userTypeId", referenceColumnName = "userTypeId")
// * private UserType UserTypeId
// * UsersType: a user role (userTypeId, userTypeName)
// * @OneToMany(targetEntity = Users.class, mappedBy = "userTypeId", cascadeType.ALL)
// * private List<Users> users
// */
//
//public class CustomUserDetails implements UserDetails {
//
//    private Users user;
//
//    public CustomUserDetails(Users user) {
//        this.user = user;
//    }
//
//    //Return rhe roles and authorities of the given user.
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        UsersType usersType = user.getUserTypeId();
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(usersType.getUserTypeName()));
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getEmail();
//    }
//}
