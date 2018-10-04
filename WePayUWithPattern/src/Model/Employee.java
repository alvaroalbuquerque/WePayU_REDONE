package Model;

import Methods.Strategy.Strategy;

public class Employee {
    protected int ID;
    protected String name;
    protected Address address;
    protected PaymentType paymentType;
    protected boolean syndicateMember;
    protected double banked;
    protected Syndicate syndicate;
    protected Strategy strategy;

    protected Employee(EmployeeBuilder employeeBuilder) {
        this.name = employeeBuilder.name;
        this.address = employeeBuilder.address;
        this.paymentType = employeeBuilder.paymentType;
        this.syndicate = employeeBuilder.syndicate;
        this.banked = employeeBuilder.banked;
        this.syndicateMember = employeeBuilder.syndicateMember;
        this.strategy = employeeBuilder.strategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Syndicate getSyndicate() {
        return syndicate;
    }

    public void setSyndicate(Syndicate syndicate) {
        this.syndicate = syndicate;
    }

    public boolean isSyndicateMember() {
        return syndicateMember;
    }

    public void setSyndicateMember(boolean syndicateMember) {
        this.syndicateMember = syndicateMember;
    }

    public double getBanked() {
        return banked;
    }

    public void setBanked(double banked) {
        this.banked = banked;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public String syndicateMemberToString() {
        if (syndicateMember) {
            return "Is part of a Syndicate\n";
        } else {
            return "Is not part of a Syndicate\n";
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Address: " + address.getStreet() + ", " + address.getNumber() + "\n" +
                "Syndicate Status: " + syndicateMemberToString() +
                "Banked: " + banked + "\n" +
                "Payment Type:\n" + paymentType;
    }
    //Builder
    public static class EmployeeBuilder{
        int ID;
        String name;
        Address address;
        PaymentType paymentType;
        boolean syndicateMember;
        double banked;
        Syndicate syndicate;
        Strategy strategy;

        public EmployeeBuilder() {
            this.syndicate = new Syndicate(0);
        }

        public EmployeeBuilder setID(int ID) {
            this.ID = ID;
            return this;
        }

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder setPaymentType(PaymentType paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public EmployeeBuilder setSyndicateMember(boolean syndicateMember) {
            this.syndicateMember = syndicateMember;
            return this;
        }

        public EmployeeBuilder setBanked(double banked) {
            this.banked = banked;
            return this;
        }

        public EmployeeBuilder setSyndicate(Syndicate syndicate) {
            this.syndicate = syndicate;
            return this;
        }

        public EmployeeBuilder setStrategy(Strategy strategy) {
            this.strategy = strategy;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}
