package com.example.campus.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("`join`")
public class Join implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "学生ID")
    private String studentId;

    @ApiModelProperty(value = "社团ID")
    private String communityId;

    @ApiModelProperty(value = "状态")
    private Boolean state;

    @ApiModelProperty(value = "学生姓名")
    @TableField(exist = false)
    private String studentName;

    @ApiModelProperty(value = "性别")
    @TableField(exist = false)
    private Boolean sex;

    @ApiModelProperty(value = "专业")
    @TableField(exist = false)
    private String speciality;

    @ApiModelProperty(value = "学院")
    @TableField(exist = false)
    private String collage;

    @ApiModelProperty(value = "头像")
    @TableField(exist = false)
    private String avatarUrl;

    @ApiModelProperty(value = "社团名称")
    private String communityName;

}
