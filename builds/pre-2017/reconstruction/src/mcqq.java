/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Maps;
import gloomyfolken.mods.anomaly.jgro;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.ejection.kjui;
import gloomyfolken.mods.ejection.pidb;
import gloomyfolken.mods.stalker.misc.tupg;
import gloomyfolken.mods.weapon.WeaponMod;
import gloomyfolken.mods.weapon.ugqx;
import java.util.Arrays;
import java.util.HashMap;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.tab.PdaHandbook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraftforge.common.Configuration;
import net.smart.moving.SmartMovingContext;
import noppes.npcs.client.gui.player.GuiDialogTalk;
import noppes.npcs.client.gui.player.GuiNpcResearcher;
import noppes.npcs.client.gui.player.GuiQuestCompleted;
import noppes.npcs.client.pda.PdaQuests;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import znw.mods.stalkerguide.StalkerguideMod;
import znw.mods.stalkerguide.client.entity.EntityFakeItem;

public class mcqq {
    private Minecraft _g;
    private String _h;
    private String _i;
    private String _j;
    private String _k;
    private String _l;
    private String _m;
    private String _n;
    private String _o;
    private String _p;
    private String _q;
    private String _r;
    private String _s;
    private String _t;
    private String _u;
    private String _v;
    private String _w;
    private String _x;
    private String _y;
    private String _z;
    private String _A;
    private String _B;
    private String _C;
    private String _D;
    private String _E;
    private String _F;
    private String _G;
    private String _H;
    private String _I;
    private String _J;
    private String _K;
    private String _L;
    private String _M;
    private String _N;
    private String _O;
    private String _P;
    private String _Q;
    private String _R;
    private String _S;
    private String _T;
    private String _U;
    private String _V;
    private String _W;
    private String _X;
    private String _Y;
    private String _Z;
    private String __aa;
    private String __ab;
    private String __ac;
    private String __ad;
    private KeyBinding __ae;
    private KeyBinding __af;
    private KeyBinding __ag;
    private KeyBinding __ah;
    private KeyBinding __ai;
    private KeyBinding __aj;
    private KeyBinding __ak;
    private KeyBinding __al;
    private KeyBinding __am;
    private KeyBinding __an;
    private KeyBinding __ao;
    private KeyBinding __ap;
    private KeyBinding __aq;
    private KeyBinding __ar;
    private KeyBinding __as;
    private KeyBinding __at;
    private KeyBinding __au;
    private KeyBinding __av;
    private KeyBinding __aw;
    private KeyBinding __ax;
    private KeyBinding __ay;
    private KeyBinding __az;
    private KeyBinding __aA;
    private divz __aB;
    private Configuration __aC;
    private double __aD;
    private double __aE;
    private double __aF;
    public String _a = "\u041b\u0435\u0439\u0442\u0435\u043d\u0430\u043d\u0442 \u0412\u044b\u0440\u043e\u0434\u0438\u043d";
    public String _b = "\u0412\u044b\u0440\u043e\u0434\u0438\u043d_1";
    public String _c = "\u041e\u0440\u0435\u0445\u043e\u0432_1";
    public String _d = "\u0420\u044f\u0434\u043e\u0432\u043e\u0439_1";
    private HashMap<Integer, thfd> __aG = Maps.newHashMap();
    public int _e = -1;
    public int _f = -1;

    public mcqq(divz divz2, Configuration configuration) {
        this.__aB = divz2;
        this.__aC = configuration;
        this._g = Minecraft._E();
        this._c();
        this._a(configuration);
    }

    public void _a(Configuration configuration) {
        this.__aD = configuration.get("other", "anomalyX", this.__aD).getDouble(0.0);
        this.__aE = configuration.get("other", "anomalyY", this.__aE).getDouble(0.0);
        this.__aF = configuration.get("other", "anomalyZ", this.__aF).getDouble(0.0);
        this._a = configuration.get("other", "npcLieutenant", this._a).getString();
        this._b = configuration.get("other", "dialog1", this._b).getString();
        this._c = configuration.get("other", "dialog2", this._c).getString();
        this._d = configuration.get("other", "dialog3", this._d).getString();
        configuration.save();
    }

    private void _c() {
        this.__am = SmartMovingContext.Options.keyBindSprint;
        this.__ae = SmartMovingContext.Options.keyBindGrab;
        this.__an = this._g._M.keyBindInventory;
        this.__al = ClientProxy.interactBinding;
        this.__ay = this._g._M.keyBindAttack;
        this.__ax = ClientProxy.useBinding;
        this.__af = this._g._M.keyBindSneak;
        this.__ag = this._g._M.keyBindJump;
        this.__ah = this._g._M.keyBindForward;
        this.__ai = this._g._M.keyBindBack;
        this.__aj = this._g._M.keyBindLeft;
        this.__ak = this._g._M.keyBindRight;
        this.__ap = this._a("\u0410\u043f\u0442\u0435\u0447\u043a\u0430 1");
        this.__aq = this._a("\u0410\u043f\u0442\u0435\u0447\u043a\u0430 2");
        this.__ar = this._a("\u0410\u043f\u0442\u0435\u0447\u043a\u0430 3");
        this.__as = this._a("\u0410\u043f\u0442\u0435\u0447\u043a\u0430 4");
        this.__at = WeaponMod.instance._A;
        this.__au = WeaponMod.instance._B;
        this.__av = WeaponMod.instance._y;
        this.__ao = this._a("\u041f\u041d\u0412");
        this.__aw = ClientProxy.viewNotification;
        this.__az = this._a("\u041f\u0414\u0410");
        this.__aA = this._a("\u041b\u0435\u0447\u044c/\u0412\u0441\u0442\u0430\u0442\u044c");
    }

    private KeyBinding _a(String string) {
        for (KeyBinding keyBinding : this._g._M.keyBindings) {
            if (!keyBinding._c.equalsIgnoreCase(string)) continue;
            return keyBinding;
        }
        return null;
    }

    private String _a(KeyBinding keyBinding) {
        if (keyBinding == null) {
            return "null";
        }
        return GameSettings.getKeyDisplayString(keyBinding._d).replace("\u041a\u043d\u043e\u043f\u043a\u0430 1", "\u041b\u041a\u041c").replace("\u041a\u043d\u043e\u043f\u043a\u0430 3", "\u0421\u041a\u041c").replace("\u041a\u043d\u043e\u043f\u043a\u0430 2", "\u041f\u041a\u041c");
    }

