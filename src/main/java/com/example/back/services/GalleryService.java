package com.example.back.services;

import com.example.back.models.Gallery;
import com.example.back.models.dto.GalleryDTO;
import com.example.back.models.dto.dtoMapper;
import com.example.back.models.user.Users;
import com.example.back.repositories.GalleryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GalleryService {
    public final GalleryRepository galleryRepository;

    public List<Gallery> getMyAllGalleries(Users users) {
        return galleryRepository.getGalleriesByUsers(users);
    }

    public Optional<Gallery> getGalleryById(Long id) {
        return galleryRepository.findById(id);
    }

    @Transactional
    public Gallery insertNewGallery(GalleryDTO galleryDTO, Users users) {
        return galleryRepository.save(dtoMapper.mapGalleryDTOToGallery(galleryDTO, users));
    }
}
