
public class Node
{
    private int x;
    private Node esquerdo;
    private Node direito;
    public Node(int x)
    {   
        this.x = x;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setEsquerdo(Node esquerdo){
        this.esquerdo = esquerdo;
    }

    public void setDireito(Node direito){
        this.direito = direito;
    }

    public int getX(){
        return this.x;
    }

    public Node getEsquerdo(){
        return this.esquerdo;
    }

    public Node getDireito(){
        return this.direito;
    }

}
