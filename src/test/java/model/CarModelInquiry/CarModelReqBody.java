package model.CarModelInquiry;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * <B>说       明</B>:
 *
 * @author 作  者  名：陈芮芃<br/>
 *         E-mail ：ruipeng110@126.com
 * @version 版 本 号：V1.0.<br/>
 *          创建时间：2017/6/8 0008 16:45
 */
public class CarModelReqBody {
    @NotNull
    private CarInfo carInfo = new CarInfo();
    private String extendInfos;

    public CarInfo getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(CarInfo carInfo) {
        this.carInfo = carInfo;
    }

    public String getExtendInfos() {
        return extendInfos;
    }

    public void setExtendInfos(String extendInfos) {
        this.extendInfos = extendInfos;
    }

    public static class CarInfo {
        @NotBlank(message = "车牌号不能为空")
        private String licenseNo;
        @NotBlank(message = "发动机号不能为空")
        private String engineNo;
        @NotBlank(message = "车架号不能为空")
        private String frameNo;
        @NotBlank(message = "新旧车标志不能为空")
        private String newVehicle;
        @NotBlank(message = "外地车标志不能为空")
        private String ecdemicVehicle;
        @NotBlank(message = "车辆品牌不能为空")
        private String vehicleBrand;
        @NotBlank(message = "车辆型号不能为空")
        private String vehicleModel;    //行驶证品牌型号“帕萨特AUDI A6L 1.8T AT”外地车非空行驶证品牌型号“帕萨特AUDI A6L 1.8T AT”外地车非空
        @NotBlank(message = "新车购置价不能为空")
        private String vehiclePrice;
        @NotBlank(message = "初登日期不能为空")
        private String enrollDate;
        @NotBlank(message = "过户车辆标识不能为空")
        private String chgOwnerFlag;
        @NotBlank(message = "转移登记日期不能为空")
        private String transferDate;

        public String getLicenseNo() {
            return licenseNo;
        }

        public void setLicenseNo(String licenseNo) {
            this.licenseNo = licenseNo;
        }

        public String getEngineNo() {
            return engineNo;
        }

        public void setEngineNo(String engineNo) {
            this.engineNo = engineNo;
        }

        public String getFrameNo() {
            return frameNo;
        }

        public void setFrameNo(String frameNo) {
            this.frameNo = frameNo;
        }

        public String getNewVehicle() {
            return newVehicle;
        }

        public void setNewVehicle(String newVehicle) {
            this.newVehicle = newVehicle;
        }

        public String getEcdemicVehicle() {
            return ecdemicVehicle;
        }

        public void setEcdemicVehicle(String ecdemicVehicle) {
            this.ecdemicVehicle = ecdemicVehicle;
        }

        public String getVehicleBrand() {
            return vehicleBrand;
        }

        public void setVehicleBrand(String vehicleBrand) {
            this.vehicleBrand = vehicleBrand;
        }

        public String getVehicleModel() {
            return vehicleModel;
        }

        public void setVehicleModel(String vehicleModel) {
            this.vehicleModel = vehicleModel;
        }

        public String getVehiclePrice() {
            return vehiclePrice;
        }

        public void setVehiclePrice(String vehiclePrice) {
            this.vehiclePrice = vehiclePrice;
        }

        public String getEnrollDate() {
            return enrollDate;
        }

        public void setEnrollDate(String enrollDate) {
            this.enrollDate = enrollDate;
        }

        public String getChgOwnerFlag() {
            return chgOwnerFlag;
        }

        public void setChgOwnerFlag(String chgOwnerFlag) {
            this.chgOwnerFlag = chgOwnerFlag;
        }

        public String getTransferDate() {
            return transferDate;
        }

        public void setTransferDate(String transferDate) {
            this.transferDate = transferDate;
        }
    }

}
