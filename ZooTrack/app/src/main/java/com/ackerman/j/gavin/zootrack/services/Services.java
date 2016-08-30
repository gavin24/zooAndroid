package com.ackerman.j.gavin.zootrack.services;

import java.util.List;

/**
 * Created by gavin.ackerman on 2016-08-28.
 */
public interface Services <S, ID> {
    public S findById(ID id);

    public String save(S entity);

    public String update(S entity);

    public String delete(S entity);

    public List<S> findAll();
}
