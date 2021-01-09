package chapter03;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class MoneyParameterizedTest {
	
	@SuppressWarnings({ "unused", "deprecation" })
	private static final Object[] getMoney() {
//		return new Object[] {
//			new Object[] {10, "USD"},
//			new Object[] {20, "USD"}
//		};
		return $(
				$(10, "USD"),
				$(20, "USD")
		);
	}

	@Test
	@Parameters(method="getMoney")
	public void constructorShouldSetAmountAndCurrency(int amount, String currency) {
		Money money = new Money(amount, currency);
		
		assertEquals(amount, money.getAmount());
		assertEquals(currency, money.getCurrency());
	}
	
}
