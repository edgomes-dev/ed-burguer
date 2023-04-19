package com.edburguer.service;

import com.edburguer.dto.FirebaseImageDto;
import com.edburguer.exception.BadRequestException;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FirebaseService {
    private FirebaseImageDto imageDto;
    private MultipartFile file;

    public FirebaseService(@RequestParam MultipartFile file) {
        this.file = file;
    }
    public String uploadImage() {
        String URI = "http://localhost:3333/firebase";

        RestTemplate restTemplate = new RestTemplate();

        if(!file.isEmpty()) {
            try {
                this.imageDto = restTemplate.postForObject(URI, file, FirebaseImageDto.class);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else {
            throw new BadRequestException("Imagem não enviada");
        }


        return imageDto.data;
    }
}