package com.vampires.numbers;

import com.vampires.VampireNumberException;
import com.vampires.fangs.SetOfFangs;

/**
 * Created by tenpines on 23/10/15.
 */
public class VampireNumber {

  private FangableNumber number;
  private SetOfFangs fangs;

  public static VampireNumber create(FangableNumber number, SetOfFangs fangs) {
    if(!fangs.isAsymmetrical()){
      throw new VampireNumberException("The given set of fangs["+fangs.leftFang().getValue() +", "+
        fangs.rightFang().getValue()+"] can not have both trailing zeroes");
    }
    if(!number.isProductOf(fangs)){
      throw new VampireNumberException("The given set of fangs["+fangs.leftFang().getValue() +", "+
        fangs.rightFang().getValue()+"] product "+fangs.productValue()+" is not " + number.getValue());
    }
    VampireNumber vampireNumber = new VampireNumber();
    vampireNumber.number = number;
    vampireNumber.fangs = fangs;
    return vampireNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    VampireNumber that = (VampireNumber) o;

    if (number != null ? !number.equals(that.number) : that.number != null) return false;
    return !(fangs != null ? !fangs.equals(that.fangs) : that.fangs != null);

  }

  @Override
  public int hashCode() {
    int result = number != null ? number.hashCode() : 0;
    result = 31 * result + (fangs != null ? fangs.hashCode() : 0);
    return result;
  }

  public int getValue() {
    return number.getValue();
  }

  public int getLeftFang() {
    return fangs.leftFang().getValue();
  }

  public int getRightFang() {
    return fangs.rightFang().getValue();
  }
}
