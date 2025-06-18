package com.br.michael.cm.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {
    private final int linha;
    private final int coluna;

    private boolean aberto = false;
    private boolean minado = false;
    private boolean marcado = false;

    private List<Campo> vizinhos = new ArrayList<>();


    public Campo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    boolean adicionaVizinho(Campo vizinho) {
        boolean linhaDiferente = linha!=vizinho.linha;
        boolean colunaDiferente = coluna!=vizinho.coluna;
        boolean diagonal = linhaDiferente && colunaDiferente;

        int deltaLinha = Math.abs(linha - vizinho.linha);//0 ------1
        int deltaColuna = Math.abs(coluna - vizinho.coluna);//1 ---1
        int deltaGeral = deltaLinha + deltaColuna;

        if (deltaGeral==1 && !diagonal) {
            vizinhos.add(vizinho);
            return true;
        } else if (deltaGeral==2 && diagonal) {
            vizinhos.add(vizinho);
            return true;
        } else {
            return false;
        }
    }
}
