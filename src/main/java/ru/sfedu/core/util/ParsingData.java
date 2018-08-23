package ru.sfedu.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ru.sfedu.core.model.InfoKeyValue;
/**
 *
 * @author sergei
 */
public class ParsingData {

    private int i = 0;

    public List<String> findByInfo(List fileList, String key) {
        int start = fileList.indexOf(key);
        int end;
        if (start != -1) {
            fileList = fileList.subList(start + 1, fileList.size());
            end = fileList.indexOf("");
            if (end != -1) {
                fileList = fileList = fileList.subList(0, end);
            }
        }
        return fileList;
    }

    public Map< String, String> mapList(List fileList) {
        Map< String, String> map = new HashMap< String, String>();
        fileList.forEach(action -> {
            String[] arrString = action.toString().split("=");
            map.put(arrString[0], arrString[1]);
        });
        return map;
    }

    public List<InfoKeyValue> getList(List fileList) {
        List<InfoKeyValue> listData = new ArrayList<InfoKeyValue>();
        fileList.forEach(action -> {
            String[] arrString = action.toString().split("=");
            listData.add(new InfoKeyValue(i++, arrString[0], arrString[1]));
        });
        i = 0;
        return listData;
    }
    
    public short toShort(byte[] array) {
        short i = (short) (((0xFF & array[0]) << 0) | ((0xFF & array[1]) << 8));
        return i;
    }

    public int toInteger(byte[] array) {
        int i = ((0xFF & array[0]) << 0) | ((0xFF & array[1]) << 8)
                | ((0xFF & array[2]) << 16) | (0xFF & array[3] << 24);
        return i;
    }

    public double toDouble(byte[] array) {

        double i = ((0xFF & array[0]) << 0) | ((0xFF & array[1]) << 8)
                | ((0xFF & array[2]) << 16) | (0xFF & array[3] << 24)
                | ((0xFF & array[4]) << 32) | ((0xFF & array[5]) << 40)
                | ((0xFF & array[6]) << 48) | (0xFF & array[7] << 56);
        return i;
    }

}
