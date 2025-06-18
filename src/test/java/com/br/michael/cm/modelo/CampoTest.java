package com.br.michael.cm.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampoTest {

    private Campo campo;

    @BeforeEach
    void iniciarCampo() {
        campo = new Campo(3, 3);

    }

    @Test
    void testeVizinhoRealDistancia1Esquerda() {
        Campo vizinho = new Campo(3, 2);
        boolean resultado = campo.adicionaVizinho(vizinho);

        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia1Direita() {
        Campo vizinho = new Campo(3, 4);
        boolean resultado = campo.adicionaVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia1Acima() {
        Campo vizinho = new Campo(2, 3);
        boolean resultado = campo.adicionaVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia1Abaixo() {
        Campo vizinho = new Campo(4, 3);
        boolean resultado = campo.adicionaVizinho(vizinho);
        assertTrue(resultado);
    }

    //Testes da diagonal

    @Test
    void testeVizinhoRealDistancia2DiagonalEsquerdaSuperior() {
        Campo vizinho = new Campo(2, 2);
        boolean resultado = campo.adicionaVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia2DiagonalDireitaSuperior() {
        Campo vizinho = new Campo(2, 4);
        boolean resultado = campo.adicionaVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia2DiagonalEsquerdaInferior() {
        Campo vizinho = new Campo(4, 2);
        boolean resultado = campo.adicionaVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia2DiagonalDireitaInferior() {
        Campo vizinho = new Campo(4, 4);
        boolean resultado = campo.adicionaVizinho(vizinho);
        assertTrue(resultado);
    }
}