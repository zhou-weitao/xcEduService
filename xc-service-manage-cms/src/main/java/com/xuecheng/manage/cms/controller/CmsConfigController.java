package com.xuecheng.manage.cms.controller;

import com.xuecheng.api.cms.CmsPageConfigControllerApi;
import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.manage.cms.service.CmsConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wtzhou
 * @date 2020/6/3 4:25 下午
 **/
@RequestMapping("/page/config")
@RestController
public class CmsConfigController implements CmsPageConfigControllerApi {

    private final CmsConfigService cmsConfigService;

    public CmsConfigController(CmsConfigService cmsConfigService) {
        this.cmsConfigService = cmsConfigService;
    }


    @Override
    @GetMapping("/getModel/{id}")
    public CmsConfig getModel(@PathVariable("id") String id) {

        return cmsConfigService.getModel(id);
    }
}
