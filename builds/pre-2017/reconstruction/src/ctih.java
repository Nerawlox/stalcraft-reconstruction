/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

public interface ctih {
    public void write(@NotNull DataOutput var1) throws IOException;

    public void read(@NotNull DataInput var1) throws IOException;

    default public boolean _a() {
        return false;
    }
}

