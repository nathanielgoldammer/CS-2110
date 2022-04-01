public class Meme 
{
   //INSTANCE FIELDS
   private User creator; 
   private BackgroundImage backgroundImage;
   private Rating[] ratings;
   private String caption;
   private String captionVerticalAlign;
   private boolean shared;
   //DEFAULT CONSTRUCTOR
   public Meme()
   {
      this.creator = new User();
      this.backgroundImage = new BackgroundImage();
      this.ratings = new Rating[10];
      this.caption = "No caption Yet";
      this.captionVerticalAlign = "bottom";
      this.shared = false; //Default Value 
   }
   //OVERLOADED CONSTRUCTOR
   public Meme(BackgroundImage backgroundImage, String caption, User creator)
   {
      this.backgroundImage = backgroundImage;
      this.caption = caption;
      this.creator = creator;
      this.ratings = new Rating[10];
      this.captionVerticalAlign = "bottom";
      this.shared = false; //Default Value
   }
   //SETTER AND GETTER METHODS
   public void setCreator(User creator)
   {
      this.creator = creator;
   }
   public User getCreator()
   {
      return this.creator;
   }
   public void setBackgroundImage(BackgroundImage backgroundImage)
   {
      this.backgroundImage = backgroundImage;
   }
   public BackgroundImage getBackgroundImage()
   {
     return this.backgroundImage;
   }
   public void setRatings(Rating[] ratings)
   {
      this.ratings = ratings;
   }
   public Rating[] getRatings()
   {
      return this.ratings;
   }
   public void setCaption(String caption)
   {
      this.caption = caption;
   }
   public String getCaption()
   {
      return this.caption;
   }
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
   public void setShared(boolean shared)
   {
      this.shared = shared;
   }
   public boolean getShared()
   {
      return shared;
   }

   @Override
   public String toString()
   {
      return this.backgroundImage.toString() + " \'" + this.caption + "\' " + this.calculateOverallRating() + " [+1: " + this.getNumberOfRatings(1) + ", -1: " + this.getNumberOfRatings(-1) + "]" + " - created by " + this.creator.getUserName();
   }
   /** Private Method to Help toString Method */
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
   //MAIN METHOD TESTING
   public static void main(String[] args)
   {
      //OVERLOADED CONSTRUCTOR TEST
      BackgroundImage backgroundImage1 = new BackgroundImage("Image File Name 1", "Title 1", "Description 1");
      BackgroundImage backgroundImage2 = new BackgroundImage("Image File Name 2", "Title 2", "Description 2");
      User user1 = new User();
      User user2 = new User();
      Meme meme1 = new Meme(backgroundImage1, "Caption 1", user1);
      Meme meme2 = new Meme(backgroundImage2, "Caption 2", user2);

      //toString METHOD TEST 1
      System.out.println(meme1.toString() + "\n");

      //equals METHOD TEST 1 AND 2
      if(meme1.equals(meme2)) //Test 1 (Should Return False)
      {
         System.out.println("The two objects ARE equal");
      }
      else
      {
         System.out.println("The two objects ARE NOT equal\n");
      }
      meme2 = meme1;
      if(meme1.equals(meme2)) //Test 2 (Should Return True)
      {
         System.out.println("The two objects ARE equal\n");
      }
      else
      {
         System.out.println("The two objects ARE NOT equal");
      }

      //calculateOverallRating Method Test 1 (Should Return 0.0)
      System.out.println(meme1.calculateOverallRating() + "\n");

      //addRating METHOD TESTS 1 AND 2
      Rating rating1 = new Rating(user1, 1); //Rating object for upvote
      Rating rating2 = new Rating(user1, 0); //Rating object for pass
      Rating rating3 = new Rating(user1, -1); //Rating object for downvote
      //Test 1
      for(int i = 0; i < meme1.ratings.length; i++)
      {
         if(i % 2 == 0)
         {
            meme1.addRating(rating1); //Places an upvote in Even Positions
         }
         else
         {
            meme1.addRating(rating2); //Places a pass in Odd Positions
         }
      }
      System.out.println("Ratings in meme1 BEFORE adding a new Rating");
      for(int i = 0; i < meme1.ratings.length; i++)
      {
         System.out.println(i + ") " + meme1.ratings[i]);
      }
      //Test 2
      System.out.println("Ratings in meme1 AFTER adding a new Rating");
      meme1.addRating(rating3);
      for(int i = 0; i < meme1.ratings.length; i++)
      {
         System.out.println(i + ") " + meme1.ratings[i]);
      }

      //calculateOverallRating METHOD TEST 2 (Should Return 3.0)
      System.out.println("\n" + meme1.calculateOverallRating() + "\n");

      //toString METHOD TEST 2
      System.out.println(meme1.toString() + "\n");

      //setCaptionVerticalAlign METHOD TESTS
      if(meme1.setCaptionVerticalAlign("top")) //Test 1 (Should Return True)
      {
         System.out.println("True");
      }
      else
      {
         System.out.println("False");
      }
      if(meme1.setCaptionVerticalAlign("bottom")) //Test 2 (Should Return True)
      {
         System.out.println("True");
      }
      else
      {
         System.out.println("False");
      }
      if(meme1.setCaptionVerticalAlign("middle")) //Test 3 (Should Return True)
      {
         System.out.println("True");
      }
      else
      {
         System.out.println("False");
      }
      if(meme1.setCaptionVerticalAlign("not top middle or bottom")) //Test 4 (Should Return False)
      {
         System.out.println("True");
      }
      else
      {
         System.out.println("False");
      }
   }
}