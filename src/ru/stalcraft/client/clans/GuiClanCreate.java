/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  bjo
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.clans;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import ru.stalcraft.client.network.ClientPacketSender;

public class GuiClanCreate
extends awe {
    private static final bjo texture = new bjo("stalker", "textures/clans/create.png");
    private avf input;
    private aut button;

    @Override
    public void A_() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.button = new aut(0, this.g / 2 - 68, this.h / 2 + 17, 66, 20, "\u0421\u043e\u0437\u0434\u0430\u0442\u044c");
        this.i.add(this.button);
        this.i.add(new aut(1, this.g / 2 + 2, this.h / 2 + 17, 66, 20, "\u041e\u0442\u043c\u0435\u043d\u0430"));
        this.input = new avf(this.o, this.g / 2 - 37, this.h / 2 - 7, 74, 14);
        this.input.f(16);
        this.input.b(true);
    }

    @Override
    public void a(int x2, int y2, float frame) {
        this.b(0);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)2896);
        String name = this.input.b();
        atv.w().N.a(texture);
        this.b(this.g / 2 - 78, this.h / 2 - 45, 0, 0, 156, 90);
        this.input.f();
        if (!this.button.h) {
            this.a(this.o, "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0434\u043e\u0436\u043d\u043e \u0431\u044b\u0442\u044c \u0434\u043b\u0438\u043d\u043e\u0439 \u043e\u0442 4 \u0434\u043e 16 \u0441\u0438\u043c\u0432\u043e\u043b\u043e\u0432,", this.g / 2, this.h / 2 - 85, 0xFFFFFF);
            this.a(this.o, "\u0441\u043e\u0441\u0442\u043e\u044f\u0442\u044c \u0446\u0435\u043b\u0438\u043a\u043e\u043c \u0438\u0437 \u0440\u0443\u0441\u0441\u043a\u0438\u0445 \u043b\u0438\u0431\u043e \u0430\u043d\u0433\u043b\u0438\u0439\u0441\u043a\u0438\u0445", this.g / 2, this.h / 2 - 75, 0xFFFFFF);
            this.a(this.o, "\u0431\u0443\u043a\u0432, \u0442\u0430\u043a\u0436\u0435 \u0434\u043e\u043f\u0443\u0441\u043a\u0430\u044e\u0442\u0441\u044f \u043f\u0440\u043e\u0431\u0435\u043b\u044b.", this.g / 2, this.h / 2 - 65, 0xFFFFFF);
        }
        this.a(this.o, "\u0423\u043a\u0430\u0436\u0438\u0442\u0435 \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435:", this.g / 2, this.h / 2 - 18, 0xFFFFFF);
        super.a(x2, y2, frame);
    }

    @Override
    protected void a(aut btn) {
        if (btn.g == 1) {
            atv.w().a((awe)null);
        } else {
            ClientPacketSender.sendClanCreateRequest(this.input.b().trim());
        }
    }

    @Override
    public void c() {
        String name = this.input.b().trim();
        this.button.h = GuiClanCreate.isNameCorrect(name);
        this.input.a();
    }

    private static boolean isNameCorrect(String name) {
        return (name = name.trim()).length() >= 4 && name.length() <= 16 && (name.matches("[a-zA-Z\\s]*") || name.matches("[\u0430-\u044f\u0410-\u042f\\s]*"));
    }

    @Override
    public void b() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    @Override
    protected void a(char par1, int par2) {
        super.a(par1, par2);
        String name = this.input.b().trim();
        boolean enabled = GuiClanCreate.isNameCorrect(name);
        if (par2 == 28 && enabled) {
            ClientPacketSender.sendClanCreateRequest(name);
        }
        this.input.a(par1, par2);
    }

    @Override
    protected void a(int par1, int par2, int par3) {
        super.a(par1, par2, par3);
        this.input.a(par1, par2, par3);
    }

    @Override
    public boolean f() {
        return false;
    }
}

