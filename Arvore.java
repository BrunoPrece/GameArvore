
import javax.swing.ImageIcon;
public class Arvore {
    private No raiz;
    private No nulo;

    public Arvore() {
        raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }

    /**
     * Inserir sem recursividade.
     *
     */
    public void inserirSemRecursividade(No no) {

        if (isEmpty()) {
            raiz = no;
        } else {
            No atual = raiz;
            No pai;
            while (true) {
                pai = atual;
                if (no.getNivel() < atual.getNivel()) {
                    atual = atual.getEsquerda();
                    if (atual == null) {
                        pai.setEsquerda(no);
                        return;
                    }
                } else {
                    atual = atual.getDireita();
                    if (atual == null) {
                        pai.setDireita(no);
                        return;
                    }
                }
            }

        }

    }

    public void delete(int valor) {
        No atual = raiz;
        No pai = raiz;
        boolean isFilhoEsquerdo = true;
        while (atual.getNivel() != valor) {
            pai = atual;
            if (valor < atual.getNivel()) {
                isFilhoEsquerdo = true;
                atual = atual.getEsquerda();
            } else {
                isFilhoEsquerdo = false;
                atual = atual.getDireita();
            }
            if (atual == null) {
                break;
            }
        }
        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            if (atual == raiz) {
                raiz = null;
            } else if (isFilhoEsquerdo) {
                pai.setEsquerda(null);
            } else {
                pai.setDireita(null);
            }
        } else if (atual.getDireita() == null) {
            if (atual == raiz) {
                raiz = atual.getEsquerda();
            } else if (isFilhoEsquerdo) {
                pai.setEsquerda(atual.getEsquerda());
            } else {
                pai.setDireita(atual.getDireita());
            }
        } else if (atual.getEsquerda() == null) {
            if (atual == raiz) {
                raiz = atual.getDireita();
            } else if (isFilhoEsquerdo) {
                pai.setEsquerda(atual.getDireita());
            } else {
                pai.setDireita(atual.getDireita());
            }
        } else {//two children
            No herdeiro = getHerdeiro(atual);
            if (atual == raiz) {
                raiz = herdeiro;
            } else if (isFilhoEsquerdo) {
                pai.setEsquerda(herdeiro);
            } else {
                pai.setDireita(herdeiro);
            }
            herdeiro.setEsquerda(atual.getEsquerda());
        }

    }

    /**
     * Função para buscar o herdeiro.
     */
    private No getHerdeiro(No No) {
        No herdeiroParent = No;
        No herdeiro = No;
        No atual = No.getDireita();
        while (atual != null) {
            herdeiroParent = herdeiro;
            herdeiro = atual;
            atual = atual.getEsquerda();
        }
        if (herdeiro != No.getDireita()) {
            herdeiroParent.setEsquerda(herdeiro.getDireita());
            herdeiro.setDireita(No.getDireita());
        }
        return herdeiro;
    }

    public void inOrder(No no) {
        if (no != null) {
            inOrder(no.getEsquerda());
            System.out.print(no.getNivel() + " ");
            inOrder(no.getDireita());
        }
    }


    /**
     *
     * @return
     */
    public boolean isEmpty() {
        if (raiz == null) {
            return true;
        }
        return false;
    }

}
