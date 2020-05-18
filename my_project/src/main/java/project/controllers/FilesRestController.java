package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.dto.InformationDto;
import project.models.Document;
import project.services.FilesService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FilesRestController {

    @Autowired
    private FilesService filesService;

    @GetMapping("/files/init")
    public ResponseEntity<?> init() {
        filesService.init();
        return ResponseEntity.ok().build();
    }

    @GetMapping("users/{user-id}/files/png")
    public ResponseEntity<List<Document>> getAllPngFilesForUser(@PathVariable("user-id") Long userId) {
        List<Document> documents = filesService.getPngForUser(userId);
        System.out.println(documents);
        return ResponseEntity.ok(documents);
    }

    @GetMapping("users/{user-id}/files/information")
    public ResponseEntity<InformationDto> getInformation(@PathVariable("user-id") Long userId) {
        InformationDto result = filesService.getInformation(userId);
        return ResponseEntity.ok(result);
    }

}
