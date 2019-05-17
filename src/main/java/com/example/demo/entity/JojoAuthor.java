package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;
import java.util.Set;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/16  10:39.
 * @Modified by:
 */
@Entity
@Table(name = "JOJO_AUTHOR")
public class JojoAuthor {
    private String id;
    private String name;
    private Long age;
    private Time birthday;

    private List<JojoArticle> jojoArticleSet;
    @OneToMany
    @JoinColumn(name = "AUTHOR_ID")
    public List<JojoArticle> getJojoArticleSet() {
        return jojoArticleSet;
    }

    public void setJojoArticleSet(List<JojoArticle> jojoArticleSet) {
        this.jojoArticleSet = jojoArticleSet;
    }

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "AGE")
    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Column(name = "BIRTHDAY")
    public Time getBirthday() {
        return birthday;
    }

    public void setBirthday(Time birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JojoAuthor that = (JojoAuthor) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JojoAuthor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", jojoArticleSet=" + jojoArticleSet +
                '}';
    }
}
