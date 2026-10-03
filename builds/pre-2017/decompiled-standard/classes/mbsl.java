/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;

public class mbsl {
    public double _a = 5.0;
    public ozlu _b;
    public EntityPlayerMP _c;
    public xtby _d = xtby._a;
    public boolean _e;
    public int _f;
    public int _g;
    public int _h;
    public int _i;
    public int _j;
    public boolean _k;
    public int _l;
    public int _m;
    public int _n;
    public int _o;
    public int _p = -1;

    public mbsl(ozlu ozlu2) {
        this._b = ozlu2;
    }

    public void _a(xtby xtby2) {
        this._d = xtby2;
        xtby2._a(this._c.field_71075_bZ);
        this._c.func_71016_p();
    }

    public xtby _a() {
        return this._d;
    }

    public boolean _b() {
        return this._d._d();
    }

    public void _b(xtby xtby2) {
        if (this._d == xtby._a) {
            this._d = xtby2;
        }
        this._a(this._d);
    }

    public void _c() {
        ++this._j;
        if (this._k) {
            int n = this._j - this._o;
            int n2 = this._b.func_72798_a(this._l, this._m, this._n);
            if (n2 == 0) {
                this._k = false;
            } else {
                twgu twgu2 = twgu.field_71973_m[n2];
                float f = twgu2.func_71908_a(this._c, this._c.field_70170_p, this._l, this._m, this._n) * (float)(n + 1);
                int n3 = (int)(f * 10.0f);
                if (n3 != this._p) {
                    this._b.func_72888_f(this._c.field_70157_k, this._l, this._m, this._n, n3);
                    this._p = n3;
                }
                if (f >= 1.0f) {
                    this._k = false;
                    this._d(this._l, this._m, this._n);
                }
            }
        } else if (this._e) {
            int n = this._b.func_72798_a(this._g, this._h, this._i);
            twgu twgu3 = twgu.field_71973_m[n];
            if (twgu3 == null) {
                this._b.func_72888_f(this._c.field_70157_k, this._g, this._h, this._i, -1);
                this._p = -1;
                this._e = false;
            } else {
                int n4 = this._j - this._f;
                float f = twgu3.func_71908_a(this._c, this._c.field_70170_p, this._g, this._h, this._i) * (float)(n4 + 1);
                int n5 = (int)(f * 10.0f);
                if (n5 != this._p) {
                    this._b.func_72888_f(this._c.field_70157_k, this._g, this._h, this._i, n5);
                    this._p = n5;
                }
            }
        }
    }

    public void _a(int n, int n2, int n3, int n4) {
        if (!this._d._c() || this._c.func_82246_f(n, n2, n3)) {
            PlayerInteractEvent playerInteractEvent = ForgeEventFactory.onPlayerInteract(this._c, PlayerInteractEvent.Action.LEFT_CLICK_BLOCK, n, n2, n3, n4);
            if (playerInteractEvent.isCanceled()) {
                this._c.field_71135_a.func_72567_b(new cwan(n, n2, n3, this._b));
                return;
            }
            if (this._b()) {
                if (!this._b.func_72886_a(null, n, n2, n3, n4)) {
                    this._d(n, n2, n3);
                }
            } else {
                this._f = this._j;
                float f = 1.0f;
                int n5 = this._b.func_72798_a(n, n2, n3);
                twgu twgu2 = twgu.field_71973_m[n5];
                if (twgu2 != null) {
                    if (playerInteractEvent.useBlock != Event.Result.DENY) {
                        twgu2.func_71921_a(this._b, n, n2, n3, this._c);
                        this._b.func_72886_a(this._c, n, n2, n3, n4);
                    } else {
                        this._c.field_71135_a.func_72567_b(new cwan(n, n2, n3, this._b));
                    }
                    f = twgu2.func_71908_a(this._c, this._c.field_70170_p, n, n2, n3);
                }
                if (playerInteractEvent.useItem == Event.Result.DENY) {
                    if (f >= 1.0f) {
                        this._c.field_71135_a.func_72567_b(new cwan(n, n2, n3, this._b));
                    }
                    return;
                }
                if (n5 > 0 && f >= 1.0f) {
                    this._d(n, n2, n3);
                } else {
                    this._e = true;
                    this._g = n;
                    this._h = n2;
                    this._i = n3;
                    int n6 = (int)(f * 10.0f);
                    this._b.func_72888_f(this._c.field_70157_k, n, n2, n3, n6);
                    this._p = n6;
                }
            }
        }
    }

    public void _a(int n, int n2, int n3) {
        if (n == this._g && n2 == this._h && n3 == this._i) {
            int n4 = this._j - this._f;
            int n5 = this._b.func_72798_a(n, n2, n3);
            if (n5 != 0) {
                twgu twgu2 = twgu.field_71973_m[n5];
                float f = twgu2.func_71908_a(this._c, this._c.field_70170_p, n, n2, n3) * (float)(n4 + 1);
                if (f >= 0.7f) {
                    this._e = false;
                    this._b.func_72888_f(this._c.field_70157_k, n, n2, n3, -1);
                    this._d(n, n2, n3);
                } else if (!this._k) {
                    this._e = false;
                    this._k = true;
                    this._l = n;
                    this._m = n2;
                    this._n = n3;
                    this._o = this._f;
                }
            }
        }
    }

    public void _b(int n, int n2, int n3) {
        this._e = false;
        this._b.func_72888_f(this._c.field_70157_k, this._g, this._h, this._i, -1);
    }

