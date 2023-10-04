package com.vehicule.vehicule.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String marque;

    String model;

    String couleur;

    String immattriculationNb;

    int cheveauxFiscNb;

    int prixReservation;

    int prixKillometre;

    int cm3;

    int m3Chargement;

    Date annee;

    int nbKillometre;

    String type;

    String src;


    public Vehicule(){

    }

    public Vehicule(int id, String marque, String model, String couleur, String immattriculationNb, int cheveauxFiscNb, int prixReservation, int prixKillometre, int cm3, int m3Chargement, Date annee, int nbKillometre, String type, String src){
        this.id = id;

        this.marque = marque;

        this.model = model;

        this.couleur = couleur;

        this.immattriculationNb = immattriculationNb;

        this.cheveauxFiscNb = cheveauxFiscNb;

        this.prixReservation = prixReservation;

        this.prixKillometre = prixKillometre;

        this.cm3 = cm3;

        this.m3Chargement = m3Chargement;

        this.annee = annee;

        this.nbKillometre = nbKillometre;

        this.type = type;

        this.src = src;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setModel(String model) { this.model = model; }

    public String getModel(){ return model; }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getImmattriculationNb() {
        return immattriculationNb;
    }

    public void setImmattriculationNb(String immattriculationNb) {
        this.immattriculationNb = immattriculationNb;
    }

    public int getCheveauxFiscNb() {
        return cheveauxFiscNb;
    }

    public void setCheveauxFiscNb(int cheveauxFiscNb) {
        this.cheveauxFiscNb = cheveauxFiscNb;
    }

    public int getPrixReservation() {
        return prixReservation;
    }

    public void setPrixReservation(int prixReservation) {
        this.prixReservation = prixReservation;
    }

    public int getPrixKillometre() {
        return prixKillometre;
    }

    public void setPrixKillometre(int prixKillometre) {
        this.prixKillometre = prixKillometre;
    }

    public int getCm3() {
        return cm3;
    }

    public void setCm3(int cm3) {
        this.cm3 = cm3;
    }

    public int getM3Chargement() {
        return m3Chargement;
    }

    public void setM3Chargement(int m3Chargement) {
        this.m3Chargement = m3Chargement;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date année) {
        this.annee = année;
    }

    public int getNbKillometre() {
        return nbKillometre;
    }

    public void setNbKillometre(int nbKillometre) {
        this.nbKillometre = nbKillometre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSrc() {return src; }

    public void setSrc(String src) { this.src = src; }

    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", couleur='" + couleur + '\'' +
                ", model=" + model +
                ", immattriculationNb=" + immattriculationNb +
                ", cheveauxFiscNb=" + cheveauxFiscNb +
                ", prixReservation=" + prixReservation +
                ", prixKillometre=" + prixKillometre +
                ", cm3=" + cm3 +
                ", m3Chargement=" + m3Chargement +
                ", année=" + annee +
                ", nbKillometre=" + nbKillometre +
                ", type=" + type +
                ", src='" + src + '\'' +
                '}';
    }
}
