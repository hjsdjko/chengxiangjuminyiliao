package com.entity.model;

import com.entity.YishengGuahaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 医生挂号
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YishengGuahaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 挂号编号
     */
    private String yishengGuahaoUuidNumber;


    /**
     * 病人
     */
    private Integer bingrenId;


    /**
     * 医生
     */
    private Integer yishengId;


    /**
     * 花费金额
     */
    private Double huafeijine;


    /**
     * 挂号日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yishengGuahaoTime;


    /**
     * 挂号状态
     */
    private Integer yishengGuahaoTypes;


    /**
     * 申请挂号时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：挂号编号
	 */
    public String getYishengGuahaoUuidNumber() {
        return yishengGuahaoUuidNumber;
    }


    /**
	 * 设置：挂号编号
	 */
    public void setYishengGuahaoUuidNumber(String yishengGuahaoUuidNumber) {
        this.yishengGuahaoUuidNumber = yishengGuahaoUuidNumber;
    }
    /**
	 * 获取：病人
	 */
    public Integer getBingrenId() {
        return bingrenId;
    }


    /**
	 * 设置：病人
	 */
    public void setBingrenId(Integer bingrenId) {
        this.bingrenId = bingrenId;
    }
    /**
	 * 获取：医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 设置：医生
	 */
    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 获取：花费金额
	 */
    public Double getHuafeijine() {
        return huafeijine;
    }


    /**
	 * 设置：花费金额
	 */
    public void setHuafeijine(Double huafeijine) {
        this.huafeijine = huafeijine;
    }
    /**
	 * 获取：挂号日期
	 */
    public Date getYishengGuahaoTime() {
        return yishengGuahaoTime;
    }


    /**
	 * 设置：挂号日期
	 */
    public void setYishengGuahaoTime(Date yishengGuahaoTime) {
        this.yishengGuahaoTime = yishengGuahaoTime;
    }
    /**
	 * 获取：挂号状态
	 */
    public Integer getYishengGuahaoTypes() {
        return yishengGuahaoTypes;
    }


    /**
	 * 设置：挂号状态
	 */
    public void setYishengGuahaoTypes(Integer yishengGuahaoTypes) {
        this.yishengGuahaoTypes = yishengGuahaoTypes;
    }
    /**
	 * 获取：申请挂号时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请挂号时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
