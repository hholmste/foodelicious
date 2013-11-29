package no.foodelicious.core.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.ws.rs.core.MediaType;

import no.foodelicious.core.configuration.MongoConfiguration;
import no.foodelicious.core.factory.RepositoryFactory;

import org.junit.Test;

import com.yammer.dropwizard.testing.ResourceTest;

public class ImageUploadResourceTest extends ResourceTest{

	@Override
	protected void setUpResources() throws Exception {
		addResource(new ImageUploadResource(new RepositoryFactory().createGridFS(new MongoConfiguration())));
	}
	
	@Test
	public void testImageUploadResource() throws Exception{
		
		File testImg = new File("src/test/resources/sushi.JPG");
		InputStream inputStream = new FileInputStream(testImg);
		
		client().resource("/imageupload").type(MediaType.MULTIPART_FORM_DATA).post(InputStream.class,inputStream);
	}
}