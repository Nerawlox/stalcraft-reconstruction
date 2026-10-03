/*
 * Decompiled with CFR 0.152.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class pidb {
    public static final DateFormat _a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    protected static int _a(ResultSet resultSet, Object object) throws SQLException {
        return resultSet.getInt(object.toString());
    }

    protected static float _b(ResultSet resultSet, Object object) throws SQLException {
        return resultSet.getFloat(object.toString());
    }

    protected static double _c(ResultSet resultSet, Object object) throws SQLException {
        return resultSet.getDouble(object.toString());
    }

    protected static long _d(ResultSet resultSet, Object object) throws SQLException {
        return resultSet.getLong(object.toString());
    }

    protected static String _e(ResultSet resultSet, Object object) throws SQLException {
        return resultSet.getString(object.toString());
    }

    protected static Date _f(ResultSet resultSet, Object object) throws SQLException, ParseException {
        return _a.parse(resultSet.getString(object.toString()));
    }
}

