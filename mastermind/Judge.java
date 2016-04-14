import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;

public class Judge extends SpecialCharacter
{ 
    public void placeLeftAlligned(Balloon b, int row) {
        if (GWorld.getOneObjectAt(5, row, "Balloon") == null) {
            GWorld.addOneObject(new OrangeBalloon(), 5, row);
        }
        else if (GWorld.getOneObjectAt(6, row, "Balloon") == null) {
            GWorld.addOneObject(new OrangeBalloon(), 6, row);
        }
        else if (GWorld.getOneObjectAt(7, row, "Balloon") == null) {
            GWorld.addOneObject(new OrangeBalloon(), 7, row);
        }
        else if (GWorld.getOneObjectAt(8, row, "Balloon") == null) {
            GWorld.addOneObject(new OrangeBalloon(), 8, row);
        }
    }
    
    public void judgeRow(int row)
    {
        System.out.println("Judge looks at row " + row); //keep this line
        
        MastermindWorld.clearBalloons(row); //keep this  line
        
        //part 1
        Peg thisPeg = (Peg)GWorld.getOneObjectAt(0, row, "Peg");
        System.out.println("the secret is: " + MastermindWorld.secret.charAt(0) + MastermindWorld.secret.charAt(1) + MastermindWorld.secret.charAt(2) + MastermindWorld.secret.charAt(3));
        System.out.println("compare " + thisPeg.color + " " + MastermindWorld.secret.charAt(0));
        if (MastermindWorld.secret.charAt(0) == thisPeg.color) {
            Balloon thisBalloon = new OrangeBalloon();
            placeLeftAlligned(thisBalloon, row);
        }
        thisPeg = (Peg)GWorld.getOneObjectAt(1, row, "Peg");
        System.out.println("compare " + thisPeg.color + " " + MastermindWorld.secret.charAt(1));
        if (MastermindWorld.secret.charAt(1) == thisPeg.color) {
            Balloon thisBalloon = new OrangeBalloon();
            placeLeftAlligned(thisBalloon, row);
        }
        thisPeg = (Peg)GWorld.getOneObjectAt(2, row, "Peg");
        System.out.println("compare " + thisPeg.color + " " + MastermindWorld.secret.charAt(2));
        if (MastermindWorld.secret.charAt(2) == thisPeg.color) {
            Balloon thisBalloon = new OrangeBalloon();
            placeLeftAlligned(thisBalloon, row);
        }
        thisPeg = (Peg)GWorld.getOneObjectAt(3, row, "Peg");
        System.out.println("compare " + thisPeg.color + " " + MastermindWorld.secret.charAt(3));
        if (MastermindWorld.secret.charAt(3) == thisPeg.color) {
            Balloon thisBalloon = new OrangeBalloon();
            placeLeftAlligned(thisBalloon, row);
        }
    }   
    
    public void judgeLatestRow()
    {
        //part 1
        for (int i=7; i>=0; i--) {
            System.out.println("looking at " + i);
            if (MastermindWorld.isRowComplete(i)) {
                judgeRow(i);
                break;
            }
        }
    }

    public void judgeAllRows()
    {
        for (int i=7; i>=0; i--) {
            if (MastermindWorld.isRowComplete(i)) {
                judgeRow(i);
            }
        }
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
