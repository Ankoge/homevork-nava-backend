package com.nava.homework.service;

import com.nava.homework.model.View;
import com.nava.homework.service.repository.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewService {
    private final ViewRepository viewRepository;

    @Autowired
    public ViewService(ViewRepository viewRepository) {
        this.viewRepository = viewRepository;
    }

    public View save() {
        View view = View.builder().build();
        return viewRepository.save(view);
    }


    public void addToView(View view) {
        view.setViews(view.getViews()+1);
        viewRepository.save(view);
    }
}
