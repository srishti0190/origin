package sg.edu.nus.iss.club;

import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {

	private Member member;
	private Facility facility;
	private Date startDate, finishDate; 
	private static SimpleDateFormat df = new SimpleDateFormat("d-MMM-yyyy H:MM");

	public Booking(Member member, Facility facility, Date startDate, Date finishDate) throws BadBookingException
	{
		if (startDate==null||finishDate==null)
		{
			throw new BadBookingException("Start Date or finish can not be left blank");
		}
		if(facility==null)
		{
			throw new BadBookingException("Facility can not be blank/null");	
		}
		if(member==null)
		{
			throw new BadBookingException("Member can not null/blank");
		}
		if(startDate.after(finishDate))
		{
			throw new BadBookingException("Start date can not be after finish date");	
		}
			this.startDate = startDate;
			this.finishDate = finishDate;
			this.facility = facility;
			this.member = member;
	}

	public Member getMember() {
		return member;
	}

	public Facility getFacility() {
		return facility;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public Boolean overlaps(Booking booking)
	{
		Booking book;
		HashMap<Facility,ArrayList<Booking>> register = BookingRegister.register;
		ArrayList<Booking> list = register.get(booking.getFacility());
		if(list==null)
		{
			return false;
		}
		else
		{
			Iterator<Booking> iter = list.iterator();
			while(iter.hasNext())
			{
				book = iter.next();

				Date start = book.getStartDate();
				Date finish = book.getFinishDate();


				Date start_new =booking.getStartDate();
				Date finish_new = booking.getFinishDate();


				if((start_new.before(finish)&& start_new.after(start))||(finish_new.before(finish)&& finish_new.after(start))
						||((start_new.toString()).equals(start))||((finish_new.toString()).equals(finish)))
				{
					return true;
				}
			}
		}
		return false;
	}


	public String toString()
	{
		String details = null;
		String startdate = df.format(this.getStartDate());
		String finishdate = df.format(this.getFinishDate());
		details+= (this.getMember()).show() + " " +(this.getFacility()).show()+ " " + startdate +" " + " " +finishdate;
		return details;
	}

	public void show()
	{
		String details = this.toString();
		System.out.println("Details of the booking are: " + details);
	}


}
