/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import java.util.HashMap;
import java.util.Vector;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.tdpx;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.IScrollData;
import noppes.npcs.client.gui.util.ITopButtonListener;
import noppes.npcs.constants.EnumPlayerPacket;
import org.lwjgl.opengl.GL11;

public class GuiTransportSelection
extends GuiNPCInterface
implements IScrollData,
ITopButtonListener {
    private final ResourceLocation resource = new ResourceLocation("customnpcs", "textures/gui/smallbg.png");
    protected int xSize = 176;
    protected int guiLeft;
    protected int guiTop;
    private GuiCustomScroll scroll;

    public GuiTransportSelection(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        this.drawDefaultBackground = false;
        this.title = "";
    }

    @Override
    public void initGui() {
        super.initGui();
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - 222) / 2;
        String string = "";
        this.addLabel(new GuiNpcLabel(0, string, this.guiLeft + (this.xSize - this.fontRenderer._b(string)) / 2, this.guiTop + 10, 0x404040));
        this.addButton(new GuiNpcButton(0, this.guiLeft + 10, this.guiTop + 192, 156, 20, tdpx._a("transporter.travel")));
        this.scroll = new GuiCustomScroll(this, 0);
        this.scroll.setWorldAndResolution(this.mc, 350, 250);
        this.scroll.setSize(156, 165);
        this.scroll.guiLeft = this.guiLeft + 10;
        this.scroll.guiTop = this.guiTop + 20;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(this.resource);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, 176, 222);
        super.drawScreen(n, n2, f);
        this.scroll.drawScreen(n, n2, f);
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)guiButton;
        String string = this.scroll.getSelected();
        if (guiNpcButton.id == 0 && string != null) {
            this.close();
            NoppesUtilPlayer.sendData(EnumPlayerPacket.Transport, string);
        }
    }

    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        this.scroll.mouseClicked(n, n2, n3);
    }

    @Override
    public void keyTyped(char c, int n) {
        if (n == 1 || n == this.mc._M.keyBindInventory._d) {
            this.close();
        }
    }

    @Override
    public void save() {
    }

    @Override
    public void setData(Vector vector, HashMap hashMap) {
        this.scroll.setList(vector);
    }

    @Override
    public void setSelected(String string) {
    }
}

