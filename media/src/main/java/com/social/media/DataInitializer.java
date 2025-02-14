package com.social.media;

import com.social.media.model.SocialPost;
import com.social.media.repositories.SocialPostRepo;
import com.social.media.repositories.SocialProfileRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.social.media.model.SocialGroup;
import com.social.media.model.SocialProfile;
import com.social.media.model.SocialUser;
import com.social.media.repositories.SocialGroupRepo;
import com.social.media.repositories.SocialUserRepo;

@Configuration
public class DataInitializer {

    private final SocialUserRepo socialUserRepo;
    private final SocialGroupRepo socialGroupRepo;
    private final SocialProfileRepo socialProfileRepo;
    private final SocialPostRepo socialPostRepo;

    public DataInitializer(SocialUserRepo socialUserRepo, SocialGroupRepo socialGroupRepo, SocialProfileRepo socialProfileRepo, SocialPostRepo socialPostRepo) {
        this.socialUserRepo = socialUserRepo;
        this.socialGroupRepo = socialGroupRepo;
        this.socialProfileRepo = socialProfileRepo;
        this.socialPostRepo = socialPostRepo;
    }

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            // Create some users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            // Save users to the database
            socialUserRepo.save(user1);
            socialUserRepo.save(user2);
            socialUserRepo.save(user3);

            // Create some groups
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            // Add users to groups
            group1.getSocialUsers().add(user1);
            group1.getSocialUsers().add(user2);

            group2.getSocialUsers().add(user2);
            group2.getSocialUsers().add(user3);

            // Save groups to the database
            socialGroupRepo.save(group1);
            socialGroupRepo.save(group2);

            // Associate users with groups
            user1.getGroups().add(group1);
            user2.getGroups().add(group1);
            user2.getGroups().add(group2);
            user3.getGroups().add(group2);

            // Save users back to database to update associations
            socialUserRepo.save(user1);
            socialUserRepo.save(user2);
            socialUserRepo.save(user3);


            // Create some posts
            SocialPost post1 = new SocialPost();
            SocialPost post2 = new SocialPost();
            SocialPost post3 = new SocialPost();

            // Associate posts with users
            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);

            // Save posts to the database (assuming you have a PostRepository)
            socialPostRepo.save(post1);
            socialPostRepo.save(post2);
            socialPostRepo.save(post3);

            // Create some social profiles
            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            // Associate profiles with users
            profile1.setSocialUser(user1);
            profile2.setSocialUser(user2);
            profile3.setSocialUser(user3);

            // Save profiles to the database (assuming you have a SocialProfileRepository)
            socialProfileRepo.save(profile1);
            socialProfileRepo.save(profile2);
            socialProfileRepo.save(profile3);

            //FETCH TYPES
            System.out.println("Fetching Social User");
            socialUserRepo.findById(1L);

        };
    }
}
