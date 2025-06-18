package com.br.michael.cm.modelo;

import com.br.michael.cm.excessao.ExplosaoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

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

    @Test
    void testeValorPadraoAtributoMarcado() {
        assertFalse(campo.isMarcado());
    }

    @Test
    void testeAlternarMarcacao() {
        campo.alterarMarcacao();
        assertTrue(campo.isMarcado());
    }

    @Test
    void testeAlternarMarcacaoDuasChamadas() {
        campo.alterarMarcacao();
        campo.alterarMarcacao();
        assertFalse(campo.isMarcado());
    }

    @Test
    void testeAbrirCampoNaoMarcadoENaoMiado() {
        assertTrue(campo.abrir());
    }

    @Test
    void testeAbrirNaoMinadoMarcado() {
        campo.alterarMarcacao();
        assertFalse(campo.abrir());
    }

    @Test
    void testeAbrirMinadoMarcado() {
        campo.alterarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());
    }

    @Test
    void testeAbrirMinadoENaoMarcado() {
        campo.minar();
        assertThrows(ExplosaoException.class, () -> {
            campo.abrir();
        });
    }

    @Test
    void testeAbrirComVizinhoDoVizinho() {

        Campo campo11 = new Campo(1, 1);
//        Campo campo12 = new Campo(1,1);
        campo11.minar();

        Campo campo22 = new Campo(2, 2);
        campo22.adicionaVizinho(campo11);
//        campo22.adicionaVizinho(campo12);

        campo.adicionaVizinho(campo22);
        campo.abrir();

        assertTrue(campo22.isAberto() && campo11.isFechado());
    }


    @Test
    void testeAcessoLinhaVizinho() {
        assertEquals(3, campo.getLinha());
    }

    @Test
    void testeAcessoColunaVizinho() {
        assertEquals(3, campo.getColuna());
    }

    @Test
    void testeObjetivoAlcancadoCampoMarcadoEMinado() {
        campo.minar();
        campo.alterarMarcacao();
        assertTrue(campo.objetivoAlcancado(), "Campo minado e marcado");
    }

    @Test
    void testeObjetivoNaoAlcancado() {
        assertFalse(campo.objetivoAlcancado(), "Campos não abertos, sem marcação e sem mina");
    }

    @Test
    void testeQuantidadeMinasNaVizinhanca() {
        Campo vizinho1 = new Campo(3, 2);
        Campo vizinho2 = new Campo(2, 3);

        vizinho1.minar();
        vizinho2.minar();

        campo.adicionaVizinho(vizinho1);
        campo.adicionaVizinho(vizinho2);

        assertEquals(2, campo.minasVizinhanca(), "Deve haver duas minas na vizinhança");
    }

    @Test
    void testandoReinicioDoJogo() {
        campo.abrir();
        campo.minar();
        campo.alterarMarcacao();

        campo.reiniciar();

        assertFalse(campo.isAberto(), "Campo deve estar fechado após reiniciar");
        assertFalse(campo.isMarcado(), "Campo deve estar desmarcado após reiniciar");

    }

    @Test
    void testeToStringFechado() {
        assertEquals("?",campo.toString(),"Campo deve exibir ?");
    }

    @Test
    void testeToStringCampoMarcado(){
        campo.alterarMarcacao();
        assertEquals("X",campo.toString(),"Campo marcado com um X" );
    }

    @Test
    void testeToStringCampoAbertoMinado(){
        campo.minar();

        assertThrows(ExplosaoException.class, () -> {
            campo.abrir();
        });
    }

    @Test
    void testeToStringAbertoSemMinaNaVizinhanca(){
        campo.abrir();
        assertEquals(" ",campo.toString(),"Campo aberto sem minas, deve ser em branco");
    }


}