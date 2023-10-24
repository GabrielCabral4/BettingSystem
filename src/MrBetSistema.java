import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representação do controlador no MrBet
 *
 * @author Gabriel Cabral De Medeiros
 */
public class MrBetSistema {
    /**
     * Mapa que tem uma String como chave e um Time como valor
     */
    private HashMap<String, Time> mapaTimesCodigo = new HashMap<>();
    /**
     * Mapa que tem uma String como chave e um Campeonato como valor
     */
    private HashMap<String, Campeonato> mapaCampeonatos = new HashMap<>();
    /**
     * Lista que armazena as apostas feitas no sistema
     */
    private ArrayList<Aposta> apostas = new ArrayList<>();

    /**
     * Método que inclui times no sistema
     * @param codigo Código identificador de um time
     * @param nome Nome do time
     * @param mascote Mascote de um time
     * @return Retorna uma String de confirmação da operação
     */

    public String incluirTimes(String codigo, String nome, String mascote){
        Time time = getTimeCodigo(codigo);
        if(time != null){
            return "TIME JÁ EXISTE!";
        }
        time = new Time(codigo, nome, mascote);
        this.mapaTimesCodigo.put(codigo.toUpperCase(), time);
        return "INCLUSÃO REALIZADA!";
    }

    public Time getTimeCodigo(String codigo){
        return mapaTimesCodigo.get(codigo.toUpperCase());
    }
    public Campeonato getCampeonatoNome(String campeonato){
        return mapaCampeonatos.get(campeonato.toUpperCase());
    }

    /**
     * Método que recupera um time dentro do mapa de Times
     * @param codigo Identificador único de um time
     * @return Retorna uma representação do time associando o seu código, nome e mascote
     */
    public String recuperarTime(String codigo){
        Time time = getTimeCodigo(codigo);
        if(time == null){
            return "TIME NÃO EXISTE!";
        }
        return "[" + codigo + "] " + time.getNome() + " / " + time.getMascote();
    }

    /**
     * Méotodo que exibe os campeonatos que um time participa
     * @param codigo Identificador único de um time
     * @return Retorna uma representação textual das informações de um time
     */
    public String exibirCampeonatosTimeParticipa(String codigo){
        Time time = getTimeCodigo(codigo);
        if(time == null){
            throw new NullPointerException("TIME NÃO EXISTE!");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Campeonato do ").append(getTimeCodigo(codigo).getNome()).append(":\n");
        for  (Campeonato camp:
        getTimeCodigo(codigo).getCampeonatosTimeParticipa()) {
            sb.append("* ").append(camp.getCampeonato()).append(" - ").append(camp.getTimesEmCampeonato().size()).append("/").append(camp.getParticipantes()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Método que adiciona times em um campeonato
     * @param campeonato Campeonato que vai ser cadastrado no sistema
     * @param participantes Quantidade máxima de participantes que um campeonato pode ter
     * @return Retorna uma confirmação de que o campeonato foi adicionado
     */
    public String adicionarCampeonato(String campeonato, int participantes){
        Campeonato camp = new Campeonato(campeonato, participantes);
        if(getCampeonatoNome(campeonato) != null){
            return "CAMPEONATO JÁ EXISTE!";
        }
        this.mapaCampeonatos.put(campeonato.toUpperCase(), camp);
        return "INCLUSÃO REALIZADA!";
    }

    /**
     * Método que inclui um time em um campeonato
     * @param codigo Identificador único de um time
     * @param campeonato Campeonato no qual o time vai ser incluído
     * @return Caso o time seja incluído em um campeonato, retorna uma confirmação textual
     */
    public String incluirTimeCampeonato(String codigo, String campeonato){
        Time time = getTimeCodigo(codigo);
        Campeonato camp = getCampeonatoNome(campeonato);
        if(time == null){
            throw new NullPointerException("TIME NÃO EXISTE!");
        }
        if(camp == null){
            throw new NullPointerException("CAMPEONATO NÃO EXISTE!");
        }
        if(camp.getParticipantes() < camp.getTimesEmCampeonato().size()){
            camp.adicionaTimeEmCampeonato(time);
        }
            return "TIME INCLUÍDO NO CAMPEONATO!";
    }

    /**
     * Método que verifica se um time participa de um campeonato
     * @param codigo Identificador único de um time
     * @param campeonato Campeonato que será verificado se o time participa
     * @return Retorna uma representação textual que confirma se o time faz parte ou não
     */
    public String verificaTimeCampeonato(String codigo, String campeonato){
        Time time = getTimeCodigo(codigo);
        Campeonato camp = getCampeonatoNome(campeonato);
        if(time == null){
            throw new NullPointerException("TIME NÃO EXISTE!");
        }
        if(camp == null){
            throw new NullPointerException("CAMPEONATO NÃO EXISTE!");
        }
        for (Campeonato c:
             time.getCampeonatosTimeParticipa()) {
            if(c.getCampeonato().equals(campeonato))
                return "TIME ESTÁ NO CAMPEONATO!";
        }
        return "TIME NÃO ESTÁ NO CAMPEONATO!";

    }
    /** Método que registra uma aposta no sistema
     * @param codigo Identificador único de um time
     * @param camp Campeonato no qual será feita a aposta
     * @param colocacao Colocação no qual é esperado  que o time termine na aposta
     * @param valorAposta Valor apostado
     * @return Retorna uma confirmação se a aposta foi feita ou não
     */
    public String apostar(String codigo, Campeonato camp, int colocacao, double valorAposta){
        Time time = getTimeCodigo(codigo);
        if(colocacao > camp.getParticipantes()){
            return "APOSTA NÃO REGISTRADA!";
        }
        if(time == null){
            throw new NullPointerException("TIME NÃO EXISTE!");
        }
        if(camp == null){
            throw new NullPointerException("CAMPEONATO NÃO EXISTE!");
        }
        Aposta aposta = new Aposta(time, camp, colocacao, valorAposta);
        this.apostas.add(aposta);
        return "APOSTA REGISTRADA!";
    }

    /**
     * Método que verifica o status de uma aposta
     * @return Retorna uma representação textual de uma aposta
     */
    public String statusApostas(){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < apostas.size(); i++) {
            Time time = apostas.get(i - 1).getTime();
            Campeonato camp = apostas.get(i - 1).getCamp();
            Aposta aposta = apostas.get(i - 1);
            sb.append(i).append(". ").append("[").append(time.getCodigo()).append("] ").append(time.getNome()).append(" / ").append(time.getMascote()).append("\n").append(camp.getCampeonato()).append("\n").append(camp.getTimesEmCampeonato().size()).append("/").append(camp.getParticipantes()).append("\n").append(aposta.getValorAposta());
        }
            return sb.toString();
    }

}