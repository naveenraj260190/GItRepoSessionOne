package packagetwo;

import java.util.List;

import org.junit.Test;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

public class ExcecuteAll {

	@Test
	public void report() {

		Result runClasses = JUnitCore.runClasses(SampleClassOne.class, SampleClassTwo.class);
		int runCount = runClasses.getRunCount();
		System.out.println("Result Count : " + runCount);

		int failureCount = runClasses.getFailureCount();
		System.out.println("Failure Count : " + failureCount);

		int ignoreCount = runClasses.getIgnoreCount();
		System.out.println("Ignore Count : " + ignoreCount);

		int pass = runCount - failureCount;
		System.out.println("Pass count : " + pass);

		long runTime = runClasses.getRunTime();
		System.out.println("Run Time : " + runTime + " ms");

		System.out.println("Run Count     : " + runClasses.getRunCount());
		System.out.println("Failure Count : " + runClasses.getFailureCount());
		System.out.println("Ignore Count  : " + runClasses.getIgnoreCount());
		System.out.println("Run Time      : " + runClasses.getRunTime() + " ms");
		System.out.println("Successful    : " + runClasses.wasSuccessful());

		List<Failure> failures = runClasses.getFailures();

		for (Failure x : failures) {
			System.out.println("Failures : " + x);

			String testHeader = x.getTestHeader();
			System.out.println("Test Header : " + testHeader);
			String replace = testHeader.replace("(org.JUnit.session3.SampleClassTwo)", "");
			System.out.println(replace);
			// Throwable exception = x.getException();
			// System.out.println(exception);
			// System.out.println("MESSAGE : "+x.getMessage());

			// System.out.println(x.getTrimmedTrace());

		}

	}

}
