package com.ks.qianjiang.model;

import java.io.Serializable;

/**
 * KS_PrcCmnEquipReal
 * @author 
 */
public class KsPrccmnequipreal implements Serializable {
    private Integer prccmnequiprealid;

    private String brandname;

    private Integer classid;

    private String classname;

    private Integer id;

    private String name;

    private String districtname;

    private Integer siteid;

    private String sitename;

    private String ramcode;

    private String equipmentname;

    private String flowrange;

    private Integer equipmentidreal;

    private String datasource;

    private String addtime;

    private Integer equipmentid;

    private Double p;

    private Double batteryvoltage;

    private String onlinestatus;

    private String coltime;

    private static final long serialVersionUID = 1L;

    public Integer getPrccmnequiprealid() {
        return prccmnequiprealid;
    }

    public void setPrccmnequiprealid(Integer prccmnequiprealid) {
        this.prccmnequiprealid = prccmnequiprealid;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }

    public Integer getSiteid() {
        return siteid;
    }

    public void setSiteid(Integer siteid) {
        this.siteid = siteid;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public String getRamcode() {
        return ramcode;
    }

    public void setRamcode(String ramcode) {
        this.ramcode = ramcode;
    }

    public String getEquipmentname() {
        return equipmentname;
    }

    public void setEquipmentname(String equipmentname) {
        this.equipmentname = equipmentname;
    }

    public String getFlowrange() {
        return flowrange;
    }

    public void setFlowrange(String flowrange) {
        this.flowrange = flowrange;
    }

    public Integer getEquipmentidreal() {
        return equipmentidreal;
    }

    public void setEquipmentidreal(Integer equipmentidreal) {
        this.equipmentidreal = equipmentidreal;
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public Integer getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(Integer equipmentid) {
        this.equipmentid = equipmentid;
    }

    public Double getP() {
        return p;
    }

    public void setP(Double p) {
        this.p = p;
    }

    public Double getBatteryvoltage() {
        return batteryvoltage;
    }

    public void setBatteryvoltage(Double batteryvoltage) {
        this.batteryvoltage = batteryvoltage;
    }

    public String getOnlinestatus() {
        return onlinestatus;
    }

    public void setOnlinestatus(String onlinestatus) {
        this.onlinestatus = onlinestatus;
    }

    public String getColtime() {
        return coltime;
    }

    public void setColtime(String coltime) {
        this.coltime = coltime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        KsPrccmnequipreal other = (KsPrccmnequipreal) that;
        return (this.getPrccmnequiprealid() == null ? other.getPrccmnequiprealid() == null : this.getPrccmnequiprealid().equals(other.getPrccmnequiprealid()))
            && (this.getBrandname() == null ? other.getBrandname() == null : this.getBrandname().equals(other.getBrandname()))
            && (this.getClassid() == null ? other.getClassid() == null : this.getClassid().equals(other.getClassid()))
            && (this.getClassname() == null ? other.getClassname() == null : this.getClassname().equals(other.getClassname()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDistrictname() == null ? other.getDistrictname() == null : this.getDistrictname().equals(other.getDistrictname()))
            && (this.getSiteid() == null ? other.getSiteid() == null : this.getSiteid().equals(other.getSiteid()))
            && (this.getSitename() == null ? other.getSitename() == null : this.getSitename().equals(other.getSitename()))
            && (this.getRamcode() == null ? other.getRamcode() == null : this.getRamcode().equals(other.getRamcode()))
            && (this.getEquipmentname() == null ? other.getEquipmentname() == null : this.getEquipmentname().equals(other.getEquipmentname()))
            && (this.getFlowrange() == null ? other.getFlowrange() == null : this.getFlowrange().equals(other.getFlowrange()))
            && (this.getEquipmentidreal() == null ? other.getEquipmentidreal() == null : this.getEquipmentidreal().equals(other.getEquipmentidreal()))
            && (this.getDatasource() == null ? other.getDatasource() == null : this.getDatasource().equals(other.getDatasource()))
            && (this.getAddtime() == null ? other.getAddtime() == null : this.getAddtime().equals(other.getAddtime()))
            && (this.getEquipmentid() == null ? other.getEquipmentid() == null : this.getEquipmentid().equals(other.getEquipmentid()))
            && (this.getP() == null ? other.getP() == null : this.getP().equals(other.getP()))
            && (this.getBatteryvoltage() == null ? other.getBatteryvoltage() == null : this.getBatteryvoltage().equals(other.getBatteryvoltage()))
            && (this.getOnlinestatus() == null ? other.getOnlinestatus() == null : this.getOnlinestatus().equals(other.getOnlinestatus()))
            && (this.getColtime() == null ? other.getColtime() == null : this.getColtime().equals(other.getColtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPrccmnequiprealid() == null) ? 0 : getPrccmnequiprealid().hashCode());
        result = prime * result + ((getBrandname() == null) ? 0 : getBrandname().hashCode());
        result = prime * result + ((getClassid() == null) ? 0 : getClassid().hashCode());
        result = prime * result + ((getClassname() == null) ? 0 : getClassname().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDistrictname() == null) ? 0 : getDistrictname().hashCode());
        result = prime * result + ((getSiteid() == null) ? 0 : getSiteid().hashCode());
        result = prime * result + ((getSitename() == null) ? 0 : getSitename().hashCode());
        result = prime * result + ((getRamcode() == null) ? 0 : getRamcode().hashCode());
        result = prime * result + ((getEquipmentname() == null) ? 0 : getEquipmentname().hashCode());
        result = prime * result + ((getFlowrange() == null) ? 0 : getFlowrange().hashCode());
        result = prime * result + ((getEquipmentidreal() == null) ? 0 : getEquipmentidreal().hashCode());
        result = prime * result + ((getDatasource() == null) ? 0 : getDatasource().hashCode());
        result = prime * result + ((getAddtime() == null) ? 0 : getAddtime().hashCode());
        result = prime * result + ((getEquipmentid() == null) ? 0 : getEquipmentid().hashCode());
        result = prime * result + ((getP() == null) ? 0 : getP().hashCode());
        result = prime * result + ((getBatteryvoltage() == null) ? 0 : getBatteryvoltage().hashCode());
        result = prime * result + ((getOnlinestatus() == null) ? 0 : getOnlinestatus().hashCode());
        result = prime * result + ((getColtime() == null) ? 0 : getColtime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", prccmnequiprealid=").append(prccmnequiprealid);
        sb.append(", brandname=").append(brandname);
        sb.append(", classid=").append(classid);
        sb.append(", classname=").append(classname);
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", districtname=").append(districtname);
        sb.append(", siteid=").append(siteid);
        sb.append(", sitename=").append(sitename);
        sb.append(", ramcode=").append(ramcode);
        sb.append(", equipmentname=").append(equipmentname);
        sb.append(", flowrange=").append(flowrange);
        sb.append(", equipmentidreal=").append(equipmentidreal);
        sb.append(", datasource=").append(datasource);
        sb.append(", addtime=").append(addtime);
        sb.append(", equipmentid=").append(equipmentid);
        sb.append(", p=").append(p);
        sb.append(", batteryvoltage=").append(batteryvoltage);
        sb.append(", onlinestatus=").append(onlinestatus);
        sb.append(", coltime=").append(coltime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}