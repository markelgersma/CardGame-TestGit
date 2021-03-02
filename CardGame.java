import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


import javax.swing.JFrame;

public class CardGame extends JFrame{

    boolean run = true;
public int temp = 0;
    protected Image dbImage;
    private Graphics dbg;

    final protected Card[] Deck;
    Image[] cardPics;
    public CardGame(){
        //Load Images:
        Deck = new Card[520];
        cardPics = new Image[520+1];
        for(int i = 0; i<Deck.length; i=i+52){
          addDeck(i);
        }
    }
    public void addDeck(int index){
        int j = 2;
        for (int i = 0; i < 36; i=i+4){				
            Deck[i+index] = new Card(j+"H",i+index,30,"blue_back",cardPics);
            Deck[i+1+index] = new Card(j+"C",i+index,30,"blue_back",cardPics);
            Deck[i+2+index] = new Card(j+"S",i+index,30,"blue_back",cardPics);
            Deck[i+3+index] = new Card(j+"D",i+index,30,"blue_back",cardPics);
            j++;
        }
        String[] Faces = new String[4];
        Faces[0]="J";
        Faces[1]="Q";
        Faces[2]="K";
        Faces[3]="A";
        j = 0;
        for (int i = 36; i < 52; i=i+4){
            Deck[i+index] = new Card(Faces[j]+"H",i+index,30,"blue_back",cardPics);
            Deck[i+1+index] = new Card(Faces[j]+"C",i+index,30,"blue_back",cardPics);
            Deck[i+2+index] = new Card(Faces[j]+"S",i+index,30,"blue_back",cardPics);
            Deck[i+3+index] = new Card(Faces[j]+"D",i+index,30,"blue_back",cardPics);
            j++;
        }
    }
    public void init(){
        KeyboardControl KBC = new KeyboardControl();
        KBC.CG = this;
        addKeyListener(KBC);
        Mouse MSE = new Mouse();
        MSE.CG = this;
        addMouseListener(MSE);
        windowManager();
    }

    public void windowManager(){
          //JFrame f = new JFrame();
          setTitle("Engine");
          setVisible(true);
          setResizable(true);
          setSize(640,480);
          setBackground(new Color(50,155,50));
          setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void paintComponent(Graphics g){
        if(run == true){
            //g.setColor(Color.BLACK);
            g.drawImage(cardPics[Deck[temp].picIndex],Deck[temp].x,Deck[temp].y,this);
            //g.drawOval(90, 90, 200, 200);
            //g.drawRect(3, 26, 1, 1); //shows the actual location of top left.
            //g.drawString("Hello World",50,50);
            temp = (temp + 1) % Deck.length;
            repaint();
        }
    }

    @Override
    public void paint(Graphics g){
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage,0,0,this);
    }

    

    

    public static void main(String[] args) {
        CardGame cardGame = new CardGame();
        cardGame.init();
    }
}