    private thfd.kjui _a(thfd.kjui kjui2, String string) {
        if (string.isEmpty()) {
            return kjui2;
        }
        try {
            Object[] objectArray = string.replaceAll("\\s*", "").split(",");
            String string2 = StringUtils.isNumeric(objectArray[0].replace("-", "").replace(".", "").trim()) ? "" : objectArray[0];
            int n = string2.isEmpty() ? 0 : 1;
            double d = Double.parseDouble(objectArray[n].trim());
            double d2 = Double.parseDouble(objectArray[n + 1].trim());
            double d3 = Double.parseDouble(objectArray[n + 2].trim());
            boolean bl = ArrayUtils.contains(objectArray, "hide");
            boolean bl2 = ArrayUtils.contains(objectArray, "fastfinish");
            Logger.info(String.format("x: %s, y: %s, z: %s", d, d2, d3), new Object[0]);
            switch (((String)objectArray[0]).toLowerCase()) {
                case "aabb": 
                case "box": 
                case "rect": {
                    double d4 = Double.parseDouble(((String)objectArray[n + 3]).trim());
                    double d5 = Double.parseDouble(((String)objectArray[n + 4]).trim());
                    double d6 = Double.parseDouble(((String)objectArray[n + 5]).trim());
                    if (bl2) {
                        kjui2 = kjui2._c(oiwg._a()._a(d, d2, d3)._b(d4, d5, d6)._a(bl));
                        break;
                    }
                    kjui2 = kjui2._a(oiwg._a()._a(d, d2, d3)._b(d4, d5, d6)._a(bl));
                    break;
                }
                default: {
                    double d7 = Double.parseDouble(((String)objectArray[n + 3]).trim());
                    if (bl2) {
                        kjui2 = kjui2._c(oiwg._a()._a(d, d2, d3)._a(d7)._a(bl));
                        break;
                    }
                    kjui2 = kjui2._a(oiwg._a()._a(d, d2, d3)._a(d7)._a(bl));
                    break;
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return kjui2;
    }

    public thfd.kjui _a(thfd.kjui kjui2, Configuration configuration, String string) {
        String string2 = kjui2._a()._b() + "." + string;
        kjui2 = this._a(kjui2, configuration.get("controlpoints", string2, "").getString());
        return kjui2;
    }

    public thfd.kjui _a(thfd.kjui kjui2, Configuration configuration) {
        String string = kjui2._a()._b() + ".";
        String string2 = "controlPoint_";
        int n = 0;
        while (configuration.hasKey("controlpoints", string + string2 + n)) {
            kjui2 = kjui2._a(() -> "\u0414\u043e\u0431\u0435\u0440\u0438\u0442\u0435\u0441\u044c \u0434\u043e \u043a\u043e\u043d\u0442\u0440\u043e\u043b\u044c\u043d\u043e\u0439 \u0442\u043e\u0447\u043a\u0438");
            kjui2 = kjui2._a(this, configuration, string2 + n);
            if (++n <= 100) continue;
            break;
        }
        return kjui2;
    }

    private void _a(thfd thfd2) {
        int n = this.__aG.size();
        thfd2._a(n);
        this.__aG.put(n, thfd2);
    }

    private ItemStack[] _d() {
        return tupg._a((EntityPlayer)this._g._t)._c._a;
    }

    private ItemStack[] _e() {
        return this._g._t.inventory._a;
    }

    private ItemStack[] _f() {
        return this._g._t.inventory._b;
    }

    private ItemStack[] _g() {
        return ArrayUtils.addAll(this._f(), ArrayUtils.addAll(this._d(), this._e()));
    }

    private tupg _h() {
        return tupg._a(this._g._t);
    }

    private ugqx _i() {
        return ugqx._a(this._g._t);
    }

    public void _a() {
        this.__aG.clear();
        this.__aB._a((thfd)null);
        this.__aB._f();
    }

    public void _b() {
        this._c();
        this._h = String.format("\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u0439\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0438 '%s', '%s', '%s' \u0438 '%s' \u0434\u043b\u044f \u043f\u0435\u0440\u0435\u0434\u0432\u0438\u0436\u0435\u043d\u0438\u044f", this._a(this.__ah), this._a(this.__aj), this._a(this.__ai), this._a(this.__ak));
        this._i = "\u041f\u043e\u0441\u043c\u043e\u0442\u0440\u0438\u0442\u0435 \u043d\u0430 \u041b\u0435\u0439\u0442\u0435\u043d\u0430\u043d\u0442\u0430 \u0412\u044b\u0440\u043e\u0434\u0438\u043d\u0430";
        this._j = "\u041d\u0430\u0436\u043c\u0438\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0443 [" + this._a(this.__al) + "], \u0447\u0442\u043e\u0431\u044b \u043f\u043e\u0433\u043e\u0432\u043e\u0440\u0438\u0442\u044c \u0441 \u043d\u0438\u043c";
        this._k = "\u0417\u0430\u0436\u043c\u0438\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0443 [" + this._a(this.__af) + "], \u0447\u0442\u043e\u0431\u044b \u0434\u0432\u0438\u0433\u0430\u0442\u044c\u0441\u044f \u0432 \u043f\u0440\u0438\u0441\u0435\u0434\u0435";
        this._l = "\u041d\u0430\u0436\u043c\u0438\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0443 [" + this._a(this.__af) + "], \u0447\u0442\u043e\u0431\u044b \u043f\u0440\u0438\u0441\u0435\u0441\u0442\u044c\n\u041d\u0430\u0436\u043c\u0438\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0443 [" + this._a(this.__aA) + "], \u0447\u0442\u043e\u0431\u044b \u043b\u0435\u0447\u044c\n\u0414\u043b\u044f \u043f\u0435\u0440\u0435\u043c\u0435\u0449\u0435\u043d\u0438\u044f \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u0439\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0438 \u0434\u0432\u0438\u0436\u0435\u043d\u0438\u044f";
        this._m = "\u041d\u0430\u0436\u043c\u0438\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0443 [" + this._a(this.__ag).toUpperCase() + "], \u0447\u0442\u043e\u0431\u044b \u043f\u0440\u044b\u0433\u043d\u0443\u0442\u044c";
        this._n = "\u0423\u0434\u0435\u0440\u0436\u0438\u0432\u0430\u044f \u043a\u043d\u043e\u043f\u043a\u0443 [" + this._a(this.__af) + "], \u0437\u0430\u0436\u043c\u0438\u0442\u0435 [" + this._a(this.__ag) + "], \u0447\u0442\u043e\u0431\u044b \u043f\u0440\u0438\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c\u0441\u044f \u043a \u0432\u044b\u0441\u043e\u043a\u043e\u043c\u0443 \u043f\u0440\u044b\u0436\u043a\u0443\n\u0414\u043e\u0436\u0434\u0438\u0442\u0435\u0441\u044c \u0437\u0430\u043f\u043e\u043b\u043d\u0435\u043d\u0438\u044f \u0448\u043a\u0430\u043b\u044b \u0441\u0438\u043b\u044b \u043f\u0440\u044b\u0436\u043a\u0430\n\u041e\u0442\u043f\u0443\u0441\u0442\u0438\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0438, \u0447\u0442\u043e\u0431\u044b \u043f\u0440\u044b\u0433\u043d\u0443\u0442\u044c";
        this._o = "\u0421\u043e\u0432\u0435\u0440\u0448\u0438\u0442\u0435 \u0432\u044b\u0441\u043e\u043a\u0438\u0439 \u043f\u0440\u044b\u0436\u043e\u043a, \u043a\u0430\u043a \u0432 \u043f\u0440\u043e\u0448\u043b\u043e\u043c \u0448\u0430\u0433\u0435\n\u0412\u043e \u0432\u0440\u0435\u043c\u044f \u043f\u0440\u044b\u0436\u043a\u0430 \u0437\u0430\u0436\u043c\u0438\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0443 [" + this._a(this.__ae) + "], \u0447\u0442\u043e\u0431\u044b \u0437\u0430\u0446\u0435\u043f\u0438\u0442\u044c\u0441\u044f \u0437\u0430 \u0443\u0441\u0442\u0443\u043f\n\u0423\u0434\u0435\u0440\u0436\u0438\u0432\u0430\u044f [" + this._a(this.__ae) + "], \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u0439\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0443 [" + this._a(this.__ah) + "] \u0434\u043b\u044f \u0442\u043e\u0433\u043e, \u0447\u0442\u043e\u0431\u044b \u0437\u0430\u0431\u0440\u0430\u0442\u044c\u0441\u044f \u043d\u0430 \u0443\u0441\u0442\u0443\u043f";
        this._p = "\u0417\u0430\u0436\u043c\u0438\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0438 [" + this._a(this.__am) + "] \u0438 [" + this._a(this.__ah) + "], \u0447\u0442\u043e\u0431\u044b \u0431\u0435\u0436\u0430\u0442\u044c. \n\u0416\u0435\u043b\u0442\u0430\u044f \u0448\u043a\u0430\u043b\u0430 \u0432 \u043f\u0440\u0430\u0432\u043e\u043c \u0443\u0433\u043b\u0443 \u044d\u043a\u0440\u0430\u043d\u0430 \u043f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u0443\u0440\u043e\u0432\u0435\u043d\u044c \u0432\u044b\u043d\u043e\u0441\u043b\u0438\u0432\u043e\u0441\u0442\u0438. \n\u0415\u0441\u043b\u0438 \u043e\u043d \u043e\u043f\u0443\u0441\u0442\u0438\u0442\u0441\u044f \u0434\u043e 0, \u0432\u044b \u043d\u0435 \u0441\u043c\u043e\u0436\u0435\u0442\u0435 \u0431\u0435\u0433\u0430\u0442\u044c \u0438\u043b\u0438 \u043f\u0440\u044b\u0433\u0430\u0442\u044c\n\u0414\u043e\u0431\u0435\u0440\u0438\u0442\u0435\u0441\u044c \u0434\u043e \u043a\u043e\u043d\u0442\u0440\u043e\u043b\u044c\u043d\u043e\u0439 \u0442\u043e\u0447\u043a\u0438";
        this._q = "\u041d\u0430\u0436\u043c\u0438\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0443 [" + this._a(this.__an) + "], \u0447\u0442\u043e\u0431\u044b \u043e\u0442\u043a\u0440\u044b\u0442\u044c \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c";
        this._r = "\u041d\u0430\u0436\u043c\u0438\u0442\u0435 [" + this._a(this.__ay) + "] \u043f\u043e \u0438\u043a\u043e\u043d\u043a\u0435 \u0435\u0434\u044b, \u0447\u0442\u043e\u0431\u044b \u043f\u0435\u0440\u0435\u043c\u0435\u0449\u0430\u0442\u044c \u0435\u0451 \n\u041f\u0435\u0440\u0435\u043c\u0435\u0441\u0442\u0438\u0442\u0435 \u0435\u0434\u0443 \u0432 \u043e\u0434\u0438\u043d \u0438\u0437 \u0441\u043b\u043e\u0442\u043e\u0432 \u0431\u044b\u0441\u0442\u0440\u043e\u0433\u043e \u0434\u043e\u0441\u0442\u0443\u043f\u0430";
        this._s = "\u0421\u044a\u0435\u0448\u0442\u0435 \u0435\u0434\u0443, \u043d\u0430\u0436\u0430\u0432 \u043a\u043b\u0430\u0432\u0438\u0448\u0443 [" + this._a(this.__ap) + "]-[" + this._a(this.__as) + "]";
        this._t = "\u041f\u0435\u0440\u0435\u043c\u0435\u0441\u0442\u0438\u0442\u0435 \u0430\u043f\u0442\u0435\u0447\u043a\u0443 \u0432 \u043e\u0434\u0438\u043d \u0438\u0437 \u0441\u043b\u043e\u0442\u043e\u0432 \u0431\u044b\u0441\u0442\u0440\u043e\u0433\u043e \u0434\u043e\u0441\u0442\u0443\u043f\u0430";
        this._u = "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u0439\u0442\u0435 \u0430\u043f\u0442\u0435\u0447\u043a\u0443, \u043d\u0430\u0436\u0430\u0432 \u043a\u043b\u0430\u0432\u0438\u0448\u0443 [" + this._a(this.__ap) + "-" + this._a(this.__as) + "]";
        this._v = "\u041f\u0435\u0440\u0435\u043c\u0435\u0441\u0442\u0438\u0442\u0435 \u0440\u044e\u043a\u0437\u0430\u043a \u0432 \u0441\u043b\u043e\u0442 \u0441\u043f\u0438\u043d\u044b";
        this._w = "\u041f\u043e\u0434\u043e\u0439\u0434\u0438\u0442\u0435 \u043a \u0442\u0430\u0439\u043d\u0438\u043a\u0443\n\u041d\u0430\u0432\u0435\u0434\u0438\u0442\u0435\u0441\u044c \u043d\u0430 \u043d\u0435\u0433\u043e \u0438 \u043d\u0430\u0436\u043c\u0438\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0443 [" + this._a(this.__al) + "], \u0447\u0442\u043e\u0431\u044b \u043e\u0442\u043a\u0440\u044b\u0442\u044c";
        this._x = "\u041f\u0435\u0440\u0435\u043c\u0435\u0441\u0442\u0438\u0442\u0435 \u0441\u043d\u0430\u0440\u044f\u0436\u0435\u043d\u0438\u0435 \u0438\u0437 \u044f\u0449\u0438\u043a\u0430 \u0432 \u0441\u0432\u043e\u0439 \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c \n[SHIFT+" + this._a(this.__ax) + "] \u0434\u043b\u044f \u0431\u044b\u0441\u0442\u0440\u043e\u0433\u043e \u043f\u0435\u0440\u0435\u043c\u0435\u0449\u0435\u043d\u0438\u044f";
        this._y = "\u041f\u0435\u0440\u0435\u043c\u0435\u0441\u0442\u0438\u0442\u0435 \u043e\u0440\u0443\u0436\u0438\u0435 \u0432 \u043e\u0434\u0438\u043d \u0438\u0437 \u0430\u043a\u0442\u0438\u0432\u043d\u044b\u0445 \u0441\u043b\u043e\u0442\u043e\u0432\n\u0438 \u0432\u043e\u0437\u044c\u043c\u0438\u0442\u0435 \u0432 \u0440\u0443\u043a\u0438 \u0441 \u043f\u043e\u043c\u043e\u0449\u044c\u044e \u043a\u043e\u043b\u0451\u0441\u0438\u043a\u0430 \u043c\u044b\u0448\u0438.";
        this._z = "\u041f\u043e\u0434\u043e\u0439\u0434\u0438\u0442\u0435 \u043a \u0441\u0442\u0440\u0435\u043b\u044c\u0431\u0438\u0449\u0443";
        this._A = "\u041d\u0430\u0436\u043c\u0438\u0442\u0435 [" + this._a(this.__ay) + "], \u0447\u0442\u043e\u0431\u044b \u0441\u0442\u0440\u0435\u043b\u044f\u0442\u044c \n\u041f\u043e\u0440\u0430\u0437\u0438\u0442\u0435 \u043c\u0438\u0448\u0435\u043d\u044c";
        this._B = "\u0417\u0430\u0436\u043c\u0438\u0442\u0435 [" + this._a(this.__ax) + "], \u0447\u0442\u043e\u0431\u044b \u043f\u0435\u0440\u0435\u0439\u0442\u0438 \u0432 \u0440\u0435\u0436\u0438\u043c \u043f\u0440\u0438\u0446\u0435\u043b\u0438\u0432\u0430\u043d\u0438\u044f\n\u041f\u043e\u0440\u0430\u0437\u0438\u0442\u0435 \u043c\u0438\u0448\u0435\u043d\u044c \u0432 \u0440\u0435\u0436\u0438\u043c\u0435 \u043f\u0440\u0438\u0446\u0435\u043b\u0438\u0432\u0430\u043d\u0438\u044f";
        this._C = "\u041d\u0430\u0436\u043c\u0438\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0443 [" + this._a(this.__av) + "], \u0447\u0442\u043e\u0431\u044b \u0440\u0430\u0441\u043a\u043b\u0438\u043d\u0438\u0442\u044c \u043e\u0440\u0443\u0436\u0438\u0435";
        this._D = "\u0427\u0442\u043e\u0431\u044b \u0441\u043c\u0435\u043d\u0438\u0442\u044c \u0442\u0438\u043f \u043f\u0430\u0442\u0440\u043e\u043d\u043e\u0432, \u0437\u0430\u0436\u043c\u0438\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0443 [" + this._a(this.__av) + "] \u0438 \u0432\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u043d\u0443\u0436\u043d\u044b\u0439\n\u041f\u043e\u0440\u0430\u0437\u0438\u0442\u0435 \u043c\u0438\u0448\u0435\u043d\u044c \u0431\u0440\u043e\u043d\u0435\u0431\u043e\u0439\u043d\u044b\u043c\u0438 \u043f\u0443\u043b\u044f\u043c\u0438";
        this._E = "\u0427\u0442\u043e\u0431\u044b \u0441\u043c\u0435\u043d\u0438\u0442\u044c \u0440\u0435\u0436\u0438\u043c \u0441\u0442\u0440\u0435\u043b\u044c\u0431\u044b, \u043d\u0430\u0436\u043c\u0438\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0443 [" + this._a(this.__at) + "]\n\u041f\u043e\u0440\u0430\u0437\u0438\u0442\u0435 \u043c\u0438\u0448\u0435\u043d\u044c \u0432 \u0440\u0435\u0436\u0438\u043c\u0435 '\u041e\u0442\u0441\u0435\u0447\u043a\u0430 \u043e\u0447\u0435\u0440\u0435\u0434\u0438'";
        this._F = "\u041e\u0442\u043a\u0440\u043e\u0439\u0442\u0435 \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c \u0438 \u043d\u0430\u0436\u043c\u0438\u0442\u0435 [" + this._a(this.__ax) + "] \u043f\u043e \u0438\u043a\u043e\u043d\u043a\u0435 \u043e\u0440\u0443\u0436\u0438\u044f, \n\u0447\u0442\u043e\u0431\u044b \u043e\u0442\u043a\u0440\u044b\u0442\u044c \u043c\u0435\u043d\u044e \u043c\u043e\u0434\u0438\u0444\u0438\u043a\u0430\u0446\u0438\u0438";
        this._G = "\u041d\u0430\u0436\u043c\u0438\u0442\u0435 [" + this._a(this.__ay) + "] \u043f\u043e \u0441\u043b\u043e\u0442\u0443 \u201c\u043f\u043e\u0434\u0441\u0442\u0432\u043e\u043b\u044c\u043d\u043e\u0435 \u043a\u0440\u0435\u043f\u043b\u0435\u043d\u0438\u0435\u201d \n\u0438 \u0432\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0439 \u043f\u043e\u0434\u0441\u0442\u0432\u043e\u043b\u044c\u043d\u044b\u0439 \u0433\u0440\u0430\u043d\u0430\u0442\u043e\u043c\u0451\u0442";
        this._H = "\u0427\u0442\u043e\u0431\u044b \u043f\u0435\u0440\u0435\u043a\u043b\u044e\u0447\u0438\u0442\u044c\u0441\u044f \u043d\u0430 \u043f\u043e\u0434\u0441\u0442\u0432\u043e\u043b\u044c\u043d\u044b\u0439 \u0433\u0440\u0430\u043d\u0430\u0442\u043e\u043c\u0451\u0442, \u043d\u0430\u0436\u043c\u0438\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0443 [" + this._a(this.__au) + "]\n\u041f\u043e\u0440\u0430\u0437\u0438\u0442\u0435 \u043c\u0438\u0448\u0435\u043d\u044c \u0438\u0437 \u043f\u043e\u0434\u0441\u0442\u0432\u043e\u043b\u044c\u043d\u043e\u0433\u043e \u0433\u0440\u0430\u043d\u0430\u0442\u043e\u043c\u0451\u0442\u0430";
        this._I = "\u041f\u043e\u043c\u0435\u0441\u0442\u0438\u0442\u0435 \u0431\u043e\u043b\u0442 \u0432 \u043e\u0434\u0438\u043d \u0438\u0437 \u0430\u043a\u0442\u0438\u0432\u043d\u044b\u0445 \u0441\u043b\u043e\u0442\u043e\u0432 \u0438 \u0432\u043e\u0437\u044c\u043c\u0438\u0442\u0435 \u0432 \u0440\u0443\u043a\u0438 \u0441 \u043f\u043e\u043c\u043e\u0449\u044c\u044e [\u0421\u041a\u041c]";
        this._J = "\u041d\u0430\u0446\u0435\u043b\u044c\u0442\u0435\u0441\u044c \u043d\u0430 \u0430\u043d\u043e\u043c\u0430\u043b\u0438\u044e \u0438 \u043d\u0430\u0436\u043c\u0438\u0442\u0435 [" + this._a(this.__ay) + "] \u0434\u043b\u044f \u043e\u0431\u044b\u0447\u043d\u043e\u0433\u043e \u0431\u0440\u043e\u0441\u043a\u0430\n\u0438\u043b\u0438 \u0437\u0430\u0436\u043c\u0438\u0442\u0435 [" + this._a(this.__ax) + "] \u0434\u043b\u044f \u0441\u0438\u043b\u044c\u043d\u043e\u0433\u043e \u0431\u0440\u043e\u0441\u043a\u0430";
        this._K = "\u041f\u0435\u0440\u0435\u043c\u0435\u0441\u0442\u0438\u0442\u0435 \u0433\u0440\u0430\u043d\u0430\u0442\u0443 \u0432 \u043e\u0434\u0438\u043d \u0438\u0437 \u0430\u043a\u0442\u0438\u0432\u043d\u044b\u0445 \u0441\u043b\u043e\u0442\u043e\u0432 \u0438 \u0432\u043e\u0437\u044c\u043c\u0438\u0442\u0435 \u0432 \u0440\u0443\u043a\u0438 \u0441 \u043f\u043e\u043c\u043e\u0449\u044c\u044e [\u0421\u041a\u041c]\n\u041d\u0430\u0436\u043c\u0438\u0442\u0435 [" + this._a(this.__ay) + "] \u0434\u043b\u044f \u043e\u0431\u044b\u0447\u043d\u043e\u0433\u043e \u0431\u0440\u043e\u0441\u043a\u0430 \u0438\u043b\u0438 \u0437\u0430\u0436\u043c\u0438\u0442\u0435 [" + this._a(this.__ax) + "] \u0434\u043b\u044f \u0441\u0438\u043b\u044c\u043d\u043e\u0433\u043e \u0431\u0440\u043e\u0441\u043a\u0430\n\u0417\u0430\u0431\u0440\u043e\u0441\u044c\u0442\u0435 \u0433\u0440\u0430\u043d\u0430\u0442\u0443 \u0432 \u0443\u043a\u0430\u0437\u0430\u043d\u043d\u0443\u044e \u043e\u0431\u043b\u0430\u0441\u0442\u044c";
        this._L = "\u041f\u0435\u0440\u0435\u043c\u0435\u0441\u0442\u0438\u0442\u0435 \u041f\u041d\u0412 \u0432 \u0441\u043b\u043e\u0442 \u0433\u043e\u043b\u043e\u0432\u044b\n\u041d\u0430\u0436\u043c\u0438\u0442\u0435 [" + this._a(this.__ao) + "], \u0447\u0442\u043e\u0431\u044b \u0432\u043a\u043b\u044e\u0447\u0438\u0442\u044c \u041f\u041d\u0412\n\u0414\u043e\u0431\u0435\u0440\u0438\u0442\u0435\u0441\u044c \u0434\u043e \u043a\u043e\u043d\u0442\u0440\u043e\u043b\u044c\u043d\u043e\u0439 \u0442\u043e\u0447\u043a\u0438";
        this._M = "\u0423\u043a\u0440\u043e\u0439\u0442\u0435\u0441\u044c \u0432 \u0431\u0443\u043d\u043a\u0435\u0440\u0435";
        this._N = "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u0435\u0441\u044c \u043d\u0430 \u0441\u0435\u0439\u0432\u0437\u043e\u043d\u0435";
        this._O = "\u041f\u0435\u0440\u0435\u0436\u0434\u0438\u0442\u0435 \u0432\u044b\u0431\u0440\u043e\u0441";
        this._P = "\u041f\u043e\u0434\u043e\u0439\u0434\u0438\u0442\u0435 \u043a \u0430\u0440\u0442\u0435\u0444\u0430\u043a\u0442\u0443\n\u041d\u0430\u0432\u0435\u0434\u0438\u0442\u0435\u0441\u044c \u043d\u0430 \u0430\u0440\u0442\u0435\u0444\u0430\u043a\u0442 \u0438 \u043a\u043d\u043e\u043f\u043a\u0443 [" + this._a(this.__al) + "], \u0447\u0442\u043e\u0431\u044b \u043f\u043e\u0434\u043e\u0431\u0440\u0430\u0442\u044c \u0435\u0433\u043e";
        this._Q = "\u041f\u043e\u0434\u043e\u0439\u0434\u0438\u0442\u0435 \u043a \u0443\u0447\u0435\u043d\u043e\u043c\u0443 \u0438 \u043d\u0430\u0436\u043c\u0438\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0443 [" + this._a(this.__al) + "], \u0447\u0442\u043e\u0431\u044b \u0432\u0437\u0430\u0438\u043c\u043e\u0434\u0435\u0439\u0441\u0442\u0432\u043e\u0432\u0430\u0442\u044c \u0441 \u043d\u0438\u043c";
        this._R = "\u041f\u0435\u0440\u0435\u043c\u0435\u0441\u0442\u0438\u0442\u0435 \u0430\u0440\u0442\u0435\u0444\u0430\u043a\u0442 \u0432 \u0441\u043b\u043e\u0442 \u0434\u043b\u044f \u0438\u0437\u0443\u0447\u0435\u043d\u0438\u044f \u0438 \u043d\u0430\u0436\u043c\u0438\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0443 \"\u0418\u0437\u0443\u0447\u0438\u0442\u044c\"\n\u0417\u0430\u0431\u0435\u0440\u0438\u0442\u0435 \u0438\u0437\u0443\u0447\u0435\u043d\u043d\u044b\u0439 \u0430\u0440\u0442\u0435\u0444\u0430\u043a\u0442";
        this._S = "\u041d\u0430\u0436\u043c\u0438\u0442\u0435 [" + this._a(this.__ax) + "] \u043f\u043e \u0438\u043a\u043e\u043d\u043a\u0435 \u043a\u043e\u043d\u0442\u0435\u0439\u043d\u0435\u0440\u0430, \u0447\u0442\u043e\u0431\u044b \u043e\u0442\u043a\u0440\u044b\u0442\u044c \u0435\u0433\u043e\n\u041f\u043e\u043c\u0435\u0441\u0442\u0438\u0442\u0435 \u0430\u0440\u0442\u0435\u0444\u0430\u043a\u0442 \u0432 \u043e\u0434\u0438\u043d \u0438\u0437 \u0441\u043b\u043e\u0442\u043e\u0432 \u043a\u043e\u043d\u0442\u0435\u0439\u043d\u0435\u0440\u0430";
        this._T = "\u041f\u0435\u0440\u0435\u043c\u0435\u0441\u0442\u0438\u0442\u0435 \u043a\u043e\u043d\u0442\u0435\u0439\u043d\u0435\u0440 \u0432 \u0441\u043b\u043e\u0442 \u0441\u043f\u0438\u043d\u044b";
        this._U = "\u041f\u0435\u0440\u0435\u043c\u0435\u0441\u0442\u0438\u0442\u0435 \u0434\u0435\u0442\u0435\u043a\u0442\u043e\u0440 \u0432 \u0441\u043e\u043e\u0442\u0432\u0435\u0442\u0441\u0442\u0432\u0443\u044e\u0449\u0438\u0439 \u0441\u043b\u043e\u0442";
        this._V = "\u041d\u0430\u0439\u0434\u0438\u0442\u0435 \u0438\u0441\u0442\u043e\u0447\u043d\u0438\u043a \u0437\u0430\u0440\u0430\u0436\u0435\u043d\u0438\u044f";
        this._W = "\u041f\u043e\u043c\u0435\u0441\u0442\u0438\u0442\u0435 \u043a\u043e\u043c\u043f\u043b\u0435\u043a\u0442 \u0445\u0438\u043c\u0437\u0430\u0449\u0438\u0442\u044b \u0432 \u0441\u043b\u043e\u0442 \u043a\u043e\u0441\u0442\u044e\u043c\u0430";
        this._X = "\u041f\u0440\u043e\u0439\u0434\u0438\u0442\u0435 \u0447\u0435\u0440\u0435\u0437 \u0437\u0430\u0440\u0430\u0436\u0435\u043d\u0438\u0435";
        this._Y = "\u041d\u0430\u0436\u043c\u0438\u0442\u0435 \u043a\u043d\u043e\u043f\u043a\u0443 [" + this._a(this.__az) + "], \u0447\u0442\u043e\u0431\u044b \u043e\u0442\u043a\u0440\u044b\u0442\u044c \u041f\u0414\u0410";
        this._Z = "\u041d\u0430\u0439\u0434\u0438\u0442\u0435 \u0438 \u043f\u0440\u043e\u0441\u043c\u043e\u0442\u0440\u0438\u0442\u0435 \u0438\u043d\u0441\u0442\u0440\u0443\u043a\u0446\u0438\u044e \u043f\u043e \u0440\u0430\u0431\u043e\u0442\u0435 \u0441 \u041f\u0414\u0410\n\u0421\u041f\u0420\u0410\u0412\u041e\u0427\u041d\u0418\u041a - \u0420\u0410\u0411\u041e\u0422\u0410 \u0421 \u041f\u0414\u0410";
        this.__aa = "\u041f\u043e\u0433\u043e\u0432\u043e\u0440\u0438\u0442\u0435 \u0441 \u041b\u0435\u0439\u0442\u0435\u043d\u0430\u043d\u0442\u043e\u043c \u041e\u0440\u0435\u0445\u043e\u0432\u044b\u043c";
        this.__ab = "\u041d\u0430\u0436\u043c\u0438\u0442\u0435 K, \u0447\u0442\u043e\u0431\u044b \u043e\u0442\u043a\u0440\u044b\u0442\u044c \u0436\u0443\u0440\u043d\u0430\u043b \u0437\u0430\u0434\u0430\u043d\u0438\u0439\n\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0437\u0430\u0434\u0430\u043d\u0438\u0435 \u0438 \u043f\u0440\u043e\u0447\u0438\u0442\u0430\u0439\u0442\u0435 \u043b\u043e\u0433";
        this.__ac = "\u041f\u043e\u0434\u043e\u0439\u0434\u0438\u0442\u0435 \u043a \u043b\u044e\u0431\u043e\u043c\u0443 \u0420\u044f\u0434\u043e\u0432\u043e\u043c\u0443 \u0437\u0430 \u0441\u0442\u043e\u043b\u043e\u043c \u0438 \u0437\u0430\u0431\u0435\u0440\u0438\u0442\u0435 \u0443 \u043d\u0435\u0433\u043e \u043f\u0440\u043e\u043f\u0443\u0441\u043a\n\u041e\u0442\u043d\u0435\u0441\u0438\u0442\u0435 \u043f\u0440\u043e\u043f\u0443\u0441\u043a \u041b\u0435\u0439\u0442\u0435\u043d\u0430\u043d\u0442\u0443 \u041e\u0440\u0435\u0445\u043e\u0432\u0443";
        this.__ad = "\u041f\u043e\u0433\u043e\u0432\u043e\u0440\u0438\u0442\u0435 \u0441 \u041b\u0435\u0439\u0442\u0435\u043d\u0430\u043d\u0442\u043e\u043c \u041e\u0440\u0435\u0445\u043e\u0432\u044b\u043c, \u0447\u0442\u043e\u0431\u044b \u043e\u0442\u043f\u0440\u0430\u0432\u0438\u0442\u044c\u0441\u044f \u0432 \u0433\u043e\u0440\u043e\u0434";
    }

    public void _a(EntityPlayerSP entityPlayerSP, int n) {
        this._b();
        this._a();
        this.__aC.load();
        StalkerguideMod._b._e = false;
        this._a(thfd._a("basicMovement")._a(() -> this._h)._c(cfuq._a()._a(this.__ah)._b())._c(cfuq._a()._a(this.__aj)._b())._c(cfuq._a()._a(this.__ai)._b())._c(cfuq._a()._a(this.__ak)._b())._a(this, this.__aC)._c());
        this._a(thfd._a("npcAct")._a(() -> this._i)._a(gsax._a()._a(this._a))._a(() -> this._j)._a(iyhq._a()._a(GuiDialogTalk.class))._a(this, this.__aC)._c());
        this._a(thfd._a("sneak")._a(() -> this._k)._a(this, this.__aC, "controlPoint_0")._a(this, this.__aC, "controlPoint_1")._c());
        this._a(thfd._a("crawl")._a(() -> this._l)._a(this, this.__aC, "controlPoint_0")._a(this, this.__aC, "controlPoint_1")._c());
        this._a(thfd._a("jump")._a(() -> this._m)._a(cfuq._a()._a(this.__ag)._b())._a(this, this.__aC)._c());
        this._a(thfd._a("highJump")._a(() -> this._n)._a(this, this.__aC, "controlPoint_0")._a(this, this.__aC, "controlPoint_1")._c());
        this._a(thfd._a("jumpClimb")._a(() -> this._o)._a(this, this.__aC, "controlPoint_0")._c());
        this._a(thfd._a("sprint")._a(() -> this._p)._a(this, this.__aC, "runTo")._c());
        this._a(thfd._a("openInventory")._a(() -> this._q)._a(iyhq._a()._a(nuis.class)._b())._a(this, this.__aC)._c());
        this._a(thfd._a("eatShit")._a(() -> this._r)._a(cwvw._a()._a(() -> this._a(new ItemStack(26512, 1, 0))), (cfum cfum2) -> this._k() && this._a(this._d(), 26512, 8, 4))._a(() -> this._s)._a(cwvw._a(), (cfum cfum2) -> {
            boolean bl;
            boolean bl2 = bl = this._k() && !this._a(this._e(), 26512, 0, 100) && !this._a(this._d(), 26512, 0, 100);
            if (bl) {
                this._g._t.playSound("damage.fallsmall", 1.0f, 1.0f);
            }
            return bl;
        })._a(this, this.__aC)._c());
        this._a(thfd._a("medicine")._a(() -> this._t)._a(cwvw._a()._a(() -> this._a(new ItemStack(26000, 1, 0))), (cfum cfum2) -> this._k() && this._a(this._d(), 26000, 8, 4))._a(() -> this._u)._a(cwvw._a(), (cfum cfum2) -> this._h()._h > 1)._a(this, this.__aC)._c());
        this._a(thfd._a("backpack")._a(() -> this._v)._a(cwvw._a()._a(() -> this._a(new ItemStack(12125, 1, 0))), (cfum cfum2) -> this._a(this._d(), 12125, 12, 1))._a(this, this.__aC)._c());
        this._a(thfd._a("stash")._a(() -> this._w)._a(this, this.__aC, "stashloc")._c(iyhq._a()._a(GuiChest.class))._a(() -> this._x)._a(this, this.__aC, "stashloc")._b(cwvw._a(), cfum2 -> this._a(this._e(), 20025, 0, 100) && this._a(this._e(), 12714, 0, 100) && this._a(this._e(), 12715, 0, 100) && this._a(this._e(), 12344, 0, 100) && this._a(this._e(), 12348, 0, 100))._a(this, this.__aC)._c());
        this._a(thfd._a("weaponEquip")._a(() -> this._y)._a(cwvw._a()._a(() -> {
            this._a(new ItemStack(20025, 1, 0));
            this._a(new ItemStack(12714, 100, 0));
            this._a(new ItemStack(12715, 100, 0));
        }), (cfum cfum2) -> this._a(this._e(), 20025, 0, 4))._a(this, this.__aC)._c());
        this._a(thfd._a("shoot")._a(() -> this._z)._a(this, this.__aC, "shoot_0")._a(this, this.__aC, "shoot_1")._a(() -> this._A)._a(cwvw._a(), (cfum cfum2) -> this._a(1) || this._a(3) || this._a(2) || this._a(8))._a(this, this.__aC)._c());
        this._a(thfd._a("aim")._a(() -> this._B)._a(cwvw._a(), (cfum cfum2) -> (this._a(1) || this._a(3) || this._a(2) || this._a(8)) && this._i()._l())._a(this, this.__aC)._c());
        this._a(thfd._a("reload")._a(() -> this._C)._a(cwvw._a(), (cfum cfum2) -> {
            if (this._g._t.getHeldItem() != null && this._g._t.getHeldItem()._a() instanceof wolf) {
                wolf._b(this._g._t.getHeldItem(), true);
            }
            return this._i()._n();
        })._a(this, this.__aC)._c());
        this._a(thfd._a("ammoType")._a(() -> this._D)._a(cwvw._a(), (cfum cfum2) -> this._a(2) || this._a(8))._a(this, this.__aC)._c());
        this._a(thfd._a("fireType")._a(() -> this._E)._a(cwvw._a(), (cfum cfum2) -> this._a(3) || this._a(8))._a(this, this.__aC)._c());
        this._a(thfd._a("weaponMod")._a(() -> this._F)._c(iyhq._a()._a(sbzo.class))._a(() -> this._G)._a(cwvw._a()._a(() -> this._a(new ItemStack(17000, 1, 0))), (cfum cfum2) -> {
            ItemStack itemStack = this._g._t.getCurrentEquippedItem();
            if (itemStack != null && itemStack._a() instanceof wolf) {
                wolf wolf2 = (wolf)itemStack._a();
                return wolf2._a(itemStack, dxwc.eidj._c) != null;
            }
            return false;
        })._a(this, this.__aC)._c());
        this._a(thfd._a("grenadeLauncher")._a(() -> this._z)._a(this, this.__aC, "shoot_0")._a(this, this.__aC, "shoot_1")._a(() -> this._H)._a(cwvw._a(), (cfum cfum2) -> this._a(4) && this._i()._f())._a(this, this.__aC)._c());
        this._a(thfd._a("bolt")._a(() -> this._I)._b(gsbl._a()._a(() -> this._a(new ItemStack(14987, 1, 0))))._a(cwvw._a(), (cfum cfum2) -> this._g._t.getCurrentEquippedItem() != null && this._g._t.getCurrentEquippedItem()._a() instanceof jgro)._a(() -> this._J)._a(cwvw._a(), (cfum cfum2) -> this._a(0))._a(this, this.__aC)._c());
        this._a(thfd._a("grenade")._a(() -> this._K)._a(this, this.__aC, "throwMarker")._b(cwvw._a(), cfum2 -> this._a(4))._a(this, this.__aC)._c());
        this._a(thfd._a("nightvision")._a(() -> this._L)._a(cwvw._a()._a(() -> this._a(new ItemStack(25500, 1, 0))), (cfum cfum2) -> this._h()._l)._a(this, this.__aC)._c());
        this._a(thfd._a("ejection")._a(() -> this._M)._a(cwvw._a(), (cfum cfum2) -> {
            this._a(true);
            return false;
        })._a(this, this.__aC, "hideout")._a(() -> this._N)._a(cwvw._a(), (cfum cfum2) -> {
            this._a(true);
            return false;
        })._a(this, this.__aC, "hideout_in")._b(cwvw._a(), cfum2 -> this._a(5))._c());
        this._a(thfd._a("ejection_saved")._a(() -> this._O)._b(gsbl._a()._a(this::_j))._a(cwvw._a(), (cfum cfum2) -> {
            this._a(false);
            return kjui._a._b == null;
        })._a(this, this.__aC)._c());
        this._a(thfd._a("artefakt")._a(() -> this._P)._a(gsax._a()._a(EntityItem.class)._a(() -> {
            EntityFakeItem entityFakeItem = new EntityFakeItem(this._g._r, this.__aD, this.__aE, this.__aF, new ItemStack(11051, 1, 0));
            this._g._r.spawnEntityInWorld(entityFakeItem);
        }), (cfum cfum2) -> {
            if (this._g._L._c == EnumMovingObjectType._b && this._g._L._i instanceof EntityItem) {
                boolean bl;
                EntityItem entityItem = (EntityItem)this._g._L._i;
                ItemStack itemStack = entityItem.getEntityItem();
                boolean bl2 = bl = itemStack != null && itemStack._d == 11051 && entityItem.age <= 1;
                if (bl) {
                    entityItem.setDead();
                    this._a(new ItemStack(11051, 1, 0), 0);
                }
                return bl;
            }
            return false;
        })._a(cwvw._a(), (cfum cfum2) -> this._b(11051))._a(this, this.__aC)._c());
        this._a(thfd._a("artefaktExamine")._a(() -> this._Q)._b(gsbl._a()._a(() -> this._a(new ItemStack(11051, 1, 0))))._a(iyhq._a()._a(GuiNpcResearcher.class))._a(() -> this._R)._a(cwvw._a(), (cfum cfum2) -> Arrays.stream(this._g()).anyMatch(itemStack -> itemStack != null && itemStack._a() instanceof cdit && ((cdit)itemStack._a())._a((ItemStack)itemStack)))._a(this, this.__aC)._c());
        this._a(thfd._a("artefaktEquip")._a(() -> this._S)._b(gsbl._a()._a(() -> {
            this._a(new ItemStack(11051, 1, 0));
            this._a(new ItemStack(12030, 1, 0));
        }))._a(cwvw._a(), (cfum cfum2) -> Arrays.stream(this._g()).anyMatch(itemStack -> {
            if (itemStack != null && itemStack._a() instanceof brhe) {
                brhe brhe2 = (brhe)itemStack._a();
                if (brhe2._d > 0) {
                    return !brhe2._k_((ItemStack)itemStack).isEmpty();
                }
            }
            return false;
        }))._a(() -> this._T)._a(cwvw._a(), (cfum cfum2) -> this._a(this._d(), 12030, 12, 1))._a(this, this.__aC)._c());
        this._a(thfd._a("detector")._a(() -> this._U)._a(cwvw._a()._a(() -> this._a(new ItemStack(14959, 1, 0))), (cfum cfum2) -> this._a(this._d(), 14959, 5, 3))._a(() -> this._V)._a(cwvw._a(), (cfum cfum2) -> this._h()._w[klcb._c.ordinal()] > 0.0f)._a(this, this.__aC)._c());
        this._a(thfd._a("contamination")._a(() -> this._W)._b(gsbl._a()._a(() -> this._a(new ItemStack(25061, 1, 0))))._a(cwvw._a(), (cfum cfum2) -> this._a(this._f(), 25061, 0, 4))._a(() -> this._X)._a(this, this.__aC, "radiationSource")._a(this, this.__aC)._c());
        this._a(thfd._a("pda")._a(() -> this._Y)._a(iyhq._a()._a(GuiPda.class))._a(() -> this._Z)._a(cwvw._a(), (cfum cfum2) -> {
            GuiScreen guiScreen = this._g._B;
            return guiScreen instanceof GuiPda && ((GuiPda)guiScreen).currentTab instanceof PdaHandbook;
        })._a(this, this.__aC)._c());
        this._a(thfd._a("questLog")._a(() -> this.__aa)._a(iyhq._a()._a(GuiDialogTalk.class))._a(() -> this.__ab)._a(cwvw._a(), (cfum cfum2) -> {
            GuiScreen guiScreen = this._g._B;
            return guiScreen instanceof GuiPda && ((GuiPda)guiScreen).currentTab instanceof PdaQuests;
        })._a(this, this.__aC)._c());
        this._a(thfd._a("waypoints")._a(() -> this.__ac)._a(iyhq._a()._a(GuiQuestCompleted.class)._c())._c());
        this._a(thfd._a("final")._a(() -> "")._a(cwvw._a()._a(() -> new hvdo().sendToServer()))._c());
        this.__aB._a(this.__aG.get(n));
        String string = "\u0412\u041d\u0418\u041c\u0410\u041d\u0418\u0415, \u0432\u0441\u0435 \u0434\u0430\u043d\u043d\u044b\u0435 \u043e\u0431 \u043e\u0434\u043d\u043e\u0439 \u043a\u043e\u043d\u0442\u0440\u043e\u043b\u044c\u043d\u043e\u0439 \u0442\u043e\u0447\u043a\u0435 \u0437\u0430\u043f\u0438\u0441\u044b\u0432\u0430\u044e\u0442\u0441\u044f \u0432 \u043e\u0434\u043d\u0443 \u0441\u0442\u0440\u043e\u043a\u0443!\n\u0412\u0441\u0435 \u043a\u043e\u043d\u0442\u0440\u043e\u043b\u044c\u043d\u044b\u0435 \u0442\u043e\u0447\u043a\u0438, \u0443 \u043a\u043e\u0442\u043e\u0440\u044b\u0445 \u0432 \u043a\u043b\u044e\u0447\u0435 (\u0434\u043e \u0437\u043d\u0430\u043a\u0430 '=') \u043d\u0430 \u043a\u043e\u043d\u0446\u0435 \u0435\u0441\u0442\u044c \u0447\u0430\u0441\u0442\u044c controlPoint_\n\u0434\u043e\u0431\u0430\u0432\u043b\u044f\u044e\u0442\u0441\u044f \u0430\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0432 \u043a\u043e\u043d\u0446\u0435 \u0443\u043a\u0430\u0437\u0430\u043d\u043d\u043e\u0433\u043e \u0437\u0430\u0434\u0430\u043d\u0438\u044f. \u041e\u0441\u0442\u0430\u043b\u044c\u043d\u044b\u0435 - \u0437\u0430\u0441\u043a\u0440\u0438\u043f\u0442\u043e\u0432\u0430\u043d\u044b \u0438 \u043e\u0431\u044f\u0437\u0430\u0442\u0435\u043b\u044c\u043d\u044b.\n\u0424\u043e\u0440\u043c\u0430\u0442 \u0442\u043e\u0447\u0435\u043a: \n 1. (\u043e\u043f\u0446\u0438\u043e\u043d\u0430\u043b\u044c\u043d\u043e) \u0422\u0438\u043f \u0442\u043e\u0447\u043a\u0438 (point|aabb). \u041f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e point. AABB - \u043f\u0430\u0440\u0430\u043b\u043b\u0435\u043b\u0435\u043f\u0438\u043f\u0435\u0434.\n 2. \u041a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u0430 X\n 3. \u041a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u0430 Y\n 4. \u041a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u0430 Z\n 5. \u0415\u0441\u043b\u0438 \u0442\u0438\u043f point - \u0440\u0430\u0434\u0438\u0443\u0441 \u0442\u043e\u0447\u043a\u0438 \u0432 \u0431\u043b\u043e\u043a\u0430\u0445. \u0418\u043d\u0430\u0447\u0435 - \u0440\u0430\u0437\u043c\u0435\u0440 aabb \u043f\u043e \u043e\u0441\u0438 \u0425.\n 6. \u0420\u0430\u0437\u043c\u0435\u0440 aabb \u043f\u043e \u043e\u0441\u0438 Y. \u041d\u0435 \u0442\u0440\u0435\u0431\u0443\u0435\u0442\u0441\u044f \u0434\u043b\u044f \u0442\u0438\u043f\u0430 point.\n 7. \u0420\u0430\u0437\u043c\u0435\u0440 aabb \u043f\u043e \u043e\u0441\u0438 Z. \u041d\u0435 \u0442\u0440\u0435\u0431\u0443\u0435\u0442\u0441\u044f \u0434\u043b\u044f \u0442\u0438\u043f\u0430 point.\n \u0422\u0430\u043a\u0436\u0435 \u0435\u0441\u0442\u044c \u0435\u0449\u0451 \u0434\u0432\u0430 \u043e\u043f\u0446\u0438\u043e\u043d\u0430\u043b\u044c\u043d\u044b\u0445 \u043f\u0430\u0440\u0430\u043c\u0435\u0442\u0440\u0430, \u043a\u043e\u0442\u043e\u0440\u044b\u0435 \u043c\u043e\u0433\u0443\u0442 \u043d\u0430\u0445\u043e\u0434\u0438\u0442\u044c\u0441\u044f \u0432 \u043a\u043e\u043d\u0446\u0435 \u0441\u0442\u0440\u043e\u043a\u0438 \u0432 \u043b\u044e\u0431\u043e\u043c \u043f\u043e\u0440\u044f\u0434\u043a\u0435:\n 1. \u041e\u043f\u0446\u0438\u044f hide - \u0441\u043a\u0440\u044b\u0432\u0430\u0435\u0442 \u043c\u0430\u0440\u043a\u0435\u0440 \u043e\u0442 \u0438\u0433\u0440\u043e\u043a\u0430. \u041e\u0431\u044f\u0437\u0430\u0442\u0435\u043b\u044c\u043d\u043e \u0434\u043b\u044f AABB. \n 2. \u041e\u043f\u0446\u0438\u044f fastfinish - \u043f\u0440\u0438 \u043f\u043e\u0441\u0435\u0449\u0435\u043d\u0438\u0438 \u044d\u0442\u043e\u0439 \u0442\u043e\u0447\u043a\u0438 \u0442\u0435\u043a\u0443\u0449\u0435\u0435 \u0437\u0430\u0434\u0430\u043d\u0438\u0435 \u0441\u0447\u0438\u0442\u0430\u0435\u0442\u0441\u044f \u0437\u0430\u0432\u0435\u0440\u0448\u0435\u043d\u043d\u044b\u043c. \u041f\u043e\u043b\u0435\u0437\u043d\u043e, \u043a\u043e\u0433\u0434\u0430\n \u043d\u0430\u0434\u043e \u043d\u0430\u043f\u0440\u0430\u0432\u0438\u0442\u044c \u0438\u0433\u0440\u043e\u043a\u0430 \u0432 \u043e\u0434\u043d\u0443 \u0438\u0437 \u043d\u0435\u0441\u043a\u043e\u043b\u044c\u043a\u0438\u0445 \u0442\u043e\u0447\u0435\u043a. \u0420\u0430\u0431\u043e\u0442\u0430\u0435\u0442 \u0442\u043e\u043b\u044c\u043a\u043e \u0434\u043b\u044f \u0437\u0430\u0441\u043a\u0440\u0438\u043f\u0442\u043e\u0432\u0430\u043d\u043d\u044b\u0445 \u043d\u0430 \u044d\u0442\u043e \u0441\u0446\u0435\u043d\u0430\u0440\u0438\u0435\u0432.\n \u041a\u0430\u0436\u0434\u044b\u0439 \u043f\u0430\u0440\u0430\u043c\u0435\u0442\u0440 \u043e\u0442\u0434\u0435\u043b\u044f\u0435\u0442\u0441\u044f \u0437\u0430\u043f\u044f\u0442\u043e\u0439.\n \u0417\u042b. \u041d\u0435\u0432\u0438\u0434\u0438\u043c\u044b\u0435 AABB-\u043c\u0430\u0440\u043a\u0435\u0440\u044b \u041d\u0410\u041f\u0420\u0418\u041c\u0415\u0420 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u044e\u0442\u0441\u044f \u0434\u043b\u044f \u0442\u0440\u0438\u0433\u0433\u0435\u0440\u043e\u0432 \u0432 \u0442\u0435\u0445 \u043c\u0435\u0441\u0442\u0430\u0445, \u043a\u0443\u0434\u0430 \u0438\u0433\u0440\u043e\u043a \u0434\u043e\u043b\u0436\u0435\u043d \u0437\u0430\u043f\u043e\u043b\u0437\u0442\u0438, \n \u0442.\u043a. \u043c\u0430\u0440\u043a\u0435\u0440\u044b \u0442\u0438\u043f\u0430 '\u0442\u043e\u0447\u043a\u0430' \u0440\u0435\u0430\u0433\u0438\u0440\u0443\u044e\u0442 \u043d\u0430 \u0438\u0433\u0440\u043e\u043a\u0430, \u0434\u0430\u0436\u0435 \u0435\u0441\u043b\u0438 \u0432\u0438\u0437\u0443\u0430\u043b\u044c\u043d\u043e \u043d\u0438\u0436\u0435.\n\u0421\u043f\u0438\u0441\u043e\u043a \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0445 ID \u0437\u0430\u0434\u0430\u043d\u0438\u0439:";
        for (int i = 0; i < this.__aG.size(); ++i) {
            string = string + "\n" + this.__aG.get(i)._b();
            if (i <= n) continue;
            this.__aB._b(this.__aG.get(i));
        }
        this.__aC.addCustomCategoryComment("controlpoints", string);
        this.__aC.save();
    }

    private void _j() {
        if (kjui._a._b == null) {
            new pidb(false, 0)._a();
        } else {
            kjui._a._b._a = 0;
        }
    }

    private void _a(boolean bl) {
        pidb pidb2 = kjui._a._b;
        if (pidb2 != null) {
            pidb2._a += 8;
            if (pidb2._a > 12000) {
                pidb2._e();
            }
        } else if (bl) {
            this._j();
        }
    }

    private boolean _a(int n) {
        if (this._f == n) {
            this._e = this._f;
            this._f = -1;
            return true;
        }
        return false;
    }

    private boolean _k() {
        return this._g._B == null;
    }

    private void _a(ItemStack itemStack) {
        this._a(itemStack, 4);
    }

    private void _a(ItemStack itemStack, int n) {
        if (!this._b(itemStack._d)) {
            new elyz(itemStack, n).sendToServer();
        }
    }

    private boolean _a(ItemStack[] itemStackArray, int n, int n2, int n3, boolean bl) {
        try {
            for (int i = n2; i < n2 + n3; ++i) {
                if (itemStackArray[i] == null || itemStackArray[i]._a().itemID != n) continue;
                NBTTagCompound nBTTagCompound = itemStackArray[i]._q();
                return !bl || nBTTagCompound != null && nBTTagCompound._o("tutorialonly");
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return false;
        }
        return false;
    }

    private boolean _a(ItemStack[] itemStackArray, int n, int n2, int n3) {
        return this._a(itemStackArray, n, n2, n3, true);
    }

    private boolean _b(int n) {
        return this._a(this._e(), n, 0, 999) || this._a(this._d(), n, 0, 999, true);
    }
}

