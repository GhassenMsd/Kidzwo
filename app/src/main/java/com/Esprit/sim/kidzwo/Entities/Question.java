package com.Esprit.sim.kidzwo.Entities;

public class Question {

    public int id;
    public String enonce;
    public String repf1;
    public String repf2;
    public String repf3;
    public String repfv;
    public String photo;

    public Question(int id, String enonce, String repf1, String repf2, String repf3, String repfv) {
        this.id = id;
        this.enonce = enonce;
        this.repf1 = repf1;
        this.repf2 = repf2;
        this.repf3 = repf3;
        this.repfv = repfv;
    }

    public Question(int id, String enonce, String repf1, String repf2, String repf3, String repfv,String photo) {
        this.id = id;
        this.enonce = enonce;
        this.repf1 = repf1;
        this.repf2 = repf2;
        this.repf3 = repf3;
        this.repfv = repfv;
        this.photo = photo;
    }

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public String getRepf1() {
        return repf1;
    }

    public void setRepf1(String repf1) {
        this.repf1 = repf1;
    }

    public String getRepf2() {
        return repf2;
    }

    public void setRepf2(String repf2) {
        this.repf2 = repf2;
    }

    public String getRepf3() {
        return repf3;
    }

    public void setRepf3(String repf3) {
        this.repf3 = repf3;
    }

    public String getRepfv() {
        return repfv;
    }

    public void setRepfv(String repfv) {
        this.repfv = repfv;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
