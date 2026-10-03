/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.stalker.misc.zwaw;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import mods.sound.SoundMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import noppes.npcs.EntityNPCInterface;
import org.lwjgl.opengl.GL11;

public class yuet
implements nttf,
ofux {
    public static final long _a = TimeUnit.SECONDS.toMillis(3L) + 500L;
    public static final double _b = 90.0;
    public static final long _c = 500L;
    public Map<Integer, zwaw> _d = new HashMap<Integer, zwaw>();
    public Set<Entity> _e = Collections.newSetFromMap(new ConcurrentHashMap());
    private long _f = -1L;
    private boolean _g = false;
    private long _h = -1L;
    private long _i = 0L;

    @Override
    public void onGameJoined() {
        this._d.clear();
    }

    @Override
    public void onTickInGame() {
        this._a();
        if (ntte._b % 10L != 0L) {
            return;
        }
        Iterator<Entity> iterator2 = this._e.iterator();
        while (iterator2.hasNext()) {
            Entity entity = iterator2.next();
            if (!entity.isEntityAlive()) {
                iterator2.remove();
                continue;
            }
            this._a(entity);
        }
    }

    @ForgeSubscribe
    public void _a(wnts wnts2) {
        if (!this._d.containsKey(wnts2._a.entityId)) {
            return;
        }
        EntityLivingBase entityLivingBase = wnts2._a;
        float f = 0.016666668f;
        RenderManager renderManager = RenderManager._b;
        double d = entityLivingBase.getDistanceToEntity(renderManager._j);
        double d2 = 100.0;
        Minecraft minecraft = Minecraft._E();
        if (d > d2) {
            return;
        }
        f = (float)((double)f * (d * (double)0.1f));
        zwaw zwaw2 = this._d.get(wnts2._a.entityId);
        GL11.glPushMatrix();
        float f2 = jywc._a((float)entityLivingBase.prevPosX, (float)entityLivingBase.posX, wnts2._b) - (float)renderManager._o;
        float f3 = jywc._a((float)entityLivingBase.prevPosY, (float)entityLivingBase.posY, wnts2._b) - (float)renderManager._p;
        float f4 = jywc._a((float)entityLivingBase.prevPosZ, (float)entityLivingBase.posZ, wnts2._b) - (float)renderManager._q;
        GL11.glTranslatef(f2, f3 + entityLivingBase.height + 0.65f + (float)(d / d2), f4);
        GL11.glNormal3f(0.0f, 1.0f, 0.0f);
        GL11.glScalef(-f, -f, f);
        GL11.glRotatef(renderManager._l, 0.0f, 1.0f, 0.0f);
        boolean bl = minecraft._M.thirdPersonView == 2;
        GL11.glRotatef(bl ? renderManager._m : -renderManager._m, 1.0f, 0.0f, 0.0f);
        GL11.glDisable(2896);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3553);
        GL11.glDisable(2929);
        this._a(d, zwaw2);
        GL11.glEnable(2929);
        GL11.glEnable(2896);
        GL11.glDisable(3042);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPopMatrix();
    }

    private void _a(double d, zwaw zwaw2) {
        Minecraft minecraft = Minecraft._E();
        long l = System.currentTimeMillis();
        long l2 = l - zwaw2._h();
        GL11.glColor4f(1.0f, 0.2f, 0.2f, Math.min(1.0f, (3000.0f - (float)(l - zwaw2._g())) / 200.0f));
        minecraft._R()._a(oxmc._a);
        float f = iwya._d;
        float f2 = iwya._e;
        float f3 = (float)l2 / 1000.0f;
        float f4 = 0.3f;
        float f5 = (float)(Math.pow(2.0, -10.0f * f3) * Math.sin((double)(f3 - f4 / 4.0f) * (Math.PI * 2) / (double)f4) + 1.0);
        float f6 = f5 * (eidj._a._z / 90.0f) * 0.5f;
        GL11.glScaled(f6, f6, f6);
        iwya._a(iwya._b, 240.0f, 0.0f);
        if (zwaw2._i()) {
            qozx._a(-7.0, -13.0, 14.0, 26.0, 448.0, 140.0, 462.0, 166.0, 512.0, 512.0);
        } else {
            qozx._a(-7.0, -6.0, 14.0, 12.0, 480.0, 154.0, 494.0, 166.0, 512.0, 512.0);
        }
        iwya._d = f;
        iwya._e = f2;
    }

    private void _a() {
        long l = System.currentTimeMillis();
        Iterator<zwaw> iterator2 = this._d.values().iterator();
        while (iterator2.hasNext()) {
            zwaw zwaw2 = iterator2.next();
            if (l - zwaw2._g() > _a) {
                iterator2.remove();
                continue;
            }
            zwaw2._a(zwaw2._c());
            zwaw2._b(zwaw2._d());
        }
    }

    private void _a(Entity entity) {
        SoundMod.starterThread.addTask(() -> {
            jzqf jzqf2 = Minecraft._E()._N;
            String string = "command_" + entity.entityId;
            if (jzqf2._c.playing(string)) {
                jzqf2._c.setPosition(string, (float)entity.posX, (float)entity.posY, (float)entity.posZ);
                jzqf2._c.setVelocity(string, (float)entity.motionX, (float)entity.motionY, (float)entity.motionZ);
            } else {
                this._e.remove(entity);
            }
        });
    }

    @ForgeSubscribe(priority=EventPriority.HIGHEST)
    public void _a(MouseEvent mouseEvent) {
        if (Minecraft._E()._B != null) {
            return;
        }
        if (!this._g && this._f > 0L && System.currentTimeMillis() - this._f > 100L) {
            this._i += (long)(mouseEvent.dx * mouseEvent.dx + mouseEvent.dy * mouseEvent.dy);
            if (this._i >= 16L) {
                Minecraft._E()._a(new oxmc());
                this._g = true;
                this._i = 0L;
            }
        }
    }

    public void _a(String string) {
        if (string.equals("spot")) {
            this._a(Minecraft._E()._t);
        } else {
            new cunq(string).sendToServer();
        }
    }

    public void _a(EntityPlayer entityPlayer) {
        long l = System.currentTimeMillis();
        if (l < this._h) {
            return;
        }
        this._h = l + 500L;
        List list2 = entityPlayer.worldObj.getLoadedEntityList();
        ArrayList<Entity> arrayList = new ArrayList<Entity>();
        for (Entity entity2 : list2) {
            if (!this._a(entityPlayer, entity2)) continue;
            double d = this._b(entityPlayer, entity2);
            double d2 = entityPlayer.getDistanceToEntity(entity2);
            double d3 = 1.0 - 0.12 * (1.0 / Math.max(1.0, d2));
            if (!(Math.abs(d) > d3)) continue;
            arrayList.add(entity2);
        }
        List list3 = arrayList.stream().sorted(Comparator.comparing(entityPlayer::getDistanceSqToEntity)).map(entity -> entity.entityId).collect(Collectors.toList());
        if (!list3.isEmpty()) {
            new uiag(list3).sendToServer();
        } else {
            this._a(false);
        }
    }

    public void _a(boolean bl) {
        if (!bl) {
            Minecraft._E()._N._a("stalker:missed_spot", 0.7f, 1.0f);
        }
    }

    private boolean _a(EntityPlayer entityPlayer, Entity entity) {
        boolean bl = entity instanceof EntityPlayer || entity instanceof EntityNPCInterface || entity instanceof EntityMutant;
        return bl && entityPlayer != entity && entity.isEntityAlive() && entityPlayer.getDistanceSqToEntity(entity) < 8100.0;
    }

    private double _b(EntityPlayer entityPlayer, Entity entity) {
        Vec3 vec3 = entityPlayer.getLookVec();
        Vec3 vec32 = entityPlayer.worldObj.getWorldVec3Pool()._a(entity.posX - entityPlayer.posX, entity.posY + (double)entity.getEyeHeight() / 2.0 - (entityPlayer.posY + (double)entityPlayer.getEyeHeight()), entity.posZ - entityPlayer.posZ);
        return vec3._b(vec32) / (vec3._b() * vec32._b());
    }

    @Override
    public void onKeyDown() {
        this._f = System.currentTimeMillis();
        this._g = false;
    }

    @Override
    public void onKeyDownRepeat() {
        Minecraft minecraft = Minecraft._E();
        if (minecraft._B != null) {
            return;
        }
        if (!this._g && System.currentTimeMillis() - this._f > 500L) {
            minecraft._a(new oxmc());
            this._g = true;
        }
    }

    @Override
    public void onKeyUp() {
        if (System.currentTimeMillis() - this._f < 500L) {
            this._a("spot");
        }
        if (Minecraft._E()._B instanceof oxmc) {
            Minecraft._E()._a((GuiScreen)null);
        }
        this._g = false;
        this._f = -1L;
    }

    @Override
    public boolean processOnGui() {
        return true;
    }
}

