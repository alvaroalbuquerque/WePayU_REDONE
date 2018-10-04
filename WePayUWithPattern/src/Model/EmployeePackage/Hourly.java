package Model.EmployeePackage;

import Model.*;

public class Hourly extends Employee {
    double totalToBePaid;
    double normalTax;
    TimeCard timeCard;


    private Hourly(HourlyBuilder hourlyBuilder) {
        super(hourlyBuilder);
        this.normalTax = hourlyBuilder.normalTax;
        this.timeCard = hourlyBuilder.timeCard;
        this.totalToBePaid = hourlyBuilder.totalToBePaid;
    }

    public double getTotalToBePaid() {
        return totalToBePaid;
    }

    public void setTotalToBePaid(double totalToBePaid) {
        this.totalToBePaid = totalToBePaid;
    }

    public double getNormalTax() {
        return normalTax;
    }

    public void setNormalTax(double normalTax) {
        this.normalTax = normalTax;
    }

    public TimeCard getTimeCard() {
        return timeCard;
    }

    public void setTimeCard(TimeCard timeCard) {
        this.timeCard = timeCard;
    }

    @Override
    public String toString() {
        return "Type: Hourly\n" + super.toString() +
                "Normal Tax: " + normalTax + "\n" +
                "To be paid: " + totalToBePaid + "\n" +
                "Timecard: " + timeCard.getHoursWorked() + "hours\n";
    }

    //Builder
    public static class HourlyBuilder extends EmployeeBuilder{
        double totalToBePaid;
        double normalTax;
        TimeCard timeCard;

        public HourlyBuilder() {
            this.timeCard = new TimeCard();
        }

        public HourlyBuilder setTotalToBePaid(double totalToBePaid) {
            this.totalToBePaid = totalToBePaid;
            return this;
        }

        public HourlyBuilder setNormalTax(double normalTax) {
            this.normalTax = normalTax;
            return this;
        }

        public HourlyBuilder setTimeCard(TimeCard timeCard) {
            this.timeCard = timeCard;
            return this;
        }

        @Override
        public HourlyBuilder setID(int ID) {
            return (HourlyBuilder)super.setID(ID);
        }

        @Override
        public HourlyBuilder setName(String name) {
            return (HourlyBuilder)super.setName(name);
        }

        @Override
        public HourlyBuilder setAddress(Address address) {
            return (HourlyBuilder)super.setAddress(address);
        }

        @Override
        public HourlyBuilder setPaymentType(PaymentType paymentType) {
            return (HourlyBuilder)super.setPaymentType(paymentType);
        }

        @Override
        public HourlyBuilder setSyndicateMember(boolean syndicateMember) {
            return (HourlyBuilder)super.setSyndicateMember(syndicateMember);
        }

        @Override
        public HourlyBuilder setBanked(double banked) {
            return (HourlyBuilder)super.setBanked(banked);
        }

        @Override
        public HourlyBuilder setSyndicate(Syndicate syndicate) {
            return (HourlyBuilder)super.setSyndicate(syndicate);
        }

        public Hourly build(){
            return new Hourly(this);
        }
    }
}
