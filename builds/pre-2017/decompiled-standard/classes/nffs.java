/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLLog;
import gloomyfolken.mods.asm.GloomyHooks;
import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import net.minecraft.entity.Entity;
import net.minecraft.entity.jgro;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.ChunkDataEvent;

public class nffs
implements bcgt,
kngp {
    public List _a = new ArrayList();
    public Set _b = new HashSet();
    public Object _c = new Object();
    public final File _d;

    public nffs(File file) {
        this._d = file;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ixzi _a(ozlu ozlu2, int n, int n2) throws IOException {
        qoac qoac2 = null;
        jjym jjym2 = new jjym(n, n2);
        Object object = this._c;
        Object object2 = this._c;
        synchronized (object2) {
            if (this._b.contains(jjym2)) {
                for (int i = 0; i < this._a.size(); ++i) {
                    if (!((dzlk)this._a.get((int)i))._a.equals(jjym2)) continue;
                    qoac2 = ((dzlk)this._a.get((int)i))._b;
                    break;
                }
            }
        }
        if (qoac2 == null) {
            object2 = suyl._b(this._d, n, n2);
            if (object2 == null) {
                return null;
            }
            qoac2 = bsvf._a((DataInput)object2);
        }
        return this._a(ozlu2, n, n2, qoac2);
    }

    public ixzi _a(ozlu ozlu2, int n, int n2, qoac qoac2) {
        if (!qoac2._c("Level")) {
            ozlu2.func_98180_V()._c("Chunk file at " + n + "," + n2 + " is missing level data, skipping");
            return null;
        }
        if (!qoac2._m("Level")._c("Sections")) {
            ozlu2.func_98180_V()._c("Chunk file at " + n + "," + n2 + " is missing block data, skipping");
            return null;
        }
        ixzi ixzi2 = this._a(ozlu2, qoac2._m("Level"));
        if (!ixzi2._a(n, n2)) {
            ozlu2.func_98180_V()._c("Chunk file at " + n + "," + n2 + " is in the wrong location; relocating. (Expected " + n + ", " + n2 + ", got " + ixzi2._i + ", " + ixzi2._j + ")");
            qoac2._a("xPos", n);
            qoac2._a("zPos", n2);
            ixzi2 = this._a(ozlu2, qoac2._m("Level"));
        }
        MinecraftForge.EVENT_BUS.post(new ChunkDataEvent.Load(ixzi2, qoac2));
        return ixzi2;
    }

    @Override
    public void _a(ozlu ozlu2, ixzi ixzi2) throws xcad, IOException {
        ozlu2.func_72906_B();
        try {
            qoac qoac2 = new qoac();
            qoac qoac3 = new qoac();
            qoac2._a("Level", (huhy)qoac3);
            this._a(ixzi2, ozlu2, qoac3);
            MinecraftForge.EVENT_BUS.post(new ChunkDataEvent.Save(ixzi2, qoac2));
            this._a(ixzi2._k(), qoac2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _a(jjym jjym2, qoac qoac2) {
        Object object = this._c;
        Object object2 = this._c;
        synchronized (object2) {
            if (this._b.contains(jjym2)) {
                for (int i = 0; i < this._a.size(); ++i) {
                    if (!((dzlk)this._a.get((int)i))._a.equals(jjym2)) continue;
                    this._a.set(i, new dzlk(jjym2, qoac2));
                    return;
                }
            }
            this._a.add(new dzlk(jjym2, qoac2));
            this._b.add(jjym2);
            xcnz._a._a(this);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean _a() {
        dzlk dzlk2 = null;
        Object object = this._c;
        Object object2 = this._c;
        synchronized (object2) {
            if (this._a.isEmpty()) {
                return false;
            }
            dzlk2 = (dzlk)this._a.remove(0);
            this._b.remove(dzlk2._a);
        }
        if (dzlk2 != null) {
            try {
                this._a(dzlk2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return true;
    }

    public void _a(dzlk dzlk2) throws IOException {
        DataOutputStream dataOutputStream = suyl._c(this._d, dzlk2._a._a, dzlk2._a._b);
        bsvf._a(dzlk2._b, dataOutputStream);
        dataOutputStream.close();
    }

    @Override
    public void _b(ozlu ozlu2, ixzi ixzi2) {
    }

    @Override
    public void _b() {
    }

    @Override
    public void _c() {
        while (this._a()) {
        }
    }

    public void _a(ixzi ixzi2, ozlu ozlu2, qoac qoac2) {
        Object object3;
        Object object22;
        qoac qoac3;
        GloomyHooks.writeChunkToNBT(this, ixzi2, ozlu2, qoac2);
        qoac2._a("xPos", ixzi2._i);
        qoac2._a("zPos", ixzi2._j);
        qoac2._a("LastUpdate", ozlu2.func_82737_E());
        qoac2._a("HeightMap", ixzi2._h);
        qoac2._a("TerrainPopulated", ixzi2._n);
        qoac2._a("InhabitedTime", ixzi2._t);
        ujzm[] ujzmArray = ixzi2._b();
        bsyv bsyv2 = new bsyv("Sections");
        boolean bl = !ozlu2.field_73011_w._g;
        ujzm[] ujzmArray2 = ujzmArray;
        int n = ujzmArray.length;
        for (int i = 0; i < n; ++i) {
            ujzm ujzm2 = ujzmArray2[i];
            if (ujzm2 == null) continue;
            qoac3 = new qoac();
            qoac3._a("Y", (byte)(ujzm2._c() >> 4 & 0xFF));
            qoac3._a("Blocks", ujzm2._e());
            if (ujzm2._g() != null) {
                qoac3._a("Add", ujzm2._g()._a);
            }
            qoac3._a("Data", ujzm2._h()._a);
            qoac3._a("BlockLight", ujzm2._i()._a);
            if (bl) {
                qoac3._a("SkyLight", ujzm2._j()._a);
            } else {
                qoac3._a("SkyLight", new byte[ujzm2._i()._a.length]);
            }
            bsyv2._a(qoac3);
        }
        qoac2._a("Sections", bsyv2);
        qoac2._a("Biomes", ixzi2._l());
        ixzi2._p = false;
        bsyv bsyv3 = new bsyv();
        for (n = 0; n < ixzi2._m.length; ++n) {
            for (Object object22 : ixzi2._m[n]) {
                qoac3 = new qoac();
                try {
                    if (!((Entity)object22).func_70039_c(qoac3)) continue;
                    ixzi2._p = true;
                    bsyv3._a(qoac3);
                }
                catch (Exception exception) {
                    FMLLog.log(Level.SEVERE, exception, "An Entity type %s has thrown an exception trying to write state. It will not persist. Report this to the mod author", object22.getClass().getName());
                }
            }
        }
        qoac2._a("Entities", bsyv3);
        object22 = new bsyv();
        for (Object object3 : ixzi2._l.values()) {
            qoac3 = new qoac();
            try {
                ((hurg)object3).func_70310_b(qoac3);
                ((bsyv)object22)._a(qoac3);
            }
            catch (Exception exception) {
                FMLLog.log(Level.SEVERE, exception, "A TileEntity type %s has throw an exception trying to write state. It will not persist. Report this to the mod author", object3.getClass().getName());
            }
        }
        qoac2._a("TileEntities", (huhy)object22);
        object3 = ozlu2.func_72920_a(ixzi2, false);
        if (object3 != null) {
            long l = ozlu2.func_82737_E();
            bsyv bsyv4 = new bsyv();
            Iterator iterator2 = object3.iterator();
            while (iterator2.hasNext()) {
                cfex cfex2 = (cfex)iterator2.next();
                qoac qoac4 = new qoac();
                qoac4._a("i", cfex2._e);
                qoac4._a("x", cfex2._b);
                qoac4._a("y", cfex2._c);
                qoac4._a("z", cfex2._d);
                qoac4._a("t", (int)(cfex2._f - l));
                qoac4._a("p", cfex2._g);
                bsyv4._a(qoac4);
            }
            qoac2._a("TileTicks", bsyv4);
        }
    }

    public ixzi _a(ozlu ozlu2, qoac qoac2) {
        bsyv bsyv2;
        bsyv bsyv3;
        Object object;
        bsyv bsyv4;
        Object object2;
        int n = qoac2._f("xPos");
        int n2 = qoac2._f("zPos");
        ixzi ixzi2 = new ixzi(ozlu2, n, n2);
        ixzi2._h = qoac2._l("HeightMap");
        ixzi2._n = qoac2._o("TerrainPopulated");
        ixzi2._t = qoac2._g("InhabitedTime");
        bsyv bsyv5 = qoac2._n("Sections");
        int n3 = 16;
        ujzm[] ujzmArray = new ujzm[n3];
        boolean bl = !ozlu2.field_73011_w._g;
        for (int i = 0; i < bsyv5._d(); ++i) {
            qoac qoac3 = (qoac)bsyv5._b(i);
            byte by = qoac3._d("Y");
            object2 = new ujzm(by << 4, bl);
            ((ujzm)object2)._a(qoac3._k("Blocks"));
            if (qoac3._c("Add")) {
                ((ujzm)object2)._a(new wqak(qoac3._k("Add"), 4));
            }
            ((ujzm)object2)._b(new wqak(qoac3._k("Data"), 4));
            ((ujzm)object2)._c(new wqak(qoac3._k("BlockLight"), 4));
            if (bl) {
                ((ujzm)object2)._d(new wqak(qoac3._k("SkyLight"), 4));
            }
            ((ujzm)object2)._d();
            ujzmArray[by] = object2;
        }
        ixzi2._a(ujzmArray);
        if (qoac2._c("Biomes")) {
            ixzi2._a(qoac2._k("Biomes"));
        }
        if ((bsyv4 = qoac2._n("Entities")) != null) {
            for (int i = 0; i < bsyv4._d(); ++i) {
                qoac qoac4 = (qoac)bsyv4._b(i);
                object2 = jgro._a(qoac4, ozlu2);
                ixzi2._p = true;
                if (object2 == null) continue;
                ixzi2._a((Entity)object2);
                object = object2;
                qoac qoac5 = qoac4;
                while (qoac5._c("Riding")) {
                    Entity entity = jgro._a(qoac5._m("Riding"), ozlu2);
                    if (entity != null) {
                        ixzi2._a(entity);
                        ((Entity)object).func_70078_a(entity);
                    }
                    object = entity;
                    qoac5 = qoac5._m("Riding");
                }
            }
        }
        if ((bsyv3 = qoac2._n("TileEntities")) != null) {
            for (int i = 0; i < bsyv3._d(); ++i) {
                object2 = (qoac)bsyv3._b(i);
                object = hurg.func_70317_c((qoac)object2);
                if (object == null) continue;
                ixzi2._a((hurg)object);
            }
        }
        if (qoac2._c("TileTicks") && (bsyv2 = qoac2._n("TileTicks")) != null) {
            for (int i = 0; i < bsyv2._d(); ++i) {
                object = (qoac)bsyv2._b(i);
                ozlu2.func_72892_b(((qoac)object)._f("x"), ((qoac)object)._f("y"), ((qoac)object)._f("z"), ((qoac)object)._f("i"), ((qoac)object)._f("t"), ((qoac)object)._f("p"));
            }
        }
        return ixzi2;
    }
}

