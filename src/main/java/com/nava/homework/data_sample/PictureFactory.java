package com.nava.homework.data_sample;

import com.nava.homework.model.Picture;
import com.nava.homework.service.PictureService;
import com.nava.homework.service.repository.PictureRepository;
import org.springframework.stereotype.Component;

@Component
public class PictureFactory {
    private final PictureService pictureService;

    public PictureFactory(PictureService pictureService, PictureRepository repository) {
        this.pictureService = pictureService;

        if (repository.count() == 0) {
            initialize();
        }
    }

    private void initialize() {
        pictureService.save(Picture.builder()
                .name("Járműipar - Ikarus autóbusz")
                .author("Gere László")
                .build());

        pictureService.save(Picture.builder()
                .name("Járműipar Háborús bűnösök - Szálasi Ferenc")
                .author("Reismann Mariann")
                .build());
        pictureService.save(Picture.builder()
                .name("Légi közlekedés - Húsz éves a Ferihegyi repülőtér")
                .author("Bara István")
                .build());
        pictureService.save(Picture.builder()
                .name("Vállalat - Autóbuszmodellek készülnek a Fővárosi Autóbuszüzemben")
                .author("Pálfai Gábor")
                .build());
        pictureService.save(Picture.builder()
                .name("Közlekedés - Budapest - A MÁV modern személyvonata")
                .author("Faludi Imre")
                .build());
    }


}
