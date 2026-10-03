/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class vmwh
extends Thread {
    public final /* synthetic */ ujth _a;

    public vmwh(ujth ujth2) {
        this._a = ujth2;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String string;
            while (!this._a.__af() && this._a._y() && (string = bufferedReader.readLine()) != null) {
                this._a._a(string, this._a);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

