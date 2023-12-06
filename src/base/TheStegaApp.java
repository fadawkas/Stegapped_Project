/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base;

/**
 *
 * @author mfada
 */
public class TheStegaApp {
    public static void main(String [] args){
        HomeGUI hm = new HomeGUI();
        hm.setVisible(true);
        hm.pack();
        hm.setLocationRelativeTo(null);
        hm.setDefaultCloseOperation(HomeGUI.EXIT_ON_CLOSE);
    }
}
