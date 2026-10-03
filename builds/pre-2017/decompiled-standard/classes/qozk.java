/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.ButtonState;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

public class qozk {
    private xpzm _a;
    private Dimension _b = new Dimension(668, 158);
    private GuiRenderer _c;
    private ComponentButtonStyle _d = new ComponentButtonStyle(){
        {
            this.borderThickness = 52;
            this.setSize(new Dimension(800, 158));
            this.setTexture(new ResourceLocation("stalkerguide", "textures/gui/palka.png"));
        }
    };
    private divz _e;

    public qozk(divz divz2) {
        this._a = xpzm._E();
        this._e = divz2;
        this._c = new GuiRendererBuilder().setTextureSize(this._d.getSize().width, this._d.getSize().height).create();
    }

    public void _a(RenderGameOverlayEvent renderGameOverlayEvent) {
        thfd thfd2;
        if (renderGameOverlayEvent instanceof RenderGameOverlayEvent.Post && renderGameOverlayEvent.type == RenderGameOverlayEvent.ElementType.ALL && !this._a._t.field_71075_bZ._d && (thfd2 = this._e._i()) != null && !thfd2._l()) {
            this._a(thfd2, renderGameOverlayEvent);
        }
    }

    private void _a(thfd thfd2, RenderGameOverlayEvent renderGameOverlayEvent) {
        this._a._D.func_78478_c();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        int n = renderGameOverlayEvent.resolution._a() * renderGameOverlayEvent.resolution._e();
        int n2 = renderGameOverlayEvent.resolution._b() * renderGameOverlayEvent.resolution._e();
        int n3 = n / 2 - this._b.width / 2;
        int n4 = n2 - 100 - this._b.height / 2;
        this._c.drawButton(new Point(n3, n4), this._b, this._d, ButtonState.DEFAULT);
        String string = thfd2._k().getDescription();
        if (string != null) {
            int n5 = this._c.getFontHeight();
            String[] stringArray = string.split("\n");
            int n6 = 0;
            for (String string2 : stringArray) {
                this._c.drawCenteredString(string2, n / 2, n2 - 90 - n5 / 2 * stringArray.length + n5 * n6++, -1);
            }
        }
        GL11.glDisable(3042);
    }
}

