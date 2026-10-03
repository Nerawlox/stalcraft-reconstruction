/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public abstract class owha
extends tuuw {
    public String _b;

    public owha(String string) {
        this._b = string;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._b);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._b = dataInput.readUTF();
    }

    public owha() {
    }
}

