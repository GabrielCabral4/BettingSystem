package br.edu.ufcg.computacao.mrbet;
import java.util.HashSet;
import java.util.Objects;

/**
 * Representação dos todos os times presentes no MrBet.
 *
 * @author Gabriel Cabral de Medeiros
 */
public class Time {
    /**
     * Código de um time
     */
    private String codigo;
    /**
     * Nome de um time
     */
    private String nome;
    /**
     * Mascote de um time
     */
    private String mascote;
    /**
     * Conjunto que armazena os campeonatos que um time participa
     */
    private HashSet<Campeonato> campeonatosTimeParticipa = new HashSet<>();

    /**
     * Constrói um time a partir de seu código, nome e mascote
     * @param codigo Código de um time em formato de String
     * @param nome Nome de um time em formato de String
     * @param mascote Mascote de um time em formato de String
     */
    public Time(String codigo, String nome, String mascote){
        this.codigo = codigo;
        this.nome = nome;
        this.mascote = mascote;
    }

    /**
     * Método que retorna o código de um time
     * @return O código de um time
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Método que compara um time com outro
     * @param o Objeto o
     * @return Retorna um boolean do time ser igual ao outro
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time times = (Time) o;
        return Objects.equals(codigo, times.codigo) && Objects.equals(nome, times.nome) && Objects.equals(mascote, times.mascote);
    }

    /**
     * Método que retorna o hashcode de um time
     * @return Retorna a representação em formato de inteiro de um time
     */
    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, mascote);
    }

    /**
     * Método que adiciona um campeonato que o time participa
     * @param campeonato Campeonato no qual o time participa
     * @return Retorna uma String de confirmação de que o time foi adicionado
     */
    public String adicionarCampeonato(Campeonato campeonato){
        int tamanhoBase = campeonatosTimeParticipa.size();
        campeonatosTimeParticipa.add(campeonato);
        if(tamanhoBase == campeonatosTimeParticipa.size()) return "CAMPEONATO JÁ EXISTE!";
        return "CAMPEONATO ADICIONADO!";
    }

    /**
     * Método que retorna o Conjunto de que campeonatos que o time participa
     * @return Retorna o Conjunto de campeonatos que o time participa
     */
    public HashSet<Campeonato> getCampeonatosTimeParticipa() {
        return campeonatosTimeParticipa;
    }

    /**
     * Método que retorna o nome de um time
     * @return Retorna o nome do time
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que retorna o mascote de um time
     * @return Retorna o mascote de um time
     */
    public String getMascote() {
        return mascote;
    }
}
