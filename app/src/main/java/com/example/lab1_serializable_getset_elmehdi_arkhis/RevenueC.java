package com.example.lab1_serializable_getset_elmehdi_arkhis;

import java.io.Serializable;

public class RevenueC implements Serializable {

    private double salMensuel;
    private double pensAlim;
    private double RevMens;

    public RevenueC(double _salMensuel, double _pensAlim, double _RevMens){
        salMensuel=_salMensuel;
        pensAlim=_pensAlim;
        RevMens=_RevMens;
    }

    public double getSalMensuel(){
        return salMensuel;
    }

    public double getPensAlim(){
        return pensAlim;
    }

    public double getRevMens(){
        return RevMens;
    }

    public double revenuTotal(){
        return salMensuel+pensAlim+RevMens;
    }

}
