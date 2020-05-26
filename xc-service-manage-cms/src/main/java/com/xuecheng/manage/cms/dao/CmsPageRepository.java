package com.xuecheng.manage.cms.dao;


import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author wtzhou
 */
public interface CmsPageRepository extends MongoRepository<CmsPage,String> {

    /**
     * 页面名称查询
     *
     * @param pageName 页面名称
     * @return 页面
     */
    CmsPage findByPageName(String pageName);

    /**
     * 根据页面名称/站点ID/页面访问路径查询
     *
     * @param pageName    页面名称
     * @param siteId      站点ID
     * @param pageWebPath 访问路径
     * @return 页面
     */
    CmsPage findByPageNameAndSiteIdAndPageWebPath(String pageName, String siteId, String pageWebPath);

}
