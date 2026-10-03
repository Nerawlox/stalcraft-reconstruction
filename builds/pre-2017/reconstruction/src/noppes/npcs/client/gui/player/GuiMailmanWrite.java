/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.client.gui.util.GuiButtonNextPage;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class GuiMailmanWrite
extends GuiScreen {
    private static final ResourceLocation bookGuiTextures = new ResourceLocation("textures/gui/book.png");
    private final NBTTagCompound itemstackBook;
    private int updateCount;
    private int bookImageWidth = 192;
    private int bookImageHeight = 192;
    private int bookTotalPages = 1;
    private int currPage;
    private NBTTagList bookPages;
    private GuiButtonNextPage buttonNextPage;
    private GuiButtonNextPage buttonPreviousPage;
    private boolean canEdit;
    private GuiScreen parent;

    public GuiMailmanWrite(GuiScreen guiScreen, NBTTagCompound nBTTagCompound, boolean bl) {
        this.parent = guiScreen;
        this.itemstackBook = nBTTagCompound;
        this.canEdit = bl;
        if (this.itemstackBook._c("pages")) {
            this.bookPages = this.itemstackBook._n("pages");
        }
        if (this.bookPages != null) {
            this.bookPages = (NBTTagList)this.bookPages._c();
            this.bookTotalPages = this.bookPages._d();
            if (this.bookTotalPages < 1) {
                this.bookTotalPages = 1;
            }
        } else {
            this.bookPages = new NBTTagList("pages");
            this.bookPages._a(new NBTTagString("1", ""));
            this.bookTotalPages = 1;
        }
    }

    static ResourceLocation func_110404_g() {
        return bookGuiTextures;
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        ++this.updateCount;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, 4 + this.bookImageHeight, 98, 20, wpcz._a("gui.done")));
        int n = (this.width - this.bookImageWidth) / 2;
        int n2 = 2;
        this.buttonNextPage = new GuiButtonNextPage(1, n + 120, n2 + 154, true);
        this.buttonList.add(this.buttonNextPage);
        this.buttonPreviousPage = new GuiButtonNextPage(2, n + 38, n2 + 154, false);
        this.buttonList.add(this.buttonPreviousPage);
        this.updateButtons();
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    private void updateButtons() {
        this.buttonNextPage.drawButton = this.currPage < this.bookTotalPages - 1 || this.canEdit;
        this.buttonPreviousPage.drawButton = this.currPage > 0;
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.enabled) {
            if (guiButton.id == 0) {
                this.close();
            } else if (guiButton.id == 1) {
                if (this.currPage < this.bookTotalPages - 1) {
                    ++this.currPage;
                } else if (this.canEdit) {
                    this.addNewPage();
                    if (this.currPage < this.bookTotalPages - 1) {
                        ++this.currPage;
                    }
                }
            } else if (guiButton.id == 2 && this.currPage > 0) {
                --this.currPage;
            }
            this.updateButtons();
        }
    }

    private void addNewPage() {
        if (this.bookPages != null && this.bookPages._d() < 50) {
            this.bookPages._a(new NBTTagString("" + (this.bookTotalPages + 1), ""));
            ++this.bookTotalPages;
        }
    }

    @Override
    protected void keyTyped(char c, int n) {
        if (n == 1) {
            this.close();
        }
        if (this.canEdit) {
            this.keyTypedInBook(c, n);
        }
    }

    private void keyTypedInBook(char c, int n) {
        switch (c) {
            case '\u0016': {
                this.func_74160_b(GuiScreen.getClipboardString());
                return;
            }
        }
        switch (n) {
            case 14: {
                String string = this.func_74158_i();
                if (string.length() > 0) {
                    this.func_74159_a(string.substring(0, string.length() - 1));
                }
                return;
            }
            case 28: 
            case 156: {
                this.func_74160_b("\n");
                return;
            }
        }
        if (ChatAllowedCharacters._a(c)) {
            this.func_74160_b(Character.toString(c));
        }
    }

    private String func_74158_i() {
        if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages._d()) {
            NBTTagString nBTTagString = (NBTTagString)this.bookPages._b(this.currPage);
            return nBTTagString.toString();
        }
        return "";
    }

    private void func_74159_a(String string) {
        if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages._d()) {
            NBTTagString nBTTagString = (NBTTagString)this.bookPages._b(this.currPage);
            nBTTagString._c = string;
        }
    }

    private void func_74160_b(String string) {
        String string2 = this.func_74158_i();
        String string3 = string2 + string;
        int n = this.fontRenderer._b(string3 + "" + (Object)((Object)EnumChatFormatting._a) + "_", 118);
        if (n <= 118 && string3.length() < 256) {
            this.func_74159_a(string3);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._R()._a(bookGuiTextures);
        int n3 = (this.width - this.bookImageWidth) / 2;
        int n4 = 2;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.bookImageWidth, this.bookImageHeight);
        String string = String.format(wpcz._a("book.pageIndicator"), this.currPage + 1, this.bookTotalPages);
        String string2 = "";
        if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages._d()) {
            NBTTagString nBTTagString = (NBTTagString)this.bookPages._b(this.currPage);
            string2 = nBTTagString.toString();
        }
        if (this.canEdit) {
            string2 = this.fontRenderer._e() ? string2 + "_" : (this.updateCount / 6 % 2 == 0 ? string2 + "" + (Object)((Object)EnumChatFormatting._a) + "_" : string2 + "" + (Object)((Object)EnumChatFormatting._h) + "_");
        }
        int n5 = this.fontRenderer._b(string);
        this.fontRenderer._b(string, n3 - n5 + this.bookImageWidth - 44, n4 + 16, 0);
        this.fontRenderer._a(string2, n3 + 36, n4 + 16 + 16, 116, 0);
        super.drawScreen(n, n2, f);
    }

    public void close() {
        this.itemstackBook._a("pages", this.bookPages);
        this.mc._a(this.parent);
    }
}

