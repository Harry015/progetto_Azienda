/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_azienda;

import eccezioni.dataNonValidaException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author harry
 */
public class Ferie {
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private String motivo;
    private boolean approvato;

    // Costruttore
    public Ferie(LocalDate dataInizio, LocalDate dataFine, String motivo) throws dataNonValidaException {
        if(dataInizio.getDayOfMonth()<=0 && dataInizio.getMonthValue()<=0 && dataInizio.getYear()<=0)
            throw new dataNonValidaException();
        if(dataFine.getDayOfMonth()<=0 && dataFine.getMonthValue()<=0 && dataFine.getYear()<=0)
            throw new dataNonValidaException();
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.motivo = motivo;
        this.approvato = false;
    }

    // Metodi getter e setter per gli attributi
    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Metodo per vedere se la richiesta è approvata o no
     * @return 
     */
    public boolean isApprovato() {
        return approvato;
    }

    /**
     * Metodo per assegnare true o false al attributo approvato
     * @param approvato 
     */
    public void setApprovato(boolean approvato) {
        this.approvato = approvato;
    }
    
    public String toString(){
        return "Data inizio: " + dataInizio + "\n" +
               "Data fine: " + dataFine + "\n" +
               "Motivo: " + motivo + "\n" +
               "Stato: " + approvato;
    }
    
}
