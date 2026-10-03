/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureMineshaftPieces;
import net.minecraft.world.gen.structure.StructureNetherBridgePieces;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;
import net.minecraft.world.gen.structure.StructureVillageStart;

public class cfps {
    public static Map _a = new HashMap();
    public static Map _b = new HashMap();
    public static Map _c = new HashMap();
    public static Map _d = new HashMap();

    public static void _a(Class clazz, String string) {
        _a.put(string, clazz);
        _b.put(clazz, string);
    }

    public static void _b(Class clazz, String string) {
        _c.put(string, clazz);
        _d.put(clazz, string);
    }

    public static String _a(tycc tycc2) {
        return (String)_b.get(tycc2.getClass());
    }

    public static String _a(StructureComponent structureComponent) {
        return (String)_d.get(structureComponent.getClass());
    }

    public static tycc _a(NBTTagCompound nBTTagCompound, World world) {
        tycc tycc2 = null;
        try {
            Class clazz = (Class)_a.get(nBTTagCompound._j("id"));
            if (clazz != null) {
                tycc2 = (tycc)clazz.newInstance();
            }
        }
        catch (Exception exception) {
            world.getWorldLogAgent()._b("Failed Start with id " + nBTTagCompound._j("id"));
            exception.printStackTrace();
        }
        if (tycc2 != null) {
            tycc2._a(world, nBTTagCompound);
        } else {
            world.getWorldLogAgent()._b("Skipping Structure with id " + nBTTagCompound._j("id"));
        }
        return tycc2;
    }

    public static StructureComponent _b(NBTTagCompound nBTTagCompound, World world) {
        StructureComponent structureComponent = null;
        try {
            Class clazz = (Class)_c.get(nBTTagCompound._j("id"));
            if (clazz != null) {
                structureComponent = (StructureComponent)clazz.newInstance();
            }
        }
        catch (Exception exception) {
            world.getWorldLogAgent()._b("Failed Piece with id " + nBTTagCompound._j("id"));
            exception.printStackTrace();
        }
        if (structureComponent != null) {
            structureComponent._a(world, nBTTagCompound);
        } else {
            world.getWorldLogAgent()._b("Skipping Piece with id " + nBTTagCompound._j("id"));
        }
        return structureComponent;
    }

    static {
        cfps._a(yfou.class, "Mineshaft");
        cfps._a(StructureVillageStart.class, "Village");
        cfps._a(dzua.class, "Fortress");
        cfps._a(razs.class, "Stronghold");
        cfps._a(vnhh.class, "Temple");
        StructureMineshaftPieces._a();
        tybp._a();
        StructureNetherBridgePieces._a();
        StructureStrongholdPieces._a();
        ozsb._a();
    }
}

