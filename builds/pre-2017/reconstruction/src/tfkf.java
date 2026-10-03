/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import org.lwjgl.input.Keyboard;

public class tfkf
extends GuiScreen {
    public static RenderItem _a = new RenderItem();
    public static final List _b = new ArrayList();
    public final stik _c;
    public String _d;
    public String _e;
    public String _f;
    public mavq _g;
    public GuiButton _h;
    public GuiTextField _i;

    public tfkf(stik stik2) {
        this._c = stik2;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        this._d = wpcz._a("createWorld.customize.presets.title");
        this._e = wpcz._a("createWorld.customize.presets.share");
        this._f = wpcz._a("createWorld.customize.presets.list");
        this._i = new GuiTextField(this.fontRenderer, 50, 40, this.width - 100, 20);
        this._g = new mavq(this);
        this._i.setMaxStringLength(1230);
        this._i.setText(this._c._a());
        this._h = new GuiButton(0, this.width / 2 - 155, this.height - 28, 150, 20, wpcz._a("createWorld.customize.presets.select"));
        this.buttonList.add(this._h);
        this.buttonList.add(new GuiButton(1, this.width / 2 + 5, this.height - 28, 150, 20, wpcz._a("gui.cancel")));
        this._a();
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        this._i.mouseClicked(n, n2, n3);
        super.mouseClicked(n, n2, n3);
    }

    @Override
    public void keyTyped(char c, int n) {
        if (!this._i.textboxKeyTyped(c, n)) {
            super.keyTyped(c, n);
        }
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0 && this._b()) {
            this._c._a(this._i.getText());
            this.mc._a(this._c);
        } else if (guiButton.id == 1) {
            this.mc._a(this._c);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this._g.drawScreen(n, n2, f);
        this.drawCenteredString(this.fontRenderer, this._d, this.width / 2, 8, 0xFFFFFF);
        this.drawString(this.fontRenderer, this._e, 50, 30, 0xA0A0A0);
        this.drawString(this.fontRenderer, this._f, 50, 70, 0xA0A0A0);
        this._i.drawTextBox();
        super.drawScreen(n, n2, f);
    }

    @Override
    public void updateScreen() {
        this._i.updateCursorCounter();
        super.updateScreen();
    }

    public void _a() {
        boolean bl;
        this._h.enabled = bl = this._b();
    }

    public boolean _b() {
        return this._g._a > -1 && this._g._a < _b.size() || this._i.getText().length() > 1;
    }

    public static void _a(String string, int n, BiomeGenBase biomeGenBase, suyo ... suyoArray) {
        tfkf._a(string, n, biomeGenBase, null, suyoArray);
    }

    public static void _a(String string, int n, BiomeGenBase biomeGenBase, List list2, suyo ... suyoArray) {
        elpk elpk2 = new elpk();
        for (int i = suyoArray.length - 1; i >= 0; --i) {
            elpk2._c().add(suyoArray[i]);
        }
        elpk2._a(biomeGenBase._P);
        elpk2._d();
        if (list2 != null) {
            for (String string2 : list2) {
                elpk2._b().put(string2, new HashMap());
            }
        }
        _b.add(new htjk(n, string, elpk2.toString()));
    }

    public static /* synthetic */ RenderItem _c() {
        return _a;
    }

    public static /* synthetic */ List _d() {
        return _b;
    }

    public static /* synthetic */ mavq _a(tfkf tfkf2) {
        return tfkf2._g;
    }

    public static /* synthetic */ GuiTextField _b(tfkf tfkf2) {
        return tfkf2._i;
    }

    static {
        tfkf._a("Classic Flat", Block.grass.blockID, BiomeGenBase._c, Arrays.asList("village"), new suyo(1, Block.grass.blockID), new suyo(2, Block.dirt.blockID), new suyo(1, Block.bedrock.blockID));
        tfkf._a("Tunnelers' Dream", Block.stone.blockID, BiomeGenBase._e, Arrays.asList("biome_1", "dungeon", "decoration", "stronghold", "mineshaft"), new suyo(1, Block.grass.blockID), new suyo(5, Block.dirt.blockID), new suyo(230, Block.stone.blockID), new suyo(1, Block.bedrock.blockID));
        tfkf._a("Water World", Block.waterMoving.blockID, BiomeGenBase._c, Arrays.asList("village", "biome_1"), new suyo(90, Block.waterStill.blockID), new suyo(5, Block.sand.blockID), new suyo(5, Block.dirt.blockID), new suyo(5, Block.stone.blockID), new suyo(1, Block.bedrock.blockID));
        tfkf._a("Overworld", Block.tallGrass.blockID, BiomeGenBase._c, Arrays.asList("village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon", "lake", "lava_lake"), new suyo(1, Block.grass.blockID), new suyo(3, Block.dirt.blockID), new suyo(59, Block.stone.blockID), new suyo(1, Block.bedrock.blockID));
        tfkf._a("Snowy Kingdom", Block.snow.blockID, BiomeGenBase._n, Arrays.asList("village", "biome_1"), new suyo(1, Block.snow.blockID), new suyo(1, Block.grass.blockID), new suyo(3, Block.dirt.blockID), new suyo(59, Block.stone.blockID), new suyo(1, Block.bedrock.blockID));
        tfkf._a("Bottomless Pit", Item.feather.itemID, BiomeGenBase._c, Arrays.asList("village", "biome_1"), new suyo(1, Block.grass.blockID), new suyo(3, Block.dirt.blockID), new suyo(2, Block.cobblestone.blockID));
        tfkf._a("Desert", Block.sand.blockID, BiomeGenBase._d, Arrays.asList("village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon"), new suyo(8, Block.sand.blockID), new suyo(52, Block.sandStone.blockID), new suyo(3, Block.stone.blockID), new suyo(1, Block.bedrock.blockID));
        tfkf._a("Redstone Ready", Item.redstone.itemID, BiomeGenBase._d, new suyo(52, Block.sandStone.blockID), new suyo(3, Block.stone.blockID), new suyo(1, Block.bedrock.blockID));
    }
}

