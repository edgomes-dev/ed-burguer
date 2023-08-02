package com.edburguer.utils;

import com.edburguer.exception.BadRequestException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UploadImage {
    private static String FOLDER_PATH = "/home/ed/Documentos/edburguer-images/";
    public  static String upload(MultipartFile file) {
        if(file.isEmpty()) throw new BadRequestException("Arquivo vázio");

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
            String date = formatter.format(new Date());
            byte[] bytes = file.getBytes();
            Path path = Paths.get(FOLDER_PATH+date+file.getOriginalFilename());
            Files.write(path, bytes);

            return date+file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
