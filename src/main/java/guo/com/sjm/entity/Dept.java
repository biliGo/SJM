package guo.com.sjm.entity;


import com.google.common.base.MoreObjects;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table
public class Dept {

    @Id
    private Integer deptno;

    @Column
    @NotNull
    private String deptname;

    public Integer getDeptno() {
        return this.deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return this.deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("deptno", deptno).add("deptname", deptname)
                .toString();
    }
}
