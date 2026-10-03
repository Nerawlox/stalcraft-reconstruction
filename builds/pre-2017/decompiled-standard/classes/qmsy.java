/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McGuiEntity;
import gloomyfolken.mods.core.client.gui.engine.component.McGuiPlayer;
import gloomyfolken.mods.effects.client.main.jxtc;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.respawn.RespawnMod;
import mods.pda.client.minimap.MapCanvas;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.jgro;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezfc;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.util.vector.Vector2f;

public class qmsy
extends jzaw<klfx> {
    public static final ResourceLocation _k = new ResourceLocation("stalker", "textures/gui/death_bg.png");
    public static final ResourceLocation _l = new ResourceLocation("stalker", "textures/gui/death_elements.png");

    @Override
    protected void _a() {
        if (this._i) {
            this._g.canvas().setZoom(((klfx)this._h)._i.length == 0 ? 0.5f : 1.0f);
            this._b();
            if (((klfx)this._h)._f instanceof oxoq) {
                this._a((oxoq)((klfx)this._h)._f);
            }
        }
    }

    private void _b() {
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        oxot oxot2 = ((klfx)this._h)._e;
        String string = "\u0412\u044b \u0431\u044b\u043b\u0438 \u0443\u0431\u0438\u0442\u044b:";
        GuiHelper.addLabel((IAdvancedGui)this, string, point.add(-this.renderer.getStringWidth(string) / 2 - 30, -240), -1);
        if (oxot2 instanceof oxoq) {
            this._b((oxoq)oxot2);
        } else if (oxot2 instanceof zgmg) {
            EntityMutant entityMutant = ((zgmg)oxot2)._c();
            if (entityMutant != null) {
                entityMutant.setScale(1.0f);
                this._a(entityMutant);
            }
        } else if (oxot2 instanceof uzai) {
            uzai uzai2 = (uzai)oxot2;
            EntityLivingBase entityLivingBase = (EntityLivingBase)jgro._a(uzai2._c, (ozlu)xpzm._E()._r);
            this._a(entityLivingBase);
        }
    }

    private void _b(oxoq oxoq2) {
        Object object;
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        int n = -218;
        String string = oxoq2._c();
        if (string != null && !string.isEmpty()) {
            string = "<" + string + ">";
            object = point.add(-this.renderer.getStringWidth(string) / 2 - 30, n);
            GuiHelper.addLabel((IAdvancedGui)this, (Object)((Object)ezfc._o) + string, (Point)object, -1);
            n += 20;
        } else {
            n += 10;
        }
        object = oxoq2._d();
        Point point2 = point.add(-this.renderer.getStringWidth((String)object) / 2 - 30, n);
        GuiHelper.addLabel((IAdvancedGui)this, (Object)((Object)ezfc._o) + (String)object, point2, -1);
        this._a(oxoq2._e(), point.add(-106, -110), 2.0f, true);
        this._a(oxoq2._f(), point.add(-24, -110), 2.0f, true);
        this._a(oxoq2._g(), point.add(-67, -31), 2.0f, true);
        McGuiPlayer mcGuiPlayer = new McGuiPlayer(this, point.add(-230, -170), new Dimension(100, 200), 55.0f);
        this.addElement(mcGuiPlayer);
        mcGuiPlayer.setRotation(330.0f);
        mcGuiPlayer.setPreviewItem(38, oxoq2._f());
    }

    private void _a(EntityLivingBase entityLivingBase) {
        if (entityLivingBase == null) {
            return;
        }
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        String string = entityLivingBase.func_70023_ak();
        GuiHelper.addLabel((IAdvancedGui)this, (Object)((Object)ezfc._o) + string, point.add(-this.renderer.getStringWidth(string) / 2 - 30, -215), -1);
        float f = 1.8f / entityLivingBase.field_70131_O;
        Point point2 = point.add(-125, -147);
        McGuiEntity<EntityLivingBase> mcGuiEntity = new McGuiEntity<EntityLivingBase>(this, point2, new Dimension(200, 250), entityLivingBase, (float)(40.0 * Math.sqrt(f)));
        mcGuiEntity.setDisableDelayedRendering(entityLivingBase instanceof EntityMutant);
        this.addElement(mcGuiEntity);
        mcGuiEntity.setRotation(330.0f);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        this.renderer.bindTexture(_l);
        if (((klfx)this._h)._e != null) {
            this.renderer.drawTexturedModalRect(this.screenWidth / 2 - 125, this.screenHeight / 2 - 167, 1, 85, 192, 44);
            int n3 = (int)(128.0f * ((klfx)this._h)._e._a());
            this.renderer.drawTexturedModalRect(this.screenWidth / 2 - 71, this.screenHeight / 2 - 153, 0, 0, n3, 18);
        }
    }

    @Override
    public void drawMapObjects(MapCanvas mapCanvas, float f) {
        GL11.glEnable(3042);
        if (((klfx)this._h)._i.length > 0) {
            for (int n : ((klfx)this._h)._i) {
                this._a(100.0, 0.39269908169872414, n);
            }
        } else {
            GL11.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
            Vector2f vector2f = mapCanvas.worldCoordsToScreen(new Vector2f((float)((klfx)this._h)._g, (float)((klfx)this._h)._h));
            this._a(vector2f.x, vector2f.y, 0.0f, 0.0f);
        }
        super.drawMapObjects(mapCanvas, f);
    }

    private void _a(double d, double d2, int n) {
        double d3 = -d2 * (double)n;
        double d4 = -d2 * (double)(n + 1);
        GL11.glDisable(3553);
        GL11.glColor4f(1.0f, 0.0f, 0.0f, 0.5f);
        GL11.glBegin(4);
        GL11.glVertex2d(0.0, 0.0);
        GL11.glVertex2d(Math.cos(d3) * d, Math.sin(d3) * d);
        GL11.glVertex2d(Math.cos(d4) * d, Math.sin(d4) * d);
        GL11.glEnd();
        GL11.glEnable(3553);
    }

    private void _a(float f, float f2, float f3, float f4) {
        Point point = this._g.getLocation();
        Dimension dimension = this._g.getSize();
        float f5 = point.x + dimension.width / 2;
        float f6 = point.y + dimension.height / 2;
        GL11.glDisable(3553);
        float f7 = this.field_73882_e._n;
        float f8 = this.field_73882_e._o;
        jxtc jxtc2 = RespawnMod.instance._g;
        jxtc2._e();
        jxtc2._a("thickness", 0.003f);
        jxtc2._a("line", (f5 + f * 2.0f) / f7, (f8 - (f6 + f2 * 2.0f)) / f8, (f5 + f3 * 2.0f) / f7, (f8 - (f6 + f4 * 2.0f)) / f8);
        jxtc2._a("resolution", f7, f8);
        jxtc2._a("time", (float)(System.currentTimeMillis() % 1000000L) * 0.002f);
        this._g.canvas().renderer.drawRect(-dimension.width / 2, -dimension.height / 2, dimension.width, dimension.height, -65536);
        GL20.glUseProgram(0);
        GL11.glEnable(3553);
    }
}

