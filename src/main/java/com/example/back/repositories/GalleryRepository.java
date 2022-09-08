package com.example.back.repositories;

import com.example.back.models.Gallery;
import com.example.back.models.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
    List<Gallery> getGalleriesByUsers(Users users);
}
