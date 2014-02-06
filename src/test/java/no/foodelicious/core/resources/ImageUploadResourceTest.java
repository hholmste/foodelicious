package no.foodelicious.core.resources;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.InputStream;

import javax.ws.rs.core.MediaType;

import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mongodb.MongoException;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;
import com.yammer.dropwizard.testing.ResourceTest;

@RunWith(MockitoJUnitRunner.class)
public class ImageUploadResourceTest extends ResourceTest {

	@Mock
	private GridFS mockGridFs;

	@Mock
	private GridFSInputFile mockGridFSInputFile;

	@Before
	public void setup() {
		when(mockGridFs.createFile(any(InputStream.class), anyString())).thenReturn(mockGridFSInputFile);
		when(mockGridFSInputFile.getId()).thenReturn("id");
	}

	@Override
	protected void setUpResources() throws Exception {
		addResource(new ImageResource(mockGridFs));
	}

	@Test
	public void testImageUploadResourceOk() throws Exception{
		final FormDataMultiPart multipart = createRequest();

		ClientResponse postResponse = client().resource("/image").type(MediaType.MULTIPART_FORM_DATA).post(ClientResponse.class, multipart);
		Assertions.assertThat(postResponse.getStatus()).isEqualTo(200);
	}

	@Test
	public void testImageUploadResourceFailed() throws Exception{
		final FormDataMultiPart multipart = createRequest();
		doThrow(new MongoException("foo")).when(mockGridFSInputFile).save();
		
		ClientResponse postResponse = client().resource("/image").type(MediaType.MULTIPART_FORM_DATA).post(ClientResponse.class, multipart);
		Assertions.assertThat(postResponse.getStatus()).isEqualTo(500);
	}

	private FormDataMultiPart createRequest() {
		final File testImg = new File("src/test/resources/test.png");
		final FileDataBodyPart filePart = new FileDataBodyPart("file", testImg);
		final FormDataMultiPart multipart = new FormDataMultiPart();
		multipart.bodyPart(filePart);
		return multipart;
	}
}