package api.test;
import static org.hamcrest.Matchers.equalTo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;
public class userTests 
{
	Faker faker;
	User userPayLoad;
	public Logger logger;
	@BeforeClass()
	public void setUp()
	{
		faker = new Faker();
		userPayLoad=new User();
		userPayLoad.setId(faker.idNumber().hashCode());
		userPayLoad.setUsername(faker.name().username());
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setLastName(faker.name().lastName());
		userPayLoad.setEmail(faker.internet().safeEmailAddress());
		userPayLoad.setPassword(faker.internet().password(5,10));
		userPayLoad.setPhone(faker.phoneNumber().cellPhone());
		logger = LogManager.getLogger(this.getClass());
	}
	@Test(priority = 1)
	public void testPostUser()
	{
		logger.info("****************  Creating User ***************");
		Response res = UserEndPoints.createUser(userPayLoad);
		//res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("****************  Created User ***************");
	}
	@Test(priority = 2)
	public void testGetUser()
	{
		logger.info("****************  Reading User ***************");
		Response res = UserEndPoints.readUser(userPayLoad.getUsername());
		//res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("****************  User Info Displayed ***************");
	}
	@Test(priority = 3)
	public void testPutUser()
	{
		logger.info("****************  Updating User ***************");
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setLastName(faker.name().lastName());
		userPayLoad.setEmail(faker.internet().safeEmailAddress());
		Response res = UserEndPoints.updateUser(userPayLoad.getUsername(),userPayLoad);
		//res.then().log().body();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("****************  User Data Updated ***************");
		//Checking the Updated data
		Response resAfterUpdate = UserEndPoints.readUser(userPayLoad.getUsername());
		Assert.assertEquals(resAfterUpdate.getStatusCode(),200);
		resAfterUpdate.then()
		.statusCode(200)
		//.log().all()
		.body("firstName",equalTo(userPayLoad.getFirstName()))
		.body("lastName", equalTo(userPayLoad.getLastName()))
		.body("email",equalTo(userPayLoad.getEmail()));
	}
	@Test(priority = 4)
	public void testDelUser()
	{
		
		logger.info("****************  Deleting User ***************");
		Response res = UserEndPoints.deleteUser(userPayLoad.getUsername());
		//res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("****************  User Deleted ***************");
	}
}
