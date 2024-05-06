package com.mycompany.progetto_azienda;

import java.util.ArrayList;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Studente
 */
public class Dipendente {
    private int id_Dipendente;
    private String nome;
    private String cognome;
    private String ruolo;
    private int stipendio;
    private Date dataAssunzione;
    private static int id=1;
    private ArrayList<Ferie> ferie;

    public String getFerie() {
        int x=0;
        String s="";
        if(this.getRuolo()!="capo reparto"){
            s="Dipendente: " + this.getNome() + " " + this.getCognome();
            for (Ferie f : ferie) {
                x=1;
                s+="\nData inizio: " + f.getDataInizio() + "\nData fine: " + f.getDataFine() + "\nMotivo: " + f.getMotivo() + "\nApprovato: " + f.isApprovato();       
            }
            if(x==0)
                s+=" Nessuna richiesta presente";
            
        }
        return s;
    }

    public void setFerie(Ferie f) {
        ferie.add(f);
    }

    public Dipendente(String nome, String cognome, String ruolo, int stipendio, Date dataAssunzione) {
        setId_Dipendente();
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
        this.stipendio = stipendio;
        this.dataAssunzione = dataAssunzione;
        this.ferie=new ArrayList<>();
    }

    public int getId_Dipendente() {
        return id_Dipendente;
    }
    
    public void setId_Dipendente() {
        this.id_Dipendente = id++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public int getStipendio() {
        return stipendio;
    }

    public void setStipendio(int stipendio) {
        this.stipendio = stipendio;
    }

    public Date getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(Date dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    @Override
    public String toString() {
        return "Dipendente{" + "id_Dipendente=" + this.getId_Dipendente()+ ", nome=" + this.getNome()+ ", cognome=" + this.getCognome() + ", ruolo=" + this.getRuolo() + ", stipendio=" + this.getStipendio() + ", dataAssunzione=" + this.getDataAssunzione() + '}';
    }

}
