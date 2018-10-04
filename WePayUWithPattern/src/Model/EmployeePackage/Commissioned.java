package Model.EmployeePackage;

import Model.*;

public class Commissioned extends Employee {
    double totalToBePaid;
    double comissionTax;
    double totalSales;
    double salary;

    private Commissioned(CommissionedBuilder commissionedBuilder) {
        super(commissionedBuilder);
        this.comissionTax = commissionedBuilder.comissionTax;
        this.salary = commissionedBuilder.salary;
        this.totalSales = commissionedBuilder.totalSales;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getTotalToBePaid() {
        return totalToBePaid;
    }

    public void setTotalToBePaid(double totalToBePaid) {
        this.totalToBePaid = totalToBePaid;
    }

    public double getComissionTax() {
        return comissionTax;
    }

    public void setComissionTax(double comissionTax) {
        this.comissionTax = comissionTax;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }


    @Override
    public String toString() {
        return "Type: Commissioned\n" + super.toString() +
                "Salary: " + salary + "\n" +
                "Commission Tax: " + comissionTax + "\n" +
                "To be paid: " + totalToBePaid + "\n";
    }

    //BUILDER
    public static class CommissionedBuilder extends EmployeeBuilder{
        double totalToBePaid;
        double comissionTax;
        double totalSales;
        double salary;

        public CommissionedBuilder() {
        }

        public CommissionedBuilder setTotalToBePaid(double totalToBePaid) {
            this.totalToBePaid = totalToBePaid;
            return this;
        }

        public CommissionedBuilder setComissionTax(double comissionTax) {
            this.comissionTax = comissionTax;
            return this;
        }

        public CommissionedBuilder setTotalSales(double totalSales) {
            this.totalSales = totalSales;
            return this;
        }

        public CommissionedBuilder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        @Override
        public CommissionedBuilder setID(int ID) {
            return (CommissionedBuilder)super.setID(ID);
        }

        @Override
        public CommissionedBuilder setName(String name) {
            return (CommissionedBuilder)super.setName(name);
        }

        @Override
        public CommissionedBuilder setAddress(Address address) {
            return (CommissionedBuilder)super.setAddress(address);
        }

        @Override
        public CommissionedBuilder setPaymentType(PaymentType paymentType) {
            return (CommissionedBuilder)super.setPaymentType(paymentType);
        }

        @Override
        public CommissionedBuilder setSyndicateMember(boolean syndicateMember) {
            return (CommissionedBuilder)super.setSyndicateMember(syndicateMember);
        }

        @Override
        public CommissionedBuilder setBanked(double banked) {
            return (CommissionedBuilder)super.setBanked(banked);
        }

        @Override
        public CommissionedBuilder setSyndicate(Syndicate syndicate) {
            return (CommissionedBuilder)super.setSyndicate(syndicate);
        }

        public Commissioned build(){
            return new Commissioned(this);
        }
    }
}
