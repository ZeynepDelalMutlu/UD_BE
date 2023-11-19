package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.UploadedFile;

import java.util.Optional;


public interface UploadedFileRepo extends JpaRepository<UploadedFile, Long> {
    void deleteUploadedFileById(Long id);
    Optional<UploadedFile> findUploadedFileById(Long id);
}
