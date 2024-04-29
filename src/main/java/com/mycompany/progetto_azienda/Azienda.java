/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_azienda;


import eccezioni.RepartoNonTrovatoException;
import eccezioni.AziendaPienaException;
import java.util.Arrays;

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
                break;
            }
        }
        if(x==0)
            throw new AziendaPienaException();
    }
    
    public Reparto getReparto(int id) throws RepartoNonTrovatoException{
        int x=0;
        Reparto r;
        for (int i = 0; i < NUM_MAX_REPARTI; i++) {
            r=reparti[i];
            if(r.getId_Reparto()==id){
                x=1;
                return r;
            }
        }
        if(x==0)
            throw new RepartoNonTrovatoException();
        return null;
    }
    
    public void rimuoviReparto(int id) throws RepartoNonTrovatoException{
        int x=0;
        Reparto r;
        for (int i = 0; i < NUM_MAX_REPARTI; i++) {
            r=reparti[i];
            if(r.getId_Reparto()==id){
                reparti[i]=null;
                break;
            }
        }
        if(x==0)
            throw new RepartoNonTrovatoException();
    }
    
    public String toString()
    {
        String s="";
        for(int i=0;i<NUM_MAX_REPARTI;i++)
        {
            if (reparti[i]==null)
                s+="Reparto "+i+" --> Vuoto\n";
            else
                s+=reparti[i].toString()+"\n";
        }
        return s;
    }
}
