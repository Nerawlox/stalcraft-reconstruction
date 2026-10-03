/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezey;
import net.minecraft.util.ezfc;
import noppes.npcs.client.gui.util.GuiButtonNextPage;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class GuiMailmanWrite
extends gqjz {
    private static final ResourceLocation bookGuiTextures = new ResourceLocation("textures/gui/book.png");
    private final qoac itemstackBook;
    private int updateCount;
    private int bookImageWidth = 192;
    private int bookImageHeight = 192;
    private int bookTotalPages = 1;
    private int currPage;
    private bsyv bookPages;
    private GuiButtonNextPage buttonNextPage;
    private GuiButtonNextPage buttonPreviousPage;
    private boolean canEdit;
    private gqjz parent;

    public GuiMailmanWrite(gqjz gqjz2, qoac qoac2, boolean bl) {
        this.parent = gqjz2;
        this.itemstackBook = qoac2;
        this.canEdit = bl;
        if (this.itemstackBook._c("pages")) {
            this.bookPages = this.itemstackBook._n("pages");
        }
        if (this.bookPages != null) {
            this.bookPages = (bsyv)this.bookPages._c();
            this.bookTotalPages = this.bookPages._d();
            if (this.bookTotalPages < 1) {
                this.bookTotalPages = 1;
            }
        } else {
            this.bookPages = new bsyv("pages");
            this.bookPages._a(new xsxy("1", ""));
            this.bookTotalPages = 1;
        }
    }

    static ResourceLocation func_110404_g() {
        return bookGuiTextures;
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        ++this.updateCount;
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.add(new jiok(0, this.field_73880_f / 2 - 100, 4 + this.bookImageHeight, 98, 20, wpcz._a("gui.done")));
        int n = (this.field_73880_f - this.bookImageWidth) / 2;
        int n2 = 2;
        this.buttonNextPage = new GuiButtonNextPage(1, n + 120, n2 + 154, true);
        this.field_73887_h.add(this.buttonNextPage);
        this.buttonPreviousPage = new GuiButtonNextPage(2, n + 38, n2 + 154, false);
        this.field_73887_h.add(this.buttonPreviousPage);
        this.updateButtons();
    }

    @Override
    public void func_73874_b() {
        Keyboard.enableRepeatEvents(false);
    }

    private void updateButtons() {
        this.buttonNextPage.field_73748_h = this.currPage < this.bookTotalPages - 1 || this.canEdit;
        this.buttonPreviousPage.field_73748_h = this.currPage > 0;
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73742_g) {
            if (jiok2.field_73741_f == 0) {
                this.close();
            } else if (jiok2.field_73741_f == 1) {
                if (this.currPage < this.bookTotalPages - 1) {
                    ++this.currPage;
                } else if (this.canEdit) {
                    this.addNewPage();
                    if (this.currPage < this.bookTotalPages - 1) {
                        ++this.currPage;
                    }
                }
            } else if (jiok2.field_73741_f == 2 && this.currPage > 0) {
                --this.currPage;
            }
            this.updateButtons();
        }
    }

    private void addNewPage() {
        if (this.bookPages != null && this.bookPages._d() < 50) {
            this.bookPages._a(new xsxy("" + (this.bookTotalPages + 1), ""));
            ++this.bookTotalPages;
        }
    }

    @Override
    protected void func_73869_a(char c, int n) {
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
                this.func_74160_b(gqjz.func_73870_l());
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
        if (ezey._a(c)) {
            this.func_74160_b(Character.toString(c));
        }
    }

    private String func_74158_i() {
        if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages._d()) {
            xsxy xsxy2 = (xsxy)this.bookPages._b(this.currPage);
            return xsxy2.toString();
        }
        return "";
    }

    private void func_74159_a(String string) {
        if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages._d()) {
            xsxy xsxy2 = (xsxy)this.bookPages._b(this.currPage);
            xsxy2._c = string;
        }
    }

    private void func_74160_b(String string) {
        String string2 = this.func_74158_i();
        String string3 = string2 + string;
        int n = this.field_73886_k._b(string3 + "" + (Object)((Object)ezfc._a) + "_", 118);
        if (n <= 118 && string3.length() < 256) {
            this.func_74159_a(string3);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(bookGuiTextures);
        int n3 = (this.field_73880_f - this.bookImageWidth) / 2;
        int n4 = 2;
        this.func_73729_b(n3, n4, 0, 0, this.bookImageWidth, this.bookImageHeight);
        String string = String.format(wpcz._a("book.pageIndicator"), this.currPage + 1, this.bookTotalPages);
        String string2 = "";
        if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages._d()) {
            xsxy xsxy2 = (xsxy)this.bookPages._b(this.currPage);
            string2 = xsxy2.toString();
        }
        if (this.canEdit) {
            string2 = this.field_73886_k._e() ? string2 + "_" : (this.updateCount / 6 % 2 == 0 ? string2 + "" + (Object)((Object)ezfc._a) + "_" : string2 + "" + (Object)((Object)ezfc._h) + "_");
        }
        int n5 = this.field_73886_k._b(string);
        this.field_73886_k._b(string, n3 - n5 + this.bookImageWidth - 44, n4 + 16, 0);
        this.field_73886_k._a(string2, n3 + 36, n4 + 16 + 16, 116, 0);
        super.func_73863_a(n, n2, f);
    }

    public void close() {
        this.itemstackBook._a("pages", this.bookPages);
        this.field_73882_e._a(this.parent);
    }
}

