package entity;

public class Student {

    private Integer id;
    private Integer groupId;
    private String name;
    private String surname;
    private Integer age;

    public Student(Integer groupId, String name, String surname, Integer age) {
        this.groupId = groupId;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Student(Integer id, Integer groupId, String name, String surname, Integer age) {
        this.id = id;
        this.groupId = groupId;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getGroupId() {
        return groupId;
    }
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}
