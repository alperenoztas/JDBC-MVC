
public class Manager {
  private int manager_id;
  private String firstName;
  private String lastName;
  private String contactInfo;
	  
	public Manager(int manager_id,String firstName, String lastName, String contactInfo) {
		this.manager_id = manager_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactInfo = contactInfo;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
  
	public Object getByName(String attributeName) {
		switch(attributeName) {
		case "manager_id" : return manager_id;
		case "firstName" : return firstName;
		case "lastName" : return lastName;
		case "contactInfo" : return contactInfo;
		default : return null;
		}
	}
	
	@Override
	public String toString() {
		return "Manager [manager_id=" + manager_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contactInfo=" + contactInfo + "]";
	}
	
	
	
}
