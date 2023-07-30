import java.util.*;
public class SpaceShip extends ImageGamePiece{    
    private int timer;
    
    public SpaceShip(int xVal, int yVal, int tall, int wide, String hue){
        super(xVal,yVal,tall,wide,hue);
        timer = 30;
    }
    
    public void keepTime(){
        timer += 1;
    }
    
    public void powerJump(ArrayList<SpaceJunk> blocks){
        if (timer > 30){
            int x = (int)StdDraw.mouseX();
            int y = (int)StdDraw.mouseY();
            super.setX(x);
            super.setY(y);
            timer = 0;
            for(SpaceJunk s: blocks){
                s.destroy(x,y);
            }
        }
    }
}