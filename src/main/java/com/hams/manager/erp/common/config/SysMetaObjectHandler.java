package com.hams.manager.erp.common.config;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.hams.manager.erp.common.base.MySysUser;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 功能说明: mybatisplus自定义填充公共字段 ,即没有传的字段自动填充<br>
 * 系统版本: v1.0<br>
 * 开发人员: @author lh<br>
 * 开发时间: 2020/4/12<br>
 */
@Component
public class SysMetaObjectHandler extends MetaObjectHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //新增填充
    @Override
    public void insertFill(MetaObject metaObject) {
        logger.info("正在调用该insert填充字段方法");
        Object createDate = getFieldValByName("createDate",metaObject);
        Object createId = getFieldValByName("createId",metaObject);
        Object updateDate = getFieldValByName("updateDate",metaObject);
        Object updateId = getFieldValByName("updateId",metaObject);


        if (null == createDate) {
            setFieldValByName("createDate", new Date(),metaObject);
        }
        if (null == createId) {
            if(MySysUser.ShiroUser() != null) {
                setFieldValByName("createId", MySysUser.id(), metaObject);
            }
        }
        if (null == updateDate) {
            setFieldValByName("updateDate", new Date(),metaObject);
        }
        if (null == updateId) {
            if(MySysUser.ShiroUser() != null) {
                setFieldValByName("updateId", MySysUser.id(), metaObject);
            }
        }
    }

    //更新填充
    @Override
    public void updateFill(MetaObject metaObject) {
        logger.info("正在调用该update填充字段方法");
        setFieldValByName("updateDate",new Date(), metaObject);
        Object updateId = getFieldValByName("updateId",metaObject);
        if (null == updateId) {
            setFieldValByName("updateId", MySysUser.id(), metaObject);
        }
    }
}
