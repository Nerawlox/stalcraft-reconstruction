/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class owne {
    protected Properties _a = new Properties();

    protected owne(String string) {
        String string2 = string + ".properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(string2);
            this._a.load(fileInputStream);
            ((InputStream)fileInputStream).close();
        }
        catch (IOException iOException) {
            throw new RuntimeException("Can't load properties file!", iOException);
        }
    }

    @NotNull
    protected String _a(String string) {
        String string2 = this._a(string, "");
        if (string2 == null) {
            owne._a(0);
        }
        return string2;
    }

    private String _c(String string, String string2) {
        String string3 = System.getProperty("config." + string);
        if (string3 == null) {
            return this._a.getProperty(string, string2);
        }
        return string3;
    }

    @NotNull
    protected String _a(String string, String string2) {
        String string3 = this._c(string, string2);
        if (string3 == null) {
            owne._a(1);
        }
        return string3;
    }

    protected int _b(String string) {
        return this._a(string, 0);
    }

    protected int _a(String string, int n) {
        return Integer.valueOf(this._c(string, String.valueOf(n)));
    }

    protected boolean _c(String string) {
        return this._a(string, false);
    }

    protected boolean _a(String string, boolean bl) {
        return Boolean.valueOf(this._c(string, String.valueOf(bl)));
    }

    @Nullable
    protected kjui _d(String string) {
        return this._b(string, "sql");
    }

    @Nullable
    protected kjui _b(String string, String string2) {
        if (this._c(string + "_" + string2 + "_address", null) != null) {
            String string3 = string + "_" + string2;
            return new kjui(this._a(string3 + "_address"), this._a(string3 + "_database"), this._a(string3 + "_username"), this._a(string3 + "_password"));
        }
        return null;
    }

    private static /* synthetic */ void _a(int n) {
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "gloomyfolken/core/service/Configuration", "getString"));
    }

    public static class kjui {
        public String _a;
        public String _b;
        public String _c;
        public String _d;

        public kjui(String string, String string2, String string3, String string4) {
            this._a = string;
            this._b = string2;
            this._c = string3;
            this._d = string4;
        }
    }
}

