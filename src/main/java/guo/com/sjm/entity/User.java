package guo.com.sjm.entity;


import com.google.common.base.MoreObjects;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table
public class User {

    @Id
    private Integer id;

    @Column
    @NotNull
    private Integer deptno;

    @Column
    @NotNull
    private String username;

    @Column
    @NotNull
    private Double sal;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeptno() {
        return this.deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getSal() {
        return this.sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).add("deptno", deptno)
                .add("username", username).add("sal", sal)
                .toString();
    }
}
