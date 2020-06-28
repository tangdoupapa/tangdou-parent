package com.tangdou.ihrm.system.service.test;

import com.tangdou.ihrm.company.application.CompanyApplication;
import com.tangdou.ihrm.company.service.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 11:40
 * @Description:
 */
@SpringBootTest(classes = CompanyApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CompanyServiceTest {

    @Autowired
    private CompanyService companyService;

    @Test
    public void findAll(){
        System.out.println(companyService.list());
    }
}
