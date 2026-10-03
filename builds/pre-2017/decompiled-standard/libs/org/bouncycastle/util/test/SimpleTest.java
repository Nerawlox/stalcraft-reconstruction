/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.util.test;

import java.io.PrintStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.test.SimpleTestResult;
import org.bouncycastle.util.test.Test;
import org.bouncycastle.util.test.TestFailedException;
import org.bouncycastle.util.test.TestResult;

public abstract class SimpleTest
implements Test {
    public abstract String getName();

    private TestResult success() {
        return SimpleTestResult.successful(this, "Okay");
    }

    protected void fail(String string) {
        throw new TestFailedException(SimpleTestResult.failed(this, string));
    }

    protected void fail(String string, Throwable throwable) {
        throw new TestFailedException(SimpleTestResult.failed(this, string, throwable));
    }

    protected void fail(String string, Object object, Object object2) {
        throw new TestFailedException(SimpleTestResult.failed(this, string, object, object2));
    }

    protected boolean areEqual(byte[] byArray, byte[] byArray2) {
        return Arrays.areEqual(byArray, byArray2);
    }

    public TestResult perform() {
        try {
            this.performTest();
            return this.success();
        }
        catch (TestFailedException testFailedException) {
            return testFailedException.getResult();
        }
        catch (Exception exception) {
            return SimpleTestResult.failed(this, "Exception: " + exception, exception);
        }
    }

    protected static void runTest(Test test) {
        SimpleTest.runTest(test, System.out);
    }

    protected static void runTest(Test test, PrintStream printStream) {
        TestResult testResult = test.perform();
        printStream.println(((Object)testResult).toString());
        if (testResult.getException() != null) {
            testResult.getException().printStackTrace(printStream);
        }
    }

    public abstract void performTest() throws Exception;
}

