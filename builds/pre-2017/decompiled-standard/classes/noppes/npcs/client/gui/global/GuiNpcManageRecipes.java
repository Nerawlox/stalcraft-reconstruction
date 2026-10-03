/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.global;

import java.util.HashMap;
import java.util.Vector;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface2;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiCustomScrollActionListener;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.client.gui.util.IScrollData;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.containers.ContainerManageRecipes;
import noppes.npcs.controllers.RecipeCarpentry;
import org.lwjgl.opengl.GL11;

public class GuiNpcManageRecipes
extends GuiContainerNPCInterface2
implements GuiCustomScrollActionListener,
IGuiData,
IScrollData,
ITextfieldListener {
    private GuiCustomScroll scroll;
    private HashMap data = new HashMap();
    private ContainerManageRecipes container;
    private RecipeCarpentry recipe = new RecipeCarpentry();
    private String selected = null;
    private ResourceLocation slot;

    public GuiNpcManageRecipes(EntityNPCInterface entityNPCInterface, ContainerManageRecipes containerManageRecipes) {
        super(entityNPCInterface, containerManageRecipes);
        this.container = containerManageRecipes;
        this.drawDefaultBackground = false;
        NoppesUtil.sendData(EnumPacketType.RecipesGet, containerManageRecipes.width);
        this.setBackground("npctradersetup.png");
        this.slot = this.getResource("slot.png");
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.scroll = new GuiCustomScroll(this, 0);
        this.scroll.func_73872_a(this.field_73882_e, 350, 250);
        this.scroll.setSize(130, 180);
        this.scroll.guiLeft = this.guiTop + 172;
        this.scroll.guiTop = this.guiLeft + 8;
        this.addButton(new GuiNpcButton(0, this.guiTop + 306, this.guiLeft + 10, 84, 20, "menu.global"));
        this.addButton(new GuiNpcButton(1, this.guiTop + 306, this.guiLeft + 32, 84, 20, "tile.npcCarpentyBench.name"));
        this.getButton((int)0).field_73742_g = this.container.width == 4;
        this.getButton((int)1).field_73742_g = this.container.width == 3;
        this.addButton(new GuiNpcButton(3, this.guiTop + 306, this.guiLeft + 60, 84, 20, "gui.add"));
        this.addButton(new GuiNpcButton(4, this.guiTop + 306, this.guiLeft + 82, 84, 20, "gui.remove"));
        this.addLabel(new GuiNpcLabel(0, "gui.ignoreDamage", this.guiTop + 86, this.guiLeft + 32, 0x404040));
        this.addButton(new GuiNpcButton(5, this.guiTop + 114, this.guiLeft + 40, 30, 20, new String[]{"gui.no", "gui.yes"}, 0));
        this.addTextField(new GuiNpcTextField(0, this, this.field_73886_k, this.guiTop + 8, this.guiLeft + 8, 160, 20, this.recipe.name));
        this.getTextField((int)0).enabled = false;
        this.getButton((int)5).field_73742_g = false;
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)jiok2;
        if (jiok2.field_73741_f == 0) {
            this.save();
            NoppesUtil.requestOpenGUI(EnumGuiType.ManageRecipes, 3, 0, 0);
        }
        if (jiok2.field_73741_f == 1) {
            this.save();
            NoppesUtil.requestOpenGUI(EnumGuiType.ManageRecipes, 4, 0, 0);
        }
        if (jiok2.field_73741_f == 3) {
            this.save();
            this.scroll.clear();
            String string = "New";
            while (this.data.containsKey(string)) {
                string = string + "_";
            }
            RecipeCarpentry recipeCarpentry = new RecipeCarpentry(-1, string);
            recipeCarpentry.isGlobal = this.container.width == 3;
            NoppesUtil.sendData(EnumPacketType.RecipeSave, recipeCarpentry.writeNBT());
        }
        if (jiok2.field_73741_f == 4 && this.data.containsKey(this.scroll.getSelected())) {
            NoppesUtil.sendData(EnumPacketType.RecipeRemove, this.data.get(this.scroll.getSelected()));
            this.scroll.clear();
        }
        if (jiok2.field_73741_f == 5) {
            this.recipe.ignoreDamage = guiNpcButton.getValue() == 1;
        }
    }

    public void doubleClicked() {
    }

    @Override
    public void setGuiData(qoac qoac2) {
        RecipeCarpentry recipeCarpentry = new RecipeCarpentry();
        recipeCarpentry.readNBT(qoac2);
        this.recipe = recipeCarpentry;
        this.getTextField(0).func_73782_a(recipeCarpentry.name);
        this.container.setRecipe(recipeCarpentry);
        this.getTextField((int)0).enabled = true;
        this.getButton((int)5).field_73742_g = true;
        this.getButton(5).setDisplay(recipeCarpentry.ignoreDamage ? 1 : 0);
        this.setSelected(recipeCarpentry.name);
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        super.func_74185_a(f, n, n2);
        this.scroll.func_73863_a(n, n2, f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(this.slot);
        for (int i = 0; i < this.container.width; ++i) {
            for (int j = 0; j < this.container.width; ++j) {
                this.func_73729_b(this.guiTop + i * 18 + 7, this.guiLeft + j * 18 + 34, 0, 0, 20, 20);
            }
        }
        this.func_73729_b(this.guiTop + 86, this.guiLeft + 60, 0, 0, 20, 20);
    }

    @Override
    public void setData(Vector vector, HashMap hashMap) {
        String string = this.scroll.getSelected();
        this.data = hashMap;
        this.scroll.setList(vector);
        this.getTextField((int)0).enabled = string != null;
        boolean bl = this.getButton((int)5).field_73742_g = string != null;
        if (string != null) {
            this.scroll.setSelected(string);
        }
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        if (n3 == 0 && this.scroll != null) {
            this.scroll.func_73864_a(n, n2, n3);
        }
    }

    @Override
    public void setSelected(String string) {
        this.selected = string;
        this.scroll.setSelected(string);
    }

    @Override
    public void customScrollClicked(int n, int n2, int n3, GuiCustomScroll guiCustomScroll) {
        this.save();
        this.selected = this.scroll.getSelected();
        NoppesUtil.sendData(EnumPacketType.RecipeGet, this.data.get(this.selected));
    }

    @Override
    public void save() {
        GuiNpcTextField.unfocus();
        if (this.selected != null && this.data.containsKey(this.selected)) {
            this.container.saveRecipe();
            NoppesUtil.sendData(EnumPacketType.RecipeSave, this.recipe.writeNBT());
        }
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        String string = guiNpcTextField.func_73781_b();
        if (!string.isEmpty() && !this.data.containsKey(string)) {
            String string2 = this.recipe.name;
            this.data.remove(this.recipe.name);
            this.recipe.name = string;
            this.data.put(this.recipe.name, this.recipe.id);
            this.selected = string;
            this.scroll.replace(string2, this.recipe.name);
        }
    }
}

