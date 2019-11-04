package com.Esprit.sim.kidzwo.Entities;

public class Book {
    private int id;
    private String titre;
    private String image;
    private String res;

    public Book(int id, String titre, String image, String res) {
        this.id = id;
        this.titre = titre;
        this.image = image;
        this.res = res;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
