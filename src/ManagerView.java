
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ManagerView implements ViewInterface {

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
				int manager_id = resultSet.getInt("manager_id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String contactInfo = resultSet.getString("contactInfo");
				
				// Display values
				System.out.print(manager_id + "\t");
				System.out.print(firstName + "\t");
				System.out.print(lastName + "\t");
				System.out.println(contactInfo);

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
		Integer manager_id = getInteger("Manager ID : ", true);
		String firstName = getString("First Name : ", true);
		String lastName = getString("Last Name : ", true);
		String contactInfo = getString("Contact Info : ", true);
		
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (manager_id != null) whereParameters.put("manager_id", manager_id);
		if (firstName != null) whereParameters.put("firstName", firstName);
		if (lastName != null) whereParameters.put("lastName", lastName);
		if (contactInfo != null) whereParameters.put("contactInfo", contactInfo);
		
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Manager", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "manager_id, firstName, lastName, contactInfo");

		List<Object> rows = new ArrayList<>();
		
		Integer manager_id;
		String firstName, lastName, contactInfo;
		do
		{
			System.out.println("Fields to insert:");
			manager_id = getInteger("Manager ID : ", true);
			firstName = getString("Name : ", true);
			lastName = getString("Last Name : ", true);
			contactInfo = getString("Contact Info : ", true);
			System.out.println();
					
			if (firstName != null && lastName != null) {
				rows.add(new Manager(manager_id, firstName, lastName, contactInfo));
			}
		}
		while (firstName != null && lastName != null);
		
		parameters.put("rows", rows);
		
		return new ViewData("Manager", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Fields to update:");
		Integer manager_id = getInteger("Manager ID : ", true);
		String firstName = getString("First Name : ", true);
		String lastName = getString("Last Name : ", true);
		String contactInfo = getString("Contact Info : ", true);
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
		if (manager_id != null) updateParameters.put("manager_id", manager_id);
		if (firstName != null) updateParameters.put("firstName", firstName);
		if (lastName != null) updateParameters.put("lastName", lastName);
		if (contactInfo != null) updateParameters.put("contactInfo", contactInfo);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Manager", "update", parameters);
	}

	ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Manager", "delete", parameters);
	}

	@Override
	public String toString() {
		return "Manager View";
		}	
	}