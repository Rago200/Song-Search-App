// --== CS400 Project1 HashTableMap ==--
// Name: Rago Senthilkumar
// Email: rsenthilkuma@wisc.edu
// Team: Blue
// Group: DQ
// TA: Yuye
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
  private Object[] hashTable;  //The array where the key and value pairs
  private int capacity;        //The number of spaces available

  /**
   * Constructor when given the capacity.
   *
   * @param capacity the number of spaces required for the Hashtable
   */
  public HashtableMap(int capacity){
    this.capacity = capacity;
    this.hashTable = new Object[capacity];
  }

  /**
   * Constructor when there is no argument given and is given a capacity of 20.
   *
   */
  public HashtableMap(){
    capacity = 20;
    this.hashTable =  new Object[20];
  }

  /**
   * Calculates the load factor.
   *
   * @return the load factor is returned as a float.
   */
  private float getLoadFactor(){
    return (float) (((double) size()) / capacity);
  }

  /**
   * This method re-sizes the hashtable and puts the key/value elements back
   * in the new hashtable and will be re-indexed and placed.
   */
  private void reHash(){
    Object[] tempTable = this.hashTable;
    this.capacity = this.capacity * 2;
    clear();
    for(int i = 0; i < tempTable.length; i++){
      if(tempTable[i] != null) {
        LinkedList<Node<KeyType, ValueType>> list = (LinkedList<Node<KeyType, ValueType>>) tempTable[i];
        for (int j = 0; j < list.size(); j++) {
          put(list.get(j).getKey(), list.get(j).getValue());
        }
      }
    }

  }

  /**
   * Finds the index where the key and value will be placed given the key.
   *
   * @param key one of the values used to calculate the index
   * @return the index of the array
   */
  private int hashFunction(KeyType key){
    return Math.abs(key.hashCode()) % capacity;
  }

  /**
   * Puts the key and value elements in the hashtable
   *
   * @param key the key value being placed
   * @param value the value being placed
   * @return True if it was successfully placed.
   */
  @Override
  public boolean put(KeyType key, ValueType value) {
    if(key.equals(null)){
      return false;
    }
    if(containsKey(key)){
      return false;
    }

    int index = hashFunction(key);

    if(hashTable[index] == null) {
      hashTable[index] = new LinkedList<Node<KeyType, ValueType>>();
      LinkedList<Node<KeyType, ValueType>> list = (LinkedList<Node<KeyType, ValueType>>) this.hashTable[index];
      list.add(new Node<>(key,value));
      if(getLoadFactor() >= .8){
        reHash();
      }
      return true;
    }

    else if(hashTable[index] != null){
      LinkedList<Node<KeyType, ValueType>> list = (LinkedList<Node<KeyType, ValueType>>) this.hashTable[index];
      list.add(new Node<>(key, value));
      if(getLoadFactor() >= .8){
        reHash();
      }
      return true;
    }

    return false;
  }

  /**
   * Gets the value held by the key in the Hashtable.
   * @param key the key value used to get the value element
   * @return the value that corresponds to the key
   * @throws NoSuchElementException thrown when the key does not exist
   */
  @Override
  public ValueType get(KeyType key) throws NoSuchElementException {
    if(!containsKey(key)){
      throw new NoSuchElementException("Key not found.");
    }

    ValueType value = null;
    int index = hashFunction(key);
    LinkedList<Node<KeyType,ValueType>> list = (LinkedList<Node<KeyType, ValueType>>) this.hashTable[index];

    for(int i = 0; i < list.size(); i++){
      if(key.equals(list.get(i).getKey())){
        value = list.get(i).getValue();
      }
    }
    return value;
  }

  /**\
   * Finds the number of key/value elements in the Hashtable.
   * @return Finds the number of key/value elements in the Hashtable.
   */
  @Override
  public int size() {
    int size = 0;

    for(int i = 0; i < this.hashTable.length; i++){
      if(hashTable[i] != null) {
        LinkedList<Node<KeyType,ValueType>> list = (LinkedList<Node<KeyType, ValueType>>) this.hashTable[i];
        for (int j = 0; j < list.size(); j++) {
          if (!(list.get(j).equals(null))) {
            size++;
          }
        }
      }
    }
    return size;
  }

  /**
   * Checks wehther a certain key and value element are there in the
   * hashtable given the key
   * @param key the key that is being searched for
   * @return true if the key exists , false otherwise.
   */
  @Override
  public boolean containsKey(KeyType key) {
    if(key == null){
      return false;
    }

    int index = hashFunction(key);

    if(hashTable[index] == null){
      return false;
    }

    LinkedList<Node<KeyType,ValueType>> list = (LinkedList<Node<KeyType, ValueType>>) this.hashTable[index];

    for(int i = 0; i < list.size(); i++){
      if(key.equals(list.get(i).getKey())){
        return true;
      }
    }

    return false;
  }

  /**
   * Removes a specific key and value elements given the key.
   * @param key the key being removed.
   * @return the value being removed.
   */
  @Override
  public ValueType remove(KeyType key) {
    if(!containsKey(key)){
      return null;
    }

    ValueType value = null;
    int index = hashFunction(key);
    LinkedList<Node<KeyType,ValueType>> list = (LinkedList<Node<KeyType, ValueType>>) this.hashTable[index];

    for(int i = 0; i < list.size(); i++){
      if(key.equals(list.get(i).getKey())){
          value = list.get(i).getValue();
          list.remove(i);
      }
    }

    return value;
  }

  /**
   * Clears the hashtable.
   */
  @Override
  public void clear() {
    this.hashTable = new Object[capacity];
  }
}
