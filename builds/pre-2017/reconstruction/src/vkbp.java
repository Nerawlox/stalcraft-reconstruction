/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.lwjgl.util.vector.Vector;
import org.lwjgl.util.vector.Vector2f;

public class vkbp
extends iekw {
    public flwn _a;
    private int _b;
    private static final float _c = 0.2f;
    private static final float _d = 0.07f;
    private List<kjui> _e = new ArrayList<kjui>();

    public vkbp(flwn flwn2) {
        super(flwn2.worldObj, flwn2);
        this._a = flwn2;
        this.setCenter((double)this._a.xCoord + 0.5, (float)this._a.yCoord + 0.25f, (double)this._a.zCoord + 0.5);
        this.setSize(5.0, 1.0, 5.0);
    }

    @Override
    public void tick() {
        Object object;
        Object object2;
        super.tick();
        Random random = this.world.rand;
        for (int i = 0; i < 15; ++i) {
            object2 = dwpk._c[random.nextInt(dwpk._c.length)];
            dwpy dwpy2 = new dwpy(this, (ejcz)object2);
            dwpy2._a = random.nextInt(3) + 18;
            dwpy2.setCollisionSize(0.6f);
            dwpy2.textureSize = 0.35f;
            dwpy2._b = 1.04f;
            object = new Vector2f(random.nextFloat() - 0.5f, random.nextFloat() - 0.5f);
            ((Vector)object).normalise();
            float f = random.nextFloat() * 0.1f;
            dwpy2.setPosition(this.centerX + (double)(((Vector2f)object).x * f), this.centerY - 0.25 + (double)(random.nextFloat() * 0.2f), this.centerZ + (double)(((Vector2f)object).y * f));
            dwpy2.motionY = 0.2f * (random.nextFloat() * 0.2f + 0.8f);
            dwpy2.move(0.0, dwpy2.motionY, 0.0);
            this.particles.add(dwpy2);
        }
        if (--this._b <= 0) {
            this._b = 8;
            zfml zfml2 = new zfml(this, dwpk._q);
            object2 = new Vector2f(random.nextFloat() - 0.5f, random.nextFloat() - 0.5f);
            ((Vector)object2).normalise();
            float f = random.nextFloat() * 0.3f;
            zfml2.setPosition(this.centerX + (double)(((Vector2f)object2).x * f), this.centerY - 1.0, this.centerZ + (double)(((Vector2f)object2).y * f));
            zfml2.motionY = 0.07f;
            zfml2._a = 75 + this.world.rand.nextInt(15);
            this.particles.add(zfml2);
        }
        Iterator<kjui> iterator2 = this._e.iterator();
        while (iterator2.hasNext()) {
            if (++iterator2.next()._a <= 10) continue;
            iterator2.remove();
        }
        for (Map.Entry entry : this._a._c.entrySet()) {
            object = new kjui();
            ((kjui)object)._b = ((flwn.kjui)entry.getValue())._c;
            ((kjui)object)._c = this.centerY;
            ((kjui)object)._d = ((flwn.kjui)entry.getValue())._d;
            this._e.add((kjui)object);
        }
        for (kjui kjui2 : this._e) {
            Object object3;
            if (kjui2._a < 4) {
                for (int i = 0; i < 10; ++i) {
                    object3 = dwpk._c[random.nextInt(dwpk._c.length)];
                    dwpy dwpy3 = new dwpy(this, (ejcz)object3);
                    dwpy3._a = random.nextInt(2) + 8;
                    dwpy3.setCollisionSize(0.6f);
                    dwpy3.textureSize = 0.35f;
                    dwpy3._b = 1.03f;
                    Vector2f vector2f = new Vector2f(random.nextFloat() - 0.5f, random.nextFloat() - 0.5f);
                    vector2f.normalise();
                    float f = random.nextFloat() * 0.1f;
                    dwpy3.setPosition(kjui2._b + (double)(vector2f.x * f), kjui2._c - 0.25 + (double)(random.nextFloat() * 0.2f), kjui2._d + (double)(vector2f.y * f));
                    dwpy3.motionY = 0.2f * (random.nextFloat() * 0.2f + 0.8f);
                    dwpy3.move(0.0, dwpy3.motionY, 0.0);
                    this.particles.add(dwpy3);
                }
            }
            if (kjui2._a % 3 != 1) continue;
            this._b = 8;
            zfml zfml3 = new zfml(this, dwpk._q);
            object3 = new Vector2f(random.nextFloat() - 0.5f, random.nextFloat() - 0.5f);
            ((Vector)object3).normalise();
            float f = random.nextFloat() * 0.3f;
            zfml3.setPosition(kjui2._b + (double)(((Vector2f)object3).x * f), kjui2._c - 0.5, kjui2._d + (double)(((Vector2f)object3).y * f));
            zfml3.motionY = 0.07f;
            zfml3._a = 20 + this.world.rand.nextInt(5);
            this.particles.add(zfml3);
        }
    }

    private static class kjui {
        public int _a;
        public double _b;
        public double _c;
        public double _d;

        private kjui() {
        }
    }
}

