package com.tangdou.ihrm.company.service.impl;

import com.tangdou.common.service.impl.BaseServiceImpl;
import com.tangdou.ihrm.company.dao.entities.Company;
import com.tangdou.ihrm.company.dao.repository.CompanyRepository;
import com.tangdou.ihrm.company.service.CompanyService;
import org.springframework.stereotype.Service;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 11:49
 * @Description:
 */
@Service
public class CompanyServiceImpl extends BaseServiceImpl<CompanyRepository, Company, String> implements CompanyService {
}
