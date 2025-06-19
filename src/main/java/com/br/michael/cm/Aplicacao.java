package com.br.michael.cm;

import com.br.michael.cm.modelo.Tabuleiro;
import com.br.michael.cm.visao.TabuleiroConsole;

public class Aplicacao {

    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);

        new TabuleiroConsole(tabuleiro);
    }
}
