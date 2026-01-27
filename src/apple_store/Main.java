/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package apple_store;

/**
 *
 * @author FOTZS41
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SystemManager systemManager = new SystemManager();
        Menu menu = new Menu(systemManager);

        systemManager.initSystem();
        menu.start();
    }
}
