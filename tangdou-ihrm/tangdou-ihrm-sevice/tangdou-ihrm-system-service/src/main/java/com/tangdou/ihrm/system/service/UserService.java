package com.tangdou.ihrm.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tangdou.common.request.PagerRequest;
import com.tangdou.common.service.BaseService;
import com.tangdou.ihrm.system.dao.entities.User;
import com.tangdou.ihrm.system.dao.repository.UserRepository;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 10:02
 * @Description: 用户管理service
 */
public interface UserService extends BaseService<UserRepository, User, String> {

    /**
     * 分页查询数据
     *
     * @param pageRequest
     * @return
     */
    Page<User> findPage(PagerRequest pageRequest);
}
