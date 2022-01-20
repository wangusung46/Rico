package com.rico.dao;

import com.rico.model.FeMember;
import com.rico.model.FeTransaction;
import java.util.List;

/**
 *
 * @author Rico
 */
public interface TransactionDao {

    public boolean insert(FeTransaction feTransaction);

    public boolean update(FeTransaction feTransaction);

    public boolean delete(FeTransaction feTransaction);

    public List<FeTransaction> getAllTransaction();
}
