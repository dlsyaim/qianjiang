package com.ks.qianjiang.model;

import java.io.Serializable;

/**
 * @author 
 * null
 */
public class GoldcardDay implements Serializable {
    private Integer ID;

    private String useDate;

    private String price;

    private String useGas;

    private String useAmount;

    private String deviceId;

    private String meterNo;

    private static final long serialVersionUID = 1L;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUseDate() {
        return useDate;
    }

    public void setUseDate(String useDate) {
        this.useDate = useDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUseGas() {
        return useGas;
    }

    public void setUseGas(String useGas) {
        this.useGas = useGas;
    }

    public String getUseAmount() {
        return useAmount;
    }

    public void setUseAmount(String useAmount) {
        this.useAmount = useAmount;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo;
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
        GoldcardDay other = (GoldcardDay) that;
        return (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
            && (this.getUseDate() == null ? other.getUseDate() == null : this.getUseDate().equals(other.getUseDate()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getUseGas() == null ? other.getUseGas() == null : this.getUseGas().equals(other.getUseGas()))
            && (this.getUseAmount() == null ? other.getUseAmount() == null : this.getUseAmount().equals(other.getUseAmount()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (this.getMeterNo() == null ? other.getMeterNo() == null : this.getMeterNo().equals(other.getMeterNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getUseDate() == null) ? 0 : getUseDate().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getUseGas() == null) ? 0 : getUseGas().hashCode());
        result = prime * result + ((getUseAmount() == null) ? 0 : getUseAmount().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getMeterNo() == null) ? 0 : getMeterNo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ID=").append(ID);
        sb.append(", useDate=").append(useDate);
        sb.append(", price=").append(price);
        sb.append(", useGas=").append(useGas);
        sb.append(", useAmount=").append(useAmount);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", meterNo=").append(meterNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}