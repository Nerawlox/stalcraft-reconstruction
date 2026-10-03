/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.xml;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamSource;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.xml.ASMContentHandler;
import org.objectweb.asm.xml.SAXClassAdapter;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class Processor {
    public static final int BYTECODE = 1;
    public static final int MULTI_XML = 2;
    public static final int SINGLE_XML = 3;
    private static final String SINGLE_XML_NAME = "classes.xml";
    private final int inRepresentation;
    private final int outRepresentation;
    private final InputStream input;
    private final OutputStream output;
    private final Source xslt;
    private int n = 0;

    public Processor(int inRepresenation, int outRepresentation, InputStream input, OutputStream output, Source xslt) {
        this.inRepresentation = inRepresenation;
        this.outRepresentation = outRepresentation;
        this.input = input;
        this.output = output;
        this.xslt = xslt;
    }

    public int process() throws TransformerException, IOException, SAXException {
        ZipEntry ze;
        ZipInputStream zis = new ZipInputStream(this.input);
        ZipOutputStream zos = new ZipOutputStream(this.output);
        OutputStreamWriter osw = new OutputStreamWriter(zos);
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        TransformerFactory tf = TransformerFactory.newInstance();
        if (!tf.getFeature("http://javax.xml.transform.sax.SAXSource/feature") || !tf.getFeature("http://javax.xml.transform.sax.SAXResult/feature")) {
            return 0;
        }
        SAXTransformerFactory saxtf = (SAXTransformerFactory)tf;
        Templates templates = null;
        if (this.xslt != null) {
            templates = saxtf.newTemplates(this.xslt);
        }
        EntryElement entryElement = this.getEntryElement(zos);
        DefaultHandler outDocHandler = null;
        switch (this.outRepresentation) {
            case 1: {
                outDocHandler = new OutputSlicingHandler(new ASMContentHandlerFactory(zos), entryElement, false);
                break;
            }
            case 2: {
                outDocHandler = new OutputSlicingHandler(new SAXWriterFactory(osw, true), entryElement, true);
                break;
            }
            case 3: {
                ZipEntry outputEntry = new ZipEntry(SINGLE_XML_NAME);
                zos.putNextEntry(outputEntry);
                outDocHandler = new SAXWriter(osw, false);
            }
        }
        DefaultHandler inDocHandler = templates == null ? outDocHandler : new InputSlicingHandler("class", outDocHandler, new TransformerHandlerFactory(saxtf, templates, outDocHandler));
        SubdocumentHandlerFactory inDocHandlerFactory = new SubdocumentHandlerFactory(inDocHandler);
        if (inDocHandler != null && this.inRepresentation != 3) {
            inDocHandler.startDocument();
            inDocHandler.startElement("", "classes", "classes", new AttributesImpl());
        }
        int i = 0;
        while ((ze = zis.getNextEntry()) != null) {
            this.update(ze.getName(), this.n++);
            if (this.isClassEntry(ze)) {
                this.processEntry(zis, ze, inDocHandlerFactory);
            } else {
                OutputStream os = entryElement.openEntry(this.getName(ze));
                this.copyEntry(zis, os);
                entryElement.closeEntry();
            }
            ++i;
        }
        if (inDocHandler != null && this.inRepresentation != 3) {
            inDocHandler.endElement("", "classes", "classes");
            inDocHandler.endDocument();
        }
        if (this.outRepresentation == 3) {
            zos.closeEntry();
        }
        zos.flush();
        zos.close();
        return i;
    }

    private void copyEntry(InputStream is, OutputStream os) throws IOException {
        int i;
        if (this.outRepresentation == 3) {
            return;
        }
        byte[] buff = new byte[2048];
        while ((i = is.read(buff)) != -1) {
            os.write(buff, 0, i);
        }
    }

    private boolean isClassEntry(ZipEntry ze) {
        String name2 = ze.getName();
        return this.inRepresentation == 3 && name2.equals(SINGLE_XML_NAME) || name2.endsWith(".class") || name2.endsWith(".class.xml");
    }

    private void processEntry(ZipInputStream zis, ZipEntry ze, ContentHandlerFactory handlerFactory) {
        ContentHandler handler = handlerFactory.createContentHandler();
        try {
            boolean singleInputDocument;
            boolean bl = singleInputDocument = this.inRepresentation == 3;
            if (this.inRepresentation == 1) {
                ClassReader cr = new ClassReader(Processor.readEntry(zis, ze));
                cr.accept(new SAXClassAdapter(handler, singleInputDocument), 0);
            } else {
                XMLReader reader = XMLReaderFactory.createXMLReader();
                reader.setContentHandler(handler);
                reader.parse(new InputSource(singleInputDocument ? new ProtectedInputStream(zis) : new ByteArrayInputStream(Processor.readEntry(zis, ze))));
            }
        }
        catch (Exception ex) {
            this.update(ze.getName(), 0);
            this.update(ex, 0);
        }
    }

    private EntryElement getEntryElement(ZipOutputStream zos) {
        if (this.outRepresentation == 3) {
            return new SingleDocElement(zos);
        }
        return new ZipEntryElement(zos);
    }

    private String getName(ZipEntry ze) {
        String name2 = ze.getName();
        if (this.isClassEntry(ze)) {
            if (this.inRepresentation != 1 && this.outRepresentation == 1) {
                name2 = name2.substring(0, name2.length() - 4);
            } else if (this.inRepresentation == 1 && this.outRepresentation != 1) {
                name2 = name2 + ".xml";
            }
        }
        return name2;
    }

    private static byte[] readEntry(InputStream zis, ZipEntry ze) throws IOException {
        int i;
        long size = ze.getSize();
        if (size > -1L) {
            int n;
            byte[] buff = new byte[(int)size];
            int k = 0;
            while ((n = zis.read(buff, k, buff.length - k)) > 0) {
                k += n;
            }
            return buff;
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buff = new byte[4096];
        while ((i = zis.read(buff)) != -1) {
            bos.write(buff, 0, i);
        }
        return bos.toByteArray();
    }

    protected void update(Object arg, int n) {
        if (arg instanceof Throwable) {
            ((Throwable)arg).printStackTrace();
        } else if (n % 100 == 0) {
            System.err.println(n + " " + arg);
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            Processor.showUsage();
            return;
        }
        int inRepresentation = Processor.getRepresentation(args[0]);
        int outRepresentation = Processor.getRepresentation(args[1]);
        InputStream is = System.in;
        BufferedOutputStream os = new BufferedOutputStream(System.out);
        StreamSource xslt = null;
        for (int i = 2; i < args.length; ++i) {
            if ("-in".equals(args[i])) {
                is = new FileInputStream(args[++i]);
                continue;
            }
            if ("-out".equals(args[i])) {
                os = new BufferedOutputStream(new FileOutputStream(args[++i]));
                continue;
            }
            if ("-xslt".equals(args[i])) {
                xslt = new StreamSource(new FileInputStream(args[++i]));
                continue;
            }
            Processor.showUsage();
            return;
        }
        if (inRepresentation == 0 || outRepresentation == 0) {
            Processor.showUsage();
            return;
        }
        Processor m = new Processor(inRepresentation, outRepresentation, is, os, xslt);
        long l1 = System.currentTimeMillis();
        int n = m.process();
        long l2 = System.currentTimeMillis();
        System.err.println(n);
        System.err.println(l2 - l1 + "ms  " + 1000.0f * (float)n / (float)(l2 - l1) + " resources/sec");
    }

    private static int getRepresentation(String s) {
        if ("code".equals(s)) {
            return 1;
        }
        if ("xml".equals(s)) {
            return 2;
        }
        if ("singlexml".equals(s)) {
            return 3;
        }
        return 0;
    }

    private static void showUsage() {
        System.err.println("Usage: Main <in format> <out format> [-in <input jar>] [-out <output jar>] [-xslt <xslt fiel>]");
        System.err.println("  when -in or -out is omitted sysin and sysout would be used");
        System.err.println("  <in format> and <out format> - code | xml | singlexml");
    }

    private static final class ZipEntryElement
    implements EntryElement {
        private ZipOutputStream zos;

        ZipEntryElement(ZipOutputStream zos) {
            this.zos = zos;
        }

        @Override
        public OutputStream openEntry(String name2) throws IOException {
            ZipEntry entry = new ZipEntry(name2);
            this.zos.putNextEntry(entry);
            return this.zos;
        }

        @Override
        public void closeEntry() throws IOException {
            this.zos.flush();
            this.zos.closeEntry();
        }
    }

    private static final class SingleDocElement
    implements EntryElement {
        private final OutputStream os;

        SingleDocElement(OutputStream os) {
            this.os = os;
        }

        @Override
        public OutputStream openEntry(String name2) throws IOException {
            return this.os;
        }

        @Override
        public void closeEntry() throws IOException {
            this.os.flush();
        }
    }

    private static interface EntryElement {
        public OutputStream openEntry(String var1) throws IOException;

        public void closeEntry() throws IOException;
    }

    private static final class OutputSlicingHandler
    extends DefaultHandler {
        private final String subdocumentRoot;
        private ContentHandlerFactory subdocumentHandlerFactory;
        private final EntryElement entryElement;
        private boolean isXml;
        private boolean subdocument = false;
        private ContentHandler subdocumentHandler;

        OutputSlicingHandler(ContentHandlerFactory subdocumentHandlerFactory, EntryElement entryElement, boolean isXml) {
            this.subdocumentRoot = "class";
            this.subdocumentHandlerFactory = subdocumentHandlerFactory;
            this.entryElement = entryElement;
            this.isXml = isXml;
        }

        @Override
        public final void startElement(String namespaceURI, String localName, String qName, Attributes list) throws SAXException {
            if (this.subdocument) {
                this.subdocumentHandler.startElement(namespaceURI, localName, qName, list);
            } else if (localName.equals(this.subdocumentRoot)) {
                String name2 = list.getValue("name");
                if (name2 == null || name2.length() == 0) {
                    throw new SAXException("Class element without name attribute.");
                }
                try {
                    this.entryElement.openEntry(this.isXml ? name2 + ".class.xml" : name2 + ".class");
                }
                catch (IOException ex) {
                    throw new SAXException(ex.toString(), ex);
                }
                this.subdocumentHandler = this.subdocumentHandlerFactory.createContentHandler();
                this.subdocumentHandler.startDocument();
                this.subdocumentHandler.startElement(namespaceURI, localName, qName, list);
                this.subdocument = true;
            }
        }

        @Override
        public final void endElement(String namespaceURI, String localName, String qName) throws SAXException {
            if (this.subdocument) {
                this.subdocumentHandler.endElement(namespaceURI, localName, qName);
                if (localName.equals(this.subdocumentRoot)) {
                    this.subdocumentHandler.endDocument();
                    this.subdocument = false;
                    try {
                        this.entryElement.closeEntry();
                    }
                    catch (IOException ex) {
                        throw new SAXException(ex.toString(), ex);
                    }
                }
            }
        }

        @Override
        public final void startDocument() throws SAXException {
        }

        @Override
        public final void endDocument() throws SAXException {
        }

        @Override
        public final void characters(char[] buff, int offset, int size) throws SAXException {
            if (this.subdocument) {
                this.subdocumentHandler.characters(buff, offset, size);
            }
        }
    }

    private static final class InputSlicingHandler
    extends DefaultHandler {
        private String subdocumentRoot;
        private final ContentHandler rootHandler;
        private ContentHandlerFactory subdocumentHandlerFactory;
        private boolean subdocument = false;
        private ContentHandler subdocumentHandler;

        InputSlicingHandler(String subdocumentRoot, ContentHandler rootHandler, ContentHandlerFactory subdocumentHandlerFactory) {
            this.subdocumentRoot = subdocumentRoot;
            this.rootHandler = rootHandler;
            this.subdocumentHandlerFactory = subdocumentHandlerFactory;
        }

        @Override
        public final void startElement(String namespaceURI, String localName, String qName, Attributes list) throws SAXException {
            if (this.subdocument) {
                this.subdocumentHandler.startElement(namespaceURI, localName, qName, list);
            } else if (localName.equals(this.subdocumentRoot)) {
                this.subdocumentHandler = this.subdocumentHandlerFactory.createContentHandler();
                this.subdocumentHandler.startDocument();
                this.subdocumentHandler.startElement(namespaceURI, localName, qName, list);
                this.subdocument = true;
            } else if (this.rootHandler != null) {
                this.rootHandler.startElement(namespaceURI, localName, qName, list);
            }
        }

        @Override
        public final void endElement(String namespaceURI, String localName, String qName) throws SAXException {
            if (this.subdocument) {
                this.subdocumentHandler.endElement(namespaceURI, localName, qName);
                if (localName.equals(this.subdocumentRoot)) {
                    this.subdocumentHandler.endDocument();
                    this.subdocument = false;
                }
            } else if (this.rootHandler != null) {
                this.rootHandler.endElement(namespaceURI, localName, qName);
            }
        }

        @Override
        public final void startDocument() throws SAXException {
            if (this.rootHandler != null) {
                this.rootHandler.startDocument();
            }
        }

        @Override
        public final void endDocument() throws SAXException {
            if (this.rootHandler != null) {
                this.rootHandler.endDocument();
            }
        }

        @Override
        public final void characters(char[] buff, int offset, int size) throws SAXException {
            if (this.subdocument) {
                this.subdocumentHandler.characters(buff, offset, size);
            } else if (this.rootHandler != null) {
                this.rootHandler.characters(buff, offset, size);
            }
        }
    }

    private static final class SAXWriter
    extends DefaultHandler
    implements LexicalHandler {
        private static final char[] OFF = "                                                                                                        ".toCharArray();
        private Writer w;
        private final boolean optimizeEmptyElements;
        private boolean openElement = false;
        private int ident = 0;

        SAXWriter(Writer w, boolean optimizeEmptyElements) {
            this.w = w;
            this.optimizeEmptyElements = optimizeEmptyElements;
        }

        @Override
        public final void startElement(String ns, String localName, String qName, Attributes atts) throws SAXException {
            try {
                this.closeElement();
                this.writeIdent();
                this.w.write('<' + qName);
                if (atts != null && atts.getLength() > 0) {
                    this.writeAttributes(atts);
                }
                if (this.optimizeEmptyElements) {
                    this.openElement = true;
                } else {
                    this.w.write(">\n");
                }
                this.ident += 2;
            }
            catch (IOException ex) {
                throw new SAXException(ex);
            }
        }

        @Override
        public final void endElement(String ns, String localName, String qName) throws SAXException {
            this.ident -= 2;
            try {
                if (this.openElement) {
                    this.w.write("/>\n");
                    this.openElement = false;
                } else {
                    this.writeIdent();
                    this.w.write("</" + qName + ">\n");
                }
            }
            catch (IOException ex) {
                throw new SAXException(ex);
            }
        }

        @Override
        public final void endDocument() throws SAXException {
            try {
                this.w.flush();
            }
            catch (IOException ex) {
                throw new SAXException(ex);
            }
        }

        @Override
        public final void comment(char[] ch, int off, int len) throws SAXException {
            try {
                this.closeElement();
                this.writeIdent();
                this.w.write("<!-- ");
                this.w.write(ch, off, len);
                this.w.write(" -->\n");
            }
            catch (IOException ex) {
                throw new SAXException(ex);
            }
        }

        @Override
        public final void startDTD(String arg0, String arg1, String arg2) throws SAXException {
        }

        @Override
        public final void endDTD() throws SAXException {
        }

        @Override
        public final void startEntity(String arg0) throws SAXException {
        }

        @Override
        public final void endEntity(String arg0) throws SAXException {
        }

        @Override
        public final void startCDATA() throws SAXException {
        }

        @Override
        public final void endCDATA() throws SAXException {
        }

        private final void writeAttributes(Attributes atts) throws IOException {
            StringBuilder sb = new StringBuilder();
            int len = atts.getLength();
            for (int i = 0; i < len; ++i) {
                sb.append(' ').append(atts.getLocalName(i)).append("=\"").append(SAXWriter.esc(atts.getValue(i))).append('\"');
            }
            this.w.write(sb.toString());
        }

        private static final String esc(String str) {
            StringBuilder sb = new StringBuilder(str.length());
            block6: for (int i = 0; i < str.length(); ++i) {
                char ch = str.charAt(i);
                switch (ch) {
                    case '&': {
                        sb.append("&amp;");
                        continue block6;
                    }
                    case '<': {
                        sb.append("&lt;");
                        continue block6;
                    }
                    case '>': {
                        sb.append("&gt;");
                        continue block6;
                    }
                    case '\"': {
                        sb.append("&quot;");
                        continue block6;
                    }
                    default: {
                        if (ch > '\u007f') {
                            sb.append("&#").append(Integer.toString(ch)).append(';');
                            continue block6;
                        }
                        sb.append(ch);
                    }
                }
            }
            return sb.toString();
        }

        private final void writeIdent() throws IOException {
            int n = this.ident;
            while (n > 0) {
                if (n > OFF.length) {
                    this.w.write(OFF);
                    n -= OFF.length;
                    continue;
                }
                this.w.write(OFF, 0, n);
                n = 0;
            }
        }

        private final void closeElement() throws IOException {
            if (this.openElement) {
                this.w.write(">\n");
            }
            this.openElement = false;
        }
    }

    private static final class SubdocumentHandlerFactory
    implements ContentHandlerFactory {
        private final ContentHandler subdocumentHandler;

        SubdocumentHandlerFactory(ContentHandler subdocumentHandler) {
            this.subdocumentHandler = subdocumentHandler;
        }

        @Override
        public final ContentHandler createContentHandler() {
            return this.subdocumentHandler;
        }
    }

    private static final class TransformerHandlerFactory
    implements ContentHandlerFactory {
        private SAXTransformerFactory saxtf;
        private final Templates templates;
        private ContentHandler outputHandler;

        TransformerHandlerFactory(SAXTransformerFactory saxtf, Templates templates, ContentHandler outputHandler) {
            this.saxtf = saxtf;
            this.templates = templates;
            this.outputHandler = outputHandler;
        }

        @Override
        public final ContentHandler createContentHandler() {
            try {
                TransformerHandler handler = this.saxtf.newTransformerHandler(this.templates);
                handler.setResult(new SAXResult(this.outputHandler));
                return handler;
            }
            catch (TransformerConfigurationException ex) {
                throw new RuntimeException(ex.toString());
            }
        }
    }

    private static final class ASMContentHandlerFactory
    implements ContentHandlerFactory {
        final OutputStream os;

        ASMContentHandlerFactory(OutputStream os) {
            this.os = os;
        }

        @Override
        public final ContentHandler createContentHandler() {
            final ClassWriter cw = new ClassWriter(1);
            return new ASMContentHandler(cw){

                @Override
                public void endDocument() throws SAXException {
                    try {
                        ASMContentHandlerFactory.this.os.write(cw.toByteArray());
                    }
                    catch (IOException e) {
                        throw new SAXException(e);
                    }
                }
            };
        }
    }

    private static final class SAXWriterFactory
    implements ContentHandlerFactory {
        private final Writer w;
        private final boolean optimizeEmptyElements;

        SAXWriterFactory(Writer w, boolean optimizeEmptyElements) {
            this.w = w;
            this.optimizeEmptyElements = optimizeEmptyElements;
        }

        @Override
        public final ContentHandler createContentHandler() {
            return new SAXWriter(this.w, this.optimizeEmptyElements);
        }
    }

    private static interface ContentHandlerFactory {
        public ContentHandler createContentHandler();
    }

    private static final class ProtectedInputStream
    extends InputStream {
        private final InputStream is;

        ProtectedInputStream(InputStream is) {
            this.is = is;
        }

        @Override
        public final void close() throws IOException {
        }

        @Override
        public final int read() throws IOException {
            return this.is.read();
        }

        @Override
        public final int read(byte[] b, int off, int len) throws IOException {
            return this.is.read(b, off, len);
        }

        @Override
        public final int available() throws IOException {
            return this.is.available();
        }
    }
}

