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
public class ExperimentData implements Serializable {

    private long id;
    private String fileName;
    private byte[] dataExperiment;
    private TypeDataExperiment type;

    public ExperimentData() {
    }

    public ExperimentData(TypeDataExperiment type, String PATH_DATA) {
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Enumerated(EnumType.ORDINAL)
    public TypeDataExperiment getType() {
        return type;
    }

    public void setType(TypeDataExperiment type) {
        this.type = type;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    @Lob
    public byte[] getDataExperiment() {
        return dataExperiment;
    }

    public void setDataExperiment(byte[] dataExperiment) {
        this.dataExperiment = dataExperiment;
    }

    @Override
    public String toString() {
        return "ExperimentData{" + "id=" + id + ", fileName=" + fileName + ", dataExperiment=" + dataExperiment + ", type=" + type + '}';
    }

}
