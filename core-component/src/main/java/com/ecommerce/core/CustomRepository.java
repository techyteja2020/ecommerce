package com.ecommerce.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomRepository<T> {
    protected final Map<String,T> repo = new HashMap();

    public T save(String id,T t){
        return repo.put(id,t);
    }

    public T findOne(String primaryKey){
        return repo.get(primaryKey);
    }

    public List<T> findAll(){
        ArrayList<T> values = new ArrayList<>(repo.values());
        return values;
    }

    public int count(){
        return repo.size();
    }

    public void delete(T entity){
        repo.remove(entity);
    }

    boolean exists(String primaryKey){
      return repo.containsKey(primaryKey);
    }

}
