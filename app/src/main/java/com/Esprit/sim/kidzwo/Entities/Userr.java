package com.Esprit.sim.kidzwo.Entities;

public class Userr {
    private Integer id;
    private String login;
    private String nom;
    private String prenom;
    private String mdp;
    private String mail;
    private Integer score;
    private Integer scoremath;
    private Integer scoreenglish;
    private Integer scorefrench;
    private Integer scoreqi;
    private Integer scoreaudio;
    private Integer scoreal;

    public Userr(Integer id, String login, String nom, String prenom, String mdp, String mail, Integer score, Integer scoremath, Integer scoreenglish, Integer scorefrench, Integer scoreqi, Integer scoreaudio, Integer scoreal) {
        this.id = id;
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.mail = mail;
        this.score = score;
        this.scoremath = scoremath;
        this.scoreenglish = scoreenglish;
        this.scorefrench = scorefrench;
        this.scoreqi = scoreqi;
        this.scoreaudio = scoreaudio;
        this.scoreal = scoreal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScoremath() {
        return scoremath;
    }

    public void setScoremath(Integer scoremath) {
        this.scoremath = scoremath;
    }

    public Integer getScoreenglish() {
        return scoreenglish;
    }

    public void setScoreenglish(Integer scoreenglish) {
        this.scoreenglish = scoreenglish;
    }

    public Integer getScorefrench() {
        return scorefrench;
    }

    public void setScorefrench(Integer scorefrench) {
        this.scorefrench = scorefrench;
    }

    public Integer getScoreqi() {
        return scoreqi;
    }

    public void setScoreqi(Integer scoreqi) {
        this.scoreqi = scoreqi;
    }

    public Integer getScoreaudio() {
        return scoreaudio;
    }

    public void setScoreaudio(Integer scoreaudio) {
        this.scoreaudio = scoreaudio;
    }

    public Integer getScoreal() {
        return scoreal;
    }

    public void setScoreal(Integer scoreal) {
        this.scoreal = scoreal;
    }

    @Override
    public String toString() {
        return "Userr{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mdp='" + mdp + '\'' +
                ", mail='" + mail + '\'' +
                ", score=" + score +
                ", scoremath=" + scoremath +
                ", scoreenglish=" + scoreenglish +
                ", scorefrench=" + scorefrench +
                ", scoreqi=" + scoreqi +
                ", scoreaudio=" + scoreaudio +
                ", scoreal=" + scoreal +
                '}';
    }
}
