package api.endpoints;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.ResourceBundle;
//User end points contains CRUD operations from Resource file
public class UserEndPoints2 
{
	static ResourceBundle getURL()
	{
		ResourceBundle routesdata = ResourceBundle.getBundle("routes"); //Load Resource file
		return routesdata;
	}
	public static Response createUser(User payload)
	{
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(getURL().getString("POST_url"));
		return res;
	}
	public static Response readUser(String userName)
	{
		Response res = given()
			.pathParam("username",userName)			
		.when()
			.get(getURL().getString("GET_url"));
		return res;
	}
	public static Response updateUser(String userName, User payload)
	{
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username",userName)			
			.body(payload)	
		.when()
			.put(getURL().getString("PUT_url"));
		return res;
	}
	
	public static Response deleteUser(String userName)
	{
		Response res = given()
			.pathParam("username",userName)			
		.when()
			.delete(getURL().getString("DEL_url"));
		return res;
	}
	
}
