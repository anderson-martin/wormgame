package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {
    
    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;
    
    public WormGame(int width, int height) {
        super(1000, null);        
        this.width = width;
        this.height = height;
        this.continues = true;        
        addActionListener(this);
        setInitialDelay(2000);
        this.worm = new Worm(width/2, height/2, Direction.DOWN);
        this.apple = RandomAppleCreator(width, height);
        
    }
    
    
    public Apple RandomAppleCreator(int width, int height){
        Random rand = new Random();
        int randX = rand.nextInt(width);
        int randY = rand.nextInt(height);
        while ((randX == width/2) && (randY == height/2) ){
            randX = rand.nextInt(width);
            randY = rand.nextInt(height);
        }
        Apple randApple = new Apple(randX, randY);
        return randApple;
        
    }
    public boolean continues() {
        return continues;
    }
    
    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getWormX(){
        return this.worm.getX();
    }
    
    public int getWormY(){
        return this.worm.getY();
    }
    
    public int getAppleX(){
        return this.apple.getX();
    }
    
    public int getAppleY(){
        return this.apple.getY();
    }
    
    public Worm getWorm(){
        return this.worm;
    }
    
    public void setWorm(Worm worm){
        this.worm = worm;
    }
    
    public Apple getApple(){
        return this.apple;
    }
    
    public void setApple(Apple apple) {
        this.apple = apple;
    }
    
    public List getWormPieces(){
        return this.worm.getPieces();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(!continues){
            return;
        }
        
        this.worm.move();
        if(this.worm.runsInto(apple)){
            this.worm.grow();
            this.apple = RandomAppleCreator(width, height);
        } 
        
        if (this.worm.runsIntoItself() || this.worm.runsIntoBorder(width, height)){
            this.continues = false;
        } 
        updatable.update();
        setDelay(1000 / worm.getLength());
        
    }
    
}
