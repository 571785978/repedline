package com.example.timing;

import com.example.reptile.netease.entrance.PlayListEntrance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author
 */
@Component
public class NeteaseMusicTiming {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    PlayListEntrance playListEntrance;

    /**
     * 每天一次
     */
    @Scheduled(/*cron = "0 0 8 * * ?"*/fixedDelay = 1000*60*60*12)
    private void doReptileList(){
        logger.info("------>开始执行网易云爬虫");
        playListEntrance.doReptile();
        logger.info("------>执行完成");
    }


}
