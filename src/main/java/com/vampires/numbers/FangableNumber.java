package com.vampires.numbers;

import com.google.common.collect.Collections2;
import com.vampires.VampireNumberException;
import com.vampires.fangs.SetOfFangs;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by tenpines on 23/10/15.
 */
public class FangableNumber {
  private IntegerNumber number;

  public static FangableNumber create(IntegerNumber number){
    if(!number.hasEventDigitCount()){
      throw new VampireNumberException("The number["+number.getValue()+"] is not fangable because it has an odd number of digits["+number.digitCount()+"]");
    }
    FangableNumber fangableNumber = new FangableNumber();
      fangableNumber.number = number;
      return fangableNumber;
  }

  public int getValue() {
    return number.getValue();
  }

  public Stream<SetOfFangs> calculatePossibleSets() {
    List<Integer> numberDigits = number.digitList();
    Collection<List<Integer>> digitPermutations = Collections2.orderedPermutations(numberDigits);
    return digitPermutations.stream()
      .map(this::convertPermutationToFangs);
  }

  private SetOfFangs convertPermutationToFangs(List<Integer> digits) {
    int halfDigitCount = digits.size() / 2;
    List<Integer> digitsLeftFang = digits.subList(0, halfDigitCount);
    List<Integer> digitsRightFang = digits.subList(halfDigitCount, digits.size());
    int leftFang = convertDigitsToInt(digitsLeftFang);
    int rightFang = convertDigitsToInt(digitsRightFang);
    return SetOfFangs.create(leftFang, rightFang);
  }

  private int convertDigitsToInt(List<Integer> digits) {
    int value = 0;
    for (Integer digit : digits) {
      value *= 10;
      value += digit;
    }
    return value;
  }

  public boolean isProductOf(SetOfFangs setOfFangs) {
    return number.getValue() == setOfFangs.productValue();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    FangableNumber that = (FangableNumber) o;

    return !(number != null ? !number.equals(that.number) : that.number != null);

  }

  @Override
  public int hashCode() {
    return number != null ? number.hashCode() : 0;
  }
}
