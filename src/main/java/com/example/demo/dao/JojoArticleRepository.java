package com.example.demo.dao;

import com.example.demo.entity.JojoArticle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/16  10:57.
 * @Modified by:
 */
public interface JojoArticleRepository extends JpaRepository<JojoArticle,String> {
}
