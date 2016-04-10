import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;

public class Judge extends SpecialCharacter
{ 
    public void judgeRow(int row)
    {
        System.out.println("Judge looks at row " + row); //keep this line
        
		MastermindWorld.clearBalloons(row); //keep this line

        //part 1
    }   
    
    public void judgeLatestRow()
    {
        //part 1
    }

    public void judgeAllRows()
    {
        //part 1
    }
    
    public int getNumberOfColoredPegsInAnswer(char color, int row)
    {
        //part 2
        
        return 0; //you should remove this line as you add your own implementation for this method
    }

    public int getNumberOfColoredPegsInSecret(char color)
    {
        //part 2
        
        return 0; //you should remove this line as you add your own implementation for this method
    }
    
    /*
     * It returns the number of yellow balloons, assuming no orange balloons would be awarded. Read assignment description on how to make use of it. (used in part 2 only)
     */
    public int getNumberOfYellowBalloons(int row)
    {
        return Math.min(getNumberOfColoredPegsInSecret('B'), getNumberOfColoredPegsInAnswer('B', row))
            + Math.min(getNumberOfColoredPegsInSecret('G'), getNumberOfColoredPegsInAnswer('G', row))
            + Math.min(getNumberOfColoredPegsInSecret('R'), getNumberOfColoredPegsInAnswer('R', row))
            + Math.min(getNumberOfColoredPegsInSecret('P'), getNumberOfColoredPegsInAnswer('P', row));
    }
}
