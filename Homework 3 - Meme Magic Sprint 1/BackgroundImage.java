public class BackgroundImage 
{
   //INSTANCE FIELDS
   private String imageFileName; 
   private String title; 
   private String description; 
   //DEFAULT CONSTRUCTOR 
   public BackgroundImage()
   {
      this.imageFileName = "No Image File Name Yet";
      this.title = "No Title Yet";
      this.description = "No Description Yet";
   }
   //OVERLOADED CONSTRUCTOR
   public BackgroundImage(String imageFileName, String title, String description)
   {
      this.imageFileName = imageFileName;
      this.title = title;
      this.description = description;
   }
   //GETTER AND SETTER METHODS
   public String getImageFileName()
   {
      return this.imageFileName;
   }
   public void setImageFileName(String imageFileName)
   {
     this.imageFileName = imageFileName;
   }
   public String getTitle()
   {
      return this.title;
   }
   public void setTitle(String title)
   {
      this.title = title;
   }
   public String getDescription()
   {
      return this.description;
   }
   public void setDescription(String description)
   {
      this.description = description;
   }
   //NON-STATIC METHODS
   @Override
   public boolean equals(Object object)
   {
      if((object != null) && (this.getClass() == object.getClass()))
      {
         //Type cast object parameter so that BackgroundImage instance variables can be directly referenced in boolean expression
         BackgroundImage newObject = (BackgroundImage) object;
         return ((imageFileName.equals(newObject.imageFileName)) && (title.equals(newObject.title)) && (description.equals(newObject.description)));
      }
      else
      {
         return false;
      }
   }
   @Override
   public String toString()
   {
      return title + " <" + description + ">";
   }
   //MAIN METHOD TESTING 
   public static void main(String[] args)
   {
      //OVERLOADED CONSTRUCTOR AND toString METHOD TESTS
      BackgroundImage backgroundImage1 = new BackgroundImage("Image File Name 1", "Title 1", "Description 1"); //Test 1
      System.out.println(backgroundImage1.toString() + "\n"); //Test 1
      BackgroundImage backgroundImage2 = new BackgroundImage("Image File Name 2", "Title 2", "Description 2"); //Test 2
      System.out.println(backgroundImage2.toString() + "\n"); //Test 2

      //equals METHOD TESTS
      if(backgroundImage1.equals(backgroundImage2)) //Test 1 (Should Return False)
      {
         System.out.println("True");
      }
      else
      {
         System.out.println("False");
      }
      backgroundImage1 = backgroundImage2;
      if(backgroundImage1.equals(backgroundImage2)) //Test 1 (Should Return True)
      {
         System.out.println("True\n");
      }
      else
      {
         System.out.println("False");
      }
   }
}