    public boolean _c(int n, int n2, int n3) {
        boolean bl;
        twgu twgu2 = twgu.field_71973_m[this._b.func_72798_a(n, n2, n3)];
        int n4 = this._b.func_72805_g(n, n2, n3);
        if (twgu2 != null) {
            twgu2.func_71846_a(this._b, n, n2, n3, n4, this._c);
        }
        boolean bl2 = bl = twgu2 != null && twgu2.removeBlockByPlayer(this._b, this._c, n, n2, n3);
        if (twgu2 != null && bl) {
            twgu2.func_71898_d(this._b, n, n2, n3, n4);
        }
        return bl;
    }

    public boolean _d(int n, int n2, int n3) {
        BlockEvent.BreakEvent breakEvent = ForgeHooks.onBlockBreakEvent(this._b, this._d, this._c, n, n2, n3);
        if (breakEvent.isCanceled()) {
            return false;
        }
        cvzo cvzo2 = this._c.func_71045_bC();
        if (cvzo2 != null && cvzo2._a().onBlockStartBreak(cvzo2, n, n2, n3, this._c)) {
            return false;
        }
        int n4 = this._b.func_72798_a(n, n2, n3);
        int n5 = this._b.func_72805_g(n, n2, n3);
        this._b.func_72889_a(this._c, 2001, n, n2, n3, n4 + (this._b.func_72805_g(n, n2, n3) << 12));
        boolean bl = false;
        if (this._b()) {
            bl = this._c(n, n2, n3);
            this._c.field_71135_a.func_72567_b(new cwan(n, n2, n3, this._b));
        } else {
            cvzo cvzo3 = this._c.func_71045_bC();
            boolean bl2 = false;
            twgu twgu2 = twgu.field_71973_m[n4];
            if (twgu2 != null) {
                bl2 = twgu2.canHarvestBlock(this._c, n5);
            }
            if (cvzo3 != null) {
                cvzo3._a(this._b, n4, n, n2, n3, this._c);
                if (cvzo3._b == 0) {
                    this._c.func_71028_bD();
                }
            }
            if ((bl = this._c(n, n2, n3)) && bl2) {
                twgu.field_71973_m[n4].func_71893_a(this._b, this._c, n, n2, n3, n5);
            }
        }
        if (!this._b() && bl && breakEvent != null) {
            twgu.field_71973_m[n4].func_71923_g(this._b, n, n2, n3, breakEvent.getExpToDrop());
        }
        return bl;
    }

    public boolean _a(EntityPlayer entityPlayer, ozlu ozlu2, cvzo cvzo2) {
        int n = cvzo2._b;
        int n2 = cvzo2._j();
        cvzo cvzo3 = cvzo2._a(ozlu2, entityPlayer);
        if (cvzo3 == cvzo2 && (cvzo3 == null || cvzo3._b == n && cvzo3._n() <= 0 && cvzo3._j() == n2)) {
            return false;
        }
        entityPlayer.field_71071_by._a[entityPlayer.field_71071_by._c] = cvzo3;
        if (this._b()) {
            cvzo3._b = n;
            if (cvzo3._f()) {
                cvzo3._b(n2);
            }
        }
        if (cvzo3._b == 0) {
            entityPlayer.field_71071_by._a[entityPlayer.field_71071_by._c] = null;
            MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(this._c, cvzo3));
        }
        if (!entityPlayer.func_71039_bw()) {
            ((EntityPlayerMP)entityPlayer).func_71120_a(entityPlayer.field_71069_bz);
        }
        return true;
    }

    public boolean _a(EntityPlayer entityPlayer, ozlu ozlu2, cvzo cvzo2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        tgdv tgdv2;
        PlayerInteractEvent playerInteractEvent = ForgeEventFactory.onPlayerInteract(entityPlayer, PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK, n, n2, n3, n4);
        if (playerInteractEvent.isCanceled()) {
            this._c.field_71135_a.func_72567_b(new cwan(n, n2, n3, this._b));
            return false;
        }
        tgdv tgdv3 = tgdv2 = cvzo2 != null ? cvzo2._a() : null;
        if (tgdv2 != null && tgdv2.onItemUseFirst(cvzo2, entityPlayer, ozlu2, n, n2, n3, n4, f, f2, f3)) {
            if (cvzo2._b <= 0) {
                ForgeEventFactory.onPlayerDestroyItem(this._c, cvzo2);
            }
            return true;
        }
        int n5 = ozlu2.func_72798_a(n, n2, n3);
        twgu twgu2 = twgu.field_71973_m[n5];
        boolean bl = false;
        if (twgu2 != null && (!entityPlayer.func_70093_af() || entityPlayer.func_70694_bm() == null || entityPlayer.func_70694_bm()._a().shouldPassSneakingClickToBlock(ozlu2, n, n2, n3))) {
            if (playerInteractEvent.useBlock != Event.Result.DENY) {
                bl = twgu2.func_71903_a(ozlu2, n, n2, n3, entityPlayer, n4, f, f2, f3);
            } else {
                this._c.field_71135_a.func_72567_b(new cwan(n, n2, n3, this._b));
                boolean bl2 = bl = playerInteractEvent.useItem != Event.Result.ALLOW;
            }
        }
        if (cvzo2 != null && !bl && playerInteractEvent.useItem != Event.Result.DENY) {
            int n6 = cvzo2._j();
            int n7 = cvzo2._b;
            bl = cvzo2._a(entityPlayer, ozlu2, n, n2, n3, n4, f, f2, f3);
            if (this._b()) {
                cvzo2._b(n6);
                cvzo2._b = n7;
            }
            if (cvzo2._b <= 0) {
                ForgeEventFactory.onPlayerDestroyItem(this._c, cvzo2);
            }
        }
        return bl;
    }

    public void _a(yfgy yfgy2) {
        this._b = yfgy2;
    }

    public double _d() {
        return this._a;
    }

    public void _a(double d) {
        this._a = d;
    }
}

