/*
 * Decompiled with CFR 0.152.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

public class ezey
extends pidb {
    protected int _b;
    protected long _c;
    protected long _d;
    protected long _e;
    protected Date _f;
    protected Date _g;
    protected Date _h;
    protected String _i;
    protected String _j;
    protected String _k;
    protected long _l;

    public static ezey _a(String string, ResultSet resultSet) {
        try {
            ezey ezey2 = new ezey();
            ezey2._a(ezey._a(resultSet, "lots_id"));
            ezey2._b(ezey._d(resultSet, "lots_price_step"));
            ezey2._c(ezey._d(resultSet, "lots_price_max"));
            ezey2._a(ezey._d(resultSet, "lots_price_start"));
            ezey2._d(ezey._d(resultSet, "bids_current_price"));
            ezey2._a(ezey._e(resultSet, "lots_category"));
            ezey2._b(ezey._e(resultSet, "lots_data"));
            ezey2._b(ezey._f(resultSet, "lots_date_start"));
            ezey2._c(ezey._f(resultSet, "lots_date_end"));
            if (string == null) {
                ezey2._c("");
            } else {
                ezey2._c(string);
            }
            return ezey2;
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

    public Date _a() {
        return this._h;
    }

    public void _a(Date date) {
        this._h = date;
    }

    public int _b() {
        return this._b;
    }

    public void _a(int n) {
        this._b = n;
    }

    public long _c() {
        return this._c;
    }

    public long _d() {
        return this._d;
    }

    public long _e() {
        return this._e;
    }

    public void _a(long l) {
        this._c = l;
    }

    public void _b(long l) {
        this._d = l;
    }

    public void _c(long l) {
        this._e = l;
    }

    public Date _f() {
        return this._f;
    }

    public Date _g() {
        return this._g;
    }

    public void _b(Date date) {
        this._f = date;
    }

    public void _c(Date date) {
        this._g = date;
    }

    public String _h() {
        return this._i;
    }

    public void _a(String string) {
        this._i = string;
    }

    public String _i() {
        return this._j;
    }

    public void _b(String string) {
        this._j = string;
    }

    public String _j() {
        return this._k;
    }

    public void _c(String string) {
        this._k = string;
    }

    public long _k() {
        return this._l;
    }

    public void _d(long l) {
        this._l = l;
    }
}

