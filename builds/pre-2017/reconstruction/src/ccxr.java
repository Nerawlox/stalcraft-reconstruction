/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.stats.PlayerStats;
import gloomyfolken.mods.core.main.GloomyCore;
import java.io.IOException;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.MinecraftForge;

public class ccxr
implements IExtendedEntityProperties {
    public final EntityPlayer _a;
    public float _b;
    private double[] _l = new double[]{0.0, 0.0, 0.0};
    private float[] _m = new float[]{0.0f, 0.0f};
    public static final String _c = "st_attrib";
    public static final String _d = "GloomyData";
    public static final String _e = "attribs";
    public bqwg<ItemStack> _f;
    public HashMap<String, bqwg> _g = new HashMap();
    public HashMap<String, tehy> _h = new HashMap();
    private List<bqdo> _n = new ArrayList<bqdo>();
    private boolean _o = false;
    private PlayerStats _p;
    private uxqz _q;
    public static ToLongFunction<ccxr> _i = ccxr2 -> InvokeWithResult.frontend(() -> null);
    public static ToIntFunction<ccxr> _j = ccxr2 -> InvokeWithResult.frontend(() -> null);
    private boolean _r;
    public bqwg<Float> _k;
    private kjui _s = new kjui();

    public ccxr(EntityPlayer entityPlayer) {
        this._a = entityPlayer;
    }

    public void _a() {
        MinecraftForge.EVENT_BUS.post(new mquk(this));
        this._p = new PlayerStats();
        this._p.player = this._a;
        this._q = new uxqz(this._a.username);
        this._b = this._a.getHealth();
        this._k();
        this._f = new bqwg.kjui<Class<ItemStack>>(this, "bp", ItemStack.class)._a()._f();
        this._k = new bqwg.kjui<Float>(this, "mspd", Float.valueOf(0.1f))._f();
        this._c();
    }

    public boolean _b() {
        return this._o;
    }

    public void _c() {
        this._a.openContainer = this._a.inventoryContainer = GloomyCore.instance.containerFactory._a(this);
        for (Map.Entry<String, tehy> entry : this._h.entrySet()) {
            entry.getValue().resetHandler();
        }
    }

    public void _a(bqwg bqwg2) {
        this._g.put(bqwg2._b, bqwg2);
    }

    public void _d() {
        for (Map.Entry<String, tehy> entry : this._h.entrySet()) {
            entry.getValue().tick();
        }
        if (!this._a.worldObj.isRemote) {
            InvokeSideOnly.frontend((InvokeSideOnly.InvokeFrontendOnly)LambdaMetafactory.metafactory(null, null, null, ()V, serverTick(), ()V)((ccxr)this));
        }
    }

    public void _e() {
        this._a.setPositionAndRotation(this._l[0], this._l[1], this._l[2], this._m[0], this._m[1]);
    }

    private void _k() {
        this._l[0] = this._a.prevPosX;
        this._l[1] = this._a.prevPosY + (double)this._a.ySize;
        this._l[2] = this._a.prevPosZ;
        this._m[0] = this._a.prevRotationYaw;
        this._m[1] = this._a.prevRotationPitch;
    }

    public NBTTagCompound _f() {
        NBTTagCompound nBTTagCompound = this._a.getEntityData();
        if (!nBTTagCompound._c("PlayerPersisted")) {
            nBTTagCompound._a("PlayerPersisted", (NBTBase)new NBTTagCompound());
        }
        return nBTTagCompound._m("PlayerPersisted");
    }

    public boolean _g() {
        return this._r;
    }

    public boolean _h() {
        return this._f._b() != null;
    }

    private void _a(NBTTagCompound nBTTagCompound, String string, qlgf qlgf2) {
        ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        try {
            qlgf2.write(byteArrayDataOutput);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        nBTTagCompound._a(string, byteArrayDataOutput.toByteArray());
    }

    private <T extends qlgf> T _b(NBTTagCompound nBTTagCompound, String string, T t) {
        byte[] byArray = nBTTagCompound._k(string);
        if (byArray.length > 0) {
            try {
                t.read(ByteStreams.newDataInput(byArray));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return t;
    }

    @Override
    public void init(Entity entity, World world) {
    }

    public pzde _a(turb turb2) {
        return this._q._a().computeIfAbsent(turb2, this::_b);
    }

    public kjwj _a(srok srok2) {
        return (kjwj)this._a((turb)srok2);
    }

    public hank _a(tdpx tdpx2) {
        return (hank)this._a((turb)tdpx2);
    }

    public samo _a(hanr hanr2) {
        return (samo)this._a((turb)hanr2);
    }

    private pzde _b(turb turb2) {
        Object s = turb2._f();
        ((pzde)s)._a = this._a.username;
        return s;
    }

    public PlayerStats _i() {
        return this._p;
    }

    public uxqz _j() {
        return this._q;
    }

    public static class kjui {
        private List<mqfb<Float, Long>> _a = new ArrayList<mqfb<Float, Long>>(2);
        private static final double _b = (double)0.001f;
        private static final int _c = 600;
    }
}

