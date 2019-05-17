package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/16  10:39.
 * @Modified by:
 */
@Entity
@Table(name = "JOJO_ARTICLE")
public class JojoArticle {
    private String id;
    private String name;
    private String authorId;

    @Column(name = "AUTHOR_ID")
    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
   /*  private JojoAuthor jojoAuthor;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    public JojoAuthor getJojoAuthor() {
        return jojoAuthor;
    }

    public void setJojoAuthor(JojoAuthor jojoAuthor) {
        this.jojoAuthor = jojoAuthor;
    }*/

    @Override
    public String toString() {
        return "JojoArticle{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JojoArticle that = (JojoArticle) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }



    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

}
