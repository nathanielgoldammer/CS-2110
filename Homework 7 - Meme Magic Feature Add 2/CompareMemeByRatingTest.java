import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
public class CompareMemeByRatingTest 
{

	@Test
	public void compareTest() 
	{
		//Input
		CompareMemeByRating comparator = new CompareMemeByRating();
		User creator1 = new User("Username");
        User creator2 = new User("Username");
        BackgroundImage backgroundImage1 = new BackgroundImage("A", "B", "C");
        BackgroundImage backgroundImage2 = new BackgroundImage("A", "B", "C");
        Meme inputMeme1 = new Meme(backgroundImage1, "Caption", creator1);
        Meme inputMeme2 = new Meme(backgroundImage2, "Caption", creator2);
        //Expected 
        int expectedInt = 0; 
        //Actual 
        int actualInt = comparator.compare(inputMeme1, inputMeme2);
        Assert.assertEquals(expectedInt, actualInt);
        
        //Input
        String inputUsername = "username";
        creator2.setUserName(inputUsername);
        //Expected 
        boolean expectedBoolean = true; 
        //Actual
        boolean actualBoolean = ((comparator.compare(inputMeme1, inputMeme2) < 0) && (comparator.compare(inputMeme2, inputMeme1) > 0));
        Assert.assertEquals(expectedBoolean, actualBoolean);
        
        //Input
        String inputImageFileName = "a";
        backgroundImage2.setImageFileName(inputImageFileName);
        //Expected
        expectedBoolean = true; 
        //Actual
        actualBoolean = ((comparator.compare(inputMeme1, inputMeme2) < 0) && (comparator.compare(inputMeme2, inputMeme1) > 0));
        Assert.assertEquals(expectedBoolean, actualBoolean);
        
        //Input
        String inputCaption = "caption";
        inputMeme2.setCaption(inputCaption);
        //Expected
        expectedBoolean = true; 
        //Actual
        actualBoolean = ((comparator.compare(inputMeme1, inputMeme2) < 0) && (comparator.compare(inputMeme2, inputMeme1) > 0));
        Assert.assertEquals(expectedBoolean, actualBoolean);
        
        //Input
        User inputUser = new User();
        Rating inputRating = new Rating(inputUser, 1);
        for(int i = 0; i < inputMeme1.getRatings().length; i++)
        {
        	inputMeme1.addRating(inputRating);
        }
        for(int i = 0; i < 5; i++)
        {
        	inputMeme2.addRating(inputRating);
        }
        //Expected
        expectedBoolean = true; 
        //Actual
        actualBoolean = ((comparator.compare(inputMeme1, inputMeme2) < 0) && (comparator.compare(inputMeme2, inputMeme1) > 0));
        Assert.assertEquals(expectedBoolean, actualBoolean);
	}

}
