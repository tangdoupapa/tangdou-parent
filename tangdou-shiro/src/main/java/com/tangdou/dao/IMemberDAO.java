package com.tangdou.dao;

import com.tangdou.common.dao.BaseRepository;
import com.tangdou.entity.Member;

import java.util.Set;


public interface IMemberDAO extends BaseRepository<Member, String> {

    Member findById(String mid);

    Set<String> findAllRoleByMember(String mid);

    Set<String> findAllActionByMember(String mid);
}
