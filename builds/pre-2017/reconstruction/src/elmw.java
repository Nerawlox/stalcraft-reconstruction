/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import net.minecraft.world.storage.ThreadedFileIOBase;
import net.minecraft.world.storage.WorldInfo;

public class elmw
extends plxv {
    public elmw(File file, String string, boolean bl) {
        super(file, string, bl);
    }

    @Override
    public bcgt getChunkLoader(WorldProvider worldProvider) {
        File file = this._c();
        if (worldProvider._m() != null) {
            File file2 = new File(file, worldProvider._m());
            file2.mkdirs();
            return new AnvilChunkLoader(file2);
        }
        return new AnvilChunkLoader(file);
    }

    @Override
    public void saveWorldInfoWithPlayer(WorldInfo worldInfo, NBTTagCompound nBTTagCompound) {
        worldInfo._d(19133);
        super.saveWorldInfoWithPlayer(worldInfo, nBTTagCompound);
    }

    @Override
    public void flush() {
        try {
            ThreadedFileIOBase._a._b();
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        suyl._a();
    }
}

