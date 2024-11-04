/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

/**
 *
 * @author jhoja
 */
import Controlador.BibliotecaController;
import Modelo.Biblioteca;
import Vista.BibliotecaView;

public class test {
    public static void main(String[] args) {
        Biblioteca Modelo = new Biblioteca();
        BibliotecaView Vista = new BibliotecaView();
        BibliotecaController Controlador = new BibliotecaController(Modelo, Vista);
        
        Vista.setVisible(true);
    }
}