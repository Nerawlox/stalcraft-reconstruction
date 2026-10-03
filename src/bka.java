/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bib
 *  bim
 *  bjo
 *  bjr
 *  bjt
 *  bku
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.util.List;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
class bka
extends awg {
    private final bjt b;
    private bjo h;
    final bjz a;

    public bka(bjz par1GuiScreenTemporaryResourcePackSelect, bjt par2ResourcePackRepository) {
        super(bjz.a(par1GuiScreenTemporaryResourcePackSelect), par1GuiScreenTemporaryResourcePackSelect.g, par1GuiScreenTemporaryResourcePackSelect.h, 32, par1GuiScreenTemporaryResourcePackSelect.h - 55 + 4, 36);
        this.a = par1GuiScreenTemporaryResourcePackSelect;
        this.b = par2ResourcePackRepository;
        par2ResourcePackRepository.a();
    }

    @Override
    protected int a() {
        return 1 + this.b.b().size();
    }

    @Override
    protected void a(int par1, boolean par2) {
        List list = this.b.b();
        try {
            if (par1 == 0) {
                throw new RuntimeException("This is so horrible ;D");
            }
            this.b.a(new bjv[]{(bjv)list.get(par1 - 1)});
            bjz.b(this.a).a();
        }
        catch (Exception exception) {
            this.b.a(new bjv[0]);
            bjz.c(this.a).a();
        }
        bjz.d((bjz)this.a).u.m = this.b.d();
        bjz.e((bjz)this.a).u.b();
    }

    @Override
    protected boolean a(int par1) {
        List list = this.b.c();
        return par1 == 0 ? list.isEmpty() : list.contains(this.b.b().get(par1 - 1));
    }

    @Override
    protected int d() {
        return this.a() * 36;
    }

    @Override
    protected void b() {
        this.a.e();
    }

    @Override
    protected void a(int par1, int par2, int par3, int par4, bfq par5Tessellator) {
        bim texturemanager = bjz.f(this.a).J();
        if (par1 == 0) {
            try {
                bjr resourcepack = this.b.b;
                bku packmetadatasection = (bku)resourcepack.a(this.b.c, "pack");
                if (this.h == null) {
                    this.h = texturemanager.a("texturepackicon", new bib(resourcepack.a()));
                }
                texturemanager.a(this.h);
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                par5Tessellator.b();
                par5Tessellator.d(0xFFFFFF);
                par5Tessellator.a(par2, par3 + par4, 0.0, 0.0, 1.0);
                par5Tessellator.a(par2 + 32, par3 + par4, 0.0, 1.0, 1.0);
                par5Tessellator.a(par2 + 32, par3, 0.0, 1.0, 0.0);
                par5Tessellator.a(par2, par3, 0.0, 0.0, 0.0);
                par5Tessellator.a();
                this.a.b(bjz.g(this.a), "Default", par2 + 32 + 2, par3 + 1, 0xFFFFFF);
                this.a.b(bjz.h(this.a), packmetadatasection.a(), par2 + 32 + 2, par3 + 12 + 10, 0x808080);
            }
            catch (IOException resourcepack) {}
        } else {
            bjv resourcepackrepositoryentry = (bjv)this.b.b().get(par1 - 1);
            resourcepackrepositoryentry.a(texturemanager);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            par5Tessellator.b();
            par5Tessellator.d(0xFFFFFF);
            par5Tessellator.a(par2, par3 + par4, 0.0, 0.0, 1.0);
            par5Tessellator.a(par2 + 32, par3 + par4, 0.0, 1.0, 1.0);
            par5Tessellator.a(par2 + 32, par3, 0.0, 1.0, 0.0);
            par5Tessellator.a(par2, par3, 0.0, 0.0, 0.0);
            par5Tessellator.a();
            String s2 = resourcepackrepositoryentry.d();
            if (s2.length() > 32) {
                s2 = s2.substring(0, 32).trim() + "...";
            }
            this.a.b(bjz.i(this.a), s2, par2 + 32 + 2, par3 + 1, 0xFFFFFF);
            List list = bjz.j(this.a).c(resourcepackrepositoryentry.e(), 183);
            for (int i1 = 0; i1 < 2 && i1 < list.size(); ++i1) {
                this.a.b(bjz.k(this.a), (String)list.get(i1), par2 + 32 + 2, par3 + 12 + 10 * i1, 0x808080);
            }
        }
    }

    static bjt a(bka par0GuiScreenTemporaryResourcePackSelectSelectionList) {
        return par0GuiScreenTemporaryResourcePackSelectSelectionList.b;
    }
}

