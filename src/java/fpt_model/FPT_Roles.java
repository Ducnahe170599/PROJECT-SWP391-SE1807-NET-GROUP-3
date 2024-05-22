/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt_model;

/**
 *
 * @author nguye
 */
public class FPT_Roles {

    private int RolesID;
    private String Role_Name;
    private String Description;

    public FPT_Roles(int RolesID, String Role_Name, String Description) {
        this.RolesID = RolesID;
        this.Role_Name = Role_Name;
        this.Description = Description;
    }

    public int getRolesID() {
        return RolesID;
    }

    public void setRolesID(int RolesID) {
        this.RolesID = RolesID;
    }

    public String getRole_Name() {
        return Role_Name;
    }

    public void setRole_Name(String Role_Name) {
        this.Role_Name = Role_Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

}
