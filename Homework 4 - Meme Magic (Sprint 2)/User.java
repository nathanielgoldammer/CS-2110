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

    //OVERLOADED CONSTRUCTOR 
    public User(String userName)
    {
        this.userName = userName;
        memesCreated = new ArrayList<>();
        memesViewed = new ArrayList<>();
    }

    //SETTER AND GETTER METHODS
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getUserName()
    {
        return this.userName;
    }
    public void setMemesCreated(ArrayList<Meme> memesCreated)
    {
        this.memesCreated = memesCreated;
    }
    public ArrayList<Meme> getMemesCreated()
    {
        return this.memesCreated;
    }
    public void setMemesViewed(ArrayList<Meme> memesViewed)
    {
        this.memesViewed = memesViewed;
    }
    public ArrayList<Meme> getMemesViewed()
    {
        return this.memesViewed;
    }

    /**
     * This method accepts a Meme argument and an int for rating score. 
     * It will record that Meme as having been seen by this user (memesViewed) 
     * and give it a Rating of this score.
     * @param object
     * @param rating
     */
    public void rateMeme(Meme object, int score)
    {
        this.memesViewed.add(object);
        Rating rating = new Rating(this, score);
        object.addRating(rating);
    }
    /**
     * Creates a new Meme object using the supplied arguments 
     * (String is the caption) and with the current user set as the creator. 
     * This method will add the resulting Meme to the list of createdMemes for the current user.
     * @param object
     * @param caption
     * @return
     */
    public Meme createMeme(BackgroundImage object, String caption)
    {
        Meme meme = new Meme(object, caption, this);
        this.memesCreated.add(meme);
        return meme;
    }
    /**
     * Deletes this Meme if found in the memesCreated field for the current user, 
     * only if the shared field is false. (Because anything shared on the Internet lives forever.) 
     * If the deletion was successful, return true. Otherwise, return false.
     * @param object
     * @return a boolean indicating whether or not the operation was successful
     */
    public boolean deleteMeme(Meme object)
    {
        for(int i = 0; i < this.memesCreated.size(); i++)
        {
            if(object.equals(this.memesCreated.get(i)))
            {
                if(object.getShared() == false)
                {
                    this.memesCreated.remove(i);
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        return false;
    }
    /**
     * Marks that Meme as shared(sets the shared field to true) and copies it to the 
     * ArrayList<Meme> data structure on the supplied Feed.
     * @param object1
     * @param object2
     */
    public void shareMeme(Meme object1, Feed object2)
    {
        object1.setShared(true);
        ArrayList<Meme> memes = new ArrayList<>();
        memes = object2.getMemes();
        memes.add(object1);
        object2.setMemes(memes);
    }
    /**
     * This method accepts a feed argument and an int for rating score and returns 
     * a boolean. The method will get a Meme from the Feed (supplied as an argument) 
     * using the getNewMeme(User) method of the Feed class. It will record that Meme 
     * as having been viewed by the user, give it the rating score, and return true. 
     * If there are no Memes left to view, the method should return false 
     * (and should not throw an error).
     * @param object
     * @param score
     * @return
     */
    public boolean rateNextMemeFromFeed(Feed object, int score)
    {
        if(object.getNewMeme(this) != null)
        {
            Meme meme = object.getNewMeme(this);
            this.memesViewed.add(meme);
            Rating rating = new Rating();
            rating.setScore(score);
            meme.addRating(rating);
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * Returns a value calculated as the average of all overall ratings 
     * (caclulateOverallRating()) for Memes created by this User. 
     * If the user has not created any Memes or had any Memes rated, 0.0 should be returned.
     * @return
     */
    public double calculateReputation()
    {
        double reputation = 0.0;
        Meme meme;
        if(!(this.memesCreated.isEmpty()))
        {
            for(int i = 0; i < this.memesCreated.size(); i++)
            {
                meme = this.memesCreated.get(i);
                reputation = reputation + meme.calculateOverallRating();
            }
            return reputation;
        }
        else
        {
            return reputation;
        }
    }
    @Override
    public String toString()
    {   
        double reputation = Math.round(this.calculateReputation() * 10.0) / 10.0;
        return this.userName + " has rated (" + memesViewed.size() + ") memes, (" + reputation + ")";
    }
    @Override
    public boolean equals(Object object)
    {
        if(object instanceof User)
        {
            User newObject = (User) object;
            if(this.userName == newObject.userName)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    public static void main(String[] args)
    {
        //Overloaded Constructor Test 1 - Expected Output: "Username 1"
        User user1 = new User("\nUsername 1");
        System.out.println(user1.getUserName());

        //Overloaded Constructor Test 2 - Expected Output: "Username 2"
        User user2 = new User("Username 2\n");
        System.out.println(user2.getUserName());

        //toString Test 1 - Expected Output: "Username 1 has rated (0) memes, (0.0)"
        System.out.println(user1.toString());

        //equals Test 1 - Expected Output: "False"
        if(user1.equals(user2))
        {
            System.out.println("\nTrue");
        }
        else
        {
            System.out.println("\nFalse");
        }
        //equals Test 1 - Expected Output: "True"
        user2 = user1;
        if(user1.equals(user2))
        {
            System.out.println("True\n");
        }
        else
        {
            System.out.println("False\n");
        }

        //rateMeme Test 1 - Expected Output: "1, 0"
        Meme meme1 = new Meme();
        user1.rateMeme(meme1, 0);
        Rating[] rating1 = meme1.getRatings();

        System.out.println(user1.memesViewed.size() + ", " + rating1[0].getScore());
        //rateMeme Test 2 - Expected Output: "2, 1"
        Meme meme2 = new Meme();
        user1.rateMeme(meme2, 1);
        Rating[] rating2 = meme2.getRatings();
        System.out.println(user2.memesViewed.size() + ", " + rating2[0].getScore());

        //rateNextMemeFromFeed Test 1 - Expected Output: "False"
        Feed feed = new Feed();
        ArrayList<Meme> memes = new ArrayList<>();
        memes.add(meme1);
        memes.add(meme2);
        feed.setMemes(memes);
        if(user1.rateNextMemeFromFeed(feed, 0))
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("\nFalse");
        }

        //rateNextMemeFromFeed Test 2 - Expected Output: "True"
        Meme meme3 = new Meme();
        memes.add(meme3);
        feed.setMemes(memes);
        if(user1.rateNextMemeFromFeed(feed, 0))
        {
            System.out.println("True\n");
        }
        else
        {
            System.out.println("False");
        }

        //createMeme Test 1 - Expected Output: "1"
        BackgroundImage backgroundImage1 = new BackgroundImage(); 
        String caption1 = "Caption 1";
        Meme meme4 =  user1.createMeme(backgroundImage1, caption1);
        System.out.println(user1.memesCreated.size());

        //createMeme Test 2 - Expected Output: "2"
        BackgroundImage backgroundImage2 = new BackgroundImage(); 
        String caption2 = "Caption 2";
        Meme meme5 = user1.createMeme(backgroundImage2, caption2);
        System.out.println(user1.memesCreated.size());

        //deleteMeme Test 1 - Expected Output: "The meme has been deleted"
        if(user1.deleteMeme(meme4))
        {
            System.out.println("\nThe meme has been deleted");
        }
        else
        {
            System.out.println("The meme has not been deleted");
        }

        //deleteMeme Test 2 and shareMeme Test 1 - Expected Output: "The meme has not been deleted"
        user1.shareMeme(meme4, feed);
        if(user1.deleteMeme(meme4))
        {
            System.out.println("\nThe meme has been deleted");
        }
        else
        {
            System.out.println("The meme has not been deleted\n");
        }

        //shareMeme Test 2 - Expected Output: "meme4 is shared"
        if(meme4.getShared())
        {
            System.out.println("meme4 is shared");
        }
        else
        {
            System.out.println("meme4 is not shared");
        }





    }
}