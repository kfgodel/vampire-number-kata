import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by tenpines on 23/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class FangTest extends JavaSpec<VampireTestContext> {
  @Override
  public void define() {
    describe("a fang number", ()->{
      it("can answer if it ends with 0", ()->{
        assertThat(Fang.create(22).hasTrailingZero()).isFalse();
        assertThat(Fang.create(20).hasTrailingZero()).isTrue();
      });
    });
  }
}
