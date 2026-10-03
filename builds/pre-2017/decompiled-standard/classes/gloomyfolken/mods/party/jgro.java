/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.party;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.party.kjui;
import gloomyfolken.mods.party.zwat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mods.pda.client.PdaClient;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.opengl.GL11;

@ezey(_a={eidj.CLIENT})
public class jgro {
    private static final ResourceLocation _a = new ResourceLocation("party", "textures/gui/hud.png");
    private GuiRenderer _b = new GuiRendererBuilder().setFontRenderer(ExternalFont.tahoma11).setTextureSize(128, 128).create();

    @ForgeSubscribe
    public void _a(RenderGameOverlayEvent.Post post) {
        if (post.type != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        xpzm xpzm2 = xpzm._E();
        List list2 = new ArrayList<kjui.kjui>(zwat._a._a.values()).stream().filter(kjui2 -> kjui2._c).collect(Collectors.toList());
        if (list2.isEmpty()) {
            return;
        }
        boolean bl = PdaClient.invertedHud.enabled;
        Point point = new Point(bl ? xpzm2._n - 280 : 20, 20);
        String string = list2.stream().filter(kjui2 -> kjui2._a.equals(xpzm2._t.field_71092_bJ)).findFirst().map(kjui2 -> kjui2._b).orElse("");
        Dimension dimension = new Dimension(255, 27);
        for (int i = 0; i < list2.size(); ++i) {
            this._a(point.add(0, 35 * i), dimension, (kjui.kjui)list2.get(i), string, i == 0);
        }
    }

    private void _a(Point point, Dimension dimension, kjui.kjui kjui2, String string, boolean bl) {
        boolean bl2 = kjui2._a();
        boolean bl3 = !bl2 && !kjui2._b.equals(string);
        GL11.glEnable(3042);
        this._b.bindTexture(_a);
        Point point2 = bl2 ? new Point(1, 82) : (bl ? new Point(1, 53) : new Point(1, 1));
        this._b.drawTiledRect(point, point2, dimension, new Dimension(64, 27), 23, 0);
        Point point3 = bl2 || bl3 ? new Point(1, 39) : new Point(1, 30);
        int n = dimension.width - 70;
        if (!bl2 && !bl3) {
            n = (int)((float)n * kjui2._g);
        }
        this._b.drawTiledRect(point.add(40, 15), point3, new Dimension(n, 8), new Dimension(21, 8), 3, 2);
        Point point4 = bl2 ? new Point(24, 30) : (bl3 ? new Point(45, 30) : new Point(69, 30));
        Dimension dimension2 = bl2 ? new Dimension(18, 18) : new Dimension(22, 20);
        this._b.drawTexturedModalRect(point.add(15, 3), point4, dimension2);
        this._b.drawString(this._b.trimToWidth(kjui2._a, dimension.width - 75, true), point.add(40, 0), -4408132);
        GL11.glDisable(3042);
    }
}

