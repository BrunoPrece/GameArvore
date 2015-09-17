
/**
 * Escreva a descrição da classe No aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class No
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    int nivel;
    int jogadas;
    No direita;
    No esquerda;
    /**
     * COnstrutor para objetos da classe No
     */
    public No(int nivel, int jogadas)
    {
        this.nivel = nivel;
        this.jogadas = jogadas;
    }

    public int getNivel(){
        return this.nivel;
    }

    public int getJogadas(){
        return this.jogadas;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;

    }
}
