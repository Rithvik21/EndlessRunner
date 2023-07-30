import java.util.*;
public class SpaceJunk extends ImageGamePiece{
    private boolean isDestroyed;
    private ArrayList<ImageGamePiece> blocks;
    int x = super.returnX();
    int y = super.returnY();
    
    public SpaceJunk(int xVal, int yVal, int tall, int wide, String hue){
        super(xVal,yVal,tall,wide,hue);
        isDestroyed = false;
    }

    public boolean getIsDestroyed(){
        return isDestroyed;
    }

    public void drawPiece(){
        if(isDestroyed == false){
            super.drawPiece();
        }
        if(super.returnY() < 0){
            isDestroyed = false;
        }
    }

    public void destroy(int x, int y){
        if(x < super.getRightBound() && x > super.getLeftBound() && y < super.getUpperBound() && y > super.getLowerBound()){
            isDestroyed = true;
        }
    }
}