import java.util.*;
public class OrderableFeed extends Feed 
{
    //Default Constructor
    public OrderableFeed()
    {
        super();
    }
    /**
     * Reorders the calling orderableFeed's list of memes by caption, using Meme's natural ordering
     */
    public void sortByCaption()
    {
        Collections.sort(this.getMemes());
    }
    /**
     * Reorders the calling orderableFeed's list of memes by rating, using the CompareMemeByRating comparator
     */
    public void sortByRating()
    {
        Collections.sort(this.getMemes(), new CompareMemeByRating());
    }
    /**
     * Reorders the calling orderableFeed's list of memes by creator, using the CompareMemeByCreator comparator
     */
    public void sortByCreator()
    {
        Collections.sort(this.getMemes(), new CompareMemeByCreator());
    }
    /**
    public static void main(String[] args)
    {
        OrderableFeed orderableFeed = new OrderableFeed();

        BackgroundImage backgroundImage1 = new BackgroundImage("A", "B", "C");
        BackgroundImage backgroundImage2 = new BackgroundImage("A", "B", "C");

        User creator1 = new User("Username");
        User creator2 = new User("Username");

        Meme meme1 = new Meme(backgroundImage1, "Caption", creator1);
        Meme meme2 = new Meme(backgroundImage2, "Caption", creator2);

        orderableFeed.getMemes().add(meme2);
        orderableFeed.getMemes().add(meme1);

        //sortByCaption Test 1 - Expected Output: "orderableFeed has not been sorted by caption because it's element's captions are identical"
        orderableFeed.sortByCaption();
        if((orderableFeed.getMemes().get(0).equals(meme2)) && (orderableFeed.getMemes().get(1).equals(meme1)))
        {
            System.out.println("\norderableFeed has not been sorted by caption because it's element's captions are identical");
        }

        //sortByRating Test 1 - Expected Output: "orderableFeed has not been sorted by rating because it's element's ratings are identical"
        orderableFeed.sortByRating();
        if((orderableFeed.getMemes().get(0).equals(meme2)) && (orderableFeed.getMemes().get(1).equals(meme1)))
        {
            System.out.println("orderableFeed has not been sorted by rating because it's element's ratings are identical");
        }

        //sortByCreator Test 1 - Expected Output: "orderableFeed has not been sorted by creator because it's element's creators are identical"
        orderableFeed.sortByCreator();
        if((orderableFeed.getMemes().get(0).equals(meme2)) && (orderableFeed.getMemes().get(1).equals(meme1)))
        {
            System.out.println("orderableFeed has not been sorted by creator because it's element's creators are identical");
        }

        //sortByCaption Test 2 - Expected Output: "orderableFeed sorted by caption"
        meme2.setCaption("caption");
        orderableFeed.sortByCaption();
        if((orderableFeed.getMemes().get(0).equals(meme1)) && (orderableFeed.getMemes().get(1).equals(meme2)))
        {
            System.out.println("orderableFeed sorted by caption");
        }

        //sortByRating Test 2 - Expected Output: "orderableFeed sorted by rating"
        User user = new User();
        Rating rating = new Rating(user, 1);
        for(int i = 0; i < meme2.getRatings().length; i++)
        {
            meme2.addRating(rating);
        }
        for(int i = 0; i < 5; i++)
        {
            meme1.addRating(rating);
        }
        orderableFeed.sortByRating();
        if((orderableFeed.getMemes().get(0).equals(meme2)) && (orderableFeed.getMemes().get(1).equals(meme1)))
        {
            System.out.println("orderableFeed sorted by rating");
        }

        //sortByCreator Test 2 - Expected Output: "orderableFeed sorted by creator"
        creator2.setUserName("username");
        orderableFeed.sortByCreator();
        if((orderableFeed.getMemes().get(0).equals(meme1)) && (orderableFeed.getMemes().get(1).equals(meme2)))
        {
            System.out.println("orderableFeed sorted by creator");
        }
    }
    */
}