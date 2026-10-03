/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  atc
 *  bdd
 *  bdi
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  dt
 *  du
 *  eh
 *  fb
 *  fk
 *  fl
 *  gk
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  net.minecraftforge.event.entity.player.PlayerDestroyItemEvent
 *  zl
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

@SideOnly(value=Side.CLIENT)
public class bdc {
    private final atv a;
    private final bcw b;
    private int c = -1;
    private int d = -1;
    private int e = -1;
    private ye f;
    private float g;
    private float h;
    private int i;
    private boolean j;
    private ace k = ace.b;
    private int l;

    public bdc(atv par1Minecraft, bcw par2NetClientHandler) {
        this.a = par1Minecraft;
        this.b = par2NetClientHandler;
    }

    public static void a(atv par0Minecraft, bdc par1PlayerControllerMP, int par2, int par3, int par4, int par5) {
        if (!par0Minecraft.f.a((uf)par0Minecraft.h, par2, par3, par4, par5)) {
            par1PlayerControllerMP.a(par2, par3, par4, par5);
        }
    }

    public void a(uf par1EntityPlayer) {
        this.k.a(par1EntityPlayer.bG);
    }

    public boolean a() {
        return false;
    }

    public void a(ace par1EnumGameType) {
        this.k = par1EnumGameType;
        this.k.a(this.a.h.bG);
    }

    public void b(uf par1EntityPlayer) {
        par1EntityPlayer.A = -180.0f;
    }

    public boolean b() {
        return this.k.e();
    }

    public boolean a(int par1, int par2, int par3, int par4) {
        ye itemstack;
        ye stack = this.a.h.by();
        if (stack != null && stack.b() != null && stack.b().onBlockStartBreak(stack, par1, par2, par3, (uf)this.a.h)) {
            return false;
        }
        if (this.k.c() && !this.a.h.d(par1, par2, par3)) {
            return false;
        }
        if (this.k.d() && this.a.h.aZ() != null && this.a.h.aZ().b() instanceof zl) {
            return false;
        }
        bdd worldclient = this.a.f;
        aqz block = aqz.s[worldclient.a(par1, par2, par3)];
        if (block == null) {
            return false;
        }
        worldclient.e(2001, par1, par2, par3, block.cF + (worldclient.h(par1, par2, par3) << 12));
        int i1 = worldclient.h(par1, par2, par3);
        boolean flag = block.removeBlockByPlayer((abw)worldclient, (uf)this.a.h, par1, par2, par3);
        if (flag) {
            block.g((abw)worldclient, par1, par2, par3, i1);
        }
        this.d = -1;
        if (!this.k.d() && (itemstack = this.a.h.by()) != null) {
            itemstack.a((abw)worldclient, block.cF, par1, par2, par3, (uf)this.a.h);
            if (itemstack.b == 0) {
                this.a.h.bz();
            }
        }
        return flag;
    }

    public void b(int par1, int par2, int par3, int par4) {
        if (!this.k.c() || this.a.h.d(par1, par2, par3)) {
            if (this.k.d()) {
                this.b.c((ey)new fb(0, par1, par2, par3, par4));
                bdc.a(this.a, this, par1, par2, par3, par4);
                this.i = 5;
            } else if (!this.j || !this.a(par1, par2, par3)) {
                if (this.j) {
                    this.b.c((ey)new fb(1, this.c, this.d, this.e, par4));
                }
                this.b.c((ey)new fb(0, par1, par2, par3, par4));
                int i1 = this.a.f.a(par1, par2, par3);
                if (i1 > 0 && this.g == 0.0f) {
                    aqz.s[i1].a((abw)this.a.f, par1, par2, par3, (uf)this.a.h);
                }
                if (i1 > 0 && aqz.s[i1].a((uf)this.a.h, this.a.h.q, par1, par2, par3) >= 1.0f) {
                    this.a(par1, par2, par3, par4);
                } else {
                    this.j = true;
                    this.c = par1;
                    this.d = par2;
                    this.e = par3;
                    this.f = this.a.h.aZ();
                    this.g = 0.0f;
                    this.h = 0.0f;
                    this.a.f.f(this.a.h.k, this.c, this.d, this.e, (int)(this.g * 10.0f) - 1);
                }
            }
        }
    }

