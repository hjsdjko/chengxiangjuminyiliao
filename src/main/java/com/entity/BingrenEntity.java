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
 * 病人
 *
 * @author 
 * @email
 */
@TableName("bingren")
public class BingrenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BingrenEntity() {

	}

	public BingrenEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 看护人姓名
     */
    @ColumnInfo(comment="看护人姓名",type="varchar(200)")
    @TableField(value = "kanhuren_name")

    private String kanhurenName;


    /**
     * 看护人联系方式
     */
    @ColumnInfo(comment="看护人联系方式",type="varchar(200)")
    @TableField(value = "kanhuren_phone")

    private String kanhurenPhone;


    /**
     * 病人姓名
     */
    @ColumnInfo(comment="病人姓名",type="varchar(200)")
    @TableField(value = "bingren_name")

    private String bingrenName;


    /**
     * 病人手机号
     */
    @ColumnInfo(comment="病人手机号",type="varchar(200)")
    @TableField(value = "bingren_phone")

    private String bingrenPhone;


    /**
     * 病人身份证号
     */
    @ColumnInfo(comment="病人身份证号",type="varchar(200)")
    @TableField(value = "bingren_id_number")

    private String bingrenIdNumber;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 病人类型
     */
    @ColumnInfo(comment="病人类型",type="int(11)")
    @TableField(value = "bingren_types")

    private Integer bingrenTypes;


    /**
     * 年龄
     */
    @ColumnInfo(comment="年龄",type="int(11)")
    @TableField(value = "age")

    private Integer age;


    /**
     * 病人照片
     */
    @ColumnInfo(comment="病人照片",type="varchar(200)")
    @TableField(value = "bingren_photo")

    private String bingrenPhoto;


    /**
     * 病人描述
     */
    @ColumnInfo(comment="病人描述",type="text")
    @TableField(value = "bingren_content")

    private String bingrenContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：看护人姓名
	 */
    public String getKanhurenName() {
        return kanhurenName;
    }
    /**
	 * 设置：看护人姓名
	 */

    public void setKanhurenName(String kanhurenName) {
        this.kanhurenName = kanhurenName;
    }
    /**
	 * 获取：看护人联系方式
	 */
    public String getKanhurenPhone() {
        return kanhurenPhone;
    }
    /**
	 * 设置：看护人联系方式
	 */

    public void setKanhurenPhone(String kanhurenPhone) {
        this.kanhurenPhone = kanhurenPhone;
    }
    /**
	 * 获取：病人姓名
	 */
    public String getBingrenName() {
        return bingrenName;
    }
    /**
	 * 设置：病人姓名
	 */

    public void setBingrenName(String bingrenName) {
        this.bingrenName = bingrenName;
    }
    /**
	 * 获取：病人手机号
	 */
    public String getBingrenPhone() {
        return bingrenPhone;
    }
    /**
	 * 设置：病人手机号
	 */

    public void setBingrenPhone(String bingrenPhone) {
        this.bingrenPhone = bingrenPhone;
    }
    /**
	 * 获取：病人身份证号
	 */
    public String getBingrenIdNumber() {
        return bingrenIdNumber;
    }
    /**
	 * 设置：病人身份证号
	 */

    public void setBingrenIdNumber(String bingrenIdNumber) {
        this.bingrenIdNumber = bingrenIdNumber;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：病人类型
	 */
    public Integer getBingrenTypes() {
        return bingrenTypes;
    }
    /**
	 * 设置：病人类型
	 */

    public void setBingrenTypes(Integer bingrenTypes) {
        this.bingrenTypes = bingrenTypes;
    }
    /**
	 * 获取：年龄
	 */
    public Integer getAge() {
        return age;
    }
    /**
	 * 设置：年龄
	 */

    public void setAge(Integer age) {
        this.age = age;
    }
    /**
	 * 获取：病人照片
	 */
    public String getBingrenPhoto() {
        return bingrenPhoto;
    }
    /**
	 * 设置：病人照片
	 */

    public void setBingrenPhoto(String bingrenPhoto) {
        this.bingrenPhoto = bingrenPhoto;
    }
    /**
	 * 获取：病人描述
	 */
    public String getBingrenContent() {
        return bingrenContent;
    }
    /**
	 * 设置：病人描述
	 */

    public void setBingrenContent(String bingrenContent) {
        this.bingrenContent = bingrenContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
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
        return "Bingren{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", kanhurenName=" + kanhurenName +
            ", kanhurenPhone=" + kanhurenPhone +
            ", bingrenName=" + bingrenName +
            ", bingrenPhone=" + bingrenPhone +
            ", bingrenIdNumber=" + bingrenIdNumber +
            ", sexTypes=" + sexTypes +
            ", bingrenTypes=" + bingrenTypes +
            ", age=" + age +
            ", bingrenPhoto=" + bingrenPhoto +
            ", bingrenContent=" + bingrenContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
