package com.example.campus.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 评论
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Comment对象", description="评论")
public class Comment implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "ID")
    private String id;

    @ApiModelProperty(value = "帖子ID")
    private String postId;

    @ApiModelProperty(value = "学生ID")
    private String studentId;

    @ApiModelProperty(value = "评论时间")
    private LocalDateTime time;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "回复评论ID")
    private String toCommentId;


}
