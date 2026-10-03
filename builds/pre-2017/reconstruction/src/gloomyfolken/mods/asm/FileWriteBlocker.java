/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.asm;

import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.HookPriority;
import gloomyfolken.hooklib.asm.ReturnCondition;
import java.io.DataOutputStream;
import java.io.File;
import net.minecraft.server.dedicated.PropertyManager;
import net.minecraft.server.management.BanList;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import net.minecraftforge.common.Configuration;
import org.apache.commons.io.output.NullOutputStream;

public class FileWriteBlocker {
    public static final boolean _a = System.getProperty("block_file_write", "false").equals("true");

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean save(Configuration configuration) {
        return _a;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean saveProperties(PropertyManager propertyManager) {
        return _a;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean saveToFile(BanList banList, boolean bl) {
        return _a;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean safeSaveChunk(fotf fotf2, Chunk chunk) {
        return _a;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean safeSaveExtraChunkData(fotf fotf2, Chunk chunk) {
        return _a;
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static boolean canSave(fotf fotf2) {
        return !_a && !fotf2._h.field_73058_d;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean setSessionLock(plxv plxv2) {
        return _a;
    }

    @Hook
    public static void checkSessionLock(plxv plxv2) throws xcad {
        if (_a) {
            throw new xcad("Server is running in no-write mode!");
        }
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, booleanReturnConstant=false)
    public static boolean chunkExists(AnvilChunkLoader anvilChunkLoader, World world, int n, int n2) {
        return FileWriteBlocker.getChunkInputStream(null, anvilChunkLoader._d, n, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Hook(returnCondition=ReturnCondition.ON_TRUE, returnNull=true, priority=HookPriority.HIGHEST)
    public static boolean getChunkInputStream(suyl suyl2, File file, int n, int n2) {
        if (!_a) {
            return false;
        }
        File file2 = new File(file, "region");
        File file3 = new File(file2, "r." + (n >> 5) + "." + (n2 >> 5) + ".m\u0441\u0430");
        Class<suyl> clazz = suyl.class;
        synchronized (suyl.class) {
            nfjd nfjd2 = (nfjd)suyl._a.get(file3);
            if (nfjd2 != null) {
                // ** MonitorExit[var6_6] (shouldn't be in output)
                return false;
            }
            // ** MonitorExit[var6_6] (shouldn't be in output)
            return !file3.exists();
        }
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, returnAnotherMethod="getNullOutputStream")
    public static boolean getChunkOutputStream(suyl suyl2, File file, int n, int n2) {
        return _a;
    }

    public static DataOutputStream getNullOutputStream(suyl suyl2, File file, int n, int n2) {
        return new DataOutputStream(new NullOutputStream());
    }

    public static boolean getBlockFileWrite() {
        return _a;
    }
}

