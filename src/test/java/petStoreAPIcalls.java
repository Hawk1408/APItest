import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class petStoreAPIcalls{
    @Test
    public static void findByStatus(){

        RestAssured.baseURI = "https://petstore.swagger.io/";
        Response response = given().
                when().param("status", "available").
                get("v2/pet/findByStatus").thenReturn();

        System.out.println(response.getStatusCode());
        //response.getBody().prettyPrint();
    }


    @Test
    public static void addPet(){
        RestAssured.baseURI = "https://petstore.swagger.io/";
        Response response = given().
                when().body("{\"id\":0,\"category\":{\"id\":0,\"name\":\"string\"},\"name\":\"doggie\",\"photoUrls\":[\"string\"],\"tags\":[{\"id\":0,\"name\":\"string\"}],\"status\":\"available\"}")
                .header("Content-Type", "application/json")
                .post("v2/pet/").thenReturn();
        System.out.println(response.getStatusCode());
        //response.getBody().prettyPrint();
    }

}
