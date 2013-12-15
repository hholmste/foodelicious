package no.foodelicious.core.resources;

import static com.yammer.dropwizard.testing.JsonHelpers.asJson;
import static com.yammer.dropwizard.testing.JsonHelpers.jsonFixture;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import no.foodelicious.core.model.Recipe;

import org.junit.Ignore;
import org.junit.Test;

public class ImageUploadParseTest {
	
	
	@Test
	@Ignore
	public void producesTheExpectedJson() throws Exception {
		File testImg = new File("src/test/resources/sushi.JPG");
		InputStream inputStream = new FileInputStream(testImg);
		
		System.out.println(asJson(inputStream));
	}

}
