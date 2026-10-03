/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.util.HashMap;
import java.util.Vector;
import net.minecraft.entity.Entity;
import net.minecraft.util.tdpx;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.IScrollData;
import noppes.npcs.constants.EnumPacketType;

public class GuiNpcRemoteEditor
extends GuiNPCInterface
implements IScrollData {
    private GuiCustomScroll scroll;
    private HashMap data = new HashMap();

    public GuiNpcRemoteEditor() {
        this.xSize = 256;
        this.setBackground("menubg.png");
        NoppesUtil.sendData(EnumPacketType.RemoteNpcsGet, new Object[0]);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        if (this.scroll == null) {
            this.scroll = new GuiCustomScroll(this, 0);
            this.scroll.setSize(165, 208);
            this.scroll.guiLeft = this.guiLeft + 4;
            this.scroll.guiTop = this.guiTop + 4;
        }
        this.addScroll(this.scroll, this.field_73882_e);
        String string = tdpx._a("remote.title");
        int n = (this.xSize - this.field_73886_k._b(string)) / 2;
        this.addLabel(new GuiNpcLabel(0, string, this.guiLeft + n, this.guiTop - 8, 0xFFFFFF));
        this.addButton(new GuiNpcButton(0, this.guiLeft + 170, this.guiTop + 6, 82, 20, "selectServer.edit"));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 170, this.guiTop + 28, 82, 20, "selectWorld.deleteButton"));
        this.addButton(new GuiNpcButton(2, this.guiLeft + 170, this.guiTop + 50, 82, 20, "remote.reset"));
        this.addButton(new GuiNpcButton(4, this.guiLeft + 170, this.guiTop + 72, 82, 20, "remote.tp"));
        this.addButton(new GuiNpcButton(5, this.guiLeft + 170, this.guiTop + 110, 82, 20, "remote.resetall"));
        this.addButton(new GuiNpcButton(3, this.guiLeft + 170, this.guiTop + 132, 82, 20, "remote.freeze"));
    }

    @Override
    public void func_73878_a(boolean bl, int n) {
        if (bl) {
            NoppesUtil.sendData(EnumPacketType.RemoteDelete, this.data.get(this.scroll.getSelected()));
        }
        NoppesUtil.openGUI(this.player, this);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        Object object;
        if (jiok2.field_73741_f == 3) {
            NoppesUtil.sendData(EnumPacketType.RemoteFreeze, new Object[0]);
        }
        if (jiok2.field_73741_f == 5) {
            object = this.data.values().iterator();
            while (object.hasNext()) {
                int n = (Integer)object.next();
                NoppesUtil.sendData(EnumPacketType.RemoteReset, n);
                Entity entity = this.player.field_70170_p.func_73045_a(n);
                if (entity == null || !(entity instanceof EntityNPCInterface)) continue;
                ((EntityNPCInterface)entity).reset();
            }
        }
        if (this.data.containsKey(this.scroll.getSelected())) {
            if (jiok2.field_73741_f == 0) {
                NoppesUtil.sendData(EnumPacketType.RemoteMainMenu, this.data.get(this.scroll.getSelected()));
            }
            if (jiok2.field_73741_f == 1) {
                object = new lowa(this, "Confirm", tdpx._a("gui.delete"), 0);
                this.field_73882_e._a((gqjz)object);
            }
            if (jiok2.field_73741_f == 2) {
                NoppesUtil.sendData(EnumPacketType.RemoteReset, this.data.get(this.scroll.getSelected()));
                object = this.player.field_70170_p.func_73045_a((Integer)this.data.get(this.scroll.getSelected()));
                if (object != null && object instanceof EntityNPCInterface) {
                    ((EntityNPCInterface)object).reset();
                }
            }
            if (jiok2.field_73741_f == 4) {
                NoppesUtil.sendData(EnumPacketType.RemoteTpToNpc, this.data.get(this.scroll.getSelected()));
                this.close();
            }
        }
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
        this.data = hashMap;
    }

    @Override
    public void setSelected(String string) {
        this.getButton((int)3).field_73744_e = string;
    }
}

