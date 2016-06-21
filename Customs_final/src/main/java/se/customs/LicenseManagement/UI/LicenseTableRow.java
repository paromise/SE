/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.LicenseManagement.UI;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author faeze
 */
public class LicenseTableRow {
  

    private final StringProperty num;

    private final StringProperty name;

    public LicenseTableRow(String num, String name) {

        this.num = new SimpleStringProperty(num);
        this.name = new SimpleStringProperty(name);

    }

    public void setNum(String id) {
        this.num.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getNum() {
        return num.get();
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty numProperty() {
        return num ;
    }

}
