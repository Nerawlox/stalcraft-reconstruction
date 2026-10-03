/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.screens.GuiScreenRadial;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

public class xadg
extends GuiScreenRadial {
    private cvzo[] _a;
    private GuiRenderer.RenderItemHD _b;

    public xadg(EntityPlayer entityPlayer) {
        super(StalkerMiscMod.instance.__aw._d, 4);
        this._b = this.renderer.createItemRender(4.0f);
        int n = GloomyCore.instance.containerFactory._b();
        this._a = new cvzo[n];
        System.arraycopy(entityPlayer.field_71071_by._a, 0, this._a, 0, n);
    }

    @Override
    protected String getSelectedTitle(int n) {
        cvzo cvzo2 = this._a[n];
        return cvzo2 != null ? cvzo2._s() : "";
    }

    @Override
    protected void drawIcon(int n, int n2, int n3) {
        cvzo cvzo2 = this._a[n];
        if (cvzo2 != null) {
            GL11.glEnable(3042);
            this._b.renderStack(cvzo2, n2 - 32, n3 - 32);
            GL11.glDisable(2896);
        }
    }

    @Override
    protected void runAction(int n) {
        int n2 = this.field_73882_e._t.field_71071_by._c;
        int n3 = n;
        if (!MinecraftForge.EVENT_BUS.post(new anrg(n2, n3, false))) {
            this.field_73882_e._t.field_71071_by._c = n3;
        }
    }
}

