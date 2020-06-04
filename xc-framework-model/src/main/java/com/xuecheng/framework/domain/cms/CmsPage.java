package com.xuecheng.framework.domain.cms;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;


@Data
@ToString
@Document(collection = "cms_page")
public class CmsPage {
    /**
     * 页面名称、别名、访问地址、类型（静态/动态）、页面模版、状态
     */
    private String siteId;
    @Id
    private String pageId;
    private String pageName;
    private String pageAlias;
    private String pageWebPath;
    private String pageParameter;
    private String pagePhysicalPath;
    private String pageType;
    private String pageTemplate;
    private String pageHtml;
    private String pageStatus;
    private Date pageCreateTime;
    private String templateId;
    private List<CmsPageParam> pageParams;
    private String templateFileId;
    private String htmlFileId;
    private String dataUrl;



}
