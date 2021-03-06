package com.centit.workflow.po;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * create by scaffold
 * @author codefan@hotmail.com
 */
@Entity
@Table(name = "WF_TRANSITION")
public class FlowTransition implements java.io.Serializable {
    private static final long serialVersionUID =  1L;

    @Id
    @Column(name = "TRANS_ID")
    private String transId;

    @Column(name = "TRANS_CLASS")
    private String transClass;
    @Column(name = "TRANS_NAME")
    private String transName;
    @Column(name = "TRANS_DESC")
    private String transDesc;
    @Column(name = "START_NODE_ID")
    private String startNodeId;
    @Column(name = "END_NODE_ID")
    private String endNodeId;
    @Column(name = "TRANS_CONDITION")
    private String transCondition;
    @Column(name = "LIMIT_TYPE")
    private String limitType;
    @Column(name = "TIME_LIMIT")
    private String timeLimit;
    @Column(name = "IS_ACCOUNT_TIME")
    private String isAccountTime;
    @Column(name = "CAN_IGNORE")
    private String canIgnore;

    /**
     * 框架解析 不到ManyToOne的属性 这儿单独 设置
     */
    @Column(name = "VERSION")
    @NotNull(message = "字段不能为空")
    @Range( max = 9999, message = "版本号不能大于{max}")
    private Long version;

    @Column(name = "FLOW_CODE")
    @NotBlank(message = "字段不能为空")
    @Length(max = 32, message = "字段长度不能大于{max}")
    private String flowCode;

    @JSONField(serialize=false)
    private FlowInfo flowDefine;


    // Constructors
    /** default constructor */
    public FlowTransition() {
        this.canIgnore="T";
        isAccountTime ="I";
    }
    /** minimal constructor */
    public FlowTransition(
        String transid
        ) {
        this.canIgnore="T";
        isAccountTime ="I";
        this.transId = transid;

    }

/** full constructor */
    public FlowTransition(
     String transid
    ,Long  version,String  wfcode,String  transclass,String  transname,String  transdesc,
     String  startnodeid,String  endnodeid,String  transcondition,String limitType,String timelimit) {


        this.transId = transid;

        this.getFlowDefine().setVersion(version);
        this.getFlowDefine().setFlowCode(wfcode);
        this.transClass = transclass;
        this.transName = transname;
        this.transDesc = transdesc;
        this.startNodeId = startnodeid;
        this.endNodeId = endnodeid;
        this.transCondition = transcondition;
        this.limitType = limitType;
        this.timeLimit = timelimit;
        this.canIgnore="T";
        this.isAccountTime ="I";
    }

    /**
     * 期限类别 I ： 未设置（ignore 默认 ）、N 无 (无期限 none ) 、 F 每实例固定期限 fix 、C 节点固定期限  cycle、H 继承上一个节点剩余时间 hierarchical。
     * @return
     */
    public String getLimitType() {
        return limitType;
    }
    /**
     * 期限类别 I ： 未设置（ignore 默认 ）、N 无 (无期限 none ) 、 F 每实例固定期限 fix 、C 节点固定期限  cycle、H 继承上一个节点剩余时间 hierarchical。
     * @param limitType
     */
    public void setLimitType(String limitType) {
        this.limitType = limitType;
    }

    public String getTimeLimit() {
        return this.timeLimit;
    }

    public void setTimeLimit(String timelimit) {
        this.timeLimit = timelimit;
    }

    public String getTransId() {
        return this.transId;
    }

    public void setTransId(String transid) {
        this.transId = transid;
    }

    public String getStartNodeId() {
        return startNodeId;
    }

    public void setStartNodeId(String startNodeId) {
        this.startNodeId = startNodeId;
    }

    public String getEndNodeId() {
        return endNodeId;
    }

    public void setEndNodeId(String endNodeId) {
        this.endNodeId = endNodeId;
    }

    public String getTransCondition() {
        return transCondition;
    }

    public void setTransCondition(String transCondition) {
        this.transCondition = transCondition;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getFlowCode() {
        return flowCode;
    }

    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode;
    }

    public String getTransClass() {
        return this.transClass;
    }

    public void setTransClass(String transClass) {
        this.transClass = transClass;
    }

    public String getTransName() {
        return this.transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    public String getTransDesc() {
        return this.transDesc;
    }

    public void setTransDesc(String transDesc) {
        this.transDesc = transDesc;
    }

    /**
     * 改是否记入时间 T/F  I 忽略
     * @return
     */
    public String getIsAccountTime() {
        return isAccountTime;
    }
    /**
     * 改是否记入时间 T/F  I 忽略
     * @param isAccountTime
     */
    public void setIsAccountTime(String isAccountTime) {
        this.isAccountTime = isAccountTime;
    }
    /**
     * T可以忽略 F 不可以忽略  是否可以忽略运行
     * @return
     */
    public String getCanIgnore() {
        return canIgnore;
    }
    /**
     * T可以忽略 F 不可以忽略  是否可以忽略运行
     * @param canIgnore
     */
    public void setCanIgnore(String canIgnore) {
        this.canIgnore = canIgnore;
    }

    public void copy(FlowTransition other){
        //this.setTransId(other.getTransId());
        this.setFlowDefine(other.getFlowDefine());
        this.transClass = other.getTransClass();
        this.transName = other.getTransName();
        this.transDesc = other.getTransDesc();
        this.startNodeId = other.getStartNodeId();
        this.endNodeId = other.getEndNodeId();
        this.transCondition = other.getTransCondition();
        this.limitType = other.getLimitType();
        this.timeLimit = other.getTimeLimit();

        this.isAccountTime= other.getIsAccountTime();
        this.canIgnore= other.getCanIgnore();
    }

    public void copyNotNullProperty(FlowTransition other){

        /*if( other.getTransId() != null)
            this.setTransId(other.getTransId());*/

        if( other.getFlowDefine() != null)
            this.setFlowDefine(other.getFlowDefine());

        if( other.getTransClass() != null)
            this.transClass = other.getTransClass();
        if( other.getTransName() != null)
            this.transName = other.getTransName();
        if( other.getTransDesc() != null)
            this.transDesc = other.getTransDesc();
        if( other.getStartNodeId() != null)
            this.startNodeId = other.getStartNodeId();
        if( other.getEndNodeId() != null)
            this.endNodeId = other.getEndNodeId();
        if( other.getTransCondition() != null)
            this.transCondition = other.getTransCondition();
        if( other.getLimitType() != null)
            this.limitType= other.getLimitType();
        if( other.getTimeLimit() != null)
            this.limitType= other.getTimeLimit();

        if( other.getIsAccountTime() != null)
            this.isAccountTime= other.getIsAccountTime();
        if( other.getCanIgnore() != null)
            this.canIgnore= other.getCanIgnore();
    }

  public void clearProperties(){


        this.flowDefine = null;
        this.transClass =null;
        this.transName = null;
        this.transDesc = null;
        this.startNodeId =null;
        this.endNodeId = null;
        this.transCondition = null;
        this.limitType =null;
        this.timeLimit = null;

        this.isAccountTime= "I";
        this.canIgnore="T";
    }

    public FlowInfo getFlowDefine() {
        return flowDefine;
    }
    public void setFlowDefine(FlowInfo flowDefine) {
        this.flowDefine = flowDefine;
    }

}
