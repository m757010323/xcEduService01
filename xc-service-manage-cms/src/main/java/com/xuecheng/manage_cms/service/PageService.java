package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PageService {
    @Autowired
    CmsPageRepository cmsPageRepository;

    /**
     *  页面列表分类查询
     * @param page 当前页码
     * @param size 一页的大小
     * @param queryPageRequest  查询条件
     * @return  页面列表
     */
    public QueryResponseResult findByList(int page, int size, QueryPageRequest queryPageRequest){
        if(queryPageRequest == null){
            queryPageRequest = new QueryPageRequest();
        }
        if(page <= 0){
            page =1;
        }
        page = page-1;//为了适应mongodb数据库做-1
        if(size<= 0 ){
            size =20;
        }

        Pageable pageable = new PageRequest(page,size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        QueryResult queryResult = new QueryResult<CmsPage>();
        queryResult.setList(all.getContent());
        queryResult.setTotal(all.getTotalElements());
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}
