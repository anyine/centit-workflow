package com.centit.workflow.client.service;

import com.alibaba.fastjson.JSONArray;
import com.centit.framework.model.basedata.OperationLog;
import com.centit.support.database.utils.PageDesc;
import com.centit.workflow.po.FlowInstance;
import com.centit.workflow.po.NodeInstance;

import java.util.Date;
import java.util.List;

/**
 * 流程管理业务接口类
 *   <流程终止，暂停，唤醒，回退等操作>
 * @author codefan@sina.com
 * @version 2.0 <br>
 *
 */
public interface FlowManagerClient {
    /**
     * 获取流程实例下的节点实例列表
     * @param wfinstid 流程实例编号
     * @return List<NodeInstance>
     */
    JSONArray /*List<NodeInstance>*/ listFlowInstNodes(String wfinstid);

    /**
     * 根据 示例ID获得实例
     *
     * @param flowInstId 流程 实例id
     * @return 流程实例信息
     */
    FlowInstance getFlowInstance(String flowInstId);
    /**
     * 终止一个流程
     * 修改其流程id为负数
     * 更新所有节点状态为F
     * F 强行结束
     * @param flowInstId 流程实例id
     * @param mangerUserCode 管理人员代码
     * @param admindesc 管理原因
     * @throws Exception 异常
     * @return 状态码
     * */
    int stopInstance(String flowInstId, String mangerUserCode, String admindesc);

    /**
     * 暂停一个流程    P 暂停 挂起
     * @param flowInstId 流程实例id
     * @param mangerUserCode 管理人员代码
     * @param admindesc 管理原因
     * throws Exception 异常
     * @return 状态码
     * */
    int suspendInstance(String flowInstId, String mangerUserCode, String admindesc);

    /**
     * 从这个节点重新运行该流程，包括已经结束的流程
     * @param nodeInstId 节点实例id
     * @param mangerUserCode 管理人员代码
     * @return 新的节点实例
     * */
    NodeInstance resetFlowToThisNode(String nodeInstId, String mangerUserCode);
    /**
     * 激活一个 挂起的或者无效的流程  N 正常
     * @param flowInstId 流程实例id
     * @param mangerUserCode 管理人员代码
     * @param admindesc 管理原因
     * @return 状态码
     * */
    int activizeInstance(String flowInstId, String mangerUserCode, String admindesc);


    /**
     * 暂停流程的一个节点  P 暂停
     * @param nodeInstId 节点实例id
     * @param mangerUserCode 管理人员代码
     * @return 状态码
     * */
    int suspendNodeInstance(String nodeInstId, String mangerUserCode);

    /**
     * 使流程的 挂起和失效的节点 正常运行 N 正常
     * @param nodeInstId 节点实例id
     * @param mangerUserCode 管理人员代码
     * @return 状态码
     * */
    int activizeNodeInstance(String nodeInstId, String mangerUserCode);

    /**
     * 强制流转到下一结点，这个好像不好搞，主要是无法获得业务数据，只能提交没有分支的节点
     * @param nodeInstId 节点实例id
     * @param mangerUserCode 管理人员代码
     * @return 状态码
     * */
    String forceCommit(String nodeInstId, String mangerUserCode);

    /**
     * 分配节点任务
     *  Task_assigned 设置为 S 如果多于 一个人 放在 ActionTask 表中，并且把  Task_assigned 设置为 T
     * @param nodeInstId 节点实例ID
     * @param userCode 操作用户
     * @param mangerUserCode 管理用户
     * @param authDesc 授权说明
     * */
    int assignNodeTask(String nodeInstId, String userCode,
                        String mangerUserCode, String authDesc);

    /**
     * 添加节点任务, 添加操作人元
     *  Task_assigned 设置为 S 如果多于 一个人 放在 ActionTask 表中，并且把  Task_assigned 设置为 T
     * @param nodeInstId 节点实例ID
     * @param userCode 操作用户
     * @param mangerUserCode 管理用户
     * @param authDesc 授权说明
     * */
    int addNodeTask(String nodeInstId, String userCode,
                     String mangerUserCode,  String authDesc);
    /**
     * 删除节点任务
     * @param nodeInstId 节点实例ID
     * @param userCode 操作用户
     * @param mangerUserCode 管理用户
     * */
    int deleteNodeTask(String nodeInstId, String userCode, String mangerUserCode);


    /**
     * 获取节点实例的操作日志列表
     * @param flowInstId 流程实例号
     * @param nodeInstId 节点实例好
     * @return List<WfActionLog>
     */
    List<OperationLog> listNodeActionLogs(String flowInstId, String nodeInstId);

    /**
     * 获取节点实例的操作日志列表
     *
     * @param flowInstId 流程实例号
     * @param withNodeAction 是否包括节点的日志
     * @return List<WfActionLog>
     */
    List<OperationLog> listFlowActionLogs(String flowInstId, boolean withNodeAction);

    /**
     * 获取用户所有的操作记录
     *
     * @param userCode
     * @param pageDesc 和分页机制结合
     * @param lastTime if null return all
     * @return
     */
    List<OperationLog> listUserActionLogs(String userCode, PageDesc pageDesc, Date lastTime);

}
