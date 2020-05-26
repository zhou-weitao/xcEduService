package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author wtzhou
 */
@Api(value="cms页面管理接口",description = "cms页面管理接口，提供页面的增、删、改、查")
public interface CmsPageControllerApi {
    /**
     * 页面查询
     * @param page 当前页
     * @param size 每页记录数
     * @param queryPageRequest 页面参数
     * @return 分页查询结果
     */
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录数",required=true,paramType="path",dataType="int")
    })
    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);

    /**
     * 添加页面
     * @param cmsPage 页面详情
     * @return 添加结果
     */
    @ApiOperation("添加页面")
    CmsPageResult add(CmsPage cmsPage);

    /**
     * 根据ID查询页面
     * @param id 页面
     * @return 页面详情
     */
    @ApiOperation("根据ID查询页面")
    CmsPage findById(String id);

    /**
     * 修改页面
     * @param id 页面ID
     * @param cmsPage 页面详情
     * @return 修改结果
     */
    @ApiOperation("修改页面")
    CmsPageResult edit(String id,CmsPage cmsPage);

    /**
     * 删除页面
     * @param id 页面ID
     * @return 删除结果
     */
    @ApiOperation("删除页面")
    ResponseResult delete(String id);
}
