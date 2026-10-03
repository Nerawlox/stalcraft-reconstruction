/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import java.util.ArrayList;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.tdpx;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.client.gui.util.GuiButtonNextPage;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiPlayerTopMenu;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.constants.EnumPlayerPacket;
import noppes.npcs.controllers.Faction;
import noppes.npcs.controllers.PlayerFactionData;
import org.lwjgl.opengl.GL11;

public class GuiFaction
extends GuiNPCInterface
implements IGuiData {
    private int xSize = 200;
    private int ySize = 216;
    private int guiLeft;
    private int guiTop;
    private ArrayList playerFactions = new ArrayList();
    private GuiPlayerTopMenu topMenu;
    private int page = 0;
    private int pages = 1;
    private GuiButtonNextPage buttonNextPage;
    private GuiButtonNextPage buttonPreviousPage;
    private ResourceLocation indicator;

    public GuiFaction() {
        this.drawDefaultBackground = false;
        this.title = "";
        NoppesUtilPlayer.sendData(EnumPlayerPacket.FactionsGet, new Object[0]);
        this.indicator = this.getResource("menubg.png");
    }

    @Override
    public void initGui() {
        super.initGui();
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
        this.topMenu = new GuiPlayerTopMenu(this.guiLeft + 4, this.guiTop - 9, 3, this.player);
        this.buttonNextPage = new GuiButtonNextPage(1, this.guiLeft + this.xSize - 43, this.guiTop + 198, true);
        this.buttonList.add(this.buttonNextPage);
        this.buttonPreviousPage = new GuiButtonNextPage(2, this.guiLeft + 20, this.guiTop + 198, false);
        this.buttonList.add(this.buttonPreviousPage);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(this.indicator);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop + 8, 0, 0, this.xSize, this.ySize);
        this.drawTexturedModalRect(this.guiLeft + 4, this.guiTop + 8, 56, 0, 200, this.ySize);
        if (this.playerFactions.isEmpty()) {
            String string = tdpx._a("faction.nostanding");
            this.fontRenderer._b(string, this.guiLeft + (this.xSize - this.fontRenderer._b(string)) / 2, this.guiTop + 80, 0x404040);
        } else {
            this.renderScreen();
        }
        super.drawScreen(n, n2, f);
        this.topMenu.drawScreen(n, n2, f);
    }

    private void renderScreen() {
        int n = 6;
        if (this.pages == 1) {
            n = this.playerFactions.size();
        }
        if (this.page == this.pages) {
            n = this.playerFactions.size() % 6;
        }
        for (int i = 0; i < n; ++i) {
            this.drawHorizontalLine(this.guiLeft + 2, this.guiLeft + this.xSize, this.guiTop + 14 + i * 30, -12566464);
            Faction faction = (Faction)this.playerFactions.get((this.page - 1) * 6 + i);
            String string = faction.name;
            String string2 = " : " + faction.defaultPoints;
            String string3 = tdpx._a("faction.friendly");
            int n2 = 65280;
            if (faction.defaultPoints < faction.neutralPoints) {
                string3 = tdpx._a("faction.unfriendly");
                n2 = 0xFF0000;
                string2 = string2 + "/" + faction.neutralPoints;
            } else if (faction.defaultPoints < faction.friendlyPoints) {
                string3 = tdpx._a("faction.neutral");
                n2 = 0xF2FF00;
                string2 = string2 + "/" + faction.friendlyPoints;
            } else {
                string2 = string2 + "/-";
            }
            this.fontRenderer._b(string, this.guiLeft + (this.xSize - this.fontRenderer._b(string)) / 2, this.guiTop + 19 + i * 30, faction.color);
            this.fontRenderer._b(string3, this.width / 2 - this.fontRenderer._b(string3) - 1, this.guiTop + 31 + i * 30, n2);
            this.fontRenderer._b(string2, this.width / 2, this.guiTop + 35 + i * 30, 0x404040);
        }
        this.drawHorizontalLine(this.guiLeft + 2, this.guiLeft + this.xSize, this.guiTop + 14 + n * 30, -12566464);
        if (this.pages > 1) {
            String string = this.page + "/" + this.pages;
            this.fontRenderer._b(string, this.guiLeft + (this.xSize - this.fontRenderer._b(string)) / 2, this.guiTop + 203, 0x404040);
        }
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 1) {
            ++this.page;
        }
        if (guiButton.id == 2) {
            --this.page;
        }
        this.updateButtons();
    }

    private void updateButtons() {
        this.buttonNextPage.drawButton = this.page < this.pages;
        this.buttonPreviousPage.drawButton = this.page > 1;
    }

    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        this.topMenu.mouseClicked(n, n2, n3);
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
    public void setGuiData(NBTTagCompound nBTTagCompound) {
        Object object;
        this.playerFactions = new ArrayList();
        NBTTagList nBTTagList = nBTTagCompound._n("FactionList");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            object = new Faction();
            ((Faction)object).readNBT((NBTTagCompound)nBTTagList._b(i));
            this.playerFactions.add(object);
        }
        PlayerFactionData playerFactionData = new PlayerFactionData();
        playerFactionData.readNBT(nBTTagCompound);
        object = playerFactionData.getFactionData().keySet().iterator();
        while (object.hasNext()) {
            int n = (Integer)object.next();
            int n2 = playerFactionData.getFactionData().get(n);
            for (Object e : this.playerFactions) {
                Faction faction = (Faction)e;
                if (faction.id != n) continue;
                faction.defaultPoints = n2;
            }
        }
        this.pages = (this.playerFactions.size() - 1) / 6;
        ++this.pages;
        this.page = 1;
        this.updateButtons();
    }
}

