/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class nwix {
    public static final BiomeGenBase[] _a = new BiomeGenBase[]{BiomeGenBase._d, BiomeGenBase._f, BiomeGenBase._e, BiomeGenBase._h, BiomeGenBase._c, BiomeGenBase._g};
    public static final BiomeGenBase[] _b = ObjectArrays.concat(_a, BiomeGenBase._w);
    public static final nwix[] _c = new nwix[16];
    public static final nwix _d = new nwix(0, "default", 1)._e();
    public static final nwix _e = new nwix(1, "flat");
    public static final nwix _f = new nwix(2, "largeBiomes");
    public static final nwix _g = new nwix(8, "default_1_1", 0)._a(false);
    public final int _h;
    public final String _i;
    public final int _j;
    public boolean _k;
    public boolean _l;
    public BiomeGenBase[] _m;

    public nwix(int n, String string) {
        this(n, string, 0);
    }

    public nwix(int n, String string, int n2) {
        this._i = string;
        this._j = n2;
        this._k = true;
        this._h = n;
        nwix._c[n] = this;
        switch (n) {
            case 8: {
                this._m = _a;
                break;
            }
            default: {
                this._m = _b;
            }
        }
    }

    public String _a() {
        return this._i;
    }

    @SideOnly(value=Side.CLIENT)
    public String _b() {
        return "generator." + this._i;
    }

    public int _c() {
        return this._j;
    }

    public nwix _a(int n) {
        return this == _d && n == 0 ? _g : this;
    }

    public nwix _a(boolean bl) {
        this._k = bl;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean _d() {
        return this._k;
    }

    public nwix _e() {
        this._l = true;
        return this;
    }

    public boolean _f() {
        return this._l;
    }

    public static nwix _a(String string) {
        for (int i = 0; i < _c.length; ++i) {
            if (_c[i] == null || !nwix._c[i]._i.equalsIgnoreCase(string)) continue;
            return _c[i];
        }
        return null;
    }

    public int _g() {
        return this._h;
    }

    public WorldChunkManager _a(World world) {
        if (this == _e) {
            elpk elpk2 = elpk._b(world.getWorldInfo()._y());
            return new WorldChunkManagerHell(BiomeGenBase._a[elpk2._a()], 0.5f, 0.5f);
        }
        return new WorldChunkManager(world);
    }

    public IChunkProvider _a(World world, String string) {
        return this == _e ? new huze(world, world.getSeed(), world.getWorldInfo()._s(), string) : new rrvu(world, world.getSeed(), world.getWorldInfo()._s());
    }

    public int _b(World world) {
        return this == _e ? 4 : 64;
    }

    public double _c(World world) {
        return this == _e ? 0.0 : 63.0;
    }

    public boolean _b(boolean bl) {
        return this != _e && !bl;
    }

    public double _h() {
        return this == _e ? 1.0 : 0.03125;
    }

    public BiomeGenBase[] _i() {
        return this._m;
    }

    public void _a(BiomeGenBase biomeGenBase) {
        LinkedHashSet<BiomeGenBase> linkedHashSet = Sets.newLinkedHashSet(Arrays.asList(this._m));
        linkedHashSet.add(biomeGenBase);
        this._m = linkedHashSet.toArray(new BiomeGenBase[0]);
    }

    public void _b(BiomeGenBase biomeGenBase) {
        LinkedHashSet<BiomeGenBase> linkedHashSet = Sets.newLinkedHashSet(Arrays.asList(this._m));
        linkedHashSet.remove(biomeGenBase);
        this._m = linkedHashSet.toArray(new BiomeGenBase[0]);
    }

    public boolean _a(Random random, World world) {
        return this == _e ? random.nextInt(4) != 1 : false;
    }

    public void _j() {
    }

    public int _k() {
        return 20;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(Minecraft minecraft, GuiCreateWorld guiCreateWorld) {
        if (this == _e) {
            minecraft._a(new stik(guiCreateWorld, guiCreateWorld._y));
        }
    }

    public boolean _l() {
        return this == _e;
    }

    @SideOnly(value=Side.CLIENT)
    public float _m() {
        return 128.0f;
    }
}

