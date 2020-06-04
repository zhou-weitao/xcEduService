package com.xuecheng.manage.cms.service;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.manage.cms.dao.CmsPageConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author wtzhou
 * @date 2020/6/3 4:20 下午
 **/
@Service
public class CmsConfigService {

    private final CmsPageConfigRepository cmsPageConfigRepository;

    public CmsConfigService(CmsPageConfigRepository cmsPageConfigRepository) {
        this.cmsPageConfigRepository = cmsPageConfigRepository;
    }

    /**
     * 根据ID查询页面配置
     * @param id 页面配置ID
     * @return 页面配置
     */
    public CmsConfig getModel(String id) {
        Optional<CmsConfig> optional = cmsPageConfigRepository.findById(id);
        return optional.orElse(null);
    }
}
