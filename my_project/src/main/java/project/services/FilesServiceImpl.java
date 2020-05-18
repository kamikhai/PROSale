package project.services;

import lombok.extern.slf4j.Slf4j;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.rendering.ImageType;
//import org.apache.pdfbox.rendering.PDFRenderer;
//import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.dto.InformationDto;
import project.models.Document;
import project.models.User;
import project.repositories.DocumentsRepository;
import project.repositories.UsersRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Component
@Slf4j
public class FilesServiceImpl implements FilesService {

    private final static String FILES_PATH = "D:\\Универ\\2к2с\\project\\my_project\\files";
    private final static String CONVERTED_FILES_PATH = "D:\\Универ\\2к2с\\project\\my_project\\converted_files";

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private DocumentsRepository documentsRepository;

    @Override
    public void init() {
        User admin = usersRepository.getOne(1L);

        try (Stream<Path> filesPaths = Files.walk(Paths.get(FILES_PATH))) {
            filesPaths.filter(filePath -> filePath.toFile().isFile()).forEach(
                    filePath -> {
                        File file = filePath.toFile();
                        Document document = null;
                        try {
                            document = Document.builder()
                                    .owner(admin)
                                    .path(filePath.toString())
                                    .size(file.length())
                                    .type(Files.probeContentType(filePath))
                                    .build();
                        } catch (IOException e) {
                            throw new IllegalArgumentException(e);
                        }
                        documentsRepository.save(document);
                    }
            );
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Transactional
    @Override
    public List<Document> getPngForUser(Long userId) {
        User admin = usersRepository.getOne(userId);
        List<Document> documents = admin.getPngDocuments();
        System.out.println(documents);
        return documents;
    }


    @Override
    public InformationDto getInformation(Long userId) {
        return usersRepository.getInformationByUser(userId);
    }

}
