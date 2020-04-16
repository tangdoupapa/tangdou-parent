package com.tangdou.ihrm.company.application.response;

import com.tangdou.ihrm.company.dao.entities.Company;
import com.tangdou.ihrm.company.dao.entities.Department;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/4/14 22:18
 * @Description:
 */
@ApiModel("公司所有的部门")
@Data
public class DeptAllResponse {

    @ApiModelProperty("公司id")
    private String companyId;

    @ApiModelProperty("公司名称")
    private String companyName;

    @ApiModelProperty("公司联系人")
    private String companyManage;

    @ApiModelProperty("部门")
    private List<Department> depts;

    public DeptAllResponse(Company company, List<Department> depts) {
        this.companyId = company.getId();
        this.companyName = company.getName();
        this.companyManage = company.getLegalRepresentative();
        this.depts = depts;
    }
}
