package in.advertiss.springjpahibernate.entity.emp;

import javax.persistence.Entity;

@Entity
public class ParttimeEmp extends Employee{

    private String hourlyPay;

    public ParttimeEmp() {
    }

    public ParttimeEmp(String hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    public ParttimeEmp(String name, String hourlyPay) {
        super(name);
        this.hourlyPay = hourlyPay;
    }

    public String getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(String hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    @Override
    public String toString() {
        return "ParttimeEmp{" +
                "hourlyPay='" + hourlyPay + '\'' +
                '}';
    }
}
