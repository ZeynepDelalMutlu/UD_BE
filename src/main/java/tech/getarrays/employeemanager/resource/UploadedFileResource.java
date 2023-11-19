package tech.getarrays.employeemanager.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.UploadedFile;
import tech.getarrays.employeemanager.service.UploadedFileService;

import java.util.List;

@RestController
@RequestMapping("/uploadedfile")
public class UploadedFileResource {
    private final UploadedFileService uploadedFileService;

    public UploadedFileResource(UploadedFileService uploadedFileService) {
        this.uploadedFileService = uploadedFileService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UploadedFile>> getAllUploadedFiles () {
        List<UploadedFile> employees = uploadedFileService.findAllUploadedFiles();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UploadedFile> getUploadedFileByName (@PathVariable("id") Long id) {
        UploadedFile employee = uploadedFileService.findUploadedFileById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UploadedFile> addUploadedFile(@RequestBody UploadedFile uploadedFile) {
        UploadedFile newUploadedFile = uploadedFileService.addUploadedFile(uploadedFile);
        return new ResponseEntity<>(newUploadedFile, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UploadedFile> updateEmployee(@RequestBody UploadedFile employee) {
        UploadedFile uploadedFile = uploadedFileService.updateUploadedFile(employee);
        return new ResponseEntity<>(uploadedFile, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUploadedFile(@PathVariable("id") Long id) {
        uploadedFileService.deleteUploadedFile(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
