package sg.edu.nus.iss.club;

public class Facility {

	private String name;
	private String description;

	public Facility (String name) {
		this (name, null);
	}

	public Facility (String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName () {
		return name;
	}

	public String getDescription () {
		return description;
	}

	public String show() {
		String fullName = this.name;
		if (this.description != null || this.description!= " " ) {
			fullName += " (" + this.description + ")";
		}
		System.out.println(fullName);
		return fullName;	
		}
	public boolean equals(Object facility) {
		if (facility instanceof Facility) {
			Facility fac = (Facility) facility;
			if (this.getName().equals(fac.getName()))
				if (this.getDescription() == null)
					if (fac.getDescription() == null)
						return true;
					else return false;
				else if (fac.getDescription() != null)
					if (this.getDescription().equals(fac.getDescription()))
						return true;

		}
		return false;
	}
}
