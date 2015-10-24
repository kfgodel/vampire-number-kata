package com.vampires.numbers;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import com.vampires.VampireNumberException;
import com.vampires.VampireTestContext;
import com.vampires.numbers.FangableNumber;
import com.vampires.fangs.SetOfFangs;
import com.vampires.numbers.IntegerNumber;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

/**
 * Created by tenpines on 23/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class FangableNumberTest extends JavaSpec<VampireTestContext> {
  @Override
  public void define() {
    describe("a fangable number", ()-> {
      it("can be created from an integer number that has even digits", () -> {
        FangableNumber fangableNumber = FangableNumber.create(IntegerNumber.create(23));

        assertThat(fangableNumber.getValue()).isEqualTo(23);
      });
      it("throws an error if created from a number with odd digits", () -> {
        try {
          FangableNumber.create(IntegerNumber.create(232));
          failBecauseExceptionWasNotThrown(VampireNumberException.class);
        } catch (VampireNumberException e) {
          assertThat(e).hasMessage("The number[232] is not fangable because it has an odd number of digits[3]");
        }
      });
      it("has one set of fangs per each possible digit permutation", () -> {
        FangableNumber fangable = FangableNumber.create(IntegerNumber.create(1234));
        List<SetOfFangs> possibleSets = fangable.calculatePossibleSets().collect(Collectors.toList());

        assertThat(possibleSets).containsOnly(
          SetOfFangs.create(12, 34),
          SetOfFangs.create(12, 43),
          SetOfFangs.create(13, 24),
          SetOfFangs.create(13, 42),
          SetOfFangs.create(14, 23),
          SetOfFangs.create(14, 32),
          SetOfFangs.create(21, 34),
          SetOfFangs.create(21, 43),
          SetOfFangs.create(23, 14),
          SetOfFangs.create(23, 41),
          SetOfFangs.create(24, 13),
          SetOfFangs.create(24, 31),
          SetOfFangs.create(31, 24),
          SetOfFangs.create(31, 42),
          SetOfFangs.create(32, 14),
          SetOfFangs.create(32, 41),
          SetOfFangs.create(34, 12),
          SetOfFangs.create(34, 21),
          SetOfFangs.create(41, 23),
          SetOfFangs.create(41, 32),
          SetOfFangs.create(42, 13),
          SetOfFangs.create(42, 31),
          SetOfFangs.create(43, 12),
          SetOfFangs.create(43, 21)
        );
      });

      it("can answer if its a fangable product for a set of fangs", () -> {
        FangableNumber fangable = FangableNumber.create(IntegerNumber.create(1260));

        boolean answer = fangable.isProductOf(SetOfFangs.create(21, 60));

        assertThat(answer).isTrue();
      });
    });
  }
}
