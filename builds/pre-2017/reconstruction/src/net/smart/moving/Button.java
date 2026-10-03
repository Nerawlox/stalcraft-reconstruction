/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.KeyBinding;
import net.smart.moving.SmartMovingContext;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Button
extends SmartMovingContext {
    public boolean Pressed;
    public boolean WasPressed;
    public boolean StartPressed;
    public boolean StopPressed;

    public void update(KeyBinding keyBinding) {
        this.update(Minecraft._E().__ab && Button.isKeyDown(keyBinding));
    }

    public void update(int n) {
        this.update(Minecraft._E().__ab && Button.isKeyDown(n));
    }

    public void update(boolean bl) {
        this.WasPressed = this.Pressed;
        this.Pressed = bl;
        this.StartPressed = !this.WasPressed && this.Pressed;
        this.StopPressed = this.WasPressed && !this.Pressed;
    }

    private static boolean isKeyDown(KeyBinding keyBinding) {
        return Button.isKeyDown(keyBinding, keyBinding._e);
    }

    private static boolean isKeyDown(KeyBinding keyBinding, boolean bl) {
        GuiScreen guiScreen = Minecraft._E()._B;
        return guiScreen != null && !guiScreen.allowUserInput ? bl : Button.isKeyDown(keyBinding._d);
    }

    private static boolean isKeyDown(int n) {
        return n >= 0 ? Keyboard.isKeyDown(n) : Mouse.isButtonDown(n + 100);
    }
}

