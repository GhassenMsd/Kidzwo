package com.Esprit.sim.kidzwo.Entities;

public class Item {
    private int id;
    private String titre;
    private String image;
    private String titrefrench;
    private String titregerman;

    public Item(int id, String titre, String image, String titrefrench, String titregerman) {
        this.id = id;
        this.titre = titre;
        this.image = image;
        this.titrefrench = titrefrench;
        this.titregerman = titregerman;
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

    public String getTitrefrench() {
        return titrefrench;
    }

    public void setTitrefrench(String titrefrench) {
        this.titrefrench = titrefrench;
    }

    public String getTitregerman() {
        return titregerman;
    }

    public void setTitregerman(String titregerman) {
        this.titregerman = titregerman;
    }
}
