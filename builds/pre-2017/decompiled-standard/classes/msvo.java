/*
 * Decompiled with CFR 0.152.
 */
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class msvo
extends Formatter {
    public SimpleDateFormat _a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final /* synthetic */ xbsz _b;

    public msvo(xbsz xbsz2) {
        this._b = xbsz2;
    }

    @Override
    public String format(LogRecord logRecord) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this._a.format(logRecord.getMillis()));
        if (xbsz._a(this._b) != null) {
            stringBuilder.append(xbsz._a(this._b));
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

    public /* synthetic */ msvo(xbsz xbsz2, sdft sdft2) {
        this(xbsz2);
    }
}

