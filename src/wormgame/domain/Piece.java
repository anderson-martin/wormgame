/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

/**
 *
 * @author Martin Anderson
 */
public class Piece {
    private int x;
    private int y;
    
    public Piece(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
       return this.y;
    }
    
    public boolean runsInto(Piece piece){        
        return (piece.getX() == this.x) && (piece.getY() == this.y);
    }
    
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }
    
}
