package ru.sfedu.core.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author sergei
 */
@Entity
@Table
public class LogEvents implements Serializable {

    private Long id;
    private String name;
    private Experiment Experiment;
    private String action;
    private Long date;
    private Users User;

    public LogEvents() {
    }

    public LogEvents(String name, Experiment Experiment, String action, Long date, Users User) {
        this.name = name;
        this.Experiment = Experiment;
        this.action = action;
        this.date = date;
        this.User = User;
    }
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    public Experiment getExperiment() {
        return Experiment;
    }

    public void setExperiment(Experiment Experiment) {
        this.Experiment = Experiment;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    public Users getUser() {
        return User;
    }

    public void setUser(Users User) {
        this.User = User;
    }

    @Override
    public String toString() {
        return "LogEvents{" + "id=" + id + ", name=" + name + ", Experiment=" + Experiment + ", action=" + action + ", date=" + date + ", User=" + User + '}';
    }
    
}
