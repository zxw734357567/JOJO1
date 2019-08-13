package com.example.demo.common;

import com.example.demo.Dto.UserTree;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class TreeStructureUtil {

    /**
    *@Description 遍历生成一级目录
    *@Param * @param null
    *@Return
    *@Author zhangxw
    *@Date 2019/8/13
    *@Time 11:39
    */
   public static List<UserTree>  getTree(List<UserTree> oldTree,Long parentId){
       List<UserTree> newTree =new ArrayList<>();
       if(oldTree==null || oldTree.isEmpty()){
           return newTree;
       }

       //第一级节点
       if(parentId.equals(0)){
           for (UserTree item:oldTree){
               if(item.getPid().equals(item.getId())){
                   newTree.add(item);
               }
           }
       }else{
           //不是第一级节点
           for (UserTree item:oldTree){
               if(item.getPid()==parentId){
                   UserTree userTree=new UserTree();
                   BeanUtils.copyProperties(item,userTree);
                   newTree.add(userTree);
               }
           }
       }
         for(UserTree newItem:newTree){
             newItem=recursiveTree(newItem,oldTree);
         }
       return newTree;
    }

    public static UserTree recursiveTree(UserTree parent,List<UserTree> oldTree){

    for(UserTree item:oldTree){
        if(parent.getId()==item.getPid()){
            item = recursiveTree(item, oldTree);
            parent.getChildNode().add(item);
        }

    }
    return parent;
    }
}
