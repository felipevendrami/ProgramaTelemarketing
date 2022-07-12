/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import Controller.MenuInicialController;
import View.MenuInicialView;

/**
 *
 * @author felip
 */
public class AddComController {
    
    public static void main(String[] args) {
        MenuInicialController menuInicial = new MenuInicialController(new MenuInicialView());
        menuInicial.exibirTelaMenuInicial();
    }
}
