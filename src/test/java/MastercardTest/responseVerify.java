package MastercardTest;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import MastercardTest.testRestAPI.RestAssuredApiCallMainTest;

public class responseVerify {

	RestAssuredApiCallMainTest res = new RestAssuredApiCallMainTest();
	String status = "available";

	@Given("^I want to verify the response of API$")
	public void i_want_to_verify_the_response_of_API() throws Throwable {
		res.RESTResponse("available");
	}

	@Then("^I will get API response in JSON format$")
	public void i_will_get_API_response_in_JSON_format() throws Throwable {
		res.getJSONresponse();
	}

	@Then("^I am providing the status 'available' and petname 'doggie'$")
	public void i_am_providing_the_status_available_and_petname_doggie() throws Throwable {
		// res.getPetsByStatus();
		res.getStatus("available");
	}

	@Then("^I am providing the status <status> and petname 'doggie'$")
	public void i_am_providing_the_status_status_and_petname_doggie(String status) throws Throwable {
		this.status = status;
		res.getStatus(status);
	}

	@Then("^I am calculating the pets 'doggie' with 'available' status$")
	public void i_am_calculating_the_pets_doggie_with_available_status() throws Throwable {
		res.countAvailableDoggie();
	}

}
