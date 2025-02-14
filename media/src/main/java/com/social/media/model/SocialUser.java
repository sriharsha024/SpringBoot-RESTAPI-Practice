package com.social.media.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "socialUser",cascade = {CascadeType.REMOVE,CascadeType.PERSIST, CascadeType.MERGE})
    //@JoinColumn(name = "social_profile_id")
    private SocialProfile socialProfile;

    @OneToMany(mappedBy = "socialUser", cascade = {CascadeType.REMOVE,CascadeType.PERSIST, CascadeType.MERGE},fetch= FetchType.EAGER)//overwritten
    private List<SocialPost> posts=new ArrayList<>();

    @ManyToMany(fetch= FetchType.EAGER)//overwritten
    @JoinTable(
            name="user_group",
            joinColumns = @JoinColumn(name="social_user_id"),
            inverseJoinColumns=@JoinColumn(name = "social_group_id")
    )
    private Set<SocialGroup> groups=new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(id);  // Only use unique identifier (id) to avoid recursion
    }

    public void SocialProfile(SocialProfile socialProfile) {
        socialProfile.setSocialUser(this);
        this.socialProfile = socialProfile;
    }

    /*
    1 to 1 eager
    many to 1 eager
    1 to many lazy
    many to many lazy
     */

}
