package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author wtzhou
 * @date 2020/6/3 4:09 下午
 **/
@Api(value = "cms页面配置管理接口", description = "cms页面配置管理接口，提供页面配置查询及管理")
public interface CmsPageConfigControllerApi {

    /**
     * 根据ID查询页面配置信息
     *
     * @param id 页面配置ID
     * @return 页面配置
     */
    @ApiOperation("根据ID查询页面配置信息")
    CmsConfig getModel(String id);
}
