package MastercardTest.testRestAPI;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

class RestAssuredApiCallMain {

	JSONArray petsList;
	String status = "available";
	Response resp;
	int count = 0;

	public void RESTResponse(String status) {
		this.status = status;
		resp = RestAssured.get("https://petstore.swagger.io/v2/pet/findByStatus?status=" + status);
		System.out.println("Step Pass");
	}

	public void getJSONresponse() {
		int code = resp.getStatusCode();
		if (code == 200) {
			System.out.println("RESPONSE  " + resp);
			String data = resp.asString();
			JSONParser jsonParser = new JSONParser();

			try {
				Object obj = jsonParser.parse(data);
				petsList = (JSONArray) obj;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("JSON response from online API ->  " + petsList);
		} else {
			// JSON parser object to parse read file
			JSONParser jsonParser = new JSONParser();

			try (FileReader reader = new FileReader("data/pets.json")) {
				// Read JSON file
				Object obj = jsonParser.parse(reader);

				petsList = (JSONArray) obj;
				System.out.println("JSON response from provided file ->  " + petsList);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

	}

	private void parsepetObject(JSONArray pet) {
		int count = 0;
		String name = "";

		for (int i = 0; i < pet.size(); i++) {
			JSONObject json = (JSONObject) pet.get(i);
			String status = json.get("status").toString();
			if (json.containsKey("name"))
				name = json.get("name").toString();
			if (status.equalsIgnoreCase("available") && name.equalsIgnoreCase("doggie")) {
				count++;
			}
		}
		System.out.println("Count is " + count);

	}

	public void getPetsByStatus() {
		parsepetObject(petsList);

	}

	public void getStatus(String status) {
		this.status = status;
		JSONArray pet = petsList;

		String name = "";

		for (int i = 0; i < pet.size(); i++) {
			JSONObject json = (JSONObject) pet.get(i);
			String status1 = json.get("status").toString();
			if (json.containsKey("name"))
				name = json.get("name").toString();
			if (status1.equalsIgnoreCase("available") && name.equalsIgnoreCase("doggie")) {
				count++;
			}
		}

	}

	public void countAvailableDoggie() {
		System.out.println("pets 'doggie' with 'available' status ->  	 " + count);
	}

}
