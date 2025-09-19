package exercise1;

// the 5 instance variables
public class Singer {
    private int singerId;
    private String singerName;
    private String singerAddress;
    private String DOB;
    private int amountOfAlbums;

//constructor 1
          public Singer () {
           singerId = -1;
           singerName = "TylerTheCreator"; // Funny because it's my name as well
              singerAddress = "My House";
              DOB = "October 8th 2002";
}
//constructor 2
              public Singer (int singerId, String singerName, String singerAddress, String DOB, int amountOfAlbums){

              this.singerId = singerId;
              this.singerName = singerName;
              this.singerAddress = singerAddress;
              this.DOB = DOB;
              this.amountOfAlbums = amountOfAlbums;


          }
public int getSingerId() {
return singerId;
}

public void setSingerId(int singerId) {
this.singerId = singerId;
}
public String getSingerName() {
return singerName;
}
public void setSingerName(String singerName) {
this.singerName = singerName;
}
public String getSingerAddress() {
return singerAddress;
}
public void setSingerAddress(String singerAddress) {
this.singerAddress = singerAddress;
}
public String getDOB() {
return DOB;
}
public void setDOB(String DOB) {
this.DOB = DOB;
}
public int getAmountOfAlbums() {
return amountOfAlbums;
}
public void setAmountOfAlbums(int amountOfAlbums) {
this.amountOfAlbums = amountOfAlbums;
}
    public void setAllValues(int singerId, String singerName, String singerAddress, String DOB, int amountOfAlbums) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.DOB = DOB;
        this.amountOfAlbums = amountOfAlbums;
    }
}