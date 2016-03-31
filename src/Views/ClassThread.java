/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.lift;

/**
 *
 * @author ZANDUT
 */
public class ClassThread implements Runnable
{
    private guiLift gui;
    private lift lift;

    public void setGui(guiLift gui)
    {
        this.gui = gui;
    }

    public void setLift(lift lift)
    {
        this.lift = lift;
    }

    public guiLift getGui()
    {
        return gui;
    }

    public lift getLift()
    {
        return lift;
    }

    public ClassThread(guiLift gui, lift lift)
    {
        this.gui = gui;
        this.lift = lift;
    }

    @Override
    public void run()
    {
        ArrayList<lift.Orang> temp = new ArrayList<lift.Orang>();
        String kata= new String();
        String status = new String();
        int i = 1;
        double total = 0;
        while(total < lift.getM2()){
            total = lift.getM1() + (lift.getTotalPenumpang(i)*lift.getFaktorKeseimbangan(lift.getTotalPenumpang(i)));
            if (total < lift.getM2())
            {
                status = "CUKUP";
            }
            else
            {
                status = "TIDAK CUKUP";
            }
            temp.add(lift.new Orang(i, total));
            kata += "Orang ke-"+i+". Status : "+status+" \n";
            i++;
            
            try
            {
                Thread.sleep(500);
            } catch (InterruptedException ex)
            {
                Logger.getLogger(ClassThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            gui.getjTextArea1().setText(kata);
        }
        temp.remove(temp.size()-1);
        
        gui.getjTextArea1().setText(gui.getjTextArea1().getText()+temp.get(temp.size()-1).toString());
    }
    
    
    
}
