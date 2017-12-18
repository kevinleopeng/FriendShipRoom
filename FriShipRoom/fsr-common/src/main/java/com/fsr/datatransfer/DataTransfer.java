package com.fsr.datatransfer;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.List;

/**
 * Created by Hasee on 2017/5/11.
 */
public interface DataTransfer<T, E> {
    public Collection<E> transfer(Collection<T> list, Object... objs);
}
