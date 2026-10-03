/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import net.minecraft.client.settings.eidj;
import net.minecraft.client.xpzm;
import net.smart.moving.SmartMovingContext;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Button
extends SmartMovingContext {
    public boolean Pressed;
    public boolean WasPressed;
    public boolean StartPressed;
    public boolean StopPressed;

    public void update(eidj eidj2) {
        this.update(xpzm._E().__ab && Button.isKeyDown(eidj2));
    }

    public void update(int n) {
        this.update(xpzm._E().__ab && Button.isKeyDown(n));
    }

    public void update(boolean bl) {
        this.WasPressed = this.Pressed;
        this.Pressed = bl;
        this.StartPressed = !this.WasPressed && this.Pressed;
        this.StopPressed = this.WasPressed && !this.Pressed;
    }

    private static boolean isKeyDown(eidj eidj2) {
        return Button.isKeyDown(eidj2, eidj2._e);
    }

    private static boolean isKeyDown(eidj eidj2, boolean bl) {
        gqjz gqjz2 = xpzm._E()._B;
        return gqjz2 != null && !gqjz2.field_73885_j ? bl : Button.isKeyDown(eidj2._d);
    }

    private static boolean isKeyDown(int n) {
        return n >= 0 ? Keyboard.isKeyDown(n) : Mouse.isButtonDown(n + 100);
    }
}

