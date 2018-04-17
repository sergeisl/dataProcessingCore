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

}
