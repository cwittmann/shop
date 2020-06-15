package com.shop.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import com.shop.model.Image;
import com.shop.repository.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @PostMapping("/images")
    public ResponseEntity postImage(@RequestParam("imageFile") MultipartFile file, @RequestParam("id") String id)
            throws IOException {

        Image image = new Image(id, compressBytes(file.getBytes()));
        imageRepository.save(image);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/images")
    public List<Image> getImages() throws IOException {
        List<Image> retrievedImages = imageRepository.findAll();
        List<Image> decompressedImages = new ArrayList<Image>();

        for (Image retrievedImage : retrievedImages) {
            Image image = new Image(retrievedImage.id, decompressBytes(retrievedImage.data));
            decompressedImages.add(image);
        }

        return decompressedImages;
    }

    @GetMapping("/images/{id}")
    public Image getImage(@PathVariable String id) throws IOException {
        final Optional<Image> retrievedImage = imageRepository.findById(id);

        Image image = new Image(id, decompressBytes(retrievedImage.get().data));

        return image;
    }

    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];

        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }

        try {
            outputStream.close();

        } catch (IOException e) {

        }

        return outputStream.toByteArray();

    }

    public static byte[] decompressBytes(byte[] data) {

        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];

        try {

            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);

            }

            outputStream.close();

        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }

        return outputStream.toByteArray();
    }
}