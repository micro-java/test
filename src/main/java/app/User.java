package app;

/**
 * Created by richard on 2017/6/1.
 */
public class User {
    private int id;
    private String name;
    private String phone;
    private String note;

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }
    public String getNote(){

        return note;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setNote(String note){
        this.note=note;
    }
    @Override
    public String toString(){
       // return  "hello world";
        return ("User [id=" + id + ", name=" + name + ", phone=" + phone +", note=" + note.replaceAll("\\n+"," ") + "]").replaceAll("\\W+"," ");
    }
}
