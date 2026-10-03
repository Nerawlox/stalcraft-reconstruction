/*
 * Decompiled with CFR 0.152.
 */
package mods.chat;

import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.MicroTransformer;

public class ChatMicrotransformer
extends MicroTransformer {
    @Override
    public void registerHooks() {
        HookLoader.registerHookContainer("mods.chat.ChatHooks");
    }
}

