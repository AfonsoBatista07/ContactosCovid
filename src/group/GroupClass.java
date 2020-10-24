package group;

public class GroupClass implements Group, Comparable<Group>{
	
	private String name, description;
	
	public GroupClass(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescritpion() {
		return description;
	}

	@Override
	public int compareTo(Group group) {
		return name.compareTo(group.getName());
	}
}
