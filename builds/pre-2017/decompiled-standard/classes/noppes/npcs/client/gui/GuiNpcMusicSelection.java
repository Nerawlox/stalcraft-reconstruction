/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.tdpx;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.AssetsBrowser;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.controllers.MusicController;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNPCStringSlot;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;

public class GuiNpcMusicSelection
extends GuiNPCInterface {
    public gqjz listener;
    int depth = 0;
    private GuiNPCStringSlot slot;
    private gqjz parent;
    private String location = "";
    private String selectedLocation = "";
    private String selectedFile = "";
    private List folders = new ArrayList();
    private List files = new ArrayList();
    private String up = "..<" + tdpx._a("gui.up") + ">..";

    public GuiNpcMusicSelection(EntityNPCInterface entityNPCInterface, gqjz gqjz2, String string) {
        super(entityNPCInterface);
        string = string.replaceAll("\\.", "/");
        if (string.startsWith("customnpcs:")) {
            int n = string.lastIndexOf("/");
            if (n < 0) {
                n = 11;
            }
            this.selectedFile = string.substring(n + 1);
            string = string.substring(0, n);
            this.location = "/" + string.substring(11);
            this.depth = this.location.split("/").length;
            this.selectedLocation = this.location;
        }
        this.drawDefaultBackground = false;
        this.title = "";
        this.listener = this.parent = gqjz2;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        String string = tdpx._a("gui.currentFolder") + ": " + this.location;
        this.addLabel(new GuiNpcLabel(0, string, this.field_73880_f / 2 - this.field_73886_k._b(string) / 2, 20, 0xFFFFFF));
        this.slot = new GuiNPCStringSlot(this.getList(), this, this.npc, false, 18);
        this.slot.func_77220_a(4, 5);
        if (this.depth > 0 && this.selectedLocation.equals(this.location)) {
            this.slot.selected = this.selectedFile;
        }
        this.addButton(new GuiNpcButton(2, this.field_73880_f / 2 - 100, this.field_73881_g - 44, 98, 20, "gui.back"));
        this.addButton(new GuiNpcButton(1, this.field_73880_f / 2 + 2, this.field_73881_g - 44, 98, 20, "gui.play"));
    }

    private List getList() {
        this.folders.clear();
        this.files.clear();
        ArrayList<String> arrayList = new ArrayList<String>();
        if (this.depth > 0) {
            arrayList.add(this.up);
        }
        AssetsBrowser assetsBrowser = new AssetsBrowser("/customnpcs/music" + this.location, new String[]{"ogg", "wav"});
        for (String string : assetsBrowser.folders) {
            this.folders.add("/" + string);
        }
        for (String string : assetsBrowser.files) {
            if (this.files.contains(string = string.substring(0, string.lastIndexOf(".")))) continue;
            this.files.add(string);
        }
        arrayList.addAll(this.folders);
        arrayList.addAll(this.files);
        return arrayList;
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.slot.func_77211_a(n, n2, f);
        super.func_73863_a(n, n2, f);
    }

    @Override
    public void elementClicked() {
        if (this.slot.selected != null && this.files.contains(this.slot.selected)) {
            this.selectedLocation = this.location;
            this.selectedFile = this.slot.selected;
        }
    }

    public String getSelected() {
        if (this.selectedFile != null && !this.selectedFile.isEmpty()) {
            String string = this.selectedFile;
            if (!this.selectedLocation.isEmpty()) {
                string = this.selectedLocation.replaceAll("/", ".").substring(1) + "." + string;
            }
            return "customnpcs:" + string;
        }
        return "";
    }

    @Override
    public void doubleClicked() {
        if (this.slot.selected.equals(this.up)) {
            --this.depth;
            this.location = this.depth == 0 ? "" : this.location.substring(0, this.location.lastIndexOf("/"));
            this.func_73866_w_();
        } else if (this.folders.contains(this.slot.selected)) {
            ++this.depth;
            this.location = this.location.endsWith("/") && this.slot.selected.startsWith("/") ? this.location + this.slot.selected.substring(1) : this.location + this.slot.selected;
            this.func_73866_w_();
        } else {
            this.close();
            NoppesUtil.openGUI(this.player, this.parent);
        }
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 1) {
            MusicController.Instance.playMusic(this.getSelected());
        }
        if (jiok2.field_73741_f == 2) {
            this.close();
            NoppesUtil.openGUI(this.player, this.parent);
        }
    }

    @Override
    public void save() {
        if (this.listener instanceof GuiNPCInterface) {
            ((GuiNPCInterface)this.listener).elementClicked();
        } else if (this.listener instanceof GuiNPCInterface2) {
            ((GuiNPCInterface2)this.listener).elementClicked();
        }
    }
}

