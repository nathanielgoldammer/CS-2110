public class Rating
{
   //INSTANCE FIELDS
   private User user;
   private int score;
   //DEFAULT CONSTRUCTOR 
   public Rating()
   {
      this.user = new User();
      this.score = 0;
   }
   //OVERLOADED CONSTRUCTOR
   public Rating(User user, int score)
   {
      this.user = user;
      if((score == -1) || (score == 0) || (score == 1))
      {
         this.score = score;
      }
      else
      {
         score = 0;
      }
   }
   //SETTER AND GETTER METHODS
   public void setUser(User user)
   {
      this.user = user;
   }
   public User getUser()
   {
      return this.user;
   }
   public boolean setScore(int score)
   {
      if((score == -1) || (score == 0) || (score == 1))
      {
         this.score = score;
         return true;
      }
      else
      {
         return false;
      }
   }
   public int getScore()
   {
      return this.score;
   }
   //NON-STATIC METHODS 
   @Override
   public String toString()
   {
      if(this.score == -1)
      {
         return this.user.getUserName() + " rated as a downvote";
      }
      else if(this.score == 0)
      {
         return this.user.getUserName() + " rated as a pass";
      }
      else
      {
         return this.user.getUserName() + " rated as an upvote";
      }
   }
   @Override
   public boolean equals(Object object)
   {
      if((object != null) && (this.getClass() == object.getClass()))
      {
         //Type Cast object Parameter so that Rating Instance Variables can be Directly Referenced in a Boolean Expression
         Rating newObject = (Rating) object;
         return ((this.score == newObject.score) && (this.user.equals(newObject.user)));
      }
      else
      {
         return false;
      }
   }
   /**
   //MAIN METHOD TESTING 
   public static void main(String[] args)
   {
      //OVERLOADED CONSTRUCTOR TESTS
      User user1 = new User();
      User user2 = new User();
      Rating rating1 = new Rating(user1, 1);
      Rating rating2 = new Rating(user2, -1);

      //toString METHOD TESTS 
      System.out.println(rating1.toString());
      System.out.println(rating2.toString() + "\n");

      //equals METHOD TESTS
      if(rating1.equals(rating2)) //Test 1 (Should Return False)
      {
         System.out.println("True");
      }
      else
      {
         System.out.println("False");
      }
      rating1 = rating2;
      if(rating1.equals(rating2)) //Test 2 (Should Return True)
      {
         System.out.println("True\n");
      }
      else
      {
         System.out.println("False");
      }

      //setScore METHOD TESTS 
      if(rating1.setScore(1)) //Test 1 (Should Return True)
      {
         System.out.println("True");
      }
      else
      {
         System.out.println("False");
      }
      if(rating1.setScore(0)) //Test 2 (Should Return True)
      {
         System.out.println("True");
      }
      else
      {
         System.out.println("False");
      }
      if(rating1.setScore(-1)) //Test 3 (Should Return True)
      {
         System.out.println("True");
      }
      else
      {
         System.out.println("False");
      }
      if(rating1.setScore(10)) //Test 4 (Should Return False)
      {
         System.out.println("True");
      }
      else
      {
         System.out.println("False\n");
      }
   }
   */
}
