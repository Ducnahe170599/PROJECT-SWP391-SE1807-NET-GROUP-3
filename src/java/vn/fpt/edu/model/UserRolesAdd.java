/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.fpt.edu.model;

/**
 *
 * @author nguye
 */
public class UserRolesAdd {
    private int UserRoles;
    private int RoleID;

    public UserRolesAdd(int UserRoles, int RoleID) {
        this.UserRoles = UserRoles;
        this.RoleID = RoleID;
    }

    public int getUserRoles() {
        return UserRoles;
    }

    public void setUserRoles(int UserRoles) {
        this.UserRoles = UserRoles;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }
    
}
