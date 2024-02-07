package com.example.pharmacie1;

public class Pharmacie {

    private String name;
    private String adress;
    private String telephone;

    public Pharmacie() {
    }

    public Pharmacie(String name, String adress, String telephone) {

        this.name = name;
        this.adress = adress;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Pharmacie{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
