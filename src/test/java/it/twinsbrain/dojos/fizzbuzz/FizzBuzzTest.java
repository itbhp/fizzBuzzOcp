package it.twinsbrain.dojos.fizzbuzz;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest {

  @Test
  public void oneAsString() throws Exception {
    assertThat(FizzBuzz.of(1), is("1"));
  }

  @Test
  @Parameters({"3", "6", "9", "12", "18", "21", "24", "93"})
  public void threeIsFizz(int sample) throws Exception {
    assertThat(FizzBuzz.of(sample), is("Fizz"));
  }

  @Test
  @Parameters({"5", "10", "20", "25"})
  public void fiveAsBuzz(int sample) throws Exception {
    assertThat(FizzBuzz.of(sample), is("Buzz"));
  }

  @Test
  @Parameters({"15", "30", "45", "60", "90"})
  public void fifteenIsFizzBuzz(int sample) throws Exception {
    assertThat(FizzBuzz.of(sample), is("FizzBuzz"));
  }
}
