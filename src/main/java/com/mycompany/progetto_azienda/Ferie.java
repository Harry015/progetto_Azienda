/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_azienda;

import java.util.Date;
import java.util.List;

/**
 *
 * @author taran
 */
public class Ferie {
    private Date dataInizio;
    private Date dataFine;
    private String motivo;
    private boolean approvato;

    // Costruttore
    public Ferie(Date dataInizio, Date dataFine, String motivo) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.motivo = motivo;
        this.approvato = false;
    }

    // Metodi getter e setter per gli attributi
    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isApprovato() {
        return approvato;
    }

    public void setApprovato(boolean approvato) {
        this.approvato = approvato;
    }
    
}
