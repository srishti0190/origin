package sg.edu.nus.iss.club;

import static org.junit.Assert.*;

import org.junit.Test;

public class MemberTest {

	@Test
	public void testShow() {
		Member member = new Member(123,"Edison", "Thomas", "Alva");
		assertNotNull("show method is not returning null value" , member.show());
		
	}

}
