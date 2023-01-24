
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class ChargeOfView implements ViewInterface {

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
				int assistant_id = resultSet.getInt("assistant_id");
				
				
				// Display values
				System.out.print(assistant_id + "\t");
				System.out.println(resident_id);
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
		Integer assistant_id = getInteger("Assistant ID : ", true);
		Integer resident_id = getInteger("Resident ID : ", true);
		
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (assistant_id != null) whereParameters.put("assistant_id", assistant_id);
		if (resident_id != null) whereParameters.put("resident_id", resident_id);
		
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("ChargeOf", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "resident_id, assistant_id");

		List<Object> rows = new ArrayList<>();
		
		Integer assistant_id, resident_id ;
		do
		{
			System.out.println("Fields to insert:");
			assistant_id = getInteger("AssistantManager ID : ", true);
			resident_id = getInteger("Resident ID : ", true);
			System.out.println();
					
			if (assistant_id != null && resident_id != null) {
				rows.add(new ChargeOf(resident_id,assistant_id));
			}
		}
		while (assistant_id != null && resident_id != null);
		
		parameters.put("rows", rows);
		
		return new ViewData("ChargeOf", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Fields to update:");
		Integer assistant_id = getInteger("Assistant ID : ", true);
		Integer resident_id = getInteger("Resident ID : ", true);
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
		if (assistant_id != null) updateParameters.put("assistant_id", assistant_id);
		if (resident_id != null) updateParameters.put("resident_id", resident_id);
		
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("ChargeOf", "update", parameters);
	}

	ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("ChargeOf", "delete", parameters);
	}
	

	@Override
	public String toString() {
		return "ChargeOf View";
		}	
	}