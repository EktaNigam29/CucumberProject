package stepDefinition7;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payload.TestData;
import pojoMapper.CreateUser;
import utilites.FetchdataFromProperty;
import utilites.FetchdatafromExcel;

public class StepDefinition7 {
	
	RequestSpecification req;
	RequestSpecification res;
	ResponseSpecification respec;
	Response response;
	
	String URL=FetchdataFromProperty.readDataFromProperty().getProperty("URL1");
	String authToken=FetchdataFromProperty.readDataFromProperty().getProperty("token");
	
	
	
	
	@Given("user has requested to it an appliaction URL")
	public void user_has_requested_to_it_an_application_url() {
		
		 req=new RequestSpecBuilder().setBaseUri(URL).setContentType(ContentType.JSON).build();
	}

	@Given("user will pass the payload with all needed details")
	public void user_will_pass_the_payload_with_all_needed_details() throws IOException {
	 res=given().log().all().relaxedHTTPSValidation().spec(req).body(CreateUser.userDetails());
		// res=given().log().all().relaxedHTTPSValidation().spec(req).body(FetchdatafromExcel.AddNewUserDeatils());
	}

	@When("the user will hit the specific {string}")
	public void the_user_will_hit_the_specific(String endpoint1) {
		
		respec=new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.build();
		response=res.when().post(endpoint1).then().log().all().spec(respec).extract().response();
	}

	
	@Then("we are going to validate the status code as specific {string}")
	public void we_are_going_to_validate_the_status_code_as_specific(String statuscode) throws JsonMappingException, JsonProcessingException {
	long time=response.getTime();
	if(time<5000)
	{
		System.out.println("it is within threshold");
	}
	else
	{
		throw new ArithmeticException();
	}
		
	String s=statuscode;
	int expectedStatusCode=Integer.parseInt(s);
	int actualStatusCode=response.getStatusCode();
Assert.assertEquals(actualStatusCode, expectedStatusCode);
JsonPath js=new JsonPath(response.asString());
String actualname=js.getString("name");
String expectedname=CreateUser.getName();
Assert.assertEquals(actualname, expectedname);

String actualaddress=js.getString("address");
String expectedaddress=CreateUser.getAddress();
Assert.assertEquals(actualaddress, expectedaddress);	
/*JsonPath js=new JsonPath(response.asString());
String expectedusername=	js.getString("username");
Object actual_name=FetchdatafromExcel.getUsername();
String actualusername=actual_name.toString();

Assert.assertEquals(actualusername, expectedusername);

String expectedjob=	js.getString("job");
Object actual_job=FetchdatafromExcel.getJob();
String actualjob=actual_job.toString();

Assert.assertEquals(actualjob, expectedjob);
System.out.println("test case is passed");*/
	}

	/*@Given("User has requested to hit an application url")
	public void user_has_requested_to_hit_an_application_url() {
		 req=new RequestSpecBuilder().setBaseUri(URL).setContentType(ContentType.JSON).build();
	}


	@Given("user passes a paylaod with all required credentials")
	public void user_passes_a_paylaod_with_all_required_credentials() {
		
		res=given().log().all().header("Authorization",authToken)
				.relaxedHTTPSValidation().spec(req).body(TestData.AddUserDeatils());
	} 

	@When("the user is going to hit url {string}")
	public void the_user_is_going_to_hit_url(String endpoint) {
		respec=new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.build();
		response=res.when().post(endpoint).then().log().all().spec(respec).extract().response();
	}

	@Then("the user will be able to validate response code and the body")
	public void the_user_will_be_able_to_validate_response_code_and_the_body() {
		long time=response.getTime();
		if(time<50000)
		{
			System.out.println("it is within threshold");
		}
		else
		{
			throw new ArithmeticException();
		}
		String status_code="201";	
		String s=status_code;
		int expectedStatusCode=Integer.parseInt(s);
		int actualStatusCode=response.getStatusCode();
	Assert.assertEquals(actualStatusCode, expectedStatusCode);
	
	JsonPath js=new JsonPath(response.asString());
String expectedname=	js.getString("name");
Object actual_name=TestData.getName();
String actualname=actual_name.toString();

Assert.assertEquals(actualname, expectedname);

String expectedemail=	js.getString("email");
Object actual_email=TestData.getEmail();
String actualemail=actual_email.toString();

Assert.assertEquals(actualemail, expectedemail);
System.out.println("test case is passed");

	
	}*/




}
