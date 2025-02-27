public class Storage {
    private String mon, con, surname, first, mid, em, add, gen;
    private int day, yr;
    
    public Storage(String surname, String first, String mid, String em,String add, String gen, String mon,int day,int yr,int bytext, String con){
        this.surname = surname; this.first = first; this.mid = mid;
        this.mon = mon; this.day =day; this.yr = yr;
        this.gen = gen;
        this.con = con; this.em = em;
        this.add = add;
    }

    public void inforDisplay(){
        System.out.println("Patient: " + surname + "," + first + mid);
        System.out.println("Date of Birth: " + mon + " | " + day + " | " + yr);
        System.out.println("Gender: " + gen);
        System.out.println("Contact Number: " + con);
        System.out.println("Email: " + em);
        System.out.println("Address: " + add);
    }
}
