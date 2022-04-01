public class BackgroundImage 
{
   //INSTANCE FIELDS
   private String imageFileName; 
   private String title; 
   private String description; 
   //DEFAULT CONSTRUCTOR 
   public BackgroundImage()
   {
      imageFileName = "No imageFileName Yet";
      title = "No title Yet";
      description = "No description Yet";
   }
   //SETTER METHODS
   public void setImageFileName(String aImageFileName)
   {
      /**
       * Assigns imageFileName the value of aImageFileName
       */
   }
   public void setTitle(String aTitle)
   {
      /**
       * Assigns title the value of aTitle
       */
   }
   public void setDescription(String aDescription)
   {
      /**
       * Assigns description the value of inputDesciption
       */
   }
   //GETTER METHODS
   public String getImageFileName()
   {
      /**
       * Returns the value of  imageFileName 
       */
      return imageFileName;
   }
   public String getTitle()
   {
      /**
       * Returns the value of title
       */
      return title;
   }
   public String getDescription()
   {
      /**
       * Returns the value of description
       */
      return description;
   }
   //METHODS
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
       * Accepts an object and returns a boolean value
       */
      return true;
   }
}
