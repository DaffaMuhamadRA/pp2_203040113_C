/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import model.MyBatisUtil;
import model.ItemMapper;
import org.apache.ibatis.session.SqlSession;
import view.ItemView;
import controller.ItemController;

public class Main {
    public static void main(String[] args) {
        SqlSession session = MyBatisUtil.getSqlSession();
        ItemMapper mapper = session.getMapper(ItemMapper.class);

        ItemView view = new ItemView();
        new ItemController(view, mapper);

        view.setVisible(true);
    }
}