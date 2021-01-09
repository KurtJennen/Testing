package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.PojoValidator;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.NoNestedClassRule;
import com.openpojo.validation.rule.impl.NoPrimitivesRule;
import com.openpojo.validation.rule.impl.NoPublicFieldsRule;
import com.openpojo.validation.rule.impl.NoStaticExceptFinalRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.DefaultValuesNullTester;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public class PojoTest {
	private static final int EXPECTED_CLASS_COUNT = 1;
	
	private static final String POJO_PACKAGE = "pojo";
	
	private List<PojoClass> pojoClasses;
	private PojoValidator pojoValidator;
	
	@Before
	public void setup() {
		pojoClasses = PojoClassFactory.getPojoClasses(POJO_PACKAGE, new FilterPackageInfo());
		
		pojoValidator = new PojoValidator();
		
		pojoValidator.addRule(new NoPublicFieldsRule());
		pojoValidator.addRule(new NoPrimitivesRule());
		pojoValidator.addRule(new NoStaticExceptFinalRule());
		//pojoValidator.addRule(new NoFieldShadowingRule());
		pojoValidator.addRule(new GetterMustExistRule());
		pojoValidator.addRule(new SetterMustExistRule());
		pojoValidator.addRule(new NoNestedClassRule());
		//pojoValidator.addRule(new BusinessKeyMustExistRule());
		
        pojoValidator.addTester(new DefaultValuesNullTester());
        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        //pojoValidator.addTester(new BusinessIdentityTester());

	}
	
	@Test
	public void ensureExpectedPojoCount() {
		Affirm.affirmEquals("Classes addes / removed?", EXPECTED_CLASS_COUNT, pojoClasses.size());
	}
	
	@Test
	public void testPojoStructureAndBehavior() {
		for(PojoClass pojoClass: pojoClasses) {
			pojoValidator.runValidation(pojoClass);
		}
	}

}
