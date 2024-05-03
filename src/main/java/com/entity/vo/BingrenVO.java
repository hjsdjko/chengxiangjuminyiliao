package com.entity.vo;

import com.entity.BingrenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 病人
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bingren")
public class BingrenVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 看护人姓名
     */

    @TableField(value = "kanhuren_name")
    private String kanhurenName;


    /**
     * 看护人联系方式
     */

    @TableField(value = "kanhuren_phone")
    private String kanhurenPhone;


    /**
     * 病人姓名
     */

    @TableField(value = "bingren_name")
    private String bingrenName;


    /**
     * 病人手机号
     */

    @TableField(value = "bingren_phone")
    private String bingrenPhone;


    /**
     * 病人身份证号
     */

    @TableField(value = "bingren_id_number")
    private String bingrenIdNumber;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 病人类型
     */

    @TableField(value = "bingren_types")
    private Integer bingrenTypes;


    /**
     * 年龄
     */

    @TableField(value = "age")
    private Integer age;


    /**
     * 病人照片
     */

    @TableField(value = "bingren_photo")
    private String bingrenPhoto;


    /**
     * 病人描述
     */

    @TableField(value = "bingren_content")
    private String bingrenContent;


    /**
     * 录入时间
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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：看护人姓名
	 */
    public String getKanhurenName() {
        return kanhurenName;
    }


    /**
	 * 获取：看护人姓名
	 */

    public void setKanhurenName(String kanhurenName) {
        this.kanhurenName = kanhurenName;
    }
    /**
	 * 设置：看护人联系方式
	 */
    public String getKanhurenPhone() {
        return kanhurenPhone;
    }


    /**
	 * 获取：看护人联系方式
	 */

    public void setKanhurenPhone(String kanhurenPhone) {
        this.kanhurenPhone = kanhurenPhone;
    }
    /**
	 * 设置：病人姓名
	 */
    public String getBingrenName() {
        return bingrenName;
    }


    /**
	 * 获取：病人姓名
	 */

    public void setBingrenName(String bingrenName) {
        this.bingrenName = bingrenName;
    }
    /**
	 * 设置：病人手机号
	 */
    public String getBingrenPhone() {
        return bingrenPhone;
    }


    /**
	 * 获取：病人手机号
	 */

    public void setBingrenPhone(String bingrenPhone) {
        this.bingrenPhone = bingrenPhone;
    }
    /**
	 * 设置：病人身份证号
	 */
    public String getBingrenIdNumber() {
        return bingrenIdNumber;
    }


    /**
	 * 获取：病人身份证号
	 */

    public void setBingrenIdNumber(String bingrenIdNumber) {
        this.bingrenIdNumber = bingrenIdNumber;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：病人类型
	 */
    public Integer getBingrenTypes() {
        return bingrenTypes;
    }


    /**
	 * 获取：病人类型
	 */

    public void setBingrenTypes(Integer bingrenTypes) {
        this.bingrenTypes = bingrenTypes;
    }
    /**
	 * 设置：年龄
	 */
    public Integer getAge() {
        return age;
    }


    /**
	 * 获取：年龄
	 */

    public void setAge(Integer age) {
        this.age = age;
    }
    /**
	 * 设置：病人照片
	 */
    public String getBingrenPhoto() {
        return bingrenPhoto;
    }


    /**
	 * 获取：病人照片
	 */

    public void setBingrenPhoto(String bingrenPhoto) {
        this.bingrenPhoto = bingrenPhoto;
    }
    /**
	 * 设置：病人描述
	 */
    public String getBingrenContent() {
        return bingrenContent;
    }


    /**
	 * 获取：病人描述
	 */

    public void setBingrenContent(String bingrenContent) {
        this.bingrenContent = bingrenContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
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
