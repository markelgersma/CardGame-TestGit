import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Mouse extends MouseAdapter {
    protected CardGame CG;   
    @Override
    public void mousePressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        CG.Deck[CG.temp].x = (int)x;
        CG.Deck[CG.temp].y = (int)y;
    }
}