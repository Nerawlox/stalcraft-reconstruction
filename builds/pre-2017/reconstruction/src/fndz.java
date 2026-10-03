/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.ObjectArrays;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.network.packet.Packet203AutoComplete;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.ClientCommandHandler;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

@SideOnly(value=Side.CLIENT)
public class fndz
extends GuiScreen {
    public String _a = "";
    public int _b = -1;
    public boolean _c;
    public boolean _d;
    public int _e;
    public List _f = new ArrayList();
    public URI _g;
    public GuiTextField _h;
    public String _i = "";

    public fndz() {
    }

    public fndz(String string) {
        this._i = string;
    }

    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this._b = this.mc._J.getChatGUI()._c().size();
        this._h = new GuiTextField(this.fontRenderer, 4, this.height - 12, this.width - 4, 12);
        this._h.setMaxStringLength(100);
        this._h.setEnableBackgroundDrawing(false);
        this._h.setFocused(true);
        this._h.setText(this._i);
        this._h.setCanLoseFocus(false);
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        this.mc._J.getChatGUI()._d();
    }

    @Override
    public void updateScreen() {
        this._h.updateCursorCounter();
    }

    @Override
    public void keyTyped(char c, int n) {
        this._d = false;
        if (n == 15) {
            this._a();
        } else {
            this._c = false;
        }
        if (n == 1) {
            this.mc._a((GuiScreen)null);
        } else if (n != 28 && n != 156) {
            if (n == 200) {
                this._a(-1);
            } else if (n == 208) {
                this._a(1);
            } else if (n == 201) {
                this.mc._J.getChatGUI()._b(this.mc._J.getChatGUI()._i() - 1);
            } else if (n == 209) {
                this.mc._J.getChatGUI()._b(-this.mc._J.getChatGUI()._i() + 1);
            } else {
                this._h.textboxKeyTyped(c, n);
            }
        } else {
            String string = this._h.getText().trim();
            if (string.length() > 0) {
                this.mc._J.getChatGUI()._b(string);
                if (!this.mc._b(string)) {
                    this.mc._t.sendChatMessage(string);
                }
            }
            this.mc._a((GuiScreen)null);
        }
    }

    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
        int n = Mouse.getEventDWheel();
        if (n != 0) {
            if (n > 1) {
                n = 1;
            }
            if (n < -1) {
                n = -1;
            }
            if (!fndz.isShiftKeyDown()) {
                n *= 7;
            }
            this.mc._J.getChatGUI()._b(n);
        }
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        URI uRI;
        wots wots2;
        if (n3 == 0 && this.mc._M.chatLinks && (wots2 = this.mc._J.getChatGUI()._a(Mouse.getX(), Mouse.getY())) != null && (uRI = wots2._b()) != null) {
            if (this.mc._M.chatLinksPrompt) {
                this._g = uRI;
                this.mc._a(new GuiConfirmOpenLink((GuiScreen)this, wots2._a(), 0, false));
            } else {
                this._a(uRI);
            }
            return;
        }
        this._h.mouseClicked(n, n2, n3);
        super.mouseClicked(n, n2, n3);
    }

    @Override
    public void confirmClicked(boolean bl, int n) {
        if (n == 0) {
            if (bl) {
                this._a(this._g);
            }
            this._g = null;
            this.mc._a(this);
        }
    }

    public void _a(URI uRI) {
        try {
            Class<?> clazz = Class.forName("java.awt.Desktop");
            Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
            clazz.getMethod("browse", URI.class).invoke(object, uRI);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void _a() {
        if (this._c) {
            this._h.deleteFromCursor(this._h.func_73798_a(-1, this._h.getCursorPosition(), false) - this._h.getCursorPosition());
            if (this._e >= this._f.size()) {
                this._e = 0;
            }
        } else {
            int n = this._h.func_73798_a(-1, this._h.getCursorPosition(), false);
            this._f.clear();
            this._e = 0;
            String string = this._h.getText().substring(n).toLowerCase();
            String string2 = this._h.getText().substring(0, this._h.getCursorPosition());
            this._a(string2, string);
            if (this._f.isEmpty()) {
                return;
            }
            this._c = true;
            this._h.deleteFromCursor(n - this._h.getCursorPosition());
        }
        if (this._f.size() > 1) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String string2 : this._f) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(string2);
            }
            this.mc._J.getChatGUI()._a(stringBuilder.toString(), 1);
        }
        this._h.writeText(EnumChatFormatting._a((String)this._f.get(this._e++)));
    }

    public void _a(String string, String string2) {
        if (string.length() >= 1) {
            ClientCommandHandler.instance.autoComplete(string, string2);
            this.mc._t.sendQueue._b(new Packet203AutoComplete(string));
            this._d = true;
        }
    }

    public void _a(int n) {
        int n2 = this._b + n;
        int n3 = this.mc._J.getChatGUI()._c().size();
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 > n3) {
            n2 = n3;
        }
        if (n2 != this._b) {
            if (n2 == n3) {
                this._b = n3;
                this._h.setText(this._a);
            } else {
                if (this._b == n3) {
                    this._a = this._h.getText();
                }
                this._h.setText((String)this.mc._J.getChatGUI()._c().get(n2));
                this._b = n2;
            }
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        fndz.drawRect(2, this.height - 14, this.width - 2, this.height - 2, Integer.MIN_VALUE);
        this._h.drawTextBox();
        super.drawScreen(n, n2, f);
    }

    public void _a(String[] stringArray) {
        if (this._d) {
            this._f.clear();
            String[] stringArray2 = stringArray;
            int n = stringArray.length;
            String[] stringArray3 = ClientCommandHandler.instance.latestAutoComplete;
            if (stringArray3 != null) {
                stringArray2 = ObjectArrays.concat(stringArray3, stringArray2, String.class);
                n = stringArray2.length;
            }
            for (int i = 0; i < n; ++i) {
                String string = stringArray2[i];
                if (string.length() <= 0) continue;
                this._f.add(string);
            }
            if (this._f.size() > 0) {
                this._c = true;
                this._a();
            }
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}

