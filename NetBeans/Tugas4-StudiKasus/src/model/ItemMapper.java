package model;

import org.apache.ibatis.annotations.*;
import java.util.List;

public interface ItemMapper {
    @Select("SELECT * FROM items")
    List<Item> getAllItems();

    @Insert("INSERT INTO items (namaProduk, kategori, harga, stok) VALUES (#{namaProduk}, #{kategori}, #{harga}, #{stok})")
    void insertItem(Item item);

    @Update("UPDATE items SET namaProduk = #{namaProduk}, kategori = #{kategori}, harga = #{harga}, stok = #{stok} WHERE id = #{id}")
    void updateItem(Item item);

    @Delete("DELETE FROM items WHERE id = #{id}")
    void deleteItem(int id);
}