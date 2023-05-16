package model;

/**
 *
 */
public class Client {

    private int id;
    private String name;
    private String address;
    private String email;
    private int age;

    public Client(){

    }

    /**
     * @param id  id  client
     * @param name nume
     * @param address
     * @param email
     * @param age
     */
    public Client(int id, String name, String address, String email, int age) {

        this.id=id;
        this.name=name;
        this.address= address;
        this.email=email;
        this.age=age;

    }

    /**
     * @param name -
     * @param address-
     * @param email-
     * @param age-
     */
    public Client(String name, String address, String email, int age) {

        this.name=name;
        this.address= address;
        this.email=email;
        this.age=age;

    }

    /**
     * @return returneaza id client
     */
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    /**
     * @return returneaza numele
     */
    public String getName(){
        return name;
    }

    /**
     * @param name nume setat
     */
    public void setName(String name){
        this.name=name;
    }

    /**
     * @return getaddress
     */
    public String getAddress(){
        return address;
    }

    /**
     * @param address set address
     */
    public void setAddress(String address){
        this.address=address;
    }

    /**
     * @return email
     */
    public String getEmail(){
        return email;
    }

    /**
     * @param email seteaza email
     */
    public void setEmail(String email){
        this.email=email;
    }

    /**
     * @return retureana varsta
     */
    public int getAge(){
        return age;
    }

    /**
     * @param age seteaza varsta
     */
    public void setAge(int age){
        this.age=age;
    }

    /**
     * @return toString
     */
    @Override
    public String toString(){
        return "Client: id  "+id+" - name "+name;
    }
}
