package it.twinsbrain.dojos.fizzbuzz;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ComposingAdapterTest {

  private static final int ANY_VAL = 1;
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Mock
  private ChainedAdapter first;

  @Mock
  private ChainedAdapter second;

  private ComposingAdapter composingAdapter;

  @Before
  public void setUp() throws Exception {
    composingAdapter = new ComposingAdapter(first, second);
  }

  @Test
  public void firstCanAdapt() throws Exception {
    int value = ANY_VAL;
    context.checking(new Expectations() {{
      allowing(first).canAdapt(value); will(returnValue(true));
      allowing(second).canAdapt(value); will(returnValue(false));
    }});

    assertThat(composingAdapter.canAdapt(value), is(false));
  }

  @Test
  public void secondCanAdapt() throws Exception {
    int value = ANY_VAL;
    context.checking(new Expectations() {{
      allowing(first).canAdapt(value); will(returnValue(false));
      allowing(second).canAdapt(value); will(returnValue(true));
    }});

    assertThat(composingAdapter.canAdapt(value), is(false));
  }

  @Test
  public void bothCanAdapt() throws Exception {
    int value = ANY_VAL;
    context.checking(new Expectations() {{
      allowing(first).canAdapt(value); will(returnValue(true));
      allowing(second).canAdapt(value); will(returnValue(true));
    }});

    assertThat(composingAdapter.canAdapt(value), is(true));
  }

  @Test
  public void adaptedValueComposeFirstAndSecond() throws Exception {
    int value = ANY_VAL;
    context.checking(new Expectations() {{
      allowing(first).adapt(value); will(returnValue("Pippo"));
      allowing(second).adapt(value); will(returnValue("Baudo"));
    }});

    assertThat(composingAdapter.adapt(value), is("PippoBaudo"));
  }
}
