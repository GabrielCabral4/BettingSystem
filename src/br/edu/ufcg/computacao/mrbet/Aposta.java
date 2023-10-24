package br.edu.ufcg.computacao.mrbet;
/**
 * Representação das apostas dentro do MrBet
 */
public class Aposta {
    /**
     * Colocação de um time na aposta feita
     */
    private int colocacao;
    /**
     * Valor que foi apostado
     */
    private double valorAposta;
    /**
     * Time
     */
    private Time time;
    /**
     * Campeonato
     */
    private Campeonato camp;

    /**
     * Constrói uma aposta a partir de um time, um campeonato, a colocação que se espera que o time termine e o valor apostado
     * @param time Time no qual será apostado
     * @param camp Campeonato no qual o time estará competindo
     * @param colocacao Colocação no qual será apostado que o time termine
     * @param valorAposta Valor apostado
     */
    public Aposta(Time time, Campeonato camp, int colocacao, double valorAposta){
        this.time = time;
        this.colocacao = colocacao;
        this.valorAposta = valorAposta;
        this.camp = camp;
    }

    /**
     * Método que retorna um time
     * @return Retorna o time
     */
    public Time getTime() {
        return this.time;
    }

    /**
     * Método que retorna um campeonato
     * @return Retorna o campeonato
     */
    public Campeonato getCamp() {
        return camp;
    }

    /**
     * Método que retorna o valor da aposta
     * @return Retorna o valor da aposta
     */
    public double getValorAposta() {
        return valorAposta;
    }

}
