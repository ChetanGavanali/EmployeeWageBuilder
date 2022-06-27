package com.bridgelabz;

import java.util.ArrayList;

interface EmpWageBuilder {

    public void wageComputation( Companyempwage obj );
}


public class EmployeeWage implements EmpWageBuilder{

    final int is_Part_Time = 1;
    final int is_Full_Time = 2;

    ArrayList<Integer> empDailyMonthlyTotalWage = new ArrayList<Integer>();

    public void wageComputation(Companyempwage companyEmployee){
        System.out.println(companyEmployee.getCompanyName()+" Employee Wage Computation");

        int empHrs = 0;
        int totalEmpHrs = 0;
        int totalWorkDay = 0;
        int totalEmpWage = 0;
        int empDailyWage = 0;
        while (totalWorkDay < companyEmployee.getNumOfWorkingDays() && totalEmpHrs <= companyEmployee.getMaxHrsInMonth()) {

            int employee = (int) ((Math.random() * 10) % 3);

            switch (employee) {
                case is_Part_Time:
                    empHrs = 4;
                    break;
                case is_Full_Time:
                    empHrs = 8;
                    break;
                default:
                    empHrs = 0;
            }
            totalWorkDay++;
            totalEmpHrs = totalEmpHrs + empHrs;
            empDailyWage = empHrs * companyEmployee.getEmpRatePerHour();
            empDailyMonthlyTotalWage.add( empDailyWage );
            System.out.println("Day:"+totalWorkDay +" Wage is : "+empDailyWage );
        }
        totalEmpWage=( totalEmpHrs * companyEmployee.getEmpRatePerHour());
        empDailyMonthlyTotalWage.add( totalEmpWage );
        companyEmployee.setTotalEmpWage( totalEmpWage );
        System.out.println("Employee Monthly Total  Wage of " + companyEmployee.getCompanyName() + " is " + companyEmployee.getTotalEmpWage());
    }

    public static void main(String arg[]) {

        System.out.println();
        EmployeeWage emp = new EmployeeWage();

        ArrayList<Companyempwage> company = new ArrayList<Companyempwage>();

        company.add( new Companyempwage( "Asus", 40, 20, 100 ));
        emp.wageComputation(company.get(0));
        System.out.println();
        company.add( new Companyempwage( "Dell", 30, 22, 120 ));
        emp.wageComputation(company.get(1));
        System.out.println();
        company.add( new Companyempwage( "HP", 45, 18, 90 ));
        emp.wageComputation(company.get(2));
    }
}

class Companyempwage{

    public String companyName=" ";
    public int empRatePerHr=0;
    public int noOfWorkDay=0;
    public int maxHrsInMonth=0;

    public int totalEmpWage=0;

    public Companyempwage(String companyName, int empRatePerHr, int noOfWorkDay, int maxHrsInMonth){
        this.companyName=companyName;
        this.empRatePerHr=empRatePerHr;
        this.noOfWorkDay=noOfWorkDay;
        this.maxHrsInMonth=maxHrsInMonth;
    }

    public String getCompanyName(){
        return companyName;
    }
    public int getEmpRatePerHour(){
        return empRatePerHr;
    }

    public int getNumOfWorkingDays(){
        return noOfWorkDay;
    }

    public int getMaxHrsInMonth(){
        return maxHrsInMonth;
    }

    public void setTotalEmpWage( int totalEmpWage ){
        this.totalEmpWage = totalEmpWage;
    }

    public int getTotalEmpWage(){
        return totalEmpWage;
    }

}