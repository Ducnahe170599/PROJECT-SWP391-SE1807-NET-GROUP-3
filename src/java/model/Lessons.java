package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Lessons {

    private int id;
    private String name;
    private String videoLink;
    private Date createdAt;
    private int createdBy;
    private int subjectId;
    private String status;
    private String content;
    private String subjectName;
    private String author;

    public Lessons() {
    }

    public Lessons(int id, String name, String videoLink, Date createdAt, int createdBy, int subjectId, String status, String content) {
        this.id = id;
        this.name = name;
        this.videoLink = videoLink;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.subjectId = subjectId;
        this.status = status;
        this.content = content;
    }

    public Lessons(String name, String videoLink, Date createdAt, int createdBy, int subjectId, String status, String content) {
        this.name = name;
        this.videoLink = videoLink;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.subjectId = subjectId;
        this.status = status;
        this.content = content;
    }

    

    public Lessons(int id, String name, String videoLink, Date createdAt, int createdBy, int subjectId, String status, String content, String subjectName, String author) {
        this.id = id;
        this.name = name;
        this.videoLink = videoLink;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.subjectId = subjectId;
        this.status = status;
        this.content = content;
        this.subjectName = subjectName;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Lessons{" + "id=" + id + ", name=" + name + ", videoLink=" + videoLink + ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", subjectId=" + subjectId + ", status=" + status + ", content=" + content + ", subjectName=" + subjectName + ", author=" + author + '}';
    }

    
}
