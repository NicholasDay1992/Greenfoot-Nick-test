import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;

/**
 * A new version of the Mario Game which just contains
 * a platform for Mario to walk left to right and a Pyramid
 * 
 * @author Derek Peacock 
 * @version 1.0
 */
public class MarioWorld extends World
{
    public static final int MAXN_COLUMNS = 24;
    public static final int MAXN_ROWS = 20;
    public static final int GROUND_ROW = 17;
    public static final int TILE_SIZE = 30; // pixels
    public static final int GAP = 2; // pyramid gap
    
    private Mario mario;
    
    /**
     * Setup the world with MAXN_COLUMNS x MAXN_ROWS
     * of tiles, with a tiles being squares TILE_SIZE pixels
     * 
     */
    public MarioWorld()
    {    
        // Create a new world with 24 x 20 tiles of 30 pixels each
        
        super(MAXN_COLUMNS, MAXN_ROWS, TILE_SIZE); 
        
        drawPath();
        
        mario = new Mario();
        addObject(mario, 1, GROUND_ROW);
        
        buildPyramid();
    }
    
    /**
     * Create a path at the bottom of the screen which is
     * 2 tiles high and goes right across the whole widh of
     * the screen to form the ground for Mario to walk on.
     */
    private void drawPath()
    {
        int yStart = MAXN_ROWS - 1; // 19
        int yEnd = GROUND_ROW + 1; // 18
        
        for(int y = yStart; y >= yEnd; y--)
        {
            for(int x = 0; x < MAXN_COLUMNS; x++)
            {
                Block Block = new Block();
                addObject(Block, x, y);
            }
        }
    }
    
    /**
     * Ask the user to enter the size of the pyramid in
     * blocks between 1 to 8 inclusive
     */
    private int getPyramidSize()
    {
        String reply = Greenfoot.ask("Enter the pyramid size (1-8) > ");
        int size = Integer.parseInt(reply); 

        return size;
    } 
    
    
    /**
     * Build a pyramid of blocks.  The pyramid base is twice
     * the size, and the pyramid is size blocks high.
     * There is a gap of 2 blocks in the centre
     * 
     * @author Nick Day
     * @version 8th November 2022
     */
    public void buildPyramid()
    {
        int size = getPyramidSize();
        
        int yStart = 17; 
        int yEnd = yStart - size;
        int xStart = 4; 
        int xEnd = xStart + size;
        
        //int xEnd2 = xStart + 2;
        // each row
        for(int y = yStart; y > yEnd; y--)
        {
            //left half
            for (int x = xStart; x < xEnd; x++)
            {
                Block Block = new Block();
                addObject(Block, x, y);
            }
            
            //right half
            for (int x = xEnd+2; x < xEnd + 2 + (xEnd - xStart); x++)
            {
                Block Block = new Block();
                addObject(Block, x, y);
            }
            xStart++;
        }

        
        
        
        /*
        for (int y = yStart; y >= yEnd; y--)
        {
            for(int x = xStart; x <= xEnd; x++)
            {
                Block Block = new Block();
                addObject(Block, x, y);
            }
            
            for(int x = xEnd + 3; x <= xEnd + 3 + (xEnd - xStart); x++)
            {
                Block Block = new Block();
                addObject(Block, x, y);
            }
            
            xStart++;
        }

        
        
        /*
        
        
        int xStart = 4;
        int xEnd = xStart + size;  // 4 + size (7) = 11
        
        int yStart = GROUND_ROW;   // 17
        int yEnd = GROUND_ROW - size;  //17 - size (7) = 10
        
        //start at the bottom row and move up
        for(int y = yStart; y > yEnd; y--)
        {
            // first half cols
            for(int x = xStart; x < xEnd; x++)
            {
                Block Block = new Block();
                addObject(Block, x, y);
            }
            
            // second half cols 
            // start = xEnd (11) + GAP (2) = (13)
            // end = xEnd (11) + GAP (2) + (decreasing length)
            for(int x = xEnd + GAP; x < xEnd + GAP + (xEnd - xStart); x++)
            {
                Block Block = new Block();
                addObject(Block, x, y);
            }
            
            xStart++;  // 4 to 5 to 6 to 7 etc
        }
    
    
        /*
        
        for(rows = 0; rows < size; rows++)
        {
            //repeat the row loop twice
            for (int sides = 0; sides < 2; sides++)
            {
                //single row
                for(int i = 0; i < cols; i++)
                {
                    Block Block = new Block();
                    addObject(Block, x, y);
                    x++;
                } 
                x = x + 2;
            }
            cols--;
            y--;
            x = 4 + (rows +1);
        }

        
        
        
        
        //FIRST HALF:
        /*
        for(int i = 0; i < size; i++)
        {
            for(int side = 0; side < cols; side++)
            {
                addObject(new Block(), x, y);
                x++;
            }
            x = 4 + (rows+1);
            rows++;
            
            cols--;
            y--;
        }
        */ 
        //FULL SOLUTION: 
        
        /*
        //start at y = 17 , then go to 17 - size (e.g. 10)
        while(y > GROUND_ROW - size)
        {
            //repeat twice for both sides of the parting
            for(int i = 0; i < 2; i++)
            {
                //this loop is for one side
                for(int side = 0; side < cols; side++)
                {
                    addObject(new Block(), x, y);
                    x++;
                }
                //middle parting of two blocks
                x = x + 2;
            }
            
            cols--;  //reduce the length of columns for each row
            x = 4 + (rows+1); //reposition x to be 1 in each time
            y--;  // the row index (starts at 17) to 16 etc
            rows++;  //number of rows completed 
        }
        */
       
    }
    
}
