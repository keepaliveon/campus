package com.example.campus.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 帖子
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Post对象", description="帖子")
public class Post implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId
    @ApiModelProperty(value = "ID")
    private String id;

    @ApiModelProperty(value = "学生ID")
    private String studentId;

    @ApiModelProperty(value = "板块ID")
    private Integer groupId;

    @ApiModelProperty(value = "社团ID")
    private Integer communityId;

    @ApiModelProperty(value = "发布时间")
    private LocalDateTime time;

    @ApiModelProperty(value = "发布内容")
    private String content;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "配图")
    private String picUrl;

    @ApiModelProperty(value = "头像")
    @TableField(exist = false)
    private String avatarUrl;

    @ApiModelProperty(value = "姓名")
    @TableField(exist = false)
    private String name;

}
