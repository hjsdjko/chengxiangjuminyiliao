package com.entity.model;

import com.entity.BingrenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 病人
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BingrenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 看护人姓名
     */
    private String kanhurenName;


    /**
     * 看护人联系方式
     */
    private String kanhurenPhone;


    /**
     * 病人姓名
     */
    private String bingrenName;


    /**
     * 病人手机号
     */
    private String bingrenPhone;


    /**
     * 病人身份证号
     */
    private String bingrenIdNumber;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 病人类型
     */
    private Integer bingrenTypes;


    /**
     * 年龄
     */
    private Integer age;


    /**
     * 病人照片
     */
    private String bingrenPhoto;


    /**
     * 病人描述
     */
    private String bingrenContent;


    /**
     * 录入时间
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
