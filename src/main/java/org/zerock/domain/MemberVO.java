package org.zerock.domain;

public class MemberVO {

    public MemberVO() {
        super();
    }

    public MemberVO(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    String    id;
    String    name;
    int       age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MemberVO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
