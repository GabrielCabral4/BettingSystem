package br.edu.ufcg.computacao.mrbet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApostaTest {
    private Aposta aposta;
    @BeforeEach
    void setUp() {
        aposta = new Aposta(new Time(("123_OB"), "Bayern", "Cachorro"), new Campeonato("Champions", 20), 20, 50);
    }

    @Test
    void getTime() {
        assertEquals("123_OB", aposta.getTime().getCodigo());
    }

    @Test
    void getCamp() {
        assertEquals("Champions", aposta.getCamp().getCampeonato());
    }

    @Test
    void getValorAposta() {
        assertEquals(50, aposta.getValorAposta());
    }
}