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
 * 点赞
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Like对象", description="点赞")
public class Like implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "帖子ID")
    private String postId;

    @ApiModelProperty(value = "学生ID")
    private String studentId;

    @ApiModelProperty(value = "点赞时间")
    private LocalDateTime time;


}
