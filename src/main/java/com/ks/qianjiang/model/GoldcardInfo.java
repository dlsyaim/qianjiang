package com.ks.qianjiang.model;

import java.io.Serializable;

/**
 * @author 
 * null
 */
public class GoldcardInfo implements Serializable {
    private Integer ID;

    private String serialNo;

    private String meterState;

    private String setUpTime;

    private String beseNum;

    private String readingNum;

    private String userName;

    private String address;

    private String userType;

    private String deviceId;

    private String valveState;

    private String sumUseGas;

    private String sumUseMoney;

    private String priceCode;

    private String sumRechargeAomunt;

    private String lastReadingTime;

    private String balance;

    private String meterNo;

    private String price;
    private String rechargeCount;
    private String voltage;
    private String signalStrength;


    private String lastRechargeAmount;

    private String lastRechargeDate;

    private static final long serialVersionUID = 1L;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getMeterState() {
        return meterState;
    }

    public void setMeterState(String meterState) {
        this.meterState = meterState;
    }

    public String getSetUpTime() {
        return setUpTime;
    }

    public void setSetUpTime(String setUpTime) {
        this.setUpTime = setUpTime;
    }

    public String getBeseNum() {
        return beseNum;
    }

    public void setBeseNum(String beseNum) {
        this.beseNum = beseNum;
    }

    public String getReadingNum() {
        return readingNum;
    }

