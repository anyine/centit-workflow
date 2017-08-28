package com.centit.workflow.client.po;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */
public class NodeInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

   
	private Long nodeId;
	/*@Column(name = "FLOWCODE")
	private String flowCode;
    @Column(name = "VERSION")
	private Long version;
    A:开始 B:首节点 C:业务节点  F结束  R: 路由节点 
    */
	private String nodeType;
	private String nodeName;
	private String optType;

    private String osId;

    private String optId;

	private String optCode;

	private String optParam;
	private String optBean;
	private String subFlowCode;
	private String roleType;
	private String roleCode;
	private String unitExp;
	private String powerExp;
	private String nodeDesc;
    private String limitType;
	private String timeLimit;
    private String inheritType;
    private String inheritNodeCode;
	private String expireOpt;
	private String isAccountTime;

	private String isTrunkLine;
	private String nodeCode;
	private String riskinfo;
    
    private String stageCode;
    
    private String routerType;
    private String multiInstType;
    private String multiInstParam;
    private String convergeType;
    private String convergeParam;
    private String warningRule;
    private String warningParam;
    
    
    private FlowInfo flowDefine;
    public String getIsTrunkLine() {
        return isTrunkLine;
    }

    public void setIsTrunkLine(String isTrunkLine) {
        this.isTrunkLine = isTrunkLine;
    }
    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getRiskinfo() {
        return riskinfo;
    }

    public void setRiskinfo(String riskinfo) {
        this.riskinfo = riskinfo;
    }

	// Constructors
	/** default constructor */
	public NodeInfo() {
        this.isAccountTime = "T";
        this.inheritType = "0";
	}

	/** minimal constructor */
	public NodeInfo(Long nodeid, String nodetype) {

		this.nodeId = nodeid;

		this.nodeType = nodetype;
        this.isAccountTime = "T";
        this.inheritType = "0";
    }

	public Long getNodeId() {
		return this.nodeId;
	}

	public void setNodeId(Long nodeid) {
		this.nodeId = nodeid;
	}

	// Property accessors

	public String getStageCode() {
        return stageCode;
    }

    public void setStageCode(String flowPhase) {
        this.stageCode = flowPhase;
    }

    public String getFlowCode() {
        if(this.flowDefine==null)
            return null;
        return this.flowDefine.getFlowCode();
	}

	public Long getVersion() {
	    if(this.flowDefine==null)
	        return null;
		return this.flowDefine.getVersion();
	}


	public FlowInfo getFlowDefine() {
        return flowDefine;
    }

    public void setFlowDefine(FlowInfo flowDefine) {
        this.flowDefine = flowDefine;
    }

    /**
	 * A:开始 B:首节点 C:业务节点  F结束  R: 路由节点 
	 * @return
	 */
	public String getNodeType() {
		return this.nodeType;
	}
	/**
	 * 
	 * @param nodetype A:开始 B:首节点 C:业务节点  F结束  R: 路由节点 
	 */
	public void setNodeType(String nodetype) {
		this.nodeType = nodetype;
	}

	public String getNodeName() {
		return this.nodeName;
	}

	public void setNodeName(String nodename) {
		this.nodeName = nodename;
	}

	/**
	 * @return A:一般 B:抢先机制 C:多人操作 D:自动执行  E哑元（可用于嵌套汇聚） S:子流程
	 */
	public String getOptType() {
		return this.optType;
	}

	/**
	 * 
	 * @param opttype A:一般 B:抢先机制 C:多人操作 D:自动执行   E哑元（可用于嵌套汇聚） S:子流程
	 */
	public void setOptType(String opttype) {
		this.optType = opttype;
	}

	public String getOptCode() {
		return this.optCode;
	}

	public void setOptCode(String optcode) {
		this.optCode = optcode;
	}

	public String getOptBean() {
		return this.optBean;
	}

	public void setOptBean(String opturl) {
		this.optBean = opturl;
	}

	public String getSubFlowCode() {
		return this.subFlowCode;
	}

	public void setSubFlowCode(String subwfcode) {
		this.subFlowCode = subwfcode;
	}
	/**
	 * en gw xz bj
	 * @return
	 */
	public String getRoleType() {
		return this.roleType;
	}

	public void setRoleType(String roletype) {
		this.roleType = roletype;
	}

	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String rolecode) {
		this.roleCode = rolecode;
	}

	public String getOptParam() {
        return optParam;
    }

    public void setOptParam(String optparam) {
        this.optParam = optparam;
    }

    public String getUnitExp() {
		return this.unitExp;
	}

	public void setUnitExp(String unitexp) {
		this.unitExp = unitexp;
	}

	public String getPowerExp() {
		return this.powerExp;
	}

	public void setPowerExp(String powerexp) {
		this.powerExp = powerexp;
	}

	public String getNodeDesc() {
		return this.nodeDesc;
	}

	public void setNodeDesc(String nodedesc) {
		this.nodeDesc = nodedesc;
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
	/**
	 *  0：不继承， 1 ：继承前节点 2 ：继承指定节点； 
	 * @return
	 */
	public String getInheritType() {
        return inheritType;
    }
	/**
	 * @param inheritType  0：不继承， 1 ：继承前节点 2 ：继承指定节点； 
	 */
    public void setInheritType(String inheritType) {
        this.inheritType = inheritType;
    }
    /**
     * 继承节点环节代码 输入框 ，文本输入； XML 属性名 inheritNodeCode 
     * InheritType == '2' 时有效
     * @return
     */
    public String getInheritNodeCode() {
        return inheritNodeCode;
    }

    public void setInheritNodeCode(String inheritNodeCode) {
        this.inheritNodeCode = inheritNodeCode;
    }

    /**
	 * N：通知， O:不处理 ，X：挂起，E：终止（流程）， C：完成（强制提交,提交失败就挂起）
	 * @return
	 */
	public String getExpireOpt() {
		return this.expireOpt;
	}
    /**
     * N：通知， O:不处理 ，X：挂起，E：终止（流程）， C：完成（强制提交,提交失败就挂起）
     * @param expireopt
     */
	public void setExpireOpt(String expireopt) {
		this.expireOpt = expireopt;
	}

	/**
     * 节点执行时间是否计入时间限制     T 计时、有期限   F  不计时    H仅环节计时
     */
	public String getIsAccountTime() {
		return this.isAccountTime;
	}

	/**
	 * 节点执行时间是否计入时间限制    T 计时、有期限  F 不计时   H 仅环节计时
	 * @param issync
	 */
	public void setIsAccountTime(String issync) {
		this.isAccountTime = issync;
	}


	/**
	 * D:分支 E:汇聚  G 多实例节点  H并行  R 游离 S：同步
	 * @return
	 */
    public String getRouterType() {
        return routerType;
    }
    /**
     * D:分支 E:汇聚  G 多实例节点  H并行  R 游离 S：同步
     * @param routerType
     */
    public void setRouterType(String routerType) {
        this.routerType = routerType;
    }

    /**
     * D 机构， U 人员 (权限表达式)， V 变量
     * @return
     */
    public String getMultiInstType() {
        return multiInstType;
    }

    /**
     * D 机构， U 人员 (权限表达式)， V 变量
     * @param multiInstType
     */
    public void setMultiInstType(String multiInstType) {
        this.multiInstType = multiInstType;
    }

    /**
     * 自定义变量表达式
     * @return
     */
    public String getMultiInstParam() {
        return multiInstParam;
    }
    /**
     * 自定义变量表达式
     * @param multiInstParam
     */
    public void setMultiInstParam(String multiInstParam) {
        this.multiInstParam = multiInstParam;
    }

    /**
     * A 所有都完成，R 至少有X完成，L 至多有X未完成， V 完成比率达到X ，E  外埠判断
     * @return
     */
    public String getConvergeType() {
        return convergeType;
    }
    /**
     * A 所有都完成，R 至少有X完成，L 至多有X未完成， V 完成比率达到X ，E  外埠判断
     * @param convergeType
     */
    public void setConvergeType(String convergeType) {
        this.convergeType = convergeType;
    }

    public String getConvergeParam() {
        return convergeParam;
    }

    public void setConvergeParam(String convergeParam) {
        this.convergeParam = convergeParam;
    }
    /**
     * R：运行时间  L:剩余时间 P：比率
     * @return
     */
    public String getWarningRule() {
        return warningRule;
    }
    /**
     *  R：运行时间  L:剩余时间 P：比率
     * @param warningRule
     */
    public void setWarningRule(String warningRule) {
        this.warningRule = warningRule;
    }

    public String getWarningParam() {
        return warningParam;
    }

    public void setWarningParam(String warningParam) {
        this.warningParam = warningParam;
    }

    public String getOsId() {
        return osId;
    }

    public void setOsId(String osId) {
        this.osId = osId;
    }

    public String getOptId() {
        return optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
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