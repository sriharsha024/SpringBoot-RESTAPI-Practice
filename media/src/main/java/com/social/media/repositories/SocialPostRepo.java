package com.social.media.repositories;

import com.social.media.model.SocialPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialPostRepo extends JpaRepository<SocialPost, Long> {
}
