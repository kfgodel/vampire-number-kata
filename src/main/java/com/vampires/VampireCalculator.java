package com.vampires;

import com.vampires.numbers.FangableNumber;
import com.vampires.fangs.SetOfFangs;
import com.vampires.numbers.IntegerNumber;
import com.vampires.numbers.VampireNumber;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by tenpines on 23/10/15.
 */
public class VampireCalculator {

  public static VampireCalculator create(){
      VampireCalculator calculator = new VampireCalculator();
      return calculator;
  }

  public Stream<VampireNumber> calculate(int upperBound) {
    return IntStream.rangeClosed(1, upperBound)
      .mapToObj(IntegerNumber::create)
      .filter(IntegerNumber::hasEventDigitCount)
      .map(FangableNumber::create)
      .flatMap((fangable) ->
          fangable.calculatePossibleSets()
            .filter(SetOfFangs::isAsymmetrical)
            .filter((fangs) -> fangable.isProductOf(fangs))
            .map((fangs) -> VampireNumber.create(fangable, fangs))
      );
  }
}
