import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collection;
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

      it("generates the list of vampire numbers lesser than the given upper bound", () -> {
        List<VampireNumber> numbers = context().calculator().calculate(1260).collect(Collectors.toList());

        assertThat(numbers)
          .containsOnly(
            VampireNumber.create(FangableNumber.create(IntegerNumber.create(1260)), SetOfFangs.create(21, 60)),
            VampireNumber.create(FangableNumber.create(IntegerNumber.create(1260)), SetOfFangs.create(60, 21))
          );
      });

    });

  }
}
