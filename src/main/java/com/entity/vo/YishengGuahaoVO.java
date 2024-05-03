package com.entity.vo;

import com.entity.YishengGuahaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 医生挂号
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yisheng_guahao")
public class YishengGuahaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 挂号编号
     */

    @TableField(value = "yisheng_guahao_uuid_number")
    private String yishengGuahaoUuidNumber;


    /**
     * 病人
     */

    @TableField(value = "bingren_id")
    private Integer bingrenId;


    /**
     * 医生
     */

    @TableField(value = "yisheng_id")
    private Integer yishengId;


    /**
     * 花费金额
     */

    @TableField(value = "huafeijine")
    private Double huafeijine;


    /**
     * 挂号日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yisheng_guahao_time")
    private Date yishengGuahaoTime;


    /**
     * 挂号状态
     */

    @TableField(value = "yisheng_guahao_types")
    private Integer yishengGuahaoTypes;


    /**
     * 申请挂号时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：挂号编号
	 */
    public String getYishengGuahaoUuidNumber() {
        return yishengGuahaoUuidNumber;
    }


    /**
	 * 获取：挂号编号
	 */

    public void setYishengGuahaoUuidNumber(String yishengGuahaoUuidNumber) {
        this.yishengGuahaoUuidNumber = yishengGuahaoUuidNumber;
    }
    /**
	 * 设置：病人
	 */
    public Integer getBingrenId() {
        return bingrenId;
    }


    /**
	 * 获取：病人
	 */

    public void setBingrenId(Integer bingrenId) {
        this.bingrenId = bingrenId;
    }
    /**
	 * 设置：医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 获取：医生
	 */

    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 设置：花费金额
	 */
    public Double getHuafeijine() {
        return huafeijine;
    }


    /**
	 * 获取：花费金额
	 */

    public void setHuafeijine(Double huafeijine) {
        this.huafeijine = huafeijine;
    }
    /**
	 * 设置：挂号日期
	 */
    public Date getYishengGuahaoTime() {
        return yishengGuahaoTime;
    }


    /**
	 * 获取：挂号日期
	 */

    public void setYishengGuahaoTime(Date yishengGuahaoTime) {
        this.yishengGuahaoTime = yishengGuahaoTime;
    }
    /**
	 * 设置：挂号状态
	 */
    public Integer getYishengGuahaoTypes() {
        return yishengGuahaoTypes;
    }


    /**
	 * 获取：挂号状态
	 */

    public void setYishengGuahaoTypes(Integer yishengGuahaoTypes) {
        this.yishengGuahaoTypes = yishengGuahaoTypes;
    }
    /**
	 * 设置：申请挂号时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请挂号时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
