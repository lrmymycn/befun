package com.befun.dao.common;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.WeakHashMap;

import javax.persistence.Id;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.befun.common.KeySynchronizer;

public class PageUtil {

    private static final Log log = LogFactory.getLog(PageUtil.class);

    /**
     * 获取主键时缓存
     */
    private static Map<Class<?>, Field> classPKMap = new WeakHashMap<Class<?>, Field>();

    /**
     * 不关心总记录数
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public static int getPageStart(long pageNumber, int pageSize) {
        return ((Long) ((pageNumber - 1) * pageSize)).intValue();
    }

    /**
     * 计算分页获取数据时游标的起始位置
     * 
     * @param totalCount 所有记录总和
     * @param pageNumber 页码,从1开始
     * @return
     */
    public static int getPageStart(int totalCount, int pageNumber, int pageSize) {
        int start = (pageNumber - 1) * pageSize;
        if (start >= totalCount) {
            start = 0;
        }

        return start;
    }

    public static Field getPkField(Class<?> cls) {
        Field pkField = classPKMap.get(cls);
        if (pkField == null) {
            synchronized (KeySynchronizer.acquire(cls)) {
                Field[] fields = cls.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Id.class)) {
                        pkField = field;
                        pkField.setAccessible(true);
                        classPKMap.put(cls, pkField);
                    }
                }
            }
        }
        if (pkField == null) {
            log.error("page error, " + cls + " : pk null");
        }
        return pkField;
    }

    public static <T> String getIdValue(T obj) {
        if (obj == null) {
            return "";
        }
        String retVal = "";
        Field pkField = getPkField(obj.getClass());
        try {
            retVal = pkField.get(obj).toString();
        } catch (Exception e) {
            log.error("page error, " + obj + " : get id value");
        }
        return retVal;
    }

    public static <T> String getIdName(T obj) {
        if (obj == null) {
            return "";
        }
        String retVal = "";
        Field pkField = getPkField(obj.getClass());
        try {
            retVal = pkField.getName();
        } catch (Exception e) {
            log.error("page error, " + obj + " : get id name");
        }
        return retVal;
    }
}
