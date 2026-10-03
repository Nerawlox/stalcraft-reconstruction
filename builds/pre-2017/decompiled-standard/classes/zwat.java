/*
 * Decompiled with CFR 0.152.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

public class zwat
extends pidb {
    protected String _b;
    protected String _c;
    protected String _d;
    protected String _e;
    protected String _f;
    protected String _g;
    protected String _h;
    protected Date _i;
    protected int _j;

    public static zwat _a(String string, ResultSet resultSet) {
        try {
            zwat zwat2 = new zwat();
            zwat2._a(zwat._a(resultSet, "messages_id"));
            zwat2._b(zwat._e(resultSet, "messages_message"));
            zwat2._a(zwat._e(resultSet, "messages_topic"));
            zwat2._d(string);
            zwat2._f(zwat._e(resultSet, "mailbox_folder"));
            zwat2._e(zwat._e(resultSet, "messages_attachment"));
            zwat2._c(zwat._e(resultSet, "users_username"));
            zwat2._g(zwat._e(resultSet, "messages_category"));
            zwat2._a(zwat._f(resultSet, "messages_date"));
            return zwat2;
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
            return null;
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
            return null;
        }
    }

    public static zwat _a(ResultSet resultSet) {
        try {
            zwat zwat2 = new zwat();
            zwat2._a(zwat._a(resultSet, "messages_id"));
            zwat2._b("");
            zwat2._a(zwat._e(resultSet, "messages_topic"));
            zwat2._d("");
            zwat2._f("");
            zwat2._e("");
            zwat2._g(zwat._e(resultSet, "messages_category"));
            zwat2._c(zwat._e(resultSet, "users_username"));
            zwat2._a(zwat._f(resultSet, "messages_date"));
            return zwat2;
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
            return null;
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
            return null;
        }
    }

    public String _a() {
        return qlgf._a(this);
    }

    public String _b() {
        return this._b;
    }

    public String _c() {
        return this._c;
    }

    public String _d() {
        return this._d;
    }

    public String _e() {
        return this._e;
    }

    public String _f() {
        return this._f;
    }

    public void _a(String string) {
        this._b = string;
    }

    public void _b(String string) {
        this._c = string;
    }

    public void _c(String string) {
        this._d = string;
    }

    public void _d(String string) {
        this._e = string;
    }

    public void _e(String string) {
        this._f = string;
    }

    public String _g() {
        return this._g;
    }

    public String _h() {
        return this._h;
    }

    public void _f(String string) {
        this._g = string;
    }

    public void _g(String string) {
        this._h = string;
    }

    public Date _i() {
        return this._i;
    }

    public void _a(Date date) {
        this._i = date;
    }

    public int _j() {
        return this._j;
    }

    public void _a(int n) {
        this._j = n;
    }
}

