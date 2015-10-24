import ar.com.dgarcia.javaspec.api.TestContext;

import java.util.function.Supplier;

/**
 * Created by tenpines on 23/10/15.
 */
public interface VampireTestContext extends TestContext {

  VampireCalculator calculator();
  void calculator(Supplier<VampireCalculator> definition);
}
