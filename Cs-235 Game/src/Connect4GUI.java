import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import boardGame.*;

public class Connect4GUI extends GUI {
    
    public boolean setPanelColour() {
        final int top = 0;
        final int bottom = getBoard().getHeight() - 1;
        final int left = 0;
        final int right = getBoard().getWidth() - 1;
        
        for (int y = 0; y < getBoard().getHeight(); ++y) {
            for (int x = 0; x < getBoard().getWidth(); ++x) {
                //set to images later
                m_panels[x][y].setBackground(Color.blue);
            }
        }
        return true;
    }
    
    public Connect4GUI(BoardGame b, GameController g) {
        super(b, g);
        //setImages();
    }
    
    public boolean setImages() {
        try {
            m_middle = Toolkit.getDefaultToolkit().createImage("middle.png");
            m_topLeft = Toolkit.getDefaultToolkit().createImage("topLeft.png");
            m_topRight = Toolkit.getDefaultToolkit().createImage("topRight.png");
            m_bottomLeft = Toolkit.getDefaultToolkit().createImage("bottomLeft.png");
            m_bottomRight = Toolkit.getDefaultToolkit().createImage("bottomRight.png");
        } catch (Exception e) {
            System.out.println("Images not found");
        }
        return true;
    }
    
    Image m_middle;
    Image m_topLeft;
    Image m_topRight;
    Image m_bottomLeft;
    Image m_bottomRight;
}
