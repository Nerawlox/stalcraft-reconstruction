/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.util.Collections;
import java.util.HashSet;
import java.util.Vector;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderManager;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.AssetsBrowser;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNPCStringSlot;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcSkinPreviewInterface;
import org.lwjgl.opengl.GL11;

public class GuiNpcTextureCloaks
extends GuiNPCInterface
implements GuiNpcSkinPreviewInterface {
    private GuiNPCStringSlot slot;
    private GuiScreen parent;
    private String root = "/customnpcs/textures/cloak";
    private AssetsBrowser assets;
    private HashSet dataFolder = new HashSet();
    private HashSet dataTextures = new HashSet();

    public GuiNpcTextureCloaks(EntityNPCInterface entityNPCInterface, GuiScreen guiScreen) {
        super(entityNPCInterface);
        if (!entityNPCInterface.display.cloakTexture.isEmpty()) {
            this.root = AssetsBrowser.getRoot(entityNPCInterface.display.cloakTexture);
        }
        this.assets = new AssetsBrowser(this.root, new String[]{"png"});
        this.drawDefaultBackground = false;
        this.title = "Select Texture";
        this.parent = guiScreen;
    }

    @Override
    public void initGui() {
        String string3;
        super.initGui();
        this.dataFolder.clear();
        String string2 = "Current Folder: " + this.root;
        this.addLabel(new GuiNpcLabel(0, string2, this.width / 2 - this.fontRenderer._b(string2) / 2, 20, 0xFFFFFF));
        Vector<String> vector = new Vector<String>();
        if (!this.assets.isRoot) {
            vector.add("..<UP>..");
        }
        for (String string3 : this.assets.folders) {
            vector.add("/" + string3);
            this.dataFolder.add("/" + string3);
        }
        for (String string3 : this.assets.files) {
            vector.add(string3);
            this.dataTextures.add(string3);
        }
        Collections.sort(vector, String.CASE_INSENSITIVE_ORDER);
        this.slot = new GuiNPCStringSlot(vector, this, this.npc, false, 18);
        int n = this.npc.display.cloakTexture.lastIndexOf("/");
        if (n > 0 && this.npc.display.cloakTexture.equals(this.assets.getAsset(string3 = this.npc.display.cloakTexture.substring(n + 1)))) {
            this.slot.selected = string3;
        }
        this.slot.registerScrollButtons(4, 5);
        this.addButton(2, new GuiNpcButton(2, this.width / 2 - 100, this.height - 44, 98, 20, "gui.back"));
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        int n3 = this.width / 2 - 180;
        int n4 = this.height / 2 - 90;
        GL11.glEnable(32826);
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        GL11.glTranslatef(n3 + 33, n4 + 131, 50.0f);
        float f2 = 250.0f / (float)this.npc.display.modelSize;
        GL11.glScalef(-f2, f2, f2);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        float f3 = this.npc.renderYawOffset;
        float f4 = this.npc.rotationYaw;
        float f5 = this.npc.rotationPitch;
        float f6 = (float)(n3 + 33) - (float)n;
        float f7 = (float)(n4 + 131 - 50) - (float)n2;
        GL11.glRotatef(135.0f, 0.0f, 1.0f, 0.0f);
        qnon._b();
        GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-((float)Math.atan(f7 / 40.0f)) * 20.0f, 1.0f, 0.0f, 0.0f);
        this.npc.renderYawOffset = (float)Math.atan(f6 / 40.0f) * 20.0f + 180.0f;
        this.npc.rotationYaw = (float)Math.atan(f6 / 40.0f) * 40.0f + 180.0f;
        this.npc.rotationPitch = -((float)Math.atan(f7 / 40.0f)) * 20.0f;
        this.npc.rotationYawHead = this.npc.rotationYaw;
        this.npc.cloakUpdate();
        GL11.glTranslatef(0.0f, this.npc.yOffset, 0.0f);
        RenderManager._b._l = 180.0f;
        RenderManager._b._a(this.npc, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        this.npc.renderYawOffset = f3;
        this.npc.rotationYaw = f4;
        this.npc.rotationPitch = f5;
        GL11.glPopMatrix();
        qnon._a();
        GL11.glDisable(32826);
        iwya._a(iwya._b);
        GL11.glDisable(3553);
        iwya._a(iwya._a);
        this.slot.drawScreen(n, n2, f);
        super.drawScreen(n, n2, f);
    }

    @Override
    public void elementClicked() {
        if (this.dataTextures.contains(this.slot.selected) && this.slot.selected != null) {
            this.npc.display.cloakTexture = this.assets.getAsset(this.slot.selected);
            this.npc.textureCloakLocation = null;
        }
    }

    @Override
    public void doubleClicked() {
        String string = this.slot.selected;
        if (string.equals("..<UP>..")) {
            this.root = this.root.substring(0, this.root.lastIndexOf("/"));
            this.assets = new AssetsBrowser(this.root, fmib._a());
            this.initGui();
        } else if (this.dataFolder.contains(string)) {
            this.root = this.root + string;
            this.assets = new AssetsBrowser(this.root, fmib._a());
            this.initGui();
        } else {
            this.close();
            NoppesUtil.openGUI(this.player, this.parent);
        }
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 2) {
            this.close();
            NoppesUtil.openGUI(this.player, this.parent);
        }
    }

    @Override
    public void save() {
    }
}

