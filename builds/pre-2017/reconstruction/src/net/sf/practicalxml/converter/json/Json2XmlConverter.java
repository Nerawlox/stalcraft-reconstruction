/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.converter.json;

import java.util.EnumSet;
import net.sf.practicalxml.DomUtil;
import net.sf.practicalxml.converter.ConversionException;
import net.sf.practicalxml.converter.internal.JsonUtils;
import net.sf.practicalxml.converter.json.Json2XmlOptions;
import org.w3c.dom.Element;

public class Json2XmlConverter {
    private EnumSet<Json2XmlOptions> _options = EnumSet.noneOf(Json2XmlOptions.class);
    private String _src;
    private int _curPos;
    private int _nextPos;

    public Json2XmlConverter(String string, Json2XmlOptions ... json2XmlOptionsArray) {
        this._src = string;
        for (Json2XmlOptions json2XmlOptions : json2XmlOptionsArray) {
            this._options.add(json2XmlOptions);
        }
    }

    public Element convert() {
        return this.convert("data");
    }

    public Element convert(String string) {
        return this.convert(null, string);
    }

    public Element convert(String string, String string2) {
        Element element = DomUtil.newDocument(string, string2);
        this.convert(element);
        return element;
    }

    public void convert(Element element) {
        this.parse(element);
    }

    private void parse(Element element) {
        String string = this.nextToken();
        if (string.equals("{")) {
            this.parseObject(element);
        } else if (string.equals("[")) {
            this.parseArray(element);
        } else {
            throw new ConversionException(this.commonExceptionText("unexpected content start of line"));
        }
        if (this.nextToken().length() > 0) {
            throw new ConversionException(this.commonExceptionText("unexpected content at end of line"));
        }
    }

    private String valueDispatch(String string, Element element) {
        if (string.equals("{")) {
            this.parseObject(element);
        } else if (string.equals("[")) {
            this.parseArray(element);
        } else if (string.equals("\"")) {
            DomUtil.setText(element, this.parseString());
        } else {
            DomUtil.setText(element, string);
        }
        return this.nextToken();
    }

    private void parseObject(Element element) {
        String string = this.nextToken();
        if (this.atEndOfSequence(string, "}", false)) {
            return;
        }
        while (true) {
            if (string.equals("\"")) {
                string = this.parseString();
            }
            Element element2 = this.appendChild(element, string);
            this.expect(":");
            string = this.valueDispatch(this.nextToken(), element2);
            if (this.atEndOfSequence(string, "}", true)) {
                return;
            }
            string = this.nextToken();
        }
    }

    private void parseArray(Element element) {
        Object object;
        String string = "data";
        if (this._options.contains((Object)Json2XmlOptions.ARRAYS_AS_REPEATED_ELEMENTS)) {
            object = element.getParentNode();
            if (!(object instanceof Element)) {
                throw new ConversionException(this.commonExceptionText("cannot convert top-level array as repeated elements"));
            }
            string = DomUtil.getLocalName(element);
            object.removeChild(element);
            element = (Element)object;
        }
        if (this.atEndOfSequence((String)(object = this.nextToken()), "]", false)) {
            return;
        }
        Element element2;
        while (!this.atEndOfSequence((String)(object = this.valueDispatch((String)object, element2 = this.appendChild(element, string))), "]", true)) {
            object = this.nextToken();
        }
        return;
    }

    private String parseString() {
        try {
            this._curPos = this._nextPos;
            while (this._nextPos < this._src.length()) {
                char c = this._src.charAt(this._nextPos);
                if (c == '\"') {
                    return JsonUtils.unescape(this._src.substring(this._curPos, this._nextPos++));
                }
                if (c == '\\') {
                    ++this._nextPos;
                }
                ++this._nextPos;
            }
            throw new ConversionException(this.commonExceptionText("unterminated string"));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new ConversionException(this.commonExceptionText("invalid string"), illegalArgumentException);
        }
    }

    private String expect(String string) {
        String string2 = this.nextToken();
        if (string2.equals(string)) {
            return string2;
        }
        throw new ConversionException(this.commonExceptionText("unexpected token"));
    }

    private boolean atEndOfSequence(String string, String string2, boolean bl) {
        if (string.equals(string2)) {
            return true;
        }
        if (string.equals(",")) {
            return false;
        }
        if (string.equals("")) {
            throw new ConversionException(this.commonExceptionText("unexpected end of input"));
        }
        if (bl) {
            throw new ConversionException(this.commonExceptionText("unexpected token"));
        }
        return false;
    }

    private String nextToken() {
        int n = this._src.length();
        this._curPos = this._nextPos;
        while (this._curPos < n && Character.isWhitespace(this._src.charAt(this._curPos))) {
            ++this._curPos;
        }
        if (this._curPos == n) {
            return "";
        }
        this._nextPos = this._curPos + 1;
        if (!this.isDelimiter(this._src.charAt(this._curPos))) {
            while (this._nextPos < n && !Character.isWhitespace(this._src.charAt(this._nextPos)) && !this.isDelimiter(this._src.charAt(this._nextPos))) {
                ++this._nextPos;
            }
        }
        return this._src.substring(this._curPos, this._nextPos);
    }

    private boolean isDelimiter(char c) {
        switch (c) {
            case '\"': 
            case ',': 
            case ':': 
            case '[': 
            case ']': 
            case '{': 
            case '}': {
                return true;
            }
        }
        return false;
    }

    private String commonExceptionText(String string) {
        String string2 = this._curPos + 20 > this._src.length() ? this._src.substring(this._curPos) : this._src.substring(this._curPos, this._curPos + 20) + "[...]";
        return string + " at position " + this._curPos + ": \"" + string2 + "\"";
    }

    private Element appendChild(Element element, String string) {
        if (string.equals("")) {
            throw new ConversionException(this.commonExceptionText("unexpected end of input"));
        }
        if (this.isDelimiter(string.charAt(0))) {
            throw new ConversionException(this.commonExceptionText("invalid token"));
        }
        try {
            return DomUtil.appendChildInheritNamespace(element, string);
        }
        catch (Exception exception) {
            throw new ConversionException(this.commonExceptionText("invalid element name"), exception);
        }
    }
}

