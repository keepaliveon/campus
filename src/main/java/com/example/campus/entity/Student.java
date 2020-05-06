package com.example.campus.entity;

import java.io.Serializable;

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

    @ApiModelProperty(value = "ID(即学号)")
    private String id;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "专业")
    private String speciality;

    @ApiModelProperty(value = "学院")
    private String collage;

    public String getRole() {
        return RoleName.ROLE_STUDENT.name();
    }

}