package patika;


import java.util.Scanner;

public class Options extends Employee {
    Scanner scan = new Scanner(System.in);
    Employee calisan;//olusturulan obje tum methodlardan kullanilmasi icin class seviyesinde olusturuldu

    public void giris() {//giris menusu calisan bilgileri aliniyor
        System.out.println("lutfen calisan bilgilerini giriniz");

        System.out.println("Calisan isim soyisim giriniz");
        String name = scan.nextLine();

        System.out.println("Calisan maas bilgisini giriniz");
        double salary = scan.nextDouble();

        System.out.println("Haftalik calisma saatini giriniz");
        int workHours = scan.nextInt();

        System.out.println("Ise giris yilinizi giriniz");
        int hireYear = scan.nextInt();

        calisan = new Employee(name, salary, workHours, hireYear);//obje olusturuluyor
        options();//options methodu cagiriliyor
    }

    public void options() {//yapmak istenilen islem secimi
        int secim;
        do {

            System.out.println("Yapmak istediginiz islemi seciniz");
            System.out.println("============================================================");
            System.out.println("Vergisiz maasi ogrenmek icin 1");
            System.out.println("Fazla mesai ogrenmek icin 2");
            System.out.println("Zamli maasi ogrenmek icin 3");
            System.out.println("Toplam maasi ogrenmek icin 4");
            System.out.println("Cikmak icin 0 seciniz");
            secim = scan.nextInt();
            System.out.println("calisan = " + calisan);//olusturulan obje istenilen menude tekrar yazilarak ilk girilen degerlerle hesaplanan degerler karsilastiriliyor
            System.out.println("=========================================================================================");

            double vergisizMaas = tax(calisan.getSalary());//tek parametreli tax methodundan donen degeri vergisizMaas variablena ataniyor
            int fazlaMesai = bonus(calisan.getWorkHours());//tek parametreli bonus methodundan donen degeri fazlaMesai variablene ataniyor
            double zamliMaas = riseSalary(calisan.getHireYear(), vergisizMaas, fazlaMesai);
            //riseSalary hesaplamasinda vergi ve fazlamesai goz onune alinmasi gerektigi icin 3 parametreli riseSalary methoduna
            //calisanin kidem yilini + vergi uygulanmis maasini + fazla mesaisini argument olarak ekleyerek hesaplamasi yapilir vedonen deger
            //zamliMaas variablena atamasi yapiliyor
            switch (secim) {
                case 0://0 secimi do-while loop un kirilmasini sagladigi icin case 0 eklenmistir(eklenmedigi zaman yine do-while loop u
                    break;//durduruyor fakat hatali secim hatasida veriyor)gelistirilebilir.
                case 1:
                    System.out.println("Vergi uygulandiktan sonra maasiniz: " + vergisizMaas + " TL'dir");//vergisiz maas yazdiriliyor
                    System.out.println("============================================================");
                    break;
                case 2:
                    System.out.println("Fazla mesainiz: " + fazlaMesai + " TL'dir");//fazla mesai yazdiriliyor
                    System.out.println("============================================================");
                    break;
                case 3:
                    System.out.println("Girdiginiz bilgilerden sonra zamli maasiniz: " + zamliMaas + " TL'dir");//zamli maas yazdiriliyor
                    System.out.println("============================================================");
                    break;
                case 4:
                    System.out.println("Toplam maasiniz: " + (vergisizMaas + fazlaMesai) + " TL'dir");//toplam maas (vergisiz maas + fazla mesai) yazdiriliyor
                    System.out.println("============================================================");

                default:
                    System.out.println("Hatali secim yaptiniz");
            }

        } while (secim != 0);


    }

}
