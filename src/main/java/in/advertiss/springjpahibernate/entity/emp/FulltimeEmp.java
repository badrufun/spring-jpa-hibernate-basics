package in.advertiss.springjpahibernate.entity.emp;

import javax.persistence.Entity;

@Entity
public class FulltimeEmp extends Employee{

    private String monthlyPay;

    public FulltimeEmp() {
    }

    public FulltimeEmp(String name, String monthlyPay) {
        super(name);
        this.monthlyPay = monthlyPay;
    }

    public String getMonthlyPay() {
        return monthlyPay;
    }

    public void setMonthlyPay(String monthlyPay) {
        this.monthlyPay = monthlyPay;
    }

    @Override
    public String toString() {
        return "FulltimeEmp{" +
                "monthlyPay='" + monthlyPay + '\'' +
                '}';
    }
}
