package ru.sfedu.core.model;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 * @author sergei
 */
@Entity
@Table
public class Info implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private int count_channel;
    private String pathData;

    public Info() {
    }
    
    public Info(int count_channel) {
        this.count_channel = count_channel;
    }
    
    public Info(int count_channel, String PATH_DATA) {
        this.count_channel = count_channel;
        this.pathData = PATH_DATA;
    }

    public String getPathData() {
        return pathData;
    }

    public void setPathData(String pathData) {
        this.pathData = pathData;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCount_channel() {
        return count_channel;
    }

    public void setCount_channel(int count_channel) {
        this.count_channel = count_channel;
    }

    @Override
    public String toString() {
        return "Info{" + "id=" + id + ", count_channel=" + count_channel + ", pathData=" + pathData + '}';
    }
  
}
