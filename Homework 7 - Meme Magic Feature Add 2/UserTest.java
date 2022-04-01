import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
public class UserTest 
{

	@Test
	public void setAndGetUserNameTest()
	{
		//Input
		User user = new User();
		String inputUserName = "Username";
		user.setUserName(inputUserName);
		//Expected
		String expectedUserName = inputUserName;
		//Actual
		String actualUserName = user.getUserName();
		Assert.assertEquals(expectedUserName, actualUserName);	
	}
	@Test
	public void setAndGetMemesCreatedTest()
	{
		//Input
		User user = new User();
		ArrayList<Meme> inputMemesCreated = new ArrayList<>();  
		user.setMemesCreated(inputMemesCreated);
		//Expected
		ArrayList<Meme> expectedMemesCreated = inputMemesCreated;
		//Actual
		ArrayList<Meme> actualMemesCreated = user.getMemesCreated(); 
		Assert.assertEquals(expectedMemesCreated, actualMemesCreated);
	}
	@Test
	public void setAndGetMemesViewedTest()
	{
		//Input
		User user = new User();
		ArrayList<Meme> inputMemesViewed = new ArrayList<>();
		Meme inputMeme = new Meme();
		inputMemesViewed.add(inputMeme);
		user.setMemesViewed(inputMemesViewed);
		//Expected
		ArrayList<Meme> expectedMemesViewed = inputMemesViewed;
		//Actual
		ArrayList<Meme> actualMemesViewed = user.getMemesViewed();
		Assert.assertEquals(expectedMemesViewed, actualMemesViewed);
	}
	@Test
	public void rateMemeTest()
	{
		//Input
		User user = new User();
		Meme inputMeme = new Meme(); 
		int inputScore = 0; 
		user.rateMeme(inputMeme, inputScore);
		//Expected
		Meme expectedMeme = inputMeme; 
		//Actual
		Meme actualMeme = user.getMemesViewed().get(0);
		Assert.assertEquals(expectedMeme, actualMeme);
	}
	@Test
	public void createMemeTest()
	{
		//Input
		User user = new User();
		BackgroundImage inputBackgroundImage = new BackgroundImage(); 
		String inputCaption = "Caption";
		//Expected
		Meme expectedMeme = user.createMeme(inputBackgroundImage, inputCaption); 
		//Actual
		Meme actualMeme = user.getMemesCreated().get(0); 
		Assert.assertEquals(expectedMeme, actualMeme);
	}
	@Test 
	public void deleteMemeTest()
	{
		//Input
		User user = new User();
		Meme inputMeme = new Meme();
		user.getMemesCreated().add(inputMeme);
		//Expected
		boolean expectedBoolean = true;
		//Actual
		boolean actualBoolean = user.deleteMeme(inputMeme);
		Assert.assertTrue(expectedBoolean == actualBoolean);
		
		//Input
		inputMeme.setShared(true);
		//Expected
		expectedBoolean = false; 
		//Actual
		actualBoolean = user.deleteMeme(inputMeme);
		Assert.assertTrue(expectedBoolean == actualBoolean);
		
		//Input
		Meme inputMeme2 = new Meme();
		user.getMemesCreated().add(inputMeme2);
		//Expected
		expectedBoolean = false; 
		//Actual
		actualBoolean = user.deleteMeme(inputMeme);
		Assert.assertTrue(expectedBoolean == actualBoolean);
	}
	@Test
	public void shareMemeTest()
	{
		User user = new User();
		//Input
		Meme inputMeme = new Meme();
		Feed inputFeed = new Feed();
		user.shareMeme(inputMeme, inputFeed);
		//Expected 
		boolean expectedShared = true; 
		Meme expectedMeme = inputMeme;
		//Actual 
		boolean actualShared = inputMeme.getShared();
		Meme actualMeme = inputFeed.getMemes().get(0);
		Assert.assertTrue(expectedShared == actualShared);
		Assert.assertEquals(expectedMeme, actualMeme);
	}
	@Test 
	public void rateNextMemeFromFeedTest()
	{
		User user = new User();
		//Input
		Feed inputFeed = new Feed();
		int inputScore = 0;
		//Expected
		boolean expectedBoolean = false; 
		//Actual
		boolean actualBoolean = user.rateNextMemeFromFeed(inputFeed, inputScore);
		Assert.assertTrue(expectedBoolean == actualBoolean);
		
		//Input
		Meme inputMeme = new Meme();
		inputFeed.getMemes().add(inputMeme);
		//Expected
		expectedBoolean = true; 
		//Actual
		actualBoolean = user.rateNextMemeFromFeed(inputFeed, inputScore);
		Assert.assertTrue(expectedBoolean == actualBoolean);
	}
	@Test 
	public void calculateOverallReputationTest()
	{
		User user = new User();
		//Expected 
		double expectedOverallReputation = 0.0; 
		//Actual 
		double actualOverallReputation = user.calculateReputation();
		Assert.assertTrue(expectedOverallReputation == actualOverallReputation);
		
		//Input 
		Meme inputMeme = new Meme();
		Rating inputRating = new Rating();
		inputRating.setUser(user);
		inputRating.setScore(1);
		inputMeme.addRating(inputRating);
		user.getMemesCreated().add(inputMeme);
		//Expected
		expectedOverallReputation = 1.0; 
		//Actual
		actualOverallReputation = user.calculateReputation();
		Assert.assertTrue(expectedOverallReputation == actualOverallReputation);
	}
	@Test 
	public void toStringTest()
	{
		User user = new User();
		//Expected 
		String expectedString = "No Username Yet has rated (0) memes, (0.0)";
		//Actual 
		String actualString = user.toString();
		Assert.assertEquals(expectedString, actualString);
	}
	@Test
	public void equalsTest()
	{
		
		//Input
		User user = new User("Username");
		User inputUser = new User("Username");
		//Expected
		boolean expectedBoolean = true; 
		//Actual 
		boolean actualBoolean = user.equals(inputUser);
		Assert.assertTrue(expectedBoolean == actualBoolean);
		
		//Input
		User inputUser2 = new User("Different Username");
		//Expected
		expectedBoolean = false;
		//Actual
		actualBoolean = user.equals(inputUser2);
		Assert.assertTrue(expectedBoolean == actualBoolean);	
		
		//Input 
		Object inputObject = new Object();
		//Expected
		expectedBoolean = false;
		//Actual
		actualBoolean = user.equals(inputObject);
		Assert.assertTrue(expectedBoolean == actualBoolean);
	}
	@Test
	public void compareToTest()
	{
		//Input
		User inputUser1 = new User("Username");
        User inputUser2 = new User("Username");
        //Expected
        int expectedInt = 0; 
        //Actual
        int actualInt = inputUser1.compareTo(inputUser2);
        Assert.assertTrue(expectedInt == actualInt);
        
        //Input
        BackgroundImage inputBackgroundImage1 = new BackgroundImage("A", "B", "C");
        BackgroundImage inputBackgroundImage2 = new BackgroundImage("A", "B", "C");
        for(int i = 0; i < 10; i++)
        {
        	inputUser1.createMeme(inputBackgroundImage1, "Caption");
        }
        for(int i = 0; i < 5; i++)
        {
        	inputUser2.createMeme(inputBackgroundImage2, "Caption");
        }
        //Expected 
        boolean expectedBoolean = true; 
        //Actual
        boolean actualBoolean = ((inputUser1.compareTo(inputUser2) < 0) && (inputUser2.compareTo(inputUser1) > 0));
        Assert.assertTrue(expectedBoolean == actualBoolean);
        
        //Input
        String inputUsername = "username";
        inputUser2.setUserName(inputUsername);
        //Expected
        expectedBoolean = true; 
        //Actual
        actualBoolean = ((inputUser1.compareTo(inputUser2) < 0) && (inputUser2.compareTo(inputUser1) > 0));
        Assert.assertTrue(expectedBoolean == actualBoolean);  
	}
}







