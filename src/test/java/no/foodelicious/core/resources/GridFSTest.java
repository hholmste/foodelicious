package no.foodelicious.core.resources;

import java.io.File;
import java.util.List;

import no.foodelicious.core.configuration.MongoConfiguration;
import no.foodelicious.core.factory.RepositoryFactory;

import org.bson.types.ObjectId;
import org.fest.assertions.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

/**
 * Test made to explore the GridFS api. Requires a running mongodatabase at 127.0.0.1:27017
 */
public class GridFSTest {
//	private static final Logger LOG = LoggerFactory.getLogger(GridFSTest.class);
	GridFS gridFs = new RepositoryFactory().createGridFS(new MongoConfiguration("127.0.0.1", 27017, "databaseName"));

	@Test
	@Ignore
	public void testInsertAndRemove() throws Exception {
		File testImg = new File("src/test/resources/test.png");

		GridFSInputFile inputFile = gridFs.createFile(testImg);
		inputFile.save();
//		LOG.debug(String.format("Inserted file [id=%s]", inputFile.getId()));
//		DBCursor fileList = gridFs.getFileList();
//		for (DBObject dbObject : fileList) {
//			LOG.debug(String.format("File [dbObject=%s]", dbObject.toString()));
//		}
		List<GridFSDBFile> afterInsert = gridFs.find(inputFile);
		Assertions.assertThat(afterInsert).isNotEmpty();

		gridFs.remove(new ObjectId(inputFile.getId().toString()));
		List<GridFSDBFile> afterRemove = gridFs.find(inputFile);
		Assertions.assertThat(afterRemove).isEmpty();
	}
}
