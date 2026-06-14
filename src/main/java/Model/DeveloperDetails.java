/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Objects;

/**
 * @author ME
 */
public class DeveloperDetails {


    String devFirstName;
    String devLastName;

    public DeveloperDetails(String devFirstName, String devLastName) {
        this.devFirstName = devFirstName;
        this.devLastName = devLastName;
    }

    public String getDevFirstName() {
        return devFirstName;
    }

    public void setDevFirstName(String devFirstName) {
        this.devFirstName = devFirstName;
    }

    public String getDevLastName() {
        return devLastName;
    }

    public void setDevLastName(String devLastName) {
        this.devLastName = devLastName;
    }

    @Override
    public String toString() {
        return "Name: " + this.devFirstName + " Surname: " + this.devLastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof String) {
            String[] objects = obj.toString().split(",");
            DeveloperDetails other = new DeveloperDetails(objects[0],
                    objects[1]);
            return Objects.equals(this.devFirstName, other.devFirstName) &&
                    Objects.equals(this.devLastName, other.devLastName);
        }
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DeveloperDetails other = (DeveloperDetails) obj;
        if (!Objects.equals(this.devFirstName, other.devFirstName)) {
            return false;
        }
        return Objects.equals(this.devLastName, other.devLastName);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.devFirstName);
        hash = 37 * hash + Objects.hashCode(this.devLastName);
        return hash;
    }


}
