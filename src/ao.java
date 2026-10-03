/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ad
 *  nb
 */
public class ao
extends z {
    public String c() {
        return "kill";
    }

    @Override
    public int a() {
        return 0;
    }

    public String c(ad par1ICommandSender) {
        return "commands.kill.usage";
    }

    public void b(ad par1ICommandSender, String[] par2ArrayOfStr) {
        jv entityplayermp = ao.b(par1ICommandSender);
        entityplayermp.a(nb.i, Float.MAX_VALUE);
        par1ICommandSender.a(cv.e("commands.kill.success"));
    }
}

