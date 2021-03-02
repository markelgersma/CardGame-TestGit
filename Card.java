import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Card implements Comparable<Card>{
	// this is an extra comment
 //test another user update powers.
  public int blah;
  public boolean canIPlay;
	public int x,y; //pos
	public boolean isVisible;

  public int suit;
  public int val;
  public int picIndex;
	
	public Card(String symbol, int posX, int posY, String back,Image[] i){
    
		x = posX;
		y = posY;

		//System.out.println(symbol);
    String s = symbol.substring(symbol.length()-1,symbol.length());
    //System.out.println(s);
    switch(s){
      case "H": suit = 0; break;
      case "D": suit = 1; break;
      case "C": suit = 2; break;
      case "S": suit = 3; break;
    }
    
    s = symbol.substring(0,symbol.length()-1); //suit
    switch(s){
      case "J": s = "11"; break;
      case "Q": s = "12"; break;
      case "K": s = "13"; break;
      case "A": s = "1"; break;
    }
    
    val = Integer.parseInt(s);
    picIndex = suit*13+val-1;
    System.out.println(symbol + " " + s + " suit:" + suit + " Index:" + picIndex); //symbol and card value
    
    if(i[i.length-1]==null){
      Image myImage1;
      ImageIcon myIcon1;
      myIcon1 = new ImageIcon("PNG/" + back + ".png");
      myIcon1 = new ImageIcon(getScaledImage(myIcon1.getImage(),130,200));
      myImage1 = myIcon1.getImage();
      i[i.length-1] = myImage1;
    }
    if(i[picIndex]==null){
      Image myImage;
      ImageIcon myIcon;
      myIcon = new ImageIcon("PNG/" + symbol + ".png");
      myIcon = new ImageIcon(getScaledImage(myIcon.getImage(),130,200));
      myImage = myIcon.getImage();
      i[picIndex] = myImage;
    }
	}
	
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
  /*
  Compare to return -1 if this card comes before the other card.
  */
  public int compareTo(Card other){
    if(suit<other.suit){
      return -1;
    }
    if(suit>other.suit){
      return 1;
    }
    if(val<other.val){
      return -1;
    }
    if(val>other.val){
      return -1;
    }
    return 0;
  }
}
