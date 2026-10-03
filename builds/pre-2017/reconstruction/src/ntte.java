/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import gloomyfolken.mods.core.client.gui.screens.GuiItemRenderDev;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.weapon.trace.EntityTracer;
import java.util.EnumSet;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class ntte
implements ITickHandler {
    public int _a = 0;
    public static long _b = 1L;
    private boolean _d;
    private boolean _e;
    private boolean _f;
    private boolean _g = false;
    private boolean _h = true;
    private boolean _i = false;
    private Minecraft _j = Minecraft._E();
    public Entity _c;
    private EnumSet<TickType> _k = EnumSet.of(TickType.CLIENT);

    @Override
    public void tickStart(EnumSet<TickType> enumSet, Object ... objectArray) {
        this._d();
        this._e();
        this._c();
        this._b();
        dwwh._a._a();
        ++_b;
    }

    private void _b() {
        if (_b % 3600L == 0L && ClientProxy.notificationsChanged) {
            ClientProxy.saveNotifications();
            ClientProxy.notificationsChanged = false;
        }
    }

    private void _c() {
        MovingObjectPosition movingObjectPosition = this._a(this._j._p._f);
        this._c = movingObjectPosition != null ? movingObjectPosition._i : null;
    }

    public void _a() {
        boolean bl = Mouse.isButtonDown(0);
        boolean bl2 = Mouse.isButtonDown(2);
        boolean bl3 = Mouse.isButtonDown(1);
        if (this._d && bl && this._j.__ab) {
            MinecraftForge.EVENT_BUS.post(new anrz(anrz.kjui._a, anrz.pidb._b));
        }
        if (this._e && bl2 && this._j.__ab) {
            MinecraftForge.EVENT_BUS.post(new anrz(anrz.kjui._b, anrz.pidb._b));
        }
        if (this._f && bl3 && this._j.__ab) {
            MinecraftForge.EVENT_BUS.post(new anrz(anrz.kjui._c, anrz.pidb._b));
        }
        this._d = this._j.__ab && bl;
        this._e = this._j.__ab && bl2;
        this._f = this._j.__ab && bl3;
    }

    private void _d() {
        if (!this._i && Keyboard.isKeyDown(207)) {
            boolean bl = this._h = !this._h;
        }
        if (this._j._t != null) {
            boolean bl = this._j._t.capabilities._d && this._h;
            int n = GloomyCore.transparentsRenderType = bl ? 0 : -1;
            if (bl != this._g) {
                this._j._s._b();
            }
            this._g = bl;
        }
        this._i = Keyboard.isKeyDown(207);
        if (this._j.__ab && Keyboard.isKeyDown(64) && this._j._t != null && this._j._t.getCurrentEquippedItem() != null && this._j._t.capabilities._d && anoq._a(this._j._t.getCurrentEquippedItem()._a()) != null) {
            anoq anoq2 = anoq._a(this._j._t.getCurrentEquippedItem()._a());
            this._j._a(new GuiItemRenderDev(anoq2._j));
        }
    }

    private void _e() {
        if (!this._j._y && this._j._r != null) {
            for (EntityPlayer entityPlayer : this._j._r.playerEntities) {
                ncwh._a(entityPlayer)._d();
            }
            ((ClientProxy)GloomyCore.proxy).tickInGame();
        }
    }

    @Override
    public void tickEnd(EnumSet<TickType> enumSet, Object ... objectArray) {
        ((ClientProxy)GloomyCore.proxy).controller._a = Minecraft._E()._B != null;
        this._f();
        dwwh._a._b();
    }

    private void _f() {
        if ((this._j._B == null || this._j._B.allowUserInput) && this._j._t != null && this._j._t.isUsingItem() && !ClientProxy.useBinding._e) {
            this._j._j._f();
            this._j._j._b._b(new Packet14BlockDig(5, 0, 0, 0, 255));
            this._j._t.stopUsingItem();
        }
    }

    @Override
    public EnumSet<TickType> ticks() {
        return this._k;
    }

    @Override
    public String getLabel() {
        return "StalkerClientTicker";
    }

    private MovingObjectPosition _a(float f) {
        MovingObjectPosition movingObjectPosition;
        if (this._j._u == null || this._j._r == null) {
            return null;
        }
        float f2 = 100.0f;
        EntityLivingBase entityLivingBase = this._j._u;
        Vec3 vec3 = entityLivingBase.getPosition(f);
        Vec3 vec32 = entityLivingBase.getLook(f);
        Vec3 vec33 = vec3._c(vec32._c * (double)f2, vec32._d * (double)f2, vec32._e * (double)f2);
        MovingObjectPosition movingObjectPosition2 = EntityTracer._a((World)this._j._r, vec3, vec33, (Entity)entityLivingBase, movingObjectPosition = entityLivingBase.worldObj.func_72831_a(entityLivingBase.getPosition(f), vec33, false, true), false);
        if (movingObjectPosition2 != null && movingObjectPosition2._c == EnumMovingObjectType._b) {
            return movingObjectPosition2;
        }
        return null;
    }

    private MovingObjectPosition _a(EntityLivingBase entityLivingBase, double d, float f) {
        Vec3 vec3 = entityLivingBase.getPosition(f);
        Vec3 vec32 = entityLivingBase.getLook(f);
        Vec3 vec33 = vec3._c(vec32._c * d, vec32._d * d, vec32._e * d);
        return entityLivingBase.worldObj.func_72831_a(vec3, vec33, false, true);
    }
}

