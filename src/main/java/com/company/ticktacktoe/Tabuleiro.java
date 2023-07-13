package com.company.ticktacktoe;



/**
 *
 * @author Erlison
 */
public class Tabuleiro {
    private final char[][] tabuleiro;
    private final int[][] winningPositions = {
        // Linhas
        {0, 1, 2}, // Primeira linha
        {3, 4, 5}, // Segunda linha
        {6, 7, 8}, // Terceira linha

        // Colunas
        {0, 3, 6}, // Primeira coluna
        {1, 4, 7}, // Segunda coluna
        {2, 5, 8}, // Terceira coluna

        // Diagonais
        {0, 4, 8}, // Diagonal principal
        {2, 4, 6}  // Diagonal secundária
     };
    
    public Tabuleiro(){
        this.tabuleiro = new char[3][3];
        this.initTable();   
    }

    public char[][] getTabuleiro() {
        return tabuleiro;
    }
    
    
    public void initTable() {
        for(int line = 0; line < tabuleiro.length; line++) {
            for (int column = 0; column < tabuleiro[line].length; column++) {
                tabuleiro[line][column] = ' ';
            }
        }
    }
    
    public void drawTable(){
        System.out.println("******* jogo da Velha *******");
        for (int line = 0; line < tabuleiro.length; line++) {   
            System.out.println("\t " + tabuleiro[line][0] + " | " + tabuleiro[line][1] + " | " + tabuleiro[line][2]);
            if (line < 2) System.out.println("\t---+---+---");
        }
    }
    
    
    public void markPosition(int line, int column, Jogador oponente){
        for (int i = 0; i < 5; i++) {
            System.out.println(); // Imprimir linhas em branco para rolar o console para cima
        }
        
        System.out.printf("o jogador: %S marcou na linha %d e na coluna %d\n", oponente.getName(), line, column);
        
        this.tabuleiro[line][column] = oponente.getSimbol();
        drawTable();
    }
    
   
    
    public boolean verifyWinner() {
        for (int[] posicoes : this.winningPositions) {
            int linha1 = posicoes[0] / 3;
            int coluna1 = posicoes[0] % 3;
            int linha2 = posicoes[1] / 3;
            int coluna2 = posicoes[1] % 3;
            int linha3 = posicoes[2] / 3;
            int coluna3 = posicoes[2] % 3;

            char simbolo = this.tabuleiro[linha1][coluna1];
            if (simbolo != ' ' && simbolo == tabuleiro[linha2][coluna2] && simbolo == tabuleiro[linha3][coluna3]) {
                return true; // Há um vencedor
            }
        }
        return false; // Não há vencedor
    }
    
    
    public void initGame(Jogador jogador1, Jogador jogador2) {
        int jogadas = 0;
        Jogador jogadorAtual = jogador1;

        do {
            System.out.println("Vez do jogador: " + jogadorAtual.getName());
            jogadorAtual.makeMove(this, jogadorAtual);
            jogadas++;
        
            if (verifyWinner()) {
                System.out.println("Parabéns! O jogador " + jogadorAtual.getName() + " venceu!");
                break;
            }

            if (jogadas == 9) {
                System.out.println("Empate! O jogo terminou sem um vencedor.");
                break;
            }

            // Troca de jogador
            jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
        } while (true);
    }



    
    /*
        |   |
    ----+---+----
        |   |
    ----+---+----
        |   | 
    
    */

    
    
    
    
}
