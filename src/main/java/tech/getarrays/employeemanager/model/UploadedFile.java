package tech.getarrays.employeemanager.model;

/*
 * This is the Entity class.
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UploadedFile implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    String name, uploadDate;
    double size;
    public UploadedFile() {}

    public UploadedFile(String name, String uploadDate, double size) {
        this.name = name;
        this.uploadDate = uploadDate;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "UploadedFile{" +
                "id=" + id +
                "name=" + name +
                ", uploadDate='" + uploadDate +
                ", size='" + size +
                '}';
    }
}
