/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.McBackground;
import gloomyfolken.mods.core.client.gui.engine.component.McDummySlot;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McTextArea;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class ejnl
extends GuiScreenAdvanced {
    private static final ResourceLocation _a = new ResourceLocation("stalker", "textures/gui/blueprint_background.png");
    private EntityPlayer _b;
    private final int _c;
    private aofd _d;

    public ejnl(gqjz gqjz2, EntityPlayer entityPlayer, int n) {
        super(GuiComponent.hdRenderer.setFont(ExternalFont.tahoma12));
        this.parentScreen = gqjz2;
        this._b = entityPlayer;
        this._c = n;
        cvzo cvzo2 = entityPlayer.field_71071_by.func_70301_a(n);
        this._d = (aofd)cvzo2._a();
        this.drawParentScreen = false;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        hsvw hsvw2 = this._d._b();
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        GuiComponent guiComponent = new McBackground(this, point.add(-178, -190), new Dimension(356, 380)).setTexture(_a).setHasBackground(true).setRenderer(new GuiRendererBuilder().setTextureSize(512, 512).create());
        this.addElement(guiComponent);
        String string = "\u0427\u0435\u0440\u0442\u0435\u0436 \u043f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u043e\u0441\u0432\u043e\u0438\u0442\u044c \u0438\u0437\u0433\u043e\u0442\u043e\u0432\u043b\u0435\u043d\u0438\u0435:";
        this.addElement(new McLabel((IAdvancedGui)this, string, point.add(0, -160)).setCentered());
        this.addElement(new McLabel((IAdvancedGui)this, hsvw2._e(), point.add(-10, -80)).setFontRenderer(ExternalFont.tahoma13));
        McTextArea mcTextArea = new McTextArea(this, point.add(-160, -10), new Dimension(320, 120));
        mcTextArea.drawBackground = false;
        mcTextArea.setText(hsvw2._g());
        mcTextArea.setRenderer(this.renderer.setFont(ExternalFont.tahoma11));
        this.addElement(mcTextArea);
        if (magc._a(this._b)._a(hsvw2)) {
            this.addElement(new McLabel((IAdvancedGui)this, "\u0423\u0436\u0435 \u0438\u0437\u0443\u0447\u0435\u043d!", point.add(-10, -57), -256).setFontRenderer(ExternalFont.tahoma10));
        }
        GuiHelper.addButton(this, point.add(-155, 135), new Dimension(150, 38), "\u0418\u0437\u0443\u0447\u0438\u0442\u044c").onClick(guiActionButtonClick -> this._a()).setRenderer(this.renderer);
        GuiHelper.addButton(this, point.add(10, 135), new Dimension(150, 38), "\u0417\u0430\u043a\u0440\u044b\u0442\u044c").onClick(guiActionButtonClick -> this.closeScreen()).setRenderer(this.renderer);
        McDummySlot mcDummySlot = new McDummySlot(this, hsvw2._h(), point.add(-92, -96), 2.0f);
        this.getElementsList().addAll(new GuiComponent[]{mcDummySlot, mcDummySlot.createToolTip()});
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        cvzo cvzo2 = this._b.field_71071_by.func_70301_a(this._c);
        if (cvzo2 == null || !(cvzo2._a() instanceof aofd)) {
            this.closeScreen();
        }
    }

    @Override
    protected void func_73869_a(char c, int n) {
        super.func_73869_a(c, n);
        if (n == 28) {
            this._a();
        }
    }

    private void _a() {
        new yuln(this._c).sendToServer();
        this.closeScreen();
    }
}

