package com.centit.workflow.controller;

import com.alibaba.fastjson.JSONArray;
import com.centit.framework.common.JsonResultUtils;
import com.centit.framework.common.ResponseMapData;
import com.centit.framework.core.controller.BaseController;
import com.centit.framework.core.controller.WrapUpResponseBody;
import com.centit.framework.core.dao.PageQueryResult;
import com.centit.support.database.utils.PageDesc;
import com.centit.workflow.po.RoleFormula;
import com.centit.workflow.service.RoleFormulaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RoleFormulaController
 * @Date 2019/7/22 15:37
 * @Version 1.0
 */
@Controller
@Api(value = "权限表达式",
    tags = "权限表达式接口类")
@RequestMapping("/formula")
public class RoleFormulaController extends BaseController {


    @Resource
    private RoleFormulaService roleFormulaService;

    @ApiOperation(value = "权限表达式列表", notes = "权限表达式列表")
    @WrapUpResponseBody
    @RequestMapping(value="/listRoleFormula",method = RequestMethod.GET)
    public PageQueryResult<RoleFormula> listAllRoleFormula(PageDesc pageDesc, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> filterMap = convertSearchColumn(request);
        List<RoleFormula> listObjects = roleFormulaService.listRoleFormulas(filterMap, pageDesc);

        return PageQueryResult.createResult(listObjects, pageDesc);
    }
    @ApiOperation(value = "查询单个权限表达式", notes = "查询单个权限表达式")
    @WrapUpResponseBody
    @RequestMapping(value = "/getRoleFormulaCode/{formulaCode}", method = RequestMethod.GET)
    public RoleFormula getRoleFormulaByCode(@PathVariable String formulaCode){
        RoleFormula roleFormula = roleFormulaService.getRoleFormulaByCode(formulaCode);
        return roleFormula;
    }
    @ApiOperation(value = "保存权限表达式", notes = "保存权限表达式")
    @WrapUpResponseBody
    @RequestMapping(value = "/saveRoleFormula", method = RequestMethod.POST)
    public RoleFormula saveFlowRole(@RequestBody RoleFormula roleFormula){
        roleFormulaService.saveRoleFormula(roleFormula);
        return roleFormula;
    }
    @ApiOperation(value = "删除权限表达式", notes = "删除权限表达式")
    @WrapUpResponseBody
    @RequestMapping(value="/deleteRoleFormulaByCode/{formulaCode}", method = RequestMethod.POST)
    public void deleteFlowRoleByCode(@PathVariable String formulaCode) {
        roleFormulaService.deleteRoleFormulaByCode(formulaCode);
    }
    @ApiOperation(value = "查询权限表达式对应用户", notes = "查询权限表达式对应用户")
    @WrapUpResponseBody
    @RequestMapping(value="/viewRoleFormulaUsers/{formulaCode}",method = RequestMethod.GET)
    public JSONArray viewRoleFormulaUsers(@PathVariable String formulaCode){
        JSONArray listObjects = roleFormulaService.viewRoleFormulaUsers(formulaCode);
        return listObjects;
    }
    @ApiOperation(value = "预览权限表达式对应用户", notes =
        "表达式为itemExp ([或| itemExp][与& itemExp][非! itemExp])的形式，itemExp为下列形式\n" +
            "D()P()DT()DL()GW()XZ()R()UT()UL()U()RO()\n" +
            "* D 根据机构代码过滤 D(机构表达式)\n" +
            "* P 根据机构代码过滤主要机构\n" +
            "* DT 根据机构类型过滤 DT(\"角色代码常量\" [,\"角色代码常量\"])\n" +
            "* DL 根据机构标签过滤 DL(\"角色代码常量\" [,\"角色代码常量\"])\n" +
            "* GW 根据岗位过滤 GW(\"角色代码常量\" [,\"角色代码常量\"])\n" +
            "* XZ 根据行政职务过滤 XZ(\"角色代码常量\" [,\"角色代码常量\"])\n" +
            "* R 根据行政职务等级过滤 R(U) / R(U-) / R(U-1) / R(U--) /R(U-1--)\n" +
            "* U 根据用户代码过滤 U(用户变量|\"用户代码常量\" [,用户变量|\"用户代码常量])\n" +
            "* UT 根据用户类型过滤 UT(\"用户类型常量\" [,\"用户类型常量\"])\n" +
            "* UL 根据用户标签过滤 UL(\"用户标记常量\" [,\"用户标记常量\"])\n" +
            "* RO 根据用户角色过滤 RO(\"系统角色代码常量\" [,\"系统角色代码常量\"])" )
    @WrapUpResponseBody
    @RequestMapping(value="/viewFormulaUsers/{formula}",method = RequestMethod.GET)
    public JSONArray viewFormulaUsers(@PathVariable String formula){
        JSONArray listObjects = roleFormulaService.viewFormulaUsers(StringEscapeUtils.unescapeHtml4(formula));
        return listObjects;
    }
}