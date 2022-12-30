package com.nava.homework.service;

import com.nava.homework.controller.dto.PictureDto;
import com.nava.homework.model.Picture;
import com.nava.homework.service.exeption.PictureNotFound;
import com.nava.homework.service.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PictureService {

    private final PictureRepository pictureRepository;
    private final ViewService viewService;


    public PictureService(PictureRepository pictureRepository, ViewService viewService) {
        this.pictureRepository = pictureRepository;
        this.viewService = viewService;
    }


    public Picture save(Picture picture) {
        if (picture.getView() == null) {
            picture.setView(viewService.save());
        }
        return pictureRepository.save(picture);
    }

    public Optional<Picture> findById(Long id) {
        return pictureRepository.findById(id);
    }


    public Optional<Picture> update(Long id, PictureDto pictureDto) {
        Optional<Picture> picture = findById(id);
        if (picture.isEmpty()) {
            return Optional.empty();
        }
        picture.get().setName(pictureDto.getName());
        picture.get().setAuthor(pictureDto.getAuthor());

        return Optional.of(pictureRepository.save(picture.get()));
    }


    public Optional<Picture> findPicture(Long id) {
        Optional<Picture> picture = findById(id);
        if (picture.isEmpty()) {
            return Optional.empty();
        }
        viewService.addToView(picture.get().getView());
        return picture;
    }

    public List<Picture> findAll() {
        return pictureRepository.findAll();
    }

    public boolean deletePicture(Long id) throws PictureNotFound {
        Optional<Picture> picture = pictureRepository.findById(id);
        if (picture.isPresent()) {
            pictureRepository.delete(picture.get());
            return true;
        }
        throw new PictureNotFound(id);
    }
}
