package com.example.campus.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.campus.common.RoleName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学生
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Student对象", description="学生")
public class Student implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "微信OpenID")
    private String openId;

    @TableId
    @ApiModelProperty(value = "ID即学号")
    private String id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private Boolean sex;

    @ApiModelProperty(value = "专业")
    private String speciality;

    @ApiModelProperty(value = "学院")
    private String collage;

    private String avatarUrl;

    @TableField(exist = false)
    private Integer postCount;

    @TableField(exist = false)
    private Integer communityCount;

}
