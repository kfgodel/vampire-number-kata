package com.vampires;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import com.vampires.numbers.FangableNumber;
import com.vampires.fangs.SetOfFangs;
import com.vampires.numbers.IntegerNumber;
import com.vampires.numbers.VampireNumber;
import org.junit.runner.RunWith;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by tenpines on 23/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class VampireCalculatorTest  extends JavaSpec<VampireTestContext> {
  @Override
  public void define() {

    describe("a vampire calculator", () -> {
      context().calculator(VampireCalculator::create);

      xit("generates the list of vampire numbers lesser than the given upper bound", () -> {
        List<VampireNumber> numbers = context().calculator().calculate(1260).collect(Collectors.toList());

        assertThat(numbers)
          .containsOnly(
            VampireNumber.create(FangableNumber.create(IntegerNumber.create(1260)), SetOfFangs.create(21, 60)),
            VampireNumber.create(FangableNumber.create(IntegerNumber.create(1260)), SetOfFangs.create(60, 21))
          );
      });

      it("finds the first numbers under 130k in less than 30s", ()->{
        long start = System.currentTimeMillis();
        Iterator<VampireNumber> calculatedNumbers = VampireCalculator.create().calculate(130_000).iterator();
        while(calculatedNumbers.hasNext()){
          VampireNumber number = calculatedNumbers.next();
          System.out.println("Number: " + number.getValue() + " fangs:[" + number.getLeftFang() + ", " + number.getRightFang() + "]");
        }
        long end = System.currentTimeMillis();
        double elapsedSeconds = (end - start) / 1000.0;
        System.out.println("Elapsed: " + elapsedSeconds + "s");
        assertThat(elapsedSeconds).isLessThan(30);
      });
    });

  }
}
