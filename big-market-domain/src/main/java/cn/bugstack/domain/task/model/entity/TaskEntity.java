package cn.bugstack.domain.task.model.entity;

import lombok.Data;

@Data
public class TaskEntity {

    // 用户ID
    private String userId;
    // 任务类型
    private String topic;
    // 消息编号
    private String messageId;
    // 消息内容
    private String message;
}
