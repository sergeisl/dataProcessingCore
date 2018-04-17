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
public class Channel_desc implements Serializable {
   @Id
    @GeneratedValue(strategy = IDENTITY)  private long id;
    private long id_info;
    private int channel_num;
    private String channel_name;

    public Channel_desc() {
    }

    public Channel_desc(long id_info, int channel_num, String channel_name) {
        this.id_info = id_info;
        this.channel_num = channel_num;
        this.channel_name = channel_name;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_info() {
        return id_info;
    }

    public void setId_info(long id_info) {
        this.id_info = id_info;
    }

    public int getChannel_num() {
        return channel_num;
    }

    public void setChannel_num(int channel_num) {
        this.channel_num = channel_num;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }
    
    
}
