package com.befun.util.input.impl.access;

import java.io.File;
import java.io.Serializable;

public class AccessConnDesc implements Serializable {

    private static final long serialVersionUID = -1216364373832567488L;

    private String filePath;

    private File file;

    private String username;

    private String password;

    @SuppressWarnings("unused")
    private AccessConnDesc() {
    }

    public AccessConnDesc(File file) {
        this.file = file;
    }

    public AccessConnDesc(String filePath) {
        this.filePath = filePath;
    }

    public AccessConnDesc(String filePath, String username, String password) {
        this.filePath = filePath;
        this.username = username;
        this.password = password;
    }

    public String getConnUrl() {
        String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + this.filePath;
        System.out.println(url);
        return url;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccessConnDesc [filePath=" + filePath + ", username=" + username + ", password=" + password + "]";
    }

}
