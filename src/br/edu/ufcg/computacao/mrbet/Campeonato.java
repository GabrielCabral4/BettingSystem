package br.edu.ufcg.computacao.mrbet;
import java.util.HashSet;
import java.util.Objects;

/**
 * Representação dos campeonatos presentes no MrBet
 *
 * @author Gabriel Cabral de Medeiros
 */
public class Campeonato {
    /**
     * Conjunto de times que participam de um campeonato
     */
    private HashSet<Time> timesEmCampeonato;
    /**
     * Nome de um campeonato
     */
    private String campeonato;
    /**
     * Número de participantes que um campeonato pode ter
     */
    private int participantes;

    /**
     * Constrói um campeonato a partir do seu nome e da quantidade de participantes que um campeonato pode ter
     * @param campeonato Nome do campeonato
     * @param participantes Quantidade de participantes que podem ter em um campeonato
     */
    public Campeonato(String campeonato, int participantes) {
        this.campeonato = campeonato;
        this.participantes = participantes;
        this.timesEmCampeonato = new HashSet<>();
    }

    /**
     * Método que adiciona um time em um campeonato
     * @param time Time que vai ser adicionado no campeonato
     * @return Retorna uma mensagem de confirmação de que o time foi adicionado no campeonato
     */
    public String adicionaTimeEmCampeonato(Time time){
        this.timesEmCampeonato.add(time);
        time.adicionarCampeonato(this);
        return "TIME ADICIONADO!";
    }

    /**
     * Método que compara objetos
     * @param o Objeto que vai ser comparado
     * @return Retorna um boolean de um campeonato ser igual ao outro
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campeonato that = (Campeonato) o;
        return participantes == that.participantes && Objects.equals(this.campeonato.toLowerCase(), that.campeonato);
    }

    /**
     * Método que retorna o hashcode de um campeonato
     * @return Retorna uma representação em forma de inteiro de um campeonato
     */
    @Override
    public int hashCode() {
        return Objects.hash(campeonato, participantes);
    }

    /**
     * Método retorna os times que participam de um campeonato
     * @return Retorna o conjunto que armazena os times que participam de um campeonato
     */
    public HashSet<Time> getTimesEmCampeonato() {
        return timesEmCampeonato;
    }

    /**
     * Método que retorna a quantidade de times que podem participar de um campeonato
     * @return Retorna a quantidade limite de participantes de um campeonato
     */
    public int getParticipantes() {
        return participantes;
    }

    /**
     * Método que retorna o nome de um campeonato
     * @return Retorna o nome do campeonato
     */
    public String getCampeonato() {
        return campeonato;
    }

}
