/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

/**
 *
 * @author Martin Anderson
 */
public class DrawingBoard extends JPanel implements Updatable{
    private WormGame wormgame;
    private int pieceLength;
    
    public DrawingBoard(WormGame wormgame, int pieceLength){
        this.wormgame = wormgame;
        this.pieceLength = pieceLength;
    }
    
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        
        
        List<Piece> pieces = this.wormgame.getWormPieces();
        for(Piece each: pieces){
            graphics.setColor(Color.BLACK);
            graphics.fill3DRect(each.getX()* this.pieceLength, each.getY()* this.pieceLength, this.pieceLength, this.pieceLength, true);
            
        }
        
        
        graphics.setColor(Color.red);
        graphics.fillOval(this.wormgame.getAppleX() * this.pieceLength, this.wormgame.getAppleY() * this.pieceLength, this.pieceLength, this.pieceLength);
    }
    
    @Override
    public void update() {
        super.repaint();
    }
    
}
