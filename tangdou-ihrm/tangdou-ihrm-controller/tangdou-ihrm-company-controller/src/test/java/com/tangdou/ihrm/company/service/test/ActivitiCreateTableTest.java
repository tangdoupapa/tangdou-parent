package com.tangdou.ihrm.company.service.test;

import com.tangdou.ihrm.company.application.CompanyApplication;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/4/4 16:44
 * @Description: activiti 流程测试
 */
@SpringBootTest(classes = CompanyApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ActivitiCreateTableTest {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ProcessRuntime processRuntime;

    /**
     * @Auther: tangdouopapa
     * @Description:
     * @Date: 2020/4/4 18:18
     * @Param:
     * @return:
     */
    @Test
    public void testGenTable() {
        List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery().list();
        System.out.println(processDefinitions);

    }
}