    public void setReadingNum(String readingNum) {
        this.readingNum = readingNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getValveState() {
        return valveState;
    }

    public void setValveState(String valveState) {
        this.valveState = valveState;
    }

    public String getSumUseGas() {
        return sumUseGas;
    }

    public void setSumUseGas(String sumUseGas) {
        this.sumUseGas = sumUseGas;
    }

    public String getSumUseMoney() {
        return sumUseMoney;
    }

    public void setSumUseMoney(String sumUseMoney) {
        this.sumUseMoney = sumUseMoney;
    }

    public String getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(String priceCode) {
        this.priceCode = priceCode;
    }

    public String getSumRechargeAomunt() {
        return sumRechargeAomunt;
    }

    public void setSumRechargeAomunt(String sumRechargeAomunt) {
        this.sumRechargeAomunt = sumRechargeAomunt;
    }

    public String getLastReadingTime() {
        return lastReadingTime;
    }

    public void setLastReadingTime(String lastReadingTime) {
        this.lastReadingTime = lastReadingTime;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getMeterNo() {
        return meterNo;
    }

    public void setMeterNo(String meterNo) {
        this.meterNo = meterNo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getRechargeCount() {
        return rechargeCount;
    }

    public void setRechargeCount(String rechargeCount) {
        this.rechargeCount = rechargeCount;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(String signalStrength) {
        this.signalStrength = signalStrength;
    }
    public String getLastRechargeAmount() {
        return lastRechargeAmount;
    }

    public void setLastRechargeAmount(String lastRechargeAmount) {
        this.lastRechargeAmount = lastRechargeAmount;
    }

    public String getLastRechargeDate() {
        return lastRechargeDate;
    }

    public void setLastRechargeDate(String lastRechargeDate) {
        this.lastRechargeDate = lastRechargeDate;
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
        GoldcardInfo other = (GoldcardInfo) that;
        return (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
            && (this.getSerialNo() == null ? other.getSerialNo() == null : this.getSerialNo().equals(other.getSerialNo()))
            && (this.getMeterState() == null ? other.getMeterState() == null : this.getMeterState().equals(other.getMeterState()))
            && (this.getSetUpTime() == null ? other.getSetUpTime() == null : this.getSetUpTime().equals(other.getSetUpTime()))
            && (this.getBeseNum() == null ? other.getBeseNum() == null : this.getBeseNum().equals(other.getBeseNum()))
            && (this.getReadingNum() == null ? other.getReadingNum() == null : this.getReadingNum().equals(other.getReadingNum()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (this.getValveState() == null ? other.getValveState() == null : this.getValveState().equals(other.getValveState()))
            && (this.getSumUseGas() == null ? other.getSumUseGas() == null : this.getSumUseGas().equals(other.getSumUseGas()))
            && (this.getSumUseMoney() == null ? other.getSumUseMoney() == null : this.getSumUseMoney().equals(other.getSumUseMoney()))
            && (this.getPriceCode() == null ? other.getPriceCode() == null : this.getPriceCode().equals(other.getPriceCode()))
            && (this.getSumRechargeAomunt() == null ? other.getSumRechargeAomunt() == null : this.getSumRechargeAomunt().equals(other.getSumRechargeAomunt()))
            && (this.getLastReadingTime() == null ? other.getLastReadingTime() == null : this.getLastReadingTime().equals(other.getLastReadingTime()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getMeterNo() == null ? other.getMeterNo() == null : this.getMeterNo().equals(other.getMeterNo()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getRechargeCount() == null ? other.getRechargeCount() == null : this.getRechargeCount().equals(other.getRechargeCount()))
            && (this.getVoltage() == null ? other.getVoltage() == null : this.getVoltage().equals(other.getVoltage()))
            && (this.getSignalStrength() == null ? other.getSignalStrength() == null : this.getSignalStrength().equals(other.getSignalStrength()))
            && (this.getLastRechargeAmount() == null ? other.getLastRechargeAmount() == null : this.getLastRechargeAmount().equals(other.getLastRechargeAmount()))
            && (this.getLastRechargeDate() == null ? other.getLastRechargeDate() == null : this.getLastRechargeDate().equals(other.getLastRechargeDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getSerialNo() == null) ? 0 : getSerialNo().hashCode());
        result = prime * result + ((getMeterState() == null) ? 0 : getMeterState().hashCode());
        result = prime * result + ((getSetUpTime() == null) ? 0 : getSetUpTime().hashCode());
        result = prime * result + ((getBeseNum() == null) ? 0 : getBeseNum().hashCode());
        result = prime * result + ((getReadingNum() == null) ? 0 : getReadingNum().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getValveState() == null) ? 0 : getValveState().hashCode());
        result = prime * result + ((getSumUseGas() == null) ? 0 : getSumUseGas().hashCode());
        result = prime * result + ((getSumUseMoney() == null) ? 0 : getSumUseMoney().hashCode());
        result = prime * result + ((getPriceCode() == null) ? 0 : getPriceCode().hashCode());
        result = prime * result + ((getSumRechargeAomunt() == null) ? 0 : getSumRechargeAomunt().hashCode());
        result = prime * result + ((getLastReadingTime() == null) ? 0 : getLastReadingTime().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getMeterNo() == null) ? 0 : getMeterNo().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getRechargeCount() == null) ? 0 : getRechargeCount().hashCode());
        result = prime * result + ((getVoltage() == null) ? 0 : getVoltage().hashCode());
        result = prime * result + ((getSignalStrength() == null) ? 0 : getSignalStrength().hashCode());
        result = prime * result + ((getLastRechargeAmount() == null) ? 0 : getLastRechargeAmount().hashCode());
        result = prime * result + ((getLastRechargeDate() == null) ? 0 : getLastRechargeDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ID=").append(ID);
        sb.append(", serialNo=").append(serialNo);
        sb.append(", meterState=").append(meterState);
        sb.append(", setUpTime=").append(setUpTime);
        sb.append(", beseNum=").append(beseNum);
        sb.append(", readingNum=").append(readingNum);
        sb.append(", userName=").append(userName);
        sb.append(", address=").append(address);
        sb.append(", userType=").append(userType);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", valveState=").append(valveState);
        sb.append(", sumUseGas=").append(sumUseGas);
        sb.append(", sumUseMoney=").append(sumUseMoney);
        sb.append(", priceCode=").append(priceCode);
        sb.append(", sumRechargeAomunt=").append(sumRechargeAomunt);
        sb.append(", lastReadingTime=").append(lastReadingTime);
        sb.append(", balance=").append(balance);
        sb.append(", meterNo=").append(meterNo);
        sb.append(", price=").append(price);
        sb.append(", lastRechargeAmount=").append(lastRechargeAmount);
        sb.append(", lastRechargeDate=").append(lastRechargeDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}