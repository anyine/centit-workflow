package com.centit.workflow.dao;

import com.centit.framework.core.dao.CodeBook;
import com.centit.framework.jdbc.dao.BaseDaoImpl;
import com.centit.workflow.po.InstAttention;
import com.centit.workflow.po.InstAttentionId;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InstAttentionDao extends BaseDaoImpl<InstAttention,InstAttentionId>
    {
        //public static final Logger logger = LoggerFactory.getLogger(WfInstAttentionDao.class);
    @Override
    public Map<String, String> getFilterField() {
        Map<String, String> filterField = new HashMap<String, String>();

        filterField.put("userCode" , "userCode=:userCode");
        filterField.put("flowInstId" , "flowInstId=:flowInstId");
        filterField.put("attSetTime" , CodeBook.LIKE_HQL_ID);
        filterField.put("attSetUser" , CodeBook.LIKE_HQL_ID);
        filterField.put("attSetMemo" , CodeBook.LIKE_HQL_ID);
        return filterField;
    }
    /**
     * 删除一个流程的所有关注
     * @param flowInstId
     */
    @Transactional
    public void deleteFlowAttention(String flowInstId) {
        this.getJdbcTemplate().update("delete from WF_INST_ATTENTION where FLOW_INST_ID = ?",
                new Object[]{flowInstId});
    }
    /**
     * 获得一个流程的所有关注
     * @param flowInstId
     */
    @Transactional
    public List<InstAttention> listAttentionByFlowInstId(String flowInstId) {
        return this.listObjectsByFilter("where FLOW_INST_ID = ?",new Object[]{flowInstId});
    }
    @Transactional
    public List<InstAttention> listAttentionByFlowInstId(String flowInstId, String optUser) {
        return this.listObjectsByFilter("where FLOW_INST_ID = ? and ATT_SET_USER = ? ",new Object[]{flowInstId,optUser});

    }
    @Transactional
    public void deleteFlowAttentionByOptUser(String flowInstId,String optUser)
    {
        this.jdbcTemplate.update("delete From WF_INST_ATTENTION where FLOW_INST_ID = ? and ATT_SET_USER = ? ",
                new Object[]{flowInstId,optUser});
    }
}
