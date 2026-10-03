/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.relauncher;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

final class FMLLogFormatter
extends Formatter {
    static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    FMLLogFormatter() {
    }

    @Override
    public String format(LogRecord logRecord) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.dateFormat.format(logRecord.getMillis()));
        Level level = logRecord.getLevel();
        String string = level.getLocalizedName();
        if (string == null) {
            string = level.getName();
        }
        if (string != null && string.length() > 0) {
            stringBuilder.append(" [" + string + "] ");
        } else {
            stringBuilder.append(" ");
        }
        if (logRecord.getLoggerName() != null) {
            stringBuilder.append("[" + logRecord.getLoggerName() + "] ");
        } else {
            stringBuilder.append("[] ");
        }
        stringBuilder.append(this.formatMessage(logRecord));
        stringBuilder.append(LINE_SEPARATOR);
        Throwable throwable = logRecord.getThrown();
        if (throwable != null) {
            StringWriter stringWriter = new StringWriter();
            throwable.printStackTrace(new PrintWriter(stringWriter));
            stringBuilder.append(stringWriter.toString());
        }
        return stringBuilder.toString();
    }
}

