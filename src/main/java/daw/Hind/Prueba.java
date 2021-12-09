/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.Hind;

import javax.swing.JOptionPane;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author hinda
 */
public class Prueba {

    public static void main(String[] args) {
        
        LibroElectronico l1 = new LibroElectronico();
        LibroElectronico l2 = new LibroElectronico();
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        
        LibroElectronico l3 = new LibroElectronico(RandomStringUtils.randomNumeric(3),"libro3",9000,10,8000);
        JOptionPane.showMessageDialog(null, l3.toString());
        
        LibroElectronico l4 = new LibroElectronico(RandomStringUtils.randomNumeric(3),"libro4",12000,12,900);
        System.out.println(l4.toString());
        
        l1.setNumeroTotalLibro(13000);
        System.out.println(l1.toString());
        
        l1.setTamañoLibro(15);
        System.out.println(l1);
        
        l3.PasarPagina(1);
        System.out.println(l3.toString());
         
        l3.retrocederPagina(1000);
        System.out.println(l3.toString());
        
        l3.saltar(1000);
        System.out.println(l3.toString());
    }
}
