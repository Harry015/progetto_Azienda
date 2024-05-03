/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_azienda;


import eccezioni.RepartoNonTrovatoException;
import eccezioni.AziendaPienaException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Studente
 */
public class Azienda {
    
    private static final int NUM_MAX_REPARTI=5;
    private String nome;
    private ArrayList<Reparto> reparti;
    //private Reparto[] reparti;
    
    public Azienda(String nomeAzienda)
    {
        this.nome=nomeAzienda;
        reparti=new ArrayList<>();
        //reparti=new Reparto[NUM_MAX_REPARTI];
        
    }
    
    public void aggiungiReparto(Reparto r) throws AziendaPienaException{
        int x=0;
        if(getNumReparti()>5)
            throw new AziendaPienaException();
        else
            reparti.add(r);
    }
    
    public Reparto getReparto(int id) throws RepartoNonTrovatoException{
        int x=0;
        for (Reparto r : reparti) {
            if (r.getId_Reparto()==id) {
                x=1;
                return r;
            }
        }
        if(x==0)
            throw new RepartoNonTrovatoException();
        return null;
    }
    
    public void rimuoviReparto(int id) throws RepartoNonTrovatoException{
        boolean x=false;
        for (Reparto r : reparti) {
            if (r.getId_Reparto()==id) {
                x=reparti.remove(r);
                break;
            }
        }
        if(x==false)
            throw new RepartoNonTrovatoException();
    }
    
    public int getNumReparti()
    {
        int c=0;
        for (Reparto r : reparti) {
            if (r!=null) {
                c++;
            }
        }
        return c;
    }
    
    public String toString()
    {
        String s="";
        for(int i=0;i<reparti.size();i++)
        {
            if (reparti.get(i)==null)
                s+="Reparto "+i+" --> Vuoto\n";
            else
                s+=reparti.get(i).toString()+"\n";
        }
        return s;
    }
}
