import java.util.ArrayList;
public class User
{
    //INSTANCE FIELDS
    private String userName;
    private ArrayList<Meme> memesCreated;
    private ArrayList<Meme> memesViewed;
    //DEFAULT CONSTRUCTOR
    public User()
    {
        userName = "No Username Yet";
        memesCreated = new ArrayList<>();
        memesViewed = new ArrayList<>();
    }
    //SETTER METHODS
    public void setUserName(String aUserName)
    {
        /**
         * Assigns userName the value of the String aUserName
         */
    }
    public void setMemesCreated(int i)
    {
        /**
         * Adds a Meme object to ith index of memesCreated
         */
    }
    public void setMemesViewed(int i)
    {
        /**
         * Adds a Meme object to ith index of memesViewed 
         */
    }
    //GETTER METHODS
    public String getUserName()
    {
        /**
         * Returns the value of userName
         */
        return userName;
    }
    public Meme getMemesCreated(int i)
    {
        /**
         * Returns Meme object from ith index of memesCreated
         */
        return null;
    }
    public Meme getMemesViewd(int i)
    {
        /**
         * Returns Meme object from ith index of memesViewed
         */
        return null;
    }
    //METHODS
    public void rateMeme(Meme object, int rating)
    {
        /**
         * Accepts a Meme object and int rating
         */
    }
    public Meme createMeme(BackgroundImage object, String caption)
    {
        /**
         * Accepts a BackgroundImage object and String caption, returns a Meme object
         */
        return null;
    }
    public boolean deleteMeme(Meme object)
    {
        /**
         * Accepts a Meme object and returns a boolean value
         */
        return true;
    }
    public void shareMeme(Meme object1, Feed object2)
    {
        /**
         * Accepts a Meme object and a Feed object
         */
    }
    public void rateNextMemeFromFeed(Feed object, int ratingScore)
    {
        /**
         * Accepts a Feed object and int value ratingScore
         */
    }
    public double calculateReputation()
    {
        /**
         * Returns a double
         */
        return 0.0;
    }
    @Override
    public String toString()
    {
        /**
         * Returns a string representation of the calling object
         */
        return "";
    }
    @Override
    public boolean equals(Object object)
    {
        /**
         * Accepts an object, returns a boolean
         */
        return true;
    }
}