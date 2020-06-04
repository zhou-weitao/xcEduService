package com.xuecheng.manage.cms.dao;

import com.xuecheng.framework.domain.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author wtzhou
 * @date 2020/6/3 4:19 下午
 **/
public interface CmsPageConfigRepository extends MongoRepository<CmsConfig, String> {

}
