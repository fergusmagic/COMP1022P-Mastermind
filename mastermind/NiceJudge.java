import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class NiceJudge extends Judge
{
    @Override
    public void judgeRow(int row)
	{
	    MastermindWorld.clearBalloons(row); //keep this  line
		System.out.println("NiceJudge looks at row " + row); //keep this line
		for (int i=0; i!=super.getNumberOfOrangeBalloons(row); i++)
		{
		    System.out.println("placing reds");
		    Balloon b = new OrangeBalloon();
		    super.placeLeftAlligned(b, row);
		}
		for (int i=0; i!=super.getNumberOfYellowBalloons(row); i++)
		{
		    System.out.println("placing yellows");
		    Balloon b = new YellowBalloon();
		    super.placeLeftAlligned(b, row);
		}
	}
}
