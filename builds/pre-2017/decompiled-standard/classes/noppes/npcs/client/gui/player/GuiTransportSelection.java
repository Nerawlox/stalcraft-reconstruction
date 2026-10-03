/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import java.util.HashMap;
import java.util.Vector;
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
    public void func_73866_w_() {
        super.func_73866_w_();
        this.guiLeft = (this.field_73880_f - this.xSize) / 2;
        this.guiTop = (this.field_73881_g - 222) / 2;
        String string = "";
        this.addLabel(new GuiNpcLabel(0, string, this.guiLeft + (this.xSize - this.field_73886_k._b(string)) / 2, this.guiTop + 10, 0x404040));
        this.addButton(new GuiNpcButton(0, this.guiLeft + 10, this.guiTop + 192, 156, 20, tdpx._a("transporter.travel")));
        this.scroll = new GuiCustomScroll(this, 0);
        this.scroll.func_73872_a(this.field_73882_e, 350, 250);
        this.scroll.setSize(156, 165);
        this.scroll.guiLeft = this.guiLeft + 10;
        this.scroll.guiTop = this.guiTop + 20;
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(this.resource);
        this.func_73729_b(this.guiLeft, this.guiTop, 0, 0, 176, 222);
        super.func_73863_a(n, n2, f);
        this.scroll.func_73863_a(n, n2, f);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)jiok2;
        String string = this.scroll.getSelected();
        if (guiNpcButton.field_73741_f == 0 && string != null) {
            this.close();
            NoppesUtilPlayer.sendData(EnumPlayerPacket.Transport, string);
        }
    }

    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        this.scroll.func_73864_a(n, n2, n3);
    }

    @Override
    public void func_73869_a(char c, int n) {
        if (n == 1 || n == this.field_73882_e._M.field_74315_B._d) {
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

