/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.paintinggui.gui;

import com.mcf.davidee.guilib.basic.BasicScreen;
import com.mcf.davidee.guilib.basic.Label;
import com.mcf.davidee.guilib.core.Button;
import com.mcf.davidee.guilib.core.Container;
import com.mcf.davidee.guilib.core.Scrollbar;
import com.mcf.davidee.guilib.core.Widget;
import com.mcf.davidee.guilib.vanilla.ButtonVanilla;
import com.mcf.davidee.guilib.vanilla.ScrollbarVanilla;
import com.mcf.davidee.paintinggui.PaintingSelectionMod;
import com.mcf.davidee.paintinggui.gui.PaintingButton;
import cpw.mods.fml.common.network.PacketDispatcher;
import java.util.ArrayList;
import net.minecraft.util.ugqi;

public class PaintingSelectionScreen
extends BasicScreen
implements Button.ButtonHandler {
    private Container container;
    private Container paintingContainer;
    private Scrollbar scrollbar;
    private Label title;
    private Button back;
    private PaintingButton[] buttons;
    private final int paintingID;
    private final String[] art;

    public PaintingSelectionScreen(String[] stringArray, int n) {
        super(null);
        this.art = stringArray;
        this.paintingID = n;
    }

    @Override
    protected void reopenedGui() {
    }

    @Override
    public void drawBackground() {
        super.drawBackground();
        PaintingSelectionScreen.func_73734_a(this.paintingContainer.left(), this.paintingContainer.top(), this.paintingContainer.right() - 10, this.paintingContainer.bottom(), 0x44444444);
    }

    @Override
    protected void unhandledKeyTyped(char c, int n) {
        if (n == 1) {
            this.close();
        }
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        if (this.field_73882_e._t == null || !this.field_73882_e._t.func_70089_S()) {
            this.close();
        }
    }

    @Override
    protected void revalidateGui() {
        int n = 10;
        int n2 = 30;
        int n3 = this.field_73880_f - 10;
        int n4 = 5;
        this.title.setPosition(this.field_73880_f / 2, 10);
        this.back.setPosition(this.field_73880_f / 2 - 100, this.field_73881_g - 25);
        this.scrollbar.setPosition(this.field_73880_f - 10, 28);
        int n5 = 10;
        int n6 = 30;
        int n7 = this.buttons[0].getHeight();
        int n8 = 0;
        for (int i = 0; i < this.buttons.length; ++i) {
            PaintingButton paintingButton = this.buttons[i];
            if (n5 + paintingButton.getWidth() > n3 || n7 > paintingButton.getHeight()) {
                this.centerRow(n8, i - 1);
                n8 = i;
                n5 = 10;
                n6 += 5 + n7;
                n7 = paintingButton.getHeight();
            }
            paintingButton.setPosition(n5, n6);
            n5 += paintingButton.getWidth() + 5;
        }
        this.centerRow(n8, this.buttons.length - 1);
        this.paintingContainer.revalidate(10, 28, this.field_73880_f - 10, this.field_73881_g - 55);
        this.container.revalidate(0, 0, this.field_73880_f, this.field_73881_g);
    }

    private void centerRow(int n, int n2) {
        int n3 = this.buttons[n].getX();
        int n4 = this.buttons[n2].getX() + this.buttons[n2].getWidth();
        int n5 = (this.field_73880_f - 20 - (n4 - n3)) / 2;
        for (int i = n; i <= n2; ++i) {
            this.buttons[i].shiftX(n5);
        }
    }

    @Override
    protected void createGui() {
        this.scrollbar = new ScrollbarVanilla(10);
        this.paintingContainer = new Container(this.scrollbar, 0, 4);
        this.container = new Container();
        this.title = new Label("Select a Painting", new Widget[0]);
        this.back = new ButtonVanilla("Cancel", new BasicScreen.CloseHandler(this));
        ugqi[] ugqiArray = ugqi.values();
        ArrayList<ugqi> arrayList = new ArrayList<ugqi>();
        String[] objectArray = this.art;
        int n = objectArray.length;
        block0: for (int i = 0; i < n; ++i) {
            String string = objectArray[i];
            for (ugqi ugqi2 : ugqiArray) {
                if (!ugqi2.__aK.equals(string)) continue;
                arrayList.add(ugqi2);
                continue block0;
            }
        }
        ugqi[] ugqiArray2 = arrayList.toArray(new ugqi[0]);
        this.buttons = new PaintingButton[ugqiArray2.length];
        for (n = 0; n < ugqiArray2.length; ++n) {
            this.buttons[n] = new PaintingButton(ugqiArray2[n], this);
        }
        this.container.addWidgets(this.title, this.back);
        this.paintingContainer.addWidgets(this.buttons);
        this.containers.add(this.paintingContainer);
        this.containers.add(this.container);
        this.selectedContainer = this.paintingContainer;
    }

    @Override
    public void buttonClicked(Button button) {
        String string = ((PaintingButton)button).art.__aK;
        jjqf jjqf2 = PaintingSelectionMod.createPacket(this.paintingID, new String[]{string});
        if (jjqf2 != null) {
            PacketDispatcher.sendPacketToServer(jjqf2);
        }
        this.field_73882_e._a((gqjz)null);
    }
}

