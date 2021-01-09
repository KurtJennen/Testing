package chapter06.excel;

import static org.junit.Assert.assertEquals;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
public class ReadExcelTest {

	@Test
	@DataLoader(filePaths = "chapter06/excel/financial.xls", loaderType = LoaderType.EXCEL)
	public void shouldCalculateDiscount(@Param(name="value") String value, @Param(name="discount") String discount) {
		assertEquals(Double.parseDouble(discount), DiscountCalculator.calculateDiscount(Double.parseDouble(value)), 0.0001);
	}
}
