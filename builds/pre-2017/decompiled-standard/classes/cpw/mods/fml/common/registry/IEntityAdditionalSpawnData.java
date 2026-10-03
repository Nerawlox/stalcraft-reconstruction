/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.registry;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

public interface IEntityAdditionalSpawnData {
    public void writeSpawnData(ByteArrayDataOutput var1);

    public void readSpawnData(ByteArrayDataInput var1);
}

