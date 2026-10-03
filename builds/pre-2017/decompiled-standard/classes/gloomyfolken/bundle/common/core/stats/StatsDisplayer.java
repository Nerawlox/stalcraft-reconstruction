/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.bundle.common.core.stats;

import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.bundle.common.core.stats.StatsType;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public interface StatsDisplayer {
    public String format(Stat var1, Object var2);

    public static StatsDisplayer formatted(String string) {
        return (stat, object) -> object != null ? String.format(string, object) : null;
    }

    public static StatsDisplayer basic() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        return (stat, object) -> {
            if (object == null) {
                return null;
            }
            switch (stat.type) {
                case DATE: {
                    return dateTimeFormatter.format((Instant)object);
                }
                case DURATION: {
                    return String.format("%.1f \u0447.", ((Long)object).doubleValue() / 3600000.0);
                }
                case DECIMAL: {
                    return String.format("%.2f", (double)((Double)object));
                }
            }
            return String.valueOf(object);
        };
    }

    public static StatsDisplayer distance() {
        return (stat, object) -> {
            if (stat.type != StatsType.DECIMAL) {
                throw new IllegalArgumentException("Only decimals supported");
            }
            double d = (Double)object;
            double d2 = d / 100.0;
            double d3 = d2 / 1000.0;
            return d3 > 0.5 ? String.format("%.2f \u043a\u043c", d3) : (d2 > 0.5 ? String.format("%.2f \u043c.", d2) : String.format("%.2f \u0441\u043c.", d));
        };
    }

    public static StatsDisplayer money() {
        return (stat, object) -> {
            if (stat.type != StatsType.INTEGER) {
                throw new IllegalArgumentException("Only integers are supported");
            }
            return NumberFormat.getNumberInstance(Locale.ENGLISH).format(((Integer)object).intValue()) + " \u0440\u0443\u0431.";
        };
    }
}

