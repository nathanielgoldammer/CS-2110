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
      creator = new User();
      backgroundImage = new BackgroundImage();
      ratings = new Rating[0];
      caption = "No caption Yet";
      captionVerticalAlign = "No captionVerticalAlign Yet";
      shared = true;
   }
   //SETTER METHODS
   public void setCreator()
   {
      /**
       * Sets creator instance variable
       */
   }
   public void setBackgroundImage()
   {
      /**
       * Sets backgroundImage instance variable
       */
   }
   public void setRatings()
   {
      /**
       * Sets ratings instance variable
       */
   }
   public void setCaption(String aCaption)
   {
      /**
       * Assigns caption the value of aCaption
       */
   }
   public void setCaptionVerticalAlign(String aCaptionVerticalAlign)
   {
      /**
       * Assigns caption the value of aCaptionVerticalAlign
       */
   }
   public void setShared(Boolean aBoolean)
   {
      /**
       * Assigns shared the value of aBoolean
       */
   }
   //GETTER METHODS
   public User getCreator()
   {
      /**
       * Returns User object
       */
      return null;
   }
   public BackgroundImage getBackgroundImage()
   {
     /**
      * Returns backgroundImage instance variable
      */
      return null;
   }
   public Rating[] getRatings()
   {
      /**
       * Returns ratings instance variable
       */
      return ratings;
   }
   public String getCaption()
   {
      /**
       * Returns caption instance variable
       */
      return "";
   }
   public String getCaptionVerticalAlign()
   {
      /**
       * Returns value of captionVerticalAlign instance field
       */
      return "";
   }
   public boolean getShared()
   {
      /**
       * Returns value of shared instance variable
       */
      return true;
   }
   //METHODS
   public boolean addRating(Rating object)
   {
      /**
       * Accepts a rating, returns a boolean
       */
      return true;
   }
   public double calculateOverallRating()
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
