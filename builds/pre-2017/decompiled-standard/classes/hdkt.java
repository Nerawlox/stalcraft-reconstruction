/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import mods.chat.ChatHooks;
import org.apache.commons.lang3.StringUtils;

public class hdkt
extends cezg {
    public String _a;

    public hdkt() {
    }

    public hdkt(String string) {
        this._a = string;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = hdkt.func_73282_a(dataInput, Short.MAX_VALUE);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        hdkt.func_73271_a(StringUtils.substring(this._a, 0, Short.MAX_VALUE), dataOutput);
    }

    @Override
    public void func_73279_a(elai elai2) {
        boolean bl = ChatHooks.processPacket(this, elai2);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        elai2.func_72461_a(this);
    }

    @Override
    public int func_73284_a() {
        return 2 + this._a.length() * 2;
    }

    public String _a() {
        return this._a;
    }

    @Override
    public boolean func_73278_e() {
        return true;
    }

    @Override
    public boolean func_73268_a(cezg cezg2) {
        return true;
    }
}

