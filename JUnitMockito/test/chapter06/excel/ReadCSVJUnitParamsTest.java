package chapter06.excel;

import static org.junit.Assert.assertEquals;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ReadCSVJUnitParamsTest {

	@Test
	@FileParameters(value = "file:E:/Java/TestNew/JUnitMockito/test/chapter06/excel/financial.csv", mapper = CsvWithHeaderMapper.class)
	public void shouldCalculateDiscount(double value, double discount) {
		assertEquals(discount, DiscountCalculator.calculateDiscount(value), 0.0001);
	}
	
}
