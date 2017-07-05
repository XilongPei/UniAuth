package com.dianrong.common.uniauth.server.test.profile;

import com.dianrong.common.uniauth.common.bean.Response;
import com.dianrong.common.uniauth.common.bean.UserIdentityType;
import com.dianrong.common.uniauth.common.bean.request.AttributeExtendParam;
import com.dianrong.common.uniauth.common.bean.request.ProfileParam;
import com.dianrong.common.uniauth.common.server.cxf.CxfHeaderHolder;
import com.dianrong.common.uniauth.common.util.JsonUtil;
import com.dianrong.common.uniauth.server.resource.UserProfileResource;
import com.dianrong.common.uniauth.server.test.BaseTest;
import com.google.common.collect.Maps;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户Profile操作相关接口.
 */
public class UserProfileResourceTest extends BaseTest {

  @Autowired
  private UserProfileResource userProfileResource;

  @Test
  public void testAddOrUpdateUserProfile() {
    CxfHeaderHolder.TENANCYCODE.set("dianrong");
    Long profileId = 4L;
    Long uniauthId = 300000020L;
    ProfileParam param = new ProfileParam();
    Map<String, AttributeExtendParam> attributes = Maps.newHashMap();
    param.setAttributes(attributes);
    attributes.put("name",
        new AttributeExtendParam().setValue("小王").setDescription("姓名").setCode("name"));
    attributes.put("email", new AttributeExtendParam().setValue("123472679@qq.com")
        .setDescription("不能修改").setCode("email"));
    attributes.put("computer",
        new AttributeExtendParam().setValue("联想笔记本").setDescription("笔记本型号").setCode("computer"));
    attributes.put("color", new AttributeExtendParam().setValue("黄色"));
    attributes.put("work", new AttributeExtendParam().setValue("java工程师"));
    attributes.put("sex", new AttributeExtendParam().setValue("男"));
    attributes.put("weight", new AttributeExtendParam().setValue("75"));
    attributes.put("height", new AttributeExtendParam().setValue("175"));
    attributes.put("age", new AttributeExtendParam().setValue("29"));
    attributes.put("cast_wechat_id", new AttributeExtendParam().setValue("cas_id"));
    attributes.put("qq", new AttributeExtendParam().setValue("123456789"));
    attributes.put("eye", new AttributeExtendParam().setValue("5.1"));
    attributes.put("address", new AttributeExtendParam().setValue("四川省"));
    attributes.put("wechat", new AttributeExtendParam().setValue("my_webchat"));
    attributes.put("weibo", new AttributeExtendParam().setValue("xiaowang@webo.com"));

    attributes.put("work_address", new AttributeExtendParam().setValue("高新区软件园"));
    attributes.put("leader", new AttributeExtendParam().setValue("leader_name"));
    attributes.put("work_phone", new AttributeExtendParam().setValue("xxxxxxxxx"));
    attributes.put("workmates", new AttributeExtendParam().setValue("xxx"));
    attributes.put("mother_name", new AttributeExtendParam().setValue("mother_name"));
    attributes.put("father_name", new AttributeExtendParam().setValue("father_name"));
    attributes.put("grandma_name", new AttributeExtendParam().setValue("grandma_name"));
    attributes.put("grandpa_name", new AttributeExtendParam().setValue("grandpa_name"));

    attributes.put("teacher_name", new AttributeExtendParam().setValue("xx老师"));
    attributes.put("deskmate_name", new AttributeExtendParam().setValue("同桌1"));
    attributes.put("class_monitor_name", new AttributeExtendParam().setValue("班长"));
    attributes.put("school", new AttributeExtendParam().setValue("学校"));

    Response<Map<String, Object>> response =
        userProfileResource.addOrUpdateUserProfile(uniauthId, profileId, param);
    System.out.println(JsonUtil.object2Jason(response));
    try {
      System.in.read();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testGetUserProfile() {
    CxfHeaderHolder.TENANCYCODE.set("dianrong");
    Long profileId = 4L;
    Long uniauthId = 300000020L;
    Response<Map<String, Object>> response =
        userProfileResource.getUserProfile(uniauthId, profileId);
    System.out.println(JsonUtil.object2Jason(response));
  }

  @Test
  public void testGetUserProfileByIdentity() {
    CxfHeaderHolder.TENANCYCODE.set("dianrong");
    Long profileId = 3L;
    String identity = "15982871999";
    Response<Map<String, Object>> response =
        userProfileResource.getUserProfileByIdentity(identity, profileId, UserIdentityType.PHONE);
    System.out.println(JsonUtil.object2Jason(response));
  }
}
