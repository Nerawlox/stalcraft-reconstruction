/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.client.gui.screens.GuiItem;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.ezfa;
import gloomyfolken.mods.core.misc.jgro;
import gloomyfolken.mods.core.misc.kjwj;
import gloomyfolken.mods.core.misc.tdmn;
import gloomyfolken.mods.core.misc.vjta;
import gloomyfolken.mods.core.misc.xpzm;
import gloomyfolken.mods.stalker.misc.tupg;
import gloomyfolken.mods.weapon.entity.EntityShell;
import gloomyfolken.mods.weapon.entity.kjui;
import gloomyfolken.mods.weapon.qlgf;
import gloomyfolken.mods.weapon.ugqx;
import gloomyfolken.mods.weapon.zwat;
import gloomyfolken.mods.weapon.zwaw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class wolf
extends kjwj
implements culm,
ezfa,
tdmn,
vjta,
xpzm<dxwc, dxwc.pidb>,
zwat<EntityLivingBase>,
oxnm,
tezq,
tfdj,
yusn {
    public int[] _b = new int[0];
    public int[] _c = new int[0];
    public HashMap<Integer, Integer> _d = new HashMap();
    public EnumMap<dxwc.pidb, Float> _e = new EnumMap(dxwc.pidb.class);
    public EnumMap<dxwc.pidb, Set<dxwc.ezey>> _f = new EnumMap(dxwc.pidb.class);
    public EnumMap<dxwc.pidb, String> _g = new EnumMap(dxwc.pidb.class);
    private float __ao;
    private float __ap;
    private float __aq;
    private int __ar;
    public float _h;
    public float _i;
    public float _j;
    public float _k;
    public float _l;
    public float _m;
    public float _n;
    public float _o;
    public float _p;
    public float _q;
    public float _r;
    public float _s;
    private float __as;
    private float __at;
    private float __au;
    private float __av;
    private float __aw;
    public boolean _t;
    private int __ax;
    public int _u;
    public boolean _v;
    public int _w;
    public int _x;
    public int _y;
    public int _z;
    public Set<String> _A = Collections.EMPTY_SET;
    public int _B = 0;
    public String _C = "";
    public String _D = "";
    public String _E;
    public String _F;
    public String _G;
    public String _H;
    public String _I;
    public String _J;
    public String _K;
    public String _L;
    public String _M;
    public String _N;
    public boolean _O;
    public boolean _P;
    public boolean _Q;
    public float _R;
    public float _S;
    public float _T;
    public boolean _U;
    public String _V;
    public ResourceLocation _W;
    public float _X;
    public int _Y;
    public int _Z;
    public Vec3 __aa = Vec3._a(0.0, 0.0, 0.0);
    public Set<String> __ab = Collections.EMPTY_SET;
    public boolean __ac;
    public boolean __ad;
    public EnumRarity __ae;
    public xrpu __af;
    public String __ag;
    public String[] __ah;
    public klka __ai;
    public qlgf __aj;
    public float __ak = -1.0f;
    public float __al = -1.0f;
    public float __am = 0.0f;
    public int __an;
    private static List<wolf> __ay = new ArrayList<wolf>();
    private static final String __az = "upgrades";
    private static final String __aA = "id";
    private static final String __aB = "level";
    private static final String __aC = "attach";
    private final dxwf __aD = new dxwf(false, 0.0f, 1.0f, -1);

    public wolf(int n, String string, String string2, List<String> list) {
        super(n, string, "weapons:" + string2, list, 1);
        __ay.add(this);
    }

    public static List<wolf> _c() {
        return __ay;
    }

    public void _a(String string, String string2) {
        this._V = string;
        if (string != null) {
            if (string.isEmpty()) {
                this._V = null;
                this._W = null;
            } else if (GloomyCore.side.isClient() && string2 != null && !string2.isEmpty()) {
                InvokeSideOnly.client(() -> this._a(string2));
            }
        } else {
            this._W = null;
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _a(String string) {
        this._W = new ResourceLocation("weapons", "models/sleeves/" + string);
        fmib._b(this._W);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        return false;
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLivingBase, ItemStack itemStack) {
        return true;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemStack, int n, int n2, int n3, EntityPlayer entityPlayer) {
        return false;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack itemStack, EntityPlayer entityPlayer, Entity entity) {
        return true;
    }

    @Override
    public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        return false;
    }

    @Override
    public EnumRarity getRarity(ItemStack itemStack) {
        return this.__ae == null ? super.getRarity(itemStack) : this.__ae;
    }

    @Override
    public void _a(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list) {
        this._c(list, "\u041f\u0430\u0442\u0440\u043e\u043d\u043e\u0432: " + wolf._E(itemStack) + "/" + this._r(itemStack));
        this._c(itemStack, entityPlayer, list);
        this._c(itemStack, list, true);
    }

    @Override
    public void _c(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list) {
        this._a(itemStack, list);
        this._b(itemStack, list, true);
        this._a(itemStack, list, true);
    }

    public void _a(ItemStack itemStack, List<String> list) {
        for (String string : this._l(itemStack)) {
            this._c(list, string);
        }
    }

    public void _a(ItemStack itemStack, List<String> list, boolean bl) {
        HashMap<stap, Integer> hashMap = wolf._K(itemStack);
        if (bl && hashMap.size() > 0) {
            list.add("");
        }
        for (Map.Entry<stap, Integer> entry : hashMap.entrySet()) {
            this._a(list, entry.getKey()._c + " " + entry.getValue());
        }
    }

    public void _b(ItemStack itemStack, List<String> list, boolean bl) {
        EnumMap<dxwc.kjui.kjui, Float> enumMap = wolf._L(itemStack);
        if (bl && enumMap.size() > 0) {
            list.add("");
        }
        for (Map.Entry<dxwc.kjui.kjui, Float> entry : enumMap.entrySet()) {
            dxwc.kjui.kjui kjui2 = entry.getKey();
            float f = entry.getValue().floatValue();
            String string = jgro._g(kjui2._a(f));
            list.add((Object)((Object)EnumChatFormatting._j) + entry.getKey()._m + ": " + string);
        }
    }

    public void _c(ItemStack itemStack, List<String> list, boolean bl) {
        NBTTagCompound nBTTagCompound = ncwh._c(itemStack);
        boolean bl2 = false;
        for (dxwc.eidj eidj2 : dxwc.eidj.values()) {
            ItemStack itemStack2 = ItemStack._a(nBTTagCompound._m(eidj2.name()));
            if (itemStack2 == null || !(itemStack2._a() instanceof dxwc)) continue;
            if (!bl2 && bl) {
                list.add("");
                bl2 = true;
            }
            this._a(list, ((dxwc)itemStack2._a())._d);
        }
    }

    public List<String> _k(ItemStack itemStack) {
        ArrayList<String> arrayList = new ArrayList<String>();
        HashMap<stap, Integer> hashMap = wolf._K(itemStack);
        for (Map.Entry<stap, Integer> entry : hashMap.entrySet()) {
            this._a(arrayList, entry.getKey()._c + " " + entry.getValue());
        }
        return arrayList;
    }

    @Override
    public void _b(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list) {
        super._b(itemStack, entityPlayer, list);
        this._a(list);
    }

    @Override
    public List<String> _a(ItemStack itemStack, EntityPlayer entityPlayer) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(String.join((CharSequence)" ", this._b_));
        this._a((List<String>)arrayList);
        return arrayList;
    }

    public void _a(List<String> list) {
        list.add((Object)((Object)EnumChatFormatting._r) + "\u041f\u043e\u0434\u0445\u043e\u0434\u044f\u0449\u0438\u0435 \u0431\u043e\u0435\u043f\u0440\u0438\u043f\u0430\u0441\u044b:");
        for (int n : this._b) {
            Item item = Item.itemsList[n];
            if (!(item instanceof nusq)) continue;
            list.add(item.getItemDisplayName(null));
        }
    }

    public List<String> _l(ItemStack itemStack) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("\u0423\u0440\u043e\u043d: " + jgro._f(this._R(itemStack)) + " \u0435\u0434.");
        arrayList.add("\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u0440\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u044c: " + jgro._h(this._m(itemStack)) + " \u0432\u044b\u0441\u0442\u0440\u0435\u043b\u043e\u0432/\u043c\u0438\u043d.");
        arrayList.add("\u041f\u0435\u0440\u0435\u0437\u0430\u0440\u044f\u0434\u043a\u0430: " + jgro._a(this._a(itemStack, this._r(itemStack))));
        arrayList.add("\u0414\u043e\u0441\u0442\u0430\u0432\u0430\u043d\u0438\u0435: " + jgro._a(this._x(itemStack)));
        arrayList.add("\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u043f\u0440\u0438\u0446\u0435\u043b\u0438\u0432\u0430\u043d\u0438\u044f: " + jgro._a(this._v(itemStack)));
        arrayList.add("\u0420\u0430\u0437\u0431\u0440\u043e\u0441: " + jgro._h(this._a(itemStack, true)) + "\u00b0");
        arrayList.add("\u0420\u0430\u0437\u0431\u0440\u043e\u0441 \u043e\u0442 \u0431\u0435\u0434\u0440\u0430: " + jgro._h(this._a(itemStack, false)) + "\u00b0");
        arrayList.add("\u041e\u0442\u0434\u0430\u0447\u0430: " + jgro._h(this._o(itemStack)) + "\u00b0");
        arrayList.add("\u0413\u043e\u0440\u0438\u0437. \u043e\u0442\u0434\u0430\u0447\u0430: " + jgro._h(this._p(itemStack)) + "\u00b0");
        arrayList.add("\u042d\u0444\u0444\u0435\u043a\u0442\u0438\u0432\u043d\u0430\u044f \u0434\u0438\u0441\u0442\u0430\u043d\u0446\u0438\u044f: " + jgro._h(this._u(itemStack)) + " \u043c.");
        arrayList.add("\u041c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u0430\u044f \u0434\u0438\u0441\u0442\u0430\u043d\u0446\u0438\u044f: " + jgro._h(this._t(itemStack)) + " \u043c.");
        arrayList.add("\u0417\u0430\u043a\u043b\u0438\u043d\u0438\u0432\u0430\u043d\u0438\u0435: " + jgro._j(this._B(itemStack)));
        return arrayList;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public boolean isFull3D() {
        return true;
    }

    @Override
    public boolean _j(ItemStack itemStack) {
        boolean bl = false;
        for (dxwc.pidb pidb2 : dxwc.pidb._y) {
            htce htce2 = this._a(itemStack, pidb2, htce.class);
            if (htce2 == null || !htce2._h) continue;
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean _b() {
        return false;
    }

    public void _a(float f) {
        this._h = f;
    }

    public void _b(float f) {
        this._i = f;
    }

    public void _c(float f) {
        this.__as = f;
    }

    public void _a(int n) {
        this.__ar = n;
    }

    public void _d(float f) {
        this.__ao = f;
    }

    public float _m(ItemStack itemStack) {
        float f = this.__ao;
        return f *= this._a(itemStack, dxwc.kjui.kjui._b);
    }

    public float _n(ItemStack itemStack) {
        return 1200.0f / this._m(itemStack);
    }

    public void _b(int n) {
        this.__ax = n * 50;
    }

    public void _e(float f) {
        this.__av = f;
    }

    public void _a(float f, float f2) {
        this.__at = f;
        this.__au = f2;
    }

    public void _b(float f, float f2) {
        this.__ap = f;
        this.__aq = f2;
    }

    public void _a(int n, int n2, int n3) {
        this._v = true;
        this._w = n * 50;
        this._x = n2 * 50;
        this._y = n3 * 50;
    }

    public void _f(float f) {
        this.__aw = f;
    }

    public float _o(ItemStack itemStack) {
        float f = this._h;
        f *= this._a(itemStack, dxwc.kjui.kjui._d);
        return f /= jgro._b(wolf._a(itemStack, stap.kjui._e));
    }

    public float _p(ItemStack itemStack) {
        float f = this._i;
        f *= this._a(itemStack, dxwc.kjui.kjui._e);
        return f /= jgro._b(wolf._a(itemStack, stap.kjui._e));
    }

    public float _a(ItemStack itemStack, boolean bl) {
        float f = this._j;
        nusq nusq2 = wolf._C(itemStack);
        if (nusq2 != null) {
            f *= nusq2._i;
        }
        if (!bl) {
            f += Math.max(this._l, this._k * this._a(itemStack, dxwc.kjui.kjui._g));
        }
        f *= this._a(itemStack, dxwc.kjui.kjui._f);
        return f /= jgro._b(wolf._a(itemStack, stap.kjui._c));
    }

    public float _q(ItemStack itemStack) {
        float f = this.__as;
        f *= this._a(itemStack, dxwc.kjui.kjui._h);
        return f /= jgro._b(wolf._a(itemStack, stap.kjui._e));
    }

    public int _r(ItemStack itemStack) {
        pjxf pjxf2 = this._a(itemStack, dxwc.pidb._n, pjxf.class);
        return pjxf2 == null ? this.__ar : pjxf2._h;
    }

    public float _s(ItemStack itemStack) {
        float f = 1.0f;
        f *= this._a(itemStack, dxwc.kjui.kjui._c);
        return f *= jgro._b(wolf._a(itemStack, stap.kjui._b));
    }

    public float _b(ItemStack itemStack, float f) {
        float f2 = this._s(itemStack);
        float f3 = this.__at * f2;
        float f4 = this.__au * f2;
        float f5 = wolf._b(f3, f4, f);
        float f6 = this.__ap - this.__aq;
        float f7 = this.__ap - f6 * f5;
        return f7 / this.__ap;
    }

    public float _t(ItemStack itemStack) {
        return this.__av * this._s(itemStack);
    }

    public float _u(ItemStack itemStack) {
        return (this.__at + this.__au) / 2.0f * this._s(itemStack);
    }

    public int _a(ItemStack itemStack, int n) {
        return this._v ? this._w + this._x * n + this._y : this.__ax;
    }

    public int _v(ItemStack itemStack) {
        return (int)((float)this._z * this._a(itemStack, dxwc.kjui.kjui._i));
    }

    public float _w(ItemStack itemStack) {
        return (int)((float)this._u * this._a(itemStack, dxwc.kjui.kjui._j));
    }

    public int _x(ItemStack itemStack) {
        return (int)(this._w(itemStack) * 50.0f);
    }

    public boolean _c(int n) {
        for (int n2 : this._b) {
            if (n2 != n) continue;
            return true;
        }
        return false;
    }

    public EnumSet<ugqx.kjui> _y(ItemStack itemStack) {
        EnumSet<ugqx.kjui> enumSet = EnumSet.of(ugqx.kjui._c);
        if (this._P) {
            enumSet.add(ugqx.kjui._a);
        }
        if (this._Q) {
            enumSet.add(ugqx.kjui._b);
        }
        return enumSet;
    }

    public int _z(ItemStack itemStack) {
        ItemStack itemStack2 = this._c(itemStack, dxwc.pidb._b);
        if (itemStack2 == null || !(itemStack2._a() instanceof xrox)) {
            return 0;
        }
        return ncwh._c(itemStack2)._f("grenade");
    }

    public void _b(ItemStack itemStack, int n) {
        ItemStack itemStack2 = this._c(itemStack, dxwc.pidb._b);
        if (itemStack2 == null || !(itemStack2._a() instanceof xrox)) {
            return;
        }
        ncwh._b(itemStack2)._a("grenade", n);
        this._a(itemStack, itemStack2, dxwc.pidb._b);
    }

    public static boolean _A(ItemStack itemStack) {
        return ncwh._c(itemStack)._o("jamming");
    }

    public static void _b(ItemStack itemStack, boolean bl) {
        ncwh._b(itemStack)._a("jamming", bl);
    }

    public float _B(ItemStack itemStack) {
        pjxf pjxf2;
        nusq nusq2;
        float f = this.__aw;
        if (itemStack._k() > 0) {
            f *= 1.0f + (float)itemStack._j() / (float)itemStack._k();
        }
        if ((nusq2 = wolf._C(itemStack)) != null) {
            f += nusq2._g;
        }
        if ((pjxf2 = this._a(itemStack, dxwc.pidb._n, pjxf.class)) != null) {
            f += pjxf2._i;
        }
        return f;
    }

    public static nusq _C(ItemStack itemStack) {
        int n = wolf._F(itemStack);
        if (n <= 0 || n >= 32000) {
            return null;
        }
        if (!(Item.itemsList[n] instanceof nusq)) {
            return null;
        }
        return (nusq)Item.itemsList[n];
    }

    public static void _a(ItemStack itemStack, int n, int n2, NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2 = ncwh._b(itemStack);
        nBTTagCompound2._a("bulletId", n);
        nBTTagCompound2._a("numBullets", n2);
        if (nBTTagCompound == null) {
            nBTTagCompound2._p("bulletTag");
        } else {
            nBTTagCompound2._a("bulletTag", (NBTBase)nBTTagCompound);
        }
    }

    public static void _D(ItemStack itemStack) {
        wolf._a(itemStack, wolf._F(itemStack), 0, null);
    }

    public static int _E(ItemStack itemStack) {
        return ncwh._c(itemStack)._f("numBullets");
    }

    public static int _F(ItemStack itemStack) {
        return ncwh._c(itemStack)._f("bulletId");
    }

    public static NBTTagCompound _G(ItemStack itemStack) {
        wolf._I(itemStack);
        NBTTagCompound nBTTagCompound = ncwh._c(itemStack);
        return nBTTagCompound._c("bulletTag") ? nBTTagCompound._m("bulletTag") : null;
    }

    public static ItemStack _H(ItemStack itemStack) {
        if (!wolf._I(itemStack)) {
            return null;
        }
        ItemStack itemStack2 = new ItemStack(wolf._F(itemStack), wolf._E(itemStack), 0);
        itemStack2._e = wolf._G(itemStack);
        return itemStack2;
    }

    public static boolean _I(ItemStack itemStack) {
        nusq nusq2 = wolf._C(itemStack);
        int n = wolf._E(itemStack);
        if (ncwh._c(itemStack)._f("bulletId") != 0 && (nusq2 == null || n == 0)) {
            wolf._D(itemStack);
        }
        return nusq2 != null && n > 0;
    }

    public static void _J(ItemStack itemStack) {
        int n = wolf._E(itemStack);
        if (--n <= 0) {
            wolf._D(itemStack);
        } else {
            ncwh._b(itemStack)._a("numBullets", n);
        }
    }

    public static HashMap<stap, Integer> _K(ItemStack itemStack) {
        HashMap<stap, Integer> hashMap = new HashMap<stap, Integer>();
        NBTTagCompound nBTTagCompound = ncwh._c(itemStack);
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m(__az);
        for (stap.kjui kjui2 : stap.kjui.values()) {
            if (!nBTTagCompound2._c(kjui2.name())) continue;
            NBTTagCompound nBTTagCompound3 = nBTTagCompound2._m(kjui2.name());
            int n = nBTTagCompound3._f(__aA);
            int n2 = nBTTagCompound3._f(__aB);
            if (n <= 0 || n >= 32000 || !(Item.itemsList[n] instanceof stap)) continue;
            stap stap2 = (stap)Item.itemsList[n];
            hashMap.put(stap2, n2);
        }
        return hashMap;
    }

    public static EnumMap<dxwc.kjui.kjui, Float> _L(ItemStack itemStack) {
        EnumMap<dxwc.kjui.kjui, Float> enumMap = new EnumMap<dxwc.kjui.kjui, Float>(dxwc.kjui.kjui.class);
        for (dxwc.kjui.kjui kjui2 : dxwc.kjui.kjui.values()) {
            if (itemStack._e == null || !itemStack._e._c(kjui2._l)) continue;
            enumMap.put(kjui2, Float.valueOf(itemStack._e._h(kjui2._l)));
        }
        return enumMap;
    }

    public static float _a(ItemStack itemStack, stap.kjui kjui2) {
        NBTTagCompound nBTTagCompound = ncwh._c(itemStack)._m(__az);
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m(kjui2.name());
        int n = nBTTagCompound2._f(__aA);
        if (n > 0 && n < 32000 && Item.itemsList[n] instanceof stap) {
            return (float)nBTTagCompound2._f(__aB) * ((stap)Item.itemsList[n])._e;
        }
        return 0.0f;
    }

    public static int _a(ItemStack itemStack, stap stap2) {
        NBTTagCompound nBTTagCompound = ncwh._c(itemStack)._m(__az);
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m(stap2._b.name());
        if (nBTTagCompound2._f(__aA) == stap2.itemID) {
            return nBTTagCompound2._f(__aB);
        }
        return 0;
    }

    public static stap _b(ItemStack itemStack, stap.kjui kjui2) {
        NBTTagCompound nBTTagCompound = ncwh._c(itemStack)._m(__az);
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m(kjui2.name());
        int n = nBTTagCompound2._f(__aA);
        if (n > 0 && n < 32000 && Item.itemsList[n] instanceof stap) {
            return (stap)Item.itemsList[n];
        }
        return null;
    }

    public static void _a(ItemStack itemStack, stap stap2, int n) {
        NBTTagCompound nBTTagCompound = ncwh._b(itemStack);
        if (!nBTTagCompound._c(__az)) {
            nBTTagCompound._a(__az, (NBTBase)new NBTTagCompound());
        }
        NBTTagCompound nBTTagCompound2 = nBTTagCompound._m(__az);
        if (n > 0) {
            NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
            nBTTagCompound3._a(__aA, stap2.itemID);
            nBTTagCompound3._a(__aB, n);
            nBTTagCompound2._a(stap2._b.name(), nBTTagCompound3);
        } else {
            nBTTagCompound2._p(stap2._b.name());
        }
    }

    public boolean _a(ItemStack itemStack, dxwc.pidb pidb2) {
        return this._c(itemStack, pidb2)._a(pidb2) != null;
    }

    public boolean _a(ItemStack itemStack, dxwc dxwc2, dxwc.pidb pidb2) {
        if (itemStack == null || dxwc2 == null) {
            return false;
        }
        return this._c(itemStack, pidb2)._a(dxwc2, pidb2);
    }

    public dxwc _b(ItemStack itemStack, dxwc.pidb pidb2) {
        dxwc dxwc2;
        if (pidb2._p != null && (dxwc2 = (dxwc)this._d(itemStack, pidb2._p)) instanceof yusn) {
            return dxwc2;
        }
        return null;
    }

    private yusn _c(ItemStack itemStack, dxwc.pidb pidb2) {
        dxwc dxwc2;
        yusn yusn2 = this;
        if (pidb2._p != null && (dxwc2 = (dxwc)this._d(itemStack, pidb2._p)) instanceof yusn) {
            yusn2 = (yusn)((Object)dxwc2);
        }
        return yusn2;
    }

    public <T extends dxwc> T _a(ItemStack itemStack, dxwc.pidb pidb2, Class<T> clazz) {
        dxwc dxwc2 = (dxwc)this._d(itemStack, pidb2);
        if (dxwc2 != null && clazz.isAssignableFrom(dxwc2.getClass())) {
            return (T)dxwc2;
        }
        return null;
    }

    public <T extends dxwc> ItemStack _b(ItemStack itemStack, dxwc.pidb pidb2, Class<T> clazz) {
        ItemStack itemStack2 = this._c(itemStack, pidb2);
        if (itemStack2 != null && clazz.isAssignableFrom(itemStack2._a().getClass())) {
            return itemStack2;
        }
        return null;
    }

    public ItemStack _a(ItemStack itemStack, dxwc.eidj eidj2) {
        for (dxwc.pidb pidb2 : dxwc.pidb._x) {
            ItemStack itemStack2;
            if (!pidb2._q.contains((Object)eidj2) || (itemStack2 = this._c(itemStack, pidb2)) == null) continue;
            return itemStack2;
        }
        return null;
    }

    public <T extends dxwc> T _a(ItemStack itemStack, dxwc.eidj eidj2, Class<T> clazz) {
        for (dxwc.pidb pidb2 : dxwc.pidb._x) {
            dxwc dxwc2;
            if (!pidb2._q.contains((Object)eidj2) || (dxwc2 = (dxwc)this._d(itemStack, pidb2)) == null || !clazz.isAssignableFrom(dxwc2.getClass())) continue;
            return (T)dxwc2;
        }
        return null;
    }

    public boolean _b(ItemStack itemStack, dxwc.eidj eidj2) {
        return this._a(itemStack, eidj2) != null;
    }

    public dxvq _M(ItemStack itemStack) {
        dxwc.pidb pidb2 = this._O(itemStack);
        return pidb2 == null ? null : this._a(itemStack, pidb2, dxvq.class);
    }

    public ItemStack _N(ItemStack itemStack) {
        dxwc.pidb pidb2 = this._O(itemStack);
        return pidb2 == null ? null : this._b(itemStack, pidb2, dxvq.class);
    }

    public dxwc.pidb _O(ItemStack itemStack) {
        dxwc dxwc2 = (dxwc)this._d(itemStack, dxwc.pidb._l);
        if (dxwc2 instanceof dxvq) {
            return dxwc.pidb._l;
        }
        if (dxwc2 instanceof ifcv && this._a(itemStack, dxwc.pidb._m, dxvq.class) != null) {
            return dxwc.pidb._m;
        }
        dxwc dxwc3 = (dxwc)this._d(itemStack, dxwc.pidb._c);
        if (dxwc3 instanceof dxvq) {
            return dxwc.pidb._c;
        }
        return null;
    }

    public float _a(ItemStack itemStack, dxwc.kjui.kjui kjui2) {
        float f = 1.0f;
        if (itemStack._e != null && itemStack._e._c(kjui2._l)) {
            f *= itemStack._e._h(kjui2._l);
        }
        for (dxwc.pidb pidb2 : dxwc.pidb._x) {
            dxwc dxwc2 = (dxwc)this._d(itemStack, pidb2);
            if (dxwc2 == null) continue;
            f *= kjui2._a(dxwc2._g);
        }
        return f;
    }

    private ItemStack _m(EntityLivingBase entityLivingBase) {
        ItemStack itemStack = entityLivingBase.getHeldItem();
        if (itemStack == null || itemStack._d != this.itemID) {
            throw new zwaw(this, itemStack);
        }
        return itemStack;
    }

    public float _a(EntityLivingBase entityLivingBase) {
        return this._t(this._m(entityLivingBase));
    }

    public int _b(EntityLivingBase entityLivingBase) {
        return this._P(this._m(entityLivingBase));
    }

    public int _P(ItemStack itemStack) {
        nusq nusq2 = wolf._C(itemStack);
        if (nusq2 != null) {
            return nusq2._l;
        }
        return 1;
    }

    public float _a(EntityLivingBase entityLivingBase, float f) {
        ItemStack itemStack = this._m(entityLivingBase);
        float f2 = entityLivingBase instanceof kjui ? ((kjui)((Object)entityLivingBase)).getDamage() : this._Q(itemStack);
        return this._a(itemStack, f2, f);
    }

    public float _a(ItemStack itemStack, float f, float f2) {
        return f * this._b(itemStack, f2);
    }

    public float _Q(ItemStack itemStack) {
        float f = this.__ap;
        f *= this._a(itemStack, dxwc.kjui.kjui._a);
        f *= jgro._b(wolf._a(itemStack, stap.kjui._a));
        nusq nusq2 = wolf._C(itemStack);
        if (nusq2 != null) {
            f *= nusq2._d;
        }
        return f;
    }

    public float _R(ItemStack itemStack) {
        return this._Q(itemStack) * (float)this._P(itemStack);
    }

    private static float _b(float f, float f2, float f3) {
        return sajh._a((f3 - f) / (f2 - f), 0.0f, 1.0f);
    }

    public float _c(EntityLivingBase entityLivingBase) {
        ItemStack itemStack = this._m(entityLivingBase);
        ugqx ugqx2 = entityLivingBase instanceof EntityPlayer ? ugqx._a((EntityPlayer)entityLivingBase) : null;
        boolean bl = true;
        if (ugqx2 != null) {
            bl = ugqx2._m();
        }
        float f = this._a(itemStack, bl);
        if (ugqx2 != null) {
            f *= ugqx2._g;
            tupg tupg2 = tupg._a((EntityPlayer)entityLivingBase);
            float f2 = xafi._a(tupg2._d._A);
            f *= f2;
            if (entityLivingBase.height < 1.0f) {
                f *= this._r;
            } else if (entityLivingBase.isSneaking()) {
                f *= this._q;
            }
            float f3 = (float)Math.sqrt(entityLivingBase.motionX * entityLivingBase.motionX + entityLivingBase.motionZ * entityLivingBase.motionZ);
            float f4 = wolf._b(0.0f, 0.1f, f3);
            f *= jywc._a(1.0f, this._p, f4);
        }
        return f;
    }

    public float _S(ItemStack itemStack) {
        dxvq dxvq2 = this._M(itemStack);
        return dxvq2 == null ? this._R : dxvq2._i;
    }

    public float _d(EntityLivingBase entityLivingBase) {
        nusq nusq2 = wolf._C(this._m(entityLivingBase));
        return nusq2 == null ? 1.0f : nusq2._e;
    }

    public float _e(EntityLivingBase entityLivingBase) {
        nusq nusq2 = wolf._C(this._m(entityLivingBase));
        return nusq2 == null ? 0.0f : nusq2._f;
    }

    public float _f(EntityLivingBase entityLivingBase) {
        nusq nusq2 = wolf._C(this._m(entityLivingBase));
        return nusq2 == null ? 0.0f : nusq2._h;
    }

    @ezey(_a={eidj.CLIENT})
    public String _g(EntityLivingBase entityLivingBase) {
        ItemStack itemStack = this._m(entityLivingBase);
        return this._a(this._l(entityLivingBase) ? this._K : this._I, entityLivingBase, itemStack);
    }

    public boolean _h(EntityLivingBase entityLivingBase) {
        if (entityLivingBase instanceof EntityPlayer) {
            ItemStack itemStack = this._m(entityLivingBase);
            ugqx ugqx2 = ugqx._a((EntityPlayer)entityLivingBase);
            ugqx.pidb pidb2 = ugqx2._b(itemStack);
            if (pidb2 != ugqx.pidb._a) {
                Logger.warning("Player " + ((EntityPlayer)entityLivingBase).username + " made impossible shot: " + (Object)((Object)pidb2), new Object[0]);
                return false;
            }
        }
        return true;
    }

    @ezey(_a={eidj.CLIENT})
    public void _i(EntityLivingBase entityLivingBase) {
        if (this._Y < 1) {
            this._j(entityLivingBase);
        }
    }

    @ezey(_a={eidj.CLIENT})
    public void _j(EntityLivingBase entityLivingBase) {
        entityLivingBase.worldObj.spawnEntityInWorld(new EntityShell(entityLivingBase.worldObj, entityLivingBase, this));
    }

    @ezey(_a={eidj.CLIENT})
    public void _k(EntityLivingBase entityLivingBase) {
        ItemStack itemStack = this._m(entityLivingBase);
        boolean bl = entityLivingBase == Minecraft._E()._u && Minecraft._E()._M.thirdPersonView == 0;
        dxwf dxwf2 = this._U(itemStack);
        sbzn._a._a(entityLivingBase, dxwf2._a(this), this.__af._p + dxwf2._b, this.__af._o * dxwf2._c, bl);
        if (entityLivingBase == Minecraft._E()._t) {
            Random random = entityLivingBase.getRNG();
            tupg tupg2 = tupg._a((EntityPlayer)entityLivingBase);
            float f = xafi._a(tupg2._d._B);
            jzcs._c = this._p(itemStack) * f * (random.nextFloat() * 2.0f - 1.0f);
            jzcs._b = this._o(itemStack) * f * (0.8f + random.nextFloat() * 0.2f);
        }
    }

    public int _T(ItemStack itemStack) {
        dxwf dxwf2 = this._U(itemStack);
        if (dxwf2._d < 0) {
            return this.__af._n;
        }
        return dxwf2._d;
    }

    public dxwf _U(ItemStack itemStack) {
        maoa maoa2 = this._a(itemStack, dxwc.pidb._k, maoa.class);
        if (maoa2 != null) {
            return maoa2._h;
        }
        jzia jzia2 = this._a(itemStack, dxwc.pidb._b, jzia.class);
        if (jzia2 != null) {
            return jzia2._h;
        }
        return this.__aD;
    }

    @Override
    public int getDamage(ItemStack itemStack) {
        return (int)this._h(itemStack);
    }

    @Override
    public int getMaxDamage(ItemStack itemStack) {
        if (itemStack._e != null && itemStack._e._o("unbreakable")) {
            return 0;
        }
        float f = this.getMaxDamage();
        f *= jgro._b(wolf._a(itemStack, stap.kjui._d));
        f *= this._a(itemStack, dxwc.kjui.kjui._k);
        return (int)(f *= this._e_(itemStack));
    }

    @Override
    public void setDamage(ItemStack itemStack, int n) {
        this._a(itemStack, (double)n);
    }

    @Override
    public int getDisplayDamage(ItemStack itemStack) {
        return this.getDamage(itemStack);
    }

    @Override
    public boolean isDamaged(ItemStack itemStack) {
        return this.getDamage(itemStack) > 0;
    }

    public String _a(String string, ItemStack itemStack) {
        return this._a(string, wolf._E(itemStack));
    }

    @ezey(_a={eidj.CLIENT})
    public String _a(String string, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        if (entityClientPlayerMP == entityLivingBase) {
            return this._a(string, ugqx._a((EntityPlayer)entityClientPlayerMP)._h);
        }
        return this._a(string, itemStack);
    }

    public boolean _l(EntityLivingBase entityLivingBase) {
        return this._t || this._U((ItemStack)this._m((EntityLivingBase)entityLivingBase))._a;
    }

    public String _a(String string, int n) {
        String string2 = string + "_" + n + "_";
        if (this._A.contains(string2)) {
            return string2;
        }
        return string;
    }

    @Override
    public EnumMap<dxwc.pidb, Set<dxwc.ezey>> _w_() {
        return this._f;
    }

    public dxwc _c(Item item) {
        return (dxwc)item;
    }

    @Override
    public float _x_() {
        return this.__ak;
    }

    @Override
    public float _y_() {
        return this.__al;
    }

    @Override
    public int _h_(ItemStack itemStack) {
        return this._B;
    }

    @ezey(_a={eidj.CLIENT})
    public GuiItem _b(GuiScreen guiScreen, EntityPlayer entityPlayer, ItemStack itemStack, int n) {
        return n < 0 ? new jibd(guiScreen, itemStack) : new sbzo(guiScreen, entityPlayer, n);
    }

    @Override
    public float _i() {
        return this.__am;
    }

    public float _a(EntityPlayer entityPlayer) {
        return this._s;
    }

    @Override
    public /* synthetic */ boolean _a(Entity entity) {
        return this._l((EntityLivingBase)entity);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public /* synthetic */ void onShootClient(Entity entity) {
        this._k((EntityLivingBase)entity);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public /* synthetic */ void spawnShell(Entity entity) {
        this._i((EntityLivingBase)entity);
    }

    @Override
    public /* synthetic */ boolean canShoot(Entity entity) {
        return this._h((EntityLivingBase)entity);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public /* synthetic */ String getShootSoundName(Entity entity) {
        return this._g((EntityLivingBase)entity);
    }

    @Override
    public /* synthetic */ float getBleedingProbability(Entity entity) {
        return this._f((EntityLivingBase)entity);
    }

    @Override
    public /* synthetic */ float getIncendiaryProbability(Entity entity) {
        return this._e((EntityLivingBase)entity);
    }

    @Override
    public /* synthetic */ float getPiercingFactor(Entity entity) {
        return this._d((EntityLivingBase)entity);
    }

    @Override
    public /* synthetic */ float getSpread(Entity entity) {
        return this._c((EntityLivingBase)entity);
    }

    @Override
    public /* synthetic */ float getDamage(Entity entity, float f) {
        return this._a((EntityLivingBase)entity, f);
    }

    @Override
    public /* synthetic */ int getNumBullets(Entity entity) {
        return this._b((EntityLivingBase)entity);
    }

    @Override
    public /* synthetic */ float getMaxDistance(Entity entity) {
        return this._a((EntityLivingBase)entity);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public /* synthetic */ GuiScreen _a(GuiScreen guiScreen, EntityPlayer entityPlayer, ItemStack itemStack, int n) {
        return this._b(guiScreen, entityPlayer, itemStack, n);
    }

    @Override
    public /* synthetic */ Item _b(Item item) {
        return this._c(item);
    }

    @Override
    public /* synthetic */ boolean _b(ItemStack itemStack, Item item, Object object) {
        return this._a(itemStack, (dxwc)item, (dxwc.pidb)((Object)object));
    }
}

