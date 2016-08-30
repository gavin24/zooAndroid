package com.ackerman.j.gavin.zootrack.Repository;

import java.util.List;

/**
 * Created by gavin.ackerman on 2016-08-21.
 */
public interface RestApi<S, ID>  {
    S get(ID id);

    String post(S entity);

    String put(S entity);

    String delete(S entity);

    List<S> getAll();
}
