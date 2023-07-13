package com.company.ticktacktoe;

/**
 *
 * @author Erlison
 */
public class Ticktacktoe {

    public static void main(String[] args) {
        Tabuleiro tab = new Tabuleiro();
        Jogador j1 = new Jogador("Erlison", 'X');
        
        Jogador j2 = new Jogador("josé", 'O');
        
        tab.drawTable();
        
        tab.initGame(j1, j2);
        
    }
}
