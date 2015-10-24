/**
 * Created by tenpines on 23/10/15.
 */
public class Fang {

  public int getValue() {
    return value;
  }

  private int value;

  public static Fang create(int value){
      Fang fang = new Fang();
      fang.value = value;
      return fang;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Fang fang = (Fang) o;

    return value == fang.value;

  }

  @Override
  public int hashCode() {
    return value;
  }

  public boolean hasTrailingZero() {
    return value % 10 == 0;
  }
}
