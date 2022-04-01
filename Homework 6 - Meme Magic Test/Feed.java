import java.util.ArrayList;
public class Feed 
{
   //Instance Field 
   private ArrayList<Meme> memes;
   //Default Constructor 
   public Feed()
   {
      memes = new ArrayList<>();
   }
   //memes Setter and Getter Methods
   public void setMemes(ArrayList<Meme> memes)
   {
      this.memes = memes;
   }
   public ArrayList<Meme> getMemes()
   {
      return this.memes;
   }
   /**
    * Returns a Meme from the current Feed that the User has not seen (does not exist in that User's memesViewed list) and that the User did not create themselves. 
    * If there is no Meme to return, null will be returned.

    * @param object
    * @return a meme or null
    */
   public Meme getNewMeme(User user)
   {
      if(!(this.memes.isEmpty()))
      {
         for(int i = 0; i < this.memes.size(); i++)
         {
            if((!(user.getMemesViewed().contains(this.memes.get(i)))) && (!(user.getMemesCreated().contains(this.memes.get(i)))))
            {
               return this.memes.get(i);
            }
         }
      }
      return null;
   }
   @Override
   public String toString()
   {
      String returnString = "";
      String memeString;
      Meme meme;
      for(int i = 0; i < this.memes.size(); i++)
      {
         meme = this.memes.get(i);
         memeString = meme.toString();
         returnString = returnString.concat(memeString + "\n");
         
      }
      return returnString;
   }
   /**
   public static void main(String[] args)
   {
      //toString Test 1 - Expected Output: 3 Separate Lines of "No Title Yet <No Description Yet> 'No caption Yet' 0.0 [+1: 0, -1: 0] - created by No Username Yet"
      Feed feed = new Feed(); 
      Meme meme1 = new Meme();
      Meme meme2 = new Meme(); 
      Meme meme3 = new Meme();
      feed.memes.add(meme1);
      feed.memes.add(meme2);
      feed.memes.add(meme3);
      System.out.println(feed.toString());

      //toString Test 2 - Expected Output: 
      //"No Title Yet <No Description Yet> 'No caption Yet' 0.0 [+1: 0, -1: 0] - created by Username 1"
      //"No Title Yet <No Description Yet> 'No caption Yet' 0.0 [+1: 0, -1: 0] - created by Username 2"
      //"No Title Yet <No Description Yet> 'No caption Yet' 0.0 [+1: 0, -1: 0] - created by Username 3"
      User user1 = new User("Username 1");
      meme1.setCreator(user1);
      User user2 = new User("Username 2");
      meme2.setCreator(user2);
      User user3 = new User("Username 3");
      meme3.setCreator(user3);
      System.out.println(feed.toString());

      //getNewMeme Test 1 - Expected Output: "There is no Meme to Return"
      ArrayList<Meme> viewed = new ArrayList<>();
      ArrayList<Meme> created = new ArrayList<>();
      viewed.add(meme1);
      viewed.add(meme2);
      viewed.add(meme3);
      created.add(meme1);
      created.add(meme2);
      created.add(meme3);
      user1.setMemesViewed(viewed);
      user1.setMemesCreated(created);
      if(feed.getNewMeme(user1) != null)
      {
         System.out.println("There is a Meme to Return");
      }
      else
      {
         System.out.println("There is no Meme to Return");
      }

      //getNewMeme Test 2 - Expected Output: "There is a Meme to Return"
      Meme meme4 = new Meme(); 
      feed.memes.add(meme4);
      if(feed.getNewMeme(user1) != null)
      {
         System.out.println("There is a Meme to Return");
      }
      else
      {
         System.out.println("There is no Meme to Return");
      }
   }
   */
}
