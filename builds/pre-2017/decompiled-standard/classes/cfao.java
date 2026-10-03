/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class cfao
extends ozhc {
    public File _a;
    public File _b;

    public cfao(ujth ujth2) {
        super(ujth2);
        this._a = ujth2._i("ops.txt");
        this._b = ujth2._i("white-list.txt");
        this._m = ujth2._a("view-distance", 10);
        this._l = ujth2._a("max-players", 20);
        this._a(ujth2._a("white-list", false));
        if (!ujth2._N()) {
            this._l()._a(true);
            this._m()._a(true);
        }
        this._l()._d();
        this._l()._e();
        this._m()._d();
        this._m()._e();
        this._b();
        this._d();
        this._z_();
        if (!this._b.exists()) {
            this._e();
        }
    }

    @Override
    public void _a(boolean bl) {
        super._a(bl);
        this._f()._a("white-list", (Object)bl);
        this._f()._a();
    }

    @Override
    public void _a(String string) {
        super._a(string);
        this._z_();
    }

    @Override
    public void _b(String string) {
        super._b(string);
        this._z_();
    }

    @Override
    public void _c(String string) {
        super._c(string);
        this._e();
    }

    @Override
    public void _d(String string) {
        super._d(string);
        this._e();
    }

    @Override
    public void _a() {
        this._d();
    }

    public void _b() {
        try {
            this._p().clear();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this._a));
            String string = "";
            while ((string = bufferedReader.readLine()) != null) {
                this._p().add(string.trim().toLowerCase());
            }
            bufferedReader.close();
        }
        catch (Exception exception) {
            this._f()._O()._b("Failed to load operators list: " + exception);
        }
    }

    public void _z_() {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(this._a, false));
            for (String string : this._p()) {
                printWriter.println(string);
            }
            printWriter.close();
        }
        catch (Exception exception) {
            this._f()._O()._b("Failed to save operators list: " + exception);
        }
    }

    public void _d() {
        try {
            this._o().clear();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this._b));
            String string = "";
            while ((string = bufferedReader.readLine()) != null) {
                this._o().add(string.trim().toLowerCase());
            }
            bufferedReader.close();
        }
        catch (Exception exception) {
            this._f()._O()._b("Failed to load white-list: " + exception);
        }
    }

    public void _e() {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(this._b, false));
            for (String string : this._o()) {
                printWriter.println(string);
            }
            printWriter.close();
        }
        catch (Exception exception) {
            this._f()._O()._b("Failed to save white-list: " + exception);
        }
    }

    @Override
    public boolean _e(String string) {
        string = string.trim().toLowerCase();
        return !this._t() || this._g(string) || this._o().contains(string);
    }

    public ujth _f() {
        return (ujth)super._g();
    }

    @Override
    public /* synthetic */ dzfd _g() {
        return this._f();
    }
}

