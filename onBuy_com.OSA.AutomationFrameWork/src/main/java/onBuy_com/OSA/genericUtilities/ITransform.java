package onBuy_com.OSA.genericUtilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class ITransform  implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
	annotation.setRetryAnalyzer(onBuy_com.OSA.genericUtilities.RetryImplementation.class);	
	
	}

	
}
