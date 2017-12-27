package it.twinsbrain.dojos.fizzbuzz;

import java.util.Arrays;

import static java.lang.String.valueOf;
import static java.util.Arrays.stream;

public class FizzBuzz {

  private final ChainedAdapter[] adapters;

  public FizzBuzz(ChainedAdapter... adapters){
    this.adapters = adapters;
  }

  static String of(int i) {
    return new FizzBuzz(new StringAdapter()).valueFor(i);
  }

  public String valueFor(int i){
    return stream(adapters)
      .filter(adapter -> adapter.canAdapt(i))
      .findFirst()
      .map(adapter -> adapter.adapt(i)).get();
  }

  static class StringAdapter implements ChainedAdapter{

    @Override
    public String adapt(int val) {
      return valueOf(val);
    }

    @Override
    public boolean canAdapt(int val) {
      return true;
    }
  }
}
