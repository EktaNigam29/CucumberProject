package pojoMapper;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateUser {

	static CreateUserPojo emp=new CreateUserPojo();
	static ObjectMapper obj=new ObjectMapper();
	static String empJson;
	public static String userDetails() throws JsonProcessingException
	{
		emp.setName("ekta");
		emp.setId(123);
		emp.setAddress("New Delhi");
		emp.setMarried(true);
	empJson=	obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
	return empJson;
	}
	
	public static int getID() throws JsonMappingException, JsonProcessingException
	{
		CreateUserPojo empObj=obj.readValue(empJson, CreateUserPojo.class);
		int ID=empObj.getId();
		return ID;
	}
	public static String getName() throws JsonMappingException, JsonProcessingException
	{
		CreateUserPojo empObj=obj.readValue(empJson, CreateUserPojo.class);
		String Name=empObj.getName();
		return Name;
	}
	
	public static String getAddress() throws JsonMappingException, JsonProcessingException
	{
		CreateUserPojo empObj=obj.readValue(empJson, CreateUserPojo.class);
		String Address=empObj.getAddress();
		return Address;
	}


}
