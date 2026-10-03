/*
 * Decompiled with CFR 0.152.
 */
import java.util.Scanner;

public class roup
extends Thread {
    private final vkai _a;

    public roup(vkai vkai2) {
        this._a = vkai2;
        this.setName("Read Command Thread");
        this.setDaemon(true);
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            if (string == null || string.isEmpty()) continue;
            this._a._f.add(string);
        }
    }
}

