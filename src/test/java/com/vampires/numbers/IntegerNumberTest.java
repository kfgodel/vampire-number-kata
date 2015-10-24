package com.vampires.numbers;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import com.google.common.collect.Lists;
import com.vampires.VampireTestContext;
import com.vampires.numbers.IntegerNumber;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by tenpines on 23/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class IntegerNumberTest extends JavaSpec<VampireTestContext> {
  @Override
  public void define() {
    describe("an integer number", ()->{
      it("can be created from an int", ()->{
        IntegerNumber number = IntegerNumber.create(42);

        assertThat(number.getValue()).isEqualTo(42);
      });
      it("can answer if it has event digit count", ()->{
        assertThat(IntegerNumber.create(1).hasEventDigitCount()).isFalse();
        assertThat(IntegerNumber.create(10).hasEventDigitCount()).isTrue();
        assertThat(IntegerNumber.create(100).hasEventDigitCount()).isFalse();
        assertThat(IntegerNumber.create(1000).hasEventDigitCount()).isTrue();
      });
      it("can answer the amount of digits", ()->{
        assertThat(IntegerNumber.create(1).digitCount()).isEqualTo(1);
        assertThat(IntegerNumber.create(10).digitCount()).isEqualTo(2);
        assertThat(IntegerNumber.create(100).digitCount()).isEqualTo(3);
        assertThat(IntegerNumber.create(1000).digitCount()).isEqualTo(4);
      });
      it("can list its digits", ()->{
        assertThat(IntegerNumber.create(2345).digitList()).isEqualTo(Lists.newArrayList(2,3,4,5));
      });
    });
  }
}
