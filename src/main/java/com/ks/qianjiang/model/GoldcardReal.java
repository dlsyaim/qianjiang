package com.ks.qianjiang.model;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.tomcat.util.json.JSONParser;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.Serializable;

/**
 * @author 
 * null
 */
public class GoldcardReal implements Serializable {
    private Integer id;

    private String summoney;

    private String readnum;

    private String userarchivesnum;

    private String valvestate;

    private String readdate;

    private String meterbalance;

    private String gasmeterno;

    private String deviceid;

    private String sumgas;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSummoney() {
        return summoney;
    }

    public void setSummoney(String summoney) {
        this.summoney = summoney;
    }

    public String getReadnum() {
        return readnum;
    }

    public void setReadnum(String readnum) {
        this.readnum = readnum;
    }

    public String getUserarchivesnum() {
        return userarchivesnum;
    }

    public void setUserarchivesnum(String userarchivesnum) {
        this.userarchivesnum = userarchivesnum;
    }

    public String getValvestate() {
        return valvestate;
    }

    public void setValvestate(String valvestate) {
        this.valvestate = valvestate;
    }

    public String getReaddate() {
        return readdate;
    }

    public void setReaddate(String readdate) {
        this.readdate = readdate;
    }

    public String getMeterbalance() {
        return meterbalance;
    }

    public void setMeterbalance(String meterbalance) {
        this.meterbalance = meterbalance;
    }

    public String getGasmeterno() {
        return gasmeterno;
    }

    public void setGasmeterno(String gasmeterno) {
        this.gasmeterno = gasmeterno;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getSumgas() {
        return sumgas;
    }

    public void setSumgas(String sumgas) {
        this.sumgas = sumgas;
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
        GoldcardReal other = (GoldcardReal) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSummoney() == null ? other.getSummoney() == null : this.getSummoney().equals(other.getSummoney()))
            && (this.getReadnum() == null ? other.getReadnum() == null : this.getReadnum().equals(other.getReadnum()))
            && (this.getUserarchivesnum() == null ? other.getUserarchivesnum() == null : this.getUserarchivesnum().equals(other.getUserarchivesnum()))
            && (this.getValvestate() == null ? other.getValvestate() == null : this.getValvestate().equals(other.getValvestate()))
            && (this.getReaddate() == null ? other.getReaddate() == null : this.getReaddate().equals(other.getReaddate()))
            && (this.getMeterbalance() == null ? other.getMeterbalance() == null : this.getMeterbalance().equals(other.getMeterbalance()))
            && (this.getGasmeterno() == null ? other.getGasmeterno() == null : this.getGasmeterno().equals(other.getGasmeterno()))
            && (this.getDeviceid() == null ? other.getDeviceid() == null : this.getDeviceid().equals(other.getDeviceid()))
            && (this.getSumgas() == null ? other.getSumgas() == null : this.getSumgas().equals(other.getSumgas()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSummoney() == null) ? 0 : getSummoney().hashCode());
        result = prime * result + ((getReadnum() == null) ? 0 : getReadnum().hashCode());
        result = prime * result + ((getUserarchivesnum() == null) ? 0 : getUserarchivesnum().hashCode());
        result = prime * result + ((getValvestate() == null) ? 0 : getValvestate().hashCode());
        result = prime * result + ((getReaddate() == null) ? 0 : getReaddate().hashCode());
        result = prime * result + ((getMeterbalance() == null) ? 0 : getMeterbalance().hashCode());
        result = prime * result + ((getGasmeterno() == null) ? 0 : getGasmeterno().hashCode());
        result = prime * result + ((getDeviceid() == null) ? 0 : getDeviceid().hashCode());
        result = prime * result + ((getSumgas() == null) ? 0 : getSumgas().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", summoney=").append(summoney);
        sb.append(", readnum=").append(readnum);
        sb.append(", userarchivesnum=").append(userarchivesnum);
        sb.append(", valvestate=").append(valvestate);
        sb.append(", readdate=").append(readdate);
        sb.append(", meterbalance=").append(meterbalance);
        sb.append(", gasmeterno=").append(gasmeterno);
        sb.append(", deviceid=").append(deviceid);
        sb.append(", sumgas=").append(sumgas);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
    public static GoldcardReal fromJson(JSONObject jsonObject){
        GoldcardReal g = new GoldcardReal();
       // JsonObject obj = new JsonParser().parse(jsonObject.toString().toLowerCase()).getAsJsonObject();

        try{

            g.summoney = jsonObject.get("sumMoney").toString();
            g.readnum = jsonObject.get("readNum").toString();
            g.userarchivesnum = jsonObject.get("userArchivesNum").toString();
            g.valvestate = jsonObject.get("valveState").toString();
            g.readdate = jsonObject.get("readDate").toString();
            g.meterbalance = jsonObject.get("meterBalance").toString();
            g.gasmeterno = jsonObject.get("gasMeterNo").toString();
            g.deviceid = jsonObject.get("deviceId").toString();
            g.sumgas = jsonObject.get("sumGas").toString();


        }catch (JsonIOException | JSONException e){
            e.printStackTrace();
            return null;
        }

        return  g;
    }
}