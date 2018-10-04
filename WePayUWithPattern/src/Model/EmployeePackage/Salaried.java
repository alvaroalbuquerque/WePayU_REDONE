package Model.EmployeePackage;

import Model.*;

public class Salaried extends Employee{
    double paymentTotal;
    double salary;

    private Salaried(SalariedBuilder salariedBuilder) {
        super(salariedBuilder);
        this.salary = salariedBuilder.salary;
    }

    public double getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(double paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Type: Salaried\n" + super.toString() + "Salary: " + salary + "\n";
    }

    public static class SalariedBuilder extends EmployeeBuilder {
        double paymentTotal;
        double salary;

        public SalariedBuilder() {
        }

        public SalariedBuilder setPaymentTotal(double paymentTotal) {
            this.paymentTotal = paymentTotal;
            return this;
        }

        public SalariedBuilder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        @Override
        public SalariedBuilder setID(int ID) {
            return (SalariedBuilder)super.setID(ID);
        }

        @Override
        public SalariedBuilder setName(String name) {
            return (SalariedBuilder)super.setName(name);
        }

        @Override
        public SalariedBuilder setAddress(Address address) {
            return (SalariedBuilder)super.setAddress(address);
        }

        @Override
        public SalariedBuilder setPaymentType(PaymentType paymentType) {
            return (SalariedBuilder)super.setPaymentType(paymentType);
        }

        @Override
        public SalariedBuilder setSyndicateMember(boolean syndicateMember) {
            return (SalariedBuilder)super.setSyndicateMember(syndicateMember);
        }

        @Override
        public SalariedBuilder setBanked(double banked) {
            return (SalariedBuilder)super.setBanked(banked);
        }

        @Override
        public SalariedBuilder setSyndicate(Syndicate syndicate) {
            return (SalariedBuilder)super.setSyndicate(syndicate);
        }

        public Salaried build(){
            return new Salaried(this);
        }
    }
}
