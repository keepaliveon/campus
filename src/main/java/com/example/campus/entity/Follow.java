package com.example.campus.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 关注
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Follow对象", description="关注")
public class Follow implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "被关注者ID")
    private String studentId;

    @ApiModelProperty(value = "关注者ID")
    private String followerId;


}
