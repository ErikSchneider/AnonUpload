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

    boolean isPermanent = false;

    @Column(nullable = false)
    String comment;

    @Column(nullable = false)
    String originalFilename;

    @Column(nullable = false)
    String newFilename;

    @Column(nullable = false)
    String password;

    public AnonFile() {
    }


    public AnonFile(boolean isPermanent, String comment, String originalFilename, String newFilename, String password) {
        this.isPermanent = isPermanent;
        this.comment = comment;
        this.originalFilename = originalFilename;
        this.newFilename = newFilename;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPermanent() {
        return isPermanent;
    }

    public void setPermanent(boolean permanent) {
        isPermanent = permanent;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
