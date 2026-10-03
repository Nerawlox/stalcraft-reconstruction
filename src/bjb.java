/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asn
 *  beu
 *  bje
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class bjb
extends bje {
    private static final bjo c = new bjo("textures/entity/skeleton/skeleton.png");
    private static final bjo d = new bjo("textures/entity/skeleton/wither_skeleton.png");
    private static final bjo e = new bjo("textures/entity/zombie/zombie.png");
    private static final bjo f = new bjo("textures/entity/creeper/creeper.png");
    public static bjb a;
    private bby g = new bby(0, 0, 64, 32);
    private bby h = new bby(0, 0, 64, 64);

    public void a(asn par1TileEntitySkull, double par2, double par4, double par6, float par8) {
        this.a((float)par2, (float)par4, (float)par6, par1TileEntitySkull.p() & 7, (float)(par1TileEntitySkull.b() * 360) / 16.0f, par1TileEntitySkull.a(), par1TileEntitySkull.c());
    }

    public void a(bjd par1TileEntityRenderer) {
        super.a(par1TileEntityRenderer);
        a = this;
    }

    public void a(float par1, float par2, float par3, int par4, float par5, int par6, String par7Str) {
        bby modelskeletonhead = this.g;
        switch (par6) {
            default: {
                this.a(c);
                break;
            }
            case 1: {
                this.a(d);
                break;
            }
            case 2: {
                this.a(e);
                modelskeletonhead = this.h;
                break;
            }
            case 3: {
                bjo resourcelocation = beu.b;
                if (par7Str != null && par7Str.length() > 0) {
                    resourcelocation = beu.h((String)par7Str);
                    beu.a((bjo)resourcelocation, (String)par7Str);
                }
                this.a(resourcelocation);
                break;
            }
            case 4: {
                this.a(f);
            }
        }
        GL11.glPushMatrix();
        GL11.glDisable((int)2884);
        if (par4 != 1) {
            switch (par4) {
                case 2: {
                    GL11.glTranslatef((float)(par1 + 0.5f), (float)(par2 + 0.25f), (float)(par3 + 0.74f));
                    break;
                }
                case 3: {
                    GL11.glTranslatef((float)(par1 + 0.5f), (float)(par2 + 0.25f), (float)(par3 + 0.26f));
                    par5 = 180.0f;
                    break;
                }
                case 4: {
                    GL11.glTranslatef((float)(par1 + 0.74f), (float)(par2 + 0.25f), (float)(par3 + 0.5f));
                    par5 = 270.0f;
                    break;
                }
                default: {
                    GL11.glTranslatef((float)(par1 + 0.26f), (float)(par2 + 0.25f), (float)(par3 + 0.5f));
                    par5 = 90.0f;
                    break;
                }
            }
        } else {
            GL11.glTranslatef((float)(par1 + 0.5f), (float)par2, (float)(par3 + 0.5f));
        }
        float f4 = 0.0625f;
        GL11.glEnable((int)32826);
        GL11.glScalef((float)-1.0f, (float)-1.0f, (float)1.0f);
        GL11.glEnable((int)3008);
        modelskeletonhead.a(null, 0.0f, 0.0f, 0.0f, par5, 0.0f, f4);
        GL11.glPopMatrix();
    }

    public void a(asp par1TileEntity, double par2, double par4, double par6, float par8) {
        this.a((asn)par1TileEntity, par2, par4, par6, par8);
    }
}

