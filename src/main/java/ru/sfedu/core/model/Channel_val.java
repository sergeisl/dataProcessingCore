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
public class Channel_val implements Serializable {
       
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;     
    private int channel_val;
    private long id_channel;

    public Channel_val() {
    }

    public Channel_val(int channel_val, long id_channel) {
        this.channel_val = channel_val;
        this.id_channel = id_channel;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getChannel_val() {
        return channel_val;
    }

    public void setChannel_val(int channel_val) {
        this.channel_val = channel_val;
    }

    public long getId_channel() {
        return id_channel;
    }

    public void setId_channel(long id_channel) {
        this.id_channel = id_channel;
    }
    
    
}
