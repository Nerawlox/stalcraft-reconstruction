/*
 * Decompiled with CFR 0.152.
 */
package gr.zdimensions.jsquish.test;

import gr.zdimensions.jsquish.test.SquishTest;
import org.lwjgl.Sys;

final class ErrorUtil {
    private static final StringBuilder buffer = new StringBuilder(512);

    private ErrorUtil() {
    }

    public static void errorKillEngine(Throwable t) {
        ErrorUtil.errorKillEngine("Unexpected Error", t);
    }

    public static void errorKillEngine(String title, Throwable t) {
        ErrorUtil.errorKillEngine(title, ErrorUtil.errorGetMessage(t, title));
    }

    public static void errorKillEngine(String title, String message) {
        Sys.alert(title, message);
        SquishTest.quit(false);
    }

    public static String errorGetMessage(Throwable t) {
        return ErrorUtil.errorGetMessage(t, null);
    }

    public static String errorGetMessage(Throwable t, String message) {
        StringBuilder buffer = ErrorUtil.buffer;
        buffer.setLength(0);
        buffer.append("\n-----------------------------[ EXCEPTION ]-----------------------------\n");
        if (message != null) {
            buffer.append(message);
            buffer.append("\n-----------------------------------------------------------------------\n");
        }
        buffer.append("INTERNAL ERROR ---[ ").append(t.getClass().getName()).append(" ]---\n");
        String tMessage = t.getMessage();
        if (tMessage != null) {
            buffer.append('\n').append(tMessage).append('\n');
        }
        buffer.append('\n');
        StackTraceElement[] stackTrace = t.getStackTrace();
        buffer.append("ERROR PATH:\n");
        StackTraceElement[] stackTraceElementArray = stackTrace;
        int n = stackTrace.length;
        int n2 = 0;
        while (n2 < n) {
            StackTraceElement e = stackTraceElementArray[n2];
            ErrorUtil.append(e, buffer);
            ++n2;
        }
        block1: while ((t = t.getCause()) != null) {
            buffer.append("\nCAUSED BY \"").append(t.getClass().getName()).append("\":\n");
            tMessage = t.getMessage();
            buffer.append(tMessage != null ? tMessage : "N/A");
            buffer.append("\n\n");
            StackTraceElement[] causeStackTrace = t.getStackTrace();
            buffer.append("ERROR PATH:\n");
            StackTraceElement[] stackTraceElementArray2 = causeStackTrace;
            int n3 = causeStackTrace.length;
            n = 0;
            while (n < n3) {
                StackTraceElement e = stackTraceElementArray2[n];
                if (e.equals(stackTrace[0])) continue block1;
                ErrorUtil.append(e, buffer);
                ++n;
            }
        }
        buffer.append("-----------------------------------------------------------------------\n");
        System.err.println(buffer.toString());
        return buffer.toString();
    }

    private static void append(StackTraceElement element, StringBuilder buffer) {
        String fileName;
        buffer.append(element.getClassName()).append('.').append(element.getMethodName());
        if (element.isNativeMethod()) {
            buffer.append(" [ Native Method ]");
        }
        if ((fileName = element.getFileName()) != null) {
            buffer.append(" [ ").append(fileName);
            int lineNumber = element.getLineNumber();
            if (lineNumber >= 0) {
                buffer.append(" :: ").append(lineNumber);
            }
            buffer.append(" ]");
        } else {
            buffer.append(" [ Unknown Source ]");
        }
        buffer.append('\n');
    }
}

