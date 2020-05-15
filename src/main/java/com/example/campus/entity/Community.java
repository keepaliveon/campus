package com.example.campus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.campus.common.RoleName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 社团
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Community对象", description="社团")
public class Community implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id")
    private String id;

    @ApiModelProperty(value = "社团名称")
    private String name;

    @ApiModelProperty(value = "登陆密码")
    private String password;

    @ApiModelProperty(value = "介绍")
    private String intro;

    @ApiModelProperty(value = "图片名称")
    private String imgName;

    @ApiModelProperty(value = "图片URL")
    private String imgUrl;

    @ApiModelProperty(value = "封面")
    @TableField(exist = false)
    private List<String> images = new ArrayList<>();

    public String getRole() {
        return RoleName.ROLE_COMMUNITY.name();
    }

}
