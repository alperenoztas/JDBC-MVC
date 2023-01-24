import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResidentView implements ViewInterface {
	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		switch(operationName) {
		case "select": return selectOperation(modelData);	
		case "insert": return insertOperation(modelData);	
		case "update": return updateOperation(modelData);	
		case "delete": return deleteOperation(modelData);	
		case "select.gui": return selectGUI(modelData);
		case "insert.gui": return insertGUI(modelData);
		case "update.gui": return updateGUI(modelData);
		case "delete.gui": return deleteGUI(modelData);
		}
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				int resident_id = resultSet.getInt("resident_id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				int D_No = resultSet.getInt("D_No");
				String contactInfo = resultSet.getString("contactInfo");
				int controller_id = resultSet.getInt("controller_id");
				
				// Display values
				System.out.print(resident_id + "\t");
				System.out.print(firstName + "\t");
				System.out.print(lastName + "\t");
				System.out.print(D_No + "\t");
				System.out.print(contactInfo + "\t");
				System.out.println(controller_id);
			}
			resultSet.close();	
		}
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData insertOperation(ModelData modelData) throws Exception {
		System.out.println("Number of inserted rows is " + modelData.recordCount);
		
		return new ViewData("MainMenu", "");
	}

	ViewData updateOperation(ModelData modelData) throws Exception {
		System.out.println("Number of updated rows is " + modelData.recordCount);
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData deleteOperation(ModelData modelData) throws Exception {
		System.out.println("Number of deleted rows is " + modelData.recordCount);
		
		return new ViewData("MainMenu", "");
	}	
	
	Map<String, Object> getWhereParameters() throws Exception {
		System.out.println("Filter conditions:");
		Integer resident_id = getInteger("Resident ID : ", true);
		
		String firstName = getString("First Name : ", true);
		String lastName = getString("Last Name : ", true);
		Integer D_No = getInteger("Daire No : ", true);
		String contactInfo = getString("Contact Info : ", true);
		Integer controllerId = getInteger("Controller ID : ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (resident_id != null) whereParameters.put("resident_id", resident_id);
	
		if (firstName != null) whereParameters.put("firstName", firstName);
		if (lastName != null) whereParameters.put("lastName", lastName);
		if (D_No != null) whereParameters.put("D_No", D_No);
		if (contactInfo != null) whereParameters.put("contactInfo", contactInfo);
		if (controllerId != null) whereParameters.put("controllerId", controllerId);

		
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Resident", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "firstName, lastName, controller_id");

		List<Object> rows = new ArrayList<>();
		
		String firstName, lastName;
		Integer controller_id;
		
		do
		{
			System.out.println("Fields to insert:");
			firstName = getString("First Name : ", true);
			lastName = getString("Last Name : ", true);
			controller_id = getInteger("Controller ID : ", true);
			
			System.out.println();
					
			if (firstName != null && lastName != null) {
				rows.add(new Resident(firstName, lastName,1));
			}
		}
		while (firstName != null && lastName != null);
		
		parameters.put("rows", rows);
		
		return new ViewData("Resident", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Fields to update:");
		String firstName = getString("First Name : ", true);
		String lastName = getString("Last Name : ", true);
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
		if (firstName != null) updateParameters.put("firstName", firstName);
		if (lastName != null) updateParameters.put("lastName", lastName);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Resident", "update", parameters);
	}

	ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Resident", "delete", parameters);
	}

	@Override
	public String toString() {
		return "Resident View";
	}
}
