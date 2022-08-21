package com.example.back.controllers;

import com.example.back.models.Gallery;
import com.example.back.models.dto.GalleryDTO;
import com.example.back.services.GalleryService;
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

    @GetMapping
    public ResponseEntity<List<Gallery>> getAllGalleries(Principal principal) {
        log.info("Get all galleries");
        log.info("Get all galleries for: " + principal.getName());
        log.info("Get all galleries for: " + principal.toString());
        return ResponseEntity.ok(galleryService.getAllGalleries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gallery> getGalleryById(@PathVariable Long id, Principal principal) {
        log.info("Get gallery id: " + id);
        log.info("New gallery for: " + principal.getName());
        return galleryService.getGalleryById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<Gallery> insertNewGallery(@RequestBody GalleryDTO galleryDTO, Principal principal) {
        log.info("New gallery for: " + principal.toString());
        return ResponseEntity.ok(galleryService.insertNewGallery(galleryDTO));
    }
}
