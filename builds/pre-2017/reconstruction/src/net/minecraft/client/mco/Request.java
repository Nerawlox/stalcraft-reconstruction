/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.mco;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import net.minecraft.client.Minecraft;

public abstract class Request {
    public HttpURLConnection _a;
    public boolean _b;
    public String _c;

    public Request(String string, int n, int n2) {
        try {
            this._c = string;
            this._a = (HttpURLConnection)new URL(string).openConnection(Minecraft._E()._Q());
            this._a.setConnectTimeout(n);
            this._a.setReadTimeout(n2);
        }
        catch (Exception exception) {
            throw new htpz("Failed URL: " + string, exception);
        }
    }

    public void _a(String string, String string2) {
        String string3 = this._a.getRequestProperty("Cookie");
        if (string3 == null) {
            this._a.setRequestProperty("Cookie", string + "=" + string2);
        } else {
            this._a.setRequestProperty("Cookie", string3 + ";" + string + "=" + string2);
        }
    }

    public int _a() {
        try {
            this._e();
            return this._a.getResponseCode();
        }
        catch (Exception exception) {
            throw new htpz("Failed URL: " + this._c, exception);
        }
    }

    public int _b() {
        String string = this._a.getHeaderField("Retry-After");
        try {
            return Integer.valueOf(string);
        }
        catch (Exception exception) {
            return 5;
        }
    }

    public String _c() {
        try {
            this._e();
            String string = this._a() >= 400 ? this._a(this._a.getErrorStream()) : this._a(this._a.getInputStream());
            this._d();
            return string;
        }
        catch (IOException iOException) {
            throw new htpz("Failed URL: " + this._c, iOException);
        }
    }

    public String _a(InputStream inputStream) {
        if (inputStream == null) {
            throw new IOException("No response (null)");
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n = inputStream.read();
        while (n != -1) {
            stringBuilder.append((char)n);
            n = inputStream.read();
        }
        return stringBuilder.toString();
    }

    public void _d() {
        byte[] byArray = new byte[1024];
        try {
            int n = 0;
            InputStream inputStream = this._a.getInputStream();
            while ((n = inputStream.read(byArray)) > 0) {
            }
            inputStream.close();
        }
        catch (Exception exception) {
            try {
                InputStream inputStream = this._a.getErrorStream();
                int n = 0;
                while ((n = inputStream.read(byArray)) > 0) {
                }
                inputStream.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    public Request _e() {
        if (!this._b) {
            Request request = this._f();
            this._b = true;
            return request;
        }
        return this;
    }

    public abstract Request _f();

    public static Request _a(String string) {
        return new ifuh(string, 5000, 10000);
    }

    public static Request _b(String string, String string2) {
        return new gqpy(string, string2.getBytes(), 5000, 10000);
    }

    public static Request _a(String string, String string2, int n, int n2) {
        return new gqpy(string, string2.getBytes(), n, n2);
    }

    public static Request _b(String string) {
        return new zydl(string, 5000, 10000);
    }

    public static Request _c(String string, String string2) {
        return new yvee(string, string2.getBytes(), 5000, 10000);
    }

    public static Request _b(String string, String string2, int n, int n2) {
        return new yvee(string, string2.getBytes(), n, n2);
    }

    public int _g() {
        String string = this._a.getHeaderField("Error-Code");
        try {
            return Integer.valueOf(string);
        }
        catch (Exception exception) {
            return -1;
        }
    }
}

