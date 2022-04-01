import java.util.*;
import java.util.ArrayList;
public class Meme implements Comparable<Meme>
{
   //Instance Fields
   private User creator; 
   private BackgroundImage backgroundImage;
   private Rating[] ratings;
   private String caption;
   private String captionVerticalAlign;
   private boolean shared;
   //Default Constructor
   public Meme()
   {
      this.creator = new User();
      this.backgroundImage = new BackgroundImage();
      this.ratings = new Rating[10];
      this.caption = "No caption Yet";
      this.captionVerticalAlign = "bottom";
      this.shared = false; //Default Value 
   }
   //Overloaded Constructor
   public Meme(BackgroundImage backgroundImage, String caption, User creator)
   {
      this.backgroundImage = backgroundImage;
      this.caption = caption;
      this.creator = creator;
      this.ratings = new Rating[10];
      this.captionVerticalAlign = "bottom";
      this.shared = false; //Default Value
   }
   //creator Setter and Getter Methods
   public void setCreator(User creator)
   {
      this.creator = creator;
   }
   public User getCreator()
   {
      return this.creator;
   }
   //backgroundImage Setter and Getter Methods
   public void setBackgroundImage(BackgroundImage backgroundImage)
   {
      this.backgroundImage = backgroundImage;
   }
   public BackgroundImage getBackgroundImage()
   {
     return this.backgroundImage;
   }
   //ratings Setter and Getter Methods
   public void setRatings(Rating[] ratings)
   {
      this.ratings = ratings;
   }
   public Rating[] getRatings()
   {
      return this.ratings;
   }
   //caption Setter and Getter Methods
   public void setCaption(String caption)
   {
      this.caption = caption;
   }
   public String getCaption()
   {
      return this.caption;
   }
   //captionVerticalAlign Setter and Getter Methods
   public boolean setCaptionVerticalAlign(String captionVerticalAlign)
   {
      if((captionVerticalAlign.equalsIgnoreCase("top")) || (captionVerticalAlign.equalsIgnoreCase("middle")) || (captionVerticalAlign.equalsIgnoreCase("bottom")))
      {
         this.captionVerticalAlign = captionVerticalAlign;
         return true;
      }
      else
      {
         return false;
      }
   }
   public String getCaptionVerticalAlign()
   {
      return this.captionVerticalAlign;
   }
   //shared Setter and Getter Methods
   public void setShared(boolean shared)
   {
      this.shared = shared;
   }
   public boolean getShared()
   {
      return shared;
   }
   /**
    * Returns a String representation of the calling object
    *
    *@return the String "backgroundImage 'caption' overallRating [+1: the number of +1 ratings, -1: the number of -1 ratings]"
    */
   @Override
   public String toString()
   {
      return this.backgroundImage.toString() + " \'" + this.caption + "\' " + this.calculateOverallRating() + " [+1: " + this.getNumberOfRatings(1) + ", -1: " + this.getNumberOfRatings(-1) + "]" + " - created by " + this.creator.getUserName();
   }
   /** Private Method to Help toString */
   private int getNumberOfRatings(int one)
   {
      //Accumulator Variable to be Returned that Counts the Number of +1 and -1 Ratings
      int accumulator = 0;
      if(one == 1)
      {
         for(int i = 0; i < this.ratings.length; i++)
         {
            if((this.ratings[i] != null) && (this.ratings[i].getScore() == 1))
            {
               accumulator++;
            }
         }
         return accumulator;
      }
      else if(one == -1)
      {
         for(int i = 0; i < this.ratings.length; i++)
         {
            if((this.ratings[i] != null) && (this.ratings[i].getScore() == -1))
            {
               accumulator++;
            }
         }
         return accumulator;
      }
      else
      {
         return 0;
      }
   }
   /**
    * Checks whether or not the two objects (the caller and the parameter) are the same by comparing their class, creator, caption, and backgroundImage
    *
    * @return true if the two objects are the same and false is otherwise
    */
   @Override
   public boolean equals(Object object)
   {
      if((object != null) && (this.getClass() == object.getClass()))
      {
         //Type Cast object Parameter so that Meme Instance Variables can be Directly Referenced in a Boolean Expression
         Meme newObject = (Meme) object;
         return ((this.creator == newObject.creator) && (this.caption == newObject.caption) && (this.backgroundImage == newObject.backgroundImage));
      }
      else
      {
         return false;
      }
   }
   /**
    * Sums the scores of each element in the calling Meme object's ratings array. 
    * If the calling Meme has no scores, a double value of 0.0 will be returned.
    *
    * @return A double value that is the sum of all Rating scores for the calling Meme object 
    */
   public double calculateOverallRating()
   {
      double sum = 0.0;
      for(int i = 0; i < ratings.length; i++)
      {
         if(this.ratings[i] != null)
         {
            sum = sum + ratings[i].getScore();
         }
      }
      return sum;
   }
   /**
    * Adds the Rating object to the calling Meme's array of ratings. 
    * Returns true if successful and false if otherwise. 
    * If the array is full, it will shift all ratings one position up 
    * and insert the new one at the last position in the array. 
    * It will discard the original first element.
    *
    * @param object
    * @return a boolean value that indicates whether or not the operation was successful
    */
   public boolean addRating(Rating object)
   {
      for(int i = 0; i < ratings.length; i++)
      {
         //Adds Rating object to the First Null Index of ratings Array
         if(ratings[i] == null)
         {
            ratings[i] = object;
            return true;
         }
         else if(ratings[9] != null)
         {
            //Shift Each Element in ratings Array One Position Down
            for(int j = 0; j < ratings.length - 1; j++) 
            {
               ratings[j] = ratings[j + 1];
               if(j + 1 == 9)
               {
                  ratings[j + 1] = object;
                  return true;
               }
            }
         }
      }
      return false;
   }
   /**
    * Orders Meme objects as follows: 
    * First, by caption (ascending)
    * Then, if the objects' captions are identical, by BackgroundImage (using BackgroundImage's natural ordering)
    * Then, if the objects' BackgroundImages are identical, by overall rating (descending)
    * Lastly, if the objects' overall ratings are identical, shared memes should come first
    *
    * @param object
    * @return A negative int value if the caller should come before the parameter, zero if the caller and parameter are the same, and a positive int value if the parameter should come before the caller
    */
   @Override
   public int compareTo(Meme object)
   {
      //Check if the objects' captions are the same
      if(this.caption.compareTo(object.caption) != 0)
      {
         return this.caption.compareTo(object.caption);
      }
      //Check if the objects' backgroundImages are the same
      else if(this.backgroundImage.compareTo(object.backgroundImage) != 0)
      {
         return this.backgroundImage.compareTo(object.backgroundImage);
      }
      //Check if the objects' overall ratings are the same
      else if(this.calculateOverallRating() - object.calculateOverallRating() != 0.0)
      {
         //Check if the calling object has a higher overall rating
         if(this.calculateOverallRating() > object.calculateOverallRating())
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
      //Check if the objects have been shared
      else if(this.getShared() != object.getShared())
      {
         //Check if the calling object has been shared
         if(this.getShared())
         {
            //Return a negative int to indicate that the calling object should come before the parameter
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
   public static void main(String[] args)
   {
      //compareTo Test 1 - Expected Output: "meme1 and meme2 are the same"
      BackgroundImage backgroundImage1 = new BackgroundImage("A", "B", "C");
      BackgroundImage backgroundImage2 = new BackgroundImage("A", "B", "C");
      User creator1 = new User();
      User creator2 = new User();
      Meme meme1 = new Meme(backgroundImage1, "Caption", creator1);
      Meme meme2 = new Meme(backgroundImage2, "Caption", creator2);
      if(meme1.compareTo(meme2) == 0)
      {
         System.out.println("\nmeme1 and meme2 are the same");
      }

      //compareTo Test 2 - Expected Output: "meme1 before meme2 by shared"
      meme1.setShared(true);
      if((meme1.compareTo(meme2) < 0) && (meme2.compareTo(meme1) > 0))
      {
         System.out.println("meme1 before meme2 by shared");
      }

      //compareTo Test 3 - Expected Output: "meme1 before meme2 by overall rating"
      User user1 = new User();
      User user2 = new User();
      for(int i = 0; i < meme1.ratings.length; i++)
      {
         meme1.ratings[i] = new Rating(user1, 1);
      }
      for(int i = 0; i < meme2.ratings.length - 5; i++)
      {
         meme2.ratings[i] = new Rating(user2, 1);
      }
      if((meme1.compareTo(meme2) < 0) && (meme2.compareTo(meme1) > 0))
      {
         System.out.println("meme1 before meme2 by overall rating");
      }

      //compareTo Test 4 - Expected Output: "meme1 before meme2 by backgroundImage"
      backgroundImage2.setImageFileName("a");
      if((meme1.compareTo(meme2) < 0) && (meme2.compareTo(meme1) > 0))
      {
         System.out.println("meme1 before meme2 by backgroundImage");
      }

      //compareTo Test 5 - Expected Output: "meme1 before meme2 by caption"
      meme2.setCaption("caption");
      if((meme1.compareTo(meme2) < 0) && (meme2.compareTo(meme1) > 0))
      {
         System.out.println("meme1 before meme2 by caption");
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