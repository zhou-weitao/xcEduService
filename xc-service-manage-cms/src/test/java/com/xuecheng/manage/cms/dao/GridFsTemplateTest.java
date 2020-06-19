package com.xuecheng.manage.cms.dao;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author wtzhou
 * @date 2020/6/9 3:25 下午
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class GridFsTemplateTest {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFSBucket gridFSBucket;

    @Test
    public void generateFile() throws FileNotFoundException {
        //添加文件
        File file = new File("/Users/wtzhou/IdeaProjects/xuecheng/portal/xc-ui-pc-static-portal/index.html");
        FileInputStream inputStream = new FileInputStream(file);
        ObjectId store = gridFsTemplate.store(inputStream, "轮播图测试文件", "");
        System.out.println("返回的文件ID为"+store.toString());
    }

    @Test
    public void getFile() throws IOException {
        String id = "5eec61503ac7a806b88370a6";
        //查文件
        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(id)));
        //写入流
        assert gridFSFile != null;
        GridFSDownloadStream downloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
        //创建gridFSResource
        GridFsResource gridFsResource = new GridFsResource(gridFSFile, downloadStream);
        //从流中获取数据
        String content = IOUtils.toString(gridFsResource.getInputStream(), StandardCharsets.UTF_8);
        System.out.println(content);
    }
}
