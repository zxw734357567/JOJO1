package com.example.demo.dao;

import com.example.demo.entity.JojoAuthor;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/16  10:58.
 * @Modified by:
 */
public interface JojoAuthorRepository extends JpaRepository<JojoAuthor, String> {

    @Query("select  jo from JojoAuthor jo left join fetch jo.jojoArticleSet  ")
    List<JojoAuthor> queryForFetch();


}
