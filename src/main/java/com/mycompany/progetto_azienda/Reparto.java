package com.mycompany.progetto_azienda;

import eccezioni.DipendenteNonTrovatoException;
import eccezioni.RepartoPienoException;
import java.util.ArrayList;

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
    private ArrayList<Dipendente> dipendenti;
    private String nomeReparto;
    private int id_Reparto;
    private static int id=1;
    
    public int getId_Reparto() {
        return id_Reparto;
    }
    
    public void setId_Reaprto() {
        this.id_Reparto = id++;
    }

    public Reparto(String nomeReparto)
    {
        this.nomeReparto=nomeReparto;
        dipendenti=new ArrayList<>();
    }
    
    public void aggiungiDipendente(Dipendente d) throws RepartoPienoException {
        if(getNumDipendenti()>10)
            throw new RepartoPienoException();
        else
            dipendenti.add(d);
    }
    
    public Dipendente getDipendente(int id) throws DipendenteNonTrovatoException {
        int x=0;
        for (Dipendente dipendente : dipendenti) {
            if (dipendente.getId_Dipendente()==id) {
                x=1;
                return dipendente;
            }
        }
        if(x==0)
            throw new DipendenteNonTrovatoException();
        return null;
    }
    
    public void rimuoviDipendente(int id) throws DipendenteNonTrovatoException {
        boolean x=false;
        for (Dipendente dipendente : dipendenti) {
            if (dipendente.getId_Dipendente()==id) {
                x=dipendenti.remove(dipendente);
                break;
            }
        }
        if(x==false)
            throw new DipendenteNonTrovatoException();
    }
    
    public int getNumDipendenti()
    {
        int c=0;
        for (Dipendente dipendente : dipendenti) {
            if (dipendente!=null) {
                c++;
            }
        }
        return c;
    }
    
    public String toString()
    {
        String s="";
        s+="Nome:"+nomeReparto+"\n";
        for(int i=0;i<dipendenti.size();i++)
        {
            if (dipendenti.get(i)==null)
                s+=i+"-->\n";
            else
                s+=i+"-->\t"+dipendenti.get(i).toString()+"\n";
        }
        return s;
    }
}
