
import arvore.Node;
import java.util.*;

/**
 * Write a description of class Arvore here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Arvore {

    // instance variables - replace the example below with your own
    private Node raiz;

    public Arvore() {
        raiz = null;
    }

    public Node getRaiz() {
        return raiz;
    }

    /**
     * Inserir sem recursividade.
     *
     */
    public void inserirSemRecursividade(Node no) {

        if (isEmpty()) {
            raiz = no;
        } else {
            Node atual = raiz;
            Node pai;
            while (true) {
                pai = atual;
                if (no.getX() < atual.getX()) {
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
        Node atual = raiz;
        Node pai = raiz;
        boolean isFilhoEsquerdo = true;
        while (atual.getX() != valor) {
            pai = atual;
            if (valor < atual.getX()) {
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
            Node herdeiro = getHerdeiro(atual);
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
    private Node getHerdeiro(Node node) {
        Node herdeiroParent = node;
        Node herdeiro = node;
        Node atual = node.getDireita();
        while (atual != null) {
            herdeiroParent = herdeiro;
            herdeiro = atual;
            atual = atual.getEsquerda();
        }
        if (herdeiro != node.getDireita()) {
            herdeiroParent.setEsquerda(herdeiro.getDireita());
            herdeiro.setDireita(node.getDireita());
        }
        return herdeiro;
    }

    public void inOrder(Node no) {
        if (no != null) {
            inOrder(no.getEsquerda());
            System.out.print(no.getX() + " ");
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
