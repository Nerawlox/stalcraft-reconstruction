/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class dwim
extends tuuw {
    public String _a;

    public dwim(String string) {
        this._a = string;
    }

    public dwim() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
        this._a = dataInput.readUTF();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
        dataOutput.writeUTF(this._a);
    }
}

