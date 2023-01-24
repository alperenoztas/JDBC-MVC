
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


class ControllerView implements ViewInterface {

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
				// Retrieve by column firstName
				int controller_id = resultSet.getInt("controller_id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String contactInfo = resultSet.getString("contactInfo");
				int manager_id = resultSet.getInt("manager_id");
				
				// Display values
				System.out.print(controller_id + "\t");
				System.out.print(firstName + "\t");
				System.out.print(lastName + "\t");
				System.out.print(contactInfo + "\t");
				System.out.println(manager_id);
				
				
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
		Integer controller_id = getInteger("Controller ID : ", true);
		String firstName = getString("First Name : ", true);
		String lastName = getString("Last Name : ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (controller_id != null) whereParameters.put("controller_id", controller_id);
		if (firstName != null) whereParameters.put("firstName", firstName);
		if (lastName != null) whereParameters.put("LastName", lastName);
		
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("ControllerDB", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		
		
		parameters.put("fieldNames", "controller_id, firstName, lastName");

		List<Object> rows = new ArrayList<>();
		
		Integer controller_id;
		String firstName, lastName, contactInfo;
		do
		{
			System.out.println("Fields to insert:");
			controller_id = getInteger("Controller ID : ", true);
			firstName = getString("First Name : ", true);
			lastName = getString("Last Name : ", true);
			contactInfo = getString("Contact Info : ", true);
			System.out.println();
					
			if (firstName != null && lastName != null) {
				rows.add(new ControllerDB(controller_id,firstName, lastName,contactInfo));
			}
		}
		while (firstName != null && lastName != null);
		
		parameters.put("rows", rows);
		
		return new ViewData("ControllerDB", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Fields to update:");
		Integer controller_id = getInteger("Controller ID : ", true);
		String firstName = getString("First Name : ", true);
		String lastName = getString("Last Name : ", true);
		String contactInfo = getString("Contact Info : ", true);
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
		if (controller_id != null) updateParameters.put("controller_id", controller_id);
		if (firstName != null) updateParameters.put("firstName", firstName);
		if (lastName != null) updateParameters.put("lastName", lastName);
		if (contactInfo != null) updateParameters.put("contactInfo", contactInfo);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("ContollerDB", "update", parameters);
	}

	ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("ControllerDB", "delete", parameters);
	}

	@Override
	public String toString() {
		return "Controller View";
	}		
}
