package com.example.campus.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学生标签
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="StudentTag对象", description="学生标签")
public class StudentTag implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "标签ID")
    private Integer tagId;

    @ApiModelProperty(value = "学生ID")
    private String studentId;


}
