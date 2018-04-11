package com.yiban.erp.entities;

import com.yiban.erp.constant.RepertoryInStatus;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepertoryIn {
    private Long id;

    private Integer companyId;

    private Long refOrderId;

    private String refType;

    private String orderNumber;

    private String refNo;

    private Long supplierId;

    private Long supplierContactId;

    private Long buyerId;

    private String status;

    private String keyWord;

    private Date receiveDate;

    private Date payDate;

    private String goodsBillNo;

    private Long tempControlMethod;

    private BigDecimal receiveTemp;

    private BigDecimal checkTemp;

    private Long tempControlStatus;

    private Integer shipCompanyId;

    private Long shipMethod;

    private Long shipTool;

    private String shipCarNo;

    private String shipDriverName;

    private Date shipStartDate;

    private Date shipEndDate;

    private String shipEntrustNo;

    private String shipStartAddress;

    private Integer warehouseId;

    private Long buyType;

    private Integer term;

    private String comeFrom;

    private Long billType;

    private String fileNo;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String supplierName;
    private String supplierContactName;
    private String warehouseName;
    private String saleNickName;
    private String saleRealName;

    private String tempControlMethodName;
    private String tempControlStatusName;
    private String shipMethodName;
    private String shipToolName;
    private String buyTypeName;
    private String billTypeName;

    private List<RepertoryInDetail> details;

    public boolean canUpdateDetail() {
        if (RepertoryInStatus.TEMP_STORAGE.name().equalsIgnoreCase(this.status)
                || RepertoryInStatus.INIT.name().equalsIgnoreCase(this.status)) {
            return true;
        }
        return false;
    }

    public void setOptions(List<Options> optionsList) {
        if (optionsList == null || optionsList.isEmpty()) {
            return;
        }
        Map<Long, Options> optionsMap = new HashMap<>();
        optionsList.stream().forEach(item -> optionsMap.put(item.getId(), item));
        this.tempControlMethodName = optionsMap.get(this.tempControlMethod) != null ? optionsMap.get(this.tempControlMethod).getValue() : null;
        this.tempControlStatusName = optionsMap.get(this.tempControlStatus) != null ? optionsMap.get(this.tempControlStatus).getValue() : null;
        this.shipMethodName = optionsMap.get(this.shipMethod) != null ? optionsMap.get(this.shipMethod).getValue() : null;
        this.shipToolName = optionsMap.get(this.shipToolName) != null ? optionsMap.get(this.shipToolName).getValue() : null;
        this.buyTypeName = optionsMap.get(this.buyType) != null ? optionsMap.get(this.buyType).getValue() : null;
        this.billTypeName = optionsMap.get(this.billType) != null ? optionsMap.get(this.billType).getValue() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Long getRefOrderId() {
        return refOrderId;
    }

    public void setRefOrderId(Long refOrderId) {
        this.refOrderId = refOrderId;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType == null ? null : refType.trim();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo == null ? null : refNo.trim();
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getSupplierContactId() {
        return supplierContactId;
    }

    public void setSupplierContactId(Long supplierContactId) {
        this.supplierContactId = supplierContactId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord == null ? null : keyWord.trim();
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getGoodsBillNo() {
        return goodsBillNo;
    }

    public void setGoodsBillNo(String goodsBillNo) {
        this.goodsBillNo = goodsBillNo == null ? null : goodsBillNo.trim();
    }

    public Long getTempControlMethod() {
        return tempControlMethod;
    }

    public void setTempControlMethod(Long tempControlMethod) {
        this.tempControlMethod = tempControlMethod;
    }

    public BigDecimal getReceiveTemp() {
        return receiveTemp;
    }

    public void setReceiveTemp(BigDecimal receiveTemp) {
        this.receiveTemp = receiveTemp;
    }

    public BigDecimal getCheckTemp() {
        return checkTemp;
    }

    public void setCheckTemp(BigDecimal checkTemp) {
        this.checkTemp = checkTemp;
    }

    public Long getTempControlStatus() {
        return tempControlStatus;
    }

    public void setTempControlStatus(Long tempControlStatus) {
        this.tempControlStatus = tempControlStatus;
    }

    public Integer getShipCompanyId() {
        return shipCompanyId;
    }

    public void setShipCompanyId(Integer shipCompanyId) {
        this.shipCompanyId = shipCompanyId;
    }

    public Long getShipMethod() {
        return shipMethod;
    }

    public void setShipMethod(Long shipMethod) {
        this.shipMethod = shipMethod;
    }

    public Long getShipTool() {
        return shipTool;
    }

    public void setShipTool(Long shipTool) {
        this.shipTool = shipTool;
    }

    public String getShipCarNo() {
        return shipCarNo;
    }

    public void setShipCarNo(String shipCarNo) {
        this.shipCarNo = shipCarNo == null ? null : shipCarNo.trim();
    }

    public String getShipDriverName() {
        return shipDriverName;
    }

    public void setShipDriverName(String shipDriverName) {
        this.shipDriverName = shipDriverName == null ? null : shipDriverName.trim();
    }

    public Date getShipStartDate() {
        return shipStartDate;
    }

    public void setShipStartDate(Date shipStartDate) {
        this.shipStartDate = shipStartDate;
    }

    public Date getShipEndDate() {
        return shipEndDate;
    }

    public void setShipEndDate(Date shipEndDate) {
        this.shipEndDate = shipEndDate;
    }

    public String getShipEntrustNo() {
        return shipEntrustNo;
    }

    public void setShipEntrustNo(String shipEntrustNo) {
        this.shipEntrustNo = shipEntrustNo == null ? null : shipEntrustNo.trim();
    }

    public String getShipStartAddress() {
        return shipStartAddress;
    }

    public void setShipStartAddress(String shipStartAddress) {
        this.shipStartAddress = shipStartAddress == null ? null : shipStartAddress.trim();
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getBuyType() {
        return buyType;
    }

    public void setBuyType(Long buyType) {
        this.buyType = buyType;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom == null ? null : comeFrom.trim();
    }

    public Long getBillType() {
        return billType;
    }

    public void setBillType(Long billType) {
        this.billType = billType;
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo == null ? null : fileNo.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierContactName() {
        return supplierContactName;
    }

    public void setSupplierContactName(String supplierContactName) {
        this.supplierContactName = supplierContactName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getSaleNickName() {
        return saleNickName;
    }

    public void setSaleNickName(String saleNickName) {
        this.saleNickName = saleNickName;
    }

    public String getSaleRealName() {
        return saleRealName;
    }

    public void setSaleRealName(String saleRealName) {
        this.saleRealName = saleRealName;
    }

    public String getTempControlMethodName() {
        return tempControlMethodName;
    }

    public void setTempControlMethodName(String tempControlMethodName) {
        this.tempControlMethodName = tempControlMethodName;
    }

    public String getTempControlStatusName() {
        return tempControlStatusName;
    }

    public void setTempControlStatusName(String tempControlStatusName) {
        this.tempControlStatusName = tempControlStatusName;
    }

    public String getShipMethodName() {
        return shipMethodName;
    }

    public void setShipMethodName(String shipMethodName) {
        this.shipMethodName = shipMethodName;
    }

    public String getShipToolName() {
        return shipToolName;
    }

    public void setShipToolName(String shipToolName) {
        this.shipToolName = shipToolName;
    }

    public String getBuyTypeName() {
        return buyTypeName;
    }

    public void setBuyTypeName(String buyTypeName) {
        this.buyTypeName = buyTypeName;
    }

    public String getBillTypeName() {
        return billTypeName;
    }

    public void setBillTypeName(String billTypeName) {
        this.billTypeName = billTypeName;
    }

    public List<RepertoryInDetail> getDetails() {
        return details;
    }

    public void setDetails(List<RepertoryInDetail> details) {
        this.details = details;
    }
}