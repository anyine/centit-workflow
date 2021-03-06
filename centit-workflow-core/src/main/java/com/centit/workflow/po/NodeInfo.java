package com.centit.workflow.po;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * create by scaffold
 *
 * @author codefan@hotmail.com
 */
@Entity
@Data
@Table(name = "WF_NODE")
public class NodeInfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "NODE_ID")
    private String nodeId;
    @Column(name = "FLOW_CODE")
    @NotNull(message = "字段不能为空")
    @Length(max = 32, message = "字段长度不能大于{max}")
    private String flowCode;

    /**
     * 框架解析 不到ManyToOne的属性 这儿单独 设置
     */
    @Column(name = "VERSION")
    @NotNull(message = "字段不能为空")
    @Range( max = 9999, message = "版本号不能大于{max}")
    private Long version;
    /**
     * A:开始（这个在数据库中其实不存在）
     * B:首节点(首节点不能是路由节点，如果是路由节点请设置为 哑元，跳转到后一个节点； B 的处理换个C一样)
     * C:业务节点 R: 路由节点 F结束
     * TODO 这个B类型是一个糟糕的设计，应该在flowInfo中添加一个首届点字段，
     */
    @Column(name = "NODE_TYPE")
    private String nodeType;
    @Column(name = "NODE_NAME")
    private String nodeName;
    /**
     * A: 唯一执行人 B: 抢先机制 C: 多人操作 D: 自动执行
     * E: 哑元（可用于嵌套汇聚，等同于自动执行无动作） S:子流程
     */
    @Column(name = "OPT_TYPE")
    private String optType;

    /**
     * 业务ID 关联到 FlowOptInfo
     */
    @Column(name = "OPT_ID")
    private String optId;
    /**
     * 业务页面代码 关联到 FlowOptPage
     *  optType = D 时； optCode 有三个选项
     *      * N 无操作；等同于哑元
     *      * B 事件Bean
     *      * S 脚本Script
     */
    @Column(name = "OPT_CODE")
    private String optCode;
    /**
     * optType = D && optCode = S 时
     * optParam 存放的是代码脚本
     */
    @Length(max = 2048, message = "长度不能超过{max}")
    @Column(name = "OPT_PARAM")
    private String optParam;

    @Column(name = "OS_ID")
    private String osId;

    @Column(name = "OPT_BEAN")
    private String optBean;

    @Column(name = "SUB_FLOW_CODE")
    private String subFlowCode;

    /**
     * EN GW XZ BJ RO SF
     */
    @Column(name = "ROLE_TYPE")
    private String roleType;

    @Column(name = "ROLE_CODE")
    private String roleCode;

    @Column(name = "UNIT_EXP")
    private String unitExp;

    @Column(name = "POWER_EXP")
    private String powerExp;

    @Column(name = "NODE_DESC")
    private String nodeDesc;

    /**
     * 期限类别 I ： 未设置（ignore 默认 ）、N 无 (无期限 none ) 、 F 每实例固定期限 fix 、
     * C 节点固定期限  cycle、H 继承上一个节点剩余时间 hierarchical。
     */
    @Column(name = "LIMIT_TYPE")
    private String limitType;

    @Column(name = "TIME_LIMIT")
    private String timeLimit;
    /**
     *  0：不继承， 1 ：继承前节点 2 ：继承指定节点；
     */
    @Column(name = "INHERIT_TYPE")
    private String inheritType;

    /**
     * 继承节点环节代码 输入框 ，文本输入； XML 属性名 inheritNodeCode
     * InheritType == '2' 时有效
     */
    @Column(name = "INHERIT_NODE_CODE")
    private String inheritNodeCode;

    @Column(name = "EXPIRE_OPT")
    private String expireOpt;

    @Column(name = "IS_ACCOUNT_TIME")
    private String isAccountTime;

    @Column(name = "IS_TRUNK_LINE")
    private String isTrunkLine;
    /**
     * 环节代码
     */
    @Column(name = "NODE_CODE")
    private String nodeCode;

    @Column(name = "RISK_INFO")
    private String riskinfo;

    @Column(name = "STAGE_CODE")
    private String stageCode;
    /**
     * D:分支 E:汇聚  G 多实例节点  H并行  R 游离 S：同步
     */
    @Column(name = "ROUTER_TYPE")
    private String routerType;
    /**
     * D 机构， U 人员 (权限表达式)， V 变量(暂时未实现，没有找到应用场景)
     */
    @Column(name = "MULTI_INST_TYPE")
    private String multiInstType;
    /**
     * 自定义变量表达式
     */
    @Column(name = "MULTI_INST_PARAM")
    private String multiInstParam;

    /**
     * A 所有都完成，R 至少有X完成，L 至多有X未完成， V 完成比率达到X ，E  外埠判断
     */
    @Column(name = "CONVERGE_TYPE")
    private String convergeType;

    @Column(name = "CONVERGE_PARAM")
    private String convergeParam;
    /**
     * R：运行时间  L:剩余时间 P：比率
     */
    @Column(name = "WARNING_RULE")
    private String warningRule;

    @Column(name = "WARNING_PARAM")
    private String warningParam;

    @JSONField(serialize=false)
    private FlowInfo flowDefine;


    // Constructors
    /** default constructor */
    public NodeInfo() {
        this.isAccountTime = "T";
        this.inheritType = "0";
    }

    /** minimal constructor */
    public NodeInfo(String nodeid, String nodetype) {

        this.nodeId = nodeid;

        this.nodeType = nodetype;
        this.isAccountTime = "T";
        this.inheritType = "0";
    }

    public void copy(NodeInfo other) {
        //this.setNodeId(other.getNodeId());
        this.setFlowDefine(other.getFlowDefine());
        //this.getFlowDefine().setFlowCode(other.getFlowCode());
        this.nodeType = other.getNodeType();
        this.nodeName = other.getNodeName();
        this.optType = other.getOptType();

        this.osId = other.getOsId();
        this.optId = other.getOptId();
        this.optCode = other.getOptCode();
        this.optParam = other.getOptParam();
        this.optBean = other.getOptBean();
        this.subFlowCode = other.getSubFlowCode();
        this.roleType = other.getRoleType();
        this.roleCode = other.getRoleCode();
        this.unitExp = other.getUnitExp();
        this.powerExp = other.getPowerExp();
        this.nodeDesc = other.getNodeDesc();
        this.timeLimit = other.getTimeLimit();
        this.expireOpt = other.getExpireOpt();
        this.isAccountTime = other.getIsAccountTime();
        this.stageCode =other.getStageCode();
        this.routerType=other.getRouterType();
        this.multiInstType=other.getMultiInstType();
        this.multiInstParam=other.getMultiInstParam();
        this.convergeParam=other.getConvergeParam();
        this.convergeType=other.getConvergeType();
        this.warningRule=other.getWarningRule();
        this.warningParam=other.getWarningParam();
    }

    public void copyNotNullProperty(NodeInfo other) {

        /*if (other.getNodeId() != null)
            this.setNodeId(other.getNodeId());*/

        if( other.getFlowDefine() != null)
            this.setFlowDefine(other.getFlowDefine());

        if (other.getNodeType() != null)
            this.nodeType = other.getNodeType();
        if (other.getNodeName() != null)
            this.nodeName = other.getNodeName();
        if (other.getOptType() != null)
            this.optType = other.getOptType();
        if (other.getOptCode() != null)
            this.optCode = other.getOptCode();
        if (other.getOptParam() != null)
            this.optParam = other.getOptParam();
        if (other.getOptBean() != null)
            this.optBean = other.getOptBean();
        if (other.getSubFlowCode() != null)
            this.subFlowCode = other.getSubFlowCode();
        if (other.getRoleType() != null)
            this.roleType = other.getRoleType();
        if (other.getRoleCode() != null)
            this.roleCode = other.getRoleCode();
        if (other.getUnitExp() != null)
            this.unitExp = other.getUnitExp();
        if (other.getPowerExp() != null)
            this.powerExp = other.getPowerExp();
        if (other.getNodeDesc() != null)
            this.nodeDesc = other.getNodeDesc();
        if (other.getTimeLimit() != null)
            this.timeLimit = other.getTimeLimit();
        if (other.getExpireOpt() != null)
            this.expireOpt = other.getExpireOpt();
        if (other.getIsAccountTime() != null)
            this.isAccountTime = other.getIsAccountTime();
        if (other.getStageCode()!=null)
            this.stageCode =other.getStageCode();

        if (other.getIsTrunkLine()!=null)
            this.isTrunkLine=other.getIsTrunkLine();
        if (other.getOsId()!=null)
            this.osId = other.getOsId();
        if (other.getOptId()!=null)
            this.optId = other.getOptId();

        if (other.getRouterType()!=null)
            this.routerType=other.getRouterType();
        if (other.getMultiInstType()!=null)
            this.multiInstType=other.getMultiInstType();
        if (other.getMultiInstParam()!=null)
            this.multiInstParam=other.getMultiInstParam();
        if (other.getConvergeParam()!=null)
            this.convergeParam=other.getConvergeParam();
        if (other.getConvergeType()!=null)
            this.convergeType=other.getConvergeType();
        if (other.getWarningRule()!=null)
            this.warningRule=other.getWarningRule();
        if (other.getWarningParam()!=null)
            this.warningParam=other.getWarningParam();

    }

    public void clearProperties()
    {
        this.nodeId = null;
        this.getFlowDefine().setVersion(null);
        this.getFlowDefine().setFlowCode(null);
        this.nodeType =  null;
        this.nodeName =  null;
        this.optType =  null;
        this.optCode =  null;
        this.optParam =  null;
        this.optBean = null;
        this.subFlowCode = null;
        this.roleType = null;
        this.roleCode =  null;
        this.unitExp =  null;
        this.powerExp = null;
        this.nodeDesc = null;
        this.timeLimit = null;
        this.stageCode =null;
        this.expireOpt =  null;
        this.isAccountTime = "T";
        this.isTrunkLine ="F";

        this.routerType=null;
        this.multiInstType=null;
        this.multiInstParam=null;
        this.convergeParam=null;
        this.convergeType=null;
        this.warningRule=null;
        this.warningParam=null;
    }

}
