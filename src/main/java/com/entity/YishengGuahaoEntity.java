package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 医生挂号
 *
 * @author 
 * @email
 */
@TableName("yisheng_guahao")
public class YishengGuahaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YishengGuahaoEntity() {

	}

	public YishengGuahaoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 挂号编号
     */
    @ColumnInfo(comment="挂号编号",type="varchar(200)")
    @TableField(value = "yisheng_guahao_uuid_number")

    private String yishengGuahaoUuidNumber;


    /**
     * 病人
     */
    @ColumnInfo(comment="病人",type="int(11)")
    @TableField(value = "bingren_id")

    private Integer bingrenId;


    /**
     * 医生
     */
    @ColumnInfo(comment="医生",type="int(11)")
    @TableField(value = "yisheng_id")

    private Integer yishengId;


    /**
     * 花费金额
     */
    @ColumnInfo(comment="花费金额",type="decimal(10,2)")
    @TableField(value = "huafeijine")

    private Double huafeijine;


    /**
     * 挂号日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="挂号日期",type="date")
    @TableField(value = "yisheng_guahao_time")

    private Date yishengGuahaoTime;


    /**
     * 挂号状态
     */
    @ColumnInfo(comment="挂号状态",type="int(11)")
    @TableField(value = "yisheng_guahao_types")

    private Integer yishengGuahaoTypes;


    /**
     * 申请挂号时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请挂号时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "YishengGuahao{" +
            ", id=" + id +
            ", yishengGuahaoUuidNumber=" + yishengGuahaoUuidNumber +
            ", bingrenId=" + bingrenId +
            ", yishengId=" + yishengId +
            ", huafeijine=" + huafeijine +
            ", yishengGuahaoTime=" + DateUtil.convertString(yishengGuahaoTime,"yyyy-MM-dd") +
            ", yishengGuahaoTypes=" + yishengGuahaoTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
