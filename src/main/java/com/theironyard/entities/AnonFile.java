package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by Erik on 6/27/16.
 */
@Entity
@Table(name = "files")
public class AnonFile {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String originalFilename;

    @Column(nullable = false)
    String newFilename;

    public AnonFile() {
    }

    public AnonFile(String originalFilename, String newFilename) {
        this.originalFilename = originalFilename;
        this.newFilename = newFilename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getNewFilename() {
        return newFilename;
    }

    public void setNewFilename(String newFilename) {
        this.newFilename = newFilename;
    }
}
