/*
 * Decompiled with CFR 0.152.
 */
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class hryi
extends Formatter {
    private SimpleDateFormat _a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String format(LogRecord logRecord) {
        Date date = new Date(logRecord.getMillis());
        String string = this._a.format(date);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string).append(" [").append(logRecord.getLevel()).append("] ").append(logRecord.getMessage()).append("\n");
        Throwable throwable = logRecord.getThrown();
        if (throwable != null) {
            StringWriter stringWriter = new StringWriter();
            throwable.printStackTrace(new PrintWriter(stringWriter));
            stringBuilder.append(stringWriter.toString());
        }
        return stringBuilder.toString();
    }
}

