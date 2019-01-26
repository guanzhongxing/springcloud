import cn.com.gzx.SpringCloudEureka;
import cn.com.gzx.entity.*;
import com.alibaba.fastjson.JSON;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOptions;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCloudEureka.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestMongo {

    private Logger logger = LoggerFactory.getLogger(TestMongo.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void insertMongoTest() {
        String applyPolicyNo = "333333";
        ApplyWillDTO applyWillDTO = new ApplyWillDTO();
        ContractDTO contractDTO = new ContractDTO();
        BaseInfoDTO baseInfoDTO = new BaseInfoDTO();
        baseInfoDTO.setApplyPolicyNo(applyPolicyNo);
        contractDTO.setBaseInfoDTO(baseInfoDTO);
        applyWillDTO.setContractDTO(contractDTO);
        applyWillDTO.setApplyPolicyNo(applyPolicyNo);
        applyWillDTO.setCreatedBy("guanzhongxing");
        applyWillDTO.setCreatedDate(new Date());
        applyWillDTO.setDepartmentCode("20103");
        this.mongoTemplate.save(applyWillDTO);
        System.out.println("save success");
    }

    @Test
    public void insertApplyPolicyCardNoRelTest() {
        String applyPolicyNo = "333333";
        ApplyPolicyCardNoRel applyPolicyCardNoRel = new ApplyPolicyCardNoRel();
        applyPolicyCardNoRel.setApplyPolicyNo(applyPolicyNo);
        applyPolicyCardNoRel.setCardNo("123456");
        applyPolicyCardNoRel.setCardType("01");
        applyPolicyCardNoRel.setIsGroup("N");
        applyPolicyCardNoRel.setTelephone("1234567890");
        applyPolicyCardNoRel.setCreatedBy("guanzhongxing");
        applyPolicyCardNoRel.setFarmerName("zhangsan");
        applyPolicyCardNoRel.setStatus("1");
        this.mongoTemplate.save(applyPolicyCardNoRel);
    }

    @Test
    public void pagedQueryTest() {
//        LookupOperation lookupOperation = LookupOperation.newLookup()
//                .from("applyWillDTO")
//                .localField("applyPolicyNo")
//                .foreignField("applyPolicyNo")
//                .as("applyWillList");
//        Criteria criteria = new Criteria();
//        criteria.and("cardNo").is("123456");
//        criteria.and("cardType").is("01");
//        criteria.and("isGroup").is("N");
//        Aggregation aggregation = Aggregation.newAggregation(
//                Aggregation.group("applyPolicyNo").count().as("applyPolicyNo"),
//                Aggregation.match(criteria),
//                lookupOperation,
//                Aggregation.unwind("applyWillList"),
//                Aggregation.project().and("applyWillList").as("applyWillDTO"),
//                Aggregation.match(new Criteria("applyWillDTO.formatType").is("03")),
////                Aggregation.group("applyWillDTO.applyPolicyNo,applyWillDTO.createdDate,applyWillDTO.contractDTO"),
//                Aggregation.sort(Sort.Direction.ASC, new String[]{"applyWillDTO.createdDate"}),
//                Aggregation.skip(0L),
//                Aggregation.limit(10)
//        );
//        System.out.println("query:" + aggregation.toString());
//        List<MgApplyWill> list = this.mongoTemplate.aggregate(aggregation, "applyPolicyCardNoRel", MgApplyWill.class).getMappedResults();
//        System.out.println("list:" + JSON.toJSONString(list));
        System.out.println("------------------------------------------------------------------------------");
        Criteria criteria = new Criteria();
        criteria.and("cardNo").is("123456");
        criteria.and("cardType").is("01");
        criteria.and("isGroup").is("N");
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(criteria),
                Aggregation.group("applyPolicyNo", "cardNo", "cardType", "isGroup")
        );
        List<ApplyPolicyCardNoRel> applyPolicyCardNoRelList = this.mongoTemplate.aggregate(aggregation, "applyPolicyCardNoRel", ApplyPolicyCardNoRel.class).getMappedResults();
        System.out.println("applyPolicyList:" + JSON.toJSONString(applyPolicyCardNoRelList));
        Criteria criteria1 = new Criteria();
        criteria1.and("formatType").is("03");
        List<String> applyPolicyList = applyPolicyCardNoRelList.stream().map(card -> card.getApplyPolicyNo()).collect(Collectors.toList());
        criteria1.and("applyPolicyNo").in(applyPolicyList);
        Aggregation aggregation1 = Aggregation.newAggregation(
                Aggregation.match(criteria1),
                Aggregation.sort(Sort.Direction.ASC, new String[]{"createdDate"}),
                Aggregation.skip(0L),
                Aggregation.limit(10)
        );
        System.out.println("query2:" + aggregation1.toString());
        List<ApplyWillDTO> applyWillDTOList = this.mongoTemplate.aggregate(aggregation1, "applyWillDTO", ApplyWillDTO.class).getMappedResults();
        System.out.println("list:" + JSON.toJSONString(applyWillDTOList));
    }
}

