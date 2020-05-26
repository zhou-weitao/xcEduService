package com.xuecheng.framework.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author wtzhou
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class QueryResponseResult extends ResponseResult {

    private QueryResult queryResult;

    public QueryResponseResult(ResultCode resultCode,QueryResult queryResult){
        super(resultCode);
        this.queryResult = queryResult;
    }

}