    public void c() {
        if (this.j) {
            this.b.c((ey)new fb(1, this.c, this.d, this.e, -1));
        }
        this.j = false;
        this.g = 0.0f;
        this.a.f.f(this.a.h.k, this.c, this.d, this.e, -1);
    }

    public void c(int par1, int par2, int par3, int par4) {
        this.k();
        if (this.i > 0) {
            --this.i;
        } else if (this.k.d()) {
            this.i = 5;
            this.b.c((ey)new fb(0, par1, par2, par3, par4));
            bdc.a(this.a, this, par1, par2, par3, par4);
        } else if (this.a(par1, par2, par3)) {
            int i1 = this.a.f.a(par1, par2, par3);
            if (i1 == 0) {
                this.j = false;
                return;
            }
            aqz block = aqz.s[i1];
            this.g += block.a((uf)this.a.h, this.a.h.q, par1, par2, par3);
            if (this.h % 4.0f == 0.0f && block != null) {
                this.a.v.a(block.cS.e(), (float)par1 + 0.5f, (float)par2 + 0.5f, (float)par3 + 0.5f, (block.cS.c() + 1.0f) / 8.0f, block.cS.d() * 0.5f);
            }
            this.h += 1.0f;
            if (this.g >= 1.0f) {
                this.j = false;
                this.b.c((ey)new fb(2, par1, par2, par3, par4));
                this.a(par1, par2, par3, par4);
                this.g = 0.0f;
                this.h = 0.0f;
                this.i = 5;
            }
            this.a.f.f(this.a.h.k, this.c, this.d, this.e, (int)(this.g * 10.0f) - 1);
        } else {
            this.b(par1, par2, par3, par4);
        }
    }

    public float d() {
        return this.k.d() ? 5.0f : 4.5f;
    }

    public void e() {
        this.k();
        this.a.v.c();
    }

    private boolean a(int par1, int par2, int par3) {
        boolean flag;
        ye itemstack = this.a.h.aZ();
        boolean bl2 = flag = this.f == null && itemstack == null;
        if (this.f != null && itemstack != null) {
            flag = itemstack.d == this.f.d && ye.a(itemstack, this.f) && (itemstack.g() || itemstack.k() == this.f.k());
        }
        return par1 == this.c && par2 == this.d && par3 == this.e && flag;
    }

    private void k() {
        int i2 = this.a.h.bn.c;
        if (i2 != this.l) {
            this.l = i2;
            this.b.c((ey)new fk(this.l));
        }
    }

    public boolean a(uf par1EntityPlayer, abw par2World, ye par3ItemStack, int par4, int par5, int par6, int par7, atc par8Vec3) {
        zh itemblock;
        int i1;
        this.k();
        float f2 = (float)par8Vec3.c - (float)par4;
        float f1 = (float)par8Vec3.d - (float)par5;
        float f22 = (float)par8Vec3.e - (float)par6;
        boolean flag = false;
        if (par3ItemStack != null && par3ItemStack.b() != null && par3ItemStack.b().onItemUseFirst(par3ItemStack, par1EntityPlayer, par2World, par4, par5, par6, par7, f2, f1, f22)) {
            return true;
        }
        if ((!par1EntityPlayer.ah() || par1EntityPlayer.aZ() == null || par1EntityPlayer.aZ().b().shouldPassSneakingClickToBlock(par2World, par4, par5, par6)) && (i1 = par2World.a(par4, par5, par6)) > 0 && aqz.s[i1].a(par2World, par4, par5, par6, par1EntityPlayer, par7, f2, f1, f22)) {
            flag = true;
        }
        if (!flag && par3ItemStack != null && par3ItemStack.b() instanceof zh && !(itemblock = (zh)par3ItemStack.b()).a(par2World, par4, par5, par6, par7, par1EntityPlayer, par3ItemStack)) {
            return false;
        }
        this.b.c((ey)new gk(par4, par5, par6, par7, par1EntityPlayer.bn.h(), f2, f1, f22));
        if (flag) {
            return true;
        }
        if (par3ItemStack == null) {
            return false;
        }
        if (this.k.d()) {
            i1 = par3ItemStack.k();
            int j1 = par3ItemStack.b;
            boolean flag1 = par3ItemStack.a(par1EntityPlayer, par2World, par4, par5, par6, par7, f2, f1, f22);
            par3ItemStack.b(i1);
            par3ItemStack.b = j1;
            return flag1;
        }
        if (!par3ItemStack.a(par1EntityPlayer, par2World, par4, par5, par6, par7, f2, f1, f22)) {
            return false;
        }
        if (par3ItemStack.b <= 0) {
            MinecraftForge.EVENT_BUS.post((Event)new PlayerDestroyItemEvent(par1EntityPlayer, par3ItemStack));
        }
        return true;
    }

