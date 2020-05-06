package com.example.campus.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学生加入社团中间表
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Join对象", description="学生加入社团中间表")
public class Join implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "学生ID")
    private String studentId;

    @ApiModelProperty(value = "社团ID")
    private Integer communityId;

    @ApiModelProperty(value = "状态")
    private Integer state;


}
