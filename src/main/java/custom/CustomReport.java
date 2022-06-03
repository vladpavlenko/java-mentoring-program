package custom;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.*;
import org.testng.xml.XmlSuite;

public class CustomReport implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                               String outputDirectory) {

        //Iterating over each suite included in the test
        for (ISuite suite : suites) {

            String suiteName = suite.getName();

            //Getting the results for the suite
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult sr : suiteResults.values()) {
                ITestContext tc = sr.getTestContext();
                List<ITestNGMethod> methodsWithCustomAnnotation = Arrays.stream(tc.getAllTestMethods())
                                .filter(ITestNGMethod -> ITestNGMethod
                                        .getConstructorOrMethod()
                                        .getMethod()
                                        .getAnnotation(MyAnnotation.class) != null)
                                        .collect(Collectors.toList());
                System.out.println("Total number of IU tests: " + methodsWithCustomAnnotation.size());
                System.out.println("UI test method names:");
                methodsWithCustomAnnotation.forEach(test -> System.out.println(test.getMethodName()));
            }
        }
    }
}
