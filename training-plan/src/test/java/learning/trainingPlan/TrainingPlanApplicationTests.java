package learning.trainingPlan;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.HttpStatus;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

@SpringBootTest
@TestConfiguration
class TrainingPlanApplicationTests {

	static final String BASE_URL = "http://localhost:8080";

	@Test
	void contextLoads() {
	}
//poniżej test do poprawy bo nie powinien zwracać 401 tylko 200
	@Test
	void convienceMethods(){
		RequestSpecification httpRequest = RestAssured.given().auth().basic("test3", "test");
		Response response = RestAssured.get(BASE_URL);
		Assert.assertEquals(response.getStatusCode(),401);
	}



}
