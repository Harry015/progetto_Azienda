package com.mycompany.progetto_azienda;

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
    
    private String nome;
    private String cognome;
    private String ruolo;
    private int stipendio;
    private Date dataAssunzione;

    public Dipendente(String nome, String cognome, String ruolo, int stipendio, Date dataAssunzione) {
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
        this.stipendio = stipendio;
        this.dataAssunzione = dataAssunzione;
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
        return "Dipendente{" + "nome=" + nome + ", cognome=" + cognome + ", ruolo=" + ruolo + ", stipendio=" + stipendio + ", dataAssunzione=" + dataAssunzione + '}';
    }

}
