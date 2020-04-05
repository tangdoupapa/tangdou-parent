package com.tangdou.ihrm.company.service.test;

import cn.hutool.core.io.IoUtil;
import com.tangdou.ihrm.company.application.CompanyApplication;
import org.flowable.engine.*;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/4/4 16:44
 * @Description: activiti 流程测试，
 * springboot 默认自动部署classpath: processes中的流程
 */
@SpringBootTest(classes = CompanyApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ActivitiTest {

    private final String PROCESS_DEFINITION_KEY = "myProcess_1";

    /**
     * 操作历史记录的表 act_ru_* 的接口, 流程运行的管理类
     */
    @Autowired
    private RuntimeService runtimeService;

    /**
     * 流程任务的管理类
     */
    @Autowired
    private TaskService taskService;
    /**
     * 操作历史记录的表 act_re_* 的接口，流程中资源管理类
     */
    @Autowired
    private RepositoryService repositoryService;
    /**
     * 操作历史记录的表 act_hi_* 的接口，流程历史管理类
     */
    @Autowired
    private HistoryService historyService;

    @Autowired
    private ProcessEngine processEngine;

    /**
     * @Auther: tangdouopapa
     * @Description: 查看部署信息, 部署后变更的表： act_re_deployment,act_re_prodef,act_ge_bytearray
     * @Date: 2020/4/4 18:18
     */
    @Test
    public void testDeployment() {
        List<Deployment> deployments = repositoryService.createDeploymentQuery().list();
        deployments.forEach(deployment -> {
            System.out.println(deployment.getName());
            System.out.println(deployment.getId());
        });
    }

    /**
     * @Auther: tangdouopapa
     * @Description: 启动流程后变更的表：act_hi_proinst , act_hi_actinst , act_hi_identitylink(参与者) , act_hi_taskinst
     * act_ru_execution , act_ru_identitylink(当前的参与者) , act_ru_task(当前的任务)
     * @Date: 2020/4/4 18:18
     */
    @Test
    public void testStartProcessInstance() {
        //ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_1");
        //带business key
        /*Map<String, Object> params = MapUtil.<String, Object>builder().put("assignee1", "zhangsan")
                .put("assignee2", "lisi").put("assignee3", "wangwu").build();*/
        //此处的params为全局变量 变更表： act_ge_bytearray  act_ru_variable
//        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_1", "1", params);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_1", "1");
        System.out.println(processInstance.getId());
        System.out.println(processInstance.getName());
    }

    /**
     * @Auther: tangdouopapa
     * @Description: 查询并完成任务, 变更更表:  act_hi_actint(历史过程) ，act_hi_identitylink（增加新的参与者） ，act_hi_proinst，act_hi_taskinst（新增下一条任务）
     * act_ru_execution , act_ru_identitylink(当前的参与者) , act_ru_task(当前的任务)
     * @Date: 2020/4/4 18:18
     */
    @Test
    public void testFindAndCompleteTask() {
        Task task = taskService.createTaskQuery()
                .processDefinitionKey(PROCESS_DEFINITION_KEY)
                .taskAssignee("zhangsan").singleResult();
        /*Task task = taskService.createTaskQuery()
                .processDefinitionKey(PROCESS_DEFINITION_KEY)
                .taskAssignee("lisi").singleResult();*/
        /*Task task = taskService.createTaskQuery()
                .processDefinitionKey(PROCESS_DEFINITION_KEY)
                .taskAssignee("wangwu").singleResult();*/
        System.out.println("流程实例:" + task.getProcessInstanceId());
        System.out.println("任务id:" + task.getId());
        System.out.println("任务名称:" + task.getName());
        System.out.println("任务负责人:" + task.getAssignee());

        taskService.complete(task.getId());
    }

    /**
     * @Auther: tangdouopapa
     * @Description: 查询流程定义
     * @Date: 2020/4/4 18:18
     */
    @Test
    public void testFindProcessDefinition() {
        List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery()
                .orderByProcessDefinitionVersion().desc().list();
        processDefinitions.forEach(pd -> {
            System.out.println("流程定义id：" + pd.getId());
            System.out.println("流程定义名称：" + pd.getName());
            System.out.println("流程定义版本：" + pd.getVersion());
            System.out.println("流程定义key：" + pd.getKey());
            System.out.println("流程定义部署id：" + pd.getDeploymentId());
        });
    }

    /**
     * @Auther: tangdouopapa
     * @Description: 删除流程定义  act_ge_bytearray:删除对应的文件  act_re_deployment   act_re_procdef
     * 注意： 当一个流程没有完全审批结束时，不可以删除流程定义（会报错）
     * 如果必须要删除，则可以进行级联删除
     * @Date: 2020/4/4 18:18
     */
    @Test
    public void testDeleteProcessDefinition() {
        List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery()
                .orderByProcessDefinitionVersion().desc().list();
        //不可删除
//        processDefinitions.forEach(pd -> repositoryService.deleteDeployment(pd.getDeploymentId()));
        //级联删除
        processDefinitions.forEach(pd -> repositoryService.deleteDeployment(pd.getDeploymentId(), true));
    }

    /**
     * @Auther: tangdouopapa
     * @Description: 下载流程定义
     * @Date: 2020/4/4 18:18
     */
    @Test
    public void testDownloadBPMN() throws Exception {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().listPage(1, 1).get(0);
        //processDefinition.getResourceName() 获取bpmn文件
        InputStream bpmnIs = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), processDefinition.getResourceName());
        //processDefinition.getDiagramResourceName() 获取bpmn文件
//        InputStream pngIs = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), processDefinition.getDiagramResourceName());
        IoUtil.copy(bpmnIs, new FileOutputStream(new File("C:\\Users\\tangdoupapa\\Desktop\\test.bpmn")));
    }

    /**
     * @Auther: tangdouopapa
     * @Description: 历史记录
     * @Date: 2020/4/4 18:18
     */
    @Test
    public void testHistory() throws Exception {
        List<HistoricActivityInstance> list = historyService.createHistoricActivityInstanceQuery()
                .processInstanceId("43756fbf-768c-11ea-bade-0a0027000006")
                .orderByHistoricActivityInstanceStartTime().asc().list();
        list.forEach(h -> System.out.println(h.getActivityName()));
    }

    /**
     * @Auther: tangdouopapa
     * @Description: 挂起和激活流程定义（全部挂起流程）
     * @Date: 2020/4/4 18:18
     */
    @Test
    public void testSuspendAndActive() {
        Task task = taskService.createTaskQuery().singleResult();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(task.getProcessDefinitionId()).singleResult();
        if (!processDefinition.isSuspended()) {
            repositoryService.suspendProcessDefinitionById(processDefinition.getId());
            System.out.println("挂起全部流程实例");
        } else {
            repositoryService.activateProcessDefinitionById(processDefinition.getId());
            System.out.println("激活全部流程实例");
        }
    }

    /**
     * @Auther: tangdouopapa
     * @Description: 挂起和激活流程定义（全部挂起流程）
     * @Date: 2020/4/4 18:18
     */
    @Test
    public void testSuspendAndActiveOne() {
        Task task = taskService.createTaskQuery().singleResult();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processDefinitionId(task.getProcessDefinitionId()).singleResult();
        if (!processInstance.isSuspended()) {
            runtimeService.suspendProcessInstanceById(processInstance.getId());
            System.out.println("挂起单个流程实例");
        } else {
            runtimeService.activateProcessInstanceById(processInstance.getId());
            System.out.println("激活单个流程实例");
        }
    }


    /**
     * @Auther: tangdouopapa
     * @Description: 拾取任务与退定任务
     * @Date: 2020/4/4 18:18
     */
    @Test
    public void testClaimTask() {
        Task task = taskService.createTaskQuery()
                .processDefinitionKey(PROCESS_DEFINITION_KEY)
                .taskCandidateUser("zhangsan").singleResult();
        taskService.claim(task.getId(), "zhangsan");

        /*Task task = taskService.createTaskQuery()
                .processDefinitionKey(PROCESS_DEFINITION_KEY)
                .taskAssignee("zhangsan").singleResult();
        taskService.unclaim(task.getId());*/
    }
}
