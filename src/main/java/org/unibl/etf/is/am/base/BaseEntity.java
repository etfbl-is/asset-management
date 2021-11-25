package org.unibl.etf.is.am.base;

import java.io.Serializable;

public interface BaseEntity<ID extends Serializable> {
    void setId(ID id);
    ID getId();
}
