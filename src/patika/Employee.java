package patika;

public class Employee {
    private String name;
    private double salary;
    private int workHours;
    private int hireYear;

    public Employee() {
    }

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public int getHireYear() {
        return hireYear;
    }

    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", workHours=" + workHours +
                ", hireYear=" + hireYear +
                '}';
    }

    public double tax(double salary) {

        double vergisizMaas = 0;
        if (salary > 1000) {
            vergisizMaas = salary - salary * 0.03;//1000 tl den yuksek olan maasa %3 vergi uygulandi
        } else {
            vergisizMaas = salary;//1000 tl den az olan maasa vergi uygulanmadi
        }
        return vergisizMaas;
    }


    public int bonus(int shift) {

        int fazlaMesai = 0;
        if (shift > 40) {//40 saat ten fazlaysa if blogu calisir
            shift -= 40;//normal mesai saatinden bonusu ayirabilmek icin 40 saati cikaririz
            fazlaMesai = shift * 30 * 4;//fazla mesai haftalik olarak hesaplandigi icin ayliga cevirebilmek icin ekstra 4 ile carpildi
        }
        return fazlaMesai;
    }

    public double riseSalary(int year, double maas, int fazlaMesai) {

        int suAnKiYil = 2021;//referans yil
        int kidem = suAnKiYil - year;//referans yildan calisilan yil cikarildi
        double zamliMaas = 0;
        if (kidem < 10) {//10 yildan dusuk olan calisanlara %5
            zamliMaas = maas + (maas * 0.05) + fazlaMesai;
        } else if (kidem < 20) {//20 yildan dusuk olan calisanlara %10
            zamliMaas = maas + (maas * 0.10) + fazlaMesai;
        } else {//19 yildan fazla olan calisanlara %15
            zamliMaas = maas + (maas * 0.15) + fazlaMesai;
        }
        return zamliMaas;
    }

}
