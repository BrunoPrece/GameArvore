
public class Arvore
{
    private Node raiz;
    public Arvore()
    {
        raiz = null;
    }

    public void inserir(Node _node){
        boolean direita = false;
        boolean esquerda =  false;
        if(raiz == null){
            raiz = _node;
        }else{
            Node aux = raiz;
            Node anterior = aux;
            while(aux != null){
                if(_node.getX()< raiz.getX()){
                    anterior = aux;
                    aux = aux.getEsquerdo();
                    esquerda = true;
                    direita = false;
                }else{
                    anterior = aux;
                    aux = aux.getDireito();
                    esquerda = false;
                    direita = true;
                }
            }

            if(direita == true){
                anterior.setDireito(_node);
            }else{
                anterior.setEsquerdo(_node);
            }
        }
    }

    /**
     * Método que elimina um determinado nó. Serão considerado três casos:
     * 1) O nó a ser apagado é uma folha (não tem filhos).
     * 2) O nó a ser apagado tem um filho
     * 3) O nó a ser apagado tem dois filhos.
     */
    public boolean remover(int id){
        Node atual = raiz;
        Node parente = raiz;
        boolean filhoEsquerda = true;
        // Percorrendo a arvore em busca de um nó. ( Caso o nó a ser removido seja encontrado, o mesmo é guardado no valor "parente").
        while(atual.getX() != id){ // busca um nó
            parente = atual;
            if(id < atual.getX()){ // vai para esquerda
                filhoEsquerda = true;
                atual = atual.getEsquerdo();
            } else { // vai para direita
                filhoEsquerda = false;
                atual = atual.getDireito();
            } 
            if(atual == null){
                break; // não encontrou
            }
        }
        // caso 1: se não há filho, simplesmente elimina-o
        if(atual.getDireito() == null && atual.getDireito() == null){
            if(atual == raiz){ // se atual for a raiz, quer dizer que a arvore ta vazia.
                raiz = null;
            } else if(filhoEsquerda){ 
                parente.setEsquerdo(null); // desconecta do pai
            } else {
                parente.setDireito(null); // // desconecta do pai
            }
            // caso 2: O nó a ser eliminado tem um filho.
        } else if(atual.getDireito() == null) { // se não tem filho a direita, substitui por subarvore a esquerda
            if(atual == raiz){
                raiz = atual.getEsquerdo();
            } else if(filhoEsquerda){ // filho a esquerda do pai (parente)
                parente.setEsquerdo(atual.getEsquerdo());
            } else {  // filho a direita do pai
                parente.setDireito(atual.getDireito());
            }
            // se não tem filho a esquerda, substitui por subarvore a direita
        } else if(atual.getEsquerdo() == null) {
            if(atual == raiz) {
                raiz = atual.getDireito();
            } else if(filhoEsquerda) { // filho da esquerda
                parente.setEsquerdo(atual.getDireito());
            } else {
                parente.setDireito(atual.getDireito()); // filho a direita do pai
            }

            // caso 3: O nó a ser eliminado tem dois filhos
        } else {
            // obtem sucessor do nó a ser eliminado (atual)
            Node herdeiro = getHerdeiro(atual);

            // conecta o pai do atual ao sucessor
            if(atual == raiz) {
                raiz = herdeiro;
            } else if(filhoEsquerda){
                parente.setEsquerdo(herdeiro);

            } else { 
                parente.setDireito(herdeiro);
            }
            // conecta sucessor ao filho da esquerda do atual
            herdeiro.setEsquerdo(atual.getEsquerdo());

        }
        return true;
    }

    /**
     * Método que vai localizar o sucessor. Retorna o nó com o proximo valor mais alto depois do node do parametro.
     * Vai p/ filho a direita, então p/ descendentes dele a esquerda.
     * 
     * @param node
     * @return herdeiro
     */
    public Node getHerdeiro(Node node){
        Node herParente = node;
        Node herdeiro = node;
        Node atual = node.getDireito(); 

        while(atual != null){
            herParente = herdeiro;
            herdeiro = atual;
            atual = atual.getEsquerdo();
        }

        // se o sucessor não é o filho à direita, faz as conexões do herdeiro.
        if(herdeiro != node.getDireito()){
            herParente.setEsquerdo(herdeiro.getDireito());
            herdeiro.setDireito(node.getDireito());
        }
        return herdeiro;
    }

}