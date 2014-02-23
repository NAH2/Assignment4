package piece;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ConnectFourPiece extends GamePiece {
    
    public ConnectFourPiece(String col) {
        super();
        setColour(col);
        setIcons();
    }
    
    public Icon getIcon() {
        if (getColour().equals("yellow")) {
            return m_yellowpiece;
        } else {
            return m_redpiece;
        }
    }
    
    public void setIcons() throws NullPointerException {
        try {
            m_yellowpiece = new ImageIcon(getClass().getResource("yellow.png"));
            m_redpiece = new ImageIcon(getClass().getResource("red.png"));
        } catch (NullPointerException e) {
            System.out.println("Images Not Found");
        }
    }
    
    // variable declarations
    private Icon m_yellowpiece;
    private Icon m_redpiece;
}