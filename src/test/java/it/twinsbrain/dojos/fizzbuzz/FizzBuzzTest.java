package it.twinsbrain.dojos.fizzbuzz;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest {

  @Test
  @Parameters({
    "1, 1",
    "2, 2",
    "4, 4",
    "7, 7",
    "8, 8",
    "11, 11",
    "91, 91"
  })
  public void simpleStrings(int sample, String adapted) throws Exception {
    assertThat(FizzBuzz.of(sample), is(adapted));
  }

  @Test
  @Parameters({"3", "6", "9", "12", "18", "21", "24", "93"})
  public void fizzes(int sample) throws Exception {
    assertThat(FizzBuzz.of(sample), is("Fizz"));
  }

  @Test
  @Parameters({"5", "10", "20", "25"})
  public void buzzes(int sample) throws Exception {
    assertThat(FizzBuzz.of(sample), is("Buzz"));
  }

  @Test
  @Parameters({"15", "30", "45", "60", "90"})
  public void fizzBuzzes(int sample) throws Exception {
    assertThat(FizzBuzz.of(sample), is("FizzBuzz"));
  }
}
