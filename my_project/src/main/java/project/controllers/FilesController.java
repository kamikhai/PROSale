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
import org.springframework.web.servlet.ModelAndView;
import project.services.FileService;

@Controller
public class FilesController {
    @Autowired
    private FileService fileService;


    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/files", method = RequestMethod.POST)
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return ResponseEntity.ok().body(fileService.save(multipartFile, email));
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/files/{file-name:.+}", method = RequestMethod.GET)
    ResponseEntity<Resource> read(@PathVariable("file-name") String fileName) {
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(fileService.get(fileName));
    }


    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/storage", method = RequestMethod.GET)
    public ModelAndView getStoragePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("file_upload");
        return modelAndView;
    }

}
