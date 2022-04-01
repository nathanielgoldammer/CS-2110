public class Rating
{
   //INSTANCE FIELDS
   private int score;
   private User user;
   //DEFAULT CONSTRUCTOR 
   public Rating()
   {
      score = 0;
      user = new User();
   }
   //SETTER METHODS
   public void setScore(int aScore)
   {
      /**
       * Assigns score the value of aScore
       */
   }
   public void setUser()
   {
      /**
       * 
       */
   }
   //GETTER METHODS
   public int getScore()
   {
      /**
       * Returns the value of score
       */
      return score;
   }
   public User getUser()
   {
      /**
       * Returns User object
       */
      return null;
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
       * Accepts an Object, returns a boolean
       */
      return false;
   }
}
