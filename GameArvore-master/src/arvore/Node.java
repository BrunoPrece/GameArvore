package arvore;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Node {

    private Image image;
    private Node direita;
    private Node esquerda;
    private String botao;
    private String icone;
    private int x;

    public Node(String icone) {
        this.icone = icone;
        ImageIcon novaImagem = new ImageIcon(this.getClass().getResource(icone));
    }

    public Image getImage() {
        return image;
    }

    public void setImage(String icone) {
        this.icone = icone;
        ImageIcon novaImagem = new ImageIcon(this.getClass().getResource(icone));
    }

    public String getBotao() {
        return botao;
    }

    public void setBotao(String botao) {
        this.botao = botao;
    }

    public Node getDireita() {
        return direita;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getIcon() {
        return this.icone;
    }

}
