/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ac.za.cput.repository;

import java.util.List;

/**
 *
 * @author Student
 * @param <T>
 * @param <ID>
 */
public interface IRepository<T, ID> {
    T create(T t);

    T read(ID id);

    T update(T t);

    boolean delete(ID id);
    
    List<T> getAll();
}
