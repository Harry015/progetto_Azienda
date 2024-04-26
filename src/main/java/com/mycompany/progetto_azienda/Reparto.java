package com.mycompany.progetto_azienda;

import eccezioni.DipendenteNonTrovatoException;
import eccezioni.RepartoPienoException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Studente
 */
public class Reparto {
    
    private final static int NUM_MAX_DIPENDENTI=11;
    private Dipendente[] dipendenti;
    private String nomeReparto;

    public Reparto(String nomeReparto)
    {
        this.nomeReparto=nomeReparto;
        dipendenti=new Dipendente[NUM_MAX_DIPENDENTI];
    }
    
    public void aggiungiDipendente(Dipendente d) throws RepartoPienoException{
        int inserito=0;
        for (int i = 0; i < NUM_MAX_DIPENDENTI; i++) {
            if(dipendenti[i]==null){
                inserito=1;
                dipendenti[i]=d;
                break;
            }
        }
        if (inserito==0) 
            throw new RepartoPienoException();   
    }
    
    public Dipendente getDipendente(int id) throws DipendenteNonTrovatoException{
        int x=0;
        Dipendente d;
        for (int i = 0; i < NUM_MAX_DIPENDENTI; i++) {
            d=dipendenti[i];
            if(d.getId()==id){
                x=1;
                return d;
            }
        }
        if(x==0)
            throw new DipendenteNonTrovatoException();
        return null;
    }
    
    public void rimuoviDipendente(int id) throws DipendenteNonTrovatoException{
        int x=0;
        Dipendente d;
        for (int i = 0; i < NUM_MAX_DIPENDENTI; i++) {
            d=dipendenti[i];
            if(d.getId()==id){
                dipendenti[i]=null;
            }
        }
        if(x==0)
            throw new DipendenteNonTrovatoException();
    }
    
    public int getNumVolumi()
    {
        int contatore=0;
        for(int i=0;i<NUM_MAX_DIPENDENTI;i++)
        {
            if(dipendenti[i]!=null)
                contatore++;
        }
        return contatore;
    }
    
    public String toString()
    {
        String s="";
        for(int i=0;i<NUM_MAX_DIPENDENTI;i++)
        {
            if (dipendenti[i]==null)
                s+=i+"-->\n";
            else
                s+=i+"-->\t"+dipendenti[i].toString()+"\n";
        }
        return s;
    }
}
