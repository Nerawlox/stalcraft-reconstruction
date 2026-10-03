/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import net.minecraft.logging.LogAgent;

public class LogFormatter
extends Formatter {
    public SimpleDateFormat _a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final /* synthetic */ LogAgent _b;

    public LogFormatter(LogAgent logAgent) {
        this._b = logAgent;
    }

    @Override
    public String format(LogRecord logRecord) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this._a.format(logRecord.getMillis()));
        if (LogAgent._a(this._b) != null) {
            stringBuilder.append(LogAgent._a(this._b));
        }
        stringBuilder.append(" [").append(logRecord.getLevel().getName()).append("] ");
        stringBuilder.append(this.formatMessage(logRecord));
        stringBuilder.append('\n');
        Throwable throwable = logRecord.getThrown();
        if (throwable != null) {
            StringWriter stringWriter = new StringWriter();
            throwable.printStackTrace(new PrintWriter(stringWriter));
            stringBuilder.append(stringWriter.toString());
        }
        return stringBuilder.toString();
    }

    public /* synthetic */ LogFormatter(LogAgent logAgent, sdft sdft2) {
        this(logAgent);
    }
}

