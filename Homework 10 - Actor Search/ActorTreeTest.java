public class ActorTreeTest 
{
    public static void insertTest()
    {
        ActorTree tree = new ActorTree();
        //1
        Actor actor1 = new Actor("Abby"); //Input
        boolean expected = true; //Expected
        boolean actual = tree.insert(actor1); //Actual
        System.out.println(expected == actual);

        //2 
        expected = false; //Expected 
        actual = tree.insert(actor1); //Actual
        System.out.println(expected == actual);

        //3
        Actor actor2 = new Actor("Bobby"); //Input
        expected = true; //Expected
        actual = tree.insert(actor2); //Actual
        System.out.println(expected == actual);
    }
    public static void findTest()
    {
        ActorTree tree = new ActorTree();
        //1
        String name1 = "Name"; //Input
        Actor expected1 = null; //Expected
        Actor actual1 = tree.find(name1);
        System.out.println(expected1 == actual1);

        //2
        String name2 = "Danny"; //Input
        Actor expected2 = new Actor(name2); //Expected
        tree.insert(expected2);
        Actor actual2 = tree.find(name2); //Actual
        System.out.println(expected2.compareTo(actual2));

        //3
        String name3 = "Charlie"; //Input 
        Actor expected3 = new Actor(name3); //Expected
        tree.insert(expected3);
        Actor actual3 = tree.find(name3); //Actual
        System.out.println(expected3.compareTo(actual3));

        //4
        String name4 = "Earl"; //Input 
        Actor expected4 = new Actor(name4); //Expected
        tree.insert(expected4);
        Actor actual4 = tree.find(name4); //Actual 
        System.out.println(expected4.compareTo(actual4));

        //5 
        String name5 = "Bobby"; //Input 
        Actor expected5 = new Actor(name5); //Expected
        tree.insert(expected5);
        Actor actual5 = tree.find(name5); //Actual 
        System.out.println(expected5.compareTo(actual5));

        //6
        String name6 = "Fabian"; //Input 
        Actor expected6 = new Actor(name6); //Expected
        tree.insert(expected6);
        Actor actual6 = tree.find(name6); //Actual 
        System.out.println(expected6.compareTo(actual6));

        //7
        String name7 = "Abby"; //Input 
        Actor expected7 = new Actor(name7); //Expected
        tree.insert(expected7);
        Actor actual7 = tree.find(name7); //Actual 
        System.out.println(expected7.compareTo(actual7));
    }
    public static void sizeTest()
    {
        ActorTree tree = new ActorTree();

        //1
        Actor actor1 = new Actor("Danny"); //Input
        tree.insert(actor1);
        int expected = 1; //Expected
        int actual = tree.size(); //Actual 
        System.out.println(expected == actual);

        //2
        Actor actor2 = new Actor("Benny"); //Input
        tree.insert(actor2);
        expected = 2; //Expected
        actual = tree.size(); //Actual 
        System.out.println(expected == actual);

        //3
        Actor actor3 = new Actor("Bobby"); //Input
        tree.insert(actor3);
        expected = 3; //Expected
        actual = tree.size(); //Actual 
        System.out.println(expected == actual);

        //4
        Actor actor4 = new Actor("Bill"); //Input
        tree.insert(actor4);
        expected = 4; //Expected
        actual = tree.size(); //Actual 
        System.out.println(expected == actual);
    }
    public static void inOrderTest()
    {
        ActorTree tree = new ActorTree(); 
        //Input
        Actor actor1 = new Actor("Juliet");
        tree.insert(actor1);
        Actor actor2 = new Actor("Diana");
        tree.insert(actor2);
        Actor actor3 = new Actor("Tom");
        tree.insert(actor3);
        Actor actor4 = new Actor("Harry");
        tree.insert(actor4);

        System.out.println(tree.inOrder());


    }

    public static void main(String[] args) 
    {
        inOrderTest();
    }
}
