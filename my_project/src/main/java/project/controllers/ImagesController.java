package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.services.ImageService;

@Controller
public class ImagesController {
    @Autowired
    private ImageService imageService;


    @PreAuthorize("permitAll()")
    @PostMapping("/files")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        System.out.println(email);
        return ResponseEntity.ok().body(imageService.save(multipartFile, email));
    }


    @PreAuthorize("permitAll()")
    @GetMapping("/files/{file-name:.+}")
    public ResponseEntity<Resource> read(@PathVariable("file-name") String fileName) {
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageService.get(fileName));
    }


    @PreAuthorize("permitAll()")
    @GetMapping("/storage")
    public String getStoragePage(Authentication authentication) {
        System.out.println(authentication);
        return "file_upload";
    }

}
