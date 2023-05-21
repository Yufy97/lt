package com.zt.entity.po;

import com.zt.constant.TypeConstant;
import lombok.Data;

@Data
public class ConnectPacket extends Packet{
    private User user;
    @Override
    public Byte getType() {
        return TypeConstant.CONNECT_COMPLETE;
    }
}
