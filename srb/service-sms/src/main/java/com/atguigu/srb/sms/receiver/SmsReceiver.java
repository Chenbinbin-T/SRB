package com.atguigu.srb.sms.receiver;

import com.atguigu.srb.base.pojo.dto.SmsDTO;
import com.atguigu.srb.rabbitutil.constant.MQConst;
import com.atguigu.srb.sms.service.SmsService;
import com.atguigu.srb.sms.util.SmsProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Component
@Slf4j
public class SmsReceiver {
    @Resource
    private SmsService smsService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MQConst.QUEUE_SMS_ITEM), // 监听的队列
            exchange = @Exchange(value = MQConst.EXCHANGE_TOPIC_SMS),//交换机
            key = {MQConst.ROUTING_SMS_ITEM} //路由(可以配置多个)
    ))
    public void send(SmsDTO smsDTO) {
        log.info("SmsReceiver消息监听.....");
        HashMap<String, Object> param = new HashMap<>();
        param.put("code", smsDTO.getMessage());
        // 发送短信 （注释掉只会影响验证码的发送，不影响功能测试）
//        smsService.send(smsDTO.getMobile(), SmsProperties.TEMPLATE_CODE, param);
    }
}
