package com.example.campus.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.example.campus.common.RoleName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Admin对象", description="管理员")
public class Admin implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户名")
    @TableId
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    public String getRole() {
        return RoleName.ROLE_ADMIN.name();
    }

}
