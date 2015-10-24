import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by tenpines on 24/10/15.
 */
public class MainDetector {

  public static void main(String[] args){
    Iterator<VampireNumber> calculatedNumbers = VampireCalculator.create().calculate(9999).iterator();
    while(calculatedNumbers.hasNext()){
      VampireNumber number = calculatedNumbers.next();
      System.out.println("Number: " + number.getValue() + " fangs:[" + number.getLeftFang() + ", " + number.getRightFang() + "]");
    }
  }
}
