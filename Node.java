// --== CS400 Project1 Node ==--
// Name: Rago Senthilkumar
// Email: rsenthilkuma@wisc.edu
// Team: Blue
// Group: DQ
// TA: Yuye
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
public class Node<KeyType, ValueType> {
  private KeyType key;
  private ValueType value;

  public Node(KeyType key, ValueType value){
    this.key = key;
    this.value = value;
  }

  public KeyType getKey() {
    return key;
  }

  public ValueType getValue() {
    return value;
  }
}
