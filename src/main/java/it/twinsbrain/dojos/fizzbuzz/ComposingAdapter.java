package it.twinsbrain.dojos.fizzbuzz;

public class ComposingAdapter implements ChainedAdapter{


  private final ChainedAdapter first;
  private final ChainedAdapter second;

  public ComposingAdapter(ChainedAdapter first, ChainedAdapter second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public boolean canAdapt(int val) {
    return first.canAdapt(val) && second.canAdapt(val);
  }

  @Override
  public String adapt(int val) {
    return first.adapt(val) + second.adapt(val);
  }
}
