package app.dto;


public class PersonDto {
    private long iD;
    private long Document;
    private String name;
    private long CellPhoneNumber;

    public PersonDto() {
    }

    

    public long getiD() {
        return iD;
    }

    public void setiD(long iD) {
        this.iD = iD;
    }

    public long getDocument() {
        return Document;
    }

    public void setDocument(long Document) {
        this.Document = Document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCellPhoneNumber() {
        return CellPhoneNumber;
    }

    public void setCellPhoneNumber(long CellPhoneNumber) {
        this.CellPhoneNumber = CellPhoneNumber;
    }
    
   
    
}
