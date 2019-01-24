package cn.com.gzx.entity;

import java.util.List;

public class ContractDTO {

    private BaseInfoDTO baseInfoDTO;

    private List<PayInfoDTO> payInfoDTOList;

    private ExtendInfo extendInfo;

    public BaseInfoDTO getBaseInfoDTO() {
        return baseInfoDTO;
    }

    public void setBaseInfoDTO(BaseInfoDTO baseInfoDTO) {
        this.baseInfoDTO = baseInfoDTO;
    }

    public List<PayInfoDTO> getPayInfoDTOList() {
        return payInfoDTOList;
    }

    public void setPayInfoDTOList(List<PayInfoDTO> payInfoDTOList) {
        this.payInfoDTOList = payInfoDTOList;
    }

    public ExtendInfo getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(ExtendInfo extendInfo) {
        this.extendInfo = extendInfo;
    }
}
