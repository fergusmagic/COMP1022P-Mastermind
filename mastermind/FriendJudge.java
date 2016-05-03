import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FriendJudge extends Judge
{
    public void judgeRow(int row)
    {
        int[] secret = {0, 0, 0, 0};
        int[] answer = {0, 0, 0, 0};
        for (int i=0; i!=MastermindWorld.secret.length(); i++)
        {
            switch (MastermindWorld.secret.charAt(i))
            {
                case 'B':
                    secret[0]++;
                    break;
                case 'G':
                    secret[1]++;
                    break;
                case 'R':
                    secret[2]++;
                    break;
                case 'P':
                    secret[3]++;
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }
        for (int i=0; i!=4; i++)
        {
            Peg thisPeg = (Peg)(GWorld.getOneObjectAt(i, row, "Peg"));
            if (thisPeg != null && thisPeg.color == MastermindWorld.secret.charAt(i))
            {
                switch (thisPeg.color)
                {
                    case 'B':
                        answer[0]++;
                        break;
                    case 'G':
                        answer[1]++;
                        break;
                    case 'R':
                        answer[2]++;
                        break;
                    case 'P':
                        answer[3]++;
                        break;
                    default:
                        System.out.println("error");
                        break;
                }
                Balloon b = new OrangeBalloon();
                GWorld.addOneObject(b, i+5, row);
            }
        }
        for (int i=0; i!=4; i++)
        {
            Peg thisPeg = (Peg)(GWorld.getOneObjectAt(i, row, "Peg"));
            if (thisPeg != null && GWorld.getOneObjectAt(i+5, row, "Balloon") == null)
            {
                int index;
                switch (thisPeg.color)
                {
                    case 'B':
                        index = 0;
                        break;
                    case 'G':
                        index = 1;
                        break;
                    case 'R':
                        index = 2;
                        break;
                    case 'P':
                        index = 3;
                        break;
                    default:
                        index = -1;
                        break;
                }
                if (secret[index] - answer[index] > 0)
                {
                    answer[index]++;
                    Balloon b = new YellowBalloon();
                    GWorld.addOneObject(b, i+5, row);
                }
            }
        }
    }
    
}
