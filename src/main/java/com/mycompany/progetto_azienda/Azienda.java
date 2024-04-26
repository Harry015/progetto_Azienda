/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_azienda;

import eccezioni.AziendaPienaException;

/**
 *
 * @author Studente
 */
public class Azienda {
    
    private static final int NUM_MAX_REPARTI=5;
    private String nome;
    private Reparto[] reparti;
    
    public Azienda(String nomeAzienda)
    {
        this.nome=nomeAzienda;
        reparti=new Reparto[NUM_MAX_REPARTI];
    }
    
    public void aggiungiReparto(Reparto r) throws AziendaPienaException{
        int x=0;
        for (int i = 0; i < NUM_MAX_REPARTI; i++) {
            if(reparti[i]==null){
                x=1;
                reparti[i]=r;
            }
        }
        if(x==0)
            throw new AziendaPienaException();
    }
    
    public void getReparto(Reparto r){
        
    }
    
    public void rimuoviReparto(Reparto r){
        
    }
    
    public String toString()
    {
        String s="";
        for(int i=0;i<NUM_MAX_REPARTI;i++)
        {
            s+="Reparto "+i+":\n"+reparti[i].toString();  
        }
        return s;
    }
}
