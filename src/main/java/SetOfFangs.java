/**
 * Created by tenpines on 23/10/15.
 */
public class SetOfFangs {

  private Fang leftFang;
  private Fang rightFang;

  public static SetOfFangs create(int leftFang, int rightFang) {
    SetOfFangs setOfFangs = new SetOfFangs();
    setOfFangs.leftFang = Fang.create(leftFang);
    setOfFangs.rightFang = Fang.create(rightFang);
    return setOfFangs;
  }

  public Fang leftFang() {
    return leftFang;
  }

  public Fang rightFang() {
    return rightFang;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    SetOfFangs that = (SetOfFangs) o;

    if (leftFang != null ? !leftFang.equals(that.leftFang) : that.leftFang != null) return false;
    return !(rightFang != null ? !rightFang.equals(that.rightFang) : that.rightFang != null);

  }

  @Override
  public int hashCode() {
    int result = leftFang != null ? leftFang.hashCode() : 0;
    result = 31 * result + (rightFang != null ? rightFang.hashCode() : 0);
    return result;
  }


  public boolean isAsymmetrical() {
    boolean bothHaveTrailingZeroes = leftFang().hasTrailingZero() && rightFang().hasTrailingZero();
    return !bothHaveTrailingZeroes;
  }

  public int productValue() {
    return leftFang().getValue() * rightFang().getValue();
  }
}
