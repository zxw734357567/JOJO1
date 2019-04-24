package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/4/24  11:02.
 * @Modified by:
 */
@Entity
@Table(name = "HI_SYS_RO")
public class HiSysRoEntity {
    private String idRo;
    private String idTet;
    private String sdRelation;
    private String sdRotp;
    private String sdRolevel;
    private String idRoca;
    private String sdLogintp;
    private String cd;
    private String na;
    private String icon;
    private String py;
    private String wb;
    private String des;
    private String instr;
    private String fgActive;
    private Time dtCreate;
    private Time dtModify;
    private String zj;

    @Id
    @Column(name = "ID_RO")
    public String getIdRo() {
        return idRo;
    }

    public void setIdRo(String idRo) {
        this.idRo = idRo;
    }

    @Basic
    @Column(name = "ID_TET")
    public String getIdTet() {
        return idTet;
    }

    public void setIdTet(String idTet) {
        this.idTet = idTet;
    }

    @Basic
    @Column(name = "SD_RELATION")
    public String getSdRelation() {
        return sdRelation;
    }

    public void setSdRelation(String sdRelation) {
        this.sdRelation = sdRelation;
    }

    @Basic
    @Column(name = "SD_ROTP")
    public String getSdRotp() {
        return sdRotp;
    }

    public void setSdRotp(String sdRotp) {
        this.sdRotp = sdRotp;
    }

    @Basic
    @Column(name = "SD_ROLEVEL")
    public String getSdRolevel() {
        return sdRolevel;
    }

    public void setSdRolevel(String sdRolevel) {
        this.sdRolevel = sdRolevel;
    }

    @Basic
    @Column(name = "ID_ROCA")
    public String getIdRoca() {
        return idRoca;
    }

    public void setIdRoca(String idRoca) {
        this.idRoca = idRoca;
    }

    @Basic
    @Column(name = "SD_LOGINTP")
    public String getSdLogintp() {
        return sdLogintp;
    }

    public void setSdLogintp(String sdLogintp) {
        this.sdLogintp = sdLogintp;
    }

    @Basic
    @Column(name = "CD")
    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    @Basic
    @Column(name = "NA")
    public String getNa() {
        return na;
    }

    public void setNa(String na) {
        this.na = na;
    }

    @Basic
    @Column(name = "ICON")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "PY")
    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py;
    }

    @Basic
    @Column(name = "WB")
    public String getWb() {
        return wb;
    }

    public void setWb(String wb) {
        this.wb = wb;
    }

    @Basic
    @Column(name = "DES")
    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Basic
    @Column(name = "INSTR")
    public String getInstr() {
        return instr;
    }

    public void setInstr(String instr) {
        this.instr = instr;
    }

    @Basic
    @Column(name = "FG_ACTIVE")
    public String getFgActive() {
        return fgActive;
    }

    public void setFgActive(String fgActive) {
        this.fgActive = fgActive;
    }

    @Basic
    @Column(name = "DT_CREATE")
    public Time getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Time dtCreate) {
        this.dtCreate = dtCreate;
    }

    @Basic
    @Column(name = "DT_MODIFY")
    public Time getDtModify() {
        return dtModify;
    }

    public void setDtModify(Time dtModify) {
        this.dtModify = dtModify;
    }

    @Basic
    @Column(name = "ZJ")
    public String getZj() {
        return zj;
    }

    public void setZj(String zj) {
        this.zj = zj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HiSysRoEntity that = (HiSysRoEntity) o;

        if (idRo != null ? !idRo.equals(that.idRo) : that.idRo != null) return false;
        if (idTet != null ? !idTet.equals(that.idTet) : that.idTet != null) return false;
        if (sdRelation != null ? !sdRelation.equals(that.sdRelation) : that.sdRelation != null) return false;
        if (sdRotp != null ? !sdRotp.equals(that.sdRotp) : that.sdRotp != null) return false;
        if (sdRolevel != null ? !sdRolevel.equals(that.sdRolevel) : that.sdRolevel != null) return false;
        if (idRoca != null ? !idRoca.equals(that.idRoca) : that.idRoca != null) return false;
        if (sdLogintp != null ? !sdLogintp.equals(that.sdLogintp) : that.sdLogintp != null) return false;
        if (cd != null ? !cd.equals(that.cd) : that.cd != null) return false;
        if (na != null ? !na.equals(that.na) : that.na != null) return false;
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) return false;
        if (py != null ? !py.equals(that.py) : that.py != null) return false;
        if (wb != null ? !wb.equals(that.wb) : that.wb != null) return false;
        if (des != null ? !des.equals(that.des) : that.des != null) return false;
        if (instr != null ? !instr.equals(that.instr) : that.instr != null) return false;
        if (fgActive != null ? !fgActive.equals(that.fgActive) : that.fgActive != null) return false;
        if (dtCreate != null ? !dtCreate.equals(that.dtCreate) : that.dtCreate != null) return false;
        if (dtModify != null ? !dtModify.equals(that.dtModify) : that.dtModify != null) return false;
        if (zj != null ? !zj.equals(that.zj) : that.zj != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "HiSysRoEntity{" +
                "idRo='" + idRo + '\'' +
                ", idTet='" + idTet + '\'' +
                ", sdRelation='" + sdRelation + '\'' +
                ", sdRotp='" + sdRotp + '\'' +
                ", sdRolevel='" + sdRolevel + '\'' +
                ", idRoca='" + idRoca + '\'' +
                ", sdLogintp='" + sdLogintp + '\'' +
                ", cd='" + cd + '\'' +
                ", na='" + na + '\'' +
                ", icon='" + icon + '\'' +
                ", py='" + py + '\'' +
                ", wb='" + wb + '\'' +
                ", des='" + des + '\'' +
                ", instr='" + instr + '\'' +
                ", fgActive='" + fgActive + '\'' +
                ", dtCreate=" + dtCreate +
                ", dtModify=" + dtModify +
                ", zj='" + zj + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = idRo != null ? idRo.hashCode() : 0;
        result = 31 * result + (idTet != null ? idTet.hashCode() : 0);
        result = 31 * result + (sdRelation != null ? sdRelation.hashCode() : 0);
        result = 31 * result + (sdRotp != null ? sdRotp.hashCode() : 0);
        result = 31 * result + (sdRolevel != null ? sdRolevel.hashCode() : 0);
        result = 31 * result + (idRoca != null ? idRoca.hashCode() : 0);
        result = 31 * result + (sdLogintp != null ? sdLogintp.hashCode() : 0);
        result = 31 * result + (cd != null ? cd.hashCode() : 0);
        result = 31 * result + (na != null ? na.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (py != null ? py.hashCode() : 0);
        result = 31 * result + (wb != null ? wb.hashCode() : 0);
        result = 31 * result + (des != null ? des.hashCode() : 0);
        result = 31 * result + (instr != null ? instr.hashCode() : 0);
        result = 31 * result + (fgActive != null ? fgActive.hashCode() : 0);
        result = 31 * result + (dtCreate != null ? dtCreate.hashCode() : 0);
        result = 31 * result + (dtModify != null ? dtModify.hashCode() : 0);
        result = 31 * result + (zj != null ? zj.hashCode() : 0);
        return result;
    }
}
