package com.client.test;

import com.gafis.SpringbootMyBatisApplication;
import com.gafis.model.Report;
import com.gafis.service.ReportImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by win-20161010 on 2017/1/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootMyBatisApplication.class)
//@WebAppConfiguration
public class ReportTest {
    @Autowired
    ReportImpl reports;

    @Test
    public void test_ReportXiZhuanTenPrint() throws Exception {
        Report reportMap = new Report();
        reportMap.setTitle("123");
        reportMap.setDate("12344");
        reportMap.setContent("123");
        reports.saveUser(reportMap);
    }
}
