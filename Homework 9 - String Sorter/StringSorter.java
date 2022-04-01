import java.util.*;
public class StringSorter 
{
    /** 
     * Array of Queues of Strings. Each Queue in arrOfQ 
     * represents a letter of the alphabet. 
     */
    private Queue<String>[] arrOfQ;
    /**
     * Default Constructor: 
     * Initializes arrOfQ with a size of 26, and then initializes
     * each element in arrOfQ. 
     */
    public StringSorter()
    {
        arrOfQ = new Queue[26];
        for(int i = 0; i < arrOfQ.length; i++)
            arrOfQ[i] = new LinkedList<>();
    }
    /**
     * Public API that allows Strings to be sorted: 
     * Calls the distribute method to "sort" the Strings in the list 
     * based on the current letter position, and then collects the values. 
     * 
     * @param list
     * @return a sorted ArrayList<String>
     */
    public ArrayList<String> sort(ArrayList<String> list)
    {
       this.distribute(list, 0);
       return this.collect(0);
    }
    /**
     * Places each String from the list into the appropriate Queue, 
     * based on the letter at the current letter position. 
     * 
     * @param list
     * @param position
     */
    private void distribute(ArrayList<String> list, int position)
    {
        for(int i = 0; i < list.size(); i++)
        {
            if(position < list.get(i).length())
            {
                for(int j = 0; j < arrOfQ.length; j++)
                {
                    if(list.get(i).charAt(position) == "abcdefghijklmnopqrstuvwxyz".charAt(j))
                        arrOfQ[j].add(list.get(i));
                }
            }
        }
    }
    /**
     * Recusively sorts all Strings from any Queue in arrOfQ that has more than one entry. 
     * Otherwise copies the Strings from arrOfQ back into an ArrayList, starting with the 
     * first Queue and ending with the last Queue, while emptying each Queue as it goes. 
     * 
     * @param position 
     * @return The sorted ArrayList of Strings
     */
    private ArrayList<String> collect(int position)
    {
        ArrayList<String> sortedArrayList = new ArrayList<>(); //Sorted ArrayList to be returned
        for(int i = 0; i < arrOfQ.length; i++)
        { 
            if(arrOfQ[i].size() == 1) //Base Case
                sortedArrayList.add(arrOfQ[i].remove());
            else if(arrOfQ[i].size() > 1) //Recursive Case
            {
                ArrayList<String> newArrayList = new ArrayList<>(); //New ArrayList to be recursively sorted
                while(!arrOfQ[i].isEmpty())
                {
                    if(arrOfQ[i].peek().length() == position + 1)
                        sortedArrayList.add(arrOfQ[i].remove());
                    else 
                        newArrayList.add(arrOfQ[i].remove());
                }
                StringSorter newStringSorter = new StringSorter(); //New StringSorter to recursively sort the new ArrayList
                newStringSorter.distribute(newArrayList, position + 1);
                sortedArrayList.addAll(newStringSorter.collect(position + 1));
            }
        }
        return sortedArrayList;
    }
}