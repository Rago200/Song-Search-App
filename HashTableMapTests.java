// --== CS400 Project1 HashTableMapTests ==--
// Name: Rago Senthilkumar
// Email: rsenthilkuma@wisc.edu
// Team: Blue
// Group: DQ
// TA: Yuye
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

/**
 * This class houses the code for the tests for the HashtableMap.
 *
 */
public class HashTableMapTests {
  /**
   * Hashtable is empty and adding an element.
   *
   * @return true if size is 1, false other wise.
   */
  public static boolean test1() { /* test code here */
    Node apartmentPair = new Node(1, "Raj");
    HashtableMap hashtableMap = new HashtableMap();
    hashtableMap.put(apartmentPair.getKey(),apartmentPair.getValue());

    //Checking for the size()
    if(hashtableMap.size() != 1 ){
      System.out.println("The size of the hashtableMap is supposed to be 1, but resulted: " + hashtableMap.size());
      return false;
    }

    //Checking to see the key value pair was placed properly
    if(!hashtableMap.get(apartmentPair.getKey()).equals("Raj")){
      System.out.println("The get() method should return \"Raj\", but resulted: " + hashtableMap.get(apartmentPair.getKey()));
      return false;
    }
    hashtableMap.clear();
    return true;
  }

  /**
   * Checking to see if the remove method works properly
   *
   * @return true if the clear() function, false otherwise.
   */
  public static boolean test2() { /* test code here */
    Node apartmentPair = new Node(1, "Raj");
    Node apartmentPair1 = new Node(2, "Guy");
    HashtableMap hashtableMap = new HashtableMap();
    hashtableMap.put(apartmentPair.getKey(),apartmentPair.getValue());
    hashtableMap.put(apartmentPair1.getKey(),apartmentPair1.getValue());


    //(1) The remove method is used with two values
    hashtableMap.remove(apartmentPair.getKey());

    if(hashtableMap.size() != 1){
      System.out.println("The size of the hashtableMap is supposed to be 1, but resulted: " + hashtableMap.size());
      return false;
    }

    //(2) The remove method is used on one element
    hashtableMap.remove(apartmentPair1.getKey());

    if(hashtableMap.size() != 0){
      System.out.println("The size of the hashtableMap is supposed to be 1, but resulted: " + hashtableMap.size());
      return false;
    }

    hashtableMap.clear();
    return true;
  }

  /**
   * Checking ReHashing when hashtable is greater than 80%.
   *
   * @return true if the ReHash() function works, false otherwise.
   */
  public static boolean test3() {
    HashtableMap hashtableMap = new HashtableMap(5);
    Node apartmentPair = new Node(1, "Raj");
    Node apartmentPair1 = new Node(2, "Guy");
    Node apartmentPair2 = new Node(3, "Lami");
    Node apartmentPair3 = new Node(4, "Rj");
    Node apartmentPair4 = new Node(5, "Cool");
    Node apartmentPair5 = new Node(6, "RV");



    hashtableMap.put(apartmentPair.getKey(),apartmentPair.getValue());
    hashtableMap.put(apartmentPair1.getKey(),apartmentPair1.getValue());
    hashtableMap.put(apartmentPair2.getKey(),apartmentPair2.getValue());


    //(1) Adding a fourth node should cause a Rehash resulting in a bigger hashtable with the elemnts still being there
    hashtableMap.put(apartmentPair3.getKey(),apartmentPair3.getValue());
    hashtableMap.put(apartmentPair4.getKey(),apartmentPair4.getValue());

    //(2)Adding this should tell let us know the capacity increased
    hashtableMap.put(apartmentPair5.getKey(),apartmentPair5.getValue());

    if(hashtableMap.size() != 6){
      System.out.println("The size of the hashtableMap is supposed to be 6, but resulted: " + hashtableMap.size());
      return false;
    }

    //checking to see if the elements are still there
    if(!hashtableMap.containsKey(apartmentPair.getKey()) || !hashtableMap.containsKey(apartmentPair1.getKey()) ||
            !hashtableMap.containsKey(apartmentPair2.getKey()) || !hashtableMap.containsKey(apartmentPair3.getKey()) ||
            !hashtableMap.containsKey(apartmentPair4.getKey()) || !hashtableMap.containsKey(apartmentPair5.getKey())){
      System.out.println("One of the key value pairs was not found in the hashtable");
      return false;
    }

    hashtableMap.clear();
    return true;
  }

  /**
   * testing the clear() function.
   *
   * @return true if the clear() function, false otherwise.
   */
  public static boolean test4() { /* test code here */
    HashtableMap hashtableMap = new HashtableMap(5);
    Node apartmentPair = new Node(1, "Raj");
    Node apartmentPair1 = new Node(2, "Guy");

    hashtableMap.put(apartmentPair.getKey(),apartmentPair.getValue());
    hashtableMap.put(apartmentPair1.getKey(),apartmentPair1.getValue());

    hashtableMap.clear();

    //The hashtable size should be zero.
    if(hashtableMap.size() != 0){
        System.out.println("The size of the hashtableMap is supposed to be 0, but resulted: " + hashtableMap.size());
        return false;
    }

    return true;
  }

  /**
   * Testing the get() method.
   *
   * @return true if the get() function, false otherwise.
   */
  public static boolean test5() {
    HashtableMap hashtableMap = new HashtableMap(5);
    Node apartmentPair = new Node(1, "Raj");
    Node apartmentPair1 = new Node(2, "Guy");

    hashtableMap.put(apartmentPair.getKey(),apartmentPair.getValue());
    hashtableMap.put(apartmentPair1.getKey(),apartmentPair1.getValue());

    if(!hashtableMap.get(apartmentPair.getKey()).equals("Raj") || !hashtableMap.get(apartmentPair1.getKey())
            .equals("Guy")){
      System.out.println("The get() method did not work correctly.");
      return false;
    }
    return true;
  }

  /**
   * The main method calls all the tests.
   *
   * @param args unused
   */

  public static void main(String[] args){
    System.out.println("test1()"+test1());
    System.out.println("test2()"+test2());
    System.out.println("test3()"+test3());
    System.out.println("test4()"+test4());
    System.out.println("test5()"+test5());
  }
}
