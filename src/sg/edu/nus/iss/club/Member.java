package sg.edu.nus.iss.club;

public class Member extends Person {
	
	private int membershipNumber = 0; 
	public boolean equals(Object o)
	{
	if(this.getFirstName()==((Member)o).getFirstName())	
	return true;
	return false;	
	}
	
	public Member(int membershipNumber, String surname, String firstName, String secondName)
	{
		super(surname,firstName,secondName);
		this.membershipNumber = membershipNumber;
	}

	public int getMembershipNumber() {
		return membershipNumber;	
	}

	public String toString()
    {
		String fullName = super.toString();
		int membershipNumber= this.getMembershipNumber();
		fullName+= " " + membershipNumber;
		System.out.println(fullName);
		return fullName;
		
    }
	
	public String show() {
		
		String fullName = this.toString();
        return fullName;
        
    }
}