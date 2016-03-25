/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author Mu'ti C Putro
 */
public class lift {
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
    
    public void pencarian(){
        int i = 1;
        double total = 0;
        while(total < m2){
            total = m1 + (getTotalPenumpang(i)*getFaktorKeseimbangan(getTotalPenumpang(i)));
            temp.add(new Orang(i, total));
            System.out.println("cukup ");
            i++;
        }
        temp.remove(temp.size()-1);
        //System.out.println(total+" dengan maks orang "+(i-1));
        System.out.println(temp.get(temp.size()-1).toString());
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
            return "jumlah : "+id+" total "+total;
        }
    }
    
    
    public static void main(String[] args) {
        lift l = new lift();
        l.pencarian();
    }
}
