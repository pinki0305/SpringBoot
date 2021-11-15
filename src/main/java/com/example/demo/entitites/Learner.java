package com.example.demo.entitites;


import javax.persistence.*;

@Entity
@Table(name="learnerdbtable")
public class Learner
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
    int id;

    @Column(name="eid")
    private String eid;

    @Column(name="time_in")
    private String time_in;

    @Column(name="time_out")
    private String time_out;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getTime_in() {
        return time_in;
    }

    public void setTime_in(String time_in) {
        this.time_in = time_in;
    }

    public String getTime_out() {
        return time_out;
    }

    public void setTime_out(String time_out) {
        this.time_out = time_out;
    }
}
