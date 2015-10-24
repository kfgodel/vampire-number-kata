/**
 * Created by tenpines on 23/10/15.
 */
public class Number {

  private int value;
  private String textRepresentation;

  public boolean isVampire(){
    return hasEvenDigits();
  }

  private boolean hasEvenDigits() {
    return textRepresentation.length() % 2 == 0;
  }

  public static Number create(int value){
      Number number = new Number();
      number.value = value;
      number.textRepresentation = String.valueOf(value);
      return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Number number = (Number) o;

    return value == number.value;

  }

  @Override
  public int hashCode() {
    return value;
  }
}
