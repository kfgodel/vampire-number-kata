package com.vampires.fangs;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import com.vampires.VampireTestContext;
import com.vampires.fangs.SetOfFangs;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by tenpines on 23/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class SetOfFangsTest extends JavaSpec<VampireTestContext> {
  @Override
  public void define() {
    describe("a set of fangs", ()->{
      it("has a left fang and a right fang", ()->{
        SetOfFangs setOfFangs = SetOfFangs.create(1, 2);

        assertThat(setOfFangs.leftFang().getValue()).isEqualTo(1);
        assertThat(setOfFangs.rightFang().getValue()).isEqualTo(2);
      });

      it("is asymmetrical if only one of the fangs ends in 0 (or none)", ()->{
        assertThat(SetOfFangs.create(1, 2).isAsymmetrical()).isTrue();
        assertThat(SetOfFangs.create(10, 2).isAsymmetrical()).isTrue();
        assertThat(SetOfFangs.create(1, 20).isAsymmetrical()).isTrue();
      });

      it("is not asymmetrical if both fangs end in 0", ()->{
        assertThat(SetOfFangs.create(10, 20).isAsymmetrical()).isFalse();
      });
    });
  }
}
