package sg.edu.nus.iss.club;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ClubApplication {

	public static void main (String args[]) {

		HashMap<String,Facility> facility; 

		Club club = new Club();
		Date startDate1= null;
		Date finishDate1 = null;
		Date startDate= null;
		Date finishDate = null;
		
		SimpleDateFormat sf = new SimpleDateFormat("d-MMM-yyyy HH:mm");
		Scanner scanner = new Scanner(System.in);

			club.addMember("Miglani","Srishti"," ");
			club.addMember("Verma","Sanskar","Deepak");
			club.addMember("Verma","Sukriti"," ");
			club.addMember("Mordhost","John","K");

			club.showMembers();

		System.out.println("Enter Index of the member you want to show");
		int index = Integer.parseInt(scanner.nextLine());
		
		System.out.println("\n\n\n\n\n\n\n");
		
		System.out.println("Here is the info:" +" " +club.getMember(index).show());
		System.out.println("\n\n\n\n\n\n\n");

		System.out.println("Enter Index of the member you want to delete"); 
		index = Integer.parseInt(scanner.nextLine());
		club.removeMember(index);
		club.showMembers();
		
		facility = club.addFacility();
		try{
			startDate1 = sf.parse("1-Mar-2000 12:00");
			finishDate1 = sf.parse("1-Mar-2000 13:03");
		}catch(ParseException e)
		{
			e.printStackTrace();
		}
		club.addBooking(0,"Room 1", startDate1, finishDate1);
		club.showBookings("Room 1", startDate1, finishDate1);
		try{	
			startDate = sf.parse("1-Mar-2000 11:00");
			finishDate = sf.parse("1-Mar-2000 12:10");

		}
		catch(ParseException e){
			e.printStackTrace();
		}
		club.addBooking(0,"Room 1", startDate, finishDate);
		club.showBookings("Room 1", startDate, finishDate);


		System.out.println("Enter the facility name of the booking you want to remove");
		String name = scanner.nextLine();			

		ArrayList<Booking> book = club.getBookings(name, startDate1, finishDate1);
		Iterator<Booking> iter = book.iterator();
		Booking booking;
		while(iter.hasNext())
		{
			booking= iter.next();
			if(((booking.getStartDate()).equals(startDate1))&&((booking.getFinishDate()).equals(finishDate1)))
			{
				club.removeBooking(booking);
				break;
			}
		}
		
	
		System.out.println("\nShowing bookings: ");
		club.showBookings("Room 1", startDate, finishDate);

		club.showFacilities();

		System.out.println("Enter name of the facility you want to show");
		name = scanner.nextLine();
		System.out.println("Here is the info:");
		(club.getFacility(name)).show();

		System.out.println("Enter name of the facility you want to delete"); 
		name = scanner.nextLine();
		club.removeFacility(name);

		System.out.println ("\nFacilities:");
		club.showFacilities();



	}

}
