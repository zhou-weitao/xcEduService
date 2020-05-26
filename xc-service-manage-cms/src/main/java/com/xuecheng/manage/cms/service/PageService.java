package com.xuecheng.manage.cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsCode;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage.cms.dao.CmsPageRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author wtzhou
 */
@Service
public class PageService {

    private final CmsPageRepository cmsPageRepository;

    public PageService(CmsPageRepository cmsPageRepository) {
        this.cmsPageRepository = cmsPageRepository;
    }


    /**
     * 页面查询方法
     *
     * @param page             页码，从1开始记数
     * @param size             每页记录数
     * @param queryPageRequest 查询条件
     * @return 查询列表
     */
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
        //条件匹配器
        //页面名称模糊查询，需要自定义字符串的匹配器实现模糊查询
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        CmsPage cmsPage = new CmsPage();
        //站点ID
        if (StringUtils.isNotEmpty(queryPageRequest.getSiteId())) {
            cmsPage.setSiteId(queryPageRequest.getSiteId());
        }
        //页面别名
        if (StringUtils.isNotEmpty(queryPageRequest.getPageAliase())) {
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());
        }
        //创建条件实例
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        //分页参数
        if (page <= 0) {
            page = 1;
        }

        page = page - 1;
        if (size <= 0) {
            size = 10;
        }

        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        QueryResult<CmsPage> queryResult = new QueryResult<>();
        queryResult.setList(all.getContent());
        queryResult.setTotal(all.getTotalElements());
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }

    /**
     * 添加页面
     *
     * @param cmsPage 页面详情
     * @return 页面添加结果
     */
    public CmsPageResult save(CmsPage cmsPage) {
        //查询页面是否存在
        CmsPage cmsPageByPageNameAndSiteIdAndPageWebPath = cmsPageRepository.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(), cmsPage.getSiteId(), cmsPage.getPageWebPath());
        if (cmsPageByPageNameAndSiteIdAndPageWebPath != null) {
            //页面已存在
            return new CmsPageResult(CmsCode.CMS_ADD_PAGE_EXISTS, null);
        }
        cmsPage.setPageId(null);
        CmsPage savedPage = cmsPageRepository.save(cmsPage);
        return new CmsPageResult(CommonCode.SUCCESS, savedPage);
    }

    /**
     * 更新页面
     *
     * @param id      页面ID
     * @param cmsPage 页面详情
     * @return 更新结果
     */
    public CmsPageResult update(String id, CmsPage cmsPage) {
        Optional<CmsPage> optional = cmsPageRepository.findById(id);
        if (optional.isPresent()) {
            CmsPage page = optional.get();
            page.setTemplateId(cmsPage.getTemplateId());
            page.setSiteId(cmsPage.getSiteId());
            page.setPageName(cmsPage.getPageName());
            page.setPageWebPath(cmsPage.getPageWebPath());
            page.setPagePhysicalPath(cmsPage.getPagePhysicalPath());
            page.setDataUrl(cmsPage.getDataUrl());
            page.setHtmlFileId(cmsPage.getHtmlFileId());
            page.setPageId(cmsPage.getPageId());
            page.setPageParameter(cmsPage.getPageParameter());
            page.setPageAliase(cmsPage.getPageAliase());
            page.setPageType(cmsPage.getPageType());
            page.setPageTemplate(cmsPage.getPageTemplate());
            page.setPageCreateTime(cmsPage.getPageCreateTime());
            page.setPageHtml(cmsPage.getPageHtml());
            page.setPageStatus(cmsPage.getPageStatus());
            page.setPageParams(cmsPage.getPageParams());
            CmsPage save = cmsPageRepository.save(page);
            return new CmsPageResult(CommonCode.SUCCESS, save);

        }
        return new CmsPageResult(CmsCode.CMS_PAGE_DOES_NOT_EXIST, null);
    }

    /**
     * 根据ID查询页面
     *
     * @param id 页面ID
     * @return 页面详情
     */
    public CmsPage findById(String id) {
        Optional<CmsPage> optional = cmsPageRepository.findById(id);
        return optional.orElse(null);
    }

    /**
     * 删除页面
     * @param id 页面ID
     * @return 删除结果
     */
    public ResponseResult delete(String id) {
        Optional<CmsPage> optional = cmsPageRepository.findById(id);
        if (optional.isPresent()) {
            cmsPageRepository.deleteById(id);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }
}
