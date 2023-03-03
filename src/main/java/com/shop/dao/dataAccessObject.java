package com.shop.dao;

import java.util.List;

public interface DataAccessObject<T> {
  public int addObject(T obj);

  public List<T> returnAll();

  public List<T> findByParam(String param);

  public int updateParamById(int Id, String paramToUpdate, String newValue);

  public int deleteById(int TId);
}