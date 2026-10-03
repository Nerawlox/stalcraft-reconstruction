/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import java.util.Map;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.storage.WorldInfo;

public interface WorldAccessContainer {
    public NBTTagCompound getDataForWriting(plxv var1, WorldInfo var2);

    public void readData(plxv var1, WorldInfo var2, Map<String, NBTBase> var3, NBTTagCompound var4);
}

