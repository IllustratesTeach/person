package com.gafis.service;

import com.gafis.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/8/29.
 */
@RestController
@Component
@RequestMapping("/bom")
public class ReportImpl extends Report{
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     * @param user
     */
    @RequestMapping("/saveuser")
    public void saveUser(Report user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据用户名查询对象
     * @param title
     * @return
     */
    @RequestMapping("/select")
    public Report findUserByUserName(String title) {
        Query query=new Query(Criteria.where("title").is(title));
        Report user =  mongoTemplate.findOne(query , Report.class);
        return user;
    }

    /**
     * 更新对象
     * @param user
     */
    @RequestMapping("/update")
    public void updateUser(Report user) {
        Query query=new Query(Criteria.where("id").is(user.getId()));
        Update update= new Update().set("title", user.getTitle()).set("content", user.getContent());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,Report.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
    }

    /**
     * 删除对象
     * @param id
     */
    @RequestMapping("/delete")
    public int deleteUserById(String id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,Report.class);
        return 123;
    }
}
