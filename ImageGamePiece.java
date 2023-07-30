public class ImageGamePiece extends GamePiece{
    private String picture;
    private double scaledHeight;
    private double scaledWidth;
    
    public ImageGamePiece (int xVal, int yVal, int tall, int wide, String hue){
        super(xVal,yVal,tall,wide,new int[]{0,0,0});
        scaledHeight = 2 * tall;
        scaledWidth = 2 * wide;
        picture = hue;
    }
    
    public void drawPiece(){
        StdDraw.picture(super.returnX(), super.returnY(), picture, scaledWidth, scaledHeight);
    }
}