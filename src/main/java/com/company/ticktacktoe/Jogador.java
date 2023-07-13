package com.company.ticktacktoe;

import java.util.Scanner;

/**
 *
 * @author Erlison
 */
public class Jogador{
    private String name;
    private char simbol;
    

    public Jogador(String name, char simbol) {
        this.name = name;
        this.simbol = simbol;
    }

    public void makeMove(Tabuleiro tab, Jogador oponente) {

        Scanner input = new Scanner(System.in);
        boolean jogadaValida = false;
    
        while (!jogadaValida) {
            System.out.print("Digite em qual linha deseja marcar: ");
            int line = input.nextInt();
        
            System.out.print("Agora digite a coluna: ");
            int column = input.nextInt();
        
            try {
                tab.markPosition(line, column, oponente);
                jogadaValida = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Por favor, faça uma jogada válida.");
            }
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSimbol() {
        return simbol;
    }

    public void setSimbol(char simbol) {
        this.simbol = simbol;
    }

    @Override
    public String toString() {
        return "Jogador{" + "name=" + name + ", simbol=" + simbol + '}';
    }
    
    
    
}
