/*
 * Decompiled with CFR 0.152.
 */
package codechicken.obfuscator;

import codechicken.obfuscator.ILogStreams;
import java.io.PrintStream;

public class SystemLogStreams
implements ILogStreams {
    public static SystemLogStreams inst = new SystemLogStreams();

    @Override
    public PrintStream err() {
        return System.err;
    }

    @Override
    public PrintStream out() {
        return System.out;
    }
}

