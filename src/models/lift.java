/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.util.ArrayList;

/**
 *
 * @author Mu'ti C Putro
 */
public class lift {
     private int lantai = 10;
    private double tpl = 3.6;
    private double waktuTempuh = 10;
    private double kecLift = 0.32;
    
    
    private double beratOrang=75;
    private double m2 = 950;
    private double m1 = 500;
    private int n=0;
    ArrayList<Orang> temp = new ArrayList<Orang>();
    
    
    public double getFaktorKeseimbangan(double kapasitasElevator){
        if(kapasitasElevator >= 1200){
            return 0.4;
        }else
        if(kapasitasElevator >= 600 && kapasitasElevator <= 1150){
            return 0.45;
        } 
        else
        if(kapasitasElevator >= 300 && kapasitasElevator <= 580){
            return 0.5;
        }
        else
            return -1;
    }
    
    public double getTotalPenumpang(int i){
        return i*this.beratOrang;
    }
    
    public String pencarian(){
        String kata= new String();
        String status = new String();
        int i = 1;
        double total = 0;
        while(total < m2){
            total = m1 + (getTotalPenumpang(i)*getFaktorKeseimbangan(getTotalPenumpang(i)));
            if (total < getM2())
            {
                status = "CUKUP";
            }
            else
            {
                status = "TIDAK CUKUP";
            }
            temp.add(new Orang(i, total));
            kata += "Orang ke-"+i+". Status : "+status+" \n";
            i++;
        }
        temp.remove(temp.size()-1);
        //System.out.println(total+" dengan maks orang "+(i-1));
        return (kata += getTemp().get(getTemp().size()-1)+"\n");
    }

   
    
     /**
     * @return the lantai
     */
    public int getLantai() {
        return lantai;
    }

    /**
     * @param lantai the lantai to set
     */
    public void setLantai(int lantai) {
        this.lantai = lantai;
    }

    /**
     * @return the beratOrang
     */
    public double getBeratOrang() {
        return beratOrang;
    }

    /**
     * @param beratOrang the beratOrang to set
     */
    public void setBeratOrang(double beratOrang) {
        this.beratOrang = beratOrang;
    }

    /**
     * @return the m2
     */
    public double getM2() {
        return m2;
    }

    /**
     * @param m2 the m2 to set
     */
    public void setM2(double m2) {
        this.m2 = m2;
    }

    /**
     * @return the m1
     */
    public double getM1() {
        return m1;
    }

    /**
     * @param m1 the m1 to set
     */
    public void setM1(double m1) {
        this.m1 = m1;
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(int n) {
        this.n = n;
    }

    /**
     * @return the temp
     */
    public ArrayList<Orang> getTemp() {
        return temp;
    }

    /**
     * @param temp the temp to set
     */
    public void setTemp(ArrayList<Orang> temp) {
        this.temp = temp;
    }

    /**
     * @return the tpl
     */
    public double getTpl() {
        return tpl;
    }

    /**
     * @param tpl the tpl to set
     */
    public void setTpl(double tpl) {
        this.tpl = tpl;
    }

    /**
     * @return the waktuTempuh
     */
    public double getWaktuTempuh() {
        return waktuTempuh;
    }

    /**
     * @param waktuTempuh the waktuTempuh to set
     */
    public void setWaktuTempuh(double waktuTempuh) {
        this.waktuTempuh = waktuTempuh;
    }

    /**
     * @return the kecLift
     */
    public double getKecLift() {
        return kecLift;
    }

    /**
     * @param kecLift the kecLift to set
     */
    public void setKecLift(double kecLift) {
        this.kecLift = kecLift;
    }

    private class Orang{
        private int id;
        private double total;

        public Orang(int id, double total) {
            this.id = id;
            this.total = total;
        }

        public int getId() {
            return id;
        }

        public double getTotal() {
            return total;
        }
        
        @Override
        public String toString(){
            return "\nJumlah Kapasitas : "+id+" Orang. Kapasitas Maksimum : "+(total + getM1()+" Kg");
        }
    }
    
   
}
