import br.edu.ufcg.computacao.mrbet.Campeonato;
import br.edu.ufcg.computacao.mrbet.Time;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CampeonatoTest {
    Campeonato camp;
    Time time;
    @BeforeEach
    void setUp() {
        camp = new Campeonato("League", 10);
        time = new Time("158_PL", "Borussia", "Tigre");
    }

    @Test
    void adicionaTimeEmCampeonato() {
        assertEquals("TIME ADICIONADO!", camp.adicionaTimeEmCampeonato(time));
    }



    @Test
    void getTimesEmCampeonato() {
        camp.adicionaTimeEmCampeonato(time);
        assertEquals(1, camp.getTimesEmCampeonato().size());
    }

    @Test
    void getParticipantes() {
        assertEquals(10, camp.getParticipantes());
    }

    @Test
    void getCampeonato() {
        assertEquals("League", camp.getCampeonato());
    }
}