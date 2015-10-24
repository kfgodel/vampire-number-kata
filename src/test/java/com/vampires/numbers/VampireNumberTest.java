package com.vampires.numbers;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import com.vampires.VampireNumberException;
import com.vampires.VampireTestContext;
import com.vampires.numbers.FangableNumber;
import com.vampires.fangs.SetOfFangs;
import com.vampires.numbers.IntegerNumber;
import com.vampires.numbers.VampireNumber;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

/**
 * Created by tenpines on 23/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class VampireNumberTest extends JavaSpec<VampireTestContext> {
  @Override
  public void define() {
    describe("a vampire number", () -> {
      it("is created from a fangable number and a specific set of fangs", () -> {
        VampireNumber vampireNumber = VampireNumber.create(FangableNumber.create(IntegerNumber.create(1260)), SetOfFangs.create(21, 60));

        assertThat(vampireNumber.getValue()).isEqualTo(1260);
        assertThat(vampireNumber.getLeftFang()).isEqualTo(21);
        assertThat(vampireNumber.getRightFang()).isEqualTo(60);
      });

      it("throws an error if the number is not product of the fangs", () -> {
        try{
          VampireNumber.create(FangableNumber.create(IntegerNumber.create(1260)),
            SetOfFangs.create(12, 60));
          failBecauseExceptionWasNotThrown(VampireNumberException.class);
        }catch(VampireNumberException e){
          assertThat(e).hasMessage("The given set of fangs[12, 60] product 720 is not 1260");
        }
      });

      it("throws an error if the fangs are not asymmetrical", () -> {
        try{
          VampireNumber.create(FangableNumber.create(IntegerNumber.create(1260)),
            SetOfFangs.create(20, 60));
          failBecauseExceptionWasNotThrown(VampireNumberException.class);
        }catch(VampireNumberException e){
          assertThat(e).hasMessage("The given set of fangs[20, 60] can not have both trailing zeroes");
        }
      });

    });
  }
}
