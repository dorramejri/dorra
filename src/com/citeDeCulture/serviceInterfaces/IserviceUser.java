
package com.citeDeCulture.serviceInterfaces;

import java.util.List;

/**
 *
 * @author rzitouni
 */
public interface IserviceUser<T> {
    void insert(T t );
    void delete(int a) ; 
    void update(T t,int a ) ; 
    List<T> GetAll() ;
  //  T get(T t) ; 
}
