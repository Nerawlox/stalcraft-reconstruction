/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import noppes.npcs.DataAI;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.constants.EnumPacketType;

public class GuiNpcPather
extends GuiNPCInterface
implements IGuiData {
    private GuiCustomScroll scroll;
    private HashMap data = new HashMap();
    private DataAI ai;

    public GuiNpcPather(EntityNPCInterface entityNPCInterface) {
        this.drawDefaultBackground = false;
        this.xSize = 176;
        this.title = "Npc Pather";
        this.setBackground("smallbg.png");
        this.ai = entityNPCInterface.aiData;
        NoppesUtil.sendData(EnumPacketType.MainmenuAIGet, new Object[0]);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.scroll = new GuiCustomScroll(this, 0);
        this.scroll.setSize(160, 164);
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int[] nArray : this.ai.getMovingPath()) {
            arrayList.add("x:" + nArray[0] + " y:" + nArray[1] + " z:" + nArray[2]);
        }
        this.scroll.setUnsortedList(arrayList);
        this.scroll.guiLeft = this.guiLeft + 7;
        this.scroll.guiTop = this.guiTop + 12;
        this.addScroll(this.scroll, this.field_73882_e);
        this.addButton(new GuiNpcButton(0, this.guiLeft + 6, this.guiTop + 178, 52, 20, "gui.down"));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 62, this.guiTop + 178, 52, 20, "gui.up"));
        this.addButton(new GuiNpcButton(2, this.guiLeft + 118, this.guiTop + 178, 52, 20, "selectWorld.deleteButton"));
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (this.scroll.selected >= 0) {
            int[] nArray;
            int[] nArray2;
            int n;
            List list;
            if (jiok2.field_73741_f == 0) {
                list = this.ai.getMovingPath();
                n = this.scroll.selected;
                if (list.size() <= n + 1) {
                    return;
                }
                nArray2 = (int[])list.get(n);
                nArray = (int[])list.get(n + 1);
                list.set(n, nArray);
                list.set(n + 1, nArray2);
                this.ai.setMovingPath(list);
                this.func_73866_w_();
                this.scroll.selected = n + 1;
            }
            if (jiok2.field_73741_f == 1) {
                if (this.scroll.selected - 1 < 0) {
                    return;
                }
                list = this.ai.getMovingPath();
                n = this.scroll.selected;
                nArray2 = (int[])list.get(n);
                nArray = (int[])list.get(n - 1);
                list.set(n, nArray);
                list.set(n - 1, nArray2);
                this.ai.setMovingPath(list);
                this.func_73866_w_();
                this.scroll.selected = n - 1;
            }
            if (jiok2.field_73741_f == 2) {
                list = this.ai.getMovingPath();
                if (list.size() <= 1) {
                    return;
                }
                list.remove(this.scroll.selected);
                this.ai.setMovingPath(list);
                this.func_73866_w_();
            }
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
        NoppesUtil.sendData(EnumPacketType.MainmenuAISave, this.ai.writeToNBT(new qoac()));
    }

    @Override
    public void setGuiData(qoac qoac2) {
        this.ai.readToNBT(qoac2);
        this.func_73866_w_();
    }
}

