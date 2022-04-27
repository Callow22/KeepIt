import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import org.testng.Assert;
import resources.Login;
import resources.User;

import java.time.ZonedDateTime;

import static io.restassured.RestAssured.given;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest {
    private static Login login= Login.builder().build();
    private static User user=new User(true, ZonedDateTime.parse("2019-02-28T13:07:49Z"),"7dwqnq-5cvrcm-1z3ehj","80ltks-yhfls5-24zyf2",true);
    private static String guid="/zhc4v6-5ev7di-9hhhlm";
    private static int https_Ok=200;
    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI="https://ws-test.keepit.com/users";
    }

    @Test
    public void getUserId(){
        Response response;
        response = given()
                .contentType(ContentType.XML)
                .auth().basic(login.getLogin(), login.getPassword())
                .when()
                .get(guid)
                .then()
                .extract().response();
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode, https_Ok);
        Assert.assertEquals(response.path("user.enabled").toString(),user.getEnabled().toString());
        Assert.assertEquals(response.path("user.created").toString(),user.getCreated().toString());
        Assert.assertEquals(response.path("user.product").toString(),user.getProduct());
        Assert.assertEquals(response.path("user.parent").toString(),user.getParent());
        Assert.assertEquals(response.path("user.subscribed").toString(),user.getSubscribed().toString());
    }

}
