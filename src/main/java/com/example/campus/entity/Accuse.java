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
 * 举报
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Accuse对象", description="举报")
public class Accuse implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "帖子ID")
    private String postId;

    @ApiModelProperty(value = "举报人ID")
    private String studentId;

    @ApiModelProperty(value = "举报类型")
    private Integer reasonType;

    @ApiModelProperty(value = "举报内容")
    private String content;

    @ApiModelProperty(value = "举报时间")
    private LocalDateTime time;


}
