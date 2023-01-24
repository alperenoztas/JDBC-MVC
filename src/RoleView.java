

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class RoleView implements ViewInterface {

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
				int resident_id = resultSet.getInt("resident_id");
				String role = resultSet.getString("role");
				
				// Display values
				System.out.print(resident_id + "\t");
				System.out.println(role);
				
				
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
		String role = getString("Role : ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (resident_id != null) whereParameters.put("resident_id", resident_id);
		if (role != null) whereParameters.put("role", role);
		
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Role", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		
		
		parameters.put("fieldNames", "resident_id, role");

		List<Object> rows = new ArrayList<>();
		
		Integer resident_id;
		String role;
		do
		{
			System.out.println("Fields to insert:");
			resident_id = getInteger("Controller ID : ", true);
			role = getString("Role : ", true);
			System.out.println();
					
			if (resident_id != null && role != null) {
				rows.add(new Role(resident_id,role));
			}
		}
		while (resident_id != null && role != null);
		
		parameters.put("rows", rows);
		
		return new ViewData("Role", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Fields to update:");
		Integer resident_id = getInteger("Resident ID : ", true);
		String role = getString("Role : ", true);
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
		if (resident_id != null) updateParameters.put("controller_id", resident_id);
		if (role != null) updateParameters.put("role", role);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Role", "update", parameters);
	}

	ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Role", "delete", parameters);
	}

	@Override
	public String toString() {
		return "Controller View";
	}		
}

