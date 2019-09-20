// Project for Bus Ticket Reservation 
// package busticketreservation;
import java.util.ArrayList;
import java.io.*;
class ReadData
{
	public static String readString(String message)
	{
		String value = "";
		DataInputStream dis = new DataInputStream(System.in);
		try
		{
			System.out.println(message);
			value = dis.readLine();
		}
		catch(Exception e)
		{
			// System.out.println("\n Exception Caught In Reading a String ");
		}
		return value;
	}// end method readString
        public static void pressEnterToContinue()
	{
		String value = "";
		DataInputStream dis = new DataInputStream(System.in);
		try
		{
			System.out.print("\n\nPress Enter To Continue .........");
			value = dis.readLine();
		}
		catch(Exception e)
		{
			// System.out.println("\n Exception Caught In Reading a String ");
		}
	}// end method readString
	public static int readInteger(String message)
	{
		int value = 0;
		DataInputStream dis = new DataInputStream(System.in);
		try
		{
			System.out.println(message);
			value = Integer.parseInt(dis.readLine());
		}
		catch(Exception e)
		{
			// System.out.println("\n Exception Caught In Reading an Integer ");
		}
		return value;
	}// end method readString
        public static void display_formatted_line()
        {
            System.out.print("\n ******************************************************************");
        }
}

class Ticket
{
    int ticket_no;
    String start_city = new String();
    String end_city = new String();
    boolean booking_status;
    Ticket()
    {
        this.ticket_no = 0;
        this.start_city = "Agra";
        this.end_city="Delhi";
        this.booking_status = false;
    }
    void display_ticket()
    {
        ReadData.display_formatted_line();
        System.out.print("\n ");
        System.out.print("\n Start city " + this.start_city);
        System.out.print("\n End city " + this.end_city);
        System.out.print("\n Ticket No : " + this.ticket_no);
        System.out.print("\n Booked : " + this.booking_status);
    }
    void book_this_ticket()
    {
        this.booking_status = true;
    }
}
class Bus
{
    final int TICKET_COUNT = 5;
    ArrayList list_of_available_tickets = new ArrayList(); 
    ArrayList list_of_booked_tickets = new ArrayList();
    Bus()
    {
        
    }
    void generate_tickets()
    {
        int i;
        for(i=0;i<this.TICKET_COUNT;i++)
        {
            Ticket t1 = new Ticket();
            t1.ticket_no = i;
            this.list_of_available_tickets.add(t1);
        }
    }
    void book_a_ticket()
    {
        if(!this.list_of_available_tickets.isEmpty())
        {
            Ticket  t = (Ticket)this.list_of_available_tickets.get(0);
            t.book_this_ticket();
            this.list_of_booked_tickets.add(t);
            this.list_of_available_tickets.remove(0);
        }
        else
        {
            System.out.print("\n Ticket is not available");
        }
    }
    void display_available_tickets()
    {
        int n = this.list_of_available_tickets.size();
        for(int i=0;i<n;i++)
        {
            Ticket t = (Ticket)this.list_of_available_tickets.get(i);
            t.display_ticket();
        }
    }
    void display_all_booked_tickets()
    {
        int n = this.list_of_booked_tickets.size();
        for(int i=0;i<n;i++)
        {
            Ticket t = (Ticket)this.list_of_booked_tickets.get(i);
            t.display_ticket();
        }
    }
}
public class BusTicketReservation {

    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Bus bus = new Bus();
        bus.generate_tickets();
        int choice = 1;
        do
        {
            ReadData.display_formatted_line();
            System.out.print("\n 0. Exit");
            System.out.print("\n 1. Display Available Tickets ");
            System.out.print("\n 2. Display Booked Tickets ");
            System.out.print("\n 3. Book a ticket");
            ReadData.display_formatted_line();
            choice = ReadData.readInteger("\n Enter your choice : ");
            switch(choice)
            {
                case 0:
                    ReadData.pressEnterToContinue();
                    break;
                case 1:
                    bus.display_available_tickets();
                    break;
                case 2:
                    bus.display_all_booked_tickets();
                    break;
                case 3:
                    bus.book_a_ticket();
                    break;
                default:
            }
        }while(choice != 0);        
    }    
}
