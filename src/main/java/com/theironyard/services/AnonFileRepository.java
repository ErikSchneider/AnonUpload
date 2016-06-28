package com.theironyard.services;

import com.theironyard.entities.AnonFile;
import org.h2.command.dml.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.io.File;
import java.util.List;

/**
 * Created by Erik on 6/27/16.
 */
public interface AnonFileRepository extends CrudRepository<AnonFile, Integer> {
    @Query ("SELECT MIN (id) FROM AnonFile")
     public int searchMinId ();

    public AnonFile findByComment(String comment);


    //List<AnonFile> findAllByIsPermanent(boolean isPermanent);
}
