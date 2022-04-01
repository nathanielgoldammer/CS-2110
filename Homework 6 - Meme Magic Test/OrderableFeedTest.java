import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
public class OrderableFeedTest {

	@Test
	public void sortByCaptionTest() 
	{
		//Input
		OrderableFeed inputOrderableFeed = new OrderableFeed();
        BackgroundImage backgroundImage1 = new BackgroundImage("A", "B", "C");
        BackgroundImage backgroundImage2 = new BackgroundImage("A", "B", "C");
        User creator1 = new User("Username");
        User creator2 = new User("Username");
        Meme meme1 = new Meme(backgroundImage1, "Caption", creator1);
        Meme meme2 = new Meme(backgroundImage2, "Caption", creator2);
        inputOrderableFeed.getMemes().add(meme2);
        inputOrderableFeed.getMemes().add(meme1);
        inputOrderableFeed.sortByCaption();
        //Expected 
        boolean expectedBoolean = true;
        //Actual
        boolean actualBoolean = ((inputOrderableFeed.getMemes().get(0).equals(meme2)) && (inputOrderableFeed.getMemes().get(1).equals(meme1)));
        Assert.assertEquals(expectedBoolean, actualBoolean);
	}
	@Test
	public void sortByRatingTest()
	{
		//Input
		OrderableFeed inputOrderableFeed = new OrderableFeed();
		BackgroundImage backgroundImage1 = new BackgroundImage("A", "B", "C");
		BackgroundImage backgroundImage2 = new BackgroundImage("A", "B", "C");
		User creator1 = new User("Username");
		User creator2 = new User("Username");
		Meme meme1 = new Meme(backgroundImage1, "Caption", creator1);
		Meme meme2 = new Meme(backgroundImage2, "Caption", creator2);
		inputOrderableFeed.getMemes().add(meme2);
		inputOrderableFeed.getMemes().add(meme1);
		inputOrderableFeed.sortByRating();
		//Expected 
        boolean expectedBoolean = true;
        //Actual
        boolean actualBoolean = ((inputOrderableFeed.getMemes().get(0).equals(meme2)) && (inputOrderableFeed.getMemes().get(1).equals(meme1)));
        Assert.assertEquals(expectedBoolean, actualBoolean);
	}
	@Test
	public void sortByCreatorTest()
	{
		//Input
		OrderableFeed inputOrderableFeed = new OrderableFeed();
		BackgroundImage backgroundImage1 = new BackgroundImage("A", "B", "C");
		BackgroundImage backgroundImage2 = new BackgroundImage("A", "B", "C");
		User creator1 = new User("Username");
		User creator2 = new User("Username");
		Meme meme1 = new Meme(backgroundImage1, "Caption", creator1);
		Meme meme2 = new Meme(backgroundImage2, "Caption", creator2);
		inputOrderableFeed.getMemes().add(meme2);
		inputOrderableFeed.getMemes().add(meme1);
		inputOrderableFeed.sortByCreator();
		//Expected 
        boolean expectedBoolean = true;
        //Actual
        boolean actualBoolean = ((inputOrderableFeed.getMemes().get(0).equals(meme2)) && (inputOrderableFeed.getMemes().get(1).equals(meme1)));
        Assert.assertEquals(expectedBoolean, actualBoolean);
	}

}
