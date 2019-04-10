package com.example.demo.entity;

import org.hibernate.annotations.Entity;

/**学习JPA框架
 *  优点:
 *  1.标准化 JPA 是 JCP 组织发布的 Java EE 标准之一，因此任何声称符合 JPA 标准的框架都遵循同样的架构，提供相同的访问API，
 *    这保证了基于JPA开发的企业应用能够经过少量的修改就能够在不同的JPA框架下运行。
 *  2.容器级特性的支持 JPA框架中支持大数据集、事务、并发等容器级事务，这使得 JPA 超越了简单持久化框架的局限，
 *    在企业应用发挥更大的作用
 *  3.简单方便 JPA的主要目标之一就是提供更加简单的编程模型：在JPA框架下创建实体和创建Java 类一样简单，
 *    没有任何的约束和限制，只需要使用
 *  4.JPA的查询语言是面向对象而非面向数据库的，它以面向对象的自然语法构造查询语句，可以看成是Hibernate HQL的等价物。
 *    JPA定义了独特的JPQL（Java Persistence Query Language），JPQL是EJB QL的一种扩展，它是针对实体的一种查询语言，操作对象是实体，
 *    而不是关系数据库的表，而且能够支持批量更新和修改、JOIN、GROUP BY、HAVING 等通常只有 SQL 才能够提供的高级查询特性，甚至还能够支持子查询
 *  5.高级特性 JPA 中能够支持面向对象的高级特性，如类之间的继承、多态和类之间的复杂关系，这样的支持能够让开发者最大限度的使用面向对象的模型设计企业应用，
 *    而不需要自行处理这些特性在关系数据库的持久化。
 */

public class ExampleJpa {
}
