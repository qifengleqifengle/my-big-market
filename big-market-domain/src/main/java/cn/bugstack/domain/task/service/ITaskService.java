package cn.bugstack.domain.task.service;

import cn.bugstack.domain.task.model.entity.TaskEntity;

import java.util.List;

public interface ITaskService {
    // 查询所有未发送消息的任务列表
    List<TaskEntity> queryNoSendMessageTaskList();
    // 发送消息
    void sendMessage(TaskEntity taskEntity);
    // 更新任务为已发送消息完成
    void updateTaskSendMessageCompleted(String userId, String messageId);
    // 更新任务为发送消息失败
    void updateTaskSendMessageFail(String userId, String messageId);
}
