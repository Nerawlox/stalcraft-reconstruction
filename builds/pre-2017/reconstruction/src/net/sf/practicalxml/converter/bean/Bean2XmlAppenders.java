/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.converter.bean;

import java.util.EnumSet;
import net.sf.practicalxml.DomUtil;
import net.sf.practicalxml.converter.ConversionException;
import net.sf.practicalxml.converter.bean.Bean2XmlOptions;
import net.sf.practicalxml.converter.internal.ConversionUtils;
import net.sf.practicalxml.converter.internal.TypeUtils;
import org.w3c.dom.Element;

public abstract class Bean2XmlAppenders {

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class DirectAppender
    extends AbstractAppender {
        private Element _elem;

        public DirectAppender(Element element, EnumSet<Bean2XmlOptions> enumSet) {
            super(enumSet);
            this._elem = element;
        }

        @Override
        public Element appendValue(String string, Class<?> clazz, String string2) {
            if (!this.shouldSkip(string2)) {
                this.setType(this._elem, clazz);
                this.setValue(this._elem, string2);
            }
            return this._elem;
        }

        @Override
        public Element appendContainer(String string, Class<?> clazz) {
            this.setType(this._elem, clazz);
            return this._elem;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class MapAppender
    extends BasicAppender {
        public MapAppender(Element element, EnumSet<Bean2XmlOptions> enumSet) {
            super(element, enumSet);
        }

        @Override
        public Element appendValue(String string, Class<?> clazz, String string2) {
            Element element = super.appendValue(this.determineName(string), clazz, string2);
            this.setMapKeyIfNeeded(element, string);
            return element;
        }

        @Override
        public Element appendContainer(String string, Class<?> clazz) {
            Element element = super.appendContainer(this.determineName(string), clazz);
            this.setMapKeyIfNeeded(element, string);
            return element;
        }

        private String determineName(String string) {
            return this.isOptionSet(Bean2XmlOptions.MAP_KEYS_AS_ELEMENT_NAME) ? string : "data";
        }

        private void setMapKeyIfNeeded(Element element, String string) {
            if (element != null && !this.isOptionSet(Bean2XmlOptions.MAP_KEYS_AS_ELEMENT_NAME)) {
                ConversionUtils.setAttribute(element, "key", string);
            }
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class IndexedAppender
    extends BasicAppender {
        private int _index = 0;

        public IndexedAppender(Element element, EnumSet<Bean2XmlOptions> enumSet) {
            super(element, enumSet);
        }

        @Override
        public Element appendValue(String string, Class<?> clazz, String string2) {
            Element element = super.appendValue(string, clazz, string2);
            if (element != null && this.isOptionSet(Bean2XmlOptions.USE_INDEX_ATTR)) {
                ConversionUtils.setAttribute(element, "index", String.valueOf(this._index++));
            }
            return element;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class BasicAppender
    extends AbstractAppender {
        private Element _parent;

        public BasicAppender(Element element, EnumSet<Bean2XmlOptions> enumSet) {
            super(enumSet);
            this._parent = element;
        }

        @Override
        public Element appendValue(String string, Class<?> clazz, String string2) {
            if (this.shouldSkip(string2)) {
                return null;
            }
            try {
                Element element = DomUtil.appendChildInheritNamespace(this._parent, string);
                this.setType(element, clazz);
                this.setValue(element, string2);
                return element;
            }
            catch (Exception exception) {
                throw new ConversionException("unable to append child: " + string, this._parent, (Throwable)exception);
            }
        }

        @Override
        public Element appendContainer(String string, Class<?> clazz) {
            Element element = DomUtil.appendChildInheritNamespace(this._parent, string);
            this.setType(element, clazz);
            return element;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static abstract class AbstractAppender
    implements Appender {
        private EnumSet<Bean2XmlOptions> _options;

        public AbstractAppender(EnumSet<Bean2XmlOptions> enumSet) {
            this._options = enumSet;
        }

        protected boolean isOptionSet(Bean2XmlOptions bean2XmlOptions) {
            return this._options.contains((Object)bean2XmlOptions);
        }

        protected boolean shouldSkip(Object object) {
            return object == null && !this._options.contains((Object)Bean2XmlOptions.NULL_AS_EMPTY) && !this._options.contains((Object)Bean2XmlOptions.NULL_AS_XSI_NIL);
        }

        protected void setType(Element element, Class<?> clazz) {
            if (this.isOptionSet(Bean2XmlOptions.USE_TYPE_ATTR)) {
                TypeUtils.setType(element, clazz);
            }
        }

        protected void setValue(Element element, String string) {
            if (string != null) {
                DomUtil.setText(element, string);
            } else if (this.isOptionSet(Bean2XmlOptions.NULL_AS_EMPTY)) {
                DomUtil.setText(element, "");
            } else if (this.isOptionSet(Bean2XmlOptions.NULL_AS_XSI_NIL)) {
                ConversionUtils.setXsiNil(element, true);
            }
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface Appender {
        public Element appendValue(String var1, Class<?> var2, String var3);

        public Element appendContainer(String var1, Class<?> var2);
    }
}

