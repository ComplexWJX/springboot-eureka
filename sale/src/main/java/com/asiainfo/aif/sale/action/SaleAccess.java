package com.asiainfo.aif.sale.action;

import com.alibaba.fastjson.JSONObject;
import com.asiainfo.aif.sale.rest.PaymentRest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Koala
 * @description
 * @date 2019/12/22 0022
 */
@Slf4j
@RequestMapping(path = "/sale")
@RestController
@Transactional
public class SaleAccess {
    @Autowired
    private PaymentRest paymentRest;
    @RequestMapping(value = "/build",method = {RequestMethod.GET,RequestMethod.POST})
    public  String buildOrder(@RequestParam("serOrderId") String serOrderId) {
        String result="{\n" +
                "\t\"services\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"bindable\": true,\n" +
                "\t\t\t\"metadata\": {\n" +
                "\t\t\t\t\"longDescription\": \"可以支持Memcache,Redis等常见缓存中间件\",\n" +
                "\t\t\t\t\"documentationUrl\": \"http://10.19.14.20:7888/doc\",\n" +
                "\t\t\t\t\"dashboardUrl\": \"http://10.19.14.20:7888/home\",\n" +
                "\t\t\t\t\"instance_unbinding_Url\": \"http://10.19.14.20:7888/\",\n" +
                "\t\t\t\t\"providerDisplayName\": \"AIF\",\n" +
                "\t\t\t\t\"service_instance_createUrl\": \"http://10.19.14.20:7888/\",\n" +
                "\t\t\t\t\"displayName\": \"CSF\",\n" +
                "\t\t\t\t\"imageUrl\": \"http://127.0.0.1/logo.image\",\n" +
                "\t\t\t\t\"instance_binding_Url\": \"http://10.19.14.20:7888/\",\n" +
                "\t\t\t\t\"supportUrl\": \"http://10.19.14.20:7888//support\",\n" +
                "\t\t\t\t\"service_instance_updateUrl\": \"http://10.19.14.20:7888/\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"plans\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"metadata\": {\n" +
                "\t\t\t\t\t\t\"costs\": [\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"amount\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"usd\": 649.0\n" +
                "\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\"unit\": \"MONTHLY\"\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t],\n" +
                "\t\t\t\t\t\t\"role\": 108,\n" +
                "\t\t\t\t\t\t\"displayName\": \"CSF普通实例\",\n" +
                "\t\t\t\t\t\t\"bullets\": [\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 10,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"csf\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"云化服务CSF\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": -1,\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 1,\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"HOME\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": -1,\n" +
                "\t\t\t\t\t\t\t\t\"funcUrl\": \"view/home/home\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"11\",\n" +
                "\t\t\t\t\t\t\t\t\"funcImg\": \"icon-home\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 11,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"csf\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"统计趋势\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": 10,\n" +
                "\t\t\t\t\t\t\t\t\"funcUrl\": \"view/tendency/tendency\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"11\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 12,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"csf\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"实例热力图\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": 10,\n" +
                "\t\t\t\t\t\t\t\t\"funcUrl\": \"view/thermodynamic/thermodynamic\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 15,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"csf\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"实例列表\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": 10,\n" +
                "\t\t\t\t\t\t\t\t\"funcUrl\": \"view/list/list\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"15\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 20,\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"应用风控\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": -1,\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"13\",\n" +
                "\t\t\t\t\t\t\t\t\"funcImg\": \"icon-warning\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 21,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"csf\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"告警管理\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": 20,\n" +
                "\t\t\t\t\t\t\t\t\"funcUrl\": \"view/csi/warn/warn\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"11\",\n" +
                "\t\t\t\t\t\t\t\t\"funcImg\": \"icon-warning\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 22,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"csf\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"事件通知\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": 20,\n" +
                "\t\t\t\t\t\t\t\t\"funcUrl\": \"view/csi/event/event\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"funcImg\": \"icon-notificationspx\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 23,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"csf\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"中间件监控\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": -1,\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 17,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"sidecar\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"云化服务网格\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": -1,\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"16\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 18,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"sidecar\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"统计趋势\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": 17,\n" +
                "\t\t\t\t\t\t\t\t\"funcUrl\": \"view/tendency/tendency\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 26,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"gateway\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"Gateway监控\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": 23,\n" +
                "\t\t\t\t\t\t\t\t\"funcUrl\": \"view/middle/middle\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 24,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"zookeeper\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"Zookeeper监控\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": 23,\n" +
                "\t\t\t\t\t\t\t\t\"funcUrl\": \"view/middle/middle\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 25,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"kafka\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"Kafka监控\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": 23,\n" +
                "\t\t\t\t\t\t\t\t\"funcUrl\": \"view/middle/middle\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 13,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"sidecar\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"实例列表\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": 17,\n" +
                "\t\t\t\t\t\t\t\t\"funcUrl\": \"view/list/list\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 27,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"activemq\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"ActiveMQ监控\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": 23,\n" +
                "\t\t\t\t\t\t\t\t\"funcUrl\": \"view/middle/middle\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 28,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"esb\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"esb监控\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": 23,\n" +
                "\t\t\t\t\t\t\t\t\"funcUrl\": \"view/middle/middle\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 29,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"esb_Sandboxie\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"esb-box监控\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": 23,\n" +
                "\t\t\t\t\t\t\t\t\"funcUrl\": \"view/middle/middle\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 30,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"tomcat_aopoauth\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"oauth监控\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": 23,\n" +
                "\t\t\t\t\t\t\t\t\"funcUrl\": \"view/middle/middle\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"12\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"desc_code\": 19,\n" +
                "\t\t\t\t\t\t\t\t\"funcCode\": \"csf\",\n" +
                "\t\t\t\t\t\t\t\t\"desc_name\": \"告警设置\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_code\": 20,\n" +
                "\t\t\t\t\t\t\t\t\"funcUrl\": \"view/csi/config/config\",\n" +
                "\t\t\t\t\t\t\t\t\"parent_name\": \"13\",\n" +
                "\t\t\t\t\t\t\t\t\"state\": \"U\",\n" +
                "\t\t\t\t\t\t\t\t\"urlType\": \"2\",\n" +
                "\t\t\t\t\t\t\t\t\"createUser\": 2\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t]\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"schemas\": {\n" +
                "\t\t\t\t\t\t\"service_binding\": {\n" +
                "\t\t\t\t\t\t\t\"create\": {\n" +
                "\t\t\t\t\t\t\t\t\"parameters\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"service_id\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"service108\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"bind_resource\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"app_guid\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"app108\"\n" +
                "\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"parameters\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"parent\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"parent108\"\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"tenant_name\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"tenant108\"\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"user_name\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"user108\"\n" +
                "\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"plan_id\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"plan108\"\n" +
                "\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"service_instance\": {\n" +
                "\t\t\t\t\t\t\t\"create\": {\n" +
                "\t\t\t\t\t\t\t\t\"parameters\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"service_id\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"service108\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"parameters\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"parent\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"parent108\"\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"role\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": 108\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"user\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"user108\"\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"tenant\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"tenant108\"\n" +
                "\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"plan_id\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"plan108\"\n" +
                "\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\"update\": {\n" +
                "\t\t\t\t\t\t\t\t\"parameters\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"service_id\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"service108\"\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"parameters\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"parent\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"parent108\"\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"role\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": 108\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"user\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"user108\"\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t\"tenant\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"tenant108\"\n" +
                "\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\"plan_id\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"type\": \"plan108\"\n" +
                "\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"name\": \"租户运维者\",\n" +
                "\t\t\t\t\t\"description\": \"一个普通的租户\",\n" +
                "\t\t\t\t\t\"id\": \"tenant_operator108\",\n" +
                "\t\t\t\t\t\"free\": true\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"name\": \"租户信息订阅\",\n" +
                "\t\t\t\"description\": \"运维监控\",\n" +
                "\t\t\t\"id\": \"tenant_subscribe\",\n" +
                "\t\t\t\"tags\": [\n" +
                "\t\t\t\t\"cache\",\n" +
                "\t\t\t\t\"redis\",\n" +
                "\t\t\t\t\"k8s\"\n" +
                "\t\t\t]\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
        try {
//            result = paymentRest.pay(UUID.randomUUID().toString() + ":" + serOrderId);
//            log.info(result);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("call failed",e);
            result = "build order failed.";
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return JSONObject.parse(result).toString();
    }
}
