import java.util.Date;

public class Note {
    private String lastName;
    private String name;
    private String patronymic;
    private String birthday;
    private long phone;
    private String sex;


    public Note(){
        this.lastName = null;
        this.name = null;
        this.patronymic = null;
        this.birthday = null;
        this.phone = 0;
        this.sex = null;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Приводит все параметры в ввиде строки
     * @return
     */
    public String toString(){
        return String.format("<%s><%s><%s><%s><%d><%s>", this.lastName, this.name, this.patronymic, this.birthday, this.phone, this.sex);
    }

}
