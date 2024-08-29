/*
#Swagger URI --> https://petstore.swagger.io
#Create user(Post) : https://petstore.swagger.io/v2/user
#Get user (Get): https://petstore.swagger.io/v2/user/{username}
#Update user (Put) : https://petstore.swagger.io/v2/user/{username}
#Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}
#User Model
 * */
package api.endpoints;
public class Routes 
{
	public static String base_url = "https://petstore.swagger.io/v2";
	//User module
	public static String POST_url = base_url+"/user";
	public static String GET_url = base_url+"/user/{username}";
	public static String PUT_url = base_url+"/user/{username}";
	public static String DEL_url = base_url+"/user/{username}";
	
	//Store module - Here create the Store module URL's
	
	//Pet module - Here create the Pet module URL's
}
