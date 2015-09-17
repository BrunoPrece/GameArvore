
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Puzzle0 extends JFrame implements ActionListener {

    // Objeto tipo JPanel - Painel Central da Aplicação
    private JPanel centerPanel;
    // Objeto tipo JButton - Botão do Painel
    private JButton button;
    // Objeto tipo JLabel - Rótulo
    private JLabel label;
    String img;
    int nivelAux = 1;
    Arvore arvoreDeNiveis =  new Arvore();
    private Image source;
    private Image image;
    // Matriz de Posições
    int[][] pos;
    // Largura e Altura da Janela 
    int width, height;
    // Matriz de Correção das Posições
    String [] correto;
    // Contador de Movimentos:
    int clique = 0;
    // Contador inicial de tempo de execução;
    long timeinicio = System.currentTimeMillis();
    public Puzzle0(String img, int nivel){
        this(img);
        this.nivelAux = nivel;
    }

    // Método Construtor do Nível Escolhido - Recebe como argumento a Imagem escolhida pelo Jogador 
    public Puzzle0(String img) {
        this.img = img;

        //MATRIZ PARA MONTAR O TOTAL DE PEÇAS DO PUZZLE, NESSA MATRIZ 5X5 TOTAL DE 25 PEÇAS. 
        pos = new int[][] {
            {0, 1, 2}, 
            {3, 4, 5}, 
            {6, 7, 8}
        };

        //ARRAY DE CORREÇÃO DAS POSIÇÕES DE CADA PEÇA, SER�? UTILIZADO PARA RECONHECER QUANDO O PUZZLE EST�? MONTADO CORRETAMENTE.
        correto = new String[] {"00","01","02",
            "10","11","12",
            "20","21","22"};

        //INSTANCIA DO JPANEL
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 3, 0, 0));

        //SELECIONA A IMAGEM PARA SER MOSTRADA NA TELA INICIAL
        ImageIcon sid = new ImageIcon(Puzzle0.class.getResource(img));
        source = sid.getImage();

        ///RECEBE A LARGURA DA IMAGEM
        width = sid.getIconWidth();
        ///RECEBE A ALTURA DA IMAGEM
        height = sid.getIconHeight();

        //TELA COM A IMAGEM EM TAMANHO REAL, SER�? MOSTRADA PARA CONHECIMENTO DO JOGADOR
        ImageIcon nivel2 = new ImageIcon(Puzzle0.class.getResource(img)); 
        //INSTANCIA UM OBJETO LABEL QUE RECEBER�? A IMAGEM COMO RÓTULO
        JLabel label2 = new JLabel(nivel2);
        //MENSAGEM DE BOAS VINDAS
        JOptionPane.showMessageDialog(null,label2 , "Pronto Para Começar??", JOptionPane.PLAIN_MESSAGE);  

        add(Box.createRigidArea(new Dimension(0, 3)), BorderLayout.NORTH);    
        add(centerPanel, BorderLayout.CENTER);

        //DOIS LAÇOS, UM PARA AS LINHAS E OUTRO PARA AS COLUNAS, PARA CORTAR A IMAGEM E GERAR OS BOTOES, ONDE CADA UM RECEBERA UMA PARTE DA IMAGEM
        //NESTE MOMENTO A IMAGEM SER�? CORTADA, MAS CADA PEÇA CONTINUARA EM SUA POSICAO INICIAL
        for ( int i = 0; i < 3; i++) {

            for ( int j = 0; j < 3; j++) {
                //SE FOR A ULTIMA POSIÇÃO DA MATRIZ, É A ULTIMA POSIÇÃO DO PUZZLE
                if ( j == 2 && i == 2) {
                    ///SETAR A LABEL EM BRANCO, PARA CONSEGUIR MOVER OS BOTOES.
                    label = new JLabel("");
                    label.setName(Integer.toString(i)+Integer.toString(j));
                    centerPanel.add(label);
                } else {
                    //SE NAO FOR A ULTIMA POSIÇAO DA MATRIZ, INSTANCIA UM JBUTTON
                    button = new JButton();
                    ///SETAR O NOME DO BOTAO COM O VALOR DA VARIAVEL (i - LINHA) E CONCATENA COM O VALOR DA VARIAVEL (j - COLUNA)
                    ///O NOME É SETADO ASSIM POIS SER�? UTILIZADO PARA COMPARAÇÃO EM CADA MOVIMENTO COM O ARRAY correto DE POSIÇÕES -> 00, 01, 02
                    button.setName(Integer.toString(i)+Integer.toString(j));
                    //ADICIONAR BOTÃO NA LISTA DE AÇÕES
                    button.addActionListener(this);
                    //ADICIONAR O BOTAO NO PAINEL
                    centerPanel.add(button);
                    //RECORTAR A IMAGEM COM O TAMANHO EXATO DO BOTAO
                    image = createImage(new FilteredImageSource(source.getSource(),new CropImageFilter(j*width/3, i*height/3, (width/3)+1, height/3)));
                    //SETAR A PARTE RECORTADA DA IMAGEM COMO ICONE DO BOTAO.
                    button.setIcon(new ImageIcon(image));
                }

            }

        }

        // RANDOM PARA EMBARALHAR A IMAGEM - A PARTIR DESTE PONTO A IMAGEM SER�? EMBARALHADA PARA O INICIO DO JOGO     
        Random rand = new Random();
        //LISTA PARA RECEBER O TOTAL DE PEÇAS DO PUZZLE
        ArrayList<Integer> listaI = new ArrayList<Integer>(); 
        //DECLARANDO VARIAVEIS DE CONTROLE.
        int numero = 0;  
        int count = 0;
        ///LAÇO PARA GERAR NUMEROS RANDOMICOS, CONDIÇÃO PARA A LISTA SER DO TAMANHO DO TOTAL DE PEÇAS
        while(count < 8)  
        {  
            //METODO QUE FAZ GERAR OS NUMEROS RANDOMICOS COM O MAIOR VALOR IGUAL A 24.
            numero = rand.nextInt(8) + 0;
            //SE O NUMERO GERADO RANDOMICAMENTE AINDA NÃO EXISTIR NA LISTA INSERIR O NUMERO NA LISTA E INCREMENTAR A VARIAVEL COUNT
            if(listaI.contains(numero) == false)  
            { 
                System.out.println(numero);
                listaI.add(numero);  
                count++;
            }  
        }
        System.out.println("LISTA : "+listaI.size());

        ///LAÇO QUE VAI EMBARALHAR O PUZZLE, COMEÇANDO EM  0 E VAI ATÉ O TAMANHO TOTAL DA LISTA CRIADA.
        for(int i=0;i<listaI.size();i++){

            System.out.println("Valor : "+listaI.get(i));
            // centerPanel.remove(0);

            //ADICIONAR NO PAINEL OS BOTOES DE ACORDO COM OS INDICES DA LISTA QUE CONTEM OS VALORES RANDOMICOS. 
            centerPanel.add(centerPanel.getComponent(listaI.get(i)),i);
            // centerPanel.add(centerPanel.getComponent(i),listaI.get(i));
            // centerPanel.validate();
        }
        centerPanel.validate();

        // Fim do Embaralhamento
        // Fim do Embaralhamento 

        //INFORMAÇÕES DA TELA//
        ///TAMANHO DA TELA
        setSize(400, 586);
        //TITULO DA TELA
        setTitle("Puzzle Nível "+nivelAux);
        //NÃO DEIXAR REDIMENSIONAR A TELA
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ///SETA TRUE PARA TELA SER VISIVEL
        setVisible(true);
    }

    //FUNÇAO PARA AS AÇÕES DO JOGADOR.
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        //PEGA O TAMANHO DO PAINEL
        Dimension size = button.getSize();

        //RECEBE A LARGURA DA LABEL.
        int labelX = label.getX();
        //RECEBE A ALTURA DA LABEL.
        int labelY = label.getY();

        ///RECEBE A LARGURA DO BOTAO
        int buttonX = button.getX();
        ///RECEBE A ALTURA DO BOTAO
        int buttonY = button.getY();

        int buttonPosX = buttonX / size.width;
        int buttonPosY = buttonY / size.height;

        //RECEBE A POSIÇAO DO BOTAO
        int buttonIndex = pos[buttonPosY][buttonPosX];

        //Contador de Movimentos, CADA VEZ É CLICADO A VARIAVEL CLIQUE É INCREMENTADA
        clique = clique + 1;

        //VERIFICAÇOES PARA IDENTIFICAR A POSIÇÃO QUE EST�? LIVRE E A POSIÇÃO QUE O BOTAO VAI SER MOVIMENTADO.
        //QUANDO A POSIÇÃO ABAIXO DO BOTAO ESTIVER VAZIA
        if (labelX == buttonX && (labelY - buttonY) == size.height ) {

            //ADICIONAR 3 AO INDICE DO BOTAO;
            int labelIndex = buttonIndex + 3;

            //REMOVER O BOTAO QUE FOI CLICADO.
            centerPanel.remove(buttonIndex);
            //ADICIONAR A LABEL VAZIA NO LUGAR DO BOTAO CLICADO.
            centerPanel.add(label, buttonIndex);
            //ADICIONAR O BOTAO NO LUGAR QUE ESTAVA VAGO, A VARIAVEL labelIndex DEFINE O VALOR QUE ESTAVA VAZIO.
            //COMO AQUI É SOMADO O VALOR DA LABELINDEX SABE-SE A DIREÇÃO DO MOVIMENTO
            centerPanel.add(button,labelIndex);
            centerPanel.validate();
        }
        //QUANDO A POSIÇÃO ACIMA DO BOTAO ESTA VAZIA   
        if (labelX == buttonX && (labelY - buttonY) == -size.height ) {

            int labelIndex = buttonIndex - 3;

            //FAZ A INVERSÃO DAS POSIÇÕES - REMOVE O LABEL
            centerPanel.remove(labelIndex);
            // ADICIONA O BOTÃO NO LUGAR DO LABEL
            centerPanel.add(button,labelIndex);
            // ADICIONA O LABEL NO LUGAR DO BOTÃO
            centerPanel.add(label, buttonIndex);
            // VALIDA O PAINEL - APLICAR ALTERAÇÕES
            centerPanel.validate();
        }
        //QUANDO O POSIÇÃO A DIREITA DO BOTAO ESTA VAZIA 
        if (labelY == buttonY && (labelX - buttonX) == size.width ) {

            int labelIndex = buttonIndex + 1;
            // FAZ A INVERSÃO DAS POSIÇÕES
            centerPanel.remove(buttonIndex);
            centerPanel.add(label, buttonIndex);
            centerPanel.add(button,labelIndex);
            centerPanel.validate();
        }
        //QUANDO O POSIÇÃO A ESQUERDA DO BOTAO ESTA VAZIA
        if (labelY == buttonY && (labelX - buttonX) == -size.width ) {

            int labelIndex = buttonIndex - 1;
            // FAZ A INVERSÃO DAS POSIÇÕES
            centerPanel.remove(buttonIndex);
            centerPanel.add(label, labelIndex);
            centerPanel.add(button,labelIndex);
            centerPanel.validate();
        }

        // VARIAVEL DE CONTROLE
        int erro = 0;

        // FOR PARA TESTAR SE TODOS OS BOTOES ESTÃO EM SUAS RESPECTIVAS POSIÇÕES ORIGINAIS.
        for ( int i = 0; i < 9; i++) {

            // COMPARA O VALOR DO NOME DO BOTAO CORRENTE COM A TABELA DE POSICOES.
            if(centerPanel.getComponent(i).getName().equals(correto[i])){

                // SE TODOS OS BOTOES ESTIVEREM EM SUAS POSIÇÕES ORIGINAIS O VALOR DA VARIAVEL DE CONTROLE 
                // erro = 0, NÃO SER�? ALTERADA E A IMAGEM SER�? CONSIDERADA COMO "CORRETA"

            }
            else {

                // CASO ALGUM BOTÃO ESTEJA EM SEU LUGAR ORIGINAL, A VARIAVEL DE CONTROLE TER�? SEU VALOR ALTERADO
                // DESTA FORMA A IMAGEM CONTINUAR�? A SER CLASSIFICADA COMO "NÃO MONTADA"
                erro = 1;
            }

        }
        // SE O VALOR DA VARIAVEL DE CONTROLE "erro" FOR IGUAL A ZERO, A IMAGEM FOI MONTADA CORRETAMENTE
        if(erro == 0) {
            // RECEBE O TEMPO TOTAL PARA CONCLUSÃO DA TAREFA DE MONTAGEM DO QUEBRA CABEÇA
            long timefim = System.currentTimeMillis();

            // EXIBE NA TELA O TEMPO PARA MONTAGEM DA IMAGEM E A QUANTIDADE CLIQUES NECESS�?RIOS PARA O FECHAMENTO DESTA TAREFA.
            JOptionPane.showMessageDialog(null, "Total de Movimentos: "+clique+"\nTempo do desafio: "+new SimpleDateFormat("mm:ss").format(new Date(timefim - timeinicio))+" Minutos"+"\nOK, este foi fácil... \nPronto para o Nível 2 ???");
            //System.exit(0);
            Puzzle0 nivel2 = new Puzzle0("darth.jpg");
            No win = new No(nivelAux++,clique);
            arvoreDeNiveis.inserirSemRecursividade(win);
        }

    }

}
