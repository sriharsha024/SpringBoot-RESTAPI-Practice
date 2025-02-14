package com.social.media.controllers;

import com.social.media.model.SocialUser;
import com.social.media.services.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SocialController {

    @Autowired
    private SocialService socialService;

    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getAllUsers() {
        List<SocialUser> users = socialService.getAllSocialUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/social/user")
    public ResponseEntity<SocialUser> createUser(@RequestBody SocialUser socialUser) {
        SocialUser createdUser = socialService.createSocialUser(socialUser);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/social/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        socialService.deleteSocialUser(id);
        return new ResponseEntity<>("Social User deleted successfully", HttpStatus.OK);
    }

}
