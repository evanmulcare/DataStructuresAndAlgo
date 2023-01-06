import java.util.Scanner;

public class AirlineReservation
{
    public static void main(String[] args){
        boolean[] arrSeats = new boolean[10];
        int total = 0;
        int firstTotal = 0;
        int economyTotal = 0;
        Scanner input = new Scanner(System.in);
            while(total != 10)
            {
                System.out.print("Enter 1 for first class or 2 for Economy");
                int choice = input.nextInt();
                input.nextLine();
                
                if (choice == 1)
                {
                    firstTotal++;
                    for(int i = 0; i < 5; i++)
                    {
                        if(arrSeats[i] == false)
                        {
                            total++;
                            
                            System.out.println("Boarding Pass, First Class, Booked seat " + (i + 1));
                            arrSeats[i] = true;
                            break;
                        }
                    }
                    
                    if(firstTotal > 5 && economyTotal < 5)
                    {
                        System.out.println("First Class is Now Full, would you like to join Economy instead? Yes:1 OR No:2");
                        int pick = input.nextInt();
                        input.nextLine();
                        if (pick == 1)
                        {
                            choice = 2;
                        }
                        else if (pick == 2)
                        {
                             break;
                        }
                    }
                }
                
                if (choice == 2)
                {
                    economyTotal++;
                    for(int i = 5; i < arrSeats.length; i++)
                    {
                        if(arrSeats[i] == false)
                        {
                            
                            total++;
                            System.out.println("Boarding Pass, Economy class, Booked seat " + (i + 1));
                            arrSeats[i] = true;
                            break;
                        }
                    }
                    
                    if(economyTotal > 5 && firstTotal < 5)
                    {
                        System.out.println("Economy Class is Now Full,would you like to join First instead? Yes:1 OR No:2");
                        int pick = input.nextInt();
                        input.nextLine();
                        if (pick == 1)
                        {
                            choice = 1;
                        }
                        else if (pick == 2)
                        {
                             break;
                        }
                    }
                }
            }
            System.out.println("Next flight leaves in 3 hours.");
    }
        
}
