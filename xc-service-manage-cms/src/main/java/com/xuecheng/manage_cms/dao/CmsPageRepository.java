package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsPageRepository extends MongoRepository<CmsPage,String> {
    //根据页面名称查询
    CmsPage findByPageName(String PageName);
    //根据页面名称和类型查找
    CmsPage findByPageNameAndPageType(String pageName, String pageType);
    //根据站点id和页面类型查找记录数
    int countBySiteIdAndPageType(String siteId, String pageType);
    //根据站点id和页面类型分页
    Page<CmsPage> findBySiteIdAndPageType(String siteId, String pageType, Pageable pageable);
}
