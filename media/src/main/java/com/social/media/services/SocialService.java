package com.social.media.services;

import com.social.media.model.SocialUser;
import com.social.media.repositories.SocialUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {

    @Autowired
    private SocialUserRepo socialUserRepo;

    public List<SocialUser> getAllSocialUsers(){
        return socialUserRepo.findAll();
    }

    public SocialUser createSocialUser(SocialUser socialUser) {
        return socialUserRepo.save(socialUser);
    }

    public SocialUser deleteSocialUser(Long id) {
        SocialUser socialUser = socialUserRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Social user not found"));
        socialUserRepo.delete(socialUser);
        return socialUser;

    }
}
