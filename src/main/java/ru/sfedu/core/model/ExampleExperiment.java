package ru.sfedu.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import ru.sfedu.core.model.ExperimentData;

/**
 *
 * @author sergei
 */

@Entity
public class ExampleExperiment extends Experiment implements Serializable {

    private String fileName;
    private byte[] metaInfo;
    private Users user;
    private Permission permission;
    
    public ExampleExperiment() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    @Lob
    public byte[] getMetaInfo() {
        return metaInfo;
    }

    public void setMetaInfo(byte[] metaInfo) {
        this.metaInfo = metaInfo;
    }
    
    @OneToOne//(fetch = FetchType.LAZY)
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
    @Enumerated(EnumType.ORDINAL)
    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Experiment{" + "fileName=" + fileName + ", metaInfo=" + metaInfo;
    }

}
