/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ListenerList;

@Cancelable
public class CommandEvent
extends Event {
    public final ICommand command;
    public final ICommandSender sender;
    public String[] parameters;
    public Throwable exception;
    private static ListenerList LISTENER_LIST;

    public CommandEvent(ICommand iCommand, ICommandSender iCommandSender, String[] stringArray) {
        this.command = iCommand;
        this.sender = iCommandSender;
        this.parameters = stringArray;
    }

    public CommandEvent() {
    }

    @Override
    protected void setup() {
        super.setup();
        if (LISTENER_LIST != null) {
            return;
        }
        LISTENER_LIST = new ListenerList(super.getListenerList());
    }

    @Override
    public ListenerList getListenerList() {
        return LISTENER_LIST;
    }
}

