//Name:Rithvik Padigala
//Period: 1A
import java.util.*;
import java.util.Random;
public class GameManager
{
    private SpaceShip hero;
    private boolean runGame;
    private ArrayList<SpaceJunk> blocks;
    Random rand = new Random();
    public GameManager(){
        runGame = true;
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setXscale(0, 500);
        StdDraw.setYscale(0, 500);
        int[] arrays = {0, 0, 0};
        hero = new SpaceShip(250, 250, 15, 15,"Ship1.gif");
        blocks = new ArrayList<SpaceJunk>();
        int x = 0;
        int y = 400;
        for(int i = 0; i < 3; i++){
            int[] red = {120, 0 , 0};
            blocks.add(new SpaceJunk(25 + x, y, 15, 200, "SpaceJunk.gif"));
            blocks.add(new SpaceJunk(475 + x, y, 15, 200, "SpaceJunk.gif"));
            y += 200;
            x = rand.nextInt(301)-150;
        }
    }
    public void run(){
        while(runGame){
            StdDraw.clear();
            hero.keepTime();
            if(StdDraw.isMousePressed()){
                hero.powerJump(blocks);
            }
            if(StdDraw.isKeyPressed(87)){
                hero.moveY(10);
            }else if (StdDraw.isKeyPressed(65)){
                hero.moveX(-10);
            }else if (StdDraw.isKeyPressed(83)){
                hero.moveY(-10);
            }else if (StdDraw.isKeyPressed(68)){
                hero.moveX(10);
            }
            this.drawGamePieces();
            this.collision();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void drawGamePieces(){
        hero.drawPiece();
        for(int x = 0; x < blocks.size(); x++){
            blocks.get(x).drawPiece();
            blocks.get(x).moveY(-8);
        }
        for(int i = 0; i < blocks.size(); i+=2){
            if(blocks.get(i).returnY() < 0){
                int x = rand.nextInt(301)-150;
                int y = rand.nextInt(201)+500;
                blocks.get(i).setY(y);
                blocks.get(i+1).setY(y);
                blocks.get(i).moveX(x);
                blocks.get(i+1).moveX(x);
            }
        }
    }
    public void collision(){
        for (GamePiece b: blocks){
            if(hero.getLowerBound() < b.getUpperBound() && hero.getUpperBound() > b.getLowerBound() && hero.getLeftBound() < b.getRightBound() && hero.getRightBound() > b.getLeftBound()){
                runGame = false;
            }
        }
    }
}