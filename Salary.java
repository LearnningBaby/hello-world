package Elements;

import java.sql.Date;

public class Salary {
    public String ID;
    public String name;
    public Date paydate;
    public float should_send;
    public float taken;
    public float overtime_pay;
    public float leave_deduct;
    public float sick_deduct;
    public float income_tax;
    public float state_tax;
    public float medical_insurance;
    public float retirement_insurance;
    public float advance_payment;
    public float real_wages;
    public String bank_account;
    public String bank_type;

    public Salary(String ID, String name, Date paydate, float should_send, float taken, float overtime_pay,
                  float leave_deduct, float sick_deduct, float income_tax, float state_tax, float medical_insurance,
                  float retirement_insurance, float advance_payment, float real_wages, String bank_account, String bank_type) {
        this.ID = ID;
        this.name = name;
        this.paydate = paydate;
        this.should_send = should_send;
        this.taken = taken;
        this.overtime_pay = overtime_pay;
        this.leave_deduct = leave_deduct;
        this.sick_deduct = sick_deduct;
        this.income_tax = income_tax;
        this.state_tax = state_tax;
        this.medical_insurance = medical_insurance;
        this.retirement_insurance = retirement_insurance;
        this.advance_payment = advance_payment;
        this.real_wages = real_wages;
        this.bank_account = bank_account;
        this.bank_type = bank_type;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public float getShould_send() {
        return should_send;
    }

    public void setShould_send(float should_send) {
        this.should_send = should_send;
    }

    public float getTaken() {
        return taken;
    }

    public void setTaken(float taken) {
        this.taken = taken;
    }

    public float getOvertime_pay() {
        return overtime_pay;
    }

    public void setOvertime_pay(float overtime_pay) {
        this.overtime_pay = overtime_pay;
    }

    public float getLeave_deduct() {
        return leave_deduct;
    }

    public void setLeave_deduct(float leave_deduct) {
        this.leave_deduct = leave_deduct;
    }

    public float getSick_deduct() {
        return sick_deduct;
    }

    public void setSick_deduct(float sick_deduct) {
        this.sick_deduct = sick_deduct;
    }

    public float getIncome_tax() {
        return income_tax;
    }

    public void setIncome_tax(float income_tax) {
        this.income_tax = income_tax;
    }

    public float getState_tax() {
        return state_tax;
    }

    public void setState_tax(float state_tax) {
        this.state_tax = state_tax;
    }

    public float getMedical_insurance() {
        return medical_insurance;
    }

    public void setMedical_insurance(float medical_insurance) {
        this.medical_insurance = medical_insurance;
    }

    public float getRetirement_insurance() {
        return retirement_insurance;
    }

    public void setRetirement_insurance(float retirement_insurance) {
        this.retirement_insurance = retirement_insurance;
    }

    public float getAdvance_payment() {
        return advance_payment;
    }

    public void setAdvance_payment(float advance_payment) {
        this.advance_payment = advance_payment;
    }

    public float getReal_wages() {
        return real_wages;
    }

    public void setReal_wages(float real_wages) {
        this.real_wages = real_wages;
    }

    public String getBank_account() {
        return bank_account;
    }

    public void setBank_account(String bank_account) {
        this.bank_account = bank_account;
    }

    public String getBank_type() {
        return bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", paydate=" + paydate +
                ", should_send=" + should_send +
                ", taken=" + taken +
                ", overtime_pay=" + overtime_pay +
                ", leave_deduct=" + leave_deduct +
                ", sick_deduct=" + sick_deduct +
                ", income_tax=" + income_tax +
                ", state_tax=" + state_tax +
                ", medical_insurance=" + medical_insurance +
                ", retirement_insurance=" + retirement_insurance +
                ", advance_payment=" + advance_payment +
                ", real_wages=" + real_wages +
                ", bank_account='" + bank_account + '\'' +
                ", bank_type='" + bank_type + '\'' +
                '}';
    }
}

