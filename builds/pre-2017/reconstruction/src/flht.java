/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import znw.mods.auction.AuctionMod;

public class flht
extends zwat {
    private String _a;
    private int _b;

    public flht(String string) {
        this._a = "";
        this._b = 0;
        this._a = string;
    }

    public flht(int n) {
        this._a = "";
        this._b = 0;
        this._b = n;
    }

    @Override
    public void processClient(boolean bl) {
        AuctionMod.instance._b = this._b;
    }

    public flht() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeInt(this._b);
    }
}

