package com.theironyard.controllers;

import com.theironyard.entities.AnonFile;
import com.theironyard.services.AnonFileRepository;
import com.theironyard.utlities.PasswordStorage;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

/**
 * Created by Erik on 6/27/16.
 */
@Controller
public class AnonFileController {
    @Autowired
    AnonFileRepository files;

    @PostConstruct
    public void init() throws SQLException {
        Server.createWebServer().start();
    }

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file, String comment, boolean isPermanent, String password) throws IOException, PasswordStorage.CannotPerformOperationException {
        File dir = new File("public/files");
        dir.mkdirs();

        File uploadedFile = File.createTempFile("file", file.getOriginalFilename(), dir);
        FileOutputStream fos = new FileOutputStream(uploadedFile);
        fos.write(file.getBytes());

        AnonFile anonFile = new AnonFile(isPermanent, comment, file.getOriginalFilename(), uploadedFile.getName(), PasswordStorage.createHash(password));

        if (files.count() < 2) {
            files.save(anonFile);
        }
        else if (files.count()> 2) {
            int id = files.searchMinId();
            files.delete(id);
        }

        return "redirect:/";


//        if (files.findAllByIsPermanent(false).size()> 2) {
//            List<AnonFile> list = (List<AnonFile>) files.findAllByIsPermanent(false);
//            AnonFile deleteFile = list.get(0);
//            String fileName = deleteFile.getNewFilename();
//            File tempFile = new File("public/files", fileName);
//            files.delete(deleteFile);
//            tempFile.delete();

//        } Something Doug told me to try but count get it to work properly.

    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public String deleteFile(String file, String password) throws Exception {
        AnonFile anonFile = files.findByComment(file);
        if (!PasswordStorage.verifyPassword(password, anonFile.getPassword())) {
            throw new Exception("Invalid Password");
        }
        else {
            files.delete(anonFile);
        }

        return "redirect:/";

    }
}