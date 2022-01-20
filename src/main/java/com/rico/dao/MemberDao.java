package com.rico.dao;

import com.rico.model.FeMember;
import java.util.List;

/**
 *
 * @author Rico
 */
public interface MemberDao {

    public boolean insert(FeMember feMember);

    public boolean update(FeMember feMember);

    public boolean delete(FeMember feMember);

    public List<FeMember> getAllMember();
}
