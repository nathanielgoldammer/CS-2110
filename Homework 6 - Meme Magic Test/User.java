import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
public class User implements Comparable<User>
{
    //Instance Fields
    private String userName;
    private ArrayList<Meme> memesCreated;
    private TreeSet<Meme> memesViewed;
    //Default Constructor
    public User()
    {
        userName = "No Username Yet";
        memesCreated = new ArrayList<>();
        memesViewed = new TreeSet<>();
    }
    //Overloaded Constructor
    public User(String userName)
    {
        this.userName = userName;
        memesCreated = new ArrayList<>();
        memesViewed = new TreeSet<>();
    }
    //userName Setter and Getter Methods
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getUserName()
    {
        return this.userName;
    }
    //memesCreated Setter and Getter Methods
    public void setMemesCreated(ArrayList<Meme> memesCreated)
    {
        this.memesCreated = memesCreated;
    }
    public ArrayList<Meme> getMemesCreated()
    {
        return this.memesCreated;
    }
    //memesViewed Setter and Getter Methods
    public void setMemesViewed(ArrayList<Meme> memesViewed)
    {
        for(int i = 0; i < memesViewed.size(); i++)
        {
            this.memesViewed.add(memesViewed.get(i));
        }
    }
    public ArrayList<Meme> getMemesViewed()
    {
        ArrayList<Meme> memesViewedList = new ArrayList<>();
        for(Meme meme : this.memesViewed)
        {
            memesViewedList.add(meme);
        }
        return memesViewedList;
    }
    /**
     * This method accepts a Meme argument and an int for rating score. 
     * It will record that Meme as having been seen by this user (memesViewed) 
     * and give it a Rating of this score.
     * 
     * @param object
     * @param score
     */
    public void rateMeme(Meme meme, int score)
    {
        this.memesViewed.add(meme);
        meme.addRating(new Rating(this, score));
    }
    /**
     * Creates a new Meme object using the supplied arguments 
     * (String is the caption) and with the current user set as the creator. 
     * This method will add the resulting Meme to the list of createdMemes for the current user.
     * 
     * @param object
     * @param caption
     * @return the created meme object
     */
    public Meme createMeme(BackgroundImage backgroundImage, String caption)
    {
        Meme meme = new Meme(backgroundImage, caption, this);
        this.memesCreated.add(meme);
        return meme;
    }
    /**
     * Deletes this Meme if found in the memesCreated field for the current user, 
     * only if the shared field is false. (Because anything shared on the Internet lives forever.) 
     * If the deletion was successful, return true. Otherwise, return false.
     * 
     * @param object
     * @return a boolean indicating whether or not the operation was successful
     */
    public boolean deleteMeme(Meme meme)
    {
        for(int i = 0; i < this.memesCreated.size(); i++)
        {
            if((meme.equals(this.memesCreated.get(i))) && (!(meme.getShared())))
            {
            	this.memesCreated.remove(i);
                return true;
            }
        }
        return false;
    }
    /**
     * Marks that Meme as shared(sets the shared field to true) and copies it to the 
     * ArrayList<Meme> data structure on the supplied Feed.
     * 
     * @param meme
     * @param feed
     */
    public void shareMeme(Meme meme, Feed feed)
    {
        meme.setShared(true);
        feed.getMemes().add(meme);
    }
    /**
     * This method accepts a feed argument and an int for rating score and returns 
     * a boolean. The method will get a Meme from the Feed (supplied as an argument) 
     * using the getNewMeme(User) method of the Feed class. It will record that Meme 
     * as having been viewed by the user, give it the rating score, and return true. 
     * If there are no Memes left to view, the method should return false 
     * (and should not throw an error).
     * 
     * @param object
     * @param score
     * @return
     */
    public boolean rateNextMemeFromFeed(Feed feed, int score)
    {
        if(feed.getNewMeme(this) != null)
        {
            Meme meme = feed.getNewMeme(this);
            this.memesViewed.add(meme);
            meme.addRating(new Rating(this, score));
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
     * 
     * @return a double
     */
    public double calculateReputation()
    {
        double reputation = 0.0;
        if(!(this.memesCreated.isEmpty()))
        {
            for(int i = 0; i < this.memesCreated.size(); i++)
            {
            	reputation = reputation + this.memesCreated.get(i).calculateOverallRating();
            }
            return reputation;
        }
        else
        {
            return reputation;
        }
    }
    /**
     * Returns a String representation of the calling object
     * @return "username has rated ( number of memes viewed ) memes, ( reputation )"
     * @Override
     */
    public String toString()
    {   
        double reputation = Math.round(this.calculateReputation() * 10.0) / 10.0;
        return this.userName + " has rated (" + memesViewed.size() + ") memes, (" + reputation + ")";
    }
    /**
     * Checks whether or not the two objects (the caller and the parameter) are the same by comparing their class and userName
     * 
     * @return true if the two objects are the same and false is otherwise
     * @Override
     */
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
    /**
     * Orders user objects as follows: 
     * First, by userName (ascending)
     * Then, if the objects' userNames are identical, by the number of memes created (descending)
     * 
     * @param object
     * @return A negative int value if the caller should come before the parameter, zero if the caller and parameter are the same, and a positive int value if the parameter should come before the caller
     * @Override
     */
    public int compareTo(User object)
    {
        //Check if the objects' userNames are the same
        if(this.userName.compareTo(object.userName) != 0)
        {
            return this.userName.compareTo(object.userName);
        }
        //Check if the objects have the same number of memes created
        else if(this.memesCreated.size() - object.memesCreated.size() != 0)
        {
            //Check if the calling object has created more memes
            if(this.memesCreated.size() > object.memesCreated.size())
            {
                //Return negative int to indicate that the calling object should come before the parameter
                return -1;
            }
            else
            {
                //Return a positive int to indicate that the parameter should come before the calling object
                return 1;
            }
        }
        //Return 0 if the objects are the same (have the same instance fields)
        else
        {
            return 0;
        }
    }
    /**
    public static void main(String[] args)
    {
        //compareTo Test 1 - Expected Output: "user1 and user2 are the same"
        User user1 = new User("Username");
        User user2 = new User("Username");
        if(user1.compareTo(user2) == 0)
        {
            System.out.println("\nuser1 and user2 are the same");
        }

        //compareTo Test 2 - Expected Output: "user1 before user2 by number of memes created"
        BackgroundImage backgroundImage1 = new BackgroundImage("A", "B", "C");
        BackgroundImage backgroundImage2 = new BackgroundImage("A", "B", "C");
        for(int i = 0; i < 10; i++)
        {
            user1.createMeme(backgroundImage1, "Caption");
        }
        for(int i = 0; i < 5; i++)
        {
            user2.createMeme(backgroundImage2, "Caption");
        }
        if((user1.compareTo(user2) < 0) && (user2.compareTo(user1) > 0))
        {
            System.out.println("user1 before user2 by number of memes created");
        }

        //compareTo Test 3 - Expected Output: "user1 before user2 by userName"
        user2.setUserName("username");
        if((user1.compareTo(user2) < 0) && (user2.compareTo(user1) > 0))
        {
            System.out.println("user1 before user2 by userName");
        }

        //compareTo Test 3 - Expected Output: "user1 sorted before user2"
        User[] users = new User[2];
        users[0] = user2;
        users[1] = user1;
        Arrays.sort(users);
        if((users[0].equals(user1)) && (users[1].equals(user2)))
        {
            System.out.println("user1 sorted before user2");
        }
    }
    */
}