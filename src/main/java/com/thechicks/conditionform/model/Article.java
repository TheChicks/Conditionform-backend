package com.thechicks.conditionform.model;

/**
 * Created by Leeseolhee on 2016. 5. 18..
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class Article implements Serializable {
    private long id;
    private String title;

    @JsonIgnore
    private MultipartFile file;

    @JsonProperty("file")
    private String fileName;

    public String getFileName() {
        return this.file.getOriginalFilename();
    }

    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}