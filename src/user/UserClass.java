package user;

public class UserClass {
	private String name, profession, locality;
	private int age;
	private String[] groups;
	private static int MAXGROUPS = 10;
	
	public UserClass( String name, int age , String locality, String profession ) {
		this.name = name;
		this.age = age;
		this.profession = profession;
		this.locality = locality;
		groups = new String[MAXGROUPS];
	}
	
	public String getName() {
		return name;
	}
	
	public String getProfession() {
		return profession;
	}
	
	public String getLocality() {
		return locality;
	}
	
	public int getAge() {
		return age;
	}
}
