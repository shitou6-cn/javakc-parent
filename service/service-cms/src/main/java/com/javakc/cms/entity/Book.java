package com.javakc.cms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "cms_book")
public class Book {
    @Id
    @Column(name = "id") /* UUID 随机生成  主键id */
    @GeneratedValue(generator = "generator_uuid")
    @GenericGenerator(name = "generator_uuid", strategy = "uuid")
    @ApiModelProperty(value = "书籍主键,采用hibernate的uuid生成32位字符串")
    private String id ;
    @Column(name = "cp_id") /* 版权方书籍ID,据此得章节 */
    @ApiModelProperty(value = " 版权方书籍ID,据此得章节")
    private String cpId ;
    @Column(name = "book_name") /* 书名 */
    @ApiModelProperty(value = "书名")
    private String bookName ;
    @Column(name = "writer") /* 作者名 */
    @ApiModelProperty(value = "作者名")
    private String writer ;
    @Column(name = "type_one") /* 一级分类 */
    @ApiModelProperty(value = "作者名")
    private Integer typeOne ;
    @Column(name = "type_two") /* 二级分类 */
    @ApiModelProperty(value = "二级分类")
    private Integer typeTwo ;
    @Column(name = "world_count") /* 字数 */
    @ApiModelProperty(value = "字数")
    private Integer worldCount ;
    @Column(name = "is_serialize") /* 是否连载  0连载1完结 */
    @ApiModelProperty(value = "是否连载  0连载1完结")
    private Integer isSerialize ;
    @Column(name = "is_original") /* 是否原创 original 0是1不是 */
    @ApiModelProperty(value = "是否原创 original 0是1不是")
    private Integer isOriginal ;
    @Column(name = "charge") /* 全本收费 */
    @ApiModelProperty(value = "全本收费")
    private Double charge ;
    @Column(name = "easy_note") /* 简介 */
    @ApiModelProperty(value = "简介")
    private String easyNote ;
    @Column(name = "authorization_start") /* 授权开始时间 */
    @ApiModelProperty(value = "授权开始时间")
    private Date authorizationStart ;
    @Column(name = "authorization_stop") /* 授权结束时间 */
    @ApiModelProperty(value = "授权结束时间")
    private Date authorizationStop ;
    @Column(name = "book_list_id") /* 书单名ID */
    @ApiModelProperty(value = "书单名ID")
    private Integer bookListId ;
    @Column(name = "batch_id") /* 批次ID */
    @ApiModelProperty(value = "批次ID")
    private Integer batchId ;
    @Column(name = "copyright_id") /* 版权名称ID */
    @ApiModelProperty(value = "版权名称ID")
    private Integer copyrightId ;
    @Column(name = "is_boot_status") /* 状态：上线 or 未上线 */
    @ApiModelProperty(value = "状态：上线 or 未上线")
    private Integer isBootStatus ;
    @Column(name = "image_url") /* 书封封面图片 */
    @ApiModelProperty(value = "书封封面图片")
    private String imageUrl ;
    @Column(name = "is_audit_status") /* 审核状态0未审核1审核通过2插入公网库 */
    @ApiModelProperty(value = "审核状态0未审核1审核通过2插入公网库")
    private Integer isAuditStatus ;
    @CreatedDate
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss", timezone = "GMT+8")
    @Column(name = "gmt_create",nullable = false,updatable = false) /* 创建时间 */
//    updatable = false //##updatable属性表示在使用“UPDATE”SQL语句插入数据时是否需要更新该字段的值
    @ApiModelProperty(value = "创建时间",example = "2020-12-12 12:12:12")
    private Date gmtCreate ;
    @CreatedDate
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",timezone = "GMT+8")
//    nullable = false //##nullable属性表示该字段是否可以为null值，默认为true
//insertable = false //##insertable属性表示在使用“INSERT”SQL语句插入数据时是否需要插入该字段的值
    @Column(name = "gmt_modified",nullable = false,insertable = false) /* 修改时间 */
    @ApiModelProperty(value = "修改时间",example = "2020-12-12 12:12:12")
    private Date gmtModified ;
}
