package sg.edu.nus.iss.club;
import java.util.*;

public class BookingRegister {
	public static HashMap<Facility,ArrayList<Booking>> register = new HashMap<Facility,ArrayList<Booking>>(); 
	private ArrayList<Booking> booking = null;
	private Iterator<Booking> iter;

	public void addBooking(Member member, Facility facility, Date startDate, Date endDate)
	{

		boolean value = false;
		try{
			Booking book = new Booking(member,facility,startDate,endDate);
			booking = register.get(facility);
			if(booking == null)
			{
				booking = new ArrayList<Booking>();
			}
			else
			{
					value=book.overlaps(book);
					if(value==true)
					{
						throw new BadBookingException("Facility has already been booked for the same time");
					}
			}
			booking.add(book);

		}catch(BadBookingException e)
		{
			System.out.println(e.getMessage());
		}
		register.put(facility,booking);
	}

	public ArrayList<Booking> getBookings(Facility facility, Date startDate, Date finishDate)
	{
		ArrayList<Booking> bookings = register.get(facility);
		Booking book;
		if(bookings==null)
		{
			System.out.println("No bookings for this facility");
			bookings = new ArrayList<Booking>();
		}
		else
		{
			Iterator<Booking> iter = bookings.iterator();
			while(iter.hasNext())
			{
				book = iter.next();
				String start = (book.getStartDate()).toString();
				String end =  (book.getFinishDate()).toString();
				if((startDate.equals(start)||startDate.after(book.getStartDate())
						&&(finishDate.equals(end)||finishDate.before(book.getFinishDate()))))
				{
					bookings.add(book); 
				}
			}
		}
		return bookings;
	}

	public void removeBooking(Booking book)
	{
		(register.get(book.getFacility())).remove(book);
		
	}
	
}
