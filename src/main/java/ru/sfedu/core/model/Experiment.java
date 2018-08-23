package ru.sfedu.core.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 *
 * @author sergei
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Experiment {
    
    private Long id;
    private Long date;
    private List<ExperimentData> data = new ArrayList<ExperimentData>();

    public Experiment() {
    }
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
    @OneToMany(fetch = FetchType.LAZY)
    public List<ExperimentData> getData() {
        return data;
    }
        
    public void setData(List<ExperimentData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Experiment{" + "id=" + id + ", date=" + date + ", data=" + data + '}';
    }

}
