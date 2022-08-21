package com.example.back.models.dto;

import com.example.back.models.Gallery;

import java.time.LocalDateTime;

public class dtoMapper {
    public static Gallery mapGalleryDTOToGallery(GalleryDTO galleryDTO) {
        return Gallery.builder()
                .shortName(galleryDTO.getShortName())
                .longName(galleryDTO.getLongName())
                .createdDate(LocalDateTime.now())
                .build();
    }
}
