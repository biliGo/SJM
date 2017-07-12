package guo.com.sjm.entity;


import com.google.common.base.MoreObjects;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table
public class Stu {

    @Id
    private Integer id;

    @Column
    @NotNull
    private String pwd;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).add("pwd", pwd)
                .toString();
    }
}
