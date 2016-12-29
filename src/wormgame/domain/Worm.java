/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package wormgame.domain;

import java.util.List;
import java.util.ArrayList;
import wormgame.Direction;
import static wormgame.Direction.DOWN;
import static wormgame.Direction.LEFT;
import static wormgame.Direction.RIGHT;
import static wormgame.Direction.UP;



/**
 *
 * @author Martin Anderson
 */
public class Worm {
    private int originalX;
    private int originalY;
    private Direction originalDirection;
    private List<Piece> pieces;
    private int maxSize;
    
    public Worm(int originalX, int originalY, Direction originalDirection){
        this.originalX = originalX;
        this.originalY = originalY;
        this.originalDirection = originalDirection;
        this.pieces = new ArrayList<Piece>();
        this.pieces.add(new Piece(originalX, originalY));
        this.maxSize = 4;
    }
    
    public Direction getDirection(){
        return this.originalDirection;
    }
    
    public void setDirection(Direction dir){
        this.originalDirection = dir;
    }
    
    public int getLength(){
        return this.pieces.size();
    }
    
    public List<Piece> getPieces(){
        return this.pieces;
    }
    
    public void move(){
        
        Piece last = this.pieces.get(this.pieces.size() -1);
        Piece beAdded;
        //?? check how comparison with enum was done
        if (getDirection().equals(RIGHT)){
            beAdded = new Piece(last.getX() + 1,last.getY());
            this.pieces.add(beAdded);
        } else if (getDirection().equals(LEFT)){
            beAdded = new Piece(last.getX() -1 ,last.getY());
            this.pieces.add(beAdded);
        } else if (getDirection().equals(UP)){
            beAdded = new Piece(last.getX() ,last.getY() - 1);
            this.pieces.add(beAdded);
        } else if (getDirection().equals(DOWN)){
            beAdded = new Piece(last.getX() ,last.getY() + 1);
            this.pieces.add(beAdded);
        }
        
        if (this.pieces.size() >= this.maxSize){
            this.pieces.remove(0);
        }
    }
    
    
    
    public void grow(){
        if (this.pieces.size() > 2){
            this.maxSize++;
        }
        
    }
    
    public boolean runsInto(Piece piece){
        for(Piece each: this.pieces){
            if (piece.runsInto(each)){
                return true;
            }
        }
        return false;
    }
    
    public boolean runsIntoItself(){
        int howManyTimes = 0;
        
        for(int i = 0; i < this.pieces.size(); i++){
            Piece temp = this.pieces.get(i);
            
            for(Piece each: this.pieces){
                if(temp.runsInto(each)){
                    howManyTimes++;
                    
                }
            }
        }
        return howManyTimes > this.pieces.size();
        
    }
    public boolean runsIntoBorder(int width, int height){

        
        for (Piece each : this.pieces) {
            if((each.getX() == width) || (each.getX() == 0) || (each.getY() == height) || (each.getY() == 0)) {
                return true;
            }
        }
        return false;
    }
    
    public int getX(){
        return this.originalX;
    }
    
    public int getY(){
        return this.originalY;
    }
}
