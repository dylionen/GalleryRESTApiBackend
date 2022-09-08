package com.example.back.controllers;

import com.example.back.models.Gallery;
import com.example.back.models.dto.GalleryDTO;
import com.example.back.models.user.Users;
import com.example.back.services.GalleryService;
import com.example.back.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/gallery")
public class GalleryController {

    private final GalleryService galleryService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<Gallery>> getMyGalleries(Principal principal) {
        Users users = userService.getUserByUsername(principal.getName());
        return ResponseEntity.ok(galleryService.getMyAllGalleries(users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gallery> getGalleryById(@PathVariable Long id, Principal principal) {
        return galleryService.getGalleryById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<Gallery> insertNewGallery(@RequestBody GalleryDTO galleryDTO, Principal principal) {
        Users users = userService.getUserByUsername(principal.getName());
        return ResponseEntity.ok(galleryService.insertNewGallery(galleryDTO,users));
    }
}
