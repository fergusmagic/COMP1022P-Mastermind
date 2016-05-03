import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class NaughtyGuy extends SpecialCharacter
{
    public void cheat()
    {
        //part 2 
        int x;
        int y;
        x = this.getX();
        y = this.getY();
        this.setLocation(5, 9);
        Peg p = null;
        switch (MastermindWorld.secret.charAt(x))
        {
            case 'B':
                p = new BluePeg();
                break;
            case 'G':
                p = new GreenPeg();
                break;
            case 'R':
                p = new RedPeg();
                break;
            case 'P':
                p = new PurplePeg();
                break;
            default:
                System.out.println("error");
                break;
        }
        GWorld.addOneObject(p, x, y);
    }
    
    public void reveal()
    {
        int x;
        int y;
        x = this.getX();
        y = this.getY();
        this.setLocation(5, 9);
        for (int i=0; i!=4; i++)
        {
            Peg p = null;
            switch (MastermindWorld.secret.charAt(i))
            {
                case 'B':
                    p = new BluePeg();
                    break;
                case 'G':
                    p = new GreenPeg();
                    break;
                case 'R':
                    p = new RedPeg();
                    break;
                case 'P':
                    p = new PurplePeg();
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            GWorld.addOneObject(p, i, y);
        }
    }
    
    public String id = "NaughtyGuy";
}
