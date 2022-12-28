package com.nava.homework.controller;

import com.nava.homework.controller.dto.PictureDto;
import com.nava.homework.model.Picture;
import com.nava.homework.service.PictureService;
import com.nava.homework.service.exeption.PictureNotFound;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class PictureController {
    private final PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping("/picture")
    public @ResponseBody List<Picture> findAllPictures() {
        return pictureService.findAll();
    }

    @GetMapping("/picture/{id}")
    public ResponseEntity<Picture> findPicture(@PathVariable Long id) {
        Optional<Picture> picture = pictureService.findPicture(id);
        if (picture.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(picture.get(), HttpStatus.OK);
    }

    @PutMapping("/picture/{id}/update")
    public ResponseEntity<Picture> updatePicture(@PathVariable Long id, @RequestBody PictureDto pictureDto) {
        Optional<Picture> picture = pictureService.update(id, pictureDto);
        if (picture.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(picture.get(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/picture/{id}/delete")
    public void deletePicture(@PathVariable Long id, HttpServletResponse response) {
        try {
            pictureService.deletePicture(id);
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (PictureNotFound exception) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } catch (Throwable exception){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }
}

