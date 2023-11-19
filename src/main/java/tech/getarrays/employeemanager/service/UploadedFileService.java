package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.UploadedFile;
import tech.getarrays.employeemanager.repo.UploadedFileRepo;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UploadedFileService {
    private UploadedFileRepo uploadedFileRepo;

    @Autowired
    public UploadedFileService(UploadedFileRepo uploadedFileRepo) {
        this.uploadedFileRepo = uploadedFileRepo;
    }
 
    public UploadedFile addUploadedFile(UploadedFile uploadedFile) {
        return uploadedFileRepo.save(uploadedFile);
    }

    public List<UploadedFile> findAllUploadedFiles() {
        return uploadedFileRepo.findAll();
    }

    public UploadedFile updateUploadedFile(UploadedFile UploadFile) {
        return uploadedFileRepo.save(UploadFile);
    }

    public UploadedFile findUploadedFileById(Long id) {
        return uploadedFileRepo.findUploadedFileById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteUploadedFile(Long id){
        uploadedFileRepo.deleteUploadedFileById(id);
    }
}
