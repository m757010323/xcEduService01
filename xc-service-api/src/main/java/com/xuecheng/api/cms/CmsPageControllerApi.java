package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value ="cms页面管理接口",description = "页面管理接口,提供页面的增删改查")
public interface CmsPageControllerApi {
    @ApiOperation("分页查询列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "page",value = "页码",required = true,paramType = "path",dataType = "int"),
                        @ApiImplicitParam(name = "size",value = "每页显示条目",required = true,paramType = "path",dataType = "int")
    })
    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
}