    public boolean a(uf par1EntityPlayer, abw par2World, ye par3ItemStack) {
        this.k();
        this.b.c((ey)new gk(-1, -1, -1, 255, par1EntityPlayer.bn.h(), 0.0f, 0.0f, 0.0f));
        int i2 = par3ItemStack.b;
        ye itemstack1 = par3ItemStack.a(par2World, par1EntityPlayer);
        if (itemstack1 == par3ItemStack && (itemstack1 == null || itemstack1.b == i2)) {
            return false;
        }
        par1EntityPlayer.bn.a[par1EntityPlayer.bn.c] = itemstack1;
        if (itemstack1.b <= 0) {
            par1EntityPlayer.bn.a[par1EntityPlayer.bn.c] = null;
            MinecraftForge.EVENT_BUS.post((Event)new PlayerDestroyItemEvent(par1EntityPlayer, itemstack1));
        }
        return true;
    }

    public bdi a(abw par1World) {
        return new bdi(this.a, par1World, this.a.H(), this.b);
    }

    public void a(uf par1EntityPlayer, nn par2Entity) {
        this.k();
        this.b.c((ey)new eh(par1EntityPlayer.k, par2Entity.k, 1));
        par1EntityPlayer.q(par2Entity);
    }

    public boolean b(uf par1EntityPlayer, nn par2Entity) {
        this.k();
        this.b.c((ey)new eh(par1EntityPlayer.k, par2Entity.k, 0));
        return par1EntityPlayer.p(par2Entity);
    }

    public ye a(int par1, int par2, int par3, int par4, uf par5EntityPlayer) {
        short short1 = par5EntityPlayer.bp.a(par5EntityPlayer.bn);
        ye itemstack = par5EntityPlayer.bp.a(par2, par3, par4, par5EntityPlayer);
        this.b.c((ey)new du(par1, par2, par3, par4, itemstack, short1));
        return itemstack;
    }

    public void a(int par1, int par2) {
        this.b.c((ey)new dt(par1, par2));
    }

    public void a(ye par1ItemStack, int par2) {
        if (this.k.d()) {
            this.b.c((ey)new fl(par2, par1ItemStack));
        }
    }

    public void a(ye par1ItemStack) {
        if (this.k.d() && par1ItemStack != null) {
            this.b.c((ey)new fl(-1, par1ItemStack));
        }
    }

    public void c(uf par1EntityPlayer) {
        this.k();
        this.b.c((ey)new fb(5, 0, 0, 0, 255));
        par1EntityPlayer.bt();
    }

    public boolean f() {
        return this.k.e();
    }

    public boolean g() {
        return !this.k.d();
    }

    public boolean h() {
        return this.k.d();
    }

    public boolean i() {
        return this.k.d();
    }

    public boolean j() {
        return this.a.h.ag() && this.a.h.o instanceof rs;
    }
}

