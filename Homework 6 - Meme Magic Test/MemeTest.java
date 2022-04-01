import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
public class MemeTest 
{

	@Test
	public void setAndGetCreatorTest() 
	{
		//Input
		Meme meme = new Meme();
		User inputCreator = new User(); 
		meme.setCreator(inputCreator);
		//Expected
		User expectedCreator = inputCreator; 
		//Actual
		User actualCreator = meme.getCreator();
		Assert.assertEquals(expectedCreator, actualCreator);
	}
	@Test 
	public void setAndGetBackgroundImageTest()
	{
		//Input
		Meme meme = new Meme();
		BackgroundImage inputBackgroundImage = new BackgroundImage(); 
		meme.setBackgroundImage(inputBackgroundImage);
		//Expected 
		BackgroundImage expectedBackgroundImage = inputBackgroundImage; 
		//Actual
		BackgroundImage actualBackgroundImage = meme.getBackgroundImage(); 
		Assert.assertEquals(expectedBackgroundImage, actualBackgroundImage);
	}
	@Test
	public void setAndGetRatingsTest()
	{
		//Input
		Meme meme = new Meme();
		Rating[] inputRatings = new Rating[10];
		meme.setRatings(inputRatings);
		//Expected
		Rating[] expectedRatings = inputRatings; 
		//Actual
		Rating[] actualRatings = meme.getRatings(); 
		Assert.assertArrayEquals(expectedRatings, actualRatings);
	}
	@Test
	public void setAndGetCaptionTest()
	{
		//Input
		Meme meme = new Meme();
		String inputCaption = "Caption"; 
		meme.setCaption(inputCaption);
		//Expected
		String expectedCaption = inputCaption; 
		//Actual
		String actualCaption = meme.getCaption(); 
		Assert.assertEquals(expectedCaption, actualCaption);
		
	}
	@Test
	public void setAndGetCaptionVerticalAlignTest()
	{
		//Input
		Meme meme = new Meme();
		String inputCaptionVerticalAlign = "bottom"; 
		meme.setCaptionVerticalAlign(inputCaptionVerticalAlign);
		//Expected
		String expectedCaptionVerticalAlign = inputCaptionVerticalAlign;
		//Actual
		String actualCaptionVerticalAlign = meme.getCaptionVerticalAlign();
		Assert.assertEquals(expectedCaptionVerticalAlign, actualCaptionVerticalAlign);
		
		//Input
		inputCaptionVerticalAlign = "not bottom middle or top"; 
		//Expected
		boolean expectedBoolean = false;
		//Actual
		boolean actualBoolean = meme.setCaptionVerticalAlign(inputCaptionVerticalAlign); 
		Assert.assertTrue(expectedBoolean == actualBoolean);
	}
	@Test
	public void setAndGetSharedTest()
	{
		//Input
		Meme meme = new Meme();
		boolean inputShared = true;
		meme.setShared(inputShared);
		//Expected
		boolean expectedShared = inputShared;
		//Actual
		boolean actualShared = meme.getShared(); 
		Assert.assertTrue(expectedShared == actualShared);
	}
	@Test
	public void toStringTest()
	{
		
		Meme meme = new Meme();
		//Expected
		String expectedString = "No Title Yet <No Description Yet> 'No caption Yet' 0.0 [+1: 0, -1: 0] - created by No Username Yet"; 
		//Actual
		String actualString = meme.toString(); //Actual String
		Assert.assertEquals(expectedString, actualString);
		
		Rating rating1 = new Rating();
		rating1.setScore(-1);
		meme.addRating(rating1);
		
		//Input
		Rating rating2 = new Rating();
		rating2.setScore(1);
		meme.addRating(rating2);
		Rating rating3 = new Rating();
		rating3.setScore(-1);
		meme.addRating(rating3);
		Rating rating4 = new Rating();
		rating4.setScore(1);
		meme.addRating(rating4);
		//Expected
		expectedString = "No Title Yet <No Description Yet> 'No caption Yet' 0.0 [+1: 2, -1: 2] - created by No Username Yet"; 
		//Actual
		actualString = meme.toString();
		Assert.assertEquals(expectedString, actualString);
	}
	@Test
	public void equalsTest()
	{
		//Input
		Meme meme = new Meme();
		Meme inputMeme = new Meme();
		//Expected
		boolean expectedBoolean = true; 
		//Actual
		boolean actualBoolean = meme.equals(inputMeme); 
		Assert.assertTrue(expectedBoolean == actualBoolean);
		
		//Input
		inputMeme.setCaption("Different Caption");
		//Expected
		expectedBoolean = false; 
		//Actual
		actualBoolean = meme.equals(inputMeme); 
		Assert.assertTrue(expectedBoolean == actualBoolean);
		
		//Input
		Object inputObject = new Object(); 
		//Expected
		expectedBoolean = false; 
		//Actual
		actualBoolean = meme.equals(inputObject);
		Assert.assertTrue(expectedBoolean == actualBoolean);
	}
	@Test
	public void calculateOverallRatingTest()
	{
		//Input
		Meme meme = new Meme();
		Rating inputRating1 = new Rating(); 
		inputRating1.setScore(-1);
		meme.addRating(inputRating1);
		Rating inputRating2 = new Rating(); 
		inputRating2.setScore(1);
		meme.addRating(inputRating2);
		//Expected
		double expectedOverallRating = 0.0; 
		//Actual
		double actualOverallRating = meme.calculateOverallRating();
		Assert.assertTrue(expectedOverallRating == actualOverallRating);	
	}
	@Test 
	public void addRatingTest()
	{
		//Input
		Meme meme = new Meme();
		int inputRatingsLength = 10;
		for(int i = 0; i < inputRatingsLength + 1; i++)
		{
			meme.addRating(new Rating(new User(), 1));
		}
		//Expected 
		int expectedRatingsLength = inputRatingsLength; 
		//Actual
		int actualRatingsLength = meme.getRatings().length; 
		Assert.assertTrue(expectedRatingsLength == actualRatingsLength);
		
		//Input
		Rating[] inputRatings = new Rating[0];
		meme.setRatings(inputRatings);
		//Expected
		boolean expectedBoolean = false; 
		//Actual 
		boolean actualBoolean = meme.addRating(new Rating(new User(), 1));
		Assert.assertTrue(expectedBoolean == actualBoolean);
	}
	@Test
	public void compareToTest()
	{
		//Input
		BackgroundImage backgroundImage1 = new BackgroundImage("A", "B", "C");
	    BackgroundImage backgroundImage2 = new BackgroundImage("A", "B", "C");
	    User creator1 = new User();
	    User creator2 = new User();
	    Meme meme1 = new Meme(backgroundImage1, "Caption", creator1);
	    Meme meme2 = new Meme(backgroundImage2, "Caption", creator2);
	    //Expected
	    int expectedInt = 0;
	    //Actual
	    int actualInt = meme1.compareTo(meme2);
	    Assert.assertEquals(expectedInt, actualInt);
	    
	    //Input
	    meme1.setShared(true);
	    //Expected 
	    boolean expectedBoolean = true;
	    //Actual
	    boolean actualBoolean = ((meme1.compareTo(meme2) < 0) && (meme2.compareTo(meme1) > 0));
	    Assert.assertTrue(expectedBoolean == actualBoolean);
	     
	    //Input
	    User user1 = new User();
	    User user2 = new User();
	    for(int i = 0; i < 10; i++)
	    {
	       meme1.addRating(new Rating(user1, 1));
	    }
	    for(int i = 0; i < 5; i++)
	    {
	       meme2.addRating(new Rating(user2, 1));
	    }
	    //Expected
	    expectedBoolean = true;
	    //Actual
	    actualBoolean = ((meme1.compareTo(meme2) < 0) && (meme2.compareTo(meme1) > 0));
	    Assert.assertTrue(expectedBoolean == actualBoolean);
	    
	    //Input
	    backgroundImage2.setImageFileName("a");
	    //Expected
	    expectedBoolean = true;
	    //Actual
	    actualBoolean = ((meme1.compareTo(meme2) < 0) && (meme2.compareTo(meme1) > 0));
	    Assert.assertTrue(expectedBoolean == actualBoolean);
	 
	    //Input
	    meme2.setCaption("caption");
	    //Expected
	    expectedBoolean = true;
	    //Actual
	    actualBoolean = ((meme1.compareTo(meme2) < 0) && (meme2.compareTo(meme1) > 0));
	    Assert.assertTrue(expectedBoolean == actualBoolean);
	}
}