import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


class MrBetSistemaTest {
    MrBetSistema mrBetSistema;
    @BeforeEach
    void setUp() {
        mrBetSistema = new MrBetSistema();
        mrBetSistema.incluirTimes("250_PB", "Nacional de Patos", "Canário");
        mrBetSistema.incluirTimes("252_PB", "Sport Lagoa Seca", "Carneiro");
        mrBetSistema.incluirTimes("002_RJ", "Clube de Regatas do Flamengo", "Urubu");
        mrBetSistema.incluirTimes("105_PB", "Sociedade Recreativa de Monteiro (SOCREMO)", "Gavião");
    }

    @Test
    void incluirTimes() {
        assertEquals("TIME JÁ EXISTE!", mrBetSistema.incluirTimes("250_PB", "Nacional de Patos", "Canário"));
    }

    @Test
    void recuperarTime() {
        assertEquals("[250_PB] Nacional de Patos / Canário", mrBetSistema.recuperarTime("250_PB"));
    }

    @Test
    void exibirCampeonatosTimeParticipa() {
        //assertEquals();
    }

    @Test
    void adicionarCampeonato() {
        assertEquals("INCLUSÃO REALIZADA!", mrBetSistema.adicionarCampeonato("Brasileirão Série A 2023", 1));
        mrBetSistema.adicionarCampeonato("Brasileirão Série A 2023", 1);
        assertEquals("CAMPEONATO JÁ EXISTE!", mrBetSistema.adicionarCampeonato("Brasileirão Série A 2023", 1));
    }

    @Test
    void incluirTimeCampeonato() {
        mrBetSistema.adicionarCampeonato("Brasileirão Série A 2023", 1);
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBetSistema.incluirTimeCampeonato("250_PB", "Brasileirão Série A 2023"));
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBetSistema.incluirTimeCampeonato("252_PB", "Brasileirão Série A 2023"));
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBetSistema.incluirTimeCampeonato("252_PB", "Brasileirão Série A 2023"));
        assertThrows(NullPointerException.class, () -> mrBetSistema.incluirTimeCampeonato("005_PB","Brasileirão Série A 2023"));
        assertThrows(NullPointerException.class, () -> mrBetSistema.incluirTimeCampeonato("252_PB", "Brasileirão Série D 2023"));
        mrBetSistema.adicionarCampeonato("Brasileirão Série A 2023",1);
        mrBetSistema.incluirTimeCampeonato("252_PB", "Brasileirão Série A 2023");
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBetSistema.incluirTimeCampeonato("252_PB", "Brasileirão Série A 2023"));
        mrBetSistema.incluirTimeCampeonato("250_PB", "Brasileirão Série A 2023");
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBetSistema.incluirTimeCampeonato("250_PB", "Brasileirão Série A 2023"));
    }
    @Test
    void verificaTimeCampeonato() {
        mrBetSistema.adicionarCampeonato("Copa do Nordeste 2023", 4);
        mrBetSistema.incluirTimeCampeonato("250_PB", "Copa do Nordeste 2023");
        assertEquals("O TIME ESTÁ NO CAMPEONATO!", mrBetSistema.verificaTimeCampeonato("250_PB", "Copa do Nordeste 2023"));
        assertEquals("O TIME NÃO ESTÁ NO CAMPEONATO!", mrBetSistema.verificaTimeCampeonato("252_PB", "Copa do Nordeste 2023"));
        assertThrows(NullPointerException.class, () -> mrBetSistema.verificaTimeCampeonato("252_PB", "Copa do Nordeste 2023"));
        assertThrows(NullPointerException.class, () -> mrBetSistema.verificaTimeCampeonato("005_PB", "Copa do Nordeste 2023"));
    }
    @Test
    void apostar() {
        Campeonato camp = new Campeonato("Copa do Brasil 2023", 10);
        assertEquals("APOSTA REGISTRADA!", mrBetSistema.apostar("252_PB", camp, 1, 50));
    }

    @Test
    void statusApostas() {
        assertNotNull(mrBetSistema.statusApostas());
    }

}