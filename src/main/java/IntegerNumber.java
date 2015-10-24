import java.util.ArrayList;
import java.util.List;

/**
 * Created by tenpines on 23/10/15.
 */
public class IntegerNumber {

  private int value;

  public int getValue() {
    return value;
  }

  public static IntegerNumber create(int value){
      IntegerNumber number = new IntegerNumber();
      number.value = value;
      return number;
  }

  public boolean hasEventDigitCount() {
    return digitCount() % 2 == 0;
  }

  public int digitCount() {
    return (int) (Math.floor(Math.log10(Math.abs(value))) + 1);
  }

  public List<Integer> digitList() {
    List<Integer> allDigits = new ArrayList<>();
    int remainingDigits = value;
    do{
      int digit = remainingDigits % 10;
      allDigits.add(0, digit);
      remainingDigits = remainingDigits / 10;
    }while(remainingDigits > 0);
    return allDigits;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    IntegerNumber that = (IntegerNumber) o;

    return value == that.value;

  }

  @Override
  public int hashCode() {
    return value;
  }
}
