package ru.sfedu.core.model;

/**
 *
 * @author sergei
 */
public class InfoKeyValue {

    private int index;
    private String key;
    private String value;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public InfoKeyValue(int index, String key, String value) {
        this.index = index;
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }   
}
