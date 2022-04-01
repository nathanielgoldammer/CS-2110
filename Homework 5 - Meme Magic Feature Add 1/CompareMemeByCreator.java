import java.util.Comparator;
import java.util.*;
import java.util.ArrayList;
public class CompareMemeByCreator implements Comparator<Meme>
{
    /**
     * Compares meme1 and meme2 and then orders them as follows:
     * First, by creator (using User's natural ordering)
     * Then, if the memes' creators are identical, by overall rating (descending)
     * Then, if the memes' overall ratings are identical, by caption (ascending)
     * Then, if the memes' captions are identical, by BackgroundImage (using BackgroundImage's natural ordering)
     * Lastly, if the memes' BackgroundImages are identical, shared memes should come first
     * 
     * @param meme1 the first meme object to be compared
     * @param meme2 the second meme object to be compared
     * 
     * @return A negative int value if meme1 should come before meme2, zero if meme1 and meme2 are the same, and a positive int value if meme2 should come before meme1
     * 
     */
    @Override
    public int compare(Meme meme1, Meme meme2)
    {
        //Check if meme1 and meme2 have the same creator
        if(meme1.getCreator().compareTo(meme2.getCreator()) != 0)
        {
            return meme1.getCreator().compareTo(meme2.getCreator());
        }
        //Check if meme1 and meme2 have the same overall rating
        else if(meme1.calculateOverallRating() - meme2.calculateOverallRating() != 0)
        {
            //Check if meme1 has a higher overall rating than meme2
            if(meme1.calculateOverallRating() > meme2.calculateOverallRating())
            {
                //Return negative int to indicate that meme1 should come before meme2
                return -1; 
            }
            else
            {
                //Return positive int to indicate that meme2 should come before meme1
                return 1; 
            }
        }
        //Check if meme1 and meme2 have the same caption
        else if(meme1.getCaption().compareTo(meme2.getCaption()) != 0)
        { 
            return meme1.getCaption().compareTo(meme2.getCaption());
        }
        //Check if meme1 and meme2 have the same BackgroundImage
        else if(meme1.getBackgroundImage().compareTo(meme2.getBackgroundImage()) != 0)
        {
            return meme1.getBackgroundImage().compareTo(meme2.getBackgroundImage());
        }
        //Check if meme1 and meme2 are both shared
        else if(meme1.getShared() != meme2.getShared())
        {
            //Check if meme1 has been shared
            if(meme1.getShared())
            {
                //Return negative int to indicate that meme1 should come before meme2
                return -1;
            }
            else
            {
                //Return positive int to indicate that meme2 should come before meme1
                return 1;
            }
        }
        else
        {
            //Return 0 to indicate that meme1 and meme2 are the same
            return 0; 
        }
    }
    public static void main(String[] args)
    {
        CompareMemeByCreator comparator = new CompareMemeByCreator();
        //compare Test 1 - Expected Output: "meme1 and meme2 are the same"
        User creator1 = new User("Username");
        User creator2 = new User("Username");
        BackgroundImage backgroundImage1 = new BackgroundImage("A", "B", "C");
        BackgroundImage backgroundImage2 = new BackgroundImage("A", "B", "C");
        Meme meme1 = new Meme(backgroundImage1, "Caption", creator1);
        Meme meme2 = new Meme(backgroundImage2, "Caption", creator2);
        if(comparator.compare(meme1, meme2) == 0)
        {
            System.out.println("\nmeme1 and meme2 are the same");
        }

        //compare Test 2 - Expected Output: "meme1 before meme2 by shared"
        meme1.setShared(true);
        if((comparator.compare(meme1, meme2) < 0) && (comparator.compare(meme2, meme1) > 0))
        {
            System.out.println("meme1 before meme2 by shared");
        }

        //compare Test 3 - Expected Output: "meme1 before meme2 by BackgroundImage"
        backgroundImage2.setImageFileName("a");
        if((comparator.compare(meme1, meme2) < 0) && (comparator.compare(meme2, meme1) > 0))
        {
            System.out.println("meme1 before meme2 by BackgroundImage");
        }

        //compareTo Test 3 - Expected Output: "meme1 before meme2 by caption"
        meme2.setCaption("caption");
        if((comparator.compare(meme1, meme2) < 0) && (comparator.compare(meme2, meme1) > 0))
        {
            System.out.println("meme1 before meme2 by caption");   
        }

        //compareTo Test 4 - Expected Output: "meme1 before meme2 by overall rating"
        User user = new User();
        Rating rating = new Rating(user, 1);
        for(int i = 0; i < meme1.getRatings().length; i++)
        {
            meme1.addRating(rating);
        }
        for(int i = 0; i < 5; i++)
        {
            meme2.addRating(rating);
        }
        if((comparator.compare(meme1, meme2) < 0) && (comparator.compare(meme2, meme1) > 0))
        {
            System.out.println("meme1 before meme2 by overall rating");
        }

        //compare Test 5 - Expected Output: "meme1 before meme2 by creator"
        creator2.setUserName("username");
        if((comparator.compare(meme1, meme2) < 0) && (comparator.compare(meme2, meme1) > 0))
        {
            System.out.println("meme1 before meme2 by creator");
        }

        //compare Test 6 - Expected Output: "meme1 sorted before meme2"
        ArrayList<Meme> memes = new ArrayList<>();
        memes.add(meme2);
        memes.add(meme1);
        Collections.sort(memes);
        if((memes.get(0).equals(meme1)) && (memes.get(1).equals(meme2)))
        {
            System.out.println("meme1 sorted before meme2\n");
        }
    }
}
