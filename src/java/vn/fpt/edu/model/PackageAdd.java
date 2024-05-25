/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.fpt.edu.model;

/**
 *
 * @author nguye
 */
public class PackageAdd {

    private int PackageID;
    private String package_name;
    private String description;
    private float listPrice;
    private float salePrive;
    private int duration;

    public PackageAdd(int PackageID, String package_name, String description, float listPrice, float salePrive, int duration) {
        this.PackageID = PackageID;
        this.package_name = package_name;
        this.description = description;
        this.listPrice = listPrice;
        this.salePrive = salePrive;
        this.duration = duration;
    }

    public int getPackageID() {
        return PackageID;
    }

    public void setPackageID(int PackageID) {
        this.PackageID = PackageID;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getListPrice() {
        return listPrice;
    }

    public void setListPrice(float listPrice) {
        this.listPrice = listPrice;
    }

    public float getSalePrive() {
        return salePrive;
    }

    public void setSalePrive(float salePrive) {
        this.salePrive = salePrive;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
