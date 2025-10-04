package exercise1;

public class SingerDriver {
    public static void main(String[] args) {

        Singer singer1 = new Singer();


         System.out.println("Default values:");
          System.out.println("ID: " + singer1.getSingerId());
        System.out.println("Name: " + singer1.getSingerName());
        System.out.println("Address: " + singer1.getSingerAddress());
         System.out.println("DOB: " + singer1.getDOB());
           System.out.println("Albums: " + singer1.getAmountOfAlbums());

        // My Friend
        singer1.setAllValues(1, "Tyrone", "Toronto", "October 6th 2002", 6);


        System.out.println("\nAfter setAllValues:");
         System.out.println("ID: " + singer1.getSingerId());
        System.out.println("Name: " + singer1.getSingerName());
         System.out.println("Address: " + singer1.getSingerAddress());
           System.out.println("DOB: " + singer1.getDOB());
        System.out.println("Albums: " + singer1.getAmountOfAlbums());


         singer1.setSingerId(2);
        singer1.setSingerName("Drake");
          singer1.setSingerAddress("Toronto");
        singer1.setDOB("October 24, 1986");
           singer1.setAmountOfAlbums(20);


          System.out.println("\nAfter individual setters:");
        System.out.println("ID: " + singer1.getSingerId());
          System.out.println("Name: " + singer1.getSingerName());
          System.out.println("Address: " + singer1.getSingerAddress());
        System.out.println("DOB: " + singer1.getDOB());
        System.out.println("Albums: " + singer1.getAmountOfAlbums());
    }
}
