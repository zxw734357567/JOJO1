package com.example.demo;

import com.example.demo.entity.HiSysRoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/4/11  16:20.
 * @Modified by:
 */
public class Test1 {
    public static void main(String[] args) {
        String a=null;
        String[] split = a.split(",");
        for (int i=0;i<split.length;i++){
            System.out.println(split[i]);
        }

        HiSysRoEntity hiSysRoEntity=new HiSysRoEntity();
        hiSysRoEntity.setCd("123");
        hiSysRoEntity.setDes("快乐");

        HiSysRoEntity hiSysRoEntity1=new HiSysRoEntity();
        hiSysRoEntity1.setCd("456");
        hiSysRoEntity1.setDes("快乐");
        List<HiSysRoEntity> list=new ArrayList<>();
        list.add(hiSysRoEntity);
        list.add(hiSysRoEntity1);

    }
}
