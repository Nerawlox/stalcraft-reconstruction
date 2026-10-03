/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.GloomyCore;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class wnsq
extends cezg {
    public String _a;

    public wnsq() {
    }

    public wnsq(String string) {
        this._a = string;
    }

    @Override
    public void func_73267_a(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
    }

    @Override
    public void func_73279_a(elai elai2) {
        if (elai2 instanceof yezc) {
            yezc yezc2 = (yezc)elai2;
            String string = yezc2._g;
            if (string.startsWith("Test-") && GloomyCore.instance.testSession != null && GloomyCore.instance.testSession.equals(this._a)) {
                yezc2._j = true;
                yezc2._h = true;
            }
        }
    }

    @Override
    public int func_73284_a() {
        return this._a.length() + 2;
    }
}

