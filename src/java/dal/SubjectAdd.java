/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Timestamp;


/**
 *
 * @author nguye
 */
public class SubjectAdd {
    private int SubjectID;
    private String Subject_Name;
    private String Description;
    private String Image;
    private int Status;
    private int PackageId;
    private int CategoryId;
    private int created_by;
    private Timestamp  Created_at;

    public SubjectAdd(int SubjectID, String Subject_Name, String Description, String Image, int Status, int PackageId, int CategoryId, int created_by, Timestamp Created_at) {
        this.SubjectID = SubjectID;
        this.Subject_Name = Subject_Name;
        this.Description = Description;
        this.Image = Image;
        this.Status = Status;
        this.PackageId = PackageId;
        this.CategoryId = CategoryId;
        this.created_by = created_by;
        this.Created_at = Created_at;
    }

    public int getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(int SubjectID) {
        this.SubjectID = SubjectID;
    }

    public String getSubject_Name() {
        return Subject_Name;
    }

    public void setSubject_Name(String Subject_Name) {
        this.Subject_Name = Subject_Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getPackageId() {
        return PackageId;
    }

    public void setPackageId(int PackageId) {
        this.PackageId = PackageId;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public Timestamp getCreated_at() {
        return Created_at;
    }

    public void setCreated_at(Timestamp Created_at) {
        this.Created_at = Created_at;
    }

}
