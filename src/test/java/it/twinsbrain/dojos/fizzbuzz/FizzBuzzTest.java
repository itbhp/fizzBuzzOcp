package it.twinsbrain.dojos.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzTest {

  @Test
  public void oneAsString() throws Exception {
    assertThat(FizzBuzz.of(1), is("1"));
  }


}
