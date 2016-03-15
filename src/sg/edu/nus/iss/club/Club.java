package sg.edu.nus.iss.club;

import java.util.*;

public class Club {
	private static int membershipNumber = 0; 
	private ArrayList<Member> member_objects = new ArrayList<Member>();
	private HashMap<String,Facility> facility = new HashMap<String,Facility>();
	private BookingRegister register = new BookingRegister();


	public ArrayList<Member> addMember(String surname, String firstName, String secondName)
	{
		/*int length = member_objects.length; 

		if (membershipNumber == length)
		{
			getExtendedArray(length);
		}*/

		member_objects.add(new Member(membershipNumber,surname,firstName,secondName));
		membershipNumber ++;
		return member_objects;
		//turnsladhk;

	}

	public HashMap<String,Facility> addFacility()
	{
		facility.put("Main Hall",new Facility("Main Hall", " "));
		facility.put("Room 1",new Facility("Room 1", "Conference Room on Level 2"));
		facility.put("Room 2",new Facility("Room 2", "Meeting Room on Level 3"));
		facility.put("Room 3",new Facility("Room 3", "Meeting Room on Level 4"));
		return facility;
	}

	/*public final void getExtendedArray(int length)
	{
		int new_length = length+1;
		Member temp[] = new Member[new_length];
		for(int i=0;i<length; i++)
		{
			temp[i]= member_objects[i];
		}
		member_objects = temp;	
	}*/

	public ArrayList<Member> getMembers()
	{		
		Iterator<Member> iter = member_objects.iterator();
		ArrayList<Member> member_temp = new ArrayList<Member>();
		//Member temp[] = new Member[member_objects.length];
		while(iter.hasNext())
		{
			member_temp.add(iter.next());

		}
		return member_temp;
	}


	public void showMembers()
	{
		ArrayList<Member> member = getMembers();
		Iterator<Member> iter = member.iterator();
		while(iter.hasNext())
		{
			(iter.next()).show();
		}
	}

	public Member getMember(int index)
	{ 
		Member memb = null;
		if(member_objects.isEmpty())
		{
			return memb;
		}
		else{
			memb = member_objects.get(index);
			return memb;
		}
	}

	public void removeMember(int index)
	{ 
		member_objects.remove(index);

		/* Member temp[] = new Member[member_objects.length-1];
		if(index==member_objects.length-1){
			member_objects[index]= null;
		}
		else{

		for(int i = index ; i<member_objects.length-1 ; i++)
		{
				member_objects[i]= member_objects[i+1];
//				/member_objects[i+1] = null;
		}
		}
		for(int i = 0 ; i<member_objects.length; i++)
		{
			if(member_objects[i]!=null)
			{
				temp[i]= member_objects[i];
			}
			else
			{
				break;
			}

		}
		member_objects = temp;	*/ 

	}

	public ArrayList<Facility> getFacilities()
	{		
		ArrayList<Facility> fac = new ArrayList<Facility>();
		Set<String> keys = facility.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext())
		{
			fac.add(facility.get(iter.next()));
		}
		return fac;
	}


	public void showFacilities()
	{
		ArrayList<Facility> fac = getFacilities();
		Iterator<Facility> iter = fac.iterator();
		while(iter.hasNext())
		{
			(iter.next()).show();

		}
	}

	public Facility getFacility(String name)
	{
		Facility fac = facility.get(name);
		return fac;
	}

	public void removeFacility(String name)
	{  
		facility.remove(name);	
	}


	public void addBooking(int id, String name, Date start, Date end)
	{
		Member member = this.getMember(id); 
		Facility fac = this.getFacility(name);
		register.addBooking(member, fac, start, end);			
	}

	public ArrayList<Booking> getBookings(String name, Date start, Date end)
	{
		Facility fac = this.getFacility(name);
		ArrayList<Booking> bookings = register.getBookings(fac, start, end);
		return bookings;
	}

	public void showBookings(String name, Date start, Date end)
	{
		ArrayList<Booking> bookings=this.getBookings(name, start, end);
		Iterator<Booking> iter = bookings.iterator();
		while(iter.hasNext())
		{
			(iter.next()).show();
		}

	}

	public void removeBooking(Booking book)
	{
		register.removeBooking(book);
	}
}
