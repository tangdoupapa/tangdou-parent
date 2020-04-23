package com.tangdou.ihrm.system.service.impl;

import com.tangdou.common.base.request.PagerRequest;
import com.tangdou.common.service.impl.BaseServiceImpl;
import com.tangdou.ihrm.system.dao.entities.User;
import com.tangdou.ihrm.system.dao.repository.UserRepository;
import com.tangdou.ihrm.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 11:49
 * @Description: 用户管理service impl
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserRepository, User, String> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> findPage(PagerRequest pageRequest) {
        Specification<User> specification = buildSpecification(pageRequest);
        return userRepository.findAll(specification, getPageable(pageRequest));
    }
}
