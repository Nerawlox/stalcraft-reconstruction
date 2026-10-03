/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.util.Collections;
import java.util.HashSet;
import java.util.Vector;
import java.util.function.Consumer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.AssetsBrowser;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNPCStringSlot;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcSkinPreviewInterface;
import org.lwjgl.opengl.GL11;

public class GuiNPCTextures
extends GuiNPCInterface
implements GuiNpcSkinPreviewInterface {
    private GuiNPCStringSlot slot;
    private gqjz parent;
    private String root = "";
    private AssetsBrowser assets;
    private HashSet dataFolder = new HashSet();
    private HashSet dataTextures = new HashSet();
    private String currentTexture;
    private Consumer<String> textureConsumer;

    public GuiNPCTextures(EntityNPCInterface entityNPCInterface, gqjz gqjz2, String string, Consumer<String> consumer) {
        super(entityNPCInterface);
        this.currentTexture = string;
        this.textureConsumer = consumer;
        this.root = AssetsBrowser.getRoot(string);
        this.assets = new AssetsBrowser(this.root, fmib._a());
        this.drawDefaultBackground = false;
        this.title = "Select Texture";
        this.parent = gqjz2;
    }

    public GuiNPCTextures(EntityNPCInterface entityNPCInterface, gqjz gqjz2) {
        this(entityNPCInterface, gqjz2, entityNPCInterface.display.texture, string -> {
            entityNPCInterface.display.texture = string;
        });
    }

    @Override
    public void func_73866_w_() {
        String string3;
        super.func_73866_w_();
        this.dataFolder.clear();
        String string2 = "Current Folder: /assets" + this.root;
        this.addLabel(new GuiNpcLabel(0, string2, this.field_73880_f / 2 - this.field_73886_k._b(string2) / 2, 20, 0xFFFFFF));
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
        int n = this.currentTexture.lastIndexOf("/");
        if (n > 0 && this.currentTexture.equals(this.assets.getAsset(string3 = this.currentTexture.substring(n + 1)))) {
            this.slot.selected = string3;
        }
        this.slot.func_77220_a(4, 5);
        this.addButton(2, new GuiNpcButton(2, this.field_73880_f / 2 - 100, this.field_73881_g - 44, 98, 20, "gui.back"));
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        this.slot.func_77211_a(n, n2, f);
        GL11.glEnable(2929);
        int n3 = this.field_73880_f / 2 - 180;
        int n4 = this.field_73881_g / 2 - 90;
        GL11.glEnable(32826);
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        GL11.glTranslatef(n3 + 33, n4 + 131, 50.0f);
        float f2 = 250.0f / (float)this.npc.display.modelSize;
        GL11.glScalef(-f2, f2, f2);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        float f3 = this.npc.field_70761_aq;
        float f4 = this.npc.field_70177_z;
        float f5 = this.npc.field_70125_A;
        float f6 = (float)(n3 + 33) - (float)n;
        float f7 = (float)(n4 + 131 - 50) - (float)n2;
        GL11.glRotatef(135.0f, 0.0f, 1.0f, 0.0f);
        qnon._b();
        GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-((float)Math.atan(f7 / 40.0f)) * 20.0f, 1.0f, 0.0f, 0.0f);
        this.npc.field_70761_aq = (float)Math.atan(f6 / 40.0f) * 20.0f;
        this.npc.field_70177_z = (float)Math.atan(f6 / 40.0f) * 40.0f;
        this.npc.field_70125_A = -((float)Math.atan(f7 / 40.0f)) * 20.0f;
        this.npc.field_70759_as = this.npc.field_70177_z;
        this.npc.cloakUpdate();
        GL11.glTranslatef(0.0f, this.npc.field_70129_M, 0.0f);
        gqqu._b._l = 180.0f;
        gqqu._b._a(this.npc, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        this.npc.field_70761_aq = f3;
        this.npc.field_70177_z = f4;
        this.npc.field_70125_A = f5;
        GL11.glPopMatrix();
        qnon._a();
        GL11.glDisable(32826);
        iwya._a(iwya._b);
        GL11.glDisable(3553);
        iwya._a(iwya._a);
    }

    @Override
    public void elementClicked() {
        if (this.dataTextures.contains(this.slot.selected) && this.slot.selected != null) {
            String string;
            this.currentTexture = string = this.assets.getAsset(this.slot.selected);
            if (this.textureConsumer != null) {
                this.textureConsumer.accept(string);
            }
            this.npc.textureLocation = null;
        }
    }

    @Override
    public void doubleClicked() {
        String string = this.slot.selected;
        if (string.equals("..<UP>..")) {
            this.root = this.root.substring(0, this.root.lastIndexOf("/"));
            this.assets = new AssetsBrowser(this.root, fmib._a());
            this.func_73866_w_();
        } else if (this.dataFolder.contains(string)) {
            this.root = this.root + string;
            this.assets = new AssetsBrowser(this.root, fmib._a());
            this.func_73866_w_();
        } else {
            this.close();
            NoppesUtil.openGUI(this.player, this.parent);
        }
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 2) {
            this.close();
            NoppesUtil.openGUI(this.player, this.parent);
        }
    }

    @Override
    public void save() {
    }
}

