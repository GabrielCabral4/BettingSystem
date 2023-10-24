import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeTest {
    private Time time;
    private Campeonato camp;
    @BeforeEach
    void setUp() {
        time = new Time("123_OB", "Bayern", "Hipopotamo");
        camp = new Campeonato("Champions", 2);
    }

    @Test
    void getCodigo() {
        assertEquals("123_OB", time.getCodigo());
    }


    @Test
    void adicionarCampeonato() {
        assertEquals("CAMPEONATO ADICIONADO!", time.adicionarCampeonato(camp));
    }

    @Test
    void getCampeonatosTimeParticipa() {
        time.adicionarCampeonato(camp);
        assertEquals(1, time.getCampeonatosTimeParticipa().size());
    }

    @Test
    void getNome() {
        assertEquals("Bayern", time.getNome());
    }

    @Test
    void getMascote() {
        assertEquals("Hipopotamo", time.getMascote());
    }
}