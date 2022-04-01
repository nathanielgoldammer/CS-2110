import java.util.Arrays;
public class BackgroundImage implements Comparable<BackgroundImage>
{
   //Instance Fields
   private String imageFileName; 
   private String title; 
   private String description; 
   //Default Constructor 
   public BackgroundImage()
   {
      this.imageFileName = "No Image File Name Yet";
      this.title = "No Title Yet";
      this.description = "No Description Yet";
   }
   //Overloaded Constructor
   public BackgroundImage(String imageFileName, String title, String description)
   {
      this.imageFileName = imageFileName;
      this.title = title;
      this.description = description;
   }
   //imageFileName Getter and Setter Methods
   public String getImageFileName()
   {
      return this.imageFileName;
   }
   public void setImageFileName(String imageFileName)
   {
     this.imageFileName = imageFileName;
   }
   //title Getter and Setter Methods
   public String getTitle()
   {
      return this.title;
   }
   public void setTitle(String title)
   {
      this.title = title;
   }
   //description Getter and Setter Methods
   public String getDescription()
   {
      return this.description;
   }
   public void setDescription(String description)
   {
      this.description = description;
   }
   /**
    * Checks whether or not the two objects (the caller and the parameter) are the same by comparing their class, title, description, and imageFileName
    *
    * @param object
    * @return true if the objects are equal and false if otherwise
    */
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
   /**
    * Returns a String representation of the calling object
    *
    * @return the String "title < description >"
    */
   @Override
   public String toString()
   {
      return title + " <" + description + ">";
   }
   /**
    * Orders BackgroundImage objects as follows: 
    * First, by imageFileName (ascending)
    * Then, if the objects' imageFileName are identical, by title (ascending)
    * Lastly, if the objects' imageFileName and title are identical, by description (ascending)
    *
    * @param object
    * @return A negative int value if the caller should come before the parameter, zero if the caller and parameter are the same, and a positive int value if the parameter should come before the caller
    */
   @Override
   public int compareTo(BackgroundImage object)
   {
      //Check if the objects' have the same imageFileName
      if(this.imageFileName.compareTo(object.imageFileName) != 0)
      {
         return this.imageFileName.compareTo(object.imageFileName);
      }
      //Check if the objects' have the same title
      else if(this.title.compareTo(object.title) != 0)
      {
         return this.title.compareTo(object.title);
      }
      //Check if the objects' have the same description
      else if(this.description.compareTo(object.description) != 0)
      {
         return this.description.compareTo(object.description);
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
      //compareTo Test 1 - Expected Output: "object1 and object2 are the same"
      BackgroundImage object1 = new BackgroundImage("A", "B", "C");
      BackgroundImage object2 = new BackgroundImage("A", "B", "C");
      if(object1.compareTo(object2) == 0)
      {
         System.out.println("\nobject1 and object2 are the same");
      }

      //compareTo Test 2 - Expected Output: "object1 before object2 by description" 
      object2.setDescription("c"); 
      if((object1.compareTo(object2) < 0) && (object2.compareTo(object1) > 0))
      {
         System.out.println("object1 before object2 by description");
      }

      //compareTo Test 3 - Expected Output: "object1 before object2 by title"
      object2.setTitle("b");
      if((object1.compareTo(object2) < 0) && (object2.compareTo(object1) > 0))
      {
         System.out.println("object1 before object2 by title");
      }

      //compareTo Test 4 - Expected Output: "object1 before object2 by imageFileName"
      object2.setImageFileName("a");
      if((object1.compareTo(object2) < 0) && (object2.compareTo(object1) > 0))
      {
         System.out.println("object1 before object2 by imageFileName");
      }

      //compareTo Test 5 - Expected Output: "object1 sorted before object2"
      BackgroundImage[] backgroundImages = new BackgroundImage[2];
      backgroundImages[0] = object2;
      backgroundImages[1] = object1;
      Arrays.sort(backgroundImages);
      if((backgroundImages[0].equals(object1)) && (backgroundImages[1].equals(object2)))
      {
         System.out.println("object1 sorted before object2\n");
      }
   }
   */
}