package com.zt.entity.po;

import com.zt.constant.TypeConstant;
import lombok.Data;

@Data
public class MessagePacket extends Packet{

    private Long toUserId;

    private Long fromUserId;

    private String body;

    @Override
    public Byte getType() {
        return TypeConstant.SEND_MESSAGE;
    }
}
