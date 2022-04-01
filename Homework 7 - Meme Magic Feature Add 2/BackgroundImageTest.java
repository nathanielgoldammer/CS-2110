import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
public class BackgroundImageTest 
{

	@Test
	public void setAndGetImageFileNameTest()
	{
		//Input
		BackgroundImage backgroundImage = new BackgroundImage();
		String inputImageFileName = "Image File Name";
		backgroundImage.setImageFileName(inputImageFileName);
		//Expected
		String expectedImageFileName = inputImageFileName; 
		//Actual 
		String actualImageFileName = backgroundImage.getImageFileName();
		Assert.assertEquals(expectedImageFileName, actualImageFileName);
	}
	@Test
	public void setAndGetTitleTest()
	{
		//Input
		BackgroundImage backgroundImage = new BackgroundImage();
		String inputTitle = "Title"; 
		backgroundImage.setTitle(inputTitle);
		//Expected
		String expectedTitle = inputTitle; 
		String actualTitle = backgroundImage.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	@Test
	public void setAndGetDescriptionTest()
	{
		//Input 
		BackgroundImage backgroundImage = new BackgroundImage();
		String inputDescription = "Description";
		backgroundImage.setDescription(inputDescription);
		//Expected
		String expectedDescription = inputDescription; 
		//Actual
		String actualDescription = backgroundImage.getDescription();
		Assert.assertEquals(expectedDescription, actualDescription);
	}
	@Test
	public void equalsTest()
	{
		//Input
		BackgroundImage backgroundImage = new BackgroundImage("Image File Name", "Title", "Description"); 
		BackgroundImage inputBackgroundImage = new BackgroundImage("Image File Name", "Title", "Description"); 
		//Expected
		boolean expectedBoolean = true; 
		//Actual
		boolean actualBoolean = backgroundImage.equals(inputBackgroundImage);
		Assert.assertTrue(expectedBoolean == actualBoolean);
		
		//Input
		backgroundImage.setImageFileName("Different Image File Name");
		//Expected boolean
		expectedBoolean = false;
		//Actual boolean
		actualBoolean = backgroundImage.equals(inputBackgroundImage); 
		Assert.assertTrue(expectedBoolean == actualBoolean);
		
		//Input
		Object inputObject = new Object();
		//Expected
		expectedBoolean = false; 
		//Actual
		actualBoolean = backgroundImage.equals(inputObject); 
		Assert.assertTrue(expectedBoolean == actualBoolean);
	}
	@Test
	public void toStringTest()
	{
		
		BackgroundImage backgroundImage = new BackgroundImage(); 
		//Expected
		String expectedString = "No Title Yet <No Description Yet>";  
		//Actual
		String actualString = backgroundImage.toString(); 
		Assert.assertEquals(expectedString, actualString);
	}
	@Test
	public void compareToTest()
	{
		//Input
		BackgroundImage backgroundImage1 = new BackgroundImage("A", "B", "C");
	    BackgroundImage backgroundImage2 = new BackgroundImage("A", "B", "C");
	    //Expected
	    int expectedInt = 0; 
	    //Actual int
	    int actualInt = backgroundImage1.compareTo(backgroundImage2); 
	    Assert.assertEquals(expectedInt, actualInt);
	    
	    //Input
	    backgroundImage2.setDescription("c");
	    //Expected 
	    boolean expectedBoolean = true; 
	    //Actual
	    boolean actualBoolean = ((backgroundImage1.compareTo(backgroundImage2) < 0) && (backgroundImage2.compareTo(backgroundImage1) > 0));
	    Assert.assertTrue(expectedBoolean == actualBoolean);
	    
	    //Input
	    backgroundImage2.setTitle("b");
	    //Expected
	    expectedBoolean = true; 
	    //Actual
	    actualBoolean = ((backgroundImage1.compareTo(backgroundImage2) < 0) && (backgroundImage2.compareTo(backgroundImage1) > 0));
	    Assert.assertTrue(expectedBoolean == actualBoolean);
	    
	    //Input
	    backgroundImage2.setImageFileName("a");
	    //Expected
	    expectedBoolean = true; 
	    //Actual
	    actualBoolean = ((backgroundImage1.compareTo(backgroundImage2) < 0) && (backgroundImage2.compareTo(backgroundImage1) > 0));
	    Assert.assertTrue(expectedBoolean == actualBoolean);
	}
}
















