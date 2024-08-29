package api.endpoints;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
//User end points contains CRUD operations
public class PetEndPoints 
{
	public static Response createUser(User payload)
	{
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.POST_url);
		return res;
	}
	public static Response readUser(String userName)
	{
		Response res = given()
			.pathParam("username",userName)			
		.when()
			.get(Routes.GET_url);
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
			.put(Routes.PUT_url);
		return res;
	}
	
	public static Response deleteUser(String userName)
	{
		Response res = given()
			.pathParam("username",userName)			
		.when()
			.delete(Routes.DEL_url);
		return res;
	}
	
}
