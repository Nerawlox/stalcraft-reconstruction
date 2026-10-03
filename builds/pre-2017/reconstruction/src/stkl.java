/*
 * Decompiled with CFR 0.152.
 */
import mcoptifine.GuiAnimationSettingsOF;
import mcoptifine.GuiDetailSettingsOF;
import mcoptifine.GuiOtherSettingsOF;
import mcoptifine.GuiPerformanceSettingsOF;
import mcoptifine.GuiQualitySettingsOF;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;

public class stkl
extends GuiScreen {
    public GuiScreen _a;
    public String _b = "Video Settings";
    public GameSettings _c;
    public boolean _d;
    public static EnumOptions[] _e = new EnumOptions[]{EnumOptions._m, EnumOptions.__aJ, EnumOptions._n, EnumOptions.__aN, EnumOptions._X, EnumOptions._h, EnumOptions._o, EnumOptions._j, EnumOptions._f, EnumOptions.__aM, EnumOptions._G, EnumOptions._H, EnumOptions._w};
    public int _f = 0;
    public int _g = 0;
    public long _h = 0L;

    public stkl(GuiScreen guiScreen, GameSettings gameSettings) {
        this._a = guiScreen;
        this._c = gameSettings;
    }

    @Override
    public void initGui() {
        int n;
        int n2;
        int n3;
        EnumOptions[] enumOptionsArray;
        int n4;
        String[] stringArray;
        this._b = wpcz._a("options.videoTitle");
        this.buttonList.clear();
        this._d = false;
        String[] stringArray2 = stringArray = new String[]{"sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch"};
        int n5 = stringArray.length;
        for (n4 = 0; n4 < n5; ++n4) {
            String string = stringArray2[n4];
            enumOptionsArray = System.getProperty(string);
            if (enumOptionsArray == null || !enumOptionsArray.contains("64")) continue;
            this._d = true;
            break;
        }
        n4 = 0;
        boolean bl = !this._d;
        enumOptionsArray = _e;
        int n6 = enumOptionsArray.length;
        boolean bl2 = false;
        for (n3 = 0; n3 < n6; ++n3) {
            EnumOptions enumOptions = enumOptionsArray[n3];
            n2 = this.width / 2 - 155 + n3 % 2 * 160;
            n = this.height / 6 + 21 * (n3 / 2) - 10;
            if (enumOptions._a()) {
                this.buttonList.add(new GuiSlider(enumOptions._c(), n2, n, enumOptions, this._c.getKeyBinding(enumOptions), this._c.getOptionFloatValue(enumOptions)));
                continue;
            }
            this.buttonList.add(new baxz(enumOptions._c(), n2, n, enumOptions, this._c.getKeyBinding(enumOptions)));
        }
        int n7 = this.height / 6 + 21 * (n3 / 2) - 10;
        n = 0;
        n2 = this.width / 2 - 155 + 160;
        this.buttonList.add(new baxz(102, n2, n7, "Quality..."));
        n2 = this.width / 2 - 155 + 0;
        this.buttonList.add(new baxz(101, n2, n7 += 21, "Details..."));
        n2 = this.width / 2 - 155 + 160;
        this.buttonList.add(new baxz(112, n2, n7, "Performance..."));
        n2 = this.width / 2 - 155 + 0;
        this.buttonList.add(new baxz(111, n2, n7 += 21, "Animations..."));
        n2 = this.width / 2 - 155 + 160;
        this.buttonList.add(new baxz(122, n2, n7, "Other..."));
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168 + 11, wpcz._a("gui.done")));
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.enabled) {
            Object object;
            int n = this._c.guiScale;
            if (guiButton.id < 100 && guiButton instanceof baxz) {
                this._c.setOptionValue(((baxz)guiButton).returnEnumOptions(), 1);
                guiButton.displayString = this._c.getKeyBinding(EnumOptions._a(guiButton.id));
            }
            if (guiButton.id == 200) {
                this.mc._M.saveOptions();
                this.mc._a(this._a);
            }
            if (this._c.guiScale != n) {
                object = new htou(this.mc._M, this.mc._n, this.mc._o);
                int n2 = ((htou)object)._a();
                int n3 = ((htou)object)._b();
                this.setWorldAndResolution(this.mc, n2, n3);
            }
            if (guiButton.id == 101) {
                this.mc._M.saveOptions();
                object = new GuiDetailSettingsOF(this, this._c);
                this.mc._a((GuiScreen)object);
            }
            if (guiButton.id == 102) {
                this.mc._M.saveOptions();
                object = new GuiQualitySettingsOF(this, this._c);
                this.mc._a((GuiScreen)object);
            }
            if (guiButton.id == 111) {
                this.mc._M.saveOptions();
                object = new GuiAnimationSettingsOF(this, this._c);
                this.mc._a((GuiScreen)object);
            }
            if (guiButton.id == 112) {
                this.mc._M.saveOptions();
                object = new GuiPerformanceSettingsOF(this, this._c);
                this.mc._a((GuiScreen)object);
            }
            if (guiButton.id == 122) {
                this.mc._M.saveOptions();
                object = new GuiOtherSettingsOF(this, this._c);
                this.mc._a((GuiScreen)object);
            }
            if (guiButton.id == EnumOptions._X.ordinal()) {
                return;
            }
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this._b, this.width / 2, this._d ? 20 : 5, 0xFFFFFF);
        super.drawScreen(n, n2, f);
        if (Math.abs(n - this._f) <= 5 && Math.abs(n2 - this._g) <= 5) {
            int n3 = 700;
            if (System.currentTimeMillis() >= this._h + (long)n3) {
                int n4 = this.width / 2 - 150;
                int n5 = this.height / 6 - 5;
                if (n2 <= n5 + 98) {
                    n5 += 105;
                }
                int n6 = n4 + 150 + 150;
                int n7 = n5 + 84 + 10;
                GuiButton guiButton = this._a(n, n2);
                if (guiButton != null) {
                    String string = this._b(guiButton.displayString);
                    String[] stringArray = this._a(string);
                    if (stringArray == null) {
                        return;
                    }
                    this.drawGradientRect(n4, n5, n6, n7, -536870912, -536870912);
                    for (int i = 0; i < stringArray.length; ++i) {
                        String string2 = stringArray[i];
                        this.fontRenderer._a(string2, n4 + 5, n5 + 5 + i * 11, 0xDDDDDD);
                    }
                }
            }
        } else {
            this._f = n;
            this._g = n2;
            this._h = System.currentTimeMillis();
        }
    }

    public String[] _a(String string) {
        String[] stringArray;
        if (string.equals("Graphics")) {
            String[] stringArray2 = new String[5];
            stringArray2[0] = "Visual quality";
            stringArray2[1] = "  Fast  - lower quality, faster";
            stringArray2[2] = "  Fancy - higher quality, slower";
            stringArray2[3] = "Changes the appearance of clouds, leaves, water,";
            stringArray = stringArray2;
            stringArray2[4] = "shadows and grass sides.";
        } else if (string.equals("Render Distance")) {
            String[] stringArray3 = new String[7];
            stringArray3[0] = "Visible distance";
            stringArray3[1] = "  Tiny - 32m (fastest)";
            stringArray3[2] = "  Short - 64m (faster)";
            stringArray3[3] = "  Normal - 128m";
            stringArray3[4] = "  Far - 256m (slower)";
            stringArray3[5] = "  Extreme - 512m (slowest!)";
            stringArray = stringArray3;
            stringArray3[6] = "The Extreme view distance is very resource demanding!";
        } else if (string.equals("Smooth Lighting")) {
            String[] stringArray4 = new String[4];
            stringArray4[0] = "Smooth lighting";
            stringArray4[1] = "  OFF - no smooth lighting (faster)";
            stringArray4[2] = "  1% - light smooth lighting (slower)";
            stringArray = stringArray4;
            stringArray4[3] = "  100% - dark smooth lighting (slower)";
        } else if (string.equals("Performance")) {
            String[] stringArray5 = new String[7];
            stringArray5[0] = "FPS Limit";
            stringArray5[1] = "  Max FPS - no limit (fastest)";
            stringArray5[2] = "  Balanced - limit 120 FPS (slower)";
            stringArray5[3] = "  Power saver - limit 40 FPS (slowest)";
            stringArray5[4] = "  VSync - limit to monitor framerate (60, 30, 20)";
            stringArray5[5] = "Balanced and Power saver decrease the FPS even if";
            stringArray = stringArray5;
            stringArray5[6] = "the limit value is not reached.";
        } else if (string.equals("3D Anaglyph")) {
            String[] stringArray6 = new String[1];
            stringArray = stringArray6;
            stringArray6[0] = "3D mode used with red-cyan 3D glasses.";
        } else if (string.equals("View Bobbing")) {
            String[] stringArray7 = new String[2];
            stringArray7[0] = "More realistic movement.";
            stringArray = stringArray7;
            stringArray7[1] = "When using mipmaps set it to OFF for best results.";
        } else if (string.equals("GUI Scale")) {
            String[] stringArray8 = new String[2];
            stringArray8[0] = "GUI Scale";
            stringArray = stringArray8;
            stringArray8[1] = "Smaller GUI might be faster";
        } else if (string.equals("Advanced OpenGL")) {
            String[] stringArray9 = new String[6];
            stringArray9[0] = "Detect and render only visible geometry";
            stringArray9[1] = "  OFF - all geometry is rendered (slower)";
            stringArray9[2] = "  Fast - only visible geometry is rendered (fastest)";
            stringArray9[3] = "  Fancy - conservative, avoids visual artifacts (faster)";
            stringArray9[4] = "The option is available only if it is supported by the ";
            stringArray = stringArray9;
            stringArray9[5] = "graphic card.";
        } else if (string.equals("Fog")) {
            String[] stringArray10 = new String[6];
            stringArray10[0] = "Fog type";
            stringArray10[1] = "  Fast - faster fog";
            stringArray10[2] = "  Fancy - slower fog, looks better";
            stringArray10[3] = "  OFF - no fog, fastest";
            stringArray10[4] = "The fancy fog is available only if it is supported by the ";
            stringArray = stringArray10;
            stringArray10[5] = "graphic card.";
        } else if (string.equals("Fog Start")) {
            String[] stringArray11 = new String[4];
            stringArray11[0] = "Fog start";
            stringArray11[1] = "  0.2 - the fog starts near the player";
            stringArray11[2] = "  0.8 - the fog starts far from the player";
            stringArray = stringArray11;
            stringArray11[3] = "This option usually does not affect the performance.";
        } else if (string.equals("Brightness")) {
            String[] stringArray12 = new String[5];
            stringArray12[0] = "Increases the brightness of darker objects";
            stringArray12[1] = "  OFF - standard brightness";
            stringArray12[2] = "  100% - maximum brightness for darker objects";
            stringArray12[3] = "This options does not change the brightness of ";
            stringArray = stringArray12;
            stringArray12[4] = "fully black objects";
        } else if (string.equals("Chunk Loading")) {
            String[] stringArray13 = new String[8];
            stringArray13[0] = "Chunk Loading";
            stringArray13[1] = "  Default - unstable FPS when loading chunks";
            stringArray13[2] = "  Smooth - stable FPS";
            stringArray13[3] = "  Multi-Core - stable FPS, 3x faster world loading";
            stringArray13[4] = "Smooth and Multi-Core remove the stuttering and freezes";
            stringArray13[5] = "caused by chunk loading.";
            stringArray13[6] = "Multi-Core can speed up 3x the world loading and";
            stringArray = stringArray13;
            stringArray13[7] = "increase FPS by using a second CPU core.";
        } else {
            stringArray = null;
        }
        return stringArray;
    }

    public String _b(String string) {
        int n = string.indexOf(58);
        return n < 0 ? string : string.substring(0, n);
    }

    public GuiButton _a(int n, int n2) {
        for (int i = 0; i < this.buttonList.size(); ++i) {
            boolean bl;
            GuiButton guiButton = (GuiButton)this.buttonList.get(i);
            boolean bl2 = bl = n >= guiButton.xPosition && n2 >= guiButton.yPosition && n < guiButton.xPosition + guiButton.width && n2 < guiButton.yPosition + guiButton.height;
            if (!bl) continue;
            return guiButton;
        }
        return null;
    }
}

