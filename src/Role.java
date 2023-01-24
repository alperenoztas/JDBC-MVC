
public class Role {
    private int residentId;
    private String role;

    public Role(int residentId, String role) {
        this.residentId = residentId;
        this.role = role;
    }

    
    public int getResidentId() {
		return residentId;
	}



	public void setResidentId(int residentId) {
		this.residentId = residentId;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public Object getByName(String attributeName) {
		switch(attributeName) {
		case "residentId" : return residentId;
		case "role" : return role;
		default : return null;
		}
	}


	@Override
	public String toString() {
		return "Role [residentId=" + residentId + ", role=" + role + "]";
	}
	
	
}