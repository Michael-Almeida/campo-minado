package com.br.michael.cm;

import com.br.michael.cm.modelo.Tabuleiro;

public class Aplicacao {

    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
        tabuleiro.abrir(3, 3);
        tabuleiro.abrir(1, 3);
        tabuleiro.alterarMarcacao(4, 4);
        tabuleiro.alterarMarcacao(2, 4);

        System.out.println(tabuleiro.toString());
    }
}
