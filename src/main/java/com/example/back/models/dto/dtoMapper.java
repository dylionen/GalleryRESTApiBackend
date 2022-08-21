package com.example.back.models.dto;

import com.example.back.models.Gallery;
import com.example.back.models.user.Users;

import java.time.LocalDateTime;

public class dtoMapper {
    public static Gallery mapGalleryDTOToGallery(GalleryDTO galleryDTO) {
        return Gallery.builder()
                .shortName(galleryDTO.getShortName())
                .longName(galleryDTO.getLongName())
                .createdDate(LocalDateTime.now())
                .build();
    }

    public static Users mapUserDTOToUsers(UserDTO userDTO) {
        return Users.builder()
                .userName(userDTO.getUserName())
                .password(userDTO.getPassword())
                .mailAddress(userDTO.getMailAddress())
                .build();
    }
}
