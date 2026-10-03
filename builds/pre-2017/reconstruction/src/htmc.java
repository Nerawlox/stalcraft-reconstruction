/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class htmc
extends GuiScreen {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/book.png");
    public final EntityPlayer _b;
    public final ItemStack _c;
    public final boolean _d;
    public boolean _e;
    public boolean _f;
    public int _g;
    public int _h = 192;
    public int _i = 192;
    public int _j = 1;
    public int _k;
    public NBTTagList _l;
    public String _m = "";
    public rqga _n;
    public rqga _o;
    public GuiButton _p;
    public GuiButton _q;
    public GuiButton _r;
    public GuiButton _s;

    public htmc(EntityPlayer entityPlayer, ItemStack itemStack, boolean bl) {
        this._b = entityPlayer;
        this._c = itemStack;
        this._d = bl;
        if (itemStack._p()) {
            NBTTagCompound nBTTagCompound = itemStack._q();
            this._l = nBTTagCompound._n("pages");
            if (this._l != null) {
                this._l = (NBTTagList)this._l._c();
                this._j = this._l._d();
                if (this._j < 1) {
                    this._j = 1;
                }
            }
        }
        if (this._l == null && bl) {
            this._l = new NBTTagList("pages");
            this._l._a(new NBTTagString("1", ""));
            this._j = 1;
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        ++this._g;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        if (this._d) {
            this._q = new GuiButton(3, this.width / 2 - 100, 4 + this._i, 98, 20, wpcz._a("book.signButton"));
            this.buttonList.add(this._q);
            this._p = new GuiButton(0, this.width / 2 + 2, 4 + this._i, 98, 20, wpcz._a("gui.done"));
            this.buttonList.add(this._p);
            this._r = new GuiButton(5, this.width / 2 - 100, 4 + this._i, 98, 20, wpcz._a("book.finalizeButton"));
            this.buttonList.add(this._r);
            this._s = new GuiButton(4, this.width / 2 + 2, 4 + this._i, 98, 20, wpcz._a("gui.cancel"));
            this.buttonList.add(this._s);
        } else {
            this._p = new GuiButton(0, this.width / 2 - 100, 4 + this._i, 200, 20, wpcz._a("gui.done"));
            this.buttonList.add(this._p);
        }
        int n = (this.width - this._h) / 2;
        int n2 = 2;
        this._n = new rqga(1, n + 120, n2 + 154, true);
        this.buttonList.add(this._n);
        this._o = new rqga(2, n + 38, n2 + 154, false);
        this.buttonList.add(this._o);
        this._a();
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    public void _a() {
        this._n.drawButton = !this._f && (this._k < this._j - 1 || this._d);
        this._o.drawButton = !this._f && this._k > 0;
        boolean bl = this._p.drawButton = !this._d || !this._f;
        if (this._d) {
            this._q.drawButton = !this._f;
            this._s.drawButton = this._f;
            this._r.drawButton = this._f;
            this._r.enabled = this._m.trim().length() > 0;
        }
    }

    public void _a(boolean bl) {
        if (!this._d || !this._e) {
            return;
        }
        if (this._l != null) {
            Object object;
            while (this._l._d() > 1) {
                object = (NBTTagString)this._l._b(this._l._d() - 1);
                if (((NBTTagString)object)._c != null && ((NBTTagString)object)._c.length() != 0) break;
                this._l._a(this._l._d() - 1);
            }
            if (this._c._p()) {
                object = this._c._q();
                ((NBTTagCompound)object)._a("pages", this._l);
            } else {
                this._c._a("pages", this._l);
            }
            object = "MC|BEdit";
            if (bl) {
                object = "MC|BSign";
                this._c._a("author", new NBTTagString("author", this._b.getCommandSenderName()));
                this._c._a("title", new NBTTagString("title", this._m.trim()));
                this._c._d = Item.writtenBook.itemID;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                Packet.writeItemStack(this._c, dataOutputStream);
                this.mc._z()._b(new Packet250CustomPayload((String)object, byteArrayOutputStream.toByteArray()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id == 0) {
            this.mc._a((GuiScreen)null);
            this._a(false);
        } else if (guiButton.id == 3 && this._d) {
            this._f = true;
        } else if (guiButton.id == 1) {
            if (this._k < this._j - 1) {
                ++this._k;
            } else if (this._d) {
                this._b();
                if (this._k < this._j - 1) {
                    ++this._k;
                }
            }
        } else if (guiButton.id == 2) {
            if (this._k > 0) {
                --this._k;
            }
        } else if (guiButton.id == 5 && this._f) {
            this._a(true);
            this.mc._a((GuiScreen)null);
        } else if (guiButton.id == 4 && this._f) {
            this._f = false;
        }
        this._a();
    }

    public void _b() {
        if (this._l == null || this._l._d() >= 50) {
            return;
        }
        this._l._a(new NBTTagString("" + (this._j + 1), ""));
        ++this._j;
        this._e = true;
    }

    @Override
    public void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        if (!this._d) {
            return;
        }
        if (this._f) {
            this._b(c, n);
        } else {
            this._a(c, n);
        }
    }

    public void _a(char c, int n) {
        switch (c) {
            case '\u0016': {
                this._b(GuiScreen.getClipboardString());
                return;
            }
        }
        switch (n) {
            case 14: {
                String string = this._c();
                if (string.length() > 0) {
                    this._a(string.substring(0, string.length() - 1));
                }
                return;
            }
            case 28: 
            case 156: {
                this._b("\n");
                return;
            }
        }
        if (ChatAllowedCharacters._a(c)) {
            this._b(Character.toString(c));
            return;
        }
    }

    public void _b(char c, int n) {
        switch (n) {
            case 14: {
                if (!this._m.isEmpty()) {
                    this._m = this._m.substring(0, this._m.length() - 1);
                    this._a();
                }
                return;
            }
            case 28: 
            case 156: {
                if (!this._m.isEmpty()) {
                    this._a(true);
                    this.mc._a((GuiScreen)null);
                }
                return;
            }
        }
        if (this._m.length() < 16 && ChatAllowedCharacters._a(c)) {
            this._m = this._m + Character.toString(c);
            this._a();
            this._e = true;
        }
    }

    public String _c() {
        if (this._l != null && this._k >= 0 && this._k < this._l._d()) {
            NBTTagString nBTTagString = (NBTTagString)this._l._b(this._k);
            return nBTTagString.toString();
        }
        return "";
    }

    public void _a(String string) {
        if (this._l != null && this._k >= 0 && this._k < this._l._d()) {
            NBTTagString nBTTagString = (NBTTagString)this._l._b(this._k);
            nBTTagString._c = string;
            this._e = true;
        }
    }

    public void _b(String string) {
        String string2 = this._c();
        String string3 = string2 + string;
        int n = this.fontRenderer._b(string3 + "" + (Object)((Object)EnumChatFormatting._a) + "_", 118);
        if (n <= 118 && string3.length() < 256) {
            this._a(string3);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._R()._a(_a);
        int n3 = (this.width - this._h) / 2;
        int n4 = 2;
        this.drawTexturedModalRect(n3, n4, 0, 0, this._h, this._i);
        if (this._f) {
            String string = this._m;
            if (this._d) {
                string = this._g / 6 % 2 == 0 ? string + "" + (Object)((Object)EnumChatFormatting._a) + "_" : string + "" + (Object)((Object)EnumChatFormatting._h) + "_";
            }
            String string2 = wpcz._a("book.editTitle");
            int n5 = this.fontRenderer._b(string2);
            this.fontRenderer._b(string2, n3 + 36 + (116 - n5) / 2, n4 + 16 + 16, 0);
            int n6 = this.fontRenderer._b(string);
            this.fontRenderer._b(string, n3 + 36 + (116 - n6) / 2, n4 + 48, 0);
            String string3 = String.format(wpcz._a("book.byAuthor"), this._b.getCommandSenderName());
            int n7 = this.fontRenderer._b(string3);
            this.fontRenderer._b((Object)((Object)EnumChatFormatting._i) + string3, n3 + 36 + (116 - n7) / 2, n4 + 48 + 10, 0);
            String string4 = wpcz._a("book.finalizeWarning");
            this.fontRenderer._a(string4, n3 + 36, n4 + 80, 116, 0);
        } else {
            String string = String.format(wpcz._a("book.pageIndicator"), this._k + 1, this._j);
            String string5 = "";
            if (this._l != null && this._k >= 0 && this._k < this._l._d()) {
                NBTTagString nBTTagString = (NBTTagString)this._l._b(this._k);
                string5 = nBTTagString.toString();
            }
            if (this._d) {
                string5 = this.fontRenderer._e() ? string5 + "_" : (this._g / 6 % 2 == 0 ? string5 + "" + (Object)((Object)EnumChatFormatting._a) + "_" : string5 + "" + (Object)((Object)EnumChatFormatting._h) + "_");
            }
            int n8 = this.fontRenderer._b(string);
            this.fontRenderer._b(string, n3 - n8 + this._h - 44, n4 + 16, 0);
            this.fontRenderer._a(string5, n3 + 36, n4 + 16 + 16, 116, 0);
        }
        super.drawScreen(n, n2, f);
    }

    public static /* synthetic */ ResourceLocation _d() {
        return _a;
    }
}

