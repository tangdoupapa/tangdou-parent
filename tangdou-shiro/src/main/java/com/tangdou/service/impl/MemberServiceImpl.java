package com.tangdou.service.impl;

import com.tangdou.common.service.impl.BaseServiceImpl;
import com.tangdou.dao.IMemberDAO;
import com.tangdou.entity.Member;
import com.tangdou.service.IMemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class MemberServiceImpl extends BaseServiceImpl<IMemberDAO, Member, String> implements IMemberService {
    @Resource
    private IMemberDAO memberDAO;

    @Override
    public Member get(String mid) throws Exception {
        return this.memberDAO.findById(mid);
    }

    @Override
    public Map<String, Object> listAuthByMember(String mid) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("allRoles", this.memberDAO.findAllRoleByMember(mid));
        map.put("allActions", this.memberDAO.findAllActionByMember(mid));
        return map;
    }

}
