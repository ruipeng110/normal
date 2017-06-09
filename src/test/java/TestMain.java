import com.fasterxml.jackson.databind.JavaType;
import model.CarModelInquiry.CarModelReturnData;
import model.GeneralReqHead;
import model.Resp;
import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by crp on 2017/6/8.
 */
public class TestMain {
    
    public static void main(String[] args) throws Exception{
        Resp<GeneralReqHead, CarModelReturnData<CarModelReturnData.CarModel>> resp = new Resp<>();
        Class<?>[] generics = new Class[]{GeneralReqHead.class, CarModelReturnData.class, CarModelReturnData.CarModel.class};
        JavaType javaType = JsonUtil.getJavaType(Resp.class, new LinkedList<Class<?>>(Arrays.asList(generics)));
        init(resp);
        String s = JsonUtil.toString(resp);
        Resp<GeneralReqHead, CarModelReturnData<CarModelReturnData.CarModel>> resp1 = JsonUtil.objectMapper.readValue(s, javaType);
        String s1 = JsonUtil.toString(resp1);
        Assert.assertTrue(s.equals(s1));
    }

    private static void init(Resp<GeneralReqHead, CarModelReturnData<CarModelReturnData.CarModel>> base){
        GeneralReqHead generalReqHead = new GeneralReqHead();
        generalReqHead.setProposalFormToken("sdwer");
        generalReqHead.setChannelId("sfwere");
        generalReqHead.setVersion("v1");
        base.setHead(generalReqHead);

        base.setMessageBody("sdfwerwerew");
        base.setMessageCode("srwerew");
        CarModelReturnData<CarModelReturnData.CarModel> data = new CarModelReturnData<>();
        base.setBody(data);
        data.setProposalFormId("srewrwerwegdfhtr");
        List<CarModelReturnData.CarModel> list = new LinkedList<>();
        CarModelReturnData.CarModel carModel1 = new CarModelReturnData.CarModel();
        carModel1.setDisplacement("sdrwer");
        CarModelReturnData.CarModel carModel2 = new CarModelReturnData.CarModel();
        carModel2.setModelCode("sdfwe");
        list.add(carModel1);
        list.add(carModel2);
        data.setCarModelList(list);
    }
    
}
