/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.tdpx;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.AssetsBrowser;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNPCStringSlot;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;

public class GuiNpcSoundSelection
extends GuiNPCInterface {
    int depth = 0;
    private GuiNPCStringSlot slot;
    private Object parent;
    private String location = "";
    private String selectedLocation = "";
    private String selectedFile = "";
    private List folders = new ArrayList();
    private List files = new ArrayList();
    private String up = "..<" + tdpx._a("gui.up") + ">..";

    public GuiNpcSoundSelection(EntityNPCInterface entityNPCInterface, Object object, String string) {
        super(entityNPCInterface);
        string = string.replaceAll("\\.", "/");
        int n = string.lastIndexOf("/");
        if (n > 0) {
            this.selectedFile = string.substring(n + 1);
            this.location = (string = string.substring(0, n)).startsWith("customnpcs:") ? "customnpcs/" + string.substring(11) : "minecraft/" + string;
            this.depth = this.location.split("/").length;
            this.selectedLocation = this.location;
        }
        this.drawDefaultBackground = false;
        this.title = "";
        this.parent = object;
    }

    @Override
    public void initGui() {
        super.initGui();
        String string = tdpx._a("gui.currentFolder") + ": " + this.location;
        this.addLabel(new GuiNpcLabel(0, string, this.width / 2 - this.fontRenderer._b(string) / 2, 20, 0xFFFFFF));
        this.slot = new GuiNPCStringSlot(this.getList(), this, this.npc, false, 18);
        this.slot.registerScrollButtons(4, 5);
        if (this.depth > 0 && this.selectedLocation.equals(this.location)) {
            this.slot.selected = this.selectedFile;
        }
        this.addButton(new GuiNpcButton(2, this.width / 2 - 100, this.height - 44, 98, 20, "gui.back"));
        this.addButton(new GuiNpcButton(1, this.width / 2 + 2, this.height - 44, 98, 20, "gui.play"));
    }

    private List getList() {
        this.folders.clear();
        this.files.clear();
        ArrayList<String> arrayList = new ArrayList<String>();
        if (this.depth == 0) {
            this.folders.add("minecraft");
            this.folders.add("customnpcs");
        } else {
            arrayList.add(this.up);
            String string = this.location.startsWith("customnpcs") ? "/customnpcs/sound" + this.location.substring(10) : "/sound" + this.location.substring(9);
            AssetsBrowser assetsBrowser = new AssetsBrowser(string, new String[]{"ogg", "wav"});
            for (String string2 : assetsBrowser.folders) {
                this.folders.add("/" + string2);
            }
            for (String string2 : assetsBrowser.files) {
                string2 = string2.substring(0, string2.lastIndexOf("."));
                while (Character.isDigit(string2.charAt(string2.length() - 1))) {
                    string2 = string2.substring(0, string2.length() - 1);
                }
                if (this.files.contains(string2)) continue;
                this.files.add(string2);
            }
        }
        arrayList.addAll(this.folders);
        arrayList.addAll(this.files);
        return arrayList;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.slot.drawScreen(n, n2, f);
        super.drawScreen(n, n2, f);
    }

    @Override
    public void elementClicked() {
        if (this.slot.selected != null && this.files.contains(this.slot.selected)) {
            this.selectedLocation = this.location;
            this.selectedFile = this.slot.selected;
            if (this.parent instanceof GuiNPCInterface) {
                ((GuiNPCInterface)this.parent).elementClicked();
            } else if (this.parent instanceof GuiNPCInterface2) {
                ((GuiNPCInterface2)this.parent).elementClicked();
            }
        }
    }

    public String getSelected() {
        String string = this.location.startsWith("customnpcs/") ? "customnpcs:" + this.location.substring(11) : this.location.substring(10);
        string = string.replaceAll("/", ".");
        return string + "." + this.slot.selected;
    }

    @Override
    public void doubleClicked() {
        if (this.slot.selected.equals(this.up)) {
            --this.depth;
            this.location = this.depth == 0 ? "" : this.location.substring(0, this.location.lastIndexOf("/"));
            this.initGui();
        } else if (this.folders.contains(this.slot.selected)) {
            ++this.depth;
            this.location = this.location.endsWith("/") && this.slot.selected.startsWith("/") ? this.location + this.slot.selected.substring(1) : this.location + this.slot.selected;
            this.initGui();
        } else {
            this.close();
            NoppesUtil.openGUI(this.player, this.parent);
        }
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 1 && this.files.contains(this.slot.selected)) {
            this.mc._N._a(this.getSelected(), 1.0f, 1.0f);
        }
        if (guiButton.id == 2) {
            this.close();
            NoppesUtil.openGUI(this.player, this.parent);
        }
    }

    @Override
    public void save() {
    }
}

