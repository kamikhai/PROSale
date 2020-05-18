package project.services;

import project.dto.InformationDto;
import project.models.Document;

import java.util.List;

public interface FilesService {
    void init();

    List<Document> getPngForUser(Long userId);

    InformationDto getInformation(Long userId);
}

