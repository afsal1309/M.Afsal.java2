package Q02;

class Student {
    Student() { System.out.println("Student object is created"); }
}

class Commission {
    String name="John", address="Delhi";
    long phone=9876543210L;
    double sales=85000;

    void calc() {
        double c= (sales>=100000)?sales*0.1 : 
        	(sales>=50000)?sales*0.05 : 
        		(sales>=30000)?sales*0.03 : 0;
        System.out.println("Name:"+name+" Sales:"+sales+" Commission:"+c);
    }



    public static void main(String[] args) {
        new Student();
        new Commission().calc();
    }
}

