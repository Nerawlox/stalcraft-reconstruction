/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.commands;

import codechicken.core.commands.CoreCommand;

public abstract class ServerCommand
extends CoreCommand {
    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        this.handleCommand(stringArray, (dzfd)nemo2);
    }

    @Override
    public boolean func_71519_b(nemo nemo2) {
        if (!super.func_71519_b(nemo2)) {
            return false;
        }
        return nemo2 instanceof dzfd;
    }

    public abstract void handleCommand(String[] var1, dzfd var2);

    @Override
    public final boolean OPOnly() {
        return false;
    }
}

