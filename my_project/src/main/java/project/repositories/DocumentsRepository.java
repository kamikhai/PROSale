package project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.models.Document;

public interface DocumentsRepository extends JpaRepository<Document, Long> {
}
