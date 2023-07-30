public class GamePiece
{
    private int centerX;
    private int centerY;
    private int height;
    private int width;
    private int[] color;

    public GamePiece (int xVal, int yVal, int tall, int wide, int[] hue){
        centerX = xVal;
        centerY = yVal;
        height = tall; 
        width = wide;
        color = hue;
    }

    public int returnX(){
        return centerX;
    }

    public int returnY(){
        return centerY;
    }

    public void moveY(int p) {
        centerY += p;
    }

    public void moveX(int p) {
        centerX += p;
    }

    public void setY(int p) {
        centerY = p;
    }

    public void setX(int p) {
        centerX = p;
    }

    public int getUpperBound(){
        return centerY + height;
    }

    public int getLowerBound(){
        return centerY - height;
    }

    public int getRightBound(){
        return centerX + width;
    }

    public int getLeftBound(){
        return centerX - width;
    }

    public void drawPiece(){
        StdDraw.setPenColor(color[0], color[1], color[2]);
        StdDraw.filledRectangle(centerX, centerY, width, height);
    }
}