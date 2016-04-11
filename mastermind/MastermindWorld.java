import greenfoot.*;  
import java.util.Random;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class MastermindWorld extends GWorld
{
    //the dimensions of the game board
    public static final int WORLD_WIDTH = 9;
    public static final int WORLD_HEIGHT = 10;
    public static final int NUMBER_OF_PLAY_ROWS = WORLD_HEIGHT - 2;

    //the constants that represent different objects (or nothing) that present on the game board
    public static final char NOTHING = 'X';
    public static final char WALL = 'W';
    public static final char JUDGE = 'J';
    public static final char NICE_JUDGE = 'N';
    public static final char FRIEND_JUDGE = 'F';
    public static final char NAUGHTY_GUY = 'C';
    public static final char BLUE_PEG = 'B';
    public static final char GREEN_PEG = 'G';
    public static final char RED_PEG = 'R';
    public static final char PURPLE_PEG = 'P';
    public static final char YELLOW_BALLOON = 'Y';
    public static final char ORANGE_BALLOON = 'O';

    //the secret, which should be randomized by you at the beginning
    public static String secret = "RGBB";

    public static int highScore[] = {0, 0}; //you may use this in part 2, or you can ignore it and use your own variables

    static 
    {      
        GWorld.setWidth(WORLD_WIDTH);   
        GWorld.setHeight(WORLD_HEIGHT);
        GWorld.setCellSize(60);
    }

    public MastermindWorld() throws Exception
    {           
        initialize(); 
        generateSecret(); 
    }
    
    public void initialize()
    {         
        //part 1
      
                MastermindWorld.addObject(MastermindWorld.JUDGE, 0, 9);
                MastermindWorld.addObject(MastermindWorld.NICE_JUDGE, 1, 9);
                MastermindWorld.addObject(MastermindWorld.FRIEND_JUDGE, 2, 9);
                MastermindWorld.addObject(MastermindWorld.NAUGHTY_GUY, 5, 9);
                for(int i = 0; i < 9; i++) {
                MastermindWorld.addObject(MastermindWorld.WALL,i, 8);
            }
                for(int i = 0; i < 10; i++) {
                MastermindWorld.addObject(MastermindWorld.WALL,4 ,i);    
            }
}
    
    public void generateSecret()
    {
        //part 1
                char[] peg = "BRGP".toCharArray();
                StringBuilder color = new StringBuilder();
                Random random = new Random();
                for (int i = 0; i < 4; i++) {
                      char c = peg[random.nextInt(peg.length)];
                      color.append(c);
                    }
                    String secret = color.toString();
                 System.out.println("The secret is " + secret );
                }
    
    
    public static void clearBalloons(int row)
    {
        //part 1
                for(int i = 4; i < 9; i++)
                for(int f = 0; f < 8; f++) {
                removeObjectsFromWorld(getAllObjectsAt(i, f, "Balloon"));
    }}

    public boolean hasSomePeg(int x, int y)
    {
        //part 1
        int i=x;
        int f=y;
                    if(MastermindWorld.getOneObjectAt(i, f, "GreenPeg") != null) {return  true;} 
               else if(MastermindWorld.getOneObjectAt(i, f, "BluePeg") != null) {return  true;} 
               else if(MastermindWorld.getOneObjectAt(i, f, "RedPeg") != null) {return  true;} 
               else if(MastermindWorld.getOneObjectAt(i, f, "PurplePeg") != null) {return  true;} 
        else {return  false;}
    }
    
    public boolean isRowComplete(int row)
    {
        //part 1
        for (int i = 0; i!=4; i++)
        {
            if (!hasSomePeg(i, row))
            {
                return false;
            }
        }
        return true; //you should remove this line as you add your own implementation for this method
    }

    public static int getLatestRow()
    {
        //part 1
        
        return 0; //you should remove this line as you add your own implementation for this method
    }

    public void saveGame() throws Exception
    {
        //part 2
    }
 
    public void loadGame() throws Exception
    {
        //part 2    
        
        //clear the board
        removeAllObjects(); // keep this line
        
        
    } 
    
    public static int calculateScore()
    {
        //part 2 
        
        return 0; //you should remove this line as you add your own implementation for this method 
    }

    public static void updateHighscores() throws Exception
    {
        //part 2  
    }
    
    /*
     * Parameters:
     * lowerBound - the (inclusive) lower bound of the random number
     * upperBound - the (inclusive) upper bound of the random number
     * 
     * Example:
     * getRandomNumber(1, 10) will return you a random number that is in range of [1, 10] (including 1 and 10).
     */
    public int getRandomNumber(int lowerBound, int upperBound)
    {
        Random randomNumberGenerator = new Random();
        return lowerBound + randomNumberGenerator.nextInt(upperBound - lowerBound + 1);
    }

    /*
     * Parameters:
     * objectChar - a character that represents the object that you want to add; you are suggested to use the constants defined in this class, e.g., MastermindWorld.JUDGE
     * x - the x coordinate of the object to be placed (the top-left corner of the world is (0, 0)
     * y - the y coordinate
     * 
     * Example:
     * MastermindWorld.addObject(MastermindWorld.NICE_JUDGE, 2, 3); 
     * will create and place a NiceJudge object to the location (2,3) in the world
     */
    public static void addObject(char objectChar, int x, int y)
    {
        //create the object base on the objectChar
        Actor object = null;
        switch(objectChar)
        {
            case MastermindWorld.JUDGE: 
                object = new Judge();
                break;
            case MastermindWorld.NICE_JUDGE: 
                object = new NiceJudge();
                break;
            case MastermindWorld.FRIEND_JUDGE: 
                object = new FriendJudge();
                break;
            case MastermindWorld.NAUGHTY_GUY: 
                object = new NaughtyGuy();
                break;
            case MastermindWorld.BLUE_PEG: 
                object = new BluePeg();
                break;
            case MastermindWorld.GREEN_PEG: 
                object = new GreenPeg();
                break;
            case MastermindWorld.RED_PEG: 
                object = new RedPeg();
                break;
            case MastermindWorld.PURPLE_PEG: 
                object = new PurplePeg();
                break;
            case MastermindWorld.YELLOW_BALLOON: 
                object = new YellowBalloon();
                break;
            case MastermindWorld.ORANGE_BALLOON: 
                object = new OrangeBalloon();
                break;
            case MastermindWorld.WALL: 
                object = new Wall();
                break;
            default:
                return; //just exit the method if nothing should be added
                
        }   
        GWorld.addOneObject(object, x, y); //add the object to the world
    }
    
    /*
     * Parameters:
     * x - the x coordinate of the location that you want to check
     * y - the y coordinate
     * 
     * Example:
     * MastermindWorld.getObjectChar(2, 3) will return a character that represents the object that is located at the location (2,3) in the world.
     * If there is a GreenPeg object there at location (2,3), then the character MastermindWorld.GREEN_PEG (which is defined as 'G') will be returned.
     * 
     * If there is nothing at the location, then the character MastermindWorld.NOTHING (which is defined as 'N') will be returned.
     * 
     * If there is more than one object in the same location (should not happen if all your methods are implemented correctly, and we assume the user won't do that), only one object will be detected.
     */
    public static char getObjectChar(int x, int y)
    {
        //return the character that represents the object at (x, y)
        if(GWorld.getOneObjectAt(x, y, "NiceJudge") != null) return MastermindWorld.NICE_JUDGE;
        else if(GWorld.getOneObjectAt(x, y, "FriendJudge") != null) return MastermindWorld.FRIEND_JUDGE;
        else if(GWorld.getOneObjectAt(x, y, "Judge") != null) return MastermindWorld.JUDGE;
        else if(GWorld.getOneObjectAt(x, y, "NaughtyGuy") != null) return MastermindWorld.NAUGHTY_GUY;
        else if(GWorld.getOneObjectAt(x, y, "BluePeg") != null) return MastermindWorld.BLUE_PEG;
        else if(GWorld.getOneObjectAt(x, y, "GreenPeg") != null) return MastermindWorld.GREEN_PEG;
        else if(GWorld.getOneObjectAt(x, y, "RedPeg") != null) return MastermindWorld.RED_PEG;
        else if(GWorld.getOneObjectAt(x, y, "PurplePeg") != null) return MastermindWorld.PURPLE_PEG;
        else if(GWorld.getOneObjectAt(x, y, "YellowBalloon") != null) return MastermindWorld.YELLOW_BALLOON;
        else if(GWorld.getOneObjectAt(x, y, "OrangeBalloon") != null) return MastermindWorld.ORANGE_BALLOON;
        else if(GWorld.getOneObjectAt(x, y, "Wall") != null) return MastermindWorld.WALL;
        else return MastermindWorld.NOTHING;
    }
    
    /*
     * Parameters:
     * x - the x coordinate
     * y - the y coordinate
     * 
     * Example:
     * Calling removeBaloons(2, 3) will remove any balloon at the position (2,3). It is safe to call the method even if the specified position has nothing in it - it just does nothing in that case.
     * 
     * It is able to remove mutliple balloons that exist at the same position at once.
     */
    public static void removeBalloons(int x, int y)
    {
        removeObjectsFromWorld(getAllObjectsAt(x, y, "Balloon"));
    }

    /*
     * Example:
     * Calling removeAllObjects() will remove all objects in the world. It should be used at the beginning of the loadGame method.
     */
    private static void removeAllObjects()
    {   
        GWorld.removeObjectsFromWorld(GWorld.getAllObjects("Peg"));
        GWorld.removeObjectsFromWorld(GWorld.getAllObjects("Wall"));
        GWorld.removeObjectsFromWorld(GWorld.getAllObjects("SpecialCharacter"));
        GWorld.removeObjectsFromWorld(GWorld.getAllObjects("Balloon"));
    }
}
