package com.example.campus.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 社团标签
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CommunityTag对象", description="社团标签")
public class CommunityTag implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "标签ID")
    private Integer tagId;

    @ApiModelProperty(value = "社团ID")
    private Integer communityId;


}
