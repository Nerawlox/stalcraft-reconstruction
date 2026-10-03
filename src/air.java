/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  agm
 *  ago
 *  ahi
 *  ahr
 *  ait
 *  aix
 */
import java.util.HashMap;
import java.util.Map;

public class air {
    private static Map a = new HashMap();
    private static Map b = new HashMap();
    private static Map c = new HashMap();
    private static Map d = new HashMap();

    public static void b(Class par0Class, String par1Str) {
        a.put(par1Str, par0Class);
        b.put(par0Class, par1Str);
    }

    public static void a(Class par0Class, String par1Str) {
        c.put(par1Str, par0Class);
        d.put(par0Class, par1Str);
    }

    public static String a(aiv par0StructureStart) {
        return (String)b.get(par0StructureStart.getClass());
    }

    public static String a(ait par0StructureComponent) {
        return (String)d.get(par0StructureComponent.getClass());
    }

    public static aiv a(by par0NBTTagCompound, abw par1World) {
        aiv structurestart = null;
        try {
            Class oclass = (Class)a.get(par0NBTTagCompound.i("id"));
            if (oclass != null) {
                structurestart = (aiv)oclass.newInstance();
            }
        }
        catch (Exception exception) {
            par1World.Y().b("Failed Start with id " + par0NBTTagCompound.i("id"));
            exception.printStackTrace();
        }
        if (structurestart != null) {
            structurestart.a(par1World, par0NBTTagCompound);
        } else {
            par1World.Y().b("Skipping Structure with id " + par0NBTTagCompound.i("id"));
        }
        return structurestart;
    }

    public static ait b(by par0NBTTagCompound, abw par1World) {
        ait structurecomponent = null;
        try {
            Class oclass = (Class)c.get(par0NBTTagCompound.i("id"));
            if (oclass != null) {
                structurecomponent = (ait)oclass.newInstance();
            }
        }
        catch (Exception exception) {
            par1World.Y().b("Failed Piece with id " + par0NBTTagCompound.i("id"));
            exception.printStackTrace();
        }
        if (structurecomponent != null) {
            structurecomponent.a(par1World, par0NBTTagCompound);
        } else {
            par1World.Y().b("Skipping Piece with id " + par0NBTTagCompound.i("id"));
        }
        return structurecomponent;
    }

    static {
        air.b(agm.class, "Mineshaft");
        air.b(aix.class, "Village");
        air.b(ago.class, "Fortress");
        air.b(ahr.class, "Stronghold");
        air.b(ahi.class, "Temple");
        agh.a();
        aiy.a();
        agp.a();
        ahs.a();
        ahj.a();
    }
}

