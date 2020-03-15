import static org.junit.Assert.*;

import java.io.*;
import java.lang.reflect.Method;

import javax.swing.JFileChooser;

import org.junit.*;

public class EdgeConvertFileParserTest {
	private File parseFile;
	EdgeConvertFileParser ecfp;
	
	@Before
	public void setUp() throws Exception{
		parseFile = new File("src/java/Courses.edg");	//have the file path,and name
		ecfp = new EdgeConvertFileParser(parseFile); //because this run first, then br will close after.
	}
	
	@Test
	public void testParseEdgeFile() {
		try {
			ecfp.parseEdgeFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testParseSaveFile() {
		try {
			ecfp.parseSaveFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	//because the br is already close,so print out the exception: Stream close
		}
	}
	
	@Test
	public void testGetEdgeTables() {
//		ecfp.getEdgeTables();
		assertEquals("to test is there has edge table should be 3",3,ecfp.getEdgeTables().length);
	}
	
	@Test
	public void testGetEdgeFields() {
		assertEquals("to test is there has edge field should be 7",7,ecfp.getEdgeFields().length);
	} 
	
//	private method
	@Test
	public void testResolveConnectors() {
		Method rc;
		try {
			rc = ecfp.getClass().getDeclaredMethod("resolveConnectors",null);
			rc.setAccessible(true);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMakeArrays() {
		Method array;

		try {
			array = ecfp.getClass().getDeclaredMethod("makeArrays", null);
			array.setAccessible(true);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIsTableDup() {
		Method table;
		try {
			table = ecfp.getClass().getDeclaredMethod("makeArrays", null);
			System.out.println("table:"+table);
//			table.setAccessible(true);
//			assertTrue(table.setAccessible(true));
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
