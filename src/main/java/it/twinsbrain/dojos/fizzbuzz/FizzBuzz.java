package it.twinsbrain.dojos.fizzbuzz;

import static java.lang.String.valueOf;
import static org.eclipse.collections.impl.utility.ArrayIterate.select;

public class FizzBuzz {

  private final ChainedAdapter[] adapters;

  public FizzBuzz(ChainedAdapter... adapters){
    this.adapters = adapters;
  }

  static String of(int i) {
    return new FizzBuzz
      (
        new BuzzAdapter()
      , new FizzAdapter()
      , new StringAdapter()
      ).valueFor(i);
  }

  public String valueFor(int i){
    return select(adapters, adapter -> adapter.canAdapt(i))
      .getFirst()
      .adapt(i);
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

  static class FizzAdapter implements ChainedAdapter{

    @Override
    public boolean canAdapt(int val) {
      return val % 3 == 0;
    }

    @Override
    public String adapt(int val) {
      return "Fizz";
    }
  }

  static class BuzzAdapter implements ChainedAdapter{

    @Override
    public boolean canAdapt(int val) {
      return val == 5;
    }

    @Override
    public String adapt(int val) {
      return "Buzz";
    }
  }
}
