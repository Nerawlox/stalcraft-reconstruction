/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.utils;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

public class Printer {
    private static final String DEFAULT_INDENTATION_UNIT = "    ";
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    protected final Appendable out;
    private final int maxBlankLines;
    private String indent;
    private final String indentUnit;
    private int blankLineCountIncludingCurrent;
    private boolean withholdIndentOnce;

    public Printer(@NotNull Appendable out) {
        if (out == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "out", "kotlin/reflect/jvm/internal/impl/utils/Printer", "<init>"));
        }
        this(out, Integer.MAX_VALUE);
    }

    public Printer(@NotNull Appendable out, @NotNull String indentUnit) {
        if (out == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "out", "kotlin/reflect/jvm/internal/impl/utils/Printer", "<init>"));
        }
        if (indentUnit == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "indentUnit", "kotlin/reflect/jvm/internal/impl/utils/Printer", "<init>"));
        }
        this(out, Integer.MAX_VALUE, indentUnit);
    }

    public Printer(@NotNull Appendable out, int maxBlankLines) {
        if (out == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "out", "kotlin/reflect/jvm/internal/impl/utils/Printer", "<init>"));
        }
        this(out, maxBlankLines, DEFAULT_INDENTATION_UNIT);
    }

    public Printer(@NotNull Appendable out, int maxBlankLines, @NotNull String indentUnit) {
        if (out == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "out", "kotlin/reflect/jvm/internal/impl/utils/Printer", "<init>"));
        }
        if (indentUnit == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "indentUnit", "kotlin/reflect/jvm/internal/impl/utils/Printer", "<init>"));
        }
        this.indent = "";
        this.blankLineCountIncludingCurrent = 0;
        this.withholdIndentOnce = false;
        this.out = out;
        this.maxBlankLines = maxBlankLines;
        this.indentUnit = indentUnit;
    }

    private void append(Object o) {
        try {
            this.out.append(o.toString());
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    @NotNull
    public Printer println(Object ... objects) {
        this.print(objects);
        this.printLineSeparator();
        Printer printer = this;
        if (printer == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/Printer", "println"));
        }
        return printer;
    }

    private void printLineSeparator() {
        if (this.blankLineCountIncludingCurrent <= this.maxBlankLines) {
            ++this.blankLineCountIncludingCurrent;
            this.append(LINE_SEPARATOR);
        }
    }

    @NotNull
    public Printer print(Object ... objects) {
        if (this.withholdIndentOnce) {
            this.withholdIndentOnce = false;
        } else if (objects.length > 0) {
            this.printIndent();
        }
        this.printWithNoIndent(objects);
        Printer printer = this;
        if (printer == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/Printer", "print"));
        }
        return printer;
    }

    public void printIndent() {
        this.append(this.indent);
    }

    @NotNull
    public Printer printWithNoIndent(Object ... objects) {
        for (Object object : objects) {
            this.blankLineCountIncludingCurrent = 0;
            this.append(object);
        }
        Printer printer = this;
        if (printer == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/Printer", "printWithNoIndent"));
        }
        return printer;
    }

    @NotNull
    public Printer withholdIndentOnce() {
        this.withholdIndentOnce = true;
        Printer printer = this;
        if (printer == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/Printer", "withholdIndentOnce"));
        }
        return printer;
    }

    @NotNull
    public Printer printlnWithNoIndent(Object ... objects) {
        this.printWithNoIndent(objects);
        this.printLineSeparator();
        Printer printer = this;
        if (printer == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/Printer", "printlnWithNoIndent"));
        }
        return printer;
    }

    @NotNull
    public Printer pushIndent() {
        this.indent = this.indent + this.indentUnit;
        Printer printer = this;
        if (printer == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/Printer", "pushIndent"));
        }
        return printer;
    }

    @NotNull
    public Printer popIndent() {
        if (this.indent.length() < this.indentUnit.length()) {
            throw new IllegalStateException("No indentation to pop");
        }
        this.indent = this.indent.substring(this.indentUnit.length());
        Printer printer = this;
        if (printer == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/Printer", "popIndent"));
        }
        return printer;
    }

    @NotNull
    public Printer separated(Object separator, Object ... items) {
        for (int i = 0; i < items.length; ++i) {
            if (i > 0) {
                this.printlnWithNoIndent(separator);
            }
            this.printlnWithNoIndent(items[i]);
        }
        Printer printer = this;
        if (printer == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/Printer", "separated"));
        }
        return printer;
    }

    @NotNull
    public Printer separated(Object separator, Collection<?> items) {
        Iterator<?> iterator2 = items.iterator();
        while (iterator2.hasNext()) {
            this.printlnWithNoIndent(iterator2.next());
            if (!iterator2.hasNext()) continue;
            this.printlnWithNoIndent(separator);
        }
        Printer printer = this;
        if (printer == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/Printer", "separated"));
        }
        return printer;
    }
}

