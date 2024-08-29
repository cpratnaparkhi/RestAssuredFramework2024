package api.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
public class DDTests2
{
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class )
	public void testPOSTUsers(String UserID,String UserName,String FirstName,String LastName,String Email,String Password,String Phone)
	{
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(UserID));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(FirstName);
		userPayload.setLastName(LastName);
		userPayload.setEmail(Email);
		userPayload.setPassword(Password);
		userPayload.setPhone(Phone);
		Response res = UserEndPoints2.createUser(userPayload);
		//res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 2, dataProvider = "Usernames", dataProviderClass = DataProviders.class )
	public void testGetUser(String UserName)
	{
		Response res = UserEndPoints2.readUser(UserName);
		//res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 3, dataProvider = "Usernames", dataProviderClass = DataProviders.class )
	public void testDelUser(String UserName)
	{
		Response res = UserEndPoints2.deleteUser(UserName);
		//res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
}
