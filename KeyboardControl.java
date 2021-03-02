import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class KeyboardControl extends KeyAdapter{
    protected CardGame CG;
    //public KeyboardControl(){};
    @Override
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        if((keyCode == KeyEvent.VK_UP) &&  (CG.Deck[0].y - 20 > 0)){
               CG.Deck[0].y = CG.Deck[0].y - 10;
        }else if((keyCode == KeyEvent.VK_DOWN)  && (CG.Deck[0].y + 20 < CG.getHeight())){
            CG.Deck[0].y = CG.Deck[0].y + 10;
        }
        if((keyCode == KeyEvent.VK_LEFT) &&  (CG.Deck[0].x - 20 > 0)){
               CG.Deck[0].x = CG.Deck[0].x - 10;
        }else if((keyCode == KeyEvent.VK_RIGHT) && (CG.Deck[0].x + 20 < CG.getWidth())){
            CG.Deck[0].x = CG.Deck[0].x + 10;
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
    }
}