package entry;

import java.sql.Date;

public class Cost {

    private Integer costId;
    private Integer apartmentId;
    private String apartmentName;
    private String waterRate;
    private String electricCharge;
    private String whetherPay;
    private String agent;
    private Date paymentTime;

    public Cost() {
    }

    public Cost(Integer costId, Integer apartmentId, String apartmentName, String waterRate,
                String electricCharge, String whetherPay, String agent, Date paymentTime) {
        this.costId = costId;
        this.apartmentId = apartmentId;
        this.apartmentName = apartmentName;
        this.waterRate = waterRate;
        this.electricCharge = electricCharge;
        this.whetherPay = whetherPay;
        this.agent = agent;
        this.paymentTime = paymentTime;
    }

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public String getWaterRate() {
        return waterRate;
    }

    public void setWaterRate(String waterRate) {
        this.waterRate = waterRate;
    }

    public String getElectricCharge() {
        return electricCharge;
    }

    public void setElectricCharge(String electricCharge) {
        this.electricCharge = electricCharge;
    }

    public String getWhetherPay() {
        return whetherPay;
    }

    public void setWhetherPay(String whetherPay) {
        this.whetherPay = whetherPay;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "costId=" + costId +
                ", apartmentId=" + apartmentId +
                ", apartmentName='" + apartmentName + '\'' +
                ", waterRate='" + waterRate + '\'' +
                ", electricCharge='" + electricCharge + '\'' +
                ", whetherPay='" + whetherPay + '\'' +
                ", agent='" + agent + '\'' +
                ", paymentTime=" + paymentTime +
                '}';
    }
}
