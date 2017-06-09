package model.CarModelInquiry;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * <B>说       明</B>:
 *
 * @author 作  者  名：陈芮芃<br/>
 *         E-mail ：ruipeng110@126.com
 * @version 版 本 号：V1.0.<br/>
 *          创建时间：2017/6/8 0008 17:55
 */
public class CarModelReturnData<T> {

    private String proposalFormId;

    private List<T> carModelList;

    public String getProposalFormId() {
        return proposalFormId;
    }

    public void setProposalFormId(String proposalFormId) {
        this.proposalFormId = proposalFormId;
    }

    public List<T> getCarModelList() {
        return carModelList;
    }

    public void setCarModelList(List<T> carModelList) {
        this.carModelList = carModelList;
    }

    public static class CarModel {
        @NotBlank(message = "车型代码不能为空")
        private String modelCode;
        @NotBlank(message = "车型名称不能为空")
        private String modelName;
        private String series;
        private String vehicleDescription;
        private String marketYear;
        private String replacementValue;
        private String ratedPassengerCapacity;
        private String displacement;


        public String getModelCode() {
            return modelCode;
        }

        public void setModelCode(String modelCode) {
            this.modelCode = modelCode;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public String getSeries() {
            return series;
        }

        public void setSeries(String series) {
            this.series = series;
        }

        public String getVehicleDescription() {
            return vehicleDescription;
        }

        public void setVehicleDescription(String vehicleDescription) {
            this.vehicleDescription = vehicleDescription;
        }

        public String getMarketYear() {
            return marketYear;
        }

        public void setMarketYear(String marketYear) {
            this.marketYear = marketYear;
        }

        public String getReplacementValue() {
            return replacementValue;
        }

        public void setReplacementValue(String replacementValue) {
            this.replacementValue = replacementValue;
        }

        public String getRatedPassengerCapacity() {
            return ratedPassengerCapacity;
        }

        public void setRatedPassengerCapacity(String ratedPassengerCapacity) {
            this.ratedPassengerCapacity = ratedPassengerCapacity;
        }

        public String getDisplacement() {
            return displacement;
        }

        public void setDisplacement(String displacement) {
            this.displacement = displacement;
        }
    }

